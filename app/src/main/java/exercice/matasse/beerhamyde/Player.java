package exercice.matasse.beerhamyde;

/**
 * Created by MATASSE on 07/08/2016.
 */
public class Player {

    private boolean isPlaying;
    private String name;


    public Player(String name){

        this.name = name;
        this.isPlaying = true;

    }

    public String getName(){

        return this.name;

    }

    public boolean isPlaying(){

        return this.isPlaying;

    }




}
