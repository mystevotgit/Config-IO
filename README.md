# Config-IO

This application takes in a command line argument. The argument can be any of the following:

* production
* staging
* development

The application reads the configuration file corresponding to command line argument supplied when starting the application.
### Example

`java Main.java development                // The application will read the development configuration file.`

if no command line argument is supplied when starting the application, the application will read the production configuration file.
### Example

`java Main.java                            // The application will read the production configuration file by default.`

## Java Files and IO
Java Files and IO involves using *Input Streams* and *Output Streams* (IO streams) to communicate with files in java.

IO streams can be categorized into two groups:

* Input stream that reads data from a source;
* Output stream that writes data to a specified destination.

There are specific IO Streams that can be used to read or write to files.

A commonly used one is _**FileInputStream**_ and _**FileOutputStream**_.

_**Java Scanner class**_ and _**File class**_ can be combined to read or write to a file too.

### Implementation

In this Task, I read and manipulated strings from environment configuration files into a map using Java Scanner class and File class.
I did the following:

1.  I created a file reader.

    `File environment = new File(filePath);`  
    `Scanner fileReader = new Scanner(environment);`

2.  I read each line of the file.

    `while (fileReader.hasNextLine()) {`  
      `  String data = fileReader.nextLine();`  
      `...`  
      `}`  
      
3.  I splitted the data read into key and value pair to be stored in a map.

    `if (data.contains("=")) {`  
                    `String[] splittedData = data.split("=");`  
                    `String key = prefix.concat(splittedData[0]);`  
                    `String value = splittedData[1];`  
                    `}`  
                    
4.  I stored key and value pairs in a map i created.

    `map.put(key, value);`  
    
5.  I closed the file.

    `fileReader.close();`  

6.  I handled exceptions.

    `catch (FileNotFoundException e) {`  
            `e.printStackTrace();`  
        `}`

## Java Files and NIO

To be updated later...
