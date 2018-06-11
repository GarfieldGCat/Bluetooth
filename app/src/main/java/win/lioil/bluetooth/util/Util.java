package win.lioil.bluetooth.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Util {
    private static final String TAG = Util.class.getSimpleName();
    public static final Executor EXECUTOR = Executors.newCachedThreadPool();
    private static WeakReference<Toast> sToastWRF; // Toast弱引用, 避免内存泄漏

    public static void toast(Context context, String txt) {
        if (sToastWRF == null || sToastWRF.get() == null)
            sToastWRF = new WeakReference<>(Toast.makeText(context, txt, Toast.LENGTH_SHORT));
        Toast toast = sToastWRF.get();
        toast.setText(txt);
        toast.show();
    }

    public static void mkdirs(String filePath) {
        boolean mk = new File(filePath).mkdirs();
        Log.d(TAG, "mkdirs: " + mk);
    }
}
