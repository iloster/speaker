package com.broadcast;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.R.string;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver
{

	public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		// TODO Auto-generated method stub
		String action = intent.getAction();
	        if (SMS_RECEIVED_ACTION.equals(action))
	        {
	            //获取intent参数
	            Bundle bundle=intent.getExtras();
	            //判断bundle内容
	            if (bundle!=null)
	            {
	                //取pdus内容,转换为Object[]
	                Object[] pdus=(Object[])bundle.get("pdus");
	                //解析短信
	                SmsMessage[] messages = new SmsMessage[pdus.length];
	                for(int i=0;i<messages.length;i++)
	                {
	                    byte[] pdu=(byte[])pdus[i];
	                    messages[i]=SmsMessage.createFromPdu(pdu);
	                }    
	                //解析完内容后分析具体参数
	                for(SmsMessage msg:messages)
	                {
	                    //获取短信内容
	                    String content=msg.getMessageBody();
	                    //获取联系人
	                    String sender=msg.getOriginatingAddress();
	                    //获取时间
	                    Date date = new Date(msg.getTimestampMillis());
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                    String sendTime = sdf.format(date);
	                    if(isOpenBlack(context)&&isInBlack(context, sender))
	                    	abortBroadcast();
	                    if(isOpenStranger(context)&&isInContact(context, sender))
	                    	 {
	                    	   abortBroadcast();
	                          getStrangeSms(context, content, sender, sendTime);
	                    	 }
	                    //TODO:根据条件判断,然后进一般处理
	                    if ("10086".equals(sender)) 
	                    {
	                    	 
	                          getStrangeSms(context, content, sender, sendTime);
	                          abortBroadcast();
	                    }
	                   // {
	                        // 屏蔽手机号为10060的短信，这里还可以时行一些处理，如把这个信息发送到第三人的手机等等。
	                        //TODO:测试
	                        Toast.makeText(context, "收到"+sender+"的短信"+"内容:"+content, Toast.LENGTH_LONG).show();
	                        //对于特定的内容,取消广播
	                      //  abortBroadcast();
	                    //}
	                    /*else
	                    {
	                        Toast.makeText(context, "收到:"+sender+"内容:"+content+"时间:"+sendTime.toString(), Toast.LENGTH_LONG).show();
	                    }*/
	                }
	                 
	            }
	        }//if 判断广播消息结束
	    
	}
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 将信息存储起来
	 */
	private void getStrangeSms(Context context,String content,String sender,String sendTime)
	{
		SharedPreferences smsSP=context.getSharedPreferences("strange_SMS", context.MODE_PRIVATE);
		Editor editor=smsSP.edit();
		//editor.putString("content", content);
		editor.putString(sender, "电话号码:"+sender+"\n"+"内容:"+content+"\n"+"发送时间:"+sendTime);
		//editor.putString("sendTime", sendTime);
		editor.commit(); 
	}
///////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 判断电话号码是否在黑名单中
	 * 
	 */
	private boolean isInBlack(Context context,String sender)
	{
		SharedPreferences settingSP=context.getSharedPreferences("contact_number", context.MODE_PRIVATE);
		return settingSP.contains(sender);
	}
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 是否开启了黑名单
	 */
	private boolean isOpenBlack(Context context)
	{
		SharedPreferences sp=context.getSharedPreferences("isOpenBlack", Context.MODE_PRIVATE);
		return sp.getBoolean("BlackFlag", false);
		
	}
	////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 是否在通讯录中
	 */
	private boolean isInContact(Context context,String sender)
	{
		GetContactProvider getContactProvider=new GetContactProvider();
		return !getContactProvider.getPhoneNum(context).contains(sender);	
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 是否开启了陌生人模式
	 */
	private boolean isOpenStranger(Context context)
	{
		SharedPreferences sp=context.getSharedPreferences("isOpenStranger", Context.MODE_PRIVATE);
		return sp.getBoolean("StrangerFlag", false);
		
	}
}
