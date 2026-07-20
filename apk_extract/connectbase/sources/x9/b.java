package x9;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import gm.i;
import yc.j;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20126c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f20127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g7.b f20128b;

    public interface a {
        void onDisplayAdded(int i10);

        void onDisplayRemoved(int i10);
    }

    /* JADX INFO: renamed from: x9.b$b, reason: collision with other inner class name */
    public interface InterfaceC0500b {
        void a();

        void b();
    }

    public interface c {
        void a();
    }

    public interface d {
        void a(int i10);
    }

    public interface e {
        void a(int i10);

        void b(int i10, float f10);
    }

    public void a(String str, String str2) throws ac.a {
        g(fc.b.a.f5987g).u(str, str2);
    }

    public void b() {
        g(fc.b.a.f5987g).i();
    }

    public void c() {
        g(fc.b.a.f5997q).c();
    }

    public int d() {
        return g(fc.b.a.f5997q).h();
    }

    public int e() {
        return g(fc.b.a.f5988h).k();
    }

    public int f() {
        return g(fc.b.a.f5986f).q();
    }

    public rf.b g(String str) {
        if (fc.b.b(str)) {
            j jVar = this.f20127a;
            if (jVar != null) {
                return jVar;
            }
            j jVarI = j.I();
            this.f20127a = jVarI;
            return jVarI;
        }
        dc.e.f(f20126c, "TranAospDisplayManager");
        g7.b bVar = this.f20128b;
        if (bVar != null) {
            return bVar;
        }
        g7.b bVar2 = new g7.b();
        this.f20128b = bVar2;
        return bVar2;
    }

    public int h() {
        return g(fc.b.a.f5989i).n();
    }

    public boolean i() {
        return g(fc.b.a.f5997q).t();
    }

    public boolean j() throws ac.a {
        return g(fc.b.a.f5995o).b();
    }

    public void k() {
        g(fc.b.a.f5987g).s();
    }

    public void l(Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Bundle state cannot be null");
        }
        g(fc.b.a.f5997q).v(bundle);
    }

    public void m(@i a aVar, @gm.j Handler handler) {
        g(fc.b.a.f5987g).j(aVar, handler);
    }

    public void n(int i10, InterfaceC0500b interfaceC0500b) throws ac.a {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Pid must out of range!");
        }
        if (interfaceC0500b == null) {
            throw new IllegalArgumentException("Callback must not be null");
        }
        g(fc.b.a.f5998r).a(i10, interfaceC0500b);
    }

    public boolean o(e eVar, String str) throws ac.a {
        if (!fc.a.g()) {
            return false;
        }
        if (eVar == null) {
            throw new IllegalArgumentException("Callback must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Tag must not be null");
        }
        try {
            Class.forName("com.transsion.hubsdk.hardware.display.ITranPowerStateChangedCallback");
            return g(fc.b.a.f6005y).w(eVar, str);
        } catch (ClassNotFoundException e10) {
            throw new ac.a("No interface,please implement yourself: " + e10.getMessage());
        }
    }

    public void p(int i10, c cVar) throws ac.a {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Pid must out of range!");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback must not be null");
        }
        g(fc.b.a.f6002v).p(i10, cVar);
    }

    public void q(int i10, d dVar) throws ac.a {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Pid must out of range!");
        }
        if (dVar == null) {
            throw new IllegalArgumentException("Callback must not be null");
        }
        g(fc.b.a.f5995o).d(i10, dVar);
    }

    public void r(int i10, float f10) {
        g(fc.b.a.f5986f).g(i10, f10);
    }

    public void s(int i10, float f10) {
        g(fc.b.a.f5984d).l(i10, f10);
    }

    public void t(int i10, boolean z10, String str) {
        if (fc.a.f()) {
            if (str == null) {
                throw new IllegalArgumentException("Reason must not be null");
            }
            g(fc.b.a.f6001u).e(i10, z10, str);
        }
    }

    public boolean u(String str) throws ac.a {
        if (!fc.a.g()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Tag must not be null");
        }
        try {
            Class.forName("com.transsion.hubsdk.hardware.display.ITranPowerStateChangedCallback");
            return g(fc.b.a.f6005y).r(str);
        } catch (ClassNotFoundException e10) {
            throw new ac.a("No interface,please implement yourself: " + e10.getMessage());
        }
    }

    public void v(@i a aVar) {
        g(fc.b.a.f5987g).x(aVar);
    }

    public void w(int i10) throws ac.a {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Pid must out of range!");
        }
        g(fc.b.a.f5998r).f(i10);
    }

    public void x(int i10) throws ac.a {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Pid must out of range!");
        }
        g(fc.b.a.f6002v).o(i10);
    }

    public void y(int i10) throws ac.a {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Pid must out of range!");
        }
        g(fc.b.a.f5995o).m(i10);
    }
}
