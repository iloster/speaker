package com.activity;

import java.util.Map;

import javax.security.auth.PrivateCredentialPermission;

import packet.test.R;
import packet.test.R.id;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity
{

	private CheckBox black;
	private CheckBox stranger;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_activity);
		black=(CheckBox)findViewById(R.id.black);
		stranger=(CheckBox)findViewById(R.id.stranger);
		get_state();
		black.setOnCheckedChangeListener(new blackListener());
		stranger.setOnCheckedChangeListener(new strangerListener());
	}
	////////////////////////////////////////////////////////////////
private	void get_state()
{
	SharedPreferences sp_black=getSharedPreferences("isOpenBlack", MODE_PRIVATE);
	black.setChecked(sp_black.getBoolean("BlackFlag", true));
	SharedPreferences sp_stranger=getSharedPreferences("isOpenStranger", MODE_PRIVATE);
	stranger.setChecked(sp_stranger.getBoolean("StrangerFlag", true));
}
	////////////////////////////////////////////////////////////////
	class blackListener implements OnCheckedChangeListener
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked)
			{
				SharedPreferences sp=getSharedPreferences("isOpenBlack", Context.MODE_PRIVATE);
				Editor editor=sp.edit();
				editor.putBoolean("BlackFlag", true);
				editor.commit();
				Toast.makeText(SettingActivity.this, "开启黑名单拦截", Toast.LENGTH_SHORT).show();
			}
			else {
				SharedPreferences sp=getSharedPreferences("isOpenBlack", Context.MODE_PRIVATE);
				Editor editor=sp.edit();
				editor.putBoolean("BlackFlag", false);
				editor.commit();
				Toast.makeText(SettingActivity.this, "关闭黑名单拦截", Toast.LENGTH_SHORT).show();
				}
			
		}
		
	}
	///////////////////////////////////////////////////////////////////
	class strangerListener implements OnCheckedChangeListener
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked)
			{
				SharedPreferences sp=getSharedPreferences("isOpenStranger", Context.MODE_PRIVATE);
				Editor editor=sp.edit();
				editor.putBoolean("StrangerFlag", true);
				editor.commit();
				Toast.makeText(SettingActivity.this, "开启陌生人拦截", Toast.LENGTH_SHORT).show();			
			}else {
				SharedPreferences sp=getSharedPreferences("isOpenStranger", Context.MODE_PRIVATE);
				Editor editor=sp.edit();
				editor.putBoolean("StrangerFlag", false);
				editor.commit();
				Toast.makeText(SettingActivity.this, "关闭陌生人拦截", Toast.LENGTH_SHORT).show();	
			}
		}
		
	}
///////////////////////////////////////////////////////////////////////
}
