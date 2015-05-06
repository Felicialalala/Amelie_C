package com.diandian.coolco.emilie.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.diandian.coolco.emilie.R;


public class ProgressDialog  extends Dialog{
	
	private String messageString = "";

    public static ProgressDialog show(Context context, String messageString){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(messageString);
        progressDialog.show();
        return progressDialog;
    }
	
	public ProgressDialog(Context context) {
		super(context, R.style.progressDialogTheme);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_progress);
		
		TextView hintTextView = (TextView) findViewById(R.id.hint);
		hintTextView.setText(messageString);
		
	    Window window = getWindow();
	    window.setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
	    		WindowManager.LayoutParams.FLAG_DIM_BEHIND);
	    WindowManager.LayoutParams params = window.getAttributes();
//	    params.width = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 0.9);
	    params.alpha = 0.9f;
	    params.dimAmount = 0.5f;
	    window.setAttributes(params);
        setCancelable(false);
        
	}
	
	public void setMessage(String messageString) {
		this.messageString = messageString;
	}
}