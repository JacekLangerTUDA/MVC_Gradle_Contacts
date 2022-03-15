package etit.temp.contacts.dal;

import etit.temp.contacts.models.ModelBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class DbConnectionService<T extends ModelBase> {


  private final DataSource dataSource;

  @Autowired
  public DbConnectionService(DataSource dataSource) {

    this.dataSource = dataSource;
  }

  public abstract List<T> parseData(ResultSet data) throws SQLException;

  public List<T> findAllData() {

    List<T> data = new ArrayList<>();
    try (var con = dataSource.getConnection()) {
      var stmt = con.createStatement();
      var rs = stmt.executeQuery("SELECT * FROM contacts");
      data = parseData(rs);
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return data;
  }

}
