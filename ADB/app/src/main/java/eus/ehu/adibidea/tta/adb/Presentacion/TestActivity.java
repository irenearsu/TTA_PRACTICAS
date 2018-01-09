package eus.ehu.adibidea.tta.adb.Presentacion;


import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

import eus.ehu.adibidea.tta.adb.Business.TestExample;
import eus.ehu.adibidea.tta.adb.Modelo.*;
import eus.ehu.adibidea.tta.adb.R;

import static android.R.attr.checked;
import static android.R.attr.checkedButton;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    public int correct;
    public int selected;
    RadioGroup group;

    TestExample data = new TestExample();
    Test test = data.getTest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        TextView textWording = (TextView)findViewById(R.id.test);
        textWording.setText(test.getGaldera());
        group = (RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for (String choice : test.getAukerak()){
            RadioButton radio = new RadioButton(this);
            radio.setText(choice);
            radio.setId(i);
            radio.setOnClickListener(this);
            group.addView(radio);
            if(test.zuzena == i)
                correct = i;
            i++;
        }

        /*TextView textWording = (TextView)findViewById(R.id.test);
        textWording.setText("Galdera");
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for(i=0;i<2;i++){
            RadioButton radio = new RadioButton(this);
            radio.setText(i+". aukera");
            radio.setOnClickListener(this);
            group.addView(radio);
        }
        correct = 1;*/



    }

    @Override
    public void onClick(View view){
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    public void send(View view){

        selected=group.getCheckedRadioButtonId();

        int choices = group.getChildCount();
        for(int i=0;i<choices;i++){
            group.getChildAt(i).setEnabled(false);
        }
        findViewById(R.id.button_send_test).setVisibility(View.GONE);

        group.getChildAt(correct).setBackgroundColor(Color.GREEN);
        if(selected != correct) {
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "¡Has fallado!", Toast.LENGTH_SHORT).show();

            if(test.adviceType != null){

                findViewById(R.id.button_send_advice).setVisibility(View.VISIBLE);

            }

        }
        else{
            Toast.makeText(getApplicationContext(),"¡Correcto!",Toast.LENGTH_SHORT).show();
        }

    }

    public void ayuda (View view){

        switch(test.adviceType){

            case "text/html":
                showHtml();
                break;
            case "video":
                showVideo();
                break;
            case "audio":
                showAudio();
                break;



        }

    }

    private void showHtml(){
        if (test.advice.contains("://")){
            Uri uri = Uri.parse(test.advice);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else{
            WebView web = new WebView(this);
            web.loadData(test.advice,"text/html",null);
            web.setBackgroundColor(Color.TRANSPARENT);
            web.setLayerType(WebView.LAYER_TYPE_SOFTWARE,null);
            ViewGroup layout = (ViewGroup)findViewById(R.id.test_activity);
            layout.addView(web);
        }
    }

    private void showVideo(){

        VideoView video = new VideoView(this);
        video.setVideoURI(Uri.parse(test.advice));
        WebView view = new WebView(this);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        view.setLayoutParams(params);

        MediaController controller = new MediaController(this){
            @Override
            public void hide(){

            }

            @Override
            public boolean dispatchKeyEvent(KeyEvent event){
                if (event.getKeyCode() == KeyEvent.KEYCODE_BACK)
                    finish();
                return super.dispatchKeyEvent(event);
            }
        };

        controller.setAnchorView(video);
        video.setMediaController(controller);

        ViewGroup layout = (ViewGroup)findViewById(R.id.test_activity);
        layout.addView(video);
        video.start();


    }

    private void showAudio(){

        WebView view = new WebView(this);
        AudioPlayer ap = new AudioPlayer(view);;

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        view.setLayoutParams(params);

        try {
            ap.setAudioUri(Uri.parse(test.advice));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ViewGroup layout = (ViewGroup)findViewById(R.id.test_activity);
        layout.addView(view);
        ap.start();
    }
}
