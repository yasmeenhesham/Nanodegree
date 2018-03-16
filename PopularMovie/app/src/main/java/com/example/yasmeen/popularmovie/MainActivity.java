package com.example.yasmeen.popularmovie;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static String MOVIES_DB_API_KEY="1f9d7cb65663cf5777f42919f1730736";
    ArrayList<Movie> movies =new ArrayList<Movie>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public class fetchdata extends AsyncTask<String , Void, List<Movie>>
    {
        public final String TAG=fetchdata.class.getSimpleName();

        @Override
        protected List<Movie> doInBackground(String... strings) {
            String sort_type= strings[0];
            HttpURLConnection urlConnection=null;
            BufferedReader reader = null;
            String jsonObjectStr;
            try {
                URL url= new URL("http://api.themoviedb.org/3/movie/"+sort_type+"?api_key="+MOVIES_DB_API_KEY);
                urlConnection=(HttpURLConnection)url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line=reader.readLine())!=null)
                {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                jsonObjectStr=buffer.toString();
                return getmoviesfromjson(jsonObjectStr);
            }
            catch  (IOException e) {
                Log.e(TAG, "Error ", e);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(TAG, "Error closing stream", e);
                    }
                }
            }


            return null;
        }
        private List<Movie>  getmoviesfromjson(String json) throws JSONException
        {
            JSONObject Jsonmovie= new JSONObject(json);
            JSONArray Jmoviearray= Jsonmovie.getJSONArray("results");

            for (int i=0;i<Jmoviearray.length();i++)
            {
                JSONObject mov=Jmoviearray.getJSONObject(i);
                Movie MOvee= new Movie(mov);
                movies.add(MOvee);
            }
            return movies;
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            if(movies!=null) {
                MovieAdapter.clear();
                for (Movie M:movies_){
                    mMovieAdapter.add(M);
                }
                mMovieAdapter.notifyDataSetChanged();
                movies.clear();
            }

        }
        }
    }
}
