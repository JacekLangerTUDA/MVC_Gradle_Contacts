package etit.temp.contacts;

import etit.temp.contacts.models.ContactModel;
import etit.temp.contacts.models.Gender;
import etit.temp.contacts.models.Titles;
import java.util.List;

public class DataProvider {

  public static List<ContactModel> getContacts() {

    // TODO(...): connect to api either implement your custom code here.

    return List.of(
        new ContactModel(Titles.NONE, Gender.MALE, "Jacek", "Langer", "+491639746080", null),
        new ContactModel(Titles.NONE, Gender.MALE, "Ahmet", "Toy", "12345687789", null),
        new ContactModel(Titles.NONE, Gender.FEMALE, "Elif", "Kocak", "12345687789", null)

    );
  }

  public static void write(ContactModel contact) {

    // TODO(...): connect to api, implement your custom code here.
  }

}
