package p6;

import android.app.NotificationChannel;
import androidx.core.app.NotificationManagerCompat;

/* JADX INFO: loaded from: classes2.dex */
public class q implements bf.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13010a = "q";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f13011b = cc.a.a("android.app.NotificationChannel");

    @Override // bf.m
    public int a(NotificationChannel notificationChannel) {
        Object objJ = cc.a.j(cc.a.g(notificationChannel.getClass(), "getOriginalImportance", new Class[0]), notificationChannel, new Object[0]);
        return objJ != null ? ((Integer) objJ).intValue() : NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
    }

    @Override // bf.m
    public void b(NotificationChannel notificationChannel, int i10) {
        cc.a.j(cc.a.g(f13011b, "lockFields", Integer.TYPE), notificationChannel, Integer.valueOf(i10));
    }
}
