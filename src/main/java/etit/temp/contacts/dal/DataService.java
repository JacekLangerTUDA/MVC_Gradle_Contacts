package etit.temp.contacts.dal;

import etit.temp.contacts.models.ContactModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

  private final ContactDataService dataService;

  public List<ContactModel> getContacts() {

    // TODO(...): connect to api either implement your custom code here.
    return dataService.findAllData();
  }


  /**
   * @param dbConnectionService the connecction service
   */
  @Autowired
  public DataService(ContactDataService dbConnectionService) {

    this.dataService = dbConnectionService;
  }

  public void write(ContactModel contact) {

    // TODO(...): connect to api, implement your custom code here.
    dataService.saveData(contact);
  }

}
