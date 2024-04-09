package ro.pub.cs.systems.eim.lab03.practicaltest01var04;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class ProcessingThread extends Thread {

    private Context context;
    String nume;
    String grupa;

    public ProcessingThread(Context context, String nume, String grupa) {
        this.context = context;
        this.nume = nume;
        this.grupa = grupa;
    }

    @Override
    public void run() {
        while (true) {
            sleep();
            sendMessage(nume, Constants.ACTION_NUME);
            sleep();
            sendMessage(grupa, Constants.ACTION_GRUPA);
        }
    }

    private void sendMessage(String message, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra(Constants.DATA, message);
        Log.d("log", "Service sent " + message);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            Log.e("tag", interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    }

}
