package com.thl.cleaner.hw;

import com.identity.Shell;

import java.io.UnsupportedEncodingException;

public class CardInfo {
	public String Name;			//姓名
	public String Gender;			//性别
	public String National;			//民族代码
	public String NationalString;	//民族字符串
	public String Birthday;			//出生日期
	public String BirthdayString;	//出生日期字符串
	public String Address;			//住址
	public String IndentityCard;	//身份证号
	public String Issued;			//签发机关
	public String StartDate;		//有效期开始日期
	public String StartDateString;	//有效期开始日期字符串
	public String EndDate;			//有效期结束日期
	public String EndDateString;	//有效期结束日期字符串
	
	public CardInfo(Shell shell, byte[] dataBytes) {
		try {
			Name = shell.GetName(dataBytes);
			Gender = shell.GetGender(dataBytes);
			Address = shell.GetAddress(dataBytes);
			IndentityCard = shell.GetIndentityCard(dataBytes);
			Issued = shell.GetIssued(dataBytes);
			
			National = GetNational(dataBytes);
			NationalString = shell.GetNational(dataBytes);
			
			Birthday = GetBirthday(dataBytes);
			BirthdayString = String.format("%s年%s月%s日", Birthday.substring(0, 4), 
					Birthday.substring(4, 6), Birthday.substring(6, 8));
			
			StartDate = GetStartDate(dataBytes);
			StartDateString = String.format("%s年%s月%s日", StartDate.substring(0, 4), 
					StartDate.substring(4, 6), StartDate.substring(6, 8));
			
			EndDate = GetEndDate(dataBytes);
			EndDateString = String.format("%s年%s月%s日", EndDate.substring(0, 4), 
					EndDate.substring(4, 6), EndDate.substring(6, 8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private String GetBirthday(byte[] data) {
		byte[] birthday = new byte[16];
		String sBirthday = null;
		
		System.arraycopy(data, 36, birthday, 0, 16);
		
		try {
			sBirthday = new String(birthday, "UTF-16LE");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sBirthday;
	}
	
	private String GetStartDate(byte[] data) {
		byte[] start = new byte[16];
		String sStart = null;
		
		System.arraycopy(data, 188, start, 0, 16);
		
		try {
			sStart = new String(start, "UTF-16LE");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sStart;
	}

	private String GetEndDate(byte[] data) {
		byte[] end = new byte[16];
		String sEnd;
		
		System.arraycopy(data, 204, end, 0, 16);
		try {
			sEnd = new String(end, "UTF-16LE");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		
		String mEnd = "";
		String strTem = sEnd.substring(0, 4);
		
		//长期
		if (sEnd.length() < 5)
			mEnd = strTem;
		else
			mEnd = sEnd;
		
		return mEnd;
	}
	
	private String GetNational(byte[] data) {
		byte[] national = new byte[4];
		String sNational = null;
		
		System.arraycopy(data, 32, national, 0, 4);
		try {
			sNational = new String(national, "UTF-16LE");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sNational;
	}
}