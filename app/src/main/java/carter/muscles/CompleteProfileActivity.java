package carter.muscles;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Timer;
import java.util.TimerTask;

public class CompleteProfileActivity extends AppCompatActivity {

    private String TAG = "UpdateProfile: ";
    private FirebaseUser user;
    private EditText username, email;
    private ImageView profilePhoto, successCheck;
    private Button saveDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        username = (EditText) findViewById(R.id.complete_profile_username);
        email = (EditText) findViewById(R.id.complete_profile_email);
        //ADD PROFILE PHOTO
        saveDataButton = (Button) findViewById(R.id.complete_profile_save);
        successCheck = (ImageView) findViewById(R.id.complete_profile_success_check);

        email.setText(user.getEmail());
        successCheck.setVisibility(View.GONE);
        if(user.getDisplayName() != null){
            username.setText(user.getDisplayName());
        }
        else{
            username.setHint("Enter your name");
        }

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfileChangeRequest saveUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(username.getText().toString())
                        .build();

                user.updateProfile(saveUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    HomePage.homePage.finish();
                                    Log.d(TAG, "User profile updated");
                                    successCheck.setVisibility(View.VISIBLE);

                                    Timer t = new Timer();
                                    t.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            Intent intent = new Intent(CompleteProfileActivity.this, HomePage.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }, 3000);
                                }
                                else{
                                    Log.d(TAG, "User profile not updated");
                                    Intent intent = new Intent(CompleteProfileActivity.this, HomePage.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

            }
        });
    }
}
