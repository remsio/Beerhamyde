package exercice.matasse.beerhamyde;

import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by MATASSE on 07/08/2016.
 */
public class Action {

    private String textShowed;

    public Action(String textShowed){

        this.textShowed = textShowed;

    }

    public Action(){

        this.textShowed = this.getRandomDataBaseSentance();

    }

    public String getAction(){

        return this.textShowed;

    }


    public String getRandomDataBaseSentance(){


        int random = (int) (1 + (Math.random()) * (5-1));

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

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Not implemented
            }
        });



        return appBeerhamyde.toString();

    }




}
