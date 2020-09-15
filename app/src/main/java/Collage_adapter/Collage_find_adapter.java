package Collage_adapter;


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.University_blind_dating.R;
import com.example.University_blind_dating.ui.splash.RegisterActivity;

import org.w3c.dom.Text;

import java.util.List;


public class Collage_find_adapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private List<String> list_Community_text;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;
    public Collage_find_adapter(List<String> list, Context context){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflate.inflate(R.layout.row_collage,null);

            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.textView_row);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }


        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));
        TextView selected = (TextView)convertView.findViewById(R.id.textView_row);
        /*selected.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v ){
                Context mcontext;
                mcontext = RegisterActivity.getContext();
                EditText changetextholder = ((RegisterActivity)mcontext).findViewById(R.id.AutoCompleteTextView_find_collage);
                changetextholder.setText(selected.getText());

            }
        });*/
        return convertView;

    }

    class ViewHolder{
        public TextView label;
    }

}
