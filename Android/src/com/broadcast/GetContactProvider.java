package com.broadcast;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

public class GetContactProvider
{
	  ArrayList<String>  getPhoneNum(Context context) { 
	        ArrayList<String> numList = new ArrayList<String>(); 
	        //得到ContentResolver对象     
	        ContentResolver cr = context.getContentResolver();      
	        //取得电话本中开始一项的光标     
	        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);    
	        while (cursor.moveToNext())    
	        {                
	            // 取得联系人ID     
	            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));    
	            Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, 
	                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);    
	            // 取得电话号码(可能存在多个号码)     
	            while (phone.moveToNext())    
	            {    
	                String strPhoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));    
	                numList.add(strPhoneNumber);   
	               // Log.v("tag","strPhoneNumber:"+strPhoneNumber); 
	            }    
	             
	            phone.close();    
	        }    
	        cursor.close(); 
	        return numList; 
	    } 
}
