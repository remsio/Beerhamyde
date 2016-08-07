package exercice.matasse.beerhamyde;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by MATASSE on 07/08/2016.
 */
public class LayoutGameActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        Intent intent = getIntent();
    }


}
