package k4;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8927a = "ActivityUtils";

    @Nullable
    public static List<ActivityManager.RunningTaskInfo> a(Context context) {
        return ((ActivityManager) context.getSystemService(ActivityManager.class)).getRunningTasks(1);
    }

    @Nullable
    public static ComponentName b(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty()) {
            return null;
        }
        return runningTasks.get(0).topActivity;
    }

    public static int c(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (Exception e10) {
            m.c(f8927a, "isActivityInFront:" + e10);
            return -1;
        }
    }

    public static boolean d(Context context, String str) {
        try {
            Class<?> cls = Class.forName("com.transsion.splitscreen.SplitScreenManager");
            Object objInvoke = cls.getMethod("isSupported", Context.class).invoke(null, context);
            if (objInvoke == null) {
                return true;
            }
            if (!((Boolean) objInvoke).booleanValue()) {
                m.c(f8927a, "SplitScreenManager is not isSupported");
                return false;
            }
            Object objInvoke2 = cls.getMethod("getInstance", Context.class).invoke(null, context);
            Object objInvoke3 = cls.getMethod("isSupportsSplitScreenMultiWindow", Integer.TYPE, String.class).invoke(objInvoke2, Integer.valueOf(cls.getField("TYPE_PACKAGE").getInt(objInvoke2)), str);
            if (objInvoke3 == null) {
                return true;
            }
            return ((Boolean) objInvoke3).booleanValue();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e10) {
            m.c(f8927a, "isSupportsSplitScreenMultiWindow:" + e10);
            return true;
        }
    }
}
