package com.geekbrains.a1l1_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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
        String text = new GreetingsBuilder().getGreetings(getApplicationContext());
        greetingsTextView.setText(text);
    }
}
