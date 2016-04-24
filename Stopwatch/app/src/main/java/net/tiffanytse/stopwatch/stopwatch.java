package net.tiffanytse.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class stopwatch extends AppCompatActivity {
    //use seconds to running to record the number of seconds passed and whether the
    //stop watch is running
    private int seconds = 0;
    //is the stop
    private boolean running;
    //record if stopWatch was running before onStop() method
    private boolean wasRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        //retrieve the values of the seconds and running variables from the Bundle
        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }

    //If activity's paused, stop the stopwatch
    @Override
    protected void onPause(){
        super.onPause();
        wasRunning = running;
        running=false;
    }
    @Override
    //If the activit's resume, stat the stopwatch again if it was running previously
    protected void onResume(){
        super.onResume();
        if(wasRunning){
            running=true;
        }
    }
    //Call this method before onDestory. Gives you a chance to save your activity's
    //state before the activity is destroyed
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        wasRunning = savedInstanceState.getBoolean("wasRunning", wasRunning);
    }


    //start the stopwatch running when the Start button is clicked.
     public void onClickStart(View view){
         running = true;
     }

    //stop the stopwatch running when the stop button is clicked
    public void onClickStop(View view){
        running = false;
    }
    //Reset the stopwatch when the Reset button is clicked
    public void onClickReset(View view){
        running =false;
        seconds =0;
    }




//run timer
    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        //create a hew Handler
        final Handler handler = new Handler();
        //call the post() method passing a new Runnable. The post() method processes code
        //without a delay so the code in the runnable immediately
        handler.post(new Runnable(){
            @Override
            public void run(){
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int sec = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, sec);
                timeView.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }

        });

    }
}
