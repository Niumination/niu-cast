package le;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.transsion.hubsdk.trancare.trancare.TranTrancareManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class o0 implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f9946a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f9947b = new a();

    public static /* synthetic */ Object B0(String str, String str2, boolean z10, boolean z11) throws RemoteException {
        return Boolean.valueOf(TranTrancareManager.getAsBooleanDef(str, str2, z10, z11));
    }

    public static /* synthetic */ Object C0(String str, String str2, boolean z10) throws RemoteException {
        return Boolean.valueOf(TranTrancareManager.getAsBoolean(str, str2, z10));
    }

    public static /* synthetic */ Object E0(String str, String str2, boolean z10, long j10) throws RemoteException {
        return Long.valueOf(TranTrancareManager.getAsLongDef(str, str2, z10, j10));
    }

    public static /* synthetic */ Object F0(String str, String str2, boolean z10) throws RemoteException {
        return Long.valueOf(TranTrancareManager.getAsLong(str, str2, z10));
    }

    public static /* synthetic */ Object O0(String str, String str2, boolean z10) throws RemoteException {
        return Boolean.valueOf(TranTrancareManager.getEnabledAsName(str, str2, z10));
    }

    public static /* synthetic */ Object P0(String str, boolean z10) throws RemoteException {
        return Boolean.valueOf(TranTrancareManager.getEnabled(str, z10));
    }

    public static /* synthetic */ Object S0(long j10) throws RemoteException {
        return Boolean.valueOf(TranTrancareManager.isEnabled(j10));
    }

    public static /* synthetic */ Object T0(String str, String str2, boolean[] zArr) throws RemoteException {
        TranTrancareManager.putAsBooleanArray(str, str2, zArr);
        return null;
    }

    public static /* synthetic */ Object U0(String str, String str2, boolean z10) throws RemoteException {
        TranTrancareManager.putAsBoolean(str, str2, z10);
        return null;
    }

    public static /* synthetic */ Object V0(String str, String str2, long[] jArr) throws RemoteException {
        TranTrancareManager.putAsLongArray(str, str2, jArr);
        return null;
    }

    public static /* synthetic */ Object W0(String str, String str2, long j10) throws RemoteException {
        TranTrancareManager.putAsLong(str, str2, j10);
        return null;
    }

    public static /* synthetic */ Object X0(String str, String str2, String[] strArr) throws RemoteException {
        TranTrancareManager.putAsStringArray(str, str2, strArr);
        return null;
    }

    public static /* synthetic */ Object Y0(String str, String str2, String str3) throws RemoteException {
        TranTrancareManager.putAsString(str, str2, str3);
        return null;
    }

    public static /* synthetic */ Object Z0(String str, String str2) throws RemoteException {
        TranTrancareManager.putConfig(str, str2);
        return null;
    }

    public static /* synthetic */ Object c1(int i10, String str, int i11, Bundle bundle) throws RemoteException {
        TranTrancareManager.serverLog(i10, str, i11, bundle);
        return null;
    }

    public static /* synthetic */ Object d1(long j10, String str, int i10, Bundle bundle) throws RemoteException {
        TranTrancareManager.serverLog(Long.valueOf(j10), str, i10, bundle);
        return null;
    }

    public static /* synthetic */ Object e1(long j10, String str, int i10, ArrayList arrayList, Bundle bundle) throws RemoteException {
        TranTrancareManager.serverLog(j10, str, i10, arrayList, bundle);
        return null;
    }

    public static /* synthetic */ Object f1(int i10, String str, int i11, ArrayList arrayList, Bundle bundle) throws RemoteException {
        TranTrancareManager.serverLog(i10, str, i11, arrayList, bundle);
        return null;
    }

    public static /* synthetic */ Object g1(int i10, String str) throws RemoteException {
        TranTrancareManager.serverLog(i10, str);
        return null;
    }

    public static /* synthetic */ Object h1(long j10, String str) throws RemoteException {
        TranTrancareManager.serverLog(Long.valueOf(j10), str);
        return null;
    }

    public static /* synthetic */ Object y0(int i10) throws RemoteException {
        TranTrancareManager.appRequest(i10);
        return null;
    }

    public static /* synthetic */ Object z0(String str, boolean z10) throws RemoteException {
        TranTrancareManager.feedBack(str, z10);
        return null;
    }

    @Override // fh.a
    public boolean A(final String str, final String str2, final boolean z10) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: le.p
            @Override // zb.f.b
            public final Object run() {
                return o0.O0(str, str2, z10);
            }
        }, "trancare")).booleanValue();
    }

    @Override // fh.a
    public boolean[] B(final String str, final String str2, final boolean z10) {
        return (boolean[]) new zb.f().c(new zb.f.b() { // from class: le.d
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getAsBooleanArray(str, str2, z10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String C(final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.g
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getDefaultFilePath(str);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String D(final String str, final String str2) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.a0
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getDefaultFileContent(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void E(final String str, final String str2, final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: le.n
            @Override // zb.f.b
            public final Object run() {
                return o0.U0(str, str2, z10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String F(final String str, final String str2) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.k
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getFileContent(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void G(final String str, final String str2, final long[] jArr) {
        new zb.f().c(new zb.f.b() { // from class: le.l0
            @Override // zb.f.b
            public final Object run() {
                return o0.V0(str, str2, jArr);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String H(final String str, final String str2, final boolean z10, final String str3) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.o
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getAsStringDef(str, str2, z10, str3);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void I(final String str, final String str2, final lb.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: le.t
            @Override // zb.f.b
            public final Object run() {
                return this.f9975a.a1(str, str2, aVar);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void J(final long j10, final String str, final int i10, final Bundle bundle) {
        new zb.f().c(new zb.f.b() { // from class: le.l
            @Override // zb.f.b
            public final Object run() {
                return o0.d1(j10, str, i10, bundle);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void K(final int i10, final String str, final int i11, final ArrayList<Bundle> arrayList, final Bundle bundle) {
        new zb.f().c(new zb.f.b() { // from class: le.e
            @Override // zb.f.b
            public final Object run() {
                return o0.f1(i10, str, i11, arrayList, bundle);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String L(final String str, final String str2, final boolean z10) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.i
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getAsString(str, str2, z10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String a(final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.r
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getConfig(str);
            }
        }, "trancare");
    }

    public final /* synthetic */ Object a1(String str, String str2, lb.a aVar) throws RemoteException {
        this.f9947b.c(str, str2, aVar);
        return null;
    }

    @Override // fh.a
    public boolean b(final String str, final boolean z10) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: le.x
            @Override // zb.f.b
            public final Object run() {
                return o0.P0(str, z10);
            }
        }, "trancare")).booleanValue();
    }

    public final /* synthetic */ Object b1(lb.c cVar) throws RemoteException {
        this.f9946a.c(cVar);
        return null;
    }

    @Override // fh.a
    public long c(final String str, final String str2, final boolean z10, final long j10) {
        return ((Long) new zb.f().c(new zb.f.b() { // from class: le.w
            @Override // zb.f.b
            public final Object run() {
                return o0.E0(str, str2, z10, j10);
            }
        }, "trancare")).longValue();
    }

    @Override // fh.a
    public void d(final int i10, final String str, final int i11, final Bundle bundle) {
        new zb.f().c(new zb.f.b() { // from class: le.k0
            @Override // zb.f.b
            public final Object run() {
                return o0.c1(i10, str, i11, bundle);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void e(final String str, final String str2, final long j10) {
        new zb.f().c(new zb.f.b() { // from class: le.h0
            @Override // zb.f.b
            public final Object run() {
                return o0.W0(str, str2, j10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public long f(final String str, final String str2, final boolean z10) {
        return ((Long) new zb.f().c(new zb.f.b() { // from class: le.e0
            @Override // zb.f.b
            public final Object run() {
                return o0.F0(str, str2, z10);
            }
        }, "trancare")).longValue();
    }

    @Override // fh.a
    public void g(final String str, final String str2, final String[] strArr) {
        new zb.f().c(new zb.f.b() { // from class: le.v
            @Override // zb.f.b
            public final Object run() {
                return o0.X0(str, str2, strArr);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void h(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: le.j
            @Override // zb.f.b
            public final Object run() {
                return o0.y0(i10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public boolean i(final long j10) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: le.f
            @Override // zb.f.b
            public final Object run() {
                return o0.S0(j10);
            }
        }, "trancare")).booleanValue();
    }

    public final /* synthetic */ Object i1(String str, lb.a aVar) throws RemoteException {
        this.f9947b.d(str, aVar);
        return null;
    }

    @Override // fh.a
    public void j(final lb.c cVar) {
        new zb.f().c(new zb.f.b() { // from class: le.m
            @Override // zb.f.b
            public final Object run() {
                return this.f9929a.b1(cVar);
            }
        }, "trancare");
    }

    public final /* synthetic */ Object j1(lb.c cVar) throws RemoteException {
        this.f9946a.d(cVar);
        return null;
    }

    @Override // fh.a
    public String k(final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.f0
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getFilePath(str);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void l(final long j10, final String str, final int i10, final ArrayList<Bundle> arrayList, final Bundle bundle) {
        new zb.f().c(new zb.f.b() { // from class: le.h
            @Override // zb.f.b
            public final Object run() {
                return o0.e1(j10, str, i10, arrayList, bundle);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void m(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: le.c
            @Override // zb.f.b
            public final Object run() {
                return o0.Z0(str, str2);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String n(final Context context, final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.g0
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getConfigStatic(context, str);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void o(final String str, final String str2, final boolean[] zArr) {
        new zb.f().c(new zb.f.b() { // from class: le.u
            @Override // zb.f.b
            public final Object run() {
                return o0.T0(str, str2, zArr);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String p(final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.m0
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getDefaultConfig(str);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void q(final lb.c cVar) {
        new zb.f().c(new zb.f.b() { // from class: le.b0
            @Override // zb.f.b
            public final Object run() {
                return this.f9834a.j1(cVar);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void r(final String str, final lb.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: le.n0
            @Override // zb.f.b
            public final Object run() {
                return this.f9938a.i1(str, aVar);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void s(final String str, final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: le.i0
            @Override // zb.f.b
            public final Object run() {
                return o0.z0(str, z10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public long[] t(final String str, final String str2, final boolean z10) {
        return (long[]) new zb.f().c(new zb.f.b() { // from class: le.y
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getAsLongArray(str, str2, z10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void u(final String str, final String str2, final String str3) {
        new zb.f().c(new zb.f.b() { // from class: le.z
            @Override // zb.f.b
            public final Object run() {
                return o0.Y0(str, str2, str3);
            }
        }, "trancare");
    }

    @Override // fh.a
    public void v(final long j10, final String str) {
        new zb.f().c(new zb.f.b() { // from class: le.c0
            @Override // zb.f.b
            public final Object run() {
                return o0.h1(j10, str);
            }
        }, "trancare");
    }

    @Override // fh.a
    public String[] w(final String str, final String str2, final boolean z10) {
        return (String[]) new zb.f().c(new zb.f.b() { // from class: le.j0
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareManager.getAsStringArray(str, str2, z10);
            }
        }, "trancare");
    }

    @Override // fh.a
    public boolean x(final String str, final String str2, final boolean z10) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: le.d0
            @Override // zb.f.b
            public final Object run() {
                return o0.C0(str, str2, z10);
            }
        }, "trancare")).booleanValue();
    }

    @Override // fh.a
    public void y(final int i10, final String str) {
        new zb.f().c(new zb.f.b() { // from class: le.s
            @Override // zb.f.b
            public final Object run() {
                return o0.g1(i10, str);
            }
        }, "trancare");
    }

    @Override // fh.a
    public boolean z(final String str, final String str2, final boolean z10, final boolean z11) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: le.q
            @Override // zb.f.b
            public final Object run() {
                return o0.B0(str, str2, z10, z11);
            }
        }, "trancare")).booleanValue();
    }
}
