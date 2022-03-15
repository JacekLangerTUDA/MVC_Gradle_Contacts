package etit.temp.contacts.models;

public enum Gender {
  MALE("male"),
  FEMALE("female"),
  DIVERSE("diverse"),
  UNDEFINED("");

  private final String gender;

  public String getGender() {

    return gender;
  }

  Gender(String gender) {

    this.gender = gender;
  }
}
