package com.example.medicalcalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        final EditText inputText = findViewById(R.id.inputWeightEditText);
        final RadioButton lbToKiloRB = findViewById(R.id.radioButton1);
        final RadioButton kiloToLbRB = findViewById(R.id.radioButton2);
        final TextView resultTextView = findViewById(R.id.resultTextView);

        final Button convertbutton = findViewById(R.id.convertButton);
        DecimalFormat outputFormat = new DecimalFormat("#.#");

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputText.getText().toString().isBlank()) {
                    weightEntered = Double.parseDouble(inputText.getText().toString());
                    if (lbToKiloRB.isChecked()) {
                        if (weightEntered <= 500) {
                            convertedWeight = weightEntered / conversionRate;
                            resultTextView.setText(outputFormat.format(convertedWeight) + " kg");
                        } else {
                            resultTextView.setText("");
                            Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        if (weightEntered <= 225) {
                            convertedWeight = weightEntered * conversionRate;
                            resultTextView.setText(outputF ormat.format(convertedWeight) + " lbs");
                        } else {
                            resultTextView.setText("");
                            Toast.makeText(MainActivity.this, "Kilograms must be less than 225", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else{
                    Toast.makeText(MainActivity.this, "Enter Value Please", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


}
