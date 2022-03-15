package etit.temp.contacts.dal;

import etit.temp.contacts.models.ContactModel;
import etit.temp.contacts.models.Gender;
import etit.temp.contacts.models.Titles;
import java.util.Map;

public class ModelHandler {

  public ContactModel handle(Map<String, String> values) {

    String firstname = values.get("firstname");
    String lastname = values.get("lastname");
    String phone = values.get("phone");
    String mail = values.get("mail");
    Titles title = getTitle(values.get("title"));
    Gender gender = getGender(values.get("gender"));

    return new ContactModel(title, gender, firstname, lastname, phone, mail);
  }

  private Gender getGender(String gender) {

    return switch (gender) {
      case "male" -> Gender.MALE;
      case "female" -> Gender.FEMALE;
      case "diverse" -> Gender.DIVERSE;
      default -> Gender.UNDEFINED;
    };
  }

  private Titles getTitle(String title) {

    return switch (title) {
      case "Prof. Dr." -> Titles.PROF_DR;
      case "Prof." -> Titles.PROF;
      case "Dr." -> Titles.DR;
      case "Dr.-Ing." -> Titles.DR_ING;
      case "Ing." -> Titles.ING;
      default -> Titles.NONE;
    };
  }

}
