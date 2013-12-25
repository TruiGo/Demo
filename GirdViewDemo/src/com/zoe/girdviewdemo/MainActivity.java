package com.zoe.girdviewdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView = (GridView) findViewById(R.id.gridView);
		MyAdapter adapter = new MyAdapter(15, this);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			/*
			 * (arg1�ǵ�ǰitem��view��ͨ�������Ի�ø����еĸ�������� 
           
			 * arg2�ǵ�ǰitem��ID�����id���������������е�д�������Լ����塣 

			 * arg3�ǵ�ǰ��item��listView�е����λ�ã� 
			 */
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(MainActivity.this, "�����"+arg2, Toast.LENGTH_SHORT).show();
			}
		});
	}

	class MyAdapter extends BaseAdapter {
		private int size;
		private LayoutInflater inflater;

		public MyAdapter(int size, Context context) {
			this.size = size;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return size;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout gridView = null;
			if (convertView == null) {
				gridView = (LinearLayout) inflater.inflate(R.layout.grid_item,
						null);
			} else {
				gridView = (LinearLayout) convertView;
			}
			TextView textView = (TextView) gridView
					.findViewById(R.id.text_item);
			textView.setText("" + position);
			return gridView;
		}
	}
}