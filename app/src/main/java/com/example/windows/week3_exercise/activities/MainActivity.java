package com.example.windows.week3_exercise.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows.week3_exercise.R;
import com.example.windows.week3_exercise.fragments.MainFragment;
import com.example.windows.week3_exercise.utils.JokeTellerConstants;

public class MainActivity extends AppCompatActivity {
    private   int jokeindex=-1;

    private FrameLayout flContainer;
    private Button btnnext;
    private Button btnprevious;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        flContainer = (FrameLayout) findViewById(R.id.fl_container);

        if(savedInstanceState==null)
        {
            jokeindex++;
            MainFragment mainActivityFragment=MainFragment.newInstance(jokeindex);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container,mainActivityFragment).
                    commit();

        }

        btnprevious=(Button)findViewById(R.id.btn_previous);
        btnnext=(Button)findViewById(R.id.btn_next);

        btnprevious.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                jokeindex--;
                if(jokeindex>=0){
                    MainFragment fragment = MainFragment.newInstance(jokeindex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                }
                else {
                    jokeindex=0;
                   // btnnext.setEnabled(false);
                    Toast.makeText(getApplicationContext(), R.string.msg_no_more_joke, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                jokeindex++;
                if(jokeindex< JokeTellerConstants.TOTAL_JOKES)
                {
                    MainFragment fragment = MainFragment.newInstance(jokeindex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                }
                else
                {
                    jokeindex=JokeTellerConstants.TOTAL_JOKES-1;
                    Toast.makeText(getApplicationContext(), R.string.msg_no_more_joke, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
