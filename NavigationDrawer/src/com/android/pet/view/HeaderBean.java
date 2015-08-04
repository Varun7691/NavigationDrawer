package com.android.pet.view;

import java.util.ArrayList;

public class HeaderBean {

	String mHeaderName;
	int mHeaderImage;
	ArrayList<ChildBean> mChildBean;

	public HeaderBean(String mHeaderName, int mHeaderImage,
			ArrayList<ChildBean> mChildBean) {
		super();
		this.mHeaderName = mHeaderName;
		this.mHeaderImage = mHeaderImage;
		this.mChildBean = mChildBean;
	}

	public int getmHeaderImage() {
		return mHeaderImage;
	}

	public void setmHeaderImage(int mHeaderImage) {
		this.mHeaderImage = mHeaderImage;
	}

	public String getmHeaderName() {
		return mHeaderName;
	}

	public void setmHeaderName(String mHeaderName) {
		this.mHeaderName = mHeaderName;
	}

	public ArrayList<ChildBean> getmChildBean() {
		return mChildBean;
	}

	public void setmChildBean(ArrayList<ChildBean> mChildBean) {
		this.mChildBean = mChildBean;
	}

}
