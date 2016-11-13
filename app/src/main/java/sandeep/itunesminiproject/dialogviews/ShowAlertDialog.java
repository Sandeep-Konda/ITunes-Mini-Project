package sandeep.itunesminiproject.dialogviews;


import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;



public class ShowAlertDialog {
    public static Context mContext;
    private static ShowAlertDialog showAlertDialog;
    public AlertDialog alertDialog;

    public static ShowAlertDialog getInstance()
    {
        if (showAlertDialog==null)
        {
            showAlertDialog=new ShowAlertDialog();
        }
        return showAlertDialog;
    }

    public void showDialog(Context context,String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(context,AlertDialog.THEME_HOLO_LIGHT);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Dismiss",null);
        alertDialog=builder.create();
        alertDialog.show();
    }


}
