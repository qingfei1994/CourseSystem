package com.example;

import android.content.Context;
import android.widget.ImageView;

public class MyImageView extends ImageView {

	private int row;
	private int col;
	public MyImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public void setRow(int row)
	{
		this.row=row;
	}
	public void setCol(int col)
	{
		this.col=col;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}

}
