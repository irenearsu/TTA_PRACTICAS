package eus.ehu.adibidea.tta.adb.Presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import eus.ehu.adibidea.tta.adb.Modelo.ProgressTask;
import eus.ehu.adibidea.tta.adb.Modelo.RestClient;
import eus.ehu.adibidea.tta.adb.Modelo.Server;
import eus.ehu.adibidea.tta.adb.Modelo.User;
import eus.ehu.adibidea.tta.adb.R;

public class LoginActivity extends AppCompatActivity {

    private Server server = new Server();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View view) throws IOException{
        //final Intent intent = new Intent(this,MainActivity.class);
        final String login = ((EditText)findViewById(R.id.login)).getText().toString();
        final String passwd = ((EditText)findViewById(R.id.password)).getText().toString();

        new ProgressTask<User>(this){
            @Override
            protected User work() throws Exception{
                server.getRc().setHttpBasicAuth(login,passwd);
                return server.getUser(login);

            }

            @Override
            protected void onFinish(User user){

                Intent input = new Intent(getApplicationContext(),MainActivity.class);
                input.putExtra(MainActivity.EXTRA_LOGIN,login);
                input.putExtra(MainActivity.EXTRA_USER,user.getUser());
                input.putExtra(MainActivity.EXTRA_LESSONTITLE,user.getLessonTitle());
                input.putExtra(MainActivity.EXTRA_PASSWORD,passwd);
                input.putExtra(MainActivity.EXTRA_LESSONNUMBER,user.getLessonNumber());
                startActivity(input);

            }
        }.execute();


    }

}

