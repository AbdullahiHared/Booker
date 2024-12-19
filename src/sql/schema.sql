-- Create Users Table
CREATE TABLE Users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       phone VARCHAR(15)
);

-- Create Buses Table
CREATE TABLE Buses (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       bus_number VARCHAR(50) UNIQUE NOT NULL,
                       route VARCHAR(200) NOT NULL,
                       departure_time TIMESTAMP NOT NULL,
                       available_seats INT NOT NULL
);

-- Create Bookings Table
CREATE TABLE Bookings (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          user_id INT NOT NULL,
                          bus_id INT NOT NULL,
                          booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          status VARCHAR(50) DEFAULT 'Booked',
                          FOREIGN KEY (user_id) REFERENCES Users(id),
                          FOREIGN KEY (bus_id) REFERENCES Buses(id)
);
