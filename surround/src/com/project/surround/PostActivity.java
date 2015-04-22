package com.project.surround;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PostActivity extends Activity {
		private Context mContext;
		private Button mPostSend;
		private Button mPostCancel;
		private EditText mPostTitle;
		private LineEditText mPostContent;
		private Spinner mPostSpinner;
		private ArrayAdapter mAdapter;
		private int mSpinnerId;
		
		void findViews() {
			mPostSend = (Button)findViewById(R.id.post_send);
			mPostCancel = (Button)findViewById(R.id.post_cancel);
			mPostTitle = (EditText)findViewById(R.id.post_title);
			mPostContent = (LineEditText)findViewById(R.id.post_content);
			mPostSpinner = (Spinner)findViewById(R.id.post_spinner);
			mContext = this;
			mSpinnerId = -1;
			
			mAdapter = ArrayAdapter.createFromResource(mContext, R.array.post_spinner, android.R.layout.simple_spinner_item);
			mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mPostSpinner.setAdapter(mAdapter);
		}
		
		void setSpinnerListener() {
			mPostSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					mSpinnerId = position;
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					mSpinnerId = 0;
				}
				
			});
		}
		
		void setButtonListener() {
			mPostSend.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String title = mPostTitle.getText().toString();
					String content = mPostContent.getText().toString();
					
					displayToast(R.string.send_msg);
					finish();
				}
				
			});
			mPostCancel.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//Intent intent = new Intent(PostActivity.this, MainActivity.class);
					//startActivity(intent);
					finish();
				}
				
			});
		}
		
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_post);
	        findViews();
	        setButtonListener();
	        setSpinnerListener();
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
