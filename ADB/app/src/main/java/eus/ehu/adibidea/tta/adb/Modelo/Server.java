package eus.ehu.adibidea.tta.adb.Modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by tta on 1/17/18.
 */

public class Server {

    String url = "http://u017633.ehu.eus:28080/ServidorTta/rest/tta";

    RestClient rc = new RestClient(url);

    public Server(){

    }

    public User getUser(String dni) throws IOException,JSONException{

        JSONObject json = rc.getJson(String.format("getStatus?dni=%s",dni));

        User user = new User();
        user.setId(json.getInt("id"));
        user.setUser(json.getString("user"));
        user.setLessonNumber(json.getInt("lessonNumber"));
        user.setLessonTitle(json.getString("lessonTitle"));
        user.setNextTest(json.getInt("nextTest"));
        user.setNextExercise(json.getInt("nextExercise"));

        return user;

    }

    public RestClient getRc(){
        return rc;
    }
}
