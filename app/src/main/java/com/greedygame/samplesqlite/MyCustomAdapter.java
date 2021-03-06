package com.greedygame.samplesqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nikhil on 17/4/17.
 */

public class MyCustomAdapter extends BaseAdapter implements ListAdapter{
    private ArrayList<String> list = new ArrayList<String>();
    private Context context;
    DatabaseHandler myDb;



    public MyCustomAdapter(ArrayList<String> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
        //just return 0 if your list items do not have an Id variable.
    }


    public addItems(ArrayList<String> list,Context context)
    {

        return
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_layout, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));


        //Handle buttons and add onClickListeners
        ImageView deleteBtn = (ImageView) view.findViewById(R.id.btn_delete);
        ImageView editBtn = (ImageView) view.findViewById(R.id.btn_edit);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do somethingdelete from data
                myDb.deleteFood(position);
                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                notifyDataSetChanged();
            }
        });

        return view;
    }

}
