package exercice.matasse.beerhamyde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public final static String CHANGE_TEXT = "com.example.matasse.beerhamyde.CHANGE_TEXT";
    public FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListPlayer.nbPlayer = 0;
        ListPlayer.listPlayer = new ArrayList<String>();
        database.setLogLevel(Logger.Level.DEBUG);

        final ArrayList<String> playerList = new ArrayList<String>();
        Button bt = (Button) findViewById(R.id.add_player);
        ListView lv = (ListView) findViewById(R.id.player_list);
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.adapter_template, playerList);
        lv.setAdapter(adapter);

        assert bt != null;
        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                ListPlayer.nbPlayer ++;

                EditText et = (EditText) findViewById(R.id.editText);
                String msg;
                msg = et.getText().toString();
                playerList.add(ListPlayer.nbPlayer+":"+msg);
                adapter.notifyDataSetChanged();

                et.setText("");
            }
        });


    }

    public void startGame(View view) {


        setContentView(R.layout.game_layout);

        changeTextShowed(database);


        Button button = (Button) findViewById(R.id.new_sentance);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeTextShowed(database);
            }
        });






    }

    public void changeTextShowed(FirebaseDatabase database){

        Action action = new Action();
        final TextView dbbTest = (TextView)findViewById(R.id.bddTest);

        action.getAction(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dbbTest.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                dbbTest.setText("ERROR: CONNEXION CANCELLED");
            }
        }, database);
        dbbTest.invalidate();



    }


}
