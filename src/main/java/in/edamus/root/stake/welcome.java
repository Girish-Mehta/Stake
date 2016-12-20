package in.edamus.root.stake;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    SharedPreferences sharedPref;

    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);



        //This not working, either fix it or comment all codes involving coins
        final int coins = 10;
        login = (TextView)findViewById(R.id.register);
        if(login.getVisibility() == View.VISIBLE)
        {
            //Code to register with Google
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Update file with default value of 0 coins
                    sharedPref = getSharedPreferences("Stakefile",MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPref.edit();
                    editor.putInt("coins",coins);
                    editor.commit();
                    login.setVisibility(View.GONE);
                    nextActivity();
                }
            });
        }
        else
        {
            CountDownTimer cdt = new CountDownTimer(2000,500) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    nextActivity();
                }
            };
            cdt.start();
        }
    }

    private void nextActivity()
    {
        Intent intent = new Intent(this,userPannel.class);
        startActivity(intent);
    }
}
