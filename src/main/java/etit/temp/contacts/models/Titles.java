package etit.temp.contacts.models;

public enum Titles {

  NONE(""),
  PROF_DR("Prof. Dr."),
  PROF("Prof."),
  DR("Dr."),
  DR_ING("Dr.-Ing."),
  ING("Ing.");

  private final String title;

  public String getTitle() {

    return title;
  }

  Titles(String title) {

    this.title = title;

  }
}

