package ee;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.resmonitor.ITranResMonitorManager;
import com.transsion.hubsdk.resmonitor.TranResMonitorManager;

/* JADX INFO: loaded from: classes2.dex */
public class s implements yg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranResMonitorManager f4315a;

    public s() {
        new zb.f().c(new zb.f.b() { // from class: ee.o
            @Override // zb.f.b
            public final Object run() {
                return this.f4303a.P();
            }
        }, "resmonitor");
    }

    public static /* synthetic */ Object D(eb.a aVar) {
        a.c(aVar);
        return null;
    }

    public static /* synthetic */ Object I(int i10, String str, eb.b bVar) throws RemoteException {
        t.b(null, i10, str, bVar);
        return null;
    }

    public static /* synthetic */ Object J(int i10, String str, eb.b bVar) throws RemoteException {
        t.b(null, i10, str, bVar);
        return null;
    }

    public static /* synthetic */ Object L(Bundle bundle, eb.b bVar) throws RemoteException {
        t.c(null, bundle, bVar);
        return null;
    }

    public static /* synthetic */ Object M(Bundle bundle, eb.b bVar) throws RemoteException {
        t.c(null, bundle, bVar);
        return null;
    }

    public static /* synthetic */ Object R(int i10, eb.a aVar, int i11, int i12, int i13, int i14) throws RemoteException {
        a.b(i10, aVar, i11, i12, i13, i14);
        return null;
    }

    public static /* synthetic */ Object S(int i10, String str) throws RemoteException {
        TranResMonitorManager.setEventStatic(i10, str);
        return null;
    }

    public static /* synthetic */ Object T(Bundle bundle, Bundle[] bundleArr) throws RemoteException {
        TranResMonitorManager.setEventBundleStatic(bundle, bundleArr);
        return null;
    }

    public static /* synthetic */ Object U(Bundle bundle, Bundle[] bundleArr) throws RemoteException {
        TranResMonitorManager.setEventBundleStatic(bundle, bundleArr);
        return null;
    }

    public static /* synthetic */ Object V(int i10, String str) throws RemoteException {
        TranResMonitorManager.setEventStatic(i10, str);
        return null;
    }

    public static /* synthetic */ Object X(eb.a aVar) throws RemoteException {
        a.c(aVar);
        return null;
    }

    public static /* synthetic */ Object r(Bundle bundle, eb.b bVar) {
        t.c(null, bundle, bVar);
        return null;
    }

    public static /* synthetic */ Object u(int i10, eb.a aVar, int i11, int i12, int i13, int i14) {
        a.b(i10, aVar, i11, i12, i13, i14);
        return null;
    }

    public static /* synthetic */ Object v(int i10, String str, eb.b bVar) {
        t.b(null, i10, str, bVar);
        return null;
    }

    public static /* synthetic */ Object x(int i10, String str, eb.b bVar) {
        t.b(null, i10, str, bVar);
        return null;
    }

    public static /* synthetic */ Object y(Bundle bundle, eb.b bVar) {
        t.c(null, bundle, bVar);
        return null;
    }

    public final /* synthetic */ Object P() throws RemoteException {
        this.f4315a = ITranResMonitorManager.Stub.asInterface(TranServiceManager.getServiceIBinder("resmonitor"));
        return null;
    }

    public final /* synthetic */ Object Q(int i10, eb.a aVar, int i11, int i12, int i13, int i14) throws RemoteException {
        if (this.f4315a == null) {
            return null;
        }
        a.b(i10, aVar, i11, i12, i13, i14);
        return null;
    }

    public final /* synthetic */ Object W(eb.a aVar) throws RemoteException {
        if (this.f4315a == null) {
            return null;
        }
        a.c(aVar);
        return null;
    }

    @VisibleForTesting
    public void Y(ITranResMonitorManager iTranResMonitorManager) {
        this.f4315a = iTranResMonitorManager;
    }

    @Override // yg.a
    public String a(final int i10, final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: ee.c
            @Override // zb.f.b
            public final Object run() {
                return TranResMonitorManager.getEventStatic(i10, str);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public Bundle[] b(final Bundle bundle, final Bundle[] bundleArr) {
        return (Bundle[]) new zb.f().c(new zb.f.b() { // from class: ee.f
            @Override // zb.f.b
            public final Object run() {
                return TranResMonitorManager.getEventBundleStatic(bundle, bundleArr);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void c(final Bundle bundle, final Bundle[] bundleArr) {
        new zb.f().c(new zb.f.b() { // from class: ee.e
            @Override // zb.f.b
            public final Object run() {
                return s.U(bundle, bundleArr);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void d(final int i10, final String str, final eb.b bVar) {
        new zb.f().c(new zb.f.b() { // from class: ee.h
            @Override // zb.f.b
            public final Object run() {
                t.b(null, i10, str, bVar);
                return null;
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void e(final Bundle bundle, final eb.b bVar) {
        new zb.f().c(new zb.f.b() { // from class: ee.j
            @Override // zb.f.b
            public final Object run() {
                t.c(null, bundle, bVar);
                return null;
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void f(final int i10, final eb.a aVar, final int i11, final int i12, final int i13, final int i14) {
        new zb.f().c(new zb.f.b() { // from class: ee.i
            @Override // zb.f.b
            public final Object run() {
                return this.f4287a.Q(i10, aVar, i11, i12, i13, i14);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public String g(final int i10, final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: ee.r
            @Override // zb.f.b
            public final Object run() {
                return TranResMonitorManager.getEventStatic(i10, str);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void h(final int i10, final String str) {
        new zb.f().c(new zb.f.b() { // from class: ee.d
            @Override // zb.f.b
            public final Object run() {
                return s.S(i10, str);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void i(final Bundle bundle, final Bundle[] bundleArr) {
        new zb.f().c(new zb.f.b() { // from class: ee.l
            @Override // zb.f.b
            public final Object run() {
                return s.T(bundle, bundleArr);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public Bundle[] j(final Bundle bundle, final Bundle[] bundleArr) {
        return (Bundle[]) new zb.f().c(new zb.f.b() { // from class: ee.n
            @Override // zb.f.b
            public final Object run() {
                return TranResMonitorManager.getEventBundleStatic(bundle, bundleArr);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void k(final eb.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: ee.m
            @Override // zb.f.b
            public final Object run() {
                a.c(aVar);
                return null;
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void l(final int i10, final String str, final eb.b bVar) {
        new zb.f().c(new zb.f.b() { // from class: ee.q
            @Override // zb.f.b
            public final Object run() {
                t.b(null, i10, str, bVar);
                return null;
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void m(final int i10, final eb.a aVar, final int i11, final int i12, final int i13, final int i14) {
        new zb.f().c(new zb.f.b() { // from class: ee.p
            @Override // zb.f.b
            public final Object run() {
                a.b(i10, aVar, i11, i12, i13, i14);
                return null;
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void n(final int i10, final String str) {
        new zb.f().c(new zb.f.b() { // from class: ee.b
            @Override // zb.f.b
            public final Object run() {
                return s.V(i10, str);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void o(final eb.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: ee.k
            @Override // zb.f.b
            public final Object run() {
                return this.f4296a.W(aVar);
            }
        }, "resmonitor");
    }

    @Override // yg.a
    public void p(final Bundle bundle, final eb.b bVar) {
        new zb.f().c(new zb.f.b() { // from class: ee.g
            @Override // zb.f.b
            public final Object run() {
                t.c(null, bundle, bVar);
                return null;
            }
        }, "resmonitor");
    }
}
