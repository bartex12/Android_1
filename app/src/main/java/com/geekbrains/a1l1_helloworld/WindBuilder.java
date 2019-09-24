package com.geekbrains.a1l1_helloworld;

import android.content.Context;

import java.util.Random;

public class WindBuilder {

    String getWindSpeed(Context context){
        Random random = new Random();
        int rndWindSpeed = random.nextInt(14);
        String windSpeed = context.getString(R.string.windSpeed);
        String ms = context.getString(R.string.ms);
        return windSpeed + " " + rndWindSpeed + " " + ms;
    }
}
