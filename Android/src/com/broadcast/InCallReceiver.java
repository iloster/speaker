package com.broadcast;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.android.internal.telephony.ITelephony;
import android.R.string;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class InCallReceiver extends BroadcastReceiver {

	private static Object obj;
	private String TAG = "tag"; 
	private TelephonyManager tm; 
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		 tm=(TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
		// test(context, intent);
		switch(tm.getCallState())
		{
		case TelephonyManager.CALL_STATE_RINGING:
			String incomingNumber=intent.getStringExtra("incoming_number");
			//showToast(context, incomingNumber);
			System.out.println("来电:"+incomingNumber);
			/*if(test(context, intent)||isSetting(context, incomingNumber))
				{
				 getStrangCall(incomingNumber, context);
				  endCall();
				}*/
			//如果在黑名单中
			if(isOpenBlack(context)&&isSetting(context, incomingNumber))
			{
			   endCall();
			}
			//如果开启了陌生人拦截
			if(isOpenStranger(context)&&test(context, intent))
			{
				getStrangCall(incomingNumber, context);
				endCall();
			}
			
		//if(incomingNumber.equals("15929916126"))
			/*GetContactProvider getContactProvider=new GetContactProvider();
			if(!getContactProvider.getPhoneNum(context).contains(incomingNumber))
			{
				endCall();
				System.out.println("结果:"+getContactProvider.getPhoneNum(context).contains(incomingNumber));
		      System.out.println("拦截成功");	
			}*/
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
			Log.d("call_state", "offhook");
		case TelephonyManager.CALL_STATE_IDLE:
			//closeToast();
		}
	}
	
	//显示永不关闭的Toast
	public static void showToast(Context context,String msg)
	{
		Toast toast=Toast.makeText(context, msg, Toast.LENGTH_LONG);
		try {
			Field field=toast.getClass().getDeclaredField("mTN");
			field.setAccessible(true);
			obj=field.get(toast);
			Method method=obj.getClass().getDeclaredMethod("show",null);
			method.invoke(obj, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    //关闭Toast信息框
	public static void closeToast()
	{
		if(obj!=null)
		{
			try {
				Method method=obj.getClass().getDeclaredMethod("hide",null);
				method.invoke(obj, null);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	/**
	 * 功能：如果来电不在通讯录当中，就自动挂断电话
	 * 参数:context,intent
	 * 
	 * 不在 true
	 * 在  false
	 * @param context
	 * @param intent
	 */
	private boolean test(Context context, Intent intent) 
	{
		String incomingNumber=intent.getStringExtra("incoming_number");
		//showToast(context, incomingNumber);
		//System.out.println("来电:"+incomingNumber);
	//if(incomingNumber.equals("15929916126"))
		GetContactProvider getContactProvider=new GetContactProvider();
		if(!getContactProvider.getPhoneNum(context).contains(incomingNumber))
		{
			//endCall();
			System.out.println("结果:"+getContactProvider.getPhoneNum(context).contains(incomingNumber));
	        System.out.println("拦截成功"+incomingNumber);	
	        return true;
		}
		else return false;
	}
	/**
	 * 看是否在黑名单中
	 * 
	 */
	private boolean isSetting(Context context,String incomingNumber)
	{
		SharedPreferences settingSP=context.getSharedPreferences("contact_number", context.MODE_PRIVATE);
		return settingSP.contains(incomingNumber);
		
	}
	
	/*
	 * 是否开启了黑名单
	 */
	
	private boolean isOpenBlack(Context context)
	{
		SharedPreferences sp=context.getSharedPreferences("isOpenBlack", Context.MODE_PRIVATE);
		return sp.getBoolean("BlackFlag", false);
		
	}
	/**
	 * 是否开启了陌生人
	 */
	
	private boolean isOpenStranger(Context context)
	{
		SharedPreferences sp=context.getSharedPreferences("isOpenStranger", Context.MODE_PRIVATE);
		return sp.getBoolean("StrangerFlag", false);
		
	}
	/***
	 * 
	 * 
	 */
	private void getStrangCall(String number,Context context)
	{
		 SharedPreferences phonenumSP = context.getSharedPreferences("in_phone_num", Context.MODE_PRIVATE); 
         Editor editor = phonenumSP.edit(); 
         editor.putString(number,number); 
         editor.commit(); 
	}
	///结束通话
	   private void endCall() 
	    { 
	        Class<TelephonyManager> c = TelephonyManager.class;          
	        try 
	        { 
	            Method getITelephonyMethod = c.getDeclaredMethod("getITelephony", (Class[]) null); 
	            getITelephonyMethod.setAccessible(true); 
	            ITelephony iTelephony = null; 
	          //  Log.e(TAG, "End call."); 
	            iTelephony = (ITelephony) getITelephonyMethod.invoke(tm, (Object[]) null); 
	            iTelephony.endCall(); 
	        } 
	        catch (Exception e) 
	        { 
	            Log.e(TAG, "Fail to answer ring call.", e); 
	        }         
	    } 
}
