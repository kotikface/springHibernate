package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserByEmail(String user);
    void update(User user);
    User getUserByCar(Car car);
}
