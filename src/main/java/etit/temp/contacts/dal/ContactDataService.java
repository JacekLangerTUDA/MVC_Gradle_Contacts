package etit.temp.contacts.dal;

import etit.temp.contacts.models.ContactModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDataService extends DbConnectionService<ContactModel> {

  @Autowired
  ContactDataService(DataSource dataSource) {

    super(dataSource);
  }

  @Override
  public List<ContactModel> parseData(ResultSet data) throws SQLException {

    List<ContactModel> res = new ArrayList<>();
    while (data.next()) {

      Map<String, String> values = new ConcurrentHashMap<>();

      values.put("id", data.getString("Id"));
      values.put("firstname", data.getString("Firstname"));
      values.put("lastname", data.getString("Lastname"));
      values.put("gender", data.getString("Gender"));
      values.put("title", data.getString("Title"));
      values.put("phone", data.getString("Phonenumber"));
      values.put("mail", data.getString("Mail"));

      ModelHandler handler = new ModelHandler();
      ContactModel contact = handler.handle(values);
      res.add(contact);
    }

    return res;
  }

  public void saveData(ContactModel contact) {


  }

}
