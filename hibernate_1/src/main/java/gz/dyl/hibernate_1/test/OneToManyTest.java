package gz.dyl.hibernate_1.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Dept;
import gz.dyl.hibernate_1.entity.Emp;

/**
 * @author DengYL
 * @version 2016年9月16日 下午12:40:14
 */
public class OneToManyTest {
	
	@Test
	public void testSaveWithInverseFalseInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setName("秘书部");
		
		Emp emp1 = new Emp();
		emp1.setName("Rose");
		Emp emp2 = new Emp();
		emp2.setName("Lily");
		
		Set<Emp> emps = new HashSet<Emp>();
		emps.add(emp1);
		emps.add(emp2);
		dept.setEmps(emps);
		
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	//由于是一的一方维护关联关系，因此删除主表中的数据时，会先清空从表中的外键引用
	@Test
	public void testDeleteWithInverseFalseInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e5573295cd01573295ce310000");
		
		session.delete(dept);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testSaveWithInverseTrueInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setName("秘书部");
		
		Emp emp1 = new Emp();
		emp1.setName("Lily");
		Emp emp2 = new Emp();
		emp2.setName("Rose");
		
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	//由于是多的一方维护关联关系，因此删除主表中的数据时，无法清空从表中的外键引用，删除会报错
	//所以删除主表中的数据前应手动清空从表中的外键引用
	@Test
	public void testDeleteWithInverseTrueInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e5573297b801573297b9f30000");
		
		if(dept != null && dept.getEmps() != null){
			for(Emp emp : dept.getEmps()){
				emp.setDept(null);
			}
		}
		
		session.delete(dept);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	@Test
	public void testSaveWithInverseFalseCascadeAllInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setName("秘书部");
		
		Emp emp1 = new Emp();
		emp1.setName("Rose");
		Emp emp2 = new Emp();
		emp2.setName("Lily");
		
		Set<Emp> emps = new HashSet<Emp>();
		emps.add(emp1);
		emps.add(emp2);
		dept.setEmps(emps);
		
		session.save(dept);
		//session.save(emp1);
		//session.save(emp2);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	//先清空外键引用再删除所有关联的数据
	@Test
	public void testDeleteWithInverseFalseCascadeAllInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e557329a750157329a766e0000");
		
		session.delete(dept);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testSaveWithInverseTrueCascadeAllInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setName("秘书部");
		
		Emp emp1 = new Emp();
		emp1.setName("Lily");
		Emp emp2 = new Emp();
		emp2.setName("Rose");
		
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	//先删除从表中引用为外键的所有数据，再删除主表中的数据
	@Test
	public void testDeleteWithInverseTrueCascadeAllInDept(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e557329e920157329e940a0000");
		
		/*if(dept != null && dept.getEmps() != null){
			for(Emp emp : dept.getEmps()){
				emp.setDept(null);
			}
		}*/
		
		session.delete(dept);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	@Test
	public void testSaveWithInverseFalseInDeptCascadeAllInEmp(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setName("秘书部");
		
		Emp emp1 = new Emp();
		emp1.setName("Rose");
		Emp emp2 = new Emp();
		emp2.setName("Lily");
		
		Set<Emp> emps = new HashSet<Emp>();
		emps.add(emp1);
		emps.add(emp2);
		dept.setEmps(emps);
		
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	@Test
	public void testDeleteWithInverseFalseInDeptCascadeAllInEmp(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e55732a22c015732a22d980000");
		
		session.delete(dept);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testSaveWithInverseTrueInDeptCascadeAllInEmp(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setName("秘书部");
		
		Emp emp1 = new Emp();
		emp1.setName("Lily");
		Emp emp2 = new Emp();
		emp2.setName("Rose");
		
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		//session.save(dept);
		session.save(emp1);
		session.save(emp2);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	@Test
	public void testDeleteWithInverseTrueInDeptCascadeAllInEmp(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, "402880e55732a4da015732a4dbc00001");
		
		if(dept != null && dept.getEmps() != null){
			for(Emp emp : dept.getEmps()){
				emp.setDept(null);
			}
		}
		
		session.delete(dept);
		
		transaction.commit();
		session.close();
		sf.close();		
	}
	
	//无法删除，因为配置了级联删除，在删除Emp之后会删除Dept，但Dept在Emp中存在外键引用
	@Test
	public void testDeleteEmpWithInverseTrueInDeptCascadeAllInEmp(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Emp emp = (Emp) session.get(Emp.class, "402880e55732ab72015732ab73530002");
		
		session.delete(emp);
		
		transaction.commit();
		session.close();
		sf.close();			
	}

}
