package org.example.test;

import org.example.dao.BusDAO;
import org.example.model.Bus;
import org.example.database.DatabaseConnection;
import org.example.database.SchemaInitializer;
import java.sql.Connection;

import java.util.List;

public class BusDAOTest {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Initialize the schema
            SchemaInitializer.initializeSchema(connection);

            // Create BusDAO instance
            BusDAO busDAO = new BusDAO(connection);

            // Test: Add a bus
            Bus bus = new Bus();
            bus.setName("City Express");
            bus.setRoute("Downtown to Uptown");
            bus.setCapacity(45);
            busDAO.addBus(bus);

            // Test: Retrieve a bus by id
            Bus busById = busDAO.getBusById(1);
            System.out.println("Bus by ID:");
            System.out.println(busById.getId() + ": " + busById.getName() + " - " + busById.getRoute());


            // update bus
            Bus bus1 = new Bus();
            bus1.setId(1);
            bus1.setName("City Express");
            bus1.setRoute("Downtown to Uptown");

            busDAO.updateBus(bus1);
            System.out.println("Update Bus by ID:");
            System.out.println(busById.getId() + ": " + busById.getName() + " - " + busById.getRoute());

            // delete bus
            busDAO.deleteBus(1);
            System.out.println("Delete Bus by ID:");
            System.out.println(busById.getId() + ": " + busById.getName() + " - " + busById.getRoute());

            // add bus
            Bus bus2 = new Bus();
            bus2.setName("City Express");
            bus2.setRoute("Downtown to Uptown");
            bus2.setCapacity(45);
            busDAO.addBus(bus2);
            System.out.println("Add Bus by ID:");
            System.out.println(busById.getId() + ": " + busById.getName() + " - " + busById.getRoute());



            // Test: Retrieve all buses
            System.out.println("All Buses:");
            for (Bus b : busDAO.getAllBuses()) {
                System.out.println(b.getId() + ": " + b.getName() + " - " + b.getRoute());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
