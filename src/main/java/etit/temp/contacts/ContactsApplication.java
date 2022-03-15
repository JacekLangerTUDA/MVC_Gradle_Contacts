package etit.temp.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// remove exclude when you connect this project to a DB
public class ContactsApplication {

  public static void main(String[] args) {

    SpringApplication.run(ContactsApplication.class, args);
  }

}
