package exercice.matasse.beerhamyde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String CHANGE_TEXT = "com.example.matasse.beerhamyde.CHANGE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chosePlayerLayout(View view){

        EditText editText = (EditText)findViewById(R.id.editText);

        String message = editText.getText().toString();

        Intent intent = new Intent(this, PlayerChoser.class);
        intent.putExtra(CHANGE_TEXT, message);
        startActivity(intent);


    }

}
