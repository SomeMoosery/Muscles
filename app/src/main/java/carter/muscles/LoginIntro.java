package carter.muscles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginIntro extends BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "EmailPassword";
    private TextView mStatusTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intro);

        //Views
        mStatusTextView = (TextView) findViewById(R.id.login_intro_description);

        // Buttons
        findViewById(R.id.email_sign_in_button).setOnClickListener(this);
        findViewById(R.id.email_create_account_button).setOnClickListener(this);
        //findViewById(R.id.sign_out_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.email_create_account_button) {
            Intent intent = new Intent(LoginIntro.this, CreateAccount.class);
            startActivity(intent);
            finish();
        }
        else if (i == R.id.email_sign_in_button) {
            Intent intent = new Intent(LoginIntro.this, SignInAccount.class);
            startActivity(intent);
            finish();
        }
    }
}