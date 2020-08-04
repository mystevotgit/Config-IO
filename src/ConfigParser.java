import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class ConfigParser {
    private String name;
    private String dbname;
    private String mode;
    private String pipeline;
    private String port;
    private String host;
    private String theme;
    private String contextUrl;

    /**
     * This is the ConfigParser constructor.
     * It allows the application to read the desired configuration file.
     * @param filePath
     */

    public ConfigParser(String filePath) {
        try {
            File environment = new File(filePath);
            Scanner fileReader = new Scanner(environment);
            Map<String, String> map = new HashMap<>();      //  Create new map

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();        //  Read each line.

                if (data.contains("=")) {
                    String[] splittedData = data.split("=");
                    String key = splittedData[0];
                    String value = splittedData[1];
                    if (!map.containsKey(key)) {
                        map.put(key, value);                //  Store key, value pair in the map.
                    }
                }

            }
            fileReader.close();     // Close the file.

            //  Assign value to class fields
            this.name = map.get("name");
            this.dbname = map.get("dbname");
            this.mode = map.get("mode");
            this.pipeline = map.get("pipeline");
            this.port = map.get("port");
            this.host = map.get("host");
            this.theme = map.get("theme");
            this.contextUrl = map.get("context-url");

        } catch (FileNotFoundException e) {         //  Handle exception
            e.printStackTrace();
        }
    }

    //  Getters
    public String getName() {
        return name;
    }

    public String getDbname() {
        return dbname;
    }

    public String getMode() {
        return mode;
    }

    public String getPipeline() {
        return pipeline;
    }

    public String getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getTheme() {
        return theme;
    }

    public String getContextUrl() {
        return contextUrl;
    }
}
