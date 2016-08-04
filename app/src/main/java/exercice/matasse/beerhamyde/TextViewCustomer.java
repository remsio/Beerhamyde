package exercice.matasse.beerhamyde;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MATASSE on 01/08/2016.
 */
public class TextViewCustomer extends TextView{


    public TextViewCustomer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/determinationmonoweb-webfont_0.ttf"));
    }
}
