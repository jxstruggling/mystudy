package com.example.testslidelistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends Activity implements OnItemClickListener{

	private SlideListView2 mListView;
	private SlideAdapter adapter;
	private List<TestModel> listModels = new ArrayList<TestModel>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		adapter = new SlideAdapter();
		
		mListView = (SlideListView2) this.findViewById(R.id.listview_list);
		mListView.initSlideMode(SlideListView2.MOD_BOTH);
		for (int i = 0; i < 40; i++) {
			TestModel item = new TestModel();
				item.setTitle(i + "��������title");
				item.setContent(i + "������������");
				item.setTime(i + "��������ʱ��");
			listModels.add(item);
		}
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(this);
	}

	private class SlideAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listModels.size();
        }

        @Override
        public Object getItem(int position) {
            return listModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = new ViewHolder();
            if (convertView == null) {
            	convertView = ListActivity.this.getLayoutInflater().inflate(R.layout.layout_list_item, null);

                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.time = (TextView) convertView.findViewById(R.id.time);
                holder.content = (TextView) convertView.findViewById(R.id.content);
                holder.delete1 = (RelativeLayout)convertView.findViewById(R.id.delete1);
                holder.other1 = (RelativeLayout)convertView.findViewById(R.id.other1);
                holder.delete2 = (RelativeLayout)convertView.findViewById(R.id.delete2);
                holder.other2 = (RelativeLayout)convertView.findViewById(R.id.other2);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            TestModel item = listModels.get(position);

            holder.title.setText(item.getTitle());
            holder.content.setText(item.getContent());
            holder.time.setText(item.getTime());
            holder.delete1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//�h������
					Toast.makeText(ListActivity.this, "��ɾ��" + position, Toast.LENGTH_SHORT).show();
					mListView.slideBack();
				}
			});
            holder.other1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(ListActivity.this, "������" + position, Toast.LENGTH_SHORT).show();
					mListView.slideBack();
				}
			});
            holder.delete2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//�h������
					Toast.makeText(ListActivity.this, "��ɾ��" + position, Toast.LENGTH_SHORT).show();
					mListView.slideBack();
				}
			});
            holder.other2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(ListActivity.this, "������" + position, Toast.LENGTH_SHORT).show();
					mListView.slideBack();
				}
			});
            
            return convertView;
        }

    }

    private static class ViewHolder {
        public TextView title;
        public TextView time;
        public TextView content;
        public RelativeLayout delete1;
        public RelativeLayout other1;
        public RelativeLayout delete2;
        public RelativeLayout other2;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
    	Toast.makeText(ListActivity.this, "���" + position, Toast.LENGTH_SHORT).show();
    }

}
