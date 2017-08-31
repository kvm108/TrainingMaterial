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
import com.hibernate.one_many.Answer;
import com.hibernate.one_many.Question;
import com.hibernate.one_to_one.Address;
import com.hibernate.one_to_one.Customer;


//TODO: deleting course deletes student.
public class ManyToMany {
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

		Set<Student> stu = new HashSet<Student>();
		stu.add(s);
		stu.add(s2);

		c[0].setStudents(stu);
		c[1].setStudents(stu);

		session.persist(c[0]);

		tx.commit();
		session.close();

		getAll(sf);

		//Update

		session = sf.openSession();
		tx = session.beginTransaction();

		Course update = session.load(Course.class, 1L);
		Set<Student> getAnswer = update.getStudents();
		System.out.println("Get answers "+getAnswer);
		Set<Student> students = new HashSet<Student>();
		students.add(new Student("One more!"));
		students.addAll(stu);
		students.remove(1);
		update.setStudents(students);
		session.merge(update);
		tx.commit();

		getAll(sf);

		session.close();
		System.out.println("After Updated");
		
		//Delete

		session = sf.openSession();
		tx = session.beginTransaction();

		Course del = session.get(Course.class, 1L);
		Set<Student> getAnswerDel = del.getStudents();
		System.out.println("Get answers del"+getAnswerDel);
		session.delete(del);
		tx.commit();

		getAll(sf);

		session.close();
		System.out.println("After Del");
		
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
		//		Query sql3 = session.createQuery("from STUDENT_COURSE");
		//		List rows3 = sql3.list();
		//		System.out.println("Student " + rows3);

	}
}
