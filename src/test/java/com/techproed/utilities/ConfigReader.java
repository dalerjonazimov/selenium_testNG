package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    //This class reads the configuration.properties file
    //Create Properties instance
    private static Properties properties;

    //using static block to run this code before the method; opening file, first read
    static{
        //path of the properties file
        String path = "configuration.properties";
        try {
            //opening the file
            FileInputStream fileInputStream = new FileInputStream(path);
            //instantiated the properties object
            properties = new Properties();
            //Loading the file
            properties.load(fileInputStream);
            //closing the file
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//ending the static block

    //Writing the method
    //it will take key  as String
    //and return the value
    //getProperty("app_url"); => http://www.carettahotel.com/
    //KEY: app_url  and VALUE: http://www.carettahotel.com/

    public static String getProperty(String key){

        String value = properties.getProperty(key);
        return value;
        //return properties.getProperty(key);
    }

//    public static void main(String[] args) {
//        String value = ConfigReader.getProperty("admin_password");
//        System.out.println(value);
//    }
}
