package exercice.matasse.beerhamyde;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MATASSE on 01/08/2016.
 */
public class PlayerChoser extends Activity{

    public static int nbPlayer = 0;
    public String players[] = new String[10];

    private ListView  playerList = (ListView) findViewById(R.id.player_list);


    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.CHANGE_TEXT);

        //add a player in the table
        players[nbPlayer]= message;

        ArrayAdapter<String> playerAdapter = new ArrayAdapter<String>(this,R.layout.activity_main, players);

        this.nbPlayer++;

        playerList.setAdapter(playerAdapter);

        playerList.invalidate();


    }


}
