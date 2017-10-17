package droid.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mht on 16-Oct-17.
 */

public class ServiceDemo extends Service {

    private static final String TAG = "ServiceDemo";
    private static Timer timer = new Timer();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: "+intent.getExtras().getString("one"));
        timer.scheduleAtFixedRate(new MainTask(intent), 0, 5000);
        return START_STICKY;
    }

    private class MainTask extends TimerTask {
        Intent intent;
        public MainTask(Intent intent) {
            this.intent = intent;
        }

        @Override
        public void run() {
            Log.e(TAG, "run: Timer check  "+intent.getExtras().getString("one")+"\n"+intent.getExtras().getString("array"));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}
