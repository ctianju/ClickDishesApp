package com.martin.bean;

public class DishesBean {
	private int imgId;//图片id
	private String dishName;//菜名
	private int saleShares;//出售数量
	private float unitPrice;//单价
	private int count=0;//选择数量
	private boolean leftButton;
	private String selectName="no select";

	

	public String getSelectName() {
		return selectName;
	}

	public void setSelectName(String selectName) {
		this.selectName = selectName;
	}

	public boolean getLeftButton() {
		return leftButton;
	}

	public void setLeftButton(boolean leftButton) {
		this.leftButton = leftButton;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public DishesBean(int imgId, String dishName, int saleShares, float unitPrice) {
		super();
		this.imgId = imgId;
		this.dishName = dishName;
		this.saleShares = saleShares;
		this.unitPrice = unitPrice;
		
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getSaleShares() {
		return saleShares;
	}

	public void setSaleShares(int saleShares) {
		this.saleShares = saleShares;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
}
