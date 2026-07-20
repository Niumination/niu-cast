package rb;

import android.graphics.Bitmap;
import com.transsion.hubsdk.view.TranUnionRenderEffect;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14404c = "l";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14405d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14406e = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.k f14407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.j f14408b;

    public enum a {
        NONE,
        G1,
        G2,
        G3,
        L1_LIGHT,
        L2_LIGHT,
        L3_LIGHT,
        L4_LIGHT,
        L1_DARK,
        L2_DARK,
        L3_DARK,
        L4_DARK,
        GT1_LIGHT,
        GT2_LIGHT,
        GT3_LIGHT,
        GT4_LIGHT,
        GT1_DARK,
        GT2_DARK,
        GT3_DARK,
        GT4_DARK
    }

    public l() {
        F(fc.b.a.E);
    }

    public static final int D() {
        return TranUnionRenderEffect.getApiLevel();
    }

    public static boolean L() {
        return TranUnionRenderEffect.isUnionRenderEffectSupport();
    }

    public void A(float f10, boolean z10, float f11) {
        F(fc.b.a.E).t(f10, z10, f11);
    }

    public void B(Bitmap bitmap, boolean z10, float f10) {
        F(fc.b.a.E).r(bitmap, z10, f10);
    }

    public void C() {
        F(fc.b.a.E).u();
    }

    public TranUnionRenderEffect E() {
        return F(fc.b.a.E).l();
    }

    public lh.j F(String str) {
        return G(str, true);
    }

    public lh.j G(String str, boolean z10) {
        if (fc.b.b(str)) {
            dc.e.f(f14404c, "TranThubUnionRenderEffect");
            re.k kVar = this.f14407a;
            if (kVar != null) {
                return kVar;
            }
            re.k kVar2 = new re.k(z10);
            this.f14407a = kVar2;
            return kVar2;
        }
        dc.e.f(f14404c, "TranAospUnionRenderEffect");
        b9.j jVar = this.f14408b;
        if (jVar != null) {
            return jVar;
        }
        b9.j jVar2 = new b9.j();
        this.f14408b = jVar2;
        return jVar2;
    }

    public boolean H() {
        return F(fc.b.a.E).A();
    }

    public boolean I() {
        return F(fc.b.a.E).I();
    }

    public boolean J() {
        return F(fc.b.a.E).i();
    }

    public boolean K() {
        return F(fc.b.a.E).h();
    }

    public boolean M(int i10) {
        return F(fc.b.a.E).H(i10);
    }

    public boolean N() {
        return F(fc.b.a.E).J();
    }

    public void O(int i10) {
        F(fc.b.a.G).B(i10);
    }

    public void P(int i10) {
        F(fc.b.a.E).q(i10);
    }

    public final TranUnionRenderEffect.TranBlendColor a(a aVar) {
        if (aVar == a.G1) {
            return TranUnionRenderEffect.TranBlendColor.MODE_G1;
        }
        if (aVar == a.G2) {
            return TranUnionRenderEffect.TranBlendColor.MODE_G2;
        }
        if (aVar == a.G3) {
            return TranUnionRenderEffect.TranBlendColor.MODE_G3;
        }
        if (aVar == a.L1_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L1_LIGHT;
        }
        if (aVar == a.L2_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L2_LIGHT;
        }
        if (aVar == a.L3_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L3_LIGHT;
        }
        if (aVar == a.L4_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L4_LIGHT;
        }
        if (aVar == a.L1_DARK) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L1_DARK;
        }
        if (aVar == a.L2_DARK) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L2_DARK;
        }
        if (aVar == a.L3_DARK) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L3_DARK;
        }
        if (aVar == a.L4_DARK) {
            return TranUnionRenderEffect.TranBlendColor.MODE_L4_DARK;
        }
        if (aVar == a.GT1_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_GT1_LIGHT;
        }
        if (aVar == a.GT2_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_GT2_LIGHT;
        }
        if (aVar == a.GT3_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_GT3_LIGHT;
        }
        if (aVar == a.GT4_LIGHT) {
            return TranUnionRenderEffect.TranBlendColor.MODE_GT4_LIGHT;
        }
        if (aVar == a.GT1_DARK) {
            return TranUnionRenderEffect.TranBlendColor.MODE_GT1_DARK;
        }
        if (aVar == a.GT2_DARK) {
            return TranUnionRenderEffect.TranBlendColor.MODE_GT2_DARK;
        }
        if (aVar == a.GT3_DARK) {
            return TranUnionRenderEffect.TranBlendColor.MODE_GT3_DARK;
        }
        return aVar == a.GT4_DARK ? TranUnionRenderEffect.TranBlendColor.MODE_GT4_DARK : TranUnionRenderEffect.TranBlendColor.MODE_NONE;
    }

    public void b() {
        F(fc.b.a.E).s();
    }

    public void c() {
        F(fc.b.a.E).b();
    }

    public void d() {
        F(fc.b.a.E).G();
    }

    public void e() {
        F(fc.b.a.E).a();
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && ((l) obj).E() == E();
    }

    public void f() {
        F(fc.b.a.E).p();
    }

    public void g() {
        F(fc.b.a.E).c();
    }

    public void h() {
        F(fc.b.a.E).o();
    }

    public void i() {
        F(fc.b.a.E).K();
    }

    public void j() {
        F(fc.b.a.E).e();
    }

    public void k() {
        F(fc.b.a.E).g();
    }

    public void l() {
        F(fc.b.a.E).E();
    }

    public void m() {
        F(fc.b.a.E).f();
    }

    public void n() {
        F(fc.b.a.E).C();
    }

    public void o() {
        F(fc.b.a.E).x();
    }

    public void p(int i10, int i11, int i12, int i13, int i14, int i15) {
        F(fc.b.a.E).v(i10, i11, i12, i13, i14, i15);
    }

    public void q(a aVar) {
        F(fc.b.a.E).m(a(aVar));
    }

    public void r(int i10, int i11, int i12, int i13, int i14, int i15) {
        F(fc.b.a.E).d(i10, i11, i12, i13, i14, i15);
    }

    public void s(a aVar) {
        F(fc.b.a.E).z(a(aVar));
    }

    public void t() {
        F(fc.b.a.E).D();
    }

    public void u(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        F(fc.b.a.G).k(i10, i11, i12, i13, i14, i15, i16, i17, i18);
    }

    public void v(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        F(fc.b.a.G).w(i10, i11, i12, i13, i14, i15, i16, i17, i18);
    }

    public void w(float f10) {
        F(fc.b.a.E).y(f10);
    }

    public void x(float f10) {
        F(fc.b.a.E).j(f10);
    }

    public void y(float f10) {
        F(fc.b.a.E).F(f10);
    }

    public void z(float f10) {
        F(fc.b.a.E).n(f10);
    }

    public l(TranUnionRenderEffect tranUnionRenderEffect) {
        lh.j jVarG = G(fc.b.a.E, false);
        if (jVarG instanceof re.k) {
            ((re.k) jVarG).M(tranUnionRenderEffect);
        } else {
            dc.e.c(f14404c, "re-establish TranUnionRenderEffectProxy fail: mAospService not support.");
        }
    }
}
