package com.martin.myapplication;



import java.util.ArrayList;

import com.martin.bean.DishesBean;

import android.app.Application;

public class MyApplication extends Application {
	private ArrayList<DishesBean> appList = new ArrayList<DishesBean>();
	

	private int sum_count = 0;// 总数量
	public float all_sumPrice=0;// 总价

	public void setSubSumPrice(float price){
		all_sumPrice=all_sumPrice-price;
	}

	public void setAddSumPrice(float price){
		all_sumPrice=all_sumPrice+price;
	}
	
	public float getSum_Price(){
		return all_sumPrice;
	}

	public int getSum_count() {
		return sum_count;
	}

	public void setSum_count(int sum_count) {
		this.sum_count = sum_count;
	}
	public ArrayList<DishesBean> getAppList() {
		return appList;
	}

	public void setAppList(DishesBean entity) {
		if(!appList.contains(entity)){
			this.appList.add(entity);
		}
		
	}

}
