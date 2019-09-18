package com.geekbrains.a1l1_helloworld;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //В портретном и ландшафтном вариантах макета цвет текста сделан разным специально
        setContentView(R.layout.activity_main);
        initGreetingsText();
    }

    private void initGreetingsText() {
        TextView greetingsTextView = findViewById(R.id.greetingsTextView);
        //формируем строку в зависимости от времени суток
        String text = new GreetingsBuilder().getGreetings(getApplicationContext());
        //выводим строку в текстовом поле
        greetingsTextView.setText(text);
    }
}
