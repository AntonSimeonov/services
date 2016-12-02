package ninja.paranoidandroid.services.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import ninja.paranoidandroid.services.util.Constants;

public class MyBindService extends Service {

    //Log
    public final static String TAG = "MyBindService";


    private MyBinder mMyBinder = new MyBinder();

    public MyBindService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMyBinder;
    }

    public class MyBinder extends Binder{

        public MyBindService getService(){
            return MyBindService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(Constants.Log.LOG_MY_BIND_SERVICE, "We are now unbound");
        return super.onUnbind(intent);
    }

    public void writeToLogFromBindService(){
        Log.i(Constants.Log.LOG_MY_BIND_SERVICE, " Im writing to log from service!!!");
    }

}
