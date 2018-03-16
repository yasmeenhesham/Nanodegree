package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by yasmeen on 2/24/2018.
 */

public class MasterListFragment extends Fragment {
    public MasterListFragment()
    {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootview=inflater.inflate(R.layout.fragment_master_list,container,false);
        GridView mgridView=(GridView)rootview.findViewById(R.id.gridData);
        MasterListAdapter adapter= new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        mgridView.setAdapter(adapter);
        return rootview;
    }
}
