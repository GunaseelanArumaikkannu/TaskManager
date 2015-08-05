package com.guna.taskmanager;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.guna.taskmanager.dummy.DummyContent;

import java.util.List;

/**
 * Created by Gunaseelan on 06-08-2015.
 */
public class MyListAdapter extends ArrayAdapter<DummyContent.DummyItem> {
    public MyListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public MyListAdapter(Context context, int resource, List<DummyContent.DummyItem> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.items, null);
        }

        DummyContent.DummyItem p = getItem(position);

        if (p != null) {
            ImageView iv1 = (ImageView) v.findViewById(R.id.image);
            TextView tt2 = (TextView) v.findViewById(R.id.time);
            TextView tt3 = (TextView) v.findViewById(R.id.desc);

            if (iv1 != null) {
                iv1.setImageBitmap(BitmapFactory.decodeFile(p.path));
//                iv1.setImageResource(R.mipmap.ic_launcher);
            }

            if (tt2 != null) {
                tt2.setText(p.title);
            }

            if (tt3 != null) {
                tt3.setText(p.description);
            }
        }

        return v;
    }
}
