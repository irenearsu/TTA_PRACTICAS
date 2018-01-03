package eus.ehu.adibidea.tta.adb.Presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import eus.ehu.adibidea.tta.adb.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    protected void login(View view){
        Intent intent = new Intent(this,MainActivity.class);
        String login = ((EditText)findViewById(R.id.login)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.password)).getText().toString();
        if(authenticate(login,passwd)){
            intent.putExtra(MainActivity.EXTRA_LOGIN,login);
            startActivity(intent);
        }
    }

    protected boolean authenticate(String login,String password){
        return true;
    }
}

