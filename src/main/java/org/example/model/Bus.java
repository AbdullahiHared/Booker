package org.example.model;

public class Bus {
    private int id;
    private String name;
    private String route;
    private int capacity;

    // Constructor
    public Bus(int id, String name, String route, int capacity) {
        this.id = id;
        this.name = name;
        this.route = route;
        this.capacity = capacity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // toString method
    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", route='" + route + '\'' +
                ", capacity=" + capacity +
                '}';
    }


}
