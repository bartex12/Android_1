package com.geekbrains.a1l1_helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {

    static String TAG = "33333";

    private ArrayAdapter<String> adapterSpinner = null;
    private Button buttonShow;
    private CheckBox checkBoxWind;
    private CheckBox checkBoxPressure;

    private Spinner spinnerTowns;
    private String city = "";
    private String[] towns =null;

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

    private void init(){
        buttonShow =  findViewById(R.id.buttonShow);
        checkBoxWind = findViewById(R.id.checkBoxWind);
        checkBoxPressure = findViewById(R.id.checkBoxPressure);
        towns = getResources().getStringArray(R.array.towns); //получаем массив из ресурсов
        adapterSpinner = new ArrayAdapter<>(this,
                R.layout.spinner_item, towns); //ставим адаптер со своим лейаутом
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTowns = findViewById(R.id.spinnerTowns);
        spinnerTowns.setAdapter(adapterSpinner); //подключанм адаптер к списку
        spinnerTowns.setSelection(1); //показываем вторую позицию
    }

    private void showCityWhether(){

        spinnerTowns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //так можно получить город через адаптер
                String str = parent.getItemAtPosition(position).toString();
                Log.d(TAG, "showCityWhether Город " + str);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //так можно получить город через спиннер
                city =  spinnerTowns.getSelectedItem().toString();
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
