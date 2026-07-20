package va;

import android.os.IBinder;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16778c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16779d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16780e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f16781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f16784i = "package name should not be null";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f16785j = "lock must not be null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vd.y f16786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.j f16787b;

    public interface a {
        void a(boolean z10);
    }

    static {
        f16781f = e8.j.z("BRIGHTNESS_MIN") != null ? ((Float) e8.j.z("BRIGHTNESS_MIN")).floatValue() : 0.0f;
        f16782g = e8.j.z("BRIGHTNESS_MIN") != null ? ((Integer) e8.j.z("BRIGHTNESS_ON")).intValue() : 255;
        f16783h = i.class.getSimpleName();
    }

    public void a(IBinder iBinder, String str, String str2) throws ac.a {
        if (iBinder == null) {
            throw new IllegalArgumentException(f16785j);
        }
        if (str2 == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        h(fc.b.a.f5987g).r(iBinder, str, str2);
    }

    public void b(IBinder iBinder, String str, String str2, long j10) throws ac.a {
        if (iBinder == null) {
            throw new IllegalArgumentException(f16785j);
        }
        if (str2 == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        h(fc.b.a.f5987g).t(iBinder, str, str2, j10);
    }

    @yb.a(level = 1)
    public List<String> c() {
        return h(fc.b.a.f5989i).a();
    }

    public float d(int i10) {
        return h(fc.b.a.f5984d).i(i10);
    }

    public int e() {
        return h(fc.b.a.f5989i).d();
    }

    public int f() {
        return h(fc.b.a.f5989i).v();
    }

    public boolean g() {
        return h(fc.b.a.f5989i).h();
    }

    public pg.h h(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16783h, "TranThubPowerManager");
            vd.y yVar = this.f16786a;
            if (yVar != null) {
                return yVar;
            }
            vd.y yVar2 = new vd.y();
            this.f16786a = yVar2;
            return yVar2;
        }
        dc.e.f(f16783h, "TranAospPowerManager");
        e8.j jVar = this.f16787b;
        if (jVar != null) {
            return jVar;
        }
        e8.j jVar2 = new e8.j();
        this.f16787b = jVar2;
        return jVar2;
    }

    @yb.a(level = 1)
    public List<String> i() {
        return h(fc.b.a.f5989i).s();
    }

    public void j(long j10) {
        h(fc.b.a.f5985e).f(j10);
    }

    public boolean k() {
        return h(fc.b.a.f5984d).q();
    }

    @Deprecated
    public boolean l(String str) {
        if (!fc.a.f()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("call reason cannot be null");
        }
        return h(fc.b.a.f6002v).o(str);
    }

    @Deprecated
    public boolean m(int i10, String str) {
        if (!fc.a.f()) {
            return false;
        }
        if (i10 > Integer.MAX_VALUE && i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("sensor flag cannot over the range of int");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("call reason cannot be null");
        }
        return h(fc.b.a.f6002v).p(i10, str);
    }

    public void n(boolean z10) throws ac.a {
        h(fc.b.a.C).w(z10);
    }

    public void o(boolean z10) {
        h(fc.b.a.f5989i).g(z10);
    }

    public void p(String str) {
        h(fc.b.a.f5986f).j(str);
    }

    public boolean q(a aVar, String str) throws ac.a {
        if (!fc.a.f()) {
            return false;
        }
        if (aVar == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("call reason cannot be null");
        }
        return h(fc.b.a.f6004x).m(aVar, str);
    }

    public boolean r(a aVar, String str) throws ac.a {
        if (!fc.a.f()) {
            return false;
        }
        if (aVar == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("call reason cannot be null");
        }
        return h(fc.b.a.f6004x).k(aVar, str);
    }

    public void s(IBinder iBinder) throws ac.a {
        if (iBinder == null) {
            throw new IllegalArgumentException(f16785j);
        }
        h(fc.b.a.f5987g).K(iBinder);
    }

    public boolean t(boolean z10) {
        return h(fc.b.a.f5984d).c(z10);
    }

    @yb.a(level = 1)
    public void u(boolean z10) {
        h(fc.b.a.f5989i).l(z10);
    }

    @yb.a(level = 1)
    public void v(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("package name should not be null");
        }
        h(fc.b.a.f5989i).e(str, z10);
    }

    public void w(boolean z10, String str, boolean z11) {
        h(fc.b.a.f5986f).b(z10, str, z11);
    }

    public boolean x(String str) throws ac.a {
        if (!fc.a.f()) {
            return false;
        }
        if (str != null) {
            return h(fc.b.a.f6004x).u(str);
        }
        throw new IllegalArgumentException("tag cannot be null");
    }
}
