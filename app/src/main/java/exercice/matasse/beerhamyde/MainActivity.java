package exercice.matasse.beerhamyde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public final static String CHANGE_TEXT = "com.example.matasse.beerhamyde.CHANGE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int random = (int) (1 + (Math.random()) * (5-1));

        final TextView dbbTest = (TextView)findViewById(R.id.bddTest);

        // Fetch the FirebaseDatabase connection
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Enable DEBUG information in the log
        database.setLogLevel(Logger.Level.DEBUG);

        // Get a reference to the information
        final DatabaseReference appBeerhamyde = database.getReference("beerhamyde").child("" + random);

        // Fetch data from the reference once
        appBeerhamyde.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Fetch the value from the snapshot of the data, as an Integer

                String value =(String) dataSnapshot.getValue();

                dbbTest.setText(value);
                dbbTest.invalidate();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Not implemented
            }
        });


        dbbTest.setText(appBeerhamyde.toString());
        dbbTest.invalidate();


    }

    public void chosePlayerLayout(View view){

        EditText editText = (EditText)findViewById(R.id.editText);

        String message = editText.getText().toString();

        Intent intent = new Intent(this, PlayerChoser.class);
        intent.putExtra(CHANGE_TEXT, message);
        startActivity(intent);


    }

}
