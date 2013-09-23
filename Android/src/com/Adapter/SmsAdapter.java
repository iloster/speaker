package com.Adapter;

import packet.test.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SmsAdapter extends BaseAdapter
{

	private Context context;
	private String sms_sender;
	private String sms_content;
	private String sms_sendTime;
	public SmsAdapter(Context context,String sms_sender,String sms_content,String sms_sendTime)
	{
		this.context=context;
		this.sms_sender=sms_sender;
		this.sms_content=sms_content;
		this.sms_sendTime=sms_sendTime;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView=LayoutInflater.from(context).inflate(R.layout.sms_content,null);
		TextView sms_senderTextView=(TextView)convertView.findViewById(R.id.sms_sender);
		TextView sms_contentTextView=(TextView)convertView.findViewById(R.id.sms_content);
		TextView sms_sendTimeTextView=(TextView)convertView.findViewById(R.id.sms_sendTime);
		sms_senderTextView.setText(sms_sender);
		sms_contentTextView.setText(sms_content);
		sms_sendTimeTextView.setText(sms_sendTime);
		
		return convertView;
	}

}
