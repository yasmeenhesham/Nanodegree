package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

//  TODO (1) Create a class called SunshineSyncTask
public class SunshineSyncTask {
//  TODO (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      TODO (3) Within syncWeather, fetch new weather data
//      TODO (4) If we have valid results, delete the old data and insert the new
    synchronized public static void syncWeather(Context context)
    {
        try {
            URL weatheerurl= NetworkUtils.getUrl(context);
            String jsonopject=NetworkUtils.getResponseFromHttpUrl(weatheerurl);
            ContentValues[] cvs= OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context,jsonopject);
            if(cvs !=null && cvs.length!=0)
            {
                ContentResolver sunshineResolver =context.getContentResolver();
                sunshineResolver.delete(WeatherContract.WeatherEntry.CONTENT_URI,null,null);
                sunshineResolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI,cvs);
            }

        }

         catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}