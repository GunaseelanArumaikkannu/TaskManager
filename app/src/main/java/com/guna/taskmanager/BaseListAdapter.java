package com.guna.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.guna.taskmanager.dummy.DummyContent;

import java.util.List;

/**
 * Created by Gunaseelan on 13-08-2015. new Base list adapter
 */
public class BaseListAdapter extends BaseAdapter implements Filterable {

    private List<DummyContent.DummyItem> items;
    private LayoutInflater inflater;

    public BaseListAdapter(Context context, List<DummyContent.DummyItem> items){
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
