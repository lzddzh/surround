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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MsgActivity extends Activity {
		private Button mMsgButton1;
		private Button mMsgButton2;
		private Button mMsgButton3;
		private Button mMsgButton4;
		private ImageView mMsgImg;
		private TextView mMsgTitle;
		private TextView mMsgContent;
		private Context mContext;
		public static final int CANCEL = 0;
		public static final int SEND = 1;
		void findViews() {
			mMsgButton1 = (Button)findViewById(R.id.msg_button_1);
			mMsgButton2 = (Button)findViewById(R.id.msg_button_2);
			mMsgButton3 = (Button)findViewById(R.id.msg_button_3);
			mMsgButton4 = (Button)findViewById(R.id.msg_button_4);
			mMsgImg = (ImageView)findViewById(R.id.msg_img);
			mMsgTitle = (TextView)findViewById(R.id.msg_title);
			mMsgContent = (TextView)findViewById(R.id.msg_content);
			mContext = this;
		}
		
		void init() {
			// TODO Get image, title, content from server.
		}
		
		void setButtonListener() {
			mMsgButton1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//Intent intent = new Intent(MsgActivity.this, MainActivity.class);
					//startActivity(intent);
					finish();
				}
				
			});
			mMsgButton2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					displayToast(R.string.like_msg);
				}
				
			});
			mMsgButton3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(MsgActivity.this, CmtActivity.class);
					startActivityForResult(intent, 0);
				}
				
			});
			mMsgButton4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					displayToast(R.string.next_msg);
				}
				
			});
			
		}
		
		@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_msg);
	        findViews();
	        setButtonListener();
	        init();
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
	    
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    	switch(resultCode) {
	    	case CANCEL:
	    		break;
	    	case SEND:
	    		finish();
	    	default:
	    		break;
	    	}
	    }
	    
	    void displayToast(String str) {
	    	Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
	    }
	    
	    void displayToast(int id) {
	    	Toast.makeText(mContext, id, Toast.LENGTH_SHORT).show();
	    }
}
