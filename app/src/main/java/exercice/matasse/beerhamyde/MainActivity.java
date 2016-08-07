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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListPlayer.nbPlayer = 0;
        ListPlayer.listPlayer = new ArrayList<String>();


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

       // final TextView dbbTest = (TextView)findViewById(R.id.bddTest);

        //Action action = new Action();



        //dbbTest.setText(action.getAction());
        //dbbTest.invalidate();


    }

    public void startGame(View view) {

        Intent intent = new Intent(this, LayoutGameActivity.class);

    }


}
