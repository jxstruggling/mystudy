package com.example.testslidelistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testslidelistview.SlideListView.RemoveDirection;
import com.example.testslidelistview.SlideListView.RemoveListener;

public class MainActivity extends Activity implements OnItemClickListener{
	private SlideListView mListView;
	private SlideAdapter adapter;
	private List<TestModel> listModels = new ArrayList<TestModel>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adapter = new SlideAdapter();
		mListView = (SlideListView) findViewById(R.id.list);
		mListView.setRemoveListener(new RemoveListener() {
			
			@Override
			public void removeItem(RemoveDirection direction, int position) {
				// TODO Auto-generated method stub
				listModels.remove(position);
				adapter.notifyDataSetChanged();  
		        switch (direction) {  
		        case RIGHT:  
		            Toast.makeText(MainActivity.this, "����ɾ��  "+ position, Toast.LENGTH_SHORT).show();  
		            break;  
		        case LEFT:  
		            Toast.makeText(MainActivity.this, "����ɾ��  "+ position, Toast.LENGTH_SHORT).show();  
		            break;  
		  
		        default:  
		            break;  
		        }  
			}
		});
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
            	convertView = MainActivity.this.getLayoutInflater().inflate(R.layout.layout_main_list_item, null);

                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.time = (TextView) convertView.findViewById(R.id.time);
                holder.content = (TextView) convertView.findViewById(R.id.content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            TestModel item = listModels.get(position);

            holder.title.setText(item.getTitle());
            holder.content.setText(item.getContent());
            holder.time.setText(item.getTime());
            
            return convertView;
        }

    }

    private static class ViewHolder {
        public TextView title;
        public TextView time;
        public TextView content;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
    	Toast.makeText(MainActivity.this, "���" + position, Toast.LENGTH_SHORT).show();
    	Intent it = new Intent();
    	it.setClass(MainActivity.this, ListActivity.class);
    	MainActivity.this.startActivity(it);
    }

}
