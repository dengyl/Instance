package gz.dyl.hibernate_1.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Dept;
import gz.dyl.hibernate_1.entity.Emp;

/**
 * @author DengYL
 * @version 2016年9月17日 下午4:30:26
 */
public class HQLTest {
	
	//查询所有，查询出的数据封装在对象中
	@Test
	public void testQuery1(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Query query = session.createQuery("from Dept");
		//Query query = session.createQuery("from Dept d");
		Query query = session.createQuery("select d from Dept d");
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//查询某些属性，查询出的数据保存到数组中
	@Test
	public void testQuery2(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select d.name from Dept d");
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//查询某些属性，查询出的数据保存到数组中
	@Test
	public void testQuery3(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select d.id, d.name from Dept d");
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		for(Object[] objs : list){
			System.out.println(Arrays.toString(objs));
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//查询某些属性，并将查询出的数据封装到对象中
	@Test
	public void testQuery4(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select new Dept(d.id, d.name) from Dept d");
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//排序
	@Test
	public void testQuery5(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dept d order by d.name asc");
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//分页
	@Test
	public void testQuery6(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dept d order by d.name asc");
		query.setFirstResult(1).setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//绑定参数1
	@Test
	public void testQuery7(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dept d where d.id = ?");
		query.setString(0, "402880e557365ef90157365efb200000");
		Dept dept = (Dept) query.uniqueResult();
		System.out.println(dept);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//绑定参数2
	@Test
	public void testQuery8(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dept d where d.id = :heihei");
		query.setString("heihei", "402880e557365ef90157365efb200000");
		Dept dept = (Dept) query.uniqueResult();
		System.out.println(dept);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//分组
	@Test
	public void testQuery9(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select e.name, count(*) from Emp e group by e.name having count(*) > 1");
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		for(Object[] objs : list){
			System.out.println(Arrays.toString(objs));
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//迫切内连接
	@Test
	public void testQuery10(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dept d inner join fetch d.emps");
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		for(Dept dept : list){
			System.out.println(dept);
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//迫切左外连接
	@Test
	public void testQuery11(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dept d left join fetch d.emps");
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		for(Dept dept : list){
			System.out.println(dept);
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//迫切右外连接
	@Test
	public void testQuery12(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dept d right join fetch d.emps");
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		for(Dept dept : list){
			System.out.println(dept);
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//命名查询（局部）
	@Test
	public void testQuery13(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("gz.dyl.hibernate_1.entity.Dept.abc");
		@SuppressWarnings("unchecked")
		List<Dept> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//命名查询（全局）
	@Test
	public void testQuery14(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("def");
		@SuppressWarnings("unchecked")
		List<Emp> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
}
