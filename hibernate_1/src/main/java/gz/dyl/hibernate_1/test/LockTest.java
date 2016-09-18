package gz.dyl.hibernate_1.test;

import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Dept;
import gz.dyl.hibernate_1.entity.Student;

/**
 * @author DengYL
 * @version 2016年9月18日 下午10:12:57
 */
public class LockTest {

	//悲观锁，写锁
	@Test
	public void testLock1(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "a01", LockOptions.UPGRADE);
		
		System.out.println(dept);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	//Hibernate中的乐观锁
	@Test
	public void testLock2(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = (Student) session.get(Student.class, "402880e5573db35301573db3550e0000");
		student.setName("Jack");
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
}
