import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.many_many.Course;
import com.hibernate.many_many.Student;

public class QueryInManyToMany {
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
		Course c[] = new Course[3];
		c[0] = new Course("ML");
		c[1] = new Course("BIG data");
		c[2] = new Course("Block Chain");

		session.persist(c[0]);
		session.persist(c[1]);

		Student s = new Student("One");
		Student s2 = new Student("Two");

		//No associated courses
		Student s3 = new Student("Three");
		Student s4 = new Student("Four");

		Set<Student> stu = new HashSet<Student>();
		stu.add(s);
		stu.add(s2);

		c[0].setStudents(stu);
		c[1].setStudents(stu);

		session.persist(c[0]);
		session.persist(s3);
		session.persist(s4);


		tx.commit();
		session.close();

		getAll(sf);

	}

	// Read
	private static void getAll(SessionFactory sf) {
		Session session = sf.openSession();
		Query sql = session.createQuery("from Course");
		List rows = sql.list();
		System.out.println("Course " + rows);
		Query sql2 = session.createQuery("from Student");
		List rows2 = sql2.list();
		System.out.println("Student " + rows2);
		Query sql3 = session.createQuery("from Course C inner join Student S");
		List rows3 = sql3.list();
		System.out.println("QUERY! " + rows3);

	}
}
