package ru.selius.binshortcut;

import android.app.*;
import android.content.*;
import android.os.*;
import java.io.*;

import java.lang.Process;
import android.widget.*;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Intent i = getIntent();
		if (i == null)
			return;

		if (!i.getAction().equals("ru.selius.binshortcut.RUN_INTENT"))
			return;

		String cmd = i.getExtras().getString("cmd");
		try {
			getMsgView().setText("Process is running...");
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finish();
		}
    }
	
	private TextView getMsgView() {
		return (TextView) findViewById(R.id.msgView);
	}
}
