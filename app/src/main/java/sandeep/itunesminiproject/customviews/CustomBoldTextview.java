package sandeep.itunesminiproject.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class CustomBoldTextview extends TextView{
    public CustomBoldTextview(Context context) {
        super(context);
        init(context);
    }

    public CustomBoldTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomBoldTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomBoldTextview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }
    public void init(Context context)
    {
        Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "helveticabold.ttf");
        setTypeface(myTypeface);
    }
}
