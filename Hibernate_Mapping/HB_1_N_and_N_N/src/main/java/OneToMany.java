import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.one_many.Answer;
import com.hibernate.one_many.Question;
import com.hibernate.one_to_one.Address;
import com.hibernate.one_to_one.Customer;

public class OneToMany {
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
		Question ques = new Question("Why do we exist?");


		Answer answer = new Answer("1. Big Bang",ques);
		Answer answer2 = new Answer("2. Just like that",ques);

		Set<Answer> ansSet = new HashSet<Answer>();
		ansSet.add(answer2);
		ansSet.add(answer);

		ques.setAnswers(ansSet);

		session.persist(ques);
		tx.commit();

		getAll(sf);

		session.close();

		//Update

		session = sf.openSession();
		tx = session.beginTransaction();

		Question update = session.load(Question.class, 1L);
		Set<Answer> getAnswer = update.getAnswers();
		System.out.println("Get answers "+getAnswer);
		update.setQusDesc("Nice description here.");
		session.update(update);
		tx.commit();

		getAll(sf);

		session.close();
		System.out.println("After Updated");

		//Delete

		session = sf.openSession();
		tx = session.beginTransaction();

		Question del = session.load(Question.class, 1L);
		Set<Answer> getAnswerToDelete = del.getAnswers();
		System.out.println("Get answers to delete "+getAnswerToDelete);

		session.delete(del);
		tx.commit();
		
		getAll(sf);
		
		session.close();
		System.out.println("After Deleted");


	}

	// Read
	private static void getAll(SessionFactory sf) {
		Session session = sf.openSession();
		Query sql = session.createQuery("from Answer");
		List rows = sql.list();
		System.out.println("Answer " + rows);
		Query sql2 = session.createQuery("from Question");
		List rows2 = sql2.list();
		System.out.println("Question " + rows2);
	}
}
