package com.iof.school.parser;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.iof.school.utils.Const;
import com.iof.showlib.utils.TaskBase.Parser;

public class ParserLoginChild implements Parser
{
	public int mResult = 100;
	public int mId;
	public String mPsw;
	
	public void setInfo(int id, String psw)
	{
		mId = id;
		mPsw = psw;
	}

	@Override
	public String getUrl()
	{
		return Const.URL_LOGIN_CHILD;
	}

	@Override
	public String getParam()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("childId=");
		sb.append(mId);
		sb.append("&password=");
		sb.append(mPsw);
		return sb.toString();
	}

	@Override
	public void parserJson(String json) throws JSONException
	{
		//System.out.println("-----------------------------json=" + json);
		JSONTokener jTokener = new JSONTokener(json);
		JSONObject jObject = (JSONObject) jTokener.nextValue();
		mResult = jObject.getInt("code");
	}
}
