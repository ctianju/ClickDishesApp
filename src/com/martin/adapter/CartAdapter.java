package com.martin.adapter;

import java.util.ArrayList;

import com.martin.Utils.Utlis;
import com.martin.bean.DishesBean;
import com.martin.clickdishesapp.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CartAdapter extends BaseAdapter {
	private static final String TAG = "martin";
	private Context context;
	private ArrayList<DishesBean> list;
	public CartAdapter(Context context, ArrayList<DishesBean> appList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list=appList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater flater = LayoutInflater.from(context);
		View v = flater.inflate(R.layout.cart_item, null);
		
		TextView dishName,count,unitPrice,selectSoup;
		
		dishName = (TextView) v.findViewById(R.id.tv_cartDishName);
		count = (TextView) v.findViewById(R.id.tv_cartCount);
		unitPrice = (TextView) v.findViewById(R.id.tv_cartUnitPrice);
		selectSoup = (TextView) v.findViewById(R.id.tv_cartSelectName);
	
		
		dishName.setText("主食："+list.get(position).getDishName());
		count.setText("数量："+list.get(position).getCount()+"份");
		unitPrice.setText("单价："+list.get(position).getUnitPrice()+"元");
		selectSoup.setText("附加："+list.get(position).getSelectName());
		return v;
	}
	
	

}
