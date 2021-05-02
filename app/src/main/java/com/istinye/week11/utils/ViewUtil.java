package com.istinye.week11.utils;

import com.istinye.week11.R;

import java.util.Random;

public class ViewUtil {

    private static int[] myVectorDrawables = {R.drawable.android, R.drawable.car, R.drawable.bus, R.drawable.plane};

    public static int getRandomProfilePicture(){
        return myVectorDrawables[new Random().nextInt(myVectorDrawables.length)];
    }

}
