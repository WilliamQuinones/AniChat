package dan.anichat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnimePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_picker);
    }

    public void onButtonClickedReturnToChat(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onButtonClickedNewAnime(View view) {
        Intent intent = new Intent(this, NewAnimeList.class);
        startActivity(intent);
    }

    public void onButtonClickedTopAnime(View view) {
        Intent intent = new Intent(this, TopAnimeList.class);
        startActivity(intent);
    }
}
