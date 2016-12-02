package ninja.paranoidandroid.services.util;

/**
 * Created by anton on 02.12.16.
 */

public final class Constants {

    private Constants(){

    }

    public static class Log{

        //Log tags
        public final static String LOG_MY_INTENT_SERVICE = "log.MY_INTENT_SERVICE";
        public final static String LOG_MY_BIND_SERVICE = "log.MY_BIND_SERVICE";
        public final static String LOG_MAYN_ACTIVITY = "log.MAIN_ACTIVITY";
        public final static String LOG_MY_WAKEFUL_BROADCAST_RECEIVER = "log.MY_WAKEFUL_RECEIVER";
    }

    public static class Action{
        //Actions
        public static final String ACTION_WAKEFUL_SERVICE = "ninja.paranoidandroid.services.service.action.WAKEFUL_SERVICE";
        public static final String ACTION_FOO = "ninja.paranoidandroid.services.service.action.FOO";
        public static final String ACTION_BAZ = "ninja.paranoidandroid.services.service.action.BAZ";
    }


    public static class Extra{
        //Extras
        public final static String EXTRA_OLD_INTENT = "ninja.paranoidandroid.services.service.extra.OLD_INTENT";
        public static final String EXTRA_PARAM1 = "ninja.paranoidandroid.services.service.extra.PARAM1";
        public static final String EXTRA_PARAM2 = "ninja.paranoidandroid.services.service.extra.PARAM2";
    }

}
