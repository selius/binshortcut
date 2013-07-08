package ru.selius.binshortcut;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class ShortcutActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.shortcut);
		
		getCreateButton().setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View v) {
					Intent shortcutIntent = new Intent("ru.selius.binshortcut.RUN_INTENT");
					shortcutIntent.addCategory(Intent.CATEGORY_DEFAULT);
					shortcutIntent.putExtra("cmd", getCmdEdit().getText().toString());

					Intent intent = new Intent();
					intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
					intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getTextEdit().getText().toString());
//        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
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
