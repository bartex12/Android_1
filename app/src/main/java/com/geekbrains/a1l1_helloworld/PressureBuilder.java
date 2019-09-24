package com.geekbrains.a1l1_helloworld;

import android.content.Context;

import java.util.Random;

public class PressureBuilder {

    String getPressure(Context context){
        Random random = new Random();
        int rndPressure = 750 + random.nextInt(20);
        String press = context.getString(R.string.press);
        String mm = context.getString(R.string.mm);
        return press + " " + rndPressure + " " + mm;
    }
}
