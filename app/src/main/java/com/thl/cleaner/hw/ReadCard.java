package com.thl.cleaner.hw;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.identity.Shell;
import com.identity.globalEnum;
import com.thl.cleaner.app.SPConstant;
import com.thl.cleaner.util.SPUtils;

import java.io.IOException;
import java.util.Calendar;

public class ReadCard {
	private final static String TAG = "ReadCard";
	
	private Context mContext;
	private ReadCardHandler mHandler = new ReadCardHandler();
	private BluetoothDevice mDevice;
	private Shell shell=null;
	private boolean bStop = false;
	private boolean bFind = false;
	
	private GetDataThread mGetDataThread;

	private ReadCardListener mListener;

	private BluetoothAdapter mAdapter;
	private BluetoothReceiver mBtReceiver;
	
	public ReadCard(Context context) {
		IntentFilter filter1, filter2, filter3;
		
		mBtReceiver = new BluetoothReceiver();
		filter1 = new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECTED);
	    filter2 = new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED);
	    filter3 = new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);
	   
	    mContext = context;
	    
	    mContext.registerReceiver(mBtReceiver, filter1);
	    mContext.registerReceiver(mBtReceiver, filter2);
	    mContext.registerReceiver(mBtReceiver, filter3);
	}
	
	public void connect() {
		bStop = false;
		mGetDataThread = new GetDataThread();
		mGetDataThread.start();
	}

	public void disconnect() {
		bStop = true;
		try {
			if (mGetDataThread != null) {
				mGetDataThread.join();
				mGetDataThread = null;
			}
			if(mDevice != null){
				if(shell!=null){
					shell.Destroy();
					shell = null;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setReadCardListener(ReadCardListener listener) {
		mListener = listener;
	}
	
	private void sendMessage(ReadCardStatus status, Object object) {
		Message msg = mHandler.obtainMessage(status.ordinal(), object);
		mHandler.sendMessage(msg);
	}
	
	private boolean findDevice() {
		boolean ret = false;
		mAdapter = BluetoothAdapter.getDefaultAdapter();
		mDevice = mAdapter.getRemoteDevice(SPUtils.getInstance(mContext).getString(SPConstant.mBtMacAddress,"88:1B:99:0A:86:C5"));
		if(mDevice != null) {
			try {
				if (shell == null)
					shell = new Shell(mContext, mDevice);
			} catch (IOException e) {
				e.printStackTrace();
				sendMessage(ReadCardStatus.CreateShellError, null);
				return ret;
			}
		}
		else {
			sendMessage(ReadCardStatus.OpenBTError, null);
		}
		
		try {
			if (shell.Register()) { 
				sendMessage(ReadCardStatus.ReadNumSuccess, null);
				
				globalEnum ge = globalEnum.NONE;
				ge = shell.Init(); 
				if (ge == globalEnum.INITIAL_SUCCESS) {
					sendMessage(ReadCardStatus.ConnectSuccess, null);
					ret = true;
				} else {
					shell.EndCommunication();//0316
					sendMessage(ReadCardStatus.InitError, null);
				}
			}else {
				sendMessage(ReadCardStatus.RegistError, null);
				shell = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	private class ReadCardHandler extends Handler {
		private Bitmap bm;
		private int t_sec1,t_sec2;
		private int t_msec1,t_msec2;
	  
		private Calendar t; 
		
		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(Message msg) {
			ReadCardStatus id = ReadCardStatus.values()[msg.what];
			switch (id) {
			case CreateShellError:
				if (mListener != null)
					mListener.readError("初始化读卡器失败");
				break;
			case OpenBTError:
				if (mListener != null)
					mListener.readError("请打开手机蓝牙");
				break;
			case ReadNumSuccess:
				if (mListener != null)
					mListener.readStatus("读取机具号码成功！");
				break;
			case ConnectSuccess:
				if (mListener != null)
					mListener.readStatus("连接蓝牙设备成功！");
				break;
			case StartFindCard:
				if (mListener != null)
					mListener.readStatus("请将身份证放在读卡器上！");
				break;
			case InitError:
				if (mListener != null)
					mListener.readError("找不到读卡器，请打开读卡器电源或检查蓝牙配置");
				break;
			case ReadInfoSuccess:
				byte[] cardInfoBytes = (byte[])msg.obj;
				if(cardInfoBytes == null){
				}else {	
					t = Calendar.getInstance();
					t_sec2 = t.get(Calendar.SECOND);
					t_msec2 = t.get(Calendar.MILLISECOND);  
					int d = t_sec2-t_sec1;
					int md = t_msec2-t_msec1;
					if(d<0)
						d = d + 60;
					if(md<0){
						d = d -1;
						md = md + 1000;
					}
					Log.d(TAG, "readcard time is:  "+d+"."+md+"s");
					CardInfo cardInfo = new CardInfo(shell, cardInfoBytes);
					if (mListener != null)
						mListener.readInfoSuccess(cardInfo);
				}
				break;
			case ReadPicSuccess:
				bm = (Bitmap) msg.obj;
				mContext.deleteFile("zp.bmp");
				if (mListener != null)
					mListener.readBmpSuccess(bm);
				break; 
			case PicLicenseError:
				if (mListener != null)
					mListener.readError("照片解码授权文件不正确");
				break; 
			case PicDecodeError:
				if (mListener != null)
					mListener.readError("照片原始数据不正确");
				break; 
			case FindCardSuccess:
				if (mListener != null)
					mListener.readStatus("寻卡成功，正在选卡...");
				break; 
			case SelectCardSuccess:
				if (mListener != null)
					mListener.readStatus("选卡成功，正在读卡...");
				break; 	
			case FindCardError:
				//if (mListener != null)
				//	mListener.readError("寻卡错误");
				break; 
			case SelectCardError:
				if (mListener != null)
					mListener.readError("选卡错误");
				break; 
			case ReadInfoError:
				if (mListener != null)
					mListener.readError("读卡错误");
				break;
			default:
				break;
			}
		}
	};
		 
	private class GetDataThread extends Thread {
		private String data;	
		private byte[] cardInfoBytes = new byte[256];		
		private int count = 0 ;
		private String wltPath="";
		private String termBPath="";
		private boolean bRet = false;
		
		public GetDataThread(){
		}        
		
		public void run() {	
			globalEnum ge = globalEnum.GetIndentiyCardData_GetData_Failed;
			
			try {		  
				while (!bStop) {
					//每隔1s钟查找一次设备，如果连接上设备，则进入寻卡过程
					if (!bFind) {
						bFind = findDevice();
						if (bFind) {
							sendMessage(ReadCardStatus.StartFindCard, null);
						} else {
							Thread.sleep(500);
							continue;
						}	
					}
					
					count += 1;  
				    if(count == 10) 
					{
						System.gc(); 
						System.runFinalization(); 
						count = 0;
					}
				    
				    bRet = shell.SearchCard(); 
					if (bRet) {  				
						sendMessage(ReadCardStatus.FindCardSuccess, null);
						
						bRet = shell.SelectCard();
						if(bRet){
							sendMessage(ReadCardStatus.SelectCardSuccess, null);
							
							ge = shell.ReadCard();
							if (ge == globalEnum.GetDataSuccess) {
								data = null;//
								
								cardInfoBytes = shell.GetCardInfoBytes();
								
								Log.d(TAG, String.format(
								        "姓名：%s 性别：%s 民族：%s 出生日期：%s 住址：%s 身份证号：%s 签发机关：%s 有效期：%s-%s",  
								                shell.GetName(cardInfoBytes), shell.GetGender(cardInfoBytes), shell.GetNational(cardInfoBytes), 
								                shell.GetBirthday(cardInfoBytes), shell.GetAddress(cardInfoBytes), 
								                shell.GetIndentityCard(cardInfoBytes), shell.GetIssued(cardInfoBytes), 
								                shell.GetStartDate(cardInfoBytes), shell.GetEndDate(cardInfoBytes)));
								sendMessage(ReadCardStatus.ReadInfoSuccess, cardInfoBytes);
								
								//	Log.w(TAG," shell.GetEndDate(cardInfo) is:"+ shell.GetEndDate(cardInfo));
							 
								// 没有模块号，所以屏蔽
								wltPath="/data/data/"+mContext.getPackageName()+"/files/";
								termBPath="/mnt/sdcard/";
								int nret = shell.GetPic(wltPath,termBPath); 
								
								//wltPath = getFilesDir().getPath()+ "/";
								//int nret = shell.GetPic(wltPath);
								Log.w(TAG,"old GetPic nRet is:"+nret);
								if(nret > 0)
								{
									//Bitmap bm = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/sdseslib/" + "zp.bmp");
									Bitmap bm = BitmapFactory.decodeFile("/data/data/"+mContext.getPackageName()+"/files/zp.bmp");
									sendMessage(ReadCardStatus.ReadPicSuccess, bm);

								}else if(nret == -5)
								{
									sendMessage(ReadCardStatus.PicLicenseError, data);
							  	}else if(nret == -1)
							  	{ 
							  		sendMessage(ReadCardStatus.PicDecodeError, data);					  
							  	} 
								//break;//0316  调试用，所以增加
							}else{
								sendMessage(ReadCardStatus.ReadInfoError, data);//发送消息
							}							
						}else{
							sendMessage(ReadCardStatus.SelectCardError, data);//发送消息			
						}						
					}else{
						sendMessage(ReadCardStatus.FindCardError, data);//发送消息
					}
					Thread.sleep(50);
					
					//如果连接断开，重新查找蓝牙设备
					if(bFind == false && mDevice != null && shell != null){
						shell.Destroy();
						shell = null;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			bStop = false;
		}
	}
	
	private class BluetoothReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
	        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	        //Log.d(TAG, "蓝牙状态改变广播 !");
	        
	        if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) 
	        {
	            Log.d(TAG, "正在断开蓝牙连接。。。");
	        }
	        else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) 
	        {
	            Log.d(TAG, "蓝牙连接已断开！！");
	            bFind = false;
	        }     
		}

	}
}
