package dan.anichat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class TopAnimeList extends AppCompatActivity {

    ListView newAnimeListView;
    String[] itemnames ={
            "Gintama",
            "Fullmetal Alchemist: Brotherhood",
            "Steins;Gate",
            "Hunter x Hunter (2011)",
            "Gintama Movie: Kanketsu-hen - Yorozuya yo Eien Nare",
            "Ginga Eiyuu Densetsu",
            "Clannad: After Story"
    };

    Integer[] imgids={
            R.mipmap.gintama,
            R.mipmap.fmabrotherhood,
            R.mipmap.steinsgate,
            R.mipmap.hxh,
            R.mipmap.gintamamovie,
            R.mipmap.ginga,
            R.mipmap.clannad
    };

    ArrayList<Integer> imgid = new ArrayList<>();
    ArrayList<String> itemname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_anime_list);

        imgid.addAll(Arrays.asList(imgids));
        itemname.addAll(Arrays.asList(itemnames));

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        newAnimeListView = (ListView) findViewById(R.id.listViewTopAnime);
        newAnimeListView.setAdapter(adapter);

        newAnimeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem= itemname.get(position);
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onButtonClickedReturnToPickerFromTop(View view) {
        Intent intent = new Intent(this, AnimePicker.class);
        startActivity(intent);
    }

}

