package com.geekbrains.a1l1_helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {

    EditText editTextCity;
    Button buttonShow;
    CheckBox checkBoxWind;
    CheckBox checkBoxPressure;

    static String CITY = "CITY";
    static String WIND = "WIND";
    static String PRESSURE = "PRESSURE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        init();
        showCityWhether();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void init(){
        editTextCity = findViewById(R.id.editTextCity);
        buttonShow =  findViewById(R.id.buttonShow);
        checkBoxWind = findViewById(R.id.checkBoxWind);
        checkBoxPressure = findViewById(R.id.checkBoxPressure);
    }

    private void showCityWhether(){
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = editTextCity.getText().toString();
                boolean isWind = checkBoxWind.isChecked();
                boolean isPressure = checkBoxPressure.isChecked();

                Intent intent = new Intent(ChooseActivity.this, ShowActivity.class);
                intent.putExtra(CITY, city);
                intent.putExtra(WIND, isWind);
                intent.putExtra(PRESSURE, isPressure);
                startActivity(intent);
            }
        });
    }
}
