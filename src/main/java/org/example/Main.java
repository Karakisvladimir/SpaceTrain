package org.example;

import passenger.Passenger;
import passenger.PassengerDao;
import storage.ConnectionProvider;
import storage.DatabaseinitService;

import java.sql.SQLException;




import cli.CliFSM;
import storage.ConnectionProvider;
import storage.DatabaseinitService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

//        //Init DB using flyway
//        new DatabaseinitService().initDb();
//
//        ConnectionProvider connectionProvider = new ConnectionProvider();
//
//        PassengerDao passengerDaoService =new PassengerDao(connectionProvider.createConnection());
//        Passenger passenger = new Passenger();
//        passenger.setPassport("AB1234567");
//        passenger.setName("John Smith");
//        passengerDaoService.create(passenger);
//        new CliFSM(connectionProvider);
//
//        connectionProvider.close();
//    }
//}

//Init DB using flyway
        new DatabaseinitService().initDb();

                ConnectionProvider connectionProvider = new ConnectionProvider();

                PassengerDao passengerDaoService =new PassengerDao(connectionProvider.createConnection());
                Passenger passenger = new Passenger();
                passenger.setPassport("AB1234567");
                passenger.setName("John Smith");
                passengerDaoService.create(passenger);
                new CliFSM(connectionProvider);

                connectionProvider.close();
                }
                }



