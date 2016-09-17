package gz.dyl.hibernate_1.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Dept;
import gz.dyl.hibernate_1.entity.Emp;

/**
 * @author DengYL
 * @version 2016年9月17日 下午12:13:24
 */
public class LazyAndFetchToSetTest {
	
	@Test
	public void testLazyTrueFetchSelectToSet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e557365ef90157365efb200000");
		
		System.out.println(dept.getEmps().size());
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyFalseFetchSelectToSet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e557365ef90157365efb200000");
		
		System.out.println(dept.getEmps().size());
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyTrueFetchJoinToSet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e557365ef90157365efb200000");
		
		System.out.println(dept.getEmps().size());
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyFalseFetchJoinToSet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e557365ef90157365efb200000");
		
		System.out.println(dept.getEmps().size());
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyTrueFetchSubselectToSet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Dept> depts = session.createQuery("from Dept").list();
		
		for(Dept dept : depts){
			for(Emp emp : dept.getEmps()){
				System.out.println(emp.getName());
			}
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyFalseFetchSubselectToSet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Dept> depts = session.createQuery("from Dept").list();
		
		for(Dept dept : depts){
			for(Emp emp : dept.getEmps()){
				System.out.println(emp.getName());
			}
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testBatchSizeToSet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Dept> depts = session.createQuery("from Dept").list();
		
		for(Dept dept : depts){
			for(Emp emp : dept.getEmps()){
				System.out.println(emp.getName());
			}
		}
		
		transaction.commit();
		session.close();
		sf.close();			
	}

}
