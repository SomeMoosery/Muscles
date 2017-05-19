package carter.muscles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        user = FirebaseAuth.getInstance().getCurrentUser();

        //Timer to ensure the splash screen only displays for 3 seconds
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (user != null){
                    //User is already signed in, take him to the Home Page
                    Intent intent = new Intent(SplashScreen.this, HomePage.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    //User is not signed in, take him to the Login Page
                    Intent intent = new Intent(SplashScreen.this, LoginIntro.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1500);
    }
}
