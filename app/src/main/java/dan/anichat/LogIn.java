package dan.anichat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

    }

    public void onButtonClickedLogIn(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
