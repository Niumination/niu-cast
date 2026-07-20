package p9;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;
import qc.w;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13046c = "g";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13047d = 4194304;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13048e = "package name should not be null";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13049f = "userId is wrong";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13050g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f13051h = 536870912;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13052i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13053j = 64;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f13054k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f13055l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13056m = 32;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f13057n = 512;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f13058o = 256;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f13059p = 4096;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f13060q = 8192;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f13061r = 2048;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jf.e f13062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jf.e f13063b;

    public interface a {
        void a(String str, int i10);
    }

    public static /* synthetic */ void A(a aVar, String str, int i10) {
        if (aVar != null) {
            aVar.a(str, i10);
        }
    }

    public static /* synthetic */ void z(a aVar, String str, int i10) {
        if (aVar != null) {
            aVar.a(str, i10);
        }
    }

    public void B(String str, boolean z10) {
        if (fc.a.f()) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("packageName is null");
            }
            w(fc.b.a.f6006z).o(str, z10);
        }
    }

    @yb.a(level = 1)
    public List<ResolveInfo> C(Intent intent, int i10, int i11) {
        if (i11 < 0 || i11 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return w(fc.b.a.f5992l).z(intent, i10, i11);
    }

    public List<ResolveInfo> D(Intent intent, int i10, int i11) {
        return w(fc.b.a.f5992l).E(intent, i10, i11);
    }

    public int E(String str, String str2) {
        return w(fc.b.a.G).A(str, str2);
    }

    public void F(IntentFilter intentFilter, int i10, ComponentName[] componentNameArr, ComponentName componentName, int i11) {
        w(fc.b.a.f5986f).h(intentFilter, i10, componentNameArr, componentName, i11);
    }

    @yb.a(level = 2)
    public void G(String str, int i10, int i11, int i12, String str2) {
        w(fc.b.a.f5983c).r(str, i10, i11, i12, str2);
    }

    public void H(String str, int i10, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        w(fc.b.a.f5987g).I(str, i10, i11);
    }

    public void I(String str, int i10, int i11) {
        w(fc.b.a.f5999s).s(str, i10, i11);
    }

    @yb.a(level = 1)
    public void J(ComponentName componentName, int i10, int i11, int i12) {
        if (componentName == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        if (i12 <= Integer.MIN_VALUE || i12 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        w(fc.b.a.f5987g).B(componentName, i10, i11, i12);
    }

    public boolean K(String str, int i10) {
        return w(fc.b.a.f5999s).d(str, i10);
    }

    @yb.a(level = 2)
    public boolean L(String str, int i10) {
        return w(fc.b.a.f5989i).q(str, i10);
    }

    public Boolean M(String str, int i10) {
        return Boolean.valueOf(w(fc.b.a.f5989i).u(str, i10));
    }

    public boolean N(String str, int i10) {
        return w(fc.b.a.f5999s).C(str, i10);
    }

    @yb.a(level = 3)
    public void O(ComponentName componentName, int i10) {
        w(fc.b.a.f5982b).g(componentName, i10);
    }

    public void c() {
        w(fc.b.a.f5999s).G();
    }

    public void d() {
        w(fc.b.a.f5999s).D();
    }

    public void e() {
        w(fc.b.a.f5999s).J();
    }

    @yb.a(level = 2)
    public void f(String str, final a aVar, int i10) {
        w(fc.b.a.f5989i).F(str, new x6.f.a() { // from class: p9.e
            @Override // x6.f.a
            public final void a(String str2, int i11) {
                g.z(aVar, str2, i11);
            }
        }, i10);
    }

    @yb.a(level = 1)
    public void g(String str, final a aVar, int i10, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        if (i11 <= Integer.MIN_VALUE || i11 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        w(fc.b.a.f5987g).i(str, new x6.f.a() { // from class: p9.f
            @Override // x6.f.a
            public final void a(String str2, int i12) {
                g.A(aVar, str2, i12);
            }
        }, i10, i11);
    }

    @yb.a(level = 2)
    public String[] h() {
        return w(fc.b.a.f5983c).t();
    }

    public int i(String str) {
        if (str != null) {
            return w(fc.b.a.f5987g).x(str);
        }
        throw new IllegalArgumentException("package name should not be null");
    }

    public ApplicationInfo j(String str, int i10, int i11) throws PackageManager.NameNotFoundException {
        if (str != null) {
            return w(fc.b.a.f5987g).y(str, i10, i11);
        }
        throw new IllegalArgumentException("package name should not be null");
    }

    public int k(String str, int i10) {
        return w(fc.b.a.f5999s).v(str, i10);
    }

    public String l(int i10) {
        return w(fc.b.a.H).p(i10);
    }

    public String m(int i10) {
        return w(fc.b.a.f5999s).c(i10);
    }

    @yb.a(level = 2)
    public String n(int i10) {
        return w(fc.b.a.f5989i).e(i10);
    }

    public String o(int i10) {
        return w(fc.b.a.f5999s).b(i10);
    }

    public ComponentName p(List<ResolveInfo> list) {
        return w(fc.b.a.f5982b).w(list);
    }

    @yb.a(level = 1)
    public List<ApplicationInfo> q(int i10, int i11) {
        if (i11 < 0 || i11 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return w(fc.b.a.f5992l).a(i10, i11);
    }

    public List<ApplicationInfo> r(int i10) {
        return w(fc.b.a.G).l(i10);
    }

    public List<PackageInfo> s(int i10, int i11) {
        return w(fc.b.a.f5990j).k(i10, i11);
    }

    @yb.a(level = 1)
    public PackageInfo t(String str, int i10, int i11) {
        return w(fc.b.a.f5982b).f(str, i10, i11);
    }

    public PackageInfo u(String str, int i10, int i11) {
        if (str != null) {
            return w(fc.b.a.f6006z).n(str, i10, i11);
        }
        throw new IllegalArgumentException("packageName is null");
    }

    public String v() {
        return w(fc.b.a.f5988h).m();
    }

    public jf.e w(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13046c, "TranThubPackageManager");
            jf.e eVar = this.f13062a;
            if (eVar != null) {
                return eVar;
            }
            w wVar = new w();
            this.f13062a = wVar;
            return wVar;
        }
        dc.e.f(f13046c, "TranAospPackageManager");
        jf.e eVar2 = this.f13063b;
        if (eVar2 != null) {
            return eVar2;
        }
        x6.e eVar3 = new x6.e();
        this.f13063b = eVar3;
        return eVar3;
    }

    @yb.a(level = 1)
    public int x(String str, int i10) {
        if (str == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        if (i10 < 0 || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        return w(fc.b.a.f5987g).j(str, i10);
    }

    public boolean y(String str) {
        if (!fc.a.f()) {
            return false;
        }
        if (str != null) {
            return w(fc.b.a.f6006z).H(str);
        }
        throw new IllegalArgumentException("packageName is null");
    }
}
