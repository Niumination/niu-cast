package oa;

import android.content.Context;
import android.media.AudioAttributes;
import java.util.List;
import od.y0;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12112c = "android.media.VOLUME_CHANGED_ACTION";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12113d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12114e = "android.media.EXTRA_VOLUME_STREAM_TYPE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12115f = "android.media.EXTRA_VOLUME_STREAM_VALUE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12116g = "android.media.EXTRA_VOLUME_STREAM_TYPE_ALIAS";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12117h = "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f12118i = "getSmartEngineSupportPackage";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y0 f12119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x7.a f12120b;

    /* JADX INFO: renamed from: oa.a$a, reason: collision with other inner class name */
    public interface InterfaceC0309a {
        boolean a();

        void b(String[] strArr, String str, String str2, boolean z10, String str3);

        void c();
    }

    public interface b {
        void a(int i10, String str);
    }

    public interface c {
        void a(int i10);
    }

    public interface d {
        void a(int i10, int i11);
    }

    public String[] A(int i10) {
        return x(fc.b.a.f5996p).c0(i10);
    }

    public int B(int i10) {
        return x(fc.b.a.f5999s).B(i10);
    }

    public int C() {
        return x(fc.b.a.f5995o).I();
    }

    public boolean D() {
        return x(fc.b.a.f5996p).d0();
    }

    public boolean E() {
        return x(fc.b.a.f5996p).E();
    }

    public boolean F(int i10) {
        return x(fc.b.a.f5996p).a0(i10);
    }

    public boolean G() {
        return x(fc.b.a.f5996p).S();
    }

    public boolean H(int i10) {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Parameter value overflow");
        }
        return x(fc.b.a.f5998r).k(i10);
    }

    public void I(InterfaceC0309a interfaceC0309a) throws ac.a {
        x(fc.b.a.E).M(interfaceC0309a);
    }

    public void J(String str, b bVar) {
        x(fc.b.a.f5985e).A(str, bVar);
    }

    public void K(c cVar) throws ac.a {
        x(fc.b.a.G).o(cVar);
    }

    public void L(d dVar) {
        if (dVar == null) {
            throw new NullPointerException("registerVolumeGroupCallback callback cannot be null");
        }
        x(fc.b.a.f5998r).i(dVar);
    }

    public void M(boolean z10) {
        x(fc.b.a.f5995o).u(z10);
    }

    public void N(int i10) {
        x(fc.b.a.f5996p).t(i10);
    }

    public void O(boolean z10) {
        x(fc.b.a.f5996p).J(z10);
    }

    public void P(boolean z10) {
        x(fc.b.a.f5995o).T(z10);
    }

    public void Q(int[] iArr) {
        if (iArr == null) {
            throw new NullPointerException("param gains cannot be null");
        }
        x(fc.b.a.f5995o).g(iArr);
    }

    public void R(boolean z10) {
        x(fc.b.a.f5996p).j(z10);
    }

    public void S(int i10) {
        x(fc.b.a.f5995o).C(i10);
    }

    public void T(int i10, int i11) {
        x(fc.b.a.f5995o).K(i10, i11);
    }

    public void U(int i10) {
        x(fc.b.a.f5996p).D(i10);
    }

    public void V(int i10) {
        x(fc.b.a.f5996p).e(i10);
    }

    public void W(boolean z10) {
        x(fc.b.a.f5996p).y(z10);
    }

    public void X(Context context, int i10) {
        x(fc.b.a.f5986f).x(context.getPackageName(), i10);
    }

    public void Y(boolean z10) {
        x(fc.b.a.f5995o).Z(z10);
    }

    public void Z(int i10, int i11) {
        x(fc.b.a.f5995o).P(i10, i11);
    }

    public boolean a(String str) throws ac.a {
        return x(fc.b.a.G).R(str);
    }

    public void a0(int i10) {
        x(fc.b.a.f5995o).q(i10);
    }

    public String b(String str) throws ac.a {
        return x(fc.b.a.G).c(str);
    }

    public void b0(boolean z10) {
        x(fc.b.a.f5995o).h(z10);
    }

    public List<String> c() throws ac.a {
        return x(fc.b.a.G).s();
    }

    public void c0() throws ac.a {
        x(fc.b.a.E).N();
    }

    public boolean d(String str, String str2) throws ac.a {
        return x(fc.b.a.G).f(str, str2);
    }

    public void d0(String str) {
        x(fc.b.a.f5985e).b0(str);
    }

    public boolean e(String str) throws ac.a {
        return x(fc.b.a.G).m(str);
    }

    public void e0() throws ac.a {
        x(fc.b.a.G).L();
    }

    public AudioAttributes f(int i10) {
        return x(fc.b.a.f5999s).z(i10);
    }

    public void f0(d dVar) {
        if (dVar == null) {
            throw new NullPointerException("unregisterVolumeGroupCallback callback cannot be null");
        }
        x(fc.b.a.f5998r).a(dVar);
    }

    public boolean g() {
        return x(fc.b.a.f5995o).d();
    }

    public String h() {
        return x(fc.b.a.f5989i).Q();
    }

    public String i() throws ac.a {
        return x(fc.b.a.G).e0();
    }

    public boolean j() {
        return x(fc.b.a.f5996p).p();
    }

    public boolean k() {
        return x(fc.b.a.f5995o).l();
    }

    public int[] l() {
        return x(fc.b.a.f5995o).n();
    }

    public boolean m() {
        return x(fc.b.a.f5996p).X();
    }

    public int n() {
        return x(fc.b.a.f5995o).O();
    }

    public int o(int i10) {
        return x(fc.b.a.f5995o).w(i10);
    }

    public String p(int i10) {
        return x(fc.b.a.f5995o).V(i10);
    }

    public int q() {
        return x(fc.b.a.f5995o).U();
    }

    public int r() {
        return x(fc.b.a.f5996p).Y();
    }

    public int s() {
        return x(fc.b.a.f5996p).W();
    }

    public String t(int i10) {
        return x(fc.b.a.f5996p).r(i10);
    }

    public int u() {
        return x(fc.b.a.f5996p).H();
    }

    public boolean v() {
        return x(fc.b.a.f5996p).F();
    }

    public String w(int i10) {
        return x(fc.b.a.f5996p).b(i10);
    }

    public ig.a x(String str) {
        if (fc.b.b(str)) {
            y0 y0Var = this.f12119a;
            if (y0Var != null) {
                return y0Var;
            }
            y0 y0Var2 = new y0();
            this.f12119a = y0Var2;
            return y0Var2;
        }
        x7.a aVar = this.f12120b;
        if (aVar != null) {
            return aVar;
        }
        x7.a aVar2 = new x7.a();
        this.f12120b = aVar2;
        return aVar2;
    }

    public boolean y() {
        return x(fc.b.a.f5995o).G();
    }

    public int z(int i10) {
        return x(fc.b.a.f5995o).v(i10);
    }
}
