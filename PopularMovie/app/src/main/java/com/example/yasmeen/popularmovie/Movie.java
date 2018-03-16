package com.example.yasmeen.popularmovie;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yasmeen on 1/2/2018.
 */

public class Movie {
    private String mTitle , mOverView,mUserRate,mRelaseDate,mPoster;
    public Movie(JSONObject js)throws JSONException
    {
        mTitle=js.getString("original_title");
        mOverView=js.getString("overview");
        mUserRate= js.getString("vote_average");
        mRelaseDate=js.getString("release_date");
        mPoster="http://image.tmdb.org/t/p/w185/" + js.getString("poster_path");;
    }

    public String getmOverView() {
        return mOverView;
    }

    public String getmPoster() {
        return mPoster;
    }

    public String getmRelaseDate() {
        return mRelaseDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmUserRate() {
        return mUserRate;
    }
}
