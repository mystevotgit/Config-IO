import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        //  Initialize variables.
        String fileName;
        ConfigParser config;
        if (args.length == 0 || args[0].equals("production")) {

            //  Access the production environment.
            fileName = "src/config/config.txt";
            config = new ConfigParser(fileName);
            getConfiguration(config);

        } else if (args[0].equals("staging")){

            //  Access the staging environment.
            fileName = "src/config/config-staging.txt";
            config = new ConfigParser(fileName);
            getConfiguration(config);

        } else if (args[0].equals("development")){

            //  Access the development environment.
            fileName = "src/config/config-dev.txt";
            config = new ConfigParser(fileName);
            getConfiguration(config);

        } else {
            System.out.println("The environment you specified does not exist or is not available for configuration." +
                    "\nUse production or staging or development as a command line argument instead.");
        }

    }


    /**
     * This method prints the values of all the keys of the specified configuration environment.
     * Different values will be printed depending on the environment specified.
     * This method can be edited to do other things.
     * @param config: the config parser to be used.
     */
    public static void getConfiguration(ConfigParser config) {

        System.out.println(config.get("dbname"));
        System.out.println(config.get("host"));
        System.out.println(config.get("application.name"));
        System.out.println(config.get("application.port"));
        System.out.println(config.get("application.context-url"));
        System.out.println(config.get("mode"));
        System.out.println(config.get("theme"));
        System.out.println(config.get("pipeline"));

    }

}
