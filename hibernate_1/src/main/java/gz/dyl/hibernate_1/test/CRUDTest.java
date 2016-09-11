package gz.dyl.hibernate_1.test;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Student;

/**
 * @author DengYL
 * @version 2016年9月11日 下午3:51:04
 */
public class CRUDTest {
	
	@Test
	public void testSave(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setName("Mike");
		student.setAge(19);
		session.save(student);
		
		transaction.commit();
		session.close();
		sf.close();
	}
	
	@Test
	public void testUpdate(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setId("402880e7571841f701571841f8620000");
		student.setName("Rose");
		student.setAge(15);
		session.update(student);
		
		transaction.commit();
		session.close();
		sf.close();
	}
	
	@Test
	public void testDelete(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setId("402880e7571841f701571841f8620000");
		session.delete(student);
		
		transaction.commit();
		session.close();
		sf.close();
	}
	
	//====================查询
	
	@Test
	public void testGet(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Student student = (Student) session.get(Student.class, "402880e75718466d015718466e5c0000");
		
		session.close();
		sf.close();
		System.out.println(student);
	}
	
	@Test
	public void testLoad(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Student student = (Student) session.load(Student.class, "402880e75718466d015718466e5c0000");
		
		session.close();
		sf.close();		
		System.out.println(student);
	}
	
	@Test
	public void testQuery(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();	
		
		/*Query query = session.createQuery("from Student");
		@SuppressWarnings("unchecked")
		List<Student> list = query.list();
		System.out.println(list);*/
		
		Query query = session.createQuery("from Student where id = ?");
		query.setParameter(0, "402880e75718466d015718466e5c0000");
		Student student = (Student) query.uniqueResult();
		System.out.println(student);
		
		session.close();
		sf.close();	
	}
	
	@Test
	public void testSQLQuery(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();	
		
		/*SQLQuery sqlQuery = session.createSQLQuery("select * from student");
		sqlQuery.addEntity(Student.class);
		@SuppressWarnings("unchecked")
		List<Student> list = sqlQuery.list();
		System.out.println(list);*/
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from student where id = ?");
		sqlQuery.addEntity(Student.class);
		sqlQuery.setParameter(0, "402880e75718466d015718466e5c0000");
		Student student = (Student) sqlQuery.uniqueResult();
		System.out.println(student);
		
		session.close();
		sf.close();			
	}
	
	@Test
	public void testCriteria(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();	
		
		/*Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.like("name", "%k%"));
		@SuppressWarnings("unchecked")
		List<Student> list = criteria.list();
		System.out.println(list);*/
		
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", "402880e75718466d015718466e5c0000"));
		Student student = (Student) criteria.uniqueResult();
		System.out.println(student);
		
		session.close();
		sf.close();		
	}

}
