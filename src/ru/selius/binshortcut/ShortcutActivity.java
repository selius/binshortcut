package ru.selius.binshortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShortcutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.shortcut);

		getCreateButton().setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent shortcutIntent = new Intent(Consts.RUN_INTENT_NAME);
				shortcutIntent.addCategory(Intent.CATEGORY_DEFAULT);
				shortcutIntent.putExtra(
					Consts.INTENT_EXTRA_CMD, getCmdEdit().getText().toString());

				Intent intent = new Intent();
				intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
				intent.putExtra(
					Intent.EXTRA_SHORTCUT_NAME,
					getTextEdit().getText().toString()
				);
				setResult(RESULT_OK, intent);

				finish();
			}
		});

	}

	private Button getCreateButton() {
		return (Button) findViewById(R.id.createButton);
	}

	private EditText getTextEdit() {
		return (EditText) findViewById(R.id.textEdit);
	}

	private EditText getCmdEdit() {
		return (EditText) findViewById(R.id.cmdEdit);
	}
}
