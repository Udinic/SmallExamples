package com.udinic.performance_demo;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Main extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.traceView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                traceViewExample();
                findDivisors();
                doNothing();
                findDivisors2();
            }
        });

        findViewById(R.id.hprofDemoHeavy).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hprofHeavyExample();
            }
        });
        findViewById(R.id.hprofDemoLight).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hprofLightExample();
            }
        });
    }

    public void hprofHeavyExample() {
        Udinic udi = new Udinic();
        for (int i=0;i<1000; i++)
            for (int j=0;j<1000; j++)
                udi = new Udinic(udi);
    }

    class Udinic {
        String string = new String("bla");
        Integer intUdini = 1;
        String[] blas = new String[]{"udini", "is", "the", "man"};
        Rect r = new Rect(new Random().nextInt(),new Random().nextInt(),new Random().nextInt(),new Random().nextInt());
        Udinic me = null;

        public Udinic(Udinic other) {
            me = other;
        }

        public Udinic(){
        }
    }

    public void hprofLightExample() {
        Rect r = new Rect();
        for (int i=0;i<10000; i++) {
            r.set(i,i,i,i);
        }
    }

    public void traceViewExample() {
//        mainlySleep();
        doNothing();
        heavyDuty();
    }

    public void mainlySleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doNothing() {
        // Nothing
    }

    public void heavyDuty() {

        Log.d("udini", "Start: " + System.currentTimeMillis());
        findDivisors();
        findDivisors2();
        Log.d("udini", "End: " + System.currentTimeMillis());
    }

    public void callWebAddress() {
        try {

            URL url = new URL("http://www.google.co.il/");

            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
//        urlc.setRequestProperty("User-Agent", "Android Application:1");
//        urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(1000 * 30); // mTimeout is in seconds
            urlc.connect();
            if (urlc.getResponseCode() == 200) {
                Log.d("udini", "getResponseCode == 200");
            }

        } catch (MalformedURLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }

    public void findDivisors() {

        int N;            // One of the integers whose divisors we have to count.
        int maxDivisors;  // Maximum number of divisors seen so far.
        int numWithMax;   // A value of N that had the given number of divisors.

        maxDivisors = 1;  // Start with the fact that 1 has 1 divisor.
        numWithMax = 1;

        /* Process all the remaining values of N from 2 to 10000, and
           update the values of maxDivisors and numWithMax whenever we
           find a value of N that has more divisors than the current value
           of maxDivisors.
        */

        for ( N = 2;  N <= 2000;  N++ ) {

            int D;  // A number to be tested to see if its a divisor of N.
            int divisorCount;  // Number of divisors of N.

            divisorCount = 0;

            for ( D = 1;  D <= N;  D++ ) {  // Count the divisors of N.
               if ( N % D == 0 )
                  divisorCount++;
            }

            if (divisorCount > maxDivisors) {
               maxDivisors = divisorCount;
               numWithMax = N;
            }

        }

//        System.out.println("Among integers between 1 and 10000,");
//        System.out.println("The maximum number of divisors is " + maxDivisors);
//        System.out.println("A number with " + maxDivisors + " divisors is " + numWithMax);

    } // end main()

    public void findDivisors2() {

        int N;            // One of the integers whose divisors we have to count.
        int maxDivisors;  // Maximum number of divisors seen so far.
        int numWithMax;   // A value of N that had the given number of divisors.

        maxDivisors = 1;  // Start with the fact that 1 has 1 divisor.
        numWithMax = 1;

        /* Process all the remaining values of N from 2 to 10000, and
           update the values of maxDivisors and numWithMax whenever we
           find a value of N that has more divisors than the current value
           of maxDivisors.
        */

        for ( N = 2;  N <= 5000;  N++ ) {

            int D;  // A number to be tested to see if its a divisor of N.
            int divisorCount;  // Number of divisors of N.

            divisorCount = 0;

            for ( D = 1;  D <= N;  D++ ) {  // Count the divisors of N.
               if ( N % D == 0 )
                  divisorCount++;
            }

            if (divisorCount > maxDivisors) {
               maxDivisors = divisorCount;
               numWithMax = N;
            }

        }

//        System.out.println("Among integers between 1 and 10000,");
//        System.out.println("The maximum number of divisors is " + maxDivisors);
//        System.out.println("A number with " + maxDivisors + " divisors is " + numWithMax);

    }

}
