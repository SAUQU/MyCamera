package com.example.segundoauqui.mycamera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class EmiActivity extends AppCompatActivity {


    EditText etLoanAmount;
    EditText etDuration;
    Button btnCalculate;
    TextView tvMonthlyResults;
    TextView tvYearlyResults;
    TextView tvMiddle1;
    SeekBar seekBarID;
    TextView tvYearlyResult;
    double rate;
    int year;
    double amount;
    double emi;
    double emiY;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);


        etLoanAmount = (EditText) findViewById(R.id.etLoanAmount);

        etDuration = (EditText) findViewById(R.id.etDuration);


        tvYearlyResult = (TextView) findViewById(R.id.tvYearlyResult);


        tvMonthlyResults = (TextView) findViewById(R.id.tvMonthlyResult);

        tvYearlyResults = (TextView) findViewById(R.id.tvYearlyResult);

        seekBarID = (SeekBar) findViewById(R.id.seekBarID);

        tvMiddle1 = (TextView) findViewById(R.id.tvMiddle1);



        seekBarID.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                double progress = (double) i;
                String val1 = getResources().getString(R.string.seek_bar_value);

                rate = progress;


                tvMiddle1.setText(val1 + progress);


            }




            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }



            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });








    }


    public void calculate(View view) {


        if (etLoanAmount.getText().toString().isEmpty() && etDuration.getText().toString().isEmpty() && seekBarID.getProgress() == 0) {
            Toast.makeText(this, "Missing Values", Toast.LENGTH_LONG).show();


        } else {

            year = Integer.parseInt(etDuration.getText().toString());

            amount = Double.parseDouble(etLoanAmount.getText().toString());

            rate = rate / (12 * 100);
            year = year * 12;

            emi = (amount * rate * Math.pow(1 + rate, year)) / (Math.pow(1 + rate, year) - 1);


            emiY = (emi * year);

            tvYearlyResult.setText("$ " + emiY + "");


            tvMonthlyResults.setText("$ " + emi + "");

            seekBarID.setProgress(0);
            etLoanAmount.setText("");
            etDuration.setText("");
        }


    }
}



