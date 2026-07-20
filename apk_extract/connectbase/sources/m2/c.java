package m2;

import androidx.annotation.CallSuper;
import k4.m;
import n2.l0;
import n2.v;
import p2.o;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10360a = "OnRequestSourceListener";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10361b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10362c = 2;

    @CallSuper
    public void a() {
        m.e(f10360a, "onClearNotification");
    }

    @CallSuper
    public void b(String str, boolean z10) {
        m.e(f10360a, "onOpenNotification:id:" + str + ",main:" + z10);
    }

    @CallSuper
    public void c(o oVar) {
        m.e(f10360a, "onPeerConfirmReceiveFile:" + oVar);
    }

    @CallSuper
    public void d() {
    }

    @CallSuper
    public void e(l0 l0Var) {
        m.e(f10360a, "onPeerRequestReceiveFile:" + l0Var);
    }

    @CallSuper
    public void f(v vVar) {
        m.e(f10360a, "onPeerRequestSendFile:" + vVar);
    }

    @CallSuper
    public void g() {
        m.e(f10360a, "onQueryAppList");
    }

    @CallSuper
    public void h() {
        m.e(f10360a, "onQueryNotificationList");
    }

    @CallSuper
    public void i(int i10, int i11, int i12) {
        StringBuilder sbA = i0.a.a("onReparent: mode:", i10, ",fromPort:", i11, ",toPort:");
        sbA.append(i12);
        m.e(f10360a, sbA.toString());
    }

    @CallSuper
    public void j(int i10, int i11) {
        m.e(f10360a, "onRequestFpsChange:port:" + i10 + ",fps:" + i11);
    }

    @CallSuper
    public void k() {
        m.e(f10360a, "onRequestGetStorageSize");
    }

    @CallSuper
    public void l(int i10) {
        b.a("onStopPlay:port:", i10, f10360a);
    }

    @CallSuper
    public void m(String str) {
        m.e(f10360a, "onRequestClipboardContentChange:content:" + str);
    }

    @CallSuper
    public void n(int i10) {
        b.a("onTeardown:", i10, f10360a);
    }
}
