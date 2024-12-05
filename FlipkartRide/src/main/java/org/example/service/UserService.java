package org.example.service;

import org.example.repository.UserRepository;
import org.example.model.User;
import org.example.model.Vehicle;

import java.util.List;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public void addUser(String name, String gender, Integer age) {
        User user = new User(name, gender, age);
        userRepository.addUser(user);
    }

    public void addVehicle(String name, String vehicleName, String vehicleNumber) {
        Vehicle vehicle = new Vehicle(vehicleName, vehicleNumber);
        User fetchedUser = userRepository.getUserByName(name);
        if (fetchedUser != null) {
            List<Vehicle> registeredVehicles = fetchedUser.getVehicles();
            registeredVehicles.add(vehicle);
            fetchedUser.setVehicles(registeredVehicles);
        } else
            System.out.println("User doesn't exist");
        userRepository.updateUser(fetchedUser);
    }

    public void printRideStats() {
        List<User> users = userRepository.getAllUsers();
        for(User user : users) {
            System.out.println(user.getName() + " " + user.getTakenRides() + " taken " + user.getOfferedRides() + " offered");
        }
    }

}
