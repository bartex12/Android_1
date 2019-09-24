package com.geekbrains.a1l1_helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {

    EditText editTextCity;
    Button buttonShow;
    CheckBox checkBoxWind;
    CheckBox checkBoxPressure;

    String city = "";

    static String CITY = "CITY";
    static String WIND = "WIND";
    static String PRESSURE = "PRESSURE";

    static String TOWN = "TOWN";
    static String TAG = "33333";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        init();
        showCityWhether();
    }

    //Если есть id, сохранение происходит автоматически
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        city = editTextCity.getText().toString();
//        outState.putString(TOWN,city);
//        Log.d(TAG, "onSaveInstanceState city = "  + city);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        String str = savedInstanceState.getString(TOWN);
//        editTextCity.setText(str);
//        Log.d(TAG, "onRestoreInstanceState str = "  + str);
//    }

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
                city = editTextCity.getText().toString();
                boolean isWind = checkBoxWind.isChecked();
                boolean isPressure = checkBoxPressure.isChecked();

                if (city.isEmpty()){
                    Log.d(TAG, "showCityWhether city.isEmpty");
                    Toast.makeText(ChooseActivity.this, "Введите название города",
                            Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(ChooseActivity.this, ShowActivity.class);
                    intent.putExtra(CITY, city);
                    intent.putExtra(WIND, isWind);
                    intent.putExtra(PRESSURE, isPressure);
                    startActivity(intent);
                }


            }
        });
    }

}
