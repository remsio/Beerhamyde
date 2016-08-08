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

    private String type;

    public static int lastId = 0;

    public Action(String textShowed){

        this.textShowed = textShowed;

    }

    public Action(){
        this.type = this.getSentanceType();

    }

    public void getAction(ValueEventListener valueEventListener, FirebaseDatabase database){
        getRandomDataBaseSentance(valueEventListener, database);
    }


    public void getRandomDataBaseSentance(ValueEventListener eventListener, FirebaseDatabase database){

        int random;

        do{
           random = (int) (1 + (Math.random()) * (5-1));
        }while (Action.lastId == random);
        Action.lastId = random;



        // Get a reference to the information
        final DatabaseReference appBeerhamyde = database.getReference("beerhamyde").child("" + random);

        // Fetch data from the reference once
        appBeerhamyde.addListenerForSingleValueEvent(eventListener);


    }


    public String getSentanceType(){

        return "CHALLENGE";

    }



}
