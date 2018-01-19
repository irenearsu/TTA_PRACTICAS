package eus.ehu.adibidea.tta.adb.Presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import eus.ehu.adibidea.tta.adb.R;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_LOGIN = "EXTRA_LOGIN";
    public static final String EXTRA_PASSWORD = "EXTRA_PASSWORD";
    public static final String EXTRA_LESSONNUMBER ="EXTRA_LESSONNUMBER";
    public static final String EXTRA_LESSONTITLE ="EXTRA_LESSONTITLE";
    public static final String EXTRA_USER ="EXTRA_USER";
    public String LOGIN ="";
    public String PASSWORD="";
    public int LESSONUMBER=0;
    public String LESSONTITLE="";
    public String USER="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.LOGIN=getIntent().getStringExtra(EXTRA_LOGIN);
        this.PASSWORD=getIntent().getStringExtra(EXTRA_PASSWORD);
        this.LESSONUMBER=getIntent().getIntExtra(EXTRA_LESSONNUMBER,0);
        this.LESSONTITLE=getIntent().getStringExtra(EXTRA_LESSONTITLE);
        this.USER=getIntent().getStringExtra(EXTRA_USER);


    }

    public void test(View view){
        Intent intent = new Intent(this,TestActivity.class);
        intent.putExtra(TestActivity.LOGIN_EXTRA,LOGIN);
        intent.putExtra(TestActivity.PASSWORD_EXTRA,PASSWORD);
        startActivity(intent);
    }

    public void ejercicio(View view){
        Intent intent = new Intent(this,EjercicioActivity.class);
        startActivity(intent);
    }

}
