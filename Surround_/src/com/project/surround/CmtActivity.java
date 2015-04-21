package com.project.surround;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Comment Activity
public class CmtActivity extends Activity {
		private Button mCancelButton;
		private Button mPostButton;
		private EditText mContent;
		private Context mContext;
		void findViews() {
			mCancelButton = (Button)findViewById(R.id.cmt_cancel);
			mPostButton = (Button)findViewById(R.id.cmt_post);
			mContent = (EditText)findViewById(R.id.cmt_txt);
			mContext = this;
		}
		
		void setButtonListener() {
			mCancelButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(CmtActivity.this, MsgActivity.class);
					setResult(MsgActivity.CANCEL);
					finish();
				}
				
			}); 
			mPostButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String comment = mContent.getText().toString();
					displayToast(R.string.send_cmt);
					setResult(MsgActivity.SEND);
					finish();
				}
				
			});
		}
	
	 	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_cmt);
	        findViews();
	        setButtonListener();
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	    
	    void displayToast(String str) {
	    	Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
	    }
	    
	    void displayToast(int id) {
	    	Toast.makeText(mContext, id, Toast.LENGTH_SHORT).show();
	    }
}
