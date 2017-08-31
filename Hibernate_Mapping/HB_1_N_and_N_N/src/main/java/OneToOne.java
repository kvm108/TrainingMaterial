import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.infinispan.xsite.BackupSenderImpl.CustomBackupPolicyInvoker;

import com.hibernate.one_to_one.Address;
import com.hibernate.one_to_one.Customer;

public class OneToOne {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");

		SessionFactory sf = conf.buildSessionFactory();
		insertEmp(sf);
		sf.close();
	}

	private static void insertEmp(SessionFactory sf) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//Create
		Address a = new Address(123, "Street 1", "City 1");
		Customer c = new Customer(1, "User 1", a);
		session.persist(c);
		
		tx.commit();
		session.close();
		
		getAll(sf);
		
		//Update
		
		session = sf.openSession();
		tx = session.beginTransaction();
		Customer update = session.load(Customer.class, 1L);
		long id = update.getCusId();
		System.out.println("Get Id : "+id);
		update.getCusAddress().setCity("Mumbai");
		session.update(update);
		tx.commit();
		
		getAll(sf);
		
		session.close();
		System.out.println("After Updated");
		
		//Delete
		
		session = sf.openSession();
		tx = session.beginTransaction();
		Customer del = session.load(Customer.class, 1L);
		id = update.getCusId();
		System.out.println("Get Id : "+id);
		session.delete(update);
		tx.commit();
		
		getAll(sf);
		
		session.close();
		System.out.println("After Deleted");
		

	}
	
	//Read
	private static void getAll(SessionFactory sf) {
		Session session = sf.openSession();
		Query sql = session.createQuery("from Customer");
		List rows = sql.list();
		System.out.println("Customer " + rows);
		Query sql2 = session.createQuery("from Address");
		List rows2 = sql2.list();
		System.out.println("Address " + rows2);
	}
}