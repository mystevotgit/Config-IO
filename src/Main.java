public class Main {
    public static void main (String args[]) {
        //  Initialize variables.
        String fileName;
        ConfigParser config;
        if (args.length == 0 || args[0].equals("production")) {

            //  Access the production environment.
            fileName = "src/config/config.txt";
            config = new ConfigParser(fileName);
            executeProgram(config);

        } else if (args[0].equals("staging")){

            //  Access the staging environment.
            fileName = "src/config/config-staging.txt";
            config = new ConfigParser(fileName);
            executeProgram(config);

        } else if (args[0].equals("development")){

            //  Access the development environment.
            fileName = "src/config/config-dev.txt";
            config = new ConfigParser(fileName);
            executeProgram(config);

        } else {
            System.out.println("The environment you specified does not exist or is not available for configuration." +
                    "\nUse production or staging or development as a command line argument instead.");
        }

    }


    /**
     * This method prints the values of all the getters of config.
     * Different values will be printed depending on the environment specified.
     * This method can be edited to handle other things.
     * @param config
     */
    public static void executeProgram(ConfigParser config) {
        System.out.println(config.getName());
        System.out.println(config.getDbname());
        System.out.println(config.getContextUrl());
        System.out.println(config.getHost());
        System.out.println(config.getMode());
        System.out.println(config.getPipeline());
        System.out.println(config.getPort());
        System.out.println(config.getTheme());
    }

}
