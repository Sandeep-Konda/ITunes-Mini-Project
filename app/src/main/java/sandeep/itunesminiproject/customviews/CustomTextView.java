package sandeep.itunesminiproject.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import org.w3c.dom.Text;



public class CustomTextView extends TextView{
    public CustomTextView(Context context) {
        super(context);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }
    public void init(Context context)
    {
        Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "helveticalight.ttf");
        setTypeface(myTypeface);
    }
}
