package com.guna.taskmanager;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.guna.taskmanager.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gunaseelan on 06-08-2015. same
 */
public class MyListAdapter extends ArrayAdapter<DummyContent.DummyItem> {

    private List<DummyContent.DummyItem> items;
    private ItemFilter itemFilter;

    public MyListAdapter(Context context, int resource, List<DummyContent.DummyItem> items) {
        super(context, resource, items);
        this.items = items;
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
            TextView tt2 = (TextView) v.findViewById(R.id.title);
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

    @Override
    public Filter getFilter() {
        if (itemFilter == null) {
            itemFilter = new ItemFilter();
        }
        return itemFilter;
    }

    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            Log.v("App", "constraint - " + constraint.toString());
            if (constraint.length() == 0) {
                results.values = items;
                results.count = items.size();
            } else {
                List<DummyContent.DummyItem> tempItems = new ArrayList<>();
                for (DummyContent.DummyItem item : items) {
                    if (item.title.contains(constraint) || item.description.contains(constraint)) {
                        tempItems.add(item);
                    }
                }
                results.values = tempItems;
                results.count = tempItems.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Log.v("App", results.count + " in publishResults");
            /*if (results.count == 0)
                notifyDataSetInvalidated();
            else {*/

            items = (List<DummyContent.DummyItem>) results.values;
            notifyDataSetChanged();
//            }
        }
    }
}
