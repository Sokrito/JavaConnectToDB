package sokrito.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReviews {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
					
			// start a transaction
			session.beginTransaction();
			
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("Deleting the course ... ");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			// add cleanup code
			session.close();
			factory.close();
		}
		 

	}

}








