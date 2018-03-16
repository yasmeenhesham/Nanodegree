package com.example.android.quakereport;

/**
 * Created by yasmeen on 12/22/2017.
 */

public class Earthquick {
    private String mAgnitude;
    private String location;
    private  String mdate;
    public Earthquick(String m, String l , String d)
    {
        mAgnitude=m;
        location=l;
        mdate=d;

    }

    public String getmAgnitude() {
        return mAgnitude;
    }

    public String getDate() {
        return mdate;
    }

    public String getLocation() {
        return location;
    }
}
