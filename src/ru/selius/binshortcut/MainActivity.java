package ru.selius.binshortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Intent i = getIntent();
		if (i == null)
			return;

		if (!i.getAction().equals(Consts.RUN_INTENT_NAME))
			return;

		String cmd = i.getExtras().getString(Consts.INTENT_EXTRA_CMD);
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
