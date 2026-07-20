package p6;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.os.Messenger;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class i implements bf.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12970a = "i";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f12971b = cc.a.a("android.app.ActivityOptions");

    @Override // bf.f
    public void a(ActivityOptions activityOptions, int i10) {
        cc.a.j(cc.a.g(f12971b, "setLaunchTaskId", Integer.TYPE), activityOptions, Integer.valueOf(i10));
    }

    @Override // bf.f
    public void b(ActivityOptions activityOptions, int i10) {
        Method methodG = cc.a.g(activityOptions.getClass(), "setStartMultiWindowByRecent", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, activityOptions, Integer.valueOf(i10));
        }
    }

    @Override // bf.f
    public void c(ActivityOptions activityOptions, int i10) {
        cc.a.j(cc.a.g(f12971b, "setLaunchTaskId", Integer.TYPE), activityOptions, Integer.valueOf(i10));
    }

    @Override // bf.f
    public Bundle d() {
        Object objJ = cc.a.j(cc.a.g(f12971b, "toBundle", new Class[0]), null, new Object[0]);
        return objJ instanceof Bundle ? (Bundle) objJ : new Bundle();
    }

    @Override // bf.f
    public void e(boolean z10) {
        cc.a.j(cc.a.g(f12971b, "setDisallowEnterPictureInPictureWhileLaunching", Boolean.TYPE), f12971b, Boolean.valueOf(z10));
    }

    @Override // bf.f
    public ActivityOptions f(Bundle bundle) {
        Object objJ = cc.a.j(cc.a.g(f12971b, "fromBundle", Bundle.class), null, bundle);
        if (objJ instanceof ActivityOptions) {
            return (ActivityOptions) objJ;
        }
        return null;
    }

    @Override // bf.f
    public void g(int i10) {
        cc.a.j(cc.a.g(f12971b, "setRotationAnimationHint", Integer.TYPE), null, Integer.valueOf(i10));
    }

    @Override // bf.f
    public void h(ActivityOptions activityOptions, Messenger messenger, long j10, long j11) {
        Class cls = Long.TYPE;
        Method methodG = cc.a.g(ActivityOptions.class, "setActivitySurfaceShownCallback", Messenger.class, cls, cls);
        if (methodG != null) {
            cc.a.j(methodG, activityOptions, messenger, Long.valueOf(j10), Long.valueOf(j11));
            dc.e.f(f12970a, "setActivitySurfaceShownCallback success");
        }
    }

    @Override // bf.f
    public void i(ActivityOptions activityOptions, boolean z10) {
        Method methodG = cc.a.g(activityOptions.getClass(), "setThunderBackSupport", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, activityOptions, Boolean.valueOf(z10));
        }
    }
}
