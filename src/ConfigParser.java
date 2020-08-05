import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class ConfigParser {
    private Map<String, String> map;

    /**
     * This is the ConfigParser constructor.
     * It allows the application to read the desired configuration file.
     * @param filePath
     */

    public ConfigParser(String filePath) {
        try {
            //  Create a file reader.
            File environment = new File(filePath);
            Scanner fileReader = new Scanner(environment);
            map = new HashMap<>();         //  Create new map

            String prefix = "";                             // initialize a prefix that will track application.
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();        //  Read each line.

                if (data.isBlank()) {                       // set prefix to empty if a blank line is encountered.
                    prefix = "";
                }

                if (data.length() > 0 && data.charAt(0) == '[') {       // set prefix to the heading i.e application.
                    prefix = data.substring(1, data.length()-1) + ".";
                }

                if (data.contains("=")) {                               // split data into key and value and join prefix where necessary.
                    String[] splittedData = data.split("=");
                    String key = prefix.concat(splittedData[0]);
                    String value = splittedData[1];
                    if (!map.containsKey(key)) {
                        map.put(key, value);                //  Store key, value pairs in the map.
                    }
                }

            }
            fileReader.close();                     // Close the file.

        } catch (FileNotFoundException e) {         //  Handle exception
            e.printStackTrace();
        }
    }


    /**
     * This get method can be used to get any key in a config file.
     * @param key
     * @return: the value of the specified key will be returned.
     */
    public String get(String key) {
        return map.get(key);
    }
}
