package dan.anichat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AnimePicker extends AppCompatActivity {

    ListView AnimePickerListView;
    private EditText filterText = null;
    CustomListAdapter adapter = null;

    String[] itemnames ={
            "Gintama",
            "Fullmetal Alchemist: Brotherhood",
            "Steins;Gate",
            "Hunter x Hunter (2011)",
            "Gintama Movie: Kanketsu-hen - Yorozuya yo Eien Nare",
            "Ginga Eiyuu Densetsu",
            "Clannad: After Story",
            "91 Days",
            "Berserk",
            "Mob Psycho 100",
            "Orange",
            "ReLIFE",
            "Shokugeki no Souma: Ni no Sara"
    };

    Integer[] imgids={
            R.mipmap.gintama,
            R.mipmap.fmabrotherhood,
            R.mipmap.steinsgate,
            R.mipmap.hxh,
            R.mipmap.gintamamovie,
            R.mipmap.ginga,
            R.mipmap.clannad,
            R.mipmap.days,
            R.mipmap.berserk,
            R.mipmap.mobpsycho,
            R.mipmap.orange,
            R.mipmap.relife,
            R.mipmap.shokugeki
    };

    ArrayList<Integer> imgid = new ArrayList<>();
    ArrayList<String> itemname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_picker);

        imgid.addAll(Arrays.asList(imgids));
        itemname.addAll(Arrays.asList(itemnames));

        filterText = (EditText) findViewById(R.id.editDynamicSearch);
        filterText.addTextChangedListener(filterTextWatcher);

        adapter=new CustomListAdapter(this, itemname, imgid);
        AnimePickerListView = (ListView) findViewById(R.id.listViewMain);
        AnimePickerListView.setTextFilterEnabled(true);
        AnimePickerListView.setAdapter(adapter);

        AnimePickerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem= itemname.get(position);
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private TextWatcher filterTextWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            if (adapter != null) {
                adapter.getFilter().filter(s.toString());
            } else {
                Log.d("filter", "no filter availible");
            }
        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        filterText.removeTextChangedListener(filterTextWatcher);
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
