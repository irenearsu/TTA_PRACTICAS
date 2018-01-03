package eus.ehu.adibidea.tta.adb.Presentacion;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import eus.ehu.adibidea.tta.adb.Business.TestExample;
import eus.ehu.adibidea.tta.adb.Modelo.*;
import eus.ehu.adibidea.tta.adb.R;

import static android.R.attr.checked;
import static android.R.attr.checkedButton;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    public int correct;
    public int selected;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TestExample data = new TestExample();

        Test test = data.getTest();
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
        }
        else{
            Toast.makeText(getApplicationContext(),"¡Correcto!",Toast.LENGTH_SHORT).show();
        }

    }
}
