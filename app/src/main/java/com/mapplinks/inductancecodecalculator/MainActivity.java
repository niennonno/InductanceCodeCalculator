package com.mapplinks.inductancecodecalculator;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button frBlack;
    Button srBlack;
    Button trBlack;
    Button frBrown;
    Button srBrown;
    Button trBrown;
    Button frRed;
    Button srRed;
    Button trRed;
    Button frOrange;
    Button srOrange;
    Button trOrange;
    Button frYellow;
    Button srYellow;
    Button trYellow;
    Button frGreen;
    Button srGreen;
    Button frBlue;
    Button srBlue;
    Button frViolet;
    Button srViolet;
    Button frGray;
    Button srGray;
    Button trGold;
    Button frWhite;
    Button srWhite;
    Button trSilver;
    Button tolGold;
    Button tolSilver;
    Button tolNone;

    TextView indValue, tolValue;
    String suffix = "μ";

    int clickCount=0;

    int btnCount = 0;
    double value, first, second, multiplier, tolerance, tolVal;

    TextView firstBand, secondBand, thirdBand, fourthBand, firstBandValue, secondBandValue, thirdBandValue, fourthBandValue;

    String projectToken = "6f44bfe4e1d0458d1a8f662fa42a44ba";
    final MixpanelAPI mixpanel = MixpanelAPI.getInstance(this, projectToken);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String projectToken = "6f44bfe4e1d0458d1a8f662fa42a44ba";
        final MixpanelAPI mixpanel = MixpanelAPI.getInstance(this, projectToken);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        indValue = (TextView) findViewById(R.id.value);
        tolValue = (TextView) findViewById(R.id.tolerance);

        frBlack = (Button) findViewById(R.id.fb_black);
        frBlack.setOnClickListener(this);
        srBlack = (Button) findViewById(R.id.sb_black);
        srBlack.setOnClickListener(this);
        trBlack = (Button) findViewById(R.id.tb_black);
        trBlack.setOnClickListener(this);

        frBrown = (Button) findViewById(R.id.fb_brown);
        frBrown.setOnClickListener(this);
        srBrown = (Button) findViewById(R.id.sb_brown);
        srBrown.setOnClickListener(this);
        trBrown = (Button) findViewById(R.id.tb_brown);
        trBrown.setOnClickListener(this);

        frRed = (Button) findViewById(R.id.fb_red);
        frRed.setOnClickListener(this);
        srRed = (Button) findViewById(R.id.sb_red);
        srRed.setOnClickListener(this);
        trRed = (Button) findViewById(R.id.tb_red);
        trRed.setOnClickListener(this);

        frOrange = (Button) findViewById(R.id.fb_orange);
        frOrange.setOnClickListener(this);
        srOrange = (Button) findViewById(R.id.sb_orange);
        srOrange.setOnClickListener(this);
        trOrange = (Button) findViewById(R.id.tb_orange);
        trOrange.setOnClickListener(this);

        frYellow = (Button) findViewById(R.id.fb_yellow);
        frYellow.setOnClickListener(this);
        srYellow = (Button) findViewById(R.id.sb_yellow);
        srYellow.setOnClickListener(this);
        trYellow = (Button) findViewById(R.id.tb_yellow);
        trYellow.setOnClickListener(this);

        frGreen = (Button) findViewById(R.id.fb_green);
        frGreen.setOnClickListener(this);
        srGreen = (Button) findViewById(R.id.sb_green);
        srGreen.setOnClickListener(this);

        frBlue = (Button) findViewById(R.id.fb_blue);
        frBlue.setOnClickListener(this);
        srBlue = (Button) findViewById(R.id.sb_blue);
        srBlue.setOnClickListener(this);

        frViolet = (Button) findViewById(R.id.fb_violet);
        frViolet.setOnClickListener(this);
        srViolet = (Button) findViewById(R.id.sb_violet);
        srViolet.setOnClickListener(this);

        frGray = (Button) findViewById(R.id.fb_gray);
        frGray.setOnClickListener(this);
        srGray = (Button) findViewById(R.id.sb_gray);
        srGray.setOnClickListener(this);

        frWhite = (Button) findViewById(R.id.fb_white);
        frWhite.setOnClickListener(this);
        srWhite = (Button) findViewById(R.id.sb_white);
        srWhite.setOnClickListener(this);

        tolGold = (Button) findViewById(R.id.tol_gold);
        tolGold.setOnClickListener(this);
        tolSilver = (Button) findViewById(R.id.tol_silver);
        tolSilver.setOnClickListener(this);
        tolNone = (Button) findViewById(R.id.tol_none);
        tolNone.setOnClickListener(this);

        firstBand = (TextView) findViewById(R.id.firstBand);
        secondBand = (TextView) findViewById(R.id.secondBand);
        thirdBand = (TextView) findViewById(R.id.fourthBand);
        fourthBand = (TextView) findViewById(R.id.fifthBand);

        trGold = (Button) findViewById(R.id.tr_gold);
        trGold.setOnClickListener(this);
        trSilver = (Button) findViewById(R.id.tr_silver);
        trSilver.setOnClickListener(this);

        firstBandValue = (TextView) findViewById(R.id.first_band_value);
        secondBandValue = (TextView) findViewById(R.id.second_band_value);
        thirdBandValue = (TextView) findViewById(R.id.fourth_band_value);
        fourthBandValue = (TextView) findViewById(R.id.fifth_band_value);
    }

    @Override
    public void onClick(View v) {

        mixpanel.track("Click");
        ++clickCount;

        if (clickCount >= 20) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.mapplinks.inductancecodecalculator"));
            if (!MyStartActivity(intent)) {
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?[Id]"));
                if (!MyStartActivity(intent)) {
                    Toast.makeText(MainActivity.this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
                }
            }
        }


        switch (v.getId()) {
            case R.id.fb_black:
                ++btnCount;
                first = 0;
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                calculate();
                break;
            case R.id.sb_black:
                ++btnCount;
                second = 0;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                break;
            case R.id.tb_black:
                ++btnCount;
                multiplier = 0;
                suffix = "μ";
                calculate();
                thirdBand.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                break;

            case R.id.fb_brown:
                ++btnCount;
                first = 1;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorBrown));
                break;
            case R.id.sb_brown:
                ++btnCount;
                second = 1;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorBrown));
                break;
            case R.id.tb_brown:
                ++btnCount;
                multiplier = 1;
                suffix = "μ";
                calculate();
                thirdBand.setBackgroundColor(getResources().getColor(R.color.colorBrown));
                break;

            case R.id.fb_red:
                ++btnCount;
                first = 2;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorRed));
                break;
            case R.id.sb_red:
                ++btnCount;
                second = 2;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorRed));
                break;
            case R.id.tb_red:
                ++btnCount;
                multiplier = -1;
                suffix = "m";
                calculate();
                thirdBand.setBackgroundColor(getResources().getColor(R.color.colorRed));
                break;

            case R.id.fb_orange:
                ++btnCount;
                first = 3;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorOrange));
                break;
            case R.id.sb_orange:
                ++btnCount;
                second = 3;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorOrange));
                break;
            case R.id.tb_orange:
                ++btnCount;
                suffix = "m";
                multiplier = 0;
                calculate();
                thirdBand.setBackgroundColor(getResources().getColor(R.color.colorOrange));
                break;

            case R.id.fb_yellow:
                ++btnCount;
                first = 4;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                break;
            case R.id.sb_yellow:
                ++btnCount;
                second = 4;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                break;
            case R.id.tb_yellow:
                ++btnCount;
                suffix = "m";
                multiplier = 1;
                calculate();
                thirdBand.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                break;

            case R.id.fb_green:
                ++btnCount;
                first = 5;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                break;
            case R.id.sb_green:
                ++btnCount;
                second = 5;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                break;
            case R.id.tr_gold:
                ++btnCount;
                multiplier = -1;
                suffix = "μ";
                calculate();
                thirdBand.setBackgroundColor(getResources().getColor(R.color.colorGold));
                break;
            case R.id.fb_blue:
                ++btnCount;
                first = 6;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                break;
            case R.id.sb_blue:
                ++btnCount;
                second = 6;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                break;
            case R.id.tr_silver:
                ++btnCount;
                multiplier = -2;
                suffix = "μ";
                calculate();
                thirdBand.setBackgroundColor(getResources().getColor(R.color.colorSilver));
                break;
            case R.id.fb_violet:
                ++btnCount;
                first = 7;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorViolet));
                break;
            case R.id.sb_violet:
                ++btnCount;
                second = 7;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorViolet));
                break;

            case R.id.fb_gray:
                ++btnCount;
                first = 8;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                break;
            case R.id.sb_gray:
                ++btnCount;
                second = 8;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                break;

            case R.id.fb_white:
                ++btnCount;
                first = 9;
                calculate();
                firstBand.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.sb_white:
                ++btnCount;
                second = 9;
                calculate();
                secondBand.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;

            case R.id.tol_gold:
                tolerance = 5;
                calculateTolerance();
                fourthBand.setBackgroundColor(getResources().getColor(R.color.colorGold));
                break;
            case R.id.tol_silver:
                tolerance = 10;
                calculateTolerance();
                fourthBand.setBackgroundColor(getResources().getColor(R.color.colorSilver));
                break;
            case R.id.tol_none:
                tolerance = 20;
                calculateTolerance();
                fourthBand.setBackgroundColor(getResources().getColor(R.color.colorNone));
                break;
            default:
                break;
        }
    }

    void calculate() {
        DecimalFormat precision = new DecimalFormat("0");
        firstBandValue.setText(precision.format(first));
        secondBandValue.setText(precision.format(second));
        if (suffix == "μ") {
            thirdBandValue.setText("10^" + precision.format(multiplier));
        } else if (suffix == "m") {
            thirdBandValue.setText("10^" + precision.format(multiplier + 3));
        }

        if (btnCount >= 3) {
            value = (first * 10) + second;
            value *= Math.pow(10, multiplier);
            double formattedNumber = Double.parseDouble(new DecimalFormat("#.##").format(value));
            indValue.setText(formattedNumber + " " + suffix + "H");
            calculateTolerance();
        }
    }

    void calculateTolerance() {
        fourthBandValue.setText(tolerance + "%");
        if (btnCount >= 3) {
            tolVal = value * tolerance / 100;
            double formattedNumber = Double.parseDouble(new DecimalFormat("#.##").format(tolVal));
            tolValue.setText("±" + formattedNumber + " " + suffix + "H");
        }
    }

    private boolean MyStartActivity(Intent aIntent) {
        try {
            startActivity(aIntent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
