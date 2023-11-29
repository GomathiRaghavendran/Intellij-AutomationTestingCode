package codeFromVenu.propertiesConcept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertyFileClass {



  public void loadData() throws IOException {
      FileInputStream  file = new FileInputStream("src/main/java/codeFromVenu/propertiesConcept/config.properties");
      Properties prop = new Properties();
      prop.load(file);

  }




}
