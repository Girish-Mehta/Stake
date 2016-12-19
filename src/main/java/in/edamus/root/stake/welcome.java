package in.edamus.root.stake;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        login = (TextView)findViewById(R.id.register);
        if(login.getVisibility() == View.VISIBLE)
        {
            //Code to register with Google
            login.setVisibility(View.GONE);
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
