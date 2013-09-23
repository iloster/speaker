package com.activity;

import java.util.Map;

import javax.security.auth.PrivateCredentialPermission;

import packet.test.R;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class CallActivity extends Activity
{
private ListView list;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call_activity);
		list=(ListView)findViewById(R.id.list);
		/* SharedPreferences phonenumSP = getSharedPreferences("in_phone_num", Context.MODE_PRIVATE);
	        Map map = phonenumSP.getAll();
	            //  Object[] array = map.keySet().toArray();
	        Object[] array=map.keySet().toArray();      
	        Log.v("tag",map.toString()+map.size());
	              ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_item,array);
	             //SimpleAdapter adapter=new SimpleAdapter(this,array,R.layout.list_item,R.id.phone);
	       list.setAdapter(adapter);*/
		get_number();
	      list.setOnItemLongClickListener(new delCallListener());
	}
////////////////////////////////////////////////////////////////////////////////////////////
	private void get_number()
	{
		 SharedPreferences phonenumSP = getSharedPreferences("in_phone_num", Context.MODE_PRIVATE);
	        Map map = phonenumSP.getAll();
	            //  Object[] array = map.keySet().toArray();
	        Object[] array=map.keySet().toArray();      
	        Log.v("tag",map.toString()+map.size());
	              ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_item,array);
	             //SimpleAdapter adapter=new SimpleAdapter(this,array,R.layout.list_item,R.id.phone);
	       list.setAdapter(adapter);
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	class delCallListener implements OnItemLongClickListener
	{

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		//Toast.makeText(CallActivity.this, "sdd", Toast.LENGTH_SHORT).show();
		SharedPreferences settingSP=getSharedPreferences("in_phone_num",Context.MODE_PRIVATE);
		 Map map = settingSP.getAll();
		 Object[] array=map.keySet().toArray();    
		Editor editor=settingSP.edit();		
		editor.remove(array[arg2].toString());
		editor.commit();
		get_number();
		return false;
	}
		
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
}
