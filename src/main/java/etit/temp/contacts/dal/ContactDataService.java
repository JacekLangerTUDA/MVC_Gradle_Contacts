package etit.temp.contacts.dal;

import etit.temp.contacts.controller.MainController;
import etit.temp.contacts.models.ContactModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDataService extends DbConnectionService<ContactModel> {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

  @Autowired
  ContactDataService(DataSource dataSource) {

    super(dataSource);
    try {
      LOGGER.info(String.valueOf(dataSource.getConnection()));
    } catch (SQLException e) {
      LOGGER.error(e.getMessage());
    }
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

    try (var con = dataSource.getConnection()) {


      String sql =
          "INSERT INTO contacts (Firstname,Lastname,Gender,Title,Phonenumber,Mail) " +
              "VALUES (?,?,?,?,?,?)";

      var stmt = con.prepareStatement(sql);
      stmt.setObject(1, contact.getName());
      stmt.setObject(2, contact.getLastname());
      stmt.setObject(3, contact.getGender());
      stmt.setObject(4, contact.getTitle());
      stmt.setObject(5, contact.getPhone());
      stmt.setObject(6, contact.getMail());

      stmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
