package eus.ehu.adibidea.tta.adb.Modelo;

import org.json.JSONArray;
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

    public Test getTest(int id) throws IOException,JSONException{

        try {
            Test test = new Test();
            JSONObject json = rc.getJson(String.format("getTest?id=%d",id));
            test.setWording(json.getString("wording"));
            JSONArray array = json.getJSONArray("choices");
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                Test.Choices choice = new Test.Choices();
                choice.setId(item.getInt("id"));
                choice.setAnswer(item.getString("answer"));
                choice.setCorrect(item.getBoolean("correct"));
                choice.setAdvice(item.optString("advise", null));

                if (item.getString("resourceType").matches("null"))
                    choice.setMime("null");
                else {
                    JSONObject resourceType = item.getJSONObject("resourceType");
                    choice.setMime(resourceType.getString("mime"));
                }

                test.getChoices().add(choice);
            }
            return test;
        } catch(JSONException e){
            return null;

        }

    }
}
