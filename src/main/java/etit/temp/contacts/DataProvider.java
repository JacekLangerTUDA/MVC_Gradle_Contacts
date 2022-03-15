package etit.temp.contacts;

import etit.temp.contacts.models.ContactModel;
import etit.temp.contacts.models.Gender;
import etit.temp.contacts.models.Titles;
import java.util.List;

public class DataProvider {

  public static List<ContactModel> getContacts() {

    // TODO(...): connect to api either implement your custom code here.

    return List.of(
        new ContactModel(Titles.PROF, Gender.MALE, "Randy", "Random", "321654987", null),
        new ContactModel(Titles.DR_ING, Gender.MALE, "Alfons", "Alfonso", "12345687789", null),
        new ContactModel(Titles.NONE, Gender.FEMALE, "Emely", "Emil", "12345687789", null),
        new ContactModel(Titles.PROF_DR, Gender.FEMALE, "Newly", "Newborn", "12345687789", null),
        new ContactModel(Titles.DR, Gender.FEMALE, "Amalie", "OldFashioned", "12345687789", null)
    );
  }

  public static void write(ContactModel contact) {

    // TODO(...): connect to api, implement your custom code here.
  }

}
