package to.msn.wings.play_nico;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFE", "onCreate");
    }

    public void btnSend_onClick(View v) {
        Intent i = new Intent(this, SettingActivity.class);
        startActivity(i);
    }

    @Override
    protected void onRestart() {
        Log.d("LIFE", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.d("LIFE", "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("LIFE", "onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d("LIFE", "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("LIFE", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("LIFE", "onDestroy");
        super.onDestroy();
    }
}
