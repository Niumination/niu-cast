package a5;

import android.os.RemoteException;
import com.transsion.connectx.mirror.source.pad.extend.ExtendScreenActivity;
import com.transsion.connectx.sdk.ICapabilityListener;
import jn.p;
import jq.h0;
import k4.f;
import kn.l0;
import kn.n0;
import lm.l2;
import os.l;
import os.m;
import p5.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f48b = "CapabilitySdkController";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final String f49c = "SERIVCE_CAPABILITY_ALBUM_BACKUP";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f50d = "extend_is_show_cast_dialog";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final String f51e = "disable_clipboard";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public static ICapabilityListener f52f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final String f54h = "com.transsion.phone_extend_pad";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f47a = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final p<String, String, l2> f53g = C0001a.INSTANCE;

    /* JADX INFO: renamed from: a5.a$a, reason: collision with other inner class name */
    public static final class C0001a extends n0 implements p<String, String, l2> {
        public static final C0001a INSTANCE = new C0001a();

        public C0001a() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, String str2) {
            invoke2(str, str2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l String str, @l String str2) {
            l0.p(str, f.f8937e);
            l0.p(str2, "param");
            k4.m.e(a.f48b, "executeAction action:" + str + ", param:" + str2);
            int iHashCode = str.hashCode();
            if (iHashCode == -1929742081) {
                if (str.equals(a.f51e) && !a6.p.b()) {
                    m0.f12861a.H();
                    return;
                }
                return;
            }
            if (iHashCode == -1574274103) {
                if (str.equals(a.f49c)) {
                    b4.a.f725a.u(str2);
                }
            } else if (iHashCode == 253663702 && str.equals(a.f50d)) {
                ExtendScreenActivity.a aVar = ExtendScreenActivity.f2136x;
                boolean zT2 = h0.T2(str2, "true", false, 2, null);
                aVar.getClass();
                ExtendScreenActivity.M = zT2;
            }
        }
    }

    public final void a(@l String str) throws RemoteException {
        l0.p(str, "param");
        k4.m.e(f48b, "changeAutoBackupState, param:" + str);
        ICapabilityListener iCapabilityListener = f52f;
        if (iCapabilityListener != null) {
            iCapabilityListener.onAction(f49c, str);
        }
    }

    public final void b(@l String str, @l String str2) throws RemoteException {
        l0.p(str, f.f8937e);
        l0.p(str2, "param");
        k4.m.e(f48b, "executeAction action:" + str + ", param:" + str2);
        ICapabilityListener iCapabilityListener = f52f;
        if (iCapabilityListener != null) {
            iCapabilityListener.onAction(str, str2);
        }
    }

    public final boolean c(String str) {
        ICapabilityListener iCapabilityListener = f52f;
        boolean zIsSupportCapability = iCapabilityListener != null ? iCapabilityListener.isSupportCapability(str) : false;
        k4.m.e(f48b, "isSupportCapability capabilityName:" + str + ", isSupport:" + zIsSupportCapability);
        return zIsSupportCapability;
    }

    public final boolean d() {
        return c(f54h);
    }

    public final void e(@l String str, @l String str2) {
        l0.p(str, f.f8937e);
        l0.p(str2, "param");
        f53g.invoke(str, str2);
    }

    public final void f(@l ICapabilityListener iCapabilityListener) {
        l0.p(iCapabilityListener, "listener");
        k4.m.e(f48b, "registerCapabilityListener");
        f52f = iCapabilityListener;
    }

    public final void g() {
        f52f = null;
    }
}
