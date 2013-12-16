package com.tuo.wechat.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyDialogUtils {

	public static void ShowDialogMessage(Context mContext, String message) {
		new AlertDialog.Builder(mContext).setTitle("系统消息").setMessage(message)
				.setNegativeButton("关闭", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();

					}
				}).show();
	}

}
