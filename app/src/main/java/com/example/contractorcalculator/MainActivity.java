package com.example.contractorcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText labor, material;
    Button calculate, chrate;
    TextView subtotal, tax, total, rate, crate;

    private static final double RATE = 0.05;
    double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        labor = findViewById(R.id.labor);
        material = findViewById(R.id.material);
        calculate = findViewById(R.id.cal);
        subtotal = findViewById(R.id.subtotal);
        tax = findViewById(R.id.tax);
        total = findViewById(R.id.total);
        chrate = findViewById(R.id.chrate);
        rate = findViewById(R.id.rate);
        crate = findViewById(R.id.crate);


        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("tax", "");
        crate.setText("%"+s1);

        rate.setText("%"+String.valueOf(RATE*100));
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(labor.getText().length()==0||material.getText().length()==0){
                    Toast.makeText(MainActivity.this, "Both Labor Costs and Material Costs are Required", Toast.LENGTH_SHORT).show();
                }else{
                    if(crate.getText().length()==0){
                        a = Double.parseDouble(labor.getText().toString());
                        b = Double.parseDouble(material.getText().toString());
                        c = a + b;
                        subtotal.setText(String.valueOf(c));
                        a = c*RATE;
                        tax.setText(String.valueOf(a));
                        total.setText(String.valueOf(a+c));
                    }else{
                        a = Double.parseDouble(labor.getText().toString());
                        b = Double.parseDouble(material.getText().toString());
                        c = a + b;
                        subtotal.setText(String.valueOf(c));
                        a = c*(Double.parseDouble(s1)/100);
                        tax.setText(String.valueOf(a));
                        total.setText(String.valueOf(a+c));
                    }
                }
            }
        });

        chrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                final EditText ed = new EditText(MainActivity.this);
                alert.setTitle("Enter Tax Rate");
                ed.setInputType(InputType.TYPE_CLASS_NUMBER);
                ed.setHint("  Tax Rate");
                alert.setView(ed);
                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = sharedPreferences.edit();
                        myEdit.putString("tax", ed.getText().toString());
                        myEdit.apply();
                        startActivity(getIntent());
                        finish();
                    }
                });

                alert.setNegativeButton("No Option", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                });

                alert.show();
            }
        });
    }
}