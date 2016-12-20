package in.edamus.root.stake;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class result extends AppCompatActivity {

    private TextView score;
    private TextView status;
    private TextView space;
    private TextView coin;
    private String stat;
    private String check;
//    private int coins;
//    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

//        sharedPreferences = getSharedPreferences("Stakefile",MODE_PRIVATE);
//        coins = sharedPreferences.getInt("coins", 0);
        //Processing with coins leading to crashing of app with error unable to launch activity caused by Resources not available
        //The same issue in welcome layout
        score = (TextView)findViewById(R.id.score);
        status = (TextView) findViewById(R.id.status);
        space = (TextView) findViewById(R.id.space);
        coin = (TextView) findViewById(R.id.coin);
        check = "win";
        stat = getIntent().getExtras().getString("status");

        if(stat.equals(check))
        {
            //If user wins
//            coins = coins + 3;                                              //update value of coin
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putInt("coins", coins);
//            editor.apply();                                                 //save coins value in sharedpreferences file
            score.setText(getResources().getString(R.string.win));          //update score in activity layout
            status.setText(getResources().getString(R.string.winstatus));   //update status in activity layout
            coin.setText("3");
//            coin.setText(coins);                                            //update coins in activity layout
        }
        else
        {
            //If user looses
//            coins = coins - 3;                                              //update value of coin
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putInt("coins", coins);
//            editor.apply();                                                 //save coins value in sharedpreferences file
            score.setText(getResources().getString(R.string.loss));         //update score in activity layout
            status.setText(getResources().getString(R.string.lossstatus));  //update status in activity layout
            coin.setText("0");
//            coin.setText(coins);                                            //update coins in activity layout
        }


        //Go back to game screen
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result.this,userPannel.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        //To prevent user from going to the previous screen
    }

}
