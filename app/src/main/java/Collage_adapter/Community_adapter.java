package Collage_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.University_blind_dating.R;

import java.util.List;

public class Community_adapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private List<String> Community_text;
    private LayoutInflater inflate;
    private Community_adapter.ViewHolder viewHolder;

    public Community_adapter(List<String> list, Context context, List<String> list_Community_text){
        this.list = list;
        this.Community_text = list_Community_text;
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
            convertView = inflate.inflate(R.layout.row_community,null);

            viewHolder = new Community_adapter.ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.Textview_Title);
            viewHolder.Community_text = (TextView) convertView.findViewById(R.id.textview_community_text);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (Community_adapter.ViewHolder)convertView.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));
        viewHolder.Community_text.setText(Community_text.get(position));

        return convertView;
    }

    class ViewHolder{
        public TextView label;
        public TextView Community_text;

    }

}
