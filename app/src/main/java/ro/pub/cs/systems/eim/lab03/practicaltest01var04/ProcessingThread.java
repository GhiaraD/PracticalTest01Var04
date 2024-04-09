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
            sendMessage(nume);
            sleep();
            sendMessage(grupa);
        }
    }

    private void sendMessage(String message) {
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_STRING);
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
