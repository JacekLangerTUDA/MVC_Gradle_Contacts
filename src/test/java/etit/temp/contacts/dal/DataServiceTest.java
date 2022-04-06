package etit.temp.contacts.dal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import etit.temp.contacts.ComposeUtils;
import etit.temp.contacts.models.ContactModel;
import etit.temp.contacts.models.Gender;
import etit.temp.contacts.models.Titles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class DataServiceTest {

  /**
   * The database container from the compose file.
   */
  @Container
  public static DockerComposeContainer<?> ENV = new DockerComposeContainer<>(
      ComposeUtils.getComposeFile());

  @Autowired
  DataService service;

  @Test
  void getContacts() {

    service.getContacts();
  }

  @Test
  void write() {

    var existing = service.getContacts();
    service.write(new ContactModel(Titles.NONE, Gender.MALE, "Jacek", "Langer", "123456789"));
    var newData = service.getContacts();

    assertTrue(existing.size() < newData.size());
  }

}