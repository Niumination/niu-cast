package le;

import android.os.RemoteException;
import com.transsion.hubsdk.trancare.trancare.TranTrancareNative;

/* JADX INFO: loaded from: classes2.dex */
public class y0 implements fh.b {
    public static /* synthetic */ Object A(String str, String str2) throws RemoteException {
        TranTrancareNative.setNvString(str, str2);
        return null;
    }

    public static /* synthetic */ Object s(String str, String str2) throws RemoteException {
        TranTrancareNative.localLog(str, str2);
        return null;
    }

    public static /* synthetic */ Object t(String str, String str2) throws RemoteException {
        TranTrancareNative.localLogImmediately(str, str2);
        return null;
    }

    public static /* synthetic */ Object u(String str, String str2) throws RemoteException {
        TranTrancareNative.localLogKeep(str, str2);
        return null;
    }

    public static /* synthetic */ Object v(String str, String str2) throws RemoteException {
        TranTrancareNative.localLogKeepReplace(str, str2);
        return null;
    }

    public static /* synthetic */ Object w(String str, String str2) throws RemoteException {
        TranTrancareNative.localRaw(str, str2);
        return null;
    }

    public static /* synthetic */ Object x(String str, float f10, int i10) throws RemoteException {
        TranTrancareNative.setNvFloat(str, f10, i10);
        return null;
    }

    public static /* synthetic */ Object y(String str, int i10, int i11) throws RemoteException {
        TranTrancareNative.setNvInt(str, i10, i11);
        return null;
    }

    public static /* synthetic */ Object z(String str, long j10, int i10) throws RemoteException {
        TranTrancareNative.setNvLong(str, j10, i10);
        return null;
    }

    @Override // fh.b
    public void a(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: le.x0
            @Override // zb.f.b
            public final Object run() {
                return y0.t(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void b(final String str, final float f10, final int i10) {
        new zb.f().c(new zb.f.b() { // from class: le.t0
            @Override // zb.f.b
            public final Object run() {
                return y0.x(str, f10, i10);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void c(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: le.s0
            @Override // zb.f.b
            public final Object run() {
                return y0.A(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void d(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: le.p0
            @Override // zb.f.b
            public final Object run() {
                return y0.u(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void e(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: le.u0
            @Override // zb.f.b
            public final Object run() {
                return y0.s(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void f(final String str, final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: le.w0
            @Override // zb.f.b
            public final Object run() {
                return y0.y(str, i10, i11);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void g(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: le.r0
            @Override // zb.f.b
            public final Object run() {
                return y0.v(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void h(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: le.v0
            @Override // zb.f.b
            public final Object run() {
                return y0.w(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.b
    public void i(final String str, final long j10, final int i10) {
        new zb.f().c(new zb.f.b() { // from class: le.q0
            @Override // zb.f.b
            public final Object run() {
                return y0.z(str, j10, i10);
            }
        }, "trancare");
    }
}
