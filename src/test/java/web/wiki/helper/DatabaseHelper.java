package web.wiki.helper;

import web.wiki.model.entity.*;
import web.wiki.model.entity.Access;

import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static web.wiki.helper.JacksonYml.*;

/**
 * Created by PilarRM on 2/5/20.
 */
public class DatabaseHelper {

    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        //create_user("user.yml");
    }

    private static Date get_current_time(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return date;
    }

    public static void create_user(String ymlUserFile){
        readUserYmlJackson(PATH_USER_FILE,ymlUserFile);
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();

        EntityTransaction a = manager.getTransaction();
        a.begin();

        User u = new User(null,1 , USER_YML.getUser() , USER_YML.getEmail() ,USER_YML.getPassword());
        manager.persist(u);

        create_access(u.getId());

        manager.flush();
        a.commit();
    }

    private static void create_access(Long userId){
        Access ur = new Access(null,1, get_current_time(),userId,USER_YML.getAccess());
        manager.persist(ur);

    }


}
