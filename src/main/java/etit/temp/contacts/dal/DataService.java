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

//    return List.of(
//        new ContactModel(Titles.PROF, Gender.MALE, "Randy", "Random", "321654987", null),
//        new ContactModel(Titles.DR_ING, Gender.MALE, "Alfons", "Alfonso", "12345687789", null),
//        new ContactModel(Titles.NONE, Gender.FEMALE, "Emely", "Emil", "12345687789", null),
//        new ContactModel(Titles.PROF_DR, Gender.FEMALE, "Newly", "Newborn", "12345687789", null),
//        new ContactModel(Titles.DR, Gender.FEMALE, "Amalie", "OldFashioned", "12345687789", null)
//    );
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
