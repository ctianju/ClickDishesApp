package com.martin.adapter;

import java.util.ArrayList;

import com.martin.Utils.Utlis;
import com.martin.bean.DishesBean;
import com.martin.clickdishesapp.R;
import com.martin.myapplication.MyApplication;

import android.Manifest.permission;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private static final String TAG = "martin";
	private LayoutInflater flater;
	private Context context;
	private ArrayList<DishesBean> listDish;
	MyApplication app;

	public MyAdapter(MyApplication app, Context context,ArrayList<DishesBean> listDish) {
		this.context = context;
		this.listDish = listDish;
		this.app = app;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listDish.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		Button btn_sub, btn_add, btn_submit;
		EditText et_count;
		ImageView img;
		TextView name, sum_count, tv_Cart;
		TextView price, sum_price;
		TextView SaledShares;
		View v;
		flater = LayoutInflater.from(context);
		v = flater.inflate(R.layout.dish_item, parent, false);

		img = (ImageView) v.findViewById(R.id.iv_dishImg);
		name = (TextView) v.findViewById(R.id.tv_dishName);

		sum_count = (TextView) ((Activity) context).findViewById(R.id.sum_count);
		sum_price = (TextView) ((Activity) context).findViewById(R.id.sum_Price);
		tv_Cart = (TextView) ((Activity) context).findViewById(R.id.tv_Cart);
		btn_submit = (Button) ((Activity) context).findViewById(R.id.btn_submit);

		price = (TextView) v.findViewById(R.id.tv_dishUnitPrice);
		SaledShares = (TextView) v.findViewById(R.id.tv_saledShare);
		btn_add = (Button) v.findViewById(R.id.btn_add);
		btn_sub = (Button) v.findViewById(R.id.btn_sub);
		et_count = (EditText) v.findViewById(R.id.et_count);

		img.setImageResource(listDish.get(position).getImgId());
		name.setText(listDish.get(position).getDishName());
		price.setText(listDish.get(position).getUnitPrice() + "元");
		SaledShares.setText(listDish.get(position).getSaleShares() + "");
		et_count.setText(listDish.get(position).getCount() + "");

		if (app.getSum_count() > -1) {
			Log.i(TAG, app.getSum_count() + "");
			sum_count.setText(+app.getSum_count() + "份");
		}

		sum_price.setText(app.getSum_Price() + "元");

		if ((listDish.get(position)).getLeftButton()) {
			btn_sub.setVisibility(View.VISIBLE);
			et_count.setVisibility(View.VISIBLE);
		}

		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				listDish.get(position).setLeftButton(true);
				int count = listDish.get(position).getCount();
				if (count < 20) {
					int oldCount = app.getSum_count();
					oldCount++;
					app.setSum_count(oldCount);
					count++;
					listDish.get(position).setCount(count);
					float sumPrice = listDish.get(position).getUnitPrice();
					app.setAddSumPrice(sumPrice);
					Log.i(TAG, "Item位置："+position);
				}

				notifyDataSetChanged();
			}
		});

		btn_sub.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				int count = listDish.get(position).getCount();
				if (count >= 1) {
					int oldCount = app.getSum_count();
					oldCount--;
					app.setSum_count(oldCount);
					count--;
					listDish.get(position).setCount(count);
					float sumPrice = listDish.get(position).getUnitPrice();
					app.setSubSumPrice(sumPrice);
				} else {
					listDish.get(position).setLeftButton(false);
				}

				notifyDataSetChanged();

			}
		});

		return v;
	}

	public void addCart() {
		for(int i =0;i<listDish.size();i++){
			Log.i(TAG, "菜名:"+listDish.get(i).getDishName());
			Log.i(TAG, "数量"+listDish.get(i).getCount());
			Log.i(TAG, "单价:"+listDish.get(i).getUnitPrice());
			Log.i(TAG, "附加为:"+listDish.get(i).getSelectName());
			if(listDish.get(i).getCount()>0){
				
				app.setAppList(listDish.get(i));
			}
		}
		notifyDataSetChanged();
	}

}
