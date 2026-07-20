package pe;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.uiawarescheduling.ITranSchedManager;

/* JADX INFO: loaded from: classes2.dex */
public class g implements jh.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13096b = "g";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13097c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13098d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13099e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13100f = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f13101g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f13102h = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranSchedManager f13103a = ITranSchedManager.Stub.asInterface(TranServiceManager.getServiceIBinder("TranSchedService"));

    @Override // jh.a
    public int a() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: pe.c
            @Override // zb.f.b
            public final Object run() {
                return this.f13088a.n();
            }
        }, "TranSchedService")).intValue();
        dc.e.f(f13096b, "getTranSchedScene");
        return iIntValue;
    }

    @Override // jh.a
    public boolean b(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: pe.d
            @Override // zb.f.b
            public final Object run() {
                return this.f13089a.q(i10);
            }
        }, "TranSchedService")).booleanValue();
        dc.e.f(f13096b, "setTranSchedScene");
        return zBooleanValue;
    }

    @Override // jh.a
    public boolean c(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: pe.f
            @Override // zb.f.b
            public final Object run() {
                return this.f13094a.m(i10);
            }
        }, "TranSchedService")).booleanValue();
        dc.e.f(f13096b, "cancelTranSchedUxTags");
        return zBooleanValue;
    }

    @Override // jh.a
    public long d(final int i10) {
        long jLongValue = ((Long) new zb.f().c(new zb.f.b() { // from class: pe.a
            @Override // zb.f.b
            public final Object run() {
                return this.f13085a.p(i10);
            }
        }, "TranSchedService")).longValue();
        dc.e.f(f13096b, "getTranSchedUxTags");
        return jLongValue;
    }

    @Override // jh.a
    public int e() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: pe.b
            @Override // zb.f.b
            public final Object run() {
                return this.f13087a.o();
            }
        }, "TranSchedService")).intValue();
        dc.e.f(f13096b, "cancelTranSchedUxTags");
        return iIntValue;
    }

    @Override // jh.a
    public boolean f(final int i10, final String str) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: pe.e
            @Override // zb.f.b
            public final Object run() {
                return this.f13091a.r(i10, str);
            }
        }, "TranSchedService")).booleanValue();
        dc.e.f(f13096b, "setTranSchedUxTagsByName");
        return zBooleanValue;
    }

    public final /* synthetic */ Object m(int i10) throws RemoteException {
        ITranSchedManager iTranSchedManager = this.f13103a;
        return iTranSchedManager != null ? Boolean.valueOf(iTranSchedManager.cancelTranSchedUxTags(i10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object n() throws RemoteException {
        ITranSchedManager iTranSchedManager = this.f13103a;
        if (iTranSchedManager != null) {
            return Integer.valueOf(iTranSchedManager.getTranSchedScene());
        }
        return 0;
    }

    public final /* synthetic */ Object o() throws RemoteException {
        ITranSchedManager iTranSchedManager = this.f13103a;
        if (iTranSchedManager != null) {
            return Integer.valueOf(iTranSchedManager.getTranSchedState());
        }
        return 0;
    }

    public final /* synthetic */ Object p(int i10) throws RemoteException {
        ITranSchedManager iTranSchedManager = this.f13103a;
        if (iTranSchedManager != null) {
            return Long.valueOf(iTranSchedManager.getTranSchedUxTags(i10));
        }
        return 0L;
    }

    public final /* synthetic */ Object q(int i10) throws RemoteException {
        ITranSchedManager iTranSchedManager = this.f13103a;
        return iTranSchedManager != null ? Boolean.valueOf(iTranSchedManager.setTranSchedScene(i10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object r(int i10, String str) throws RemoteException {
        ITranSchedManager iTranSchedManager = this.f13103a;
        return iTranSchedManager != null ? Boolean.valueOf(iTranSchedManager.setTranSchedUxTagsByName(i10, str)) : Boolean.FALSE;
    }
}
