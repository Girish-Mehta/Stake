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

    private TextView splay;
    private TextView mplay;
    private TextView go;
    private TextView colora;
    private TextView colorb;
    private TextView colorc;
    private TextView colord;
    private TextView back;
    private LinearLayout splayground;
    private LinearLayout playground;
    private LinearLayout main;
    private int result;
    private int sword;
    private boolean check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pannel);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


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
                // Enable Single Player Mode
                splay.setVisibility(View.GONE);
                mplay.setVisibility(View.GONE);
                splayground.setVisibility(View.VISIBLE);
                back.setText("< Back");
            }
        });

        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Enable Multi Player Mode

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splayground.setVisibility(View.GONE);
                splay.setVisibility(View.VISIBLE);
                mplay.setVisibility(View.VISIBLE);
            }
        });

        colora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.parseColor("#ffea00"));
                sword = Color.parseColor("#ffea00");
            }
        });

        colorb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.parseColor("#FF4081"));
                sword = Color.parseColor("#FF4081");
            }
        });

        colorc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.BLACK);
                sword = Color.BLACK;
            }
        });

        colord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go.setVisibility(View.VISIBLE);
                go.setBackgroundColor(Color.parseColor("#4dd0e1"));
                sword = Color.parseColor("#4dd0e1");
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //generate a random number here
                Random randomGenerator = new Random();
                result = randomGenerator.nextInt(10);
                playground.setVisibility(View.GONE);
                CountDownTimer cdt = new CountDownTimer(4000,500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
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
                        if (result%2 != 0)
                        {
                            main.setBackgroundColor(sword);
                            updateScore('p');
                            Toast.makeText(userPannel.this,"You Win",Toast.LENGTH_LONG).show();
                            reload();
                        }
                        else
                        {
                            main.setBackgroundColor(Color.WHITE);
                            updateScore('n');
                            Toast.makeText(userPannel.this,"Oops, You Loose",Toast.LENGTH_LONG).show();
                            reload();
                        }

                    }
                };
                cdt.start();

            }
        });

    }

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


    private void reload()
    {
        CountDownTimer cdt = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(userPannel.this,userPannel.class);
                startActivity(intent);
                finish();
            }
        };
        cdt.start();
    }

    @Override
    public void onBackPressed()
    {

    }

}
