package sokrito.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeteleInstructorDetailOnly {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			
			// get the instructor detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			// consoleRead
			System.out.println("tempInstructorDetails: " + tempInstructorDetail);
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}
		 

	}

}








