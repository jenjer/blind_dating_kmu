package Collage_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.University_blind_dating.R;

import java.util.List;

public class Dashboard_adapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private List<String> Community_text;
    private List<String> list_meta_data;
    //todo 이미지 추가할 때 주석 해재  private List<이미지 자료형> image_list;
    private LayoutInflater inflate;
    private Dashboard_adapter.ViewHolder viewHolder;

    //todo 이미지 추가할 때 - 생성자 인자값에 이미지 리스트 추가
    public Dashboard_adapter(List<String> list, Context context, List<String> list_Community_text, List<String> list_meta_data){
        this.list = list;
        this.Community_text = list_Community_text;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
        this.list_meta_data = list_meta_data;
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
            convertView = inflate.inflate(R.layout.row_dashboard,null);

            viewHolder = new Dashboard_adapter.ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.textView_title);
            viewHolder.Community_text = (TextView) convertView.findViewById(R.id.textView_data);
            viewHolder.meta_data = (TextView) convertView.findViewById(R.id.textView_meta_data);
            // todo 여기서 매치시켜서 이미지 넣는다 viewHolder.Profile_view = (ImageView) convertView.findViewById(R.id.imageView_profile);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (Dashboard_adapter.ViewHolder)convertView.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));
        viewHolder.Community_text.setText(Community_text.get(position));
        viewHolder.meta_data.setText(list_meta_data.get(position));
        //todo 이미지 추가 할때 여기서 이미지뷰를 넣어서 리스트뷰 셀에 뿌리는것
        return convertView;
    }

    class ViewHolder{
        public TextView label;
        public TextView Community_text;
        public TextView meta_data;
        // todo 이미지 추가 할 때 주석 삭제 public ImageView Profile_view;
    }

}
