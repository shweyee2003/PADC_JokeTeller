package com.example.windows.week3_exercise.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows.week3_exercise.R;
import com.example.windows.week3_exercise.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {
    private   int i=0;
  //  int histprvradioid=0;
    //int histnextradioid=0;
    int selectedId;
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
        MainFragment mainActivityFragment=new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container,mainActivityFragment).
                commit();

        final Button btnprevious=(Button)findViewById(R.id.btn_previous);
        final Button btnnext=(Button)findViewById(R.id.btn_next);
        RadioGroup rd_btn_grp=(RadioGroup)findViewById(R.id.rdbtn_group);
        selectedId = rd_btn_grp.getCheckedRadioButtonId();


        btnprevious.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i--;
                RadioButton btn_radioprev;
                btnprevious.setEnabled(true);
                btnnext.setEnabled(true);
                if(i<0)
                {
                    i=0;
                    btnprevious.setEnabled(false);
                    Toast.makeText(MainActivity.this,"No Record",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    btnprevious.setEnabled(true);
                    changedata();
                  //  histprvradioid=selectedId;
                }
//                if(histnextradioid==0)
//                {
//                    btn_radioprev =(RadioButton)findViewById(selectedId);
//                }
//                else
//                {
//                    btn_radioprev=(RadioButton)findViewById(histnextradioid);
//                }
               // RadioButton btn_radioprev=(RadioButton)findViewById(selectedId);


            }
        });

        btnnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                RadioButton btn_radionext;
                btnprevious.setEnabled(true);
                btnnext.setEnabled(true);
                i++;
                if(i>2)
                {
                    i=2;
                    btnnext.setEnabled(false);
                    Toast.makeText(MainActivity.this,"No Record",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    btnnext.setEnabled(true);
                  //  histnextradioid=selectedId;
                    changedata();
                }
//                if(histprvradioid==0)
//                {
//                    btn_radionext =(RadioButton)findViewById(selectedId);
//                }
//                else
//                {
//                    btn_radionext=(RadioButton)findViewById(histprvradioid);
//                }
//                // RadioButton btn_radioprev=(RadioButton)findViewById(selectedId);
//                histnextradioid=selectedId;
//                Toast.makeText(MainActivity.this,btn_radionext.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void changedata(){
        TextView tv_title=(TextView) findViewById(R.id.tv_title);
        ImageView imgview=(ImageView)findViewById(R.id.imgv_joke);
        TextView tv_body=(TextView)findViewById(R.id.tv_body);


        switch(i)
        {
            case 0:
                tv_title.setText(R.string.joke1_title);
                imgview.setImageResource(R.drawable.joke_1);
                tv_body.setText(R.string.joke1_text);

                break;
            case 1:
                tv_title.setText(R.string.joke2_title);
                imgview.setImageResource(R.drawable.joke_2);
                tv_body.setText(R.string.joke2_text);
             //   btn_radio=(RadioButton)findViewById(selectedId);
               // Toast.makeText(MainActivity.this,btn_radio.getText(),Toast.LENGTH_SHORT).show();
                //RadioButton btn2_radio=(RadioButton)findViewById(selectedId);
                //btn2_radio.setChecked(true);
                break;
            default:
                tv_title.setText(R.string.joke3_title);
                imgview.setImageResource(R.drawable.joke_3);
                tv_body.setText(R.string.joke3_text);
            //    btn_radio=(RadioButton)findViewById(selectedId);
              //  Toast.makeText(MainActivity.this,btn_radio.getText(),Toast.LENGTH_SHORT).show();
                //RadioButton btn3_radio=(RadioButton)findViewById(selectedId);
                //btn3_radio.setChecked(true);
               // Toast.makeText(MainActivity.this,btn_radio.getText(),Toast.LENGTH_SHORT).show();
                break;
        }
       // RadioButton btn_radio=(RadioButton)findViewById(selectedId);
       // RadioButton btnprev_radio=(RadioButton)findViewById(histprvradioid);
       // Toast.makeText(MainActivity.this,btn_radio.getText(),Toast.LENGTH_SHORT).show();
       // Toast.makeText(MainActivity.this,btnprev_radio.getText(),Toast.LENGTH_SHORT).show();
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
