package h8;

import android.app.ActivityManager;
import android.os.IBinder;
import j3.z;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements x9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f5272b = o9.a("android.app.ActivityTaskManager");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f5273c = o9.a("android.app.IActivityTaskManager");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Class f5274d;
    public static final Class e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5275a;

    static {
        o9.a("android.app.ActivityManager");
        f5274d = o9.a("android.os.ServiceManager");
        e = o9.a("android.app.IActivityTaskManager$Stub");
        o9.a("android.window.TaskSnapshot");
    }

    public a() {
        z.f6093b.getApplicationContext();
        this.f5275a = o9.e(null, o9.d(f5272b, "getService", new Class[0]), new Object[0]);
    }

    @Override // x9.a
    public final ActivityManager.RunningTaskInfo a() {
        Class[] clsArr = {Integer.TYPE};
        Object objE = o9.e(this.f5275a, o9.d(f5273c, "getTopTask", clsArr), 0);
        if (objE instanceof ActivityManager.RunningTaskInfo) {
            return (ActivityManager.RunningTaskInfo) objE;
        }
        return null;
    }

    @Override // x9.a
    public final boolean hasMultiWindow() {
        Object objE = o9.e(null, o9.d(e, "asInterface", IBinder.class), o9.e(null, o9.d(f5274d, "getService", String.class), "activity_task"));
        Object objE2 = objE != null ? o9.e(objE, o9.d(objE.getClass(), "hasMultiWindow", new Class[0]), new Object[0]) : null;
        if (objE2 instanceof Boolean) {
            return ((Boolean) objE2).booleanValue();
        }
        return false;
    }

    @Override // x9.a
    public final boolean isSplitScreen() {
        Object obj = this.f5275a;
        if (obj == null) {
            return false;
        }
        Object objE = o9.e(obj, o9.d(obj.getClass(), "isSplitScreen", new Class[0]), new Object[0]);
        if (objE instanceof Boolean) {
            return ((Boolean) objE).booleanValue();
        }
        return false;
    }
}
