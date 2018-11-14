package framework;

import java.util.Properties;
import java.io.*;

public class FileProperties {
    private Properties prop;
    private String pathFile="./src/test/resources/config.properties";

    public FileProperties() {
        prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(new File(pathFile).getCanonicalPath());
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProperties(String parameter) {
        return prop.getProperty(parameter);
    }
}
