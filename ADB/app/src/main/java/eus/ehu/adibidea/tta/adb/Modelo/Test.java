package eus.ehu.adibidea.tta.adb.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import eus.ehu.adibidea.tta.adb.Business.TestInterface;

/**
 * Created by tta on 1/2/18.
 */

public class Test{

    private List<Choices> choices;
    private String wording;


    public int zuzena;



    public Test(){

        choices = new ArrayList<Choices>();

    }

    public String getWording(){

        return wording;
    }

    public void setWording(String wording){
        this.wording=wording;
    }

    public List<Choices> getChoices(){

        return choices;
    }

    public void setChoices(List<Choices> choices){
        this.choices=choices;
    }

    public static class Choices implements Serializable{

        private String answer;
        private int id;
        private String advice;
        private boolean correct;
        private String mime;

        public boolean isCorrect() {
            return correct;
        }

        public int getId() {
            return id;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAdvice() {
            return advice;
        }

        public String getMime() {
            return mime;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public void setCorrect(boolean correct) {
            this.correct = correct;
        }

        public void setMime(String mime) {
            this.mime = mime;
        }
    }



}
