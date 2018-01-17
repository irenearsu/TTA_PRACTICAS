package eus.ehu.adibidea.tta.adb.Modelo;

/**
 * Created by tta on 1/17/18.
 */

public class User {

    private int id;
    private String user;
    private int lessonNumber;
    private String lessonTitle;
    private int nextTest;
    private int nextExercise;

    public User(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user=user;
    }

    public int getLessonNumber(){
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber){
        this.lessonNumber=lessonNumber;
    }

    public String getLessonTitle(){
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle){
        this.lessonTitle=lessonTitle;
    }

    public int getNextTest(){
        return nextTest;
    }

    public void setNextTest(int nextTest){
        this.nextTest=nextTest;
    }

    public int getNextExercise(){
        return nextExercise;
    }

    public void setNextExercise(int nextExercise){
        this.nextExercise=nextExercise;
    }




}
