package c8;

import android.content.ComponentName;
import android.content.Context;
import android.service.notification.NotificationListenerService;
import dc.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ng.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1377b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f1378c = cc.a.a("android.service.notification.NotificationListenerService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationListenerService f1379a;

    public a(NotificationListenerService notificationListenerService) {
        this.f1379a = notificationListenerService;
    }

    @Override // ng.a
    public void a(Context context, ComponentName componentName, int i10) {
        try {
            Method methodG = cc.a.g(f1378c, "registerAsSystemService", Context.class, ComponentName.class, Integer.TYPE);
            methodG.setAccessible(true);
            methodG.invoke(this.f1379a, context, componentName, Integer.valueOf(i10));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f1377b, "registerAsSystemService fail:" + e10);
        }
    }

    @Override // ng.a
    public void b() {
        try {
            Method methodG = cc.a.g(f1378c, "unregisterAsSystemService", new Class[0]);
            methodG.setAccessible(true);
            methodG.invoke(this.f1379a, null);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f1377b, "unregisterAsSystemService fail:" + e10);
        }
    }
}
