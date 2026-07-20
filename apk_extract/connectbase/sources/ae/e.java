package ae;

import android.os.RemoteException;
import com.transsion.hubsdk.TranContext;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.pq.ITranPictureQuality;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class e implements ug.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f208c = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranPictureQuality f209a = ITranPictureQuality.Stub.asInterface(TranServiceManager.getServiceIBinder("picture_quality"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranContext f210b;

    @Override // ug.a
    public void a(final int i10) {
        new f().c(new f.b() { // from class: ae.b
            @Override // zb.f.b
            public final Object run() {
                return this.f202a.o(i10);
            }
        }, "picture_quality");
    }

    @Override // ug.a
    public void b(final int i10) {
        new f().c(new f.b() { // from class: ae.d
            @Override // zb.f.b
            public final Object run() {
                return this.f206a.p(i10);
            }
        }, "picture_quality");
    }

    @Override // ug.a
    public void c(final boolean z10) {
        new f().c(new f.b() { // from class: ae.c
            @Override // zb.f.b
            public final Object run() {
                return this.f204a.m(z10);
            }
        }, "picture_quality");
    }

    @Override // ug.a
    public int d() {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality == null) {
            return 0;
        }
        try {
            return iTranPictureQuality.getPictureMode();
        } catch (RemoteException e10) {
            j7.b.a("getPictureMode fail:", e10, f208c);
            return 0;
        }
    }

    @Override // ug.a
    public void e(int i10) {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality != null) {
            try {
                iTranPictureQuality.setGammaIndex(i10);
            } catch (RemoteException e10) {
                j7.b.a("setGammaIndex fail:", e10, f208c);
            }
        }
    }

    @Override // ug.a
    public void f(int i10) {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality != null) {
            try {
                iTranPictureQuality.setPictureMode(i10);
            } catch (RemoteException e10) {
                j7.b.a("setPictureMode fail:", e10, f208c);
            }
        }
    }

    @Override // ug.a
    public int g() {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality == null) {
            return 0;
        }
        try {
            return iTranPictureQuality.getGammaIndex();
        } catch (RemoteException e10) {
            j7.b.a("getGammaIndex fail:", e10, f208c);
            return 0;
        }
    }

    @Override // ug.a
    public int h() {
        return ((Integer) new f().c(new f.b() { // from class: ae.a
            @Override // zb.f.b
            public final Object run() {
                return this.f201a.n();
            }
        }, "picture_quality")).intValue();
    }

    public final /* synthetic */ Object m(boolean z10) throws RemoteException {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality == null) {
            return null;
        }
        iTranPictureQuality.enableC3D(z10);
        return null;
    }

    public final /* synthetic */ Object n() throws RemoteException {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality != null) {
            return Integer.valueOf(iTranPictureQuality.getAALFunction());
        }
        return -1;
    }

    public final /* synthetic */ Object o(int i10) throws RemoteException {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality == null) {
            return null;
        }
        iTranPictureQuality.setAALFunction(i10);
        return null;
    }

    public final /* synthetic */ Object p(int i10) throws RemoteException {
        ITranPictureQuality iTranPictureQuality = this.f209a;
        if (iTranPictureQuality == null) {
            return null;
        }
        iTranPictureQuality.setSmartBacklightStrength(i10);
        return null;
    }
}
