package com.martin.act;

import java.util.ArrayList;

import com.martin.Utils.Utlis;
import com.martin.adapter.CartAdapter;
import com.martin.adapter.MyAdapter;
import com.martin.bean.DishesBean;
import com.martin.clickdishesapp.R;
import com.martin.myapplication.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
public class MainActivity extends Activity implements android.view.View.OnClickListener{
	protected static final String TAG = "martin";
	private ListView listView;
	private ArrayList<DishesBean> list;
	public MyApplication app;
	public TextView cart;
	public Button btn_submit;
	private MyAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dishes_listview);
		setTitle("请点餐");
		
		list= Utlis.getDishesList();
		listView = (ListView) findViewById(R.id.lv_disheslist);
		
		btn_submit = (Button) findViewById(R.id.btn_submit);
		
		
		app = (MyApplication) this.getApplication();
		adapter = new MyAdapter(app, this,list);
		listView.setAdapter(adapter);

		
	
		btn_submit.setOnClickListener(this);
			
			
		

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "对话框位置："+position);
				showMyDialog(MainActivity.this, position);
			}
		});

	}

	protected void showMyDialog(final Context context, final int position1) {
		// TODO Auto-generated method stub

		View view = LayoutInflater.from(context).inflate(R.layout.my_dialog, null);
		final AlertDialog dialog = new AlertDialog.Builder(context).setTitle("温馨提示(附加赠送可选)")
				.setMessage("您选的主食:" + list.get(position1).getDishName()).setView(view)
				// .setIcon(listDish.get(position).getImgId())
				.setPositiveButton("确定", null).create();

		dialog.show();

		RadioGroup rg = (RadioGroup) view.findViewById(R.id.rg_dialog);
		final Spinner spinner = (Spinner) view.findViewById(R.id.sp_spinner);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			ArrayAdapter<String> adapter;
			private String[] select;

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (checkedId == R.id.rb_soup) {
					select = getResources().getStringArray(R.array.soup);
					adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, select);
				}
				if (checkedId == R.id.rb_drink) {
					select = getResources().getStringArray(R.array.drink);
					adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, select);
				}

				spinner.setAdapter(adapter);
				spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						String dialog_SelectData = (String) spinner.getSelectedItem();
						Log.i(TAG, "dialog位置："+position1);//注意 position是谁的
						list.get(position1).setSelectName(dialog_SelectData);
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		Intent intent = new Intent(this,OrderActivity.class);
		if(id == R.id.btn_submit){
			adapter.addCart();
			startActivity(intent);
		}
		if(id == R.id.tv_Cart){
//			showCartDialog();
		}
		
	}

	
}
