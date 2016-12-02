package ninja.paranoidandroid.services.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import ninja.paranoidandroid.services.receiver.MyWakefulBroadcastReciever;
import ninja.paranoidandroid.services.util.Constants;


public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }


    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(Constants.Action.ACTION_FOO);
        intent.putExtra(Constants.Extra.EXTRA_PARAM1, param1);
        intent.putExtra(Constants.Extra.EXTRA_PARAM2, param2);
        context.startService(intent);
    }


    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(Constants.Action.ACTION_BAZ);
        intent.putExtra(Constants.Extra.EXTRA_PARAM1, param1);
        intent.putExtra(Constants.Extra.EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (Constants.Action.ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(Constants.Extra.EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(Constants.Extra.EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (Constants.Action.ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(Constants.Extra.EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(Constants.Extra.EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }else if(Constants.Action.ACTION_WAKEFUL_SERVICE.equals(action)){
                Intent oldIntent = intent.getParcelableExtra(Constants.Extra.EXTRA_OLD_INTENT);
                Log.i(Constants.Log.LOG_MY_INTENT_SERVICE, "WAKEFUL SERVISE WORKING");
                MyWakefulBroadcastReciever.completeWakefulIntent(intent);
            }
        }
    }


    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
       Log.i(Constants.Log.LOG_MY_INTENT_SERVICE, "Hi i am in handleActionFoo method " + param1 + " " + param2 );
    }


    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
