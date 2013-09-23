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
	            //��ȡintent����
	            Bundle bundle=intent.getExtras();
	            //�ж�bundle����
	            if (bundle!=null)
	            {
	                //ȡpdus����,ת��ΪObject[]
	                Object[] pdus=(Object[])bundle.get("pdus");
	                //��������
	                SmsMessage[] messages = new SmsMessage[pdus.length];
	                for(int i=0;i<messages.length;i++)
	                {
	                    byte[] pdu=(byte[])pdus[i];
	                    messages[i]=SmsMessage.createFromPdu(pdu);
	                }    
	                //���������ݺ�����������
	                for(SmsMessage msg:messages)
	                {
	                    //��ȡ��������
	                    String content=msg.getMessageBody();
	                    //��ȡ��ϵ��
	                    String sender=msg.getOriginatingAddress();
	                    //��ȡʱ��
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
	                    //TODO:���������ж�,Ȼ���һ�㴦��
	                    if ("10086".equals(sender)) 
	                    {
	                    	 
	                          getStrangeSms(context, content, sender, sendTime);
	                          abortBroadcast();
	                    }
	                   // {
	                        // �����ֻ���Ϊ10060�Ķ��ţ����ﻹ����ʱ��һЩ������������Ϣ���͵������˵��ֻ��ȵȡ�
	                        //TODO:����
	                        Toast.makeText(context, "�յ�"+sender+"�Ķ���"+"����:"+content, Toast.LENGTH_LONG).show();
	                        //�����ض�������,ȡ���㲥
	                      //  abortBroadcast();
	                    //}
	                    /*else
	                    {
	                        Toast.makeText(context, "�յ�:"+sender+"����:"+content+"ʱ��:"+sendTime.toString(), Toast.LENGTH_LONG).show();
	                    }*/
	                }
	                 
	            }
	        }//if �жϹ㲥��Ϣ����
	    
	}
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * ����Ϣ�洢����
	 */
	private void getStrangeSms(Context context,String content,String sender,String sendTime)
	{
		SharedPreferences smsSP=context.getSharedPreferences("strange_SMS", context.MODE_PRIVATE);
		Editor editor=smsSP.edit();
		//editor.putString("content", content);
		editor.putString(sender, "�绰����:"+sender+"\n"+"����:"+content+"\n"+"����ʱ��:"+sendTime);
		//editor.putString("sendTime", sendTime);
		editor.commit(); 
	}
///////////////////////////////////////////////////////////////////////////////////////
	/*
	 * �жϵ绰�����Ƿ��ں�������
	 * 
	 */
	private boolean isInBlack(Context context,String sender)
	{
		SharedPreferences settingSP=context.getSharedPreferences("contact_number", context.MODE_PRIVATE);
		return settingSP.contains(sender);
	}
/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * �Ƿ����˺�����
	 */
	private boolean isOpenBlack(Context context)
	{
		SharedPreferences sp=context.getSharedPreferences("isOpenBlack", Context.MODE_PRIVATE);
		return sp.getBoolean("BlackFlag", false);
		
	}
	////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * �Ƿ���ͨѶ¼��
	 */
	private boolean isInContact(Context context,String sender)
	{
		GetContactProvider getContactProvider=new GetContactProvider();
		return !getContactProvider.getPhoneNum(context).contains(sender);	
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * �Ƿ�����İ����ģʽ
	 */
	private boolean isOpenStranger(Context context)
	{
		SharedPreferences sp=context.getSharedPreferences("isOpenStranger", Context.MODE_PRIVATE);
		return sp.getBoolean("StrangerFlag", false);
		
	}
}
