package com.tuo.createwechatmenu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tuo.wechat.util.MyDialogUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private static final String APPID = "wx33db9cc9c7fb6067";
	private static final String APPSECRET = "7dba8ba3dfa8ac50eaff87896085815b";
	private static final String PREFRENCE = "my_prefrence";
	private static final String PREFRENCE_ACCESS_TOKEN = "prefrence.access_token";
	private static final String PREFRENCE_ACCESS_TOKEN_EXPIRES = "expires";
	private static final String PREFRENCE_LAST_TIMESTAMP = "last_timestamp";

	SharedPreferences sharedPreferences;
	Context mContext = MainActivity.this;
	ExecutorService executorService = Executors.newCachedThreadPool();
	ProgressDialog progressDialog;

	EditText menu_1Text, menu_2Text, menu_3Text;
	EditText menu_1_urlText, menu_2_urlText, menu_3_urlText;
	EditText subMenu1_1Text, subMenu1_2Text, subMenu1_3Text, subMenu1_4Text, subMenu1_5Text;
	EditText subMenu2_1Text, subMenu2_2Text, subMenu2_3Text, subMenu2_4Text, subMenu2_5Text;
	EditText subMenu3_1Text, subMenu3_2Text, subMenu3_3Text, subMenu3_4Text, subMenu3_5Text;
	EditText subMenu1_1_urlText, subMenu1_2_urlText, subMenu1_3_urlText, subMenu1_4_urlText, subMenu1_5_urlText;
	EditText subMenu2_1_urlText, subMenu2_2_urlText, subMenu2_3_urlText, subMenu2_4_urlText, subMenu2_5_urlText;
	EditText subMenu3_1_urlText, subMenu3_2_urlText, subMenu3_3_urlText, subMenu3_4_urlText, subMenu3_5_urlText;
	Button createButton;

	List<EditText> group1 = new ArrayList<EditText>();
	List<EditText> group2 = new ArrayList<EditText>();
	List<EditText> group3 = new ArrayList<EditText>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sharedPreferences = getApplicationContext().getSharedPreferences(PREFRENCE, PreferenceActivity.MODE_PRIVATE);
		initView();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	void initView() {

		// group 1
		menu_1Text = (EditText) findViewById(R.id.etv_menu_1);
		menu_1_urlText = (EditText) findViewById(R.id.etv_menu_1_url);
		subMenu1_1Text = (EditText) findViewById(R.id.etv_sub_menu_1_1);
		subMenu1_2Text = (EditText) findViewById(R.id.etv_sub_menu_1_2);
		subMenu1_3Text = (EditText) findViewById(R.id.etv_sub_menu_1_3);
		subMenu1_4Text = (EditText) findViewById(R.id.etv_sub_menu_1_4);
		subMenu1_5Text = (EditText) findViewById(R.id.etv_sub_menu_1_5);
		subMenu1_1_urlText = (EditText) findViewById(R.id.etv_sub_menu_1_1_url);
		subMenu1_2_urlText = (EditText) findViewById(R.id.etv_sub_menu_1_2_url);
		subMenu1_3_urlText = (EditText) findViewById(R.id.etv_sub_menu_1_3_url);
		subMenu1_4_urlText = (EditText) findViewById(R.id.etv_sub_menu_1_4_url);
		subMenu1_5_urlText = (EditText) findViewById(R.id.etv_sub_menu_1_5_url);

		group1.add(menu_1Text);
		group1.add(menu_1_urlText);
		group1.add(subMenu1_1Text);
		group1.add(subMenu1_2Text);
		group1.add(subMenu1_3Text);
		group1.add(subMenu1_4Text);
		group1.add(subMenu1_5Text);
		group1.add(subMenu1_1_urlText);
		group1.add(subMenu1_2_urlText);
		group1.add(subMenu1_3_urlText);
		group1.add(subMenu1_4_urlText);
		group1.add(subMenu1_5_urlText);

		// group 2
		menu_2Text = (EditText) findViewById(R.id.etv_menu_2);
		menu_2_urlText = (EditText) findViewById(R.id.etv_menu_2_url);
		subMenu2_1Text = (EditText) findViewById(R.id.etv_sub_menu_2_1);
		subMenu2_2Text = (EditText) findViewById(R.id.etv_sub_menu_2_2);
		subMenu2_3Text = (EditText) findViewById(R.id.etv_sub_menu_2_3);
		subMenu2_4Text = (EditText) findViewById(R.id.etv_sub_menu_2_4);
		subMenu2_5Text = (EditText) findViewById(R.id.etv_sub_menu_2_5);
		subMenu2_1_urlText = (EditText) findViewById(R.id.etv_sub_menu_2_1_url);
		subMenu2_2_urlText = (EditText) findViewById(R.id.etv_sub_menu_2_2_url);
		subMenu2_3_urlText = (EditText) findViewById(R.id.etv_sub_menu_2_3_url);
		subMenu2_4_urlText = (EditText) findViewById(R.id.etv_sub_menu_2_4_url);
		subMenu2_5_urlText = (EditText) findViewById(R.id.etv_sub_menu_2_5_url);

		group2.add(menu_2Text);
		group2.add(menu_2_urlText);
		group2.add(subMenu2_1Text);
		group2.add(subMenu2_2Text);
		group2.add(subMenu2_3Text);
		group2.add(subMenu2_4Text);
		group2.add(subMenu2_5Text);
		group2.add(subMenu2_1_urlText);
		group2.add(subMenu2_2_urlText);
		group2.add(subMenu2_3_urlText);
		group2.add(subMenu2_4_urlText);
		group2.add(subMenu2_5_urlText);
		// group 3
		menu_3Text = (EditText) findViewById(R.id.etv_menu_3);
		menu_3_urlText = (EditText) findViewById(R.id.etv_menu_3_url);
		subMenu3_1Text = (EditText) findViewById(R.id.etv_sub_menu_3_1);
		subMenu3_2Text = (EditText) findViewById(R.id.etv_sub_menu_3_2);
		subMenu3_3Text = (EditText) findViewById(R.id.etv_sub_menu_3_3);
		subMenu3_4Text = (EditText) findViewById(R.id.etv_sub_menu_3_4);
		subMenu3_5Text = (EditText) findViewById(R.id.etv_sub_menu_3_5);
		subMenu3_1_urlText = (EditText) findViewById(R.id.etv_sub_menu_3_1_url);
		subMenu3_2_urlText = (EditText) findViewById(R.id.etv_sub_menu_3_2_url);
		subMenu3_3_urlText = (EditText) findViewById(R.id.etv_sub_menu_3_3_url);
		subMenu3_4_urlText = (EditText) findViewById(R.id.etv_sub_menu_3_4_url);
		subMenu3_5_urlText = (EditText) findViewById(R.id.etv_sub_menu_3_5_url);

		group3.add(menu_3Text);
		group3.add(menu_3_urlText);
		group3.add(subMenu3_1Text);
		group3.add(subMenu3_2Text);
		group3.add(subMenu3_3Text);
		group3.add(subMenu3_4Text);
		group3.add(subMenu3_5Text);
		group3.add(subMenu3_1_urlText);
		group3.add(subMenu3_2_urlText);
		group3.add(subMenu3_3_urlText);
		group3.add(subMenu3_4_urlText);
		group3.add(subMenu3_5_urlText);

		createButton = (Button) findViewById(R.id.btn_create);
		createButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String token = sharedPreferences.getString(PREFRENCE_ACCESS_TOKEN, "");
				long expires = sharedPreferences.getLong(PREFRENCE_ACCESS_TOKEN_EXPIRES, 0);
				long last_timestamp = sharedPreferences.getLong(PREFRENCE_LAST_TIMESTAMP, 0);
				if (TextUtils.isEmpty(token) || (System.currentTimeMillis() - last_timestamp) / 1000 > expires) {
					executorService.execute(new GetAccessTokenRunnable());
				} else {
					executorService.execute(new CreateMenuRunnable(token));
				}

			}
		});
	}

	private JSONObject getJson(List<EditText> editTexts) {
		JSONObject obj = null;
		List<String> click = new LinkedList<String>();
		List<String> view = new LinkedList<String>();
		String firstName = "", firstUrl = "";

		for (EditText t : editTexts) {
			String tag = t.getTag().toString();
			if ("menu_name".equals(tag)) {
				firstName = t.getText().toString();
			}
			if ("menu_url".equals(tag)) {
				firstUrl = t.getText().toString();

			}
			if ("sub_name".equals(tag)) {
				click.add(t.getText().toString());

			}
			if ("sub_url".equals(tag)) {
				view.add(t.getText().toString());
			}
		}

		boolean isSubMenu = false;
		for (String s : click) {
			if (!TextUtils.isEmpty(s)) {
				isSubMenu = true;
				break;
			}

		}
		if (isSubMenu) {
			obj = new JSONObject();
			JSONArray sub = new JSONArray();
			try {
				obj.put("name", firstName);
				for (int i = 0; i < click.size(); i++) {
					String menu_name = click.get(i);
					if (!TextUtils.isEmpty(menu_name)) {
						JSONObject tmp = new JSONObject();
						tmp.put("name", menu_name);
						String menu_url = view.get(i);
						if (TextUtils.isEmpty(menu_url)) {
							tmp.put("type", "click");
							tmp.put("key", menu_name);
						} else {
							tmp.put("type", "view");
							tmp.put("url", menu_url);
						}
						sub.put(tmp);
					}

				}
				obj.put("sub_button", sub);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			if (!TextUtils.isEmpty(firstName)) {
				try {
					obj = new JSONObject();
					obj.put("name", firstName);
					if (firstUrl == null || TextUtils.isEmpty(firstUrl)) {
						obj.put("type", "click");
						obj.put("key", firstName);

					} else {
						obj.put("type", "view");
						obj.put("url", firstUrl);
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return obj;

	}

	class CreateMenuRunnable implements Runnable {
		String token;

		public CreateMenuRunnable(String token) {
			super();
			this.token = token;
		}

		private Handler createHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				progressDialog.dismiss();
				switch (msg.what) {
				case 0:
					String result = (String) msg.obj;
					MyDialogUtils.ShowDialogMessage(mContext, result);
					break;

				default:
					MyDialogUtils.ShowDialogMessage(mContext, "Exception");
					break;
				}
			}

		};

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Looper.prepare();
			String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + token;

			AsyncHttpClient client = new AsyncHttpClient();
			JSONObject post = new JSONObject();
			HttpEntity httpEntity = null;
			try {
				JSONArray tempArray = new JSONArray();
				JSONObject menu1, menu2, menu3;
				menu1 = getJson(group1);
				menu2 = getJson(group2);
				menu3 = getJson(group3);
				if (menu1 != null) {
					tempArray.put(menu1);
				}
				if (menu2 != null) {
					tempArray.put(menu2);
				}
				if (menu3 != null) {
					tempArray.put(menu3);
				}
				post.put("button", tempArray);
				httpEntity = new StringEntity(post.toString(), HTTP.UTF_8);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MyDialogUtils.ShowDialogMessage(mContext, e.getLocalizedMessage());
				createHandler.sendEmptyMessage(1);
				return;

			}

			client.post(mContext, url, httpEntity, "application/json", new AsyncHttpResponseHandler() {

				@Override
				public void onFailure(Throwable arg0, String arg1) {
					// TODO Auto-generated method stub
					progressDialog.dismiss();
					MyDialogUtils.ShowDialogMessage(mContext, arg1);
					super.onFailure(arg0, arg1);
				}

				@Override
				public void onStart() {
					// TODO Auto-generated method stub
					progressDialog = ProgressDialog.show(mContext, null, "please wait...", true, false);
					super.onStart();
				}

				@Override
				public void onSuccess(String arg0) {
					// TODO Auto-generated method stub
					createHandler.obtainMessage(0, -1, -1, arg0).sendToTarget();
					super.onSuccess(arg0);

				}

			});
			Looper.loop();
		}

	}

	class GetAccessTokenRunnable implements Runnable {
		private Handler getHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 0:
					String result = (String) msg.obj;
					try {
						JSONObject json = new JSONObject(result);
						String token = json.getString("access_token");
						long expires_in = json.getLong("expires_in");
						Editor editor = sharedPreferences.edit();
						editor.putString(PREFRENCE_ACCESS_TOKEN, token);
						editor.putLong(PREFRENCE_ACCESS_TOKEN_EXPIRES, expires_in);
						editor.putLong(PREFRENCE_LAST_TIMESTAMP, System.currentTimeMillis());
						editor.commit();
						executorService.execute(new CreateMenuRunnable(token));

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						MyDialogUtils.ShowDialogMessage(mContext, e.getLocalizedMessage());
					}

					break;

				default:
					break;
				}
			}

		};

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Looper.prepare();
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;
			AsyncHttpClient client = new AsyncHttpClient();
			client.get(url, new AsyncHttpResponseHandler() {

				@Override
				public void onFailure(Throwable arg0, String arg1) {
					// TODO Auto-generated method stub
					MyDialogUtils.ShowDialogMessage(mContext, arg1);
					super.onFailure(arg0, arg1);
				}

				@Override
				public void onStart() {
					super.onStart();
				}

				@Override
				public void onSuccess(String arg0) {
					// TODO Auto-generated method stub
					getHandler.obtainMessage(0, -1, -1, arg0).sendToTarget();
					super.onSuccess(arg0);
				}

			});
			Looper.loop();
		}

	}


}
