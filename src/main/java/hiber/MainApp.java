package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
     AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car = new Car("audi", 100);
      Car car1 = new Car("bmw", 5);
      Car car2 = new Car("lada", 9);
      Car car3 = new Car("opel", 3);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User user1 = userService.getUserByEmail("user1@mail.ru");
      user1.setCar(car);
      userService.update(user1);
      User user2 = userService.getUserByEmail("user2@mail.ru");
      user2.setCar(car1);
      userService.update(user2);
      User user3 = userService.getUserByEmail("user3@mail.ru");
      user3.setCar(car2);
      userService.update(user3);
      User user4 = userService.getUserByEmail("user4@mail.ru");
      user4.setCar(car3);
      userService.update(user4);




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(userService.getUserByCar(car1));
      context.close();
   }
}
