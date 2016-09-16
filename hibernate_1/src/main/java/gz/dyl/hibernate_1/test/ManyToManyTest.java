package gz.dyl.hibernate_1.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import gz.dyl.hibernate_1.entity.Commodity;
import gz.dyl.hibernate_1.entity.Order;

/**
 * @author DengYL
 * @version 2016年9月16日 下午8:55:55
 */
public class ManyToManyTest {
	
	@Test
	public void testSave(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Order order1 = new Order();
		order1.setName("订单1");
		Order order2 = new Order();
		order2.setName("订单2");
		
		Commodity commodity1 = new Commodity();
		commodity1.setName("商品1");
		Commodity commodity2 = new Commodity();
		commodity2.setName("商品2");
		
		Set<Commodity> commodities = new HashSet<Commodity>();
		commodities.add(commodity1);
		commodities.add(commodity2);
		
		order1.setCommodities(commodities);
		order2.setCommodities(commodities);
		
		session.save(order1);
		session.save(order2);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testDeleteOrder(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Order order = (Order) session.get(Order.class, "402880e557334c400157334c41b90003");
		
		Iterator<Commodity> it = order.getCommodities().iterator();
		while(it.hasNext()){
			it.next();
			it.remove();
		}
		
		session.delete(order);
		
		transaction.commit();
		session.close();
		sf.close();			
	}
	
	@Test
	public void testDeleteCommodity(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Commodity commodity = (Commodity) session.get(Commodity.class, "402880e557334c400157334c41b90002");
		
		Iterator<Order> it = commodity.getOrders().iterator();
		while(it.hasNext()){
			it.next();
			it.remove();
		}
		
		session.delete(commodity);
		
		transaction.commit();
		session.close();
		sf.close();			
	}

}
