package cli;

import passenger.HibernatePassengerDaoService;
import passenger.IPassengerDaoService;
import passenger.Passenger;
import ticket.HibernateTicketDaoService;
import ticket.ITicketDaoService;
import ticket.Planet;
import ticket.Ticket;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class AddTicketState extends CliState {

    public AddTicketState(CliFSM fsm) {
        super(fsm);
    }

    @Override
    public void init() {
        try {
            IPassengerDaoService passengerDaoService = new HibernatePassengerDaoService();

            System.out.println("Enter passenger passport:");
            String passport = fsm.getScanner().nextLine();

            Passenger passenger = passengerDaoService.getByPassport(passport);

            if (passenger != null) {
                System.out.println("Passenger " + passenger.getName() + " found. Enter FROM planet:");
            } else {
                System.out.println("Enter passenger name:");

                String passengerName = fsm.getScanner().nextLine();

                passenger = new Passenger();
                passenger.setPassport(passport);
                passenger.setName(passengerName);
                passengerDaoService.create(passenger);

                passenger = passengerDaoService.getByPassport(passport);

                System.out.println("Passenger saved. Enter FROM planet:");
            }

            Planet from = new PlanetChooser(fsm.getScanner()).ask();

            System.out.println(from + " found. Enter TO planet");

            Planet to = new PlanetChooser(fsm.getScanner()).ask();

                ITicketDaoService ticketDaoService = new HibernateTicketDaoService();

                Ticket ticket = new Ticket();
                ticket.setPassengerId(passenger.getId());
                ticket.setFrom(from);
                ticket.setTo(to);
                long ticketId = ticketDaoService.create(ticket);

                System.out.println(to + " found. Ticket ordered, ID: " + ticketId);

                fsm.setState(new IdleState(fsm));
            } catch (SQLException | ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
