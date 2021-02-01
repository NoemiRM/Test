package web.wiki.helper;

import web.wiki.model.yml.UserYml;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.File;
import java.io.IOException;

/**
 * Created by PilarRM on 2/3/20.
 */
public class JacksonYml {
    public static String PATH_USER_FILE = "data/user/";
    public static UserYml USER_YML = null;

    public static void main(String[] args) throws IOException {
        //readYmlJackson(PATH_CLIENT_FILE,"jose_perales.yml");
        //System.out.println("hola");
    }

    public static UserYml readUserYmlJackson(String folderPath, String fileName){
        String completePath = folderPath + fileName;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(completePath).getFile());
        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        try {
            USER_YML = om.readValue(file, UserYml.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return USER_YML;
    }

    public static String[] getNameFiles(String path){
        File file = new File(path);
        String[] fileList = file.list();
        for(String name:fileList){
            System.out.println(name);
        }
        return fileList;
    }
}
