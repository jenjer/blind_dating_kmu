package Collage_adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.*;
import com.example.myapplication.ui.splash.RegisterActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Collage_find_adapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    private List<String> Colage_List = null;
    private ArrayList<String> arrayList;
    public Collage_find_adapter(Context context, List<String> Colage_List) {
        this.context = context;
        this.Colage_List = Colage_List;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<String>();
        this.arrayList.addAll(Colage_List);
    }

    public class ViewHolder {
        TextView tv_name;
    }

    @Override
    public int getCount() {
        return Colage_List.size();
    }

    @Override
    public String getItem(int position) {
        return Colage_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        final String Collage = Colage_List.get(position);

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_collage, null);
            // Locate the TextViews in listview_item.xml
            holder.tv_name = (TextView) view.findViewById(R.id.textView_row);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.tv_name.setText(Collage);

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, RegisterActivity.class);;
                context.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        Colage_List.clear();
        if (charText.length() == 0) {
            Colage_List.addAll(arrayList);
        } else {
            for (String potion : arrayList) {
//                String name = context.getResources();
 //               if (name.toLowerCase().contains(charText)) {
                    Colage_List.add(potion);
                }
            }
        }
  //      notifyDataSetChanged();
}


