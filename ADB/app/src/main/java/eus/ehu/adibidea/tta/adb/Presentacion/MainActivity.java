package eus.ehu.adibidea.tta.adb.Presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import eus.ehu.adibidea.tta.adb.R;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_LOGIN;
    public static String EXTRA_PASSWORD;
    public static String EXTRA_LESSONNUMBER;
    public static String EXTRA_LESSONTITLE;
    public static String EXTRA_USER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view){
        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
    }

    public void ejercicio(View view){
        Intent intent = new Intent(this,EjercicioActivity.class);
        startActivity(intent);
    }

}
