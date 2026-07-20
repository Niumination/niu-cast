package p6;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class s implements bf.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13016a = "s";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f13017b = cc.a.a("android.app.PendingIntent");

    @Override // bf.o
    public Intent a(PendingIntent pendingIntent) {
        Object objJ = cc.a.j(cc.a.g(f13017b, "getIntent", new Class[0]), pendingIntent, new Object[0]);
        if (objJ instanceof Intent) {
            return (Intent) objJ;
        }
        return null;
    }

    @Override // bf.o
    public PendingIntent b(Context context, int i10, Intent intent, int i11, Bundle bundle, UserHandle userHandle) {
        Class<?> cls = f13017b;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "getActivityAsUser", Context.class, cls2, Intent.class, cls2, Bundle.class, UserHandle.class);
        if (methodG != null) {
            return (PendingIntent) cc.a.j(methodG, null, context, Integer.valueOf(i10), intent, Integer.valueOf(i11), bundle, userHandle);
        }
        return null;
    }

    @Override // bf.o
    public PendingIntent c(Context context, int i10, Intent intent, int i11, UserHandle userHandle) {
        Class<?> cls = f13017b;
        Class cls2 = Integer.TYPE;
        return (PendingIntent) cc.a.j(cc.a.g(cls, "getBroadcastAsUser", Context.class, cls2, Intent.class, cls2, UserHandle.class), null, context, Integer.valueOf(i10), intent, Integer.valueOf(i11), userHandle);
    }
}
