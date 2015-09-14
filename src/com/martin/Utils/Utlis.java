package com.martin.Utils;

import java.util.ArrayList;

import com.martin.bean.DishesBean;
import com.martin.clickdishesapp.R;

public class Utlis {

	private static String[] names = { "¶ç½·ÓãÍ·", "ÌÇ´×ÀğÓã", "ÌÇ´×ÅÅ¹Ç", "°××ÆÏº", "¼¦ÌÀâÆâ½", "´óÏºÉÕ°×²Ë", "À±³´¸òòÛ", "ôä´äÏº»·", "ÓãÏãÈâË¿", "¹¬±£¼¦¶¡",
			"ÂéÆÅ¶¹¸¯", "»Ø¹øÈâ", "¶«ÆÂÖâ×Ó", "¹ÖÎ¶¼¦", "°ô°ô¼¦", "Ã°²Ë" };// ²ËÃû

	private static int[] ids = { R.drawable.cai1, R.drawable.cai2, R.drawable.cai3, R.drawable.cai4, R.drawable.cai5,
			R.drawable.cai6, R.drawable.cai7, R.drawable.cai8, R.drawable.cai9, R.drawable.cai10, R.drawable.cai11,
			R.drawable.cai12, R.drawable.cai13, R.drawable.cai14, R.drawable.cai15, R.drawable.cai16, };// ²ËÍ¼Æ¬

	private static float[] prices = { 100.00f, 110.00f, 190.00f, 110.00f, 10.10f, 90.00f, 120.00f, 110.00f, 150.00f,
			1110.00f, 190.00f, 130.00f, 130.00f, 10.00f, 160.00f, 200.00f, };// µ¥¼Û

	public static int saledShares[] = { 2, 2, 100, 12, 3, 4, 56, 213, 12, 5, 67, 8, 3, 1, 24, 6 };// ÒÑ¾­ÊÛ³ö·İÊı


	private static ArrayList<DishesBean> list;

	private Utlis() {

	}

	public static ArrayList<DishesBean> getDishesList() {
		if (list == null) {
			list = new ArrayList<DishesBean>();
			for (int i = 0; i < names.length; i++) {
				list.add(new DishesBean(ids[i], names[i], saledShares[i], prices[i]));
			}
		}
		return list;

	}

}
