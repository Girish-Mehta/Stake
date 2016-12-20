package in.edamus.root.stake;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class userPannel extends AppCompatActivity {

    private TextView splay;                     //Single Player Mode Button
    private TextView mplay;                     //Multi Player Mode Butotn
    private TextView go;                        //Start Game Button
    private TextView colora;                    //Color 1- Yellow
    private TextView colorb;                    //Color 2- Girlish
    private TextView colorc;                    //Color 3- Black
    private TextView colord;                    //Color 4- Cyan Blue
    private TextView back;                      //Back Button
    private LinearLayout splayground;           //Single Player console
    private LinearLayout playground;            //Game Console
    private LinearLayout main;                  //Main Activity
    private int result;                         //Decision element
    private int sword;                          //User choosen color
    private boolean check;                      //Kind of a flag



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pannel);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //Declaring variables

        go = (TextView) findViewById(R.id.go);
        back = (TextView) findViewById(R.id.back);
        splay = (TextView) findViewById(R.id.splay);
        mplay = (TextView) findViewById(R.id.mplay);
        colora = (TextView) findViewById(R.id.colora);
        colorb = (TextView) findViewById(R.id.colorb);
        colorc = (TextView) findViewById(R.id.colorc);
        colord = (TextView) findViewById(R.id.colord);
        playground = (LinearLayout)findViewById(R.id.playground);
        splayground = (LinearLayout)findViewById(R.id.splayground);
        main = (LinearLayout) findViewById(R.id.activity_user_pannel);

        check = false;

        splay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Enable Single Player Console
                splay.setVisibility(View.GONE);
                mplay.setVisibility(View.GONE);
                splayground.setVisibility(View.VISIBLE);
                back.setText("< Back");
            }
        });

        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Enable Multi Player Console

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Take back to Game Console
                splayground.setVisibility(View.GONE);
                splay.setVisibility(View.VISIBLE);
                mplay.setVisibility(View.VISIBLE);
            }
        });

        colora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set user choosen color
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.parseColor("#ffea00"));
                sword = Color.parseColor("#ffea00");
            }
        });

        colorb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set user choosen color
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.parseColor("#FF4081"));
                sword = Color.parseColor("#FF4081");
            }
        });

        colorc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set user choosen color
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.BLACK);
                sword = Color.BLACK;
            }
        });

        colord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set user choosen color
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.parseColor("#4dd0e1"));
                sword = Color.parseColor("#4dd0e1");
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //generate a random number here for the dicision element
                Random randomGenerator = new Random();
                result = randomGenerator.nextInt(10);
                //Clear ground
                playground.setVisibility(View.GONE);
                CountDownTimer cdt = new CountDownTimer(4000,250) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        //Flicker colors
                        if (check == false)
                        {
                            main.setBackgroundColor(Color.WHITE);
                            check = true;
                        }
                        else
                        {
                            main.setBackgroundColor(sword);
                            check = false;
                        }

                    }

                    @Override
                    public void onFinish() {
                        //Show result
                        if (result%2 != 0)
                        {
                            //If user wins
                            main.setBackgroundColor(sword);
                            updateScore('p');
                            Toast.makeText(userPannel.this,"You Win",Toast.LENGTH_LONG).show();
                            reload("win");
                        }
                        else
                        {
                            //If user looses
                            main.setBackgroundColor(Color.WHITE);
                            updateScore('n');
                            Toast.makeText(userPannel.this,"Oops, You Loose",Toast.LENGTH_LONG).show();
                            reload("loss");
                        }

                    }
                };
                cdt.start();

            }
        });

    }


    //Update Scores for Single Player Mode
    private void updateScore(char r)
    {
        if (r == 'p')
        {
            // Write database code to increment score by 3
        }
        else
        {
            // Write database code to decrement score by 1
        }
    }

    //Intent to result activity
    private void reload(final String status)
    {
        CountDownTimer cdt = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(userPannel.this,result.class);
                intent.putExtra("status",status);
                startActivity(intent);
                finish();
            }
        };
        cdt.start();
    }

    @Override
    public void onBackPressed()
    {
        //To prevent user from going to the previous screen
    }

}
