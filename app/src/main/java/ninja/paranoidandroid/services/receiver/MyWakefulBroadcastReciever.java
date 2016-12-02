package ninja.paranoidandroid.services.receiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import ninja.paranoidandroid.services.service.MyIntentService;
import ninja.paranoidandroid.services.util.Constants;

/**
 * Created by anton on 02.12.16.
 */

public class MyWakefulBroadcastReciever extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(Constants.Log.LOG_MY_WAKEFUL_BROADCAST_RECEIVER, "onReceive method");

        Intent startServiceIntent = new Intent(context, MyIntentService.class);
        startServiceIntent.setAction(Constants.Action.ACTION_WAKEFUL_SERVICE);
        startServiceIntent.putExtra(Constants.Extra.EXTRA_OLD_INTENT, intent);

        startWakefulService(context, startServiceIntent);
    }
}
