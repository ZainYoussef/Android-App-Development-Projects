package com.example.ticketsvault;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
double costPerTicket = 79.99;
int numberOfTickets;
double totalCost;
String spinnerChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final EditText numOfTicketsInput = findViewById(R.id.editTextText);
        final Spinner spinnerGroup = findViewById(R.id.spinner);
        Button findCostButton = findViewById(R.id.button);
        findCostButton.setOnClickListener(new View.OnClickListener() {
            final TextView resultView = findViewById(R.id.textView2);
            @Override
            public void onClick(View view) {
            numberOfTickets = Integer.parseInt(numOfTicketsInput.getText().toString());
            totalCost = costPerTicket * numberOfTickets;
            DecimalFormat costFormat = new DecimalFormat("$###,###.##");
            spinnerChoice = spinnerGroup.getSelectedItem().toString();
            String output = "Cost for " + spinnerChoice + " is: \n" + costFormat.format(totalCost);
            resultView.setText(output);
            Toast.makeText(MainActivity.this,"Thanks for using the app",Toast.LENGTH_LONG).show();

            }
        });
    }
}