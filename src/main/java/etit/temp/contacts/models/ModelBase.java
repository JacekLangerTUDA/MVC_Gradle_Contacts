package etit.temp.contacts.models;

import java.rmi.server.UID;

public class ModelBase {


  private final UID id;

  public ModelBase() {

    this.id = new UID();
  }

  public ModelBase(UID id) {

    this.id = id;
  }

}
