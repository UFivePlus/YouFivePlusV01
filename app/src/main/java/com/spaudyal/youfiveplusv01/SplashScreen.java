package com.spaudyal.youfiveplusv01;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashScreen extends AwesomeSplash {

    //Not overriding onCreate() method

    @Override
    public void initSplash(ConfigSplash configSplash) {

        /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorBlack); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.mipmap.ic_launcher); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
        configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(1000); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(1000); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.colorRed); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.colorYellow); //path object filling color


        //Customize Title
        configSplash.setTitleSplash("U 5 +");
        configSplash.setTitleTextColor(R.color.colorWhite);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        configSplash.setTitleFont("fonts/slimjim.ttf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {

        //transit to another activity here
        //or do whatever you want
        Intent intent = new Intent(this, CongratsReferal.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
