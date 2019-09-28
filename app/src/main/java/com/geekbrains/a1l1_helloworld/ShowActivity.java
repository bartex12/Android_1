package com.geekbrains.a1l1_helloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    private static final String TAG = "33333";

    private String city = "";
    private boolean isWind;
    private boolean isPressure;
    private TextView textViewCity;
    private TextView greetingsTextView;
    private TextView textViewWhether;
    private TextView textViewTemper;
    private TextView textViewWind;
    private TextView textViewPressure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = getIntent().getStringExtra(ChooseActivity.CITY);
        Log.d(TAG, "city = " + city);
        isWind = getIntent().getBooleanExtra(ChooseActivity.WIND, false);
        Log.d(TAG, "isWind = " + isWind);
        isPressure = getIntent().getBooleanExtra(ChooseActivity.PRESSURE, false);
        Log.d(TAG, "isPressure = " + isPressure);

        init();
        showData();
    }

    private void init(){
        textViewCity = findViewById(R.id.textViewCity);
        greetingsTextView = findViewById(R.id.greetingsTextView);
        textViewWhether = findViewById(R.id.textViewWhether);
        textViewTemper = findViewById(R.id.textViewTemper);
        textViewWind = findViewById(R.id.textViewWind);
        textViewPressure = findViewById(R.id.textViewPressure);
    }

    //сохранение погодных данных по городу при поворте экрана не делал в связи с
    // учебным характером задачи. Поэтому при повороте экрана данные меняются, поскольку
    //они рандомно формируются в showData(), вызываемом в onCreate() при повороте экрана
    private void showData() {

        textViewCity.setText(city);

        //формируем строку в зависимости от времени суток
        String text = new GreetingsBuilder().getGreetings(getApplicationContext());
        //выводим строки в текстовых полях
        greetingsTextView.setText(text);

        String  textWhether = new WhetherBuilder().getWhether(getApplicationContext());
        textViewWhether.setText(textWhether);

        String  textTemper = new TempBuilder().getTemperature(getApplicationContext());
        textViewTemper.setText(textTemper);

        if (isWind){
            String wind = new WindBuilder().getWindSpeed(getApplicationContext());
            textViewWind.setText(wind);
        }
       if (isPressure){
           String press = new PressureBuilder().getPressure(getApplicationContext());
           textViewPressure.setText(press);
       }

    }
}
