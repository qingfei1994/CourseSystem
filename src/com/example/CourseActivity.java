package com.example;


import com.example.gridlayoutdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.GridLayout.Spec;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CourseActivity extends Activity implements OnClickListener{

	GridLayout grid;
	int btnNum=60;
	int rowNum=12;
	int colNum=5;
	int[][] press=new int[5][12];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.couse);
		grid=(GridLayout)findViewById(R.id.course);
		for(int i=0;i<=12*5;i++)
		{
			GridLayout.Spec rowSpec=GridLayout.spec(i/6+1);
			GridLayout.Spec colSpec=GridLayout.spec(i%6);
			GridLayout.LayoutParams params=new GridLayout.LayoutParams(rowSpec,colSpec);
			if(i%6!=0)
			{ 
			MyImageView img=new MyImageView(this);
			//img.setBackgroundColor(getResources().getColor(R.color.no_class));
			img.setBackgroundResource(R.drawable.top_bg);
			img.setRow(i/6+1);
			img.setCol(i%6);
			img.setOnClickListener(this);
			grid.addView(img,params);
			}
			else
			{
				TextView tv=new TextView(this);
				tv.setText(i/6+1+"");
				grid.addView(tv,params);
			}
		
			
		 // params.width=
			//params.setGravity(Gravity.FILL);//如果不想要拉伸就不要设置gravity.
		
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v instanceof MyImageView)
		{
			MyImageView myView=(MyImageView)v;
			int row=myView.getRow();
			int col=myView.getCol();
			int press_time=press[col][row];
			press_time++;
			if(press_time>3)
			{
				press_time=0;
			}
			
			switch(press_time)
			{
			case 0:
				myView.setBackgroundResource(R.drawable.top_bg);
				break;
			case 1:
				myView.setBackgroundResource(R.drawable.ic_launcher);
				myView.setAdjustViewBounds(true);
				break;
			case 2:
				myView.setBackgroundResource(R.drawable.back_f);
				myView.setAdjustViewBounds(true);
				break;
			case 3:
				myView.setBackgroundResource(R.drawable.back_n);
				myView.setAdjustViewBounds(true);
				break;
			}
			press[col][row]=press_time;
			Toast.makeText(this, "row="+row+"col="+col+"presstime="+press_time, Toast.LENGTH_SHORT).show();
		}

	}
		
}
