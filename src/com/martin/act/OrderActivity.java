package com.martin.act;

import com.martin.adapter.CartAdapter;
import com.martin.clickdishesapp.R;
import com.martin.myapplication.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends Activity {
	ListView listView;
	CartAdapter adapter;
	MyApplication app;
	TextView tv_allCash;
	Button btn_ok;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart_view);
		setTitle("�ҵĶ���");
		app = (MyApplication) getApplication();
		listView = (ListView) findViewById(R.id.lv_cart);
		tv_allCash = (TextView) findViewById(R.id.tv_AllCash);
		tv_allCash.setText("�ϼƣ�"+app.getSum_Price()+"Ԫ");
		btn_ok = (Button) findViewById(R.id.btn_ok);
		
		
		btn_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(OrderActivity.this,"�ύ�ɹ��������ĵȴ�", Toast.LENGTH_SHORT).show();;
				Intent intent = new Intent(OrderActivity.this,MainActivity.class);
				
				startActivity(intent);
				
			}
		});
		
		adapter = new CartAdapter(this, app.getAppList());
		listView.setAdapter(adapter);
		
	}
}
