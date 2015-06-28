package com.example.nquang.helloworld;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by NQuang on 6/8/2015.
 */
public class TutorialOneActivity extends Activity implements RadioGroup.OnCheckedChangeListener {
    EditText textIn;
    TextView textOut;
    RadioGroup styleG, gravityG;
    Button generateBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_one);

        textIn = (EditText) findViewById(R.id.editText);
        textOut = (TextView) findViewById(R.id.textView);
        styleG = (RadioGroup) findViewById(R.id.rgStyle);
        gravityG = (RadioGroup) findViewById(R.id.rgGravity);
        generateBT = (Button) findViewById(R.id.btGenerate);

        styleG.setOnCheckedChangeListener(this);
        gravityG.setOnCheckedChangeListener(this);

        generateBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textIn.getText());
            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbLeft:
                textOut.setGravity(Gravity.LEFT);
                break;
            case R.id.rbRight:
                textOut.setGravity(Gravity.RIGHT);
                break;
            case R.id.rbCenter:
                textOut.setGravity(Gravity.CENTER);
                break;
            case R.id.rbNormal:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case R.id.rbBold:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                break;
            case R.id.rbItalic:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                break;
        }
    }
}
