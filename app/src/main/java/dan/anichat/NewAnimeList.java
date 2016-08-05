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
import java.util.List;

public class NewAnimeList extends AppCompatActivity {

    ListView newAnimeListView;
    String[] itemnames ={
            "91 Days",
            "Berserk",
            "Mob Psycho 100",
            "Orange",
            "ReLIFE",
            "Shokugeki no Souma: Ni no Sara"
    };

    Integer[] imgids={
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
        setContentView(R.layout.activity_new_anime_list);

        imgid.addAll(Arrays.asList(imgids));
        itemname.addAll(Arrays.asList(itemnames));

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        newAnimeListView = (ListView) findViewById(R.id.listViewNewAnime);
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


    public void onButtonClickedReturnToPicker(View view) {
        Intent intent = new Intent(this, AnimePicker.class);
        startActivity(intent);
    }
}
