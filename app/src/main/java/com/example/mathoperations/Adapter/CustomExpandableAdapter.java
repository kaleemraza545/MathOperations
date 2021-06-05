package com.example.mathoperations.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.mathoperations.R;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> ListTitle;
    private HashMap<String, List<String>> ListItems;

    public CustomExpandableAdapter(Context context, List<String> listTitle, HashMap<String, List<String>> listItems) {
        this.context = context;
        ListTitle = listTitle;
        ListItems = listItems;
    }

    @Override
    public int getGroupCount() {
        return ListTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ListItems.get(ListTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return ListTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ListItems.get(ListTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String)getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater Inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //convertView = Inflater.inflate(R.layout.list_group,null);
            convertView = LayoutInflater.from(context).inflate(R.layout.list_group,null);
        }
        TextView textView=(TextView)convertView.findViewById(R.id.list_title);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String)getChild(groupPosition,childPosition);
        if(convertView == null)
        {
            LayoutInflater Inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           // convertView = Inflater.inflate(R.layout.list_group,null);
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        }
        TextView textChild=(TextView)convertView.findViewById(R.id.ExpandableListITem);
        textChild.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
