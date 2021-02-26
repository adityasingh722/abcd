package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class commonactions {

public Properties readProperty() throws IOException {
	
	File f = new File("data.properties");
	FileInputStream file = new FileInputStream(f);
	Properties pro = new Properties();
	pro.load(file);
	return pro;
}
}

