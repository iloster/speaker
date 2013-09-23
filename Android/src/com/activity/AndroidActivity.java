package com.activity;

import java.util.Map;

import javax.security.auth.PrivateCredentialPermission;

import packet.test.R;
import android.app.ListActivity;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.ViewDebug.IntToString;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class AndroidActivity extends TabActivity implements OnCheckedChangeListener{
    /** Called when the activity is first created. */
	
	private RadioGroup mainTab;
	private TabHost mainTabHost;
	private RadioButton call,sms,contact,setting;
	//定义一些常量
	final String TAB_TAG_CALL="tab_tag_call";
	final String TAB_TAG_SMS="tab_tag_sms";
	final String TAB_TAG_CONTACT="tab_tag_contact";
	final String TAB_TAG_SETTING="tab_tag_setting";
	//定义一些Intent
	private Intent CallIntent;
	private Intent SmsIntent;
	private Intent ContactIntent;
	private Intent settingIntent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题
        setContentView(R.layout.main);
        init();
        mainTab.setOnCheckedChangeListener(this);
        pre_Intent();
        setup_Intent();
      
    }
    /***
     * 函数:init()
     * 参数:无
     * 作用:初始化各种控件
     * 
     */
    private void init()
    {
    	    	    	
    	mainTab=(RadioGroup)findViewById(R.id.main_tab);//获得RadioGrop控件
    	call=(RadioButton)findViewById(R.id.call);
    	sms=(RadioButton)findViewById(R.id.sms);
    	contact=(RadioButton)findViewById(R.id.contact);   
    	setting=(RadioButton)findViewById(R.id.setting);
    }
    
    
    /***
     * 
     * 函数名：pre_Intent
     * 参数:无
     * 作用:初始化Intent
     * 
     */
    private void pre_Intent()
    {
    	 CallIntent = new Intent(this,CallActivity.class);
    	 SmsIntent = new Intent(this,SmsActivity.class);
    	 ContactIntent = new Intent(this,ContactActivity.class);
    	 settingIntent=new Intent(this,SettingActivity.class);
    	
    }
    
    /***
     * 函数名:setup_Intent()
     * 参数：无
     * 作用:建立tabhost
     * 
     */
    
    private void setup_Intent()
    {
    	this.mainTabHost=getTabHost();
		TabHost localTabHost=this.mainTabHost;
		localTabHost.addTab(buildTabSpec(TAB_TAG_CALL, R.string.main_call, R.drawable.call_normal, CallIntent));
		localTabHost.addTab(buildTabSpec(TAB_TAG_SMS, R.string.main_sms, R.drawable.sms_normal, SmsIntent));
		localTabHost.addTab(buildTabSpec(TAB_TAG_CONTACT, R.string.main_contact, R.drawable.contact_normal, ContactIntent));
		localTabHost.addTab(buildTabSpec(TAB_TAG_SETTING, R.string.main_setting, R.drawable.setting_normal, settingIntent));
		
    }
    
    /***
     *  构建TabHost的Tab页
     * @param tag  标记
     * @param resLabel  标签
     * @param resIcon  该tab展示的内容
     * @param content
     * @return
     */
	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,final Intent content) {
		return this.mainTabHost.newTabSpec(tag).setIndicator(getString(resLabel),
				this.getResources().getDrawable(resIcon)).setContent(content);
	} 
	
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.call:
			this.mainTabHost.setCurrentTabByTag(TAB_TAG_CALL);
			call.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.call_selected,0,0);
			sms.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sms_normal, 0,0);
			contact.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.contact_normal, 0, 0);
			setting.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.setting_normal,0,0);
			break;
		case R.id.sms:
			this.mainTabHost.setCurrentTabByTag(TAB_TAG_SMS);
			call.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.call_normal,0,0);
			sms.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sms_selected, 0,0);
			contact.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.contact_normal, 0, 0);
			setting.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.setting_normal,0,0);
			break;
		case R.id.contact:
			this.mainTabHost.setCurrentTabByTag(TAB_TAG_CONTACT);
			call.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.call_normal,0,0);
			sms.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sms_normal, 0,0);
			contact.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.contact_selected, 0, 0);
			setting.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.setting_normal,0,0);
			break;
		case R.id.setting:
			this.mainTabHost.setCurrentTabByTag(TAB_TAG_SETTING);
			call.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.call_normal,0,0);
			sms.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sms_normal, 0,0);
			contact.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.contact_normal, 0, 0);
			setting.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.setting_pressed,0,0);
			break;
		
		}
	}
}