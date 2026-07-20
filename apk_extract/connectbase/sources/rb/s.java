package rb;

import android.graphics.Bitmap;
import android.view.WindowManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14428c = "s";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14429d = 2000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14430e = 2008;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14431f = 2009;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14432g = 2038;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14433h = 12;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f14434i = 33;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.s f14435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.p f14436b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f14437a = 2000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14438b = 2021;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14439c = 2036;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14440d = 2014;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f14441e = 16;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f14442f = 1048576;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f14443g = 536870912;
    }

    public int a(String str) {
        if (!fc.a.g()) {
            return 0;
        }
        if (str != null) {
            return e(fc.b.a.f6006z).k(str);
        }
        throw new IllegalArgumentException(ob.a.f12167l);
    }

    public String b() {
        return !fc.a.g() ? "" : e(fc.b.a.f6006z).j();
    }

    public int c(WindowManager.LayoutParams layoutParams) {
        if (layoutParams != null) {
            return e(fc.b.a.f6001u).l(layoutParams);
        }
        throw new IllegalArgumentException("layoutParams is null");
    }

    public String d() {
        return !fc.a.g() ? "" : e(fc.b.a.f6006z).d();
    }

    public lh.p e(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14428c, "TranThubWindowManager");
            re.s sVar = this.f14435a;
            if (sVar != null) {
                return sVar;
            }
            re.s sVar2 = new re.s();
            this.f14435a = sVar2;
            return sVar2;
        }
        dc.e.f(f14428c, "TranAospWindowManager");
        b9.p pVar = this.f14436b;
        if (pVar != null) {
            return pVar;
        }
        b9.p pVar2 = new b9.p();
        this.f14436b = pVar2;
        return pVar2;
    }

    public List<String> f(int i10) {
        return e(fc.b.a.f5985e).o(i10);
    }

    public int[] g() {
        return e(fc.b.a.f5985e).f();
    }

    public boolean h() {
        return e(fc.b.a.A).i();
    }

    public void i(WindowManager.LayoutParams layoutParams, int i10) {
        e(fc.b.a.f5994n).m(layoutParams, i10);
    }

    public void j(WindowManager.LayoutParams layoutParams, int i10) {
        if (layoutParams == null) {
            throw new IllegalArgumentException("layoutParams is null");
        }
        e(fc.b.a.f6001u).c(layoutParams, i10);
    }

    public void k(WindowManager.LayoutParams layoutParams, int i10) {
        if (layoutParams == null) {
            throw new IllegalArgumentException("LayoutParams is null.");
        }
        e(fc.b.a.f5992l).h(layoutParams, i10);
    }

    public void l(String str) {
        if (fc.a.g()) {
            e(fc.b.a.f6006z).e(str);
        }
    }

    public void m(int i10, String str) {
        e(fc.b.a.f5985e).g(i10, str);
    }

    public void n(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            throw new IllegalArgumentException("WindowManager.LayoutParams is null.");
        }
        e(fc.b.a.f5992l).b(layoutParams);
    }

    @yb.a(level = 1)
    public Bitmap o() {
        return e(fc.b.a.f5989i).n();
    }
}
