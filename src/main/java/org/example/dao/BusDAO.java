package org.example.dao;

import org.example.model.Bus;
import org.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
    private Connection connection;

    public BusDAO(Connection connection) {
        this.connection = connection; // Use the passed connection directly
    }

    public void addBus(Bus bus) {
        String query = "INSERT INTO buses(name, route, capacity) VALUES(?, ?, ?)"; // Fixed table name
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, bus.getName());
            pstmt.setString(2, bus.getRoute());
            pstmt.setInt(3, bus.getCapacity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bus> getAllBuses() throws SQLException {
        List<Bus> buses = new ArrayList<>();
        String query = "SELECT * FROM buses"; // Fixed table name
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setName(rs.getString("name"));
                bus.setRoute(rs.getString("route"));
                bus.setCapacity(rs.getInt("capacity"));
                buses.add(bus);
            }
        }
        return buses;
    }

    public Bus getBusById(int id) {
        Bus bus = null;
        String query = "SELECT * FROM buses WHERE id = ?"; // Fixed table name
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    bus = new Bus();
                    bus.setId(rs.getInt("id"));
                    bus.setName(rs.getString("name"));
                    bus.setRoute(rs.getString("route"));
                    bus.setCapacity(rs.getInt("capacity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bus;
    }

    public void updateBus(Bus bus) {
        String query = "UPDATE buses SET name = ?, route = ?, capacity = ? WHERE id = ?"; // Fixed table name
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, bus.getName());
            pstmt.setString(2, bus.getRoute());
            pstmt.setInt(3, bus.getCapacity());
            pstmt.setInt(4, bus.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBus(int id) {
        String query = "DELETE FROM buses WHERE id = ?"; // Fixed table name
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
