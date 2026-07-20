package ic;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranActivityOptions;
import com.transsion.hubsdk.app.TranActivityOptions;

/* JADX INFO: loaded from: classes2.dex */
public class t0 implements bf.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7895c = "t0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranActivityOptions f7896a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITranActivityOptions f7897b = ITranActivityOptions.Stub.asInterface(TranServiceManager.getServiceIBinder("activity_option"));

    @Override // bf.f
    public void a(ActivityOptions activityOptions, int i10) {
        if (this.f7896a == null) {
            this.f7896a = new TranActivityOptions();
        }
        this.f7896a.setLaunchWindowingMode(activityOptions, i10);
    }

    @Override // bf.f
    public void b(ActivityOptions activityOptions, int i10) {
        if (this.f7896a == null) {
            this.f7896a = new TranActivityOptions();
        }
        this.f7896a.setStartMultiWindowByRecent(activityOptions, i10);
    }

    @Override // bf.f
    public void c(ActivityOptions activityOptions, int i10) {
        if (this.f7896a == null) {
            this.f7896a = new TranActivityOptions();
        }
        this.f7896a.setLaunchTaskId(activityOptions, i10);
    }

    @Override // bf.f
    public Bundle d() {
        Bundle bundle = (Bundle) new zb.f().c(new zb.f.b() { // from class: ic.s0
            @Override // zb.f.b
            public final Object run() {
                return this.f7891a.o();
            }
        }, "accessibility_service_info");
        dc.e.f(f7895c, "toBundle bundle:" + bundle);
        return bundle;
    }

    @Override // bf.f
    public void e(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.r0
            @Override // zb.f.b
            public final Object run() {
                return this.f7887a.m(z10);
            }
        }, "accessibility_service_info");
        n0.a("setDisallowEnterPictureInPictureWhileLaunching disallow:", z10, f7895c);
    }

    @Override // bf.f
    public ActivityOptions f(Bundle bundle) {
        if (this.f7896a == null) {
            this.f7896a = new TranActivityOptions();
        }
        return this.f7896a.fromBundle(bundle);
    }

    @Override // bf.f
    public void g(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: ic.q0
            @Override // zb.f.b
            public final Object run() {
                return this.f7881a.n(i10);
            }
        }, "accessibility_service_info");
        dc.e.f(f7895c, "setRotationAnimationHint hint:" + i10);
    }

    @Override // bf.f
    public void h(ActivityOptions activityOptions, Messenger messenger, long j10, long j11) {
        if (this.f7896a == null) {
            this.f7896a = new TranActivityOptions();
        }
        this.f7896a.setActivitySurfaceShownCallback(activityOptions, messenger, j10, j11);
    }

    @Override // bf.f
    public void i(ActivityOptions activityOptions, boolean z10) {
        if (this.f7896a == null) {
            this.f7896a = new TranActivityOptions();
        }
        this.f7896a.setThunderBackSupport(activityOptions, z10);
    }

    public final /* synthetic */ Object m(boolean z10) throws RemoteException {
        ITranActivityOptions iTranActivityOptions = this.f7897b;
        if (iTranActivityOptions == null) {
            return null;
        }
        iTranActivityOptions.setDisallowEnterPictureInPictureWhileLaunching(z10);
        return null;
    }

    public final /* synthetic */ Object n(int i10) throws RemoteException {
        ITranActivityOptions iTranActivityOptions = this.f7897b;
        if (iTranActivityOptions == null) {
            return null;
        }
        iTranActivityOptions.setRotationAnimationHint(i10);
        return null;
    }

    public final /* synthetic */ Object o() throws RemoteException {
        ITranActivityOptions iTranActivityOptions = this.f7897b;
        if (iTranActivityOptions != null) {
            return iTranActivityOptions.toBundle();
        }
        return null;
    }

    @VisibleForTesting
    public void p(ITranActivityOptions iTranActivityOptions) {
        this.f7897b = iTranActivityOptions;
    }
}
