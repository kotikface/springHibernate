package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getUserByEmail(String user) {
      List<User> users = userDao.listUsers();
      for (User u:users) {
         if (u.getEmail().equals(user)){
            return u;
         }
      }
      return new User();
   }
   @Transactional
   @Override
   public void update(User user) {
      userDao.update(user);
   }
   @Transactional
   @Override
   public User getUserByCar(Car car) {
      List<User> users = userDao.listUsers();
      for (User u:users) {
         if (u.getCar().getName().equals(car.getName()) && u.getCar().getSeries()==car.getSeries()){
            return u;
         }
      }
      return new User();
   }

}
