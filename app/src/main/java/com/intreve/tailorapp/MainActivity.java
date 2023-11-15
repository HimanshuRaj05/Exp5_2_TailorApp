package com.intreve.tailorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double height;
    Button btn;
    RadioGroup rg;
    Spinner spinner;

    EditText et;

    double cost;

    String size;

    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        rg=findViewById(R.id.rg);
        spinner=findViewById(R.id.spinner);
        et=findViewById(R.id.et);


        String[] spinnerItems={"L", "XL", "XXL"};


        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem=adapterView.getItemAtPosition(i).toString();

                size=selectedItem;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightString=et.getText().toString();
                height=Double.parseDouble(heightString);
                int id=rg.getCheckedRadioButtonId();
                RadioButton rb= findViewById(id);
                gender=rb.getText().toString();
                switch (size){
                    case "L":
                        switch (gender){
                            case "Male":
                                cost=height*300;
                                break;

                            case "Female":
                                cost=height*500;
                                break;
                        }

                        break;


                    case "XL":
                        switch (gender){
                            case "Male":
                                cost=height*400;
                                break;

                            case "Female":
                                cost=height*700;
                                break;
                        }

                        break;

                    case "XXL":
                        switch (gender){
                            case "Male":
                                cost=height*500;
                                break;

                            case "Female":
                                cost=height*900;
                                break;
                        }

                        break;

                }


                Toast.makeText(MainActivity.this, "Total cost: "+cost, Toast.LENGTH_SHORT).show();
            }
        });




    }
}