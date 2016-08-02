package dan.anichat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    public static final String ANONYMOUS = "anonymous";

    private static final String TAG = "MainActivity";
    private String mUsername;
    private String mPhotoUrl;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


    }


  public void onButtonClickedLogOut(View v){

      firebaseAuth.signOut();
      firebaseUser = null;
      mUsername = ANONYMOUS;
      mPhotoUrl = null;
      startActivity(new Intent(this, LogIn.class));
      finish();

  }

    public void onButtonClickedChat(View v){
        Intent intent = new Intent(this, ChatWindow.class);
        startActivity(intent);

    }










    public void onButtonClickedAnimePicker(View view) {

        Intent intent = new Intent(this, AnimePicker.class);
        startActivity(intent);
    }

}
