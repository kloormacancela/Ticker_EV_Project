package com.evtian.ticker;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.widget.ProgressBar;

import java.util.logging.Handler;


public class MainActivity extends ActionBarActivity {

    // class fields for the progress bar
    private int _mProgressStatus = 0;
    private Handler _mHandler;

    Button btnShowDevi, btnPair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  setContentView(R.layout.wifi_connection);
        btnPair = (Button)findViewById(R.id.btnPair);
        btnShowDevi = (Button)findViewById(R.id.btnShowDevice);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Initialization of progress bar variable (sourcing from the progress bar implemented in the MainActivity.xml),
        // ImageView (again sourcing from the image on the MainActivity.xml) and Animation is sourced from the class stored
        // in the anim folder.
        final ProgressBar _progressBar = (ProgressBar)findViewById(R.id.circularProgressBar);
        final ImageView bitCoinImage = (ImageView) findViewById(R.id.imgBitcoin);
        final Animation r = AnimationUtils.loadAnimation(this, R.anim.logorotation);

        // Uses the ImageView 'bitCoinImage' property setOnClickListener and set it with a new overrided
        // anonymous method.
        bitCoinImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mProgressStatus = 0;
                _progressBar.setProgress(0);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (_mProgressStatus < 100) {
                            _mProgressStatus += 1;
                            try {
                                Thread.sleep(20);
                                _progressBar.setProgress(_mProgressStatus);
                            } catch (InterruptedException e) {
                                System.out.println("got interrupt");
                            }
                        }
                    }
                }).start();
                bitCoinImage.startAnimation(r);
            }
        });
        return true;
    }

    public void buttonOnClick(View v) {
// do something when the button is clicked
      // btnShowDevi.setVisibility(v.INVISIBLE);
       // btnPair.setVisibility(v.INVISIBLE);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
