package storage.hibernate;


import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import passenger.Passenger;
import storage.DatabaseinitService;
import tests.Person;
import ticket.Ticket;

import java.util.Arrays;
import java.util.List;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;
    static {
        INSTANCE = new HibernateUtil();
    }
    @Getter
    private SessionFactory sessionFactory;



    public HibernateUtil() {

        sessionFactory = new Configuration()
                .addAnnotatedClass(Passenger.class)
                .addAnnotatedClass(Ticket.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
    }

   public static HibernateUtil getInstance(){
        return INSTANCE;
   }
   public void close(){
        sessionFactory.close();
   }

    public static void main(String[] args) {
        //Init DB using flyway
        new DatabaseinitService().initDb();

        HibernateUtil util = HibernateUtil.getInstance();

                 //Get single passenger
//        Session session = util.getSessionFactory().openSession();
//        Passenger passenger = session.get(Passenger.class, 3);
//        System.out.println("passenger = " + passenger);
//        session.close();
                    //Get AllPassengers
//        Session session = util.getSessionFactory().openSession();
//        List<Passenger> passengers = session.createQuery("from  Passenger", Passenger.class).list();
//        System.out.println("passengers = " + passengers);
//        session.close();

                      //Save new passenger
//        Session session1 = util.getSessionFactory().openSession();
//        Transaction transaction = session1.beginTransaction();
//        Passenger newPassenger = new Passenger();
//        newPassenger.setName("Vasia");
//        newPassenger.setPassport("22211");
//        session1.persist(newPassenger);
//        System.out.println("newPassenger = " + newPassenger);
//
//        transaction.commit();
//        session1.close();

                    //"Modified passenger name"
//        Session session = util.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        Passenger existing = session.get(Passenger.class, 3l);
//        existing.setName("Modified passenger name");
//        session.persist(existing);
//        transaction.commit();
//        session.close();

        //List all tickets
//        Session session = util.getSessionFactory().openSession();
//        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
//        System.out.println("tickets = " + tickets);
//        session.close();

//        Session session = util.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        Person p = new Person();
//        p.setAddressList(Arrays.asList("addressA", "addressB"));
//        session.persist(p);
//        transaction.commit();
//        session.close();



        Session session = util.getSessionFactory().openSession();
        List<Person> persons = session.createQuery("from Person", Person.class).list();
        System.out.println("persons = " + persons);
        session.close();
    }
}