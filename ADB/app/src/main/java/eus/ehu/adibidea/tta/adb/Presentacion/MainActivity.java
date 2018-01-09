package eus.ehu.adibidea.tta.adb.Presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import eus.ehu.adibidea.tta.adb.R;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_LOGIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void test(View view){
        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
    }

    protected void ejercicio(View view){
        Intent intent = new Intent(this,EjercicioActivity.class);
        startActivity(intent);
    }

}
