package dan.anichat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;


public class ChatWindow extends AppCompatActivity /*implements GoogleApiClient.OnConnectionFailedListener*/ {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
    }
}
