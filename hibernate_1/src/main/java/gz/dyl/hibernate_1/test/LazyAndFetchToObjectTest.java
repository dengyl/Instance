package gz.dyl.hibernate_1.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Emp;

/**
 * @author DengYL
 * @version 2016年9月17日 下午12:43:24
 */
public class LazyAndFetchToObjectTest {
	
	@Test
	public void testLazyFalseFetchSelectToObject(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Emp emp = (Emp) session.get(Emp.class, "402880e557365ef90157365efb2b0002");
		
		System.out.println(emp.getDept());
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyProxyFetchSelectToObject(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Emp emp = (Emp) session.get(Emp.class, "402880e557365ef90157365efb2b0002");
		
		System.out.println(emp.getDept());
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyFalseFetchJoinToObject(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Emp emp = (Emp) session.get(Emp.class, "402880e557365ef90157365efb2b0002");
		
		System.out.println(emp.getDept());
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testLazyProxyFetchJoinToObject(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Emp emp = (Emp) session.get(Emp.class, "402880e557365ef90157365efb2b0002");
		
		System.out.println(emp.getDept());
		
		transaction.commit();
		session.close();
		sf.close();			
	}

}
