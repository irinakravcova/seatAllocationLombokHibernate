import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import plane.*;

@Getter
@Setter

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Seat.class)//connect - import/register the Seat and Passenger classes
                .addAnnotatedClass(Passenger.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();//direct conn with DB
        Transaction transaction = session.beginTransaction();//every change made to a DB

        //to find a user/person etc
      /*  Seat showAvailableSeats = session.find(Seat.class, SeatStatus.AVAILABLE);
        System.out.println("Available seats are:  " + SeatStatus.AVAILABLE); */

        Passenger passenger = new Passenger();
        passenger.setName("George");
        passenger.setSeatNumber("ECO_2A");
        session.persist(passenger);//will save the information to db. Persist unless we dont need to use save
        System.out.println(passenger);


   /*    // how to find a person
        Long passengerId = 14L;
        Passenger foundPassenger = session.find(Passenger.class, passengerId);
        System.out.println("Found passenger: " + foundPassenger); */

        Seat seat = new Seat();//assign a seat to this passenger
        seat.setPassenger(new Passenger());
        seat.setSeatStatus(SeatStatus.UNAVAILABLE);

        session.save(seat);
        System.out.println(seat);

/*how to find a seat?
        Seat foundSeat = session.find(Seat.class, 13L);
        System.out.println("Found from DB: " + foundSeat);;*/

        session.save(seat); //provides id(?) unlike session.persist
        System.out.println("Saved seat for passenger: " + passenger.getName() + ", seat number: " + passenger.getSeatNumber());

        //  Seat foundSeat = session.find(Seat.class, seat.getSeatNumber());

        //  System.out.println("Found from db: " + foundSeat);
        // push all update to db
        transaction.commit();//it will come to reflect in the DB. Rollback - if we don't need to reflect the last
    }
}

