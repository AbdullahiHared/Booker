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
