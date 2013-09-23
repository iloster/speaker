package com.activity;

import java.util.Map;

import com.Adapter.SmsAdapter;

import packet.test.R;
import android.R.string;
import android.app.Activity;
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

public class SmsActivity extends Activity
{

	private ListView sms_list;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_activity);
        sms_list=(ListView)findViewById(R.id.sms_list);		
        //SharedPreferences smsSP=getSharedPreferences("strange_SMS", Context.MODE_PRIVATE);
        //String sms_sender=smsSP.getString("sender","");
        //String sms_content=smsSP.getString("content","");
        //String sms_sendTime=smsSP.getString("sendTime","");
       // System.out.println("sender:"+sms_sender+sms_content+sms_sendTime);
        //SmsAdapter smsAdapter=new SmsAdapter(SmsActivity.this, sms_sender, sms_content, sms_sendTime);
        //sms_list.setAdapter(smsAdapter);
       /* Map map = smsSP.getAll();
              Object[] array = map.values().toArray();
              Log.v("tag",map.toString()+map.size());
              ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_item,array);
             //SimpleAdapter adapter=new SimpleAdapter(this,array,R.layout.list_item,R.id.phone);
              sms_list.setAdapter(adapter);*/
        get_number();
        sms_list.setOnItemLongClickListener(new delSmsListener());
        
	}
//////////////////////////////////////////////////////////////////////
	private void get_number()
	{
		 SharedPreferences smsSP=getSharedPreferences("strange_SMS", Context.MODE_PRIVATE);
		  Map map = smsSP.getAll();
          Object[] array = map.values().toArray();
          Log.v("tag",map.toString()+map.size());
          ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_item,array);
         //SimpleAdapter adapter=new SimpleAdapter(this,array,R.layout.list_item,R.id.phone);
          sms_list.setAdapter(adapter);
	}
	////////////////////////////////////////////////////////////////////
	class delSmsListener implements OnItemLongClickListener
	{

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			// TODO Auto-generated method stub
			SharedPreferences settingSP=getSharedPreferences("strange_SMS",Context.MODE_PRIVATE);
			 Map map = settingSP.getAll();
			 Object[] array=map.keySet().toArray();    
			Editor editor=settingSP.edit();		
			editor.remove(array[arg2].toString());
			editor.commit();
			get_number();
			return false;
		}
		
	}
	///////////////////////////////////////////////////////////////////////
	
}
