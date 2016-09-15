package gz.dyl.hibernate_1.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Student;

/**
 * 一级缓存是session范围内的
 * @author DengYL
 * @version 2016年9月15日 上午9:55:51
 */
public class OneLevelCacheTest {
	
	//get方法会先查缓存，若缓存没有查询到才发送sql语句查询数据库，并将查询到的数据放入缓存中
	@Test
	public void testGetCache(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student1 = (Student) session.get(Student.class, "402880e75718466d015718466e5c0000");
		
		Student student2 = (Student) session.get(Student.class, "402880e75718466d015718466e5c0000");
		
		System.out.println(student1 == student2);
		
		transaction.commit();
		session.close();
		sf.close();
	}
	
	//list方法不会从缓存中取数据，而是发送sql语句查询数据库，但会将查询到的结果放入缓存中
	@Test
	public void testListCache(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Student> list1 = session.createQuery("from Student").list();
		System.out.println(list1);
		
		@SuppressWarnings("unchecked")
		List<Student> list2 = session.createQuery("from Student").list();
		System.out.println(list2);
		
		Student student = (Student) session.get(Student.class, "402880e75718466d015718466e5c0000");
		System.out.println(student);
		
		transaction.commit();
		session.close();
		sf.close();
	}
	
	/*
	 * 对于saveOrUpdate():
	 * 	前提条件-->指定的主键生成策略不是手动插入，如native、uuid
	 * 		若不设置id，则插入；若设置id，则修改。
	 *  前提条件-->指定的主键生成策略是手动插入，如assigned
	 * 		若不设置id会报错。若设置了id，会先根据id查询，查询不到数据则插入，查询到数据则修改。
	 */
	@Test
	public void testSaveOrUpdate(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setId("a01");
		student.setName("update with assigned");
		student.setAge(16);
		
		session.saveOrUpdate(student);
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
