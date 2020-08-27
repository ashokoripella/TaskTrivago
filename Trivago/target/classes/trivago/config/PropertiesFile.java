package trivago.config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	public String loadPropertyAsString(String propertyName) {

        String propertyValue = null;
        try {
            Properties props = new Properties();
            String filename = "C:\\Users\\champa\\eclipse-workspace\\Trivago\\src\\main\\resources\\trivago\\config\\config.properties";
            props.load(this.getClass().getResourceAsStream(filename));
            propertyValue = props.get(propertyName).toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("not able to load the file!!!", e);
        } catch (IOException e) {
            throw new RuntimeException("not able to read the file!!!", e);
        }
        return propertyValue;
    }
}

