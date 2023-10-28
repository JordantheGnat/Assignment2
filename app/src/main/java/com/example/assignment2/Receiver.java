package com.example.assignment2;
//I ripped this from the braodcast reciever example, I am running out of time and it worked when plugged in so


import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            Log.i("SMSReceived", "received sms");
            try {
                if (bundle != null) {
                    final Object[] pdusObj = (Object[]) bundle.get("pdus");
                    String format = bundle.getString("format");

                    for (int i = 0; i < pdusObj.length; i++) {

                        SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);
                        String senderNum = currentMessage.getDisplayOriginatingAddress();
                        String message = currentMessage.getDisplayMessageBody();

                        Log.i("SMSReceived", "senderNum: " + senderNum + "; message: " + message);

                        int duration = Toast.LENGTH_LONG;
                        Toast.makeText(context, "senderNum: " + senderNum + ", message: " + message, duration).show();

                    }
                }
            } catch (Exception e) {
                Log.e("SMSReceived", "Exception on smsReceiver" + e);
            }
        }
    }
}
