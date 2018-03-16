package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yasmeen on 12/22/2017.
 */

public class EarthquickAdapter extends ArrayAdapter<Earthquick> {

    private static final String LOG_TAG = EarthquickAdapter.class.getSimpleName();

    public EarthquickAdapter( Context context,  List<Earthquick> earthquicks) {
        super(context, 0, earthquicks);
    }
    public View getView(int position, View converView, ViewGroup parent)
    {
        View listitemview= converView;
        if(listitemview==null)
        {
            listitemview= LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquick_list_item,parent,false);
        }
        Earthquick current=getItem(position);
        TextView magnitudev= (TextView)listitemview.findViewById(R.id.magnitude);
        magnitudev.setText(current.getmAgnitude());
        TextView locationv =(TextView)listitemview.findViewById(R.id.location);
        locationv.setText(current.getLocation());
        TextView datev=(TextView)listitemview.findViewById(R.id.mdate);
        datev.setText(current.getDate());
        return listitemview;
    }
}
