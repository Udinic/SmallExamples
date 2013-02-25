package com.udinic.performance_demo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Udic
 * Date: 30/01/13
 * Time: 02:02
 * To change this template use File | Settings | File Templates.
 */
public class OverDraw extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.

        setContentView(R.layout.act_overdraw);
        getWindow().setBackgroundDrawable(null);
    }
}
