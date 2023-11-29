package codeFromGomathi.PropertiesConcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadPropertyFileClass {

    public void loadData() throws IOException {
            FileInputStream file = new FileInputStream("src/main/java/codeFromGomathi/PropertiesConcepts/metaData.properties");
            Properties prop = new Properties();
            prop.load(file);
        System.out.println(prop);

        }

    }


