package com.tuo.wechat.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyDialogUtils {

	public static void ShowDialogMessage(Context mContext, String message) {
		new AlertDialog.Builder(mContext).setTitle("ϵͳ��Ϣ").setMessage(message)
				.setNegativeButton("�ر�", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();

					}
				}).show();
	}

}
