package com.example.pace_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.lang.*;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText distanceEdtTxt;
    private EditText timehEdtTxt;
    private EditText timemEdtTxt;
    private EditText timesEdtTxt;
    private TextView speedmsTxtVwDisplay;
    private TextView speedkmphTxtVwDisplay;
    private TextView speedmphTxtVwDisplay;
    private TextView sPerLapTxtVwDisplay;
    private TextView ppkmMinTxtVwDisplay;
    private TextView ppkmSecTxtVwDisplay;
    private TextView ppmMinTxtVwDisplay;
    private TextView ppmSecTxtVwDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIView();
    }

    private void setupUIView(){
        distanceEdtTxt = (EditText)findViewById(R.id.distanceEdtTxt);
        timehEdtTxt = (EditText)findViewById(R.id.timehEdtTxt);
        timemEdtTxt = (EditText)findViewById(R.id.timemEdtTxt);
        timesEdtTxt = (EditText)findViewById(R.id.timesEdtTxt);
        speedmsTxtVwDisplay = (TextView)findViewById(R.id.speedmsTxtVwDisplay);
        speedkmphTxtVwDisplay = (TextView)findViewById(R.id.speedkmphTxtVwDisplay);
        speedmphTxtVwDisplay = (TextView)findViewById(R.id.speedmphTxtVwDisplay);
        sPerLapTxtVwDisplay = (TextView)findViewById(R.id.sPerLapTxtVwDisplay);
        ppkmMinTxtVwDisplay = (TextView)findViewById(R.id.ppkmMinTxtVwDisplay);
        ppkmSecTxtVwDisplay = (TextView)findViewById(R.id.ppkmSecTxtVwDisplay);
        ppmMinTxtVwDisplay = (TextView)findViewById(R.id.ppmMinTxtVwDisplay);
        ppmSecTxtVwDisplay = (TextView)findViewById(R.id.ppmSecTxtVwDisplay);
    }

    public void onCalcButton (View view){
        Double disk = Double.parseDouble(distanceEdtTxt.getText().toString());
        Integer hour = Integer.parseInt(timehEdtTxt.getText().toString());
        Integer min = Integer.parseInt(timemEdtTxt.getText().toString());
        Integer sec = Integer.parseInt(timesEdtTxt.getText().toString());

        Double dism = disk*1000;
        Double laps = dism/400;
        Integer time = ((hour*60)+(min*60)+sec);
        DecimalFormat df = new DecimalFormat("###.###");
        Double speedms = Double.parseDouble(df.format((dism/time))+"");
        Double speedkph = Double.parseDouble(df.format((3.6*speedms))+"");
        Double speedmph = Double.parseDouble(df.format((0.62137*speedkph))+"");
        Double pkm = Double.parseDouble(((time*1000)/dism)+"");
        Double minpkm2 = new Double((pkm/60));
        int minpkm = minpkm2.intValue();

        Double secpkm2 = new Double((pkm%60));
        int secpkm = secpkm2.intValue();
        //Double secpkm = Double.parseDouble(pkm%60+"");

        Double secplap = Double.parseDouble((time/laps)+"");


        Double dismile = Double.parseDouble((0.62137*disk)+"");
        Double pmile = Double.parseDouble((time/dismile)+"");
        Double minpmile2 = new Double((pmile/60)+"");
        int minpmile = minpmile2.intValue();

        Double secpmile2 = new Double((pmile%60)+"");
        int secpmile = secpmile2.intValue();

        speedmsTxtVwDisplay.setText(speedms+"");
        speedkmphTxtVwDisplay.setText(speedkph+"");
        speedmphTxtVwDisplay.setText(speedmph+"");
        sPerLapTxtVwDisplay.setText(secplap+"");
        ppkmMinTxtVwDisplay.setText(minpkm+"     :");
        ppkmSecTxtVwDisplay.setText(secpkm+"");
        ppmMinTxtVwDisplay.setText(minpmile+"     :");
        ppmSecTxtVwDisplay.setText(secpmile+"");

    }

}