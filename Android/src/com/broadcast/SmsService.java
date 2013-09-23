package com.broadcast;


import java.util.List;
import java.util.Map;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class SmsService extends Service
{
	 private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";  
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCreate() {  
        IntentFilter filter = new IntentFilter(ACTION);  
        filter.setPriority(2147483647);  
        SmsReceiver myService = new SmsReceiver();  
        registerReceiver(myService, filter);  
    }  
  

}
