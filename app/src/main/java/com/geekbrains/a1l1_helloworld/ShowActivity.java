package com.geekbrains.a1l1_helloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    static String TAG = "33333";

    String city = "";
    boolean isWind;
    boolean isPressure;
    TextView textViewCity;
    TextView greetingsTextView;
    TextView textViewWhether;
    TextView textViewTemper;
    TextView textViewWind;
    TextView textViewPressure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //В портретном и ландшафтном вариантах макета цвет текста сделан разным специально
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

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void init(){
        textViewCity = findViewById(R.id.textViewCity);
        greetingsTextView = findViewById(R.id.greetingsTextView);
        textViewWhether = findViewById(R.id.textViewWhether);
        textViewTemper = findViewById(R.id.textViewTemper);
        textViewWind = findViewById(R.id.textViewWind);
        textViewPressure = findViewById(R.id.textViewPressure);
    }

    private void showData() {
        String c = getResources().getString(R.string.city) + ": " + city;
        textViewCity.setText(c);

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
