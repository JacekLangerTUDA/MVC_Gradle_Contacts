package etit.temp.contacts.dal;

import java.io.File;
import java.nio.file.Path;

public class ComposeUtils {


  public static File getComposeFile() {

    return Path.of("src/test/resources/docker-compose.yml").toFile();
  }

}
