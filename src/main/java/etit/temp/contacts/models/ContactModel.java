package etit.temp.contacts.models;

/**
 * Contact Model Class.
 */
public class ContactModel {

  private String name;
  private String lastname;
  private String phone;
  private String mail;
  private String title;
  private String gender;
  private ContactModel[] friends;

  public String getTitle() {

    return title;
  }

  public void setTitle(String value) {

    this.title = value;
  }

  public ContactModel[] getFriends() {

    return friends;
  }

  public void setFriends(ContactModel[] value) {

    this.friends = value;
  }

  public String getName() {

    return name;
  }

  public void setName(String value) {

    this.name = value;
  }

  public String getLastname() {

    return lastname;
  }

  public void setLastname(String value) {

    this.lastname = value;
  }

  public String getMail() {

    return mail;
  }

  public void setMail(String value) {

    this.mail = value;
  }

  public String getPhone() {

    return phone;
  }

  public void setPhone(String value) {

    this.phone = parsePhoneNumber(value);
  }

  public ContactModel() {

    this(Titles.NONE, Gender.UNDEFINED, "", "", "", "", null);
  }

  /**
   * Creates an instance with the tu email.
   *
   * @param firstName first name
   * @param lastName  last name
   * @param phone     the phone name
   */
  public ContactModel(Titles title, Gender gender, String firstName, String lastName, String phone,
                      ContactModel... friends) {

    this(title, gender, firstName, lastName, firstName + "." + lastName + "@tu-darmstadt.de", phone,
         friends);
  }

  /**
   * Creates a new instance of a ContactModel.
   *
   * @param name     name
   * @param lastname last name
   * @param phone    phone number
   * @param mail     email adress
   * @param friends  list of friends
   */
  public ContactModel(Titles title, Gender gender, String name, String lastname, String phone,
                      String mail, ContactModel[] friends) {

    this.name = name;
    this.lastname = lastname;
    this.phone = phone;
    this.mail = mail;
    this.friends = friends;
    this.gender = gender.getGender();
    this.title = title.getTitle();
  }

  private String parsePhoneNumber(String value) {

    char[] chars = new char[] { 'a', 'e', 'i', 'o', 'u' };
    var valueChars = value.toCharArray();

    for (char valueChar : valueChars) {
      for (char c : chars) {
        if (valueChar == c) {
          throw new NumberFormatException("not a valid number");
        }
      }
    }

    if (value.equals("") || value == null) {
      return null;
    }
    if (value.length() < 9 && value.charAt(0) != '0') {
      return value;
    }

    StringBuilder standardisedNumber = new StringBuilder();

    var firstDigits = value.substring(0, 2);

    if (firstDigits.equals("00")) {
      standardisedNumber.append("(+")
                        .append(value, 2, 4)
                        .append(")")
                        .append(value, 4, 7)
                        .append(" / ")
                        .append(value.substring(7));

      return standardisedNumber.toString();
    }
    if (value.charAt(0) == '0') {
      standardisedNumber.append("(+49)")
                        .append(value, 1, 4)
                        .append(" / ")
                        .append(value.substring(4));

      return standardisedNumber.toString();
    }

    if (value.charAt(0) == '+') {
      standardisedNumber.append("(")
                        .append(value, 0, 3)
                        .append(")")
                        .append(value, 3, 6)
                        .append(" / ")
                        .append(value.substring(6));

      return standardisedNumber.toString();
    }

    standardisedNumber.append("(+49)")
                      .append(value, 1, 3)
                      .append(" / ")
                      .append(value.substring(3));

    return standardisedNumber.toString();
  }

}
