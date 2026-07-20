package p6;

import android.os.IBinder;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes2.dex */
public class n implements bf.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13005a = "n";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f13006b = cc.a.a("android.os.ServiceManager");

    @Override // bf.i
    public void a(String str) {
        IBinder iBinder = (IBinder) cc.a.j(cc.a.g(f13006b, "getService", String.class), f13006b, NotificationCompat.CATEGORY_ALARM);
        Class clsA = cc.a.a("android.app.IAlarmManager$Stub");
        Object objJ = cc.a.j(cc.a.g(clsA, "asInterface", IBinder.class), clsA, iBinder);
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "cancelPoweroffAlarm", String.class), objJ, str);
        }
    }
}
