package etit.temp.contacts.dal;

import etit.temp.contacts.models.ContactModel;
import etit.temp.contacts.models.Gender;
import etit.temp.contacts.models.Titles;
import java.io.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class DataServiceTest {

  private static final DockerImageName contactsdb = DockerImageName.parse("contactsdb");

  @Container
  DockerComposeContainer container = new DockerComposeContainer(new File("C:\\Users\\langer" +
                                                                             "\\Desktop" +
                                                                             "\\Projects" +
                                                                             "\\ContactsDockerDb" +
                                                                             "\\docker-compose" +
                                                                             ".yml"));

  @Autowired
  DataService service;

  @Test
  void getContacts() {

    service.getContacts();
  }

  @Test
  void write() {

    service.write(new ContactModel(Titles.NONE, Gender.MALE, "Jacek", "Langer", "123456789"));

  }

}