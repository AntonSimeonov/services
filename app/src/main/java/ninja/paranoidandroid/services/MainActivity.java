package ninja.paranoidandroid.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ninja.paranoidandroid.services.receiver.MyWakefulBroadcastReciever;
import ninja.paranoidandroid.services.service.MyBindService;
import ninja.paranoidandroid.services.service.MyIntentService;
import ninja.paranoidandroid.services.util.Constants;

public class MainActivity extends AppCompatActivity {


    //UI
    private Button mRefreshButton;
    private Button mUnbindButton;

    //Service interface
    private MyBindService myBindService;


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBindService.MyBinder myBinder = (MyBindService.MyBinder) iBinder;
            myBindService = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myBindService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startMyIntentService();
        startMyWakefulBroadcastReciever();
        //bindToMyBindService();

        initUI();
        initUIListeners();
    }

    private void initUI(){

        mRefreshButton = (Button) findViewById(R.id.b_activity_main_bind_service_refresher);
        mUnbindButton = (Button) findViewById(R.id.b_activity_main_unbind);

    }

    private void initUIListeners(){
        mRefreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(myBindService != null){
                    myBindService.writeToLogFromBindService();
                }else{

                    Log.i(Constants.Log.LOG_MAYN_ACTIVITY, " stop pushing the button you are now unbid from the service deal with it!!!");
                }

            }
        });

        mUnbindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myBindService != null){
                    unbindService(mServiceConnection);
                    myBindService = null;
                }else{
                    Log.i(Constants.Log.LOG_MAYN_ACTIVITY, "you cant unbind more then onece from a service. STOP!!!");
                }

            }
        });

    }

    //Bind to service
    private void bindToMyBindService(){
        Intent intent = new Intent(this, MyBindService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    private void startMyIntentService(){
        MyIntentService.startActionFoo(this, "Perl", "jam");
    }

    private void startMyWakefulBroadcastReciever(){

        Log.i(Constants.Log.LOG_MAYN_ACTIVITY, " startMyWakefulBroadcastReciever method");

        Intent intent = new Intent(this, MyWakefulBroadcastReciever.class);
        sendBroadcast(intent);
//        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
//        localBroadcastManager.sendBroadcast(intent);

    }
}
