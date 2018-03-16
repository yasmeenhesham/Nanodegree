package com.example.yasmeen.popularmovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yasmeen on 1/3/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MovieAdapterViewHolder>{

    List<Movie> mmovies;
    Context mcontext;
    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {


        public MovieAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }

    }
