package com.activity;


import java.util.Map;


import packet.test.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;

public class ContactActivity extends Activity
{

	private EditText contact_number;
	private ListView contact_list;
	private Button contact_add;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_activity);
		contact_number=(EditText)findViewById(R.id.contact_number);
		contact_list=(ListView)findViewById(R.id.contact_list);
		contact_add=(Button)findViewById(R.id.contact_add);
		contact_add.setOnClickListener(new addListener());
		get_number();
		contact_list.setOnItemLongClickListener(new setting_listListener());
	}
	
	private void get_number()
	{
		SharedPreferences settingSP=getSharedPreferences("contact_number",Context.MODE_PRIVATE);
		 Map map = settingSP.getAll();
        //  Object[] array = map.keySet().toArray();
       Object[] array=map.keySet().toArray();      
       Log.v("tag",map.toString()+map.size());
          ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_item,array);
         //SimpleAdapter adapter=new SimpleAdapter(this,array,R.layout.list_item,R.id.phone);
          contact_list.setAdapter(adapter);
	}
////////////////////////////////////////////////////////////////////////////
	private class addListener implements OnClickListener
	{

		@Override
		public void onClick(View v) 
		{
			// TODO Auto-generated method stub
			String number=contact_number.getText().toString();
			SharedPreferences settingSP=getSharedPreferences("contact_number", Context.MODE_PRIVATE);
			Editor editor=settingSP.edit();
	        editor.putString(number, number);
	        editor.commit();
	        get_number();
	        contact_number.setText("");
		}
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    private class setting_listListener implements OnItemLongClickListener
    {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3)
		{
			// TODO Auto-generated method stub
			SharedPreferences settingSP=getSharedPreferences("contact_number",Context.MODE_PRIVATE);
			 Map map = settingSP.getAll();
			 Object[] array=map.keySet().toArray();    
			Editor editor=settingSP.edit();
			//Toast.makeText(SettingActivity.this, "a"+array[arg2], Toast.LENGTH_LONG).show();
			editor.remove(array[arg2].toString());
			editor.commit();
			get_number();
			return false;
		}
    }

}
