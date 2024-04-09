package ro.pub.cs.systems.eim.lab03.practicaltest01var04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String data = null;
        if (Constants.ACTION_NUME.equals(action)) {
            data = intent.getStringExtra(Constants.DATA);
            Log.d("broadcast", "Received nume: " + data);
        }
        if (Constants.ACTION_GRUPA.equals(action)) {
            data = intent.getStringExtra(Constants.DATA);
            Log.d("broadcast", "Received grupa: " + data);
        }
    }
}
