package sandeep.itunesminiproject;

import android.app.Application;

import java.util.ArrayList;

import sandeep.itunesminiproject.DTO.Result;


public class ITunesApplication extends Application{

    public static ITunesApplication iTunesApplication=null;
    public ArrayList<Result> outputResult;

    @Override
    public void onCreate() {
        super.onCreate();
        iTunesApplication=this;
    }
    public static ITunesApplication getInstance()
    {
        if (iTunesApplication==null)
        {
            iTunesApplication=new ITunesApplication();
        }
        return iTunesApplication;
    }
    public ArrayList<Result> getOutputResult() {
        return outputResult;
    }

    public void setOutputResult(ArrayList<Result> outputResult) {
        this.outputResult = outputResult;
    }
}
