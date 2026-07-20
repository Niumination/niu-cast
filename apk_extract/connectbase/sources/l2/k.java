package l2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kn.l0;
import kn.n0;
import kn.w;
import lm.d0;
import lm.f0;
import lm.i0;
import lm.t0;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final a f9658j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final String f9659k = "AnimPlayer.ScaleTypeUtil";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9666g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public l2.e f9668i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final d0 f9660a = f0.b(e.INSTANCE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final d0 f9661b = f0.b(d.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final d0 f9662c = f0.b(c.INSTANCE);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public g f9667h = g.FIT_XY;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9669a;

        static {
            int[] iArr = new int[g.values().length];
            iArr[g.FIT_XY.ordinal()] = 1;
            iArr[g.FIT_CENTER.ordinal()] = 2;
            iArr[g.CENTER_CROP.ordinal()] = 3;
            f9669a = iArr;
        }
    }

    public static final class c extends n0 implements jn.a<h> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final h invoke() {
            return new h();
        }
    }

    public static final class d extends n0 implements jn.a<i> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final i invoke() {
            return new i();
        }
    }

    public static final class e extends n0 implements jn.a<j> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final j invoke() {
            return new j();
        }
    }

    public final boolean a() {
        return this.f9663d > 0 && this.f9664e > 0 && this.f9665f > 0 && this.f9666g > 0;
    }

    public final l2.e b() {
        l2.e eVar = this.f9668i;
        if (eVar != null) {
            l2.a.f9640a.e(f9659k, "custom scaleType");
            return eVar;
        }
        l2.a.f9640a.e(f9659k, l0.C("scaleType=", this.f9667h));
        int i10 = b.f9669a[this.f9667h.ordinal()];
        if (i10 == 1) {
            return h();
        }
        if (i10 == 2) {
            return g();
        }
        if (i10 == 3) {
            return f();
        }
        throw new i0();
    }

    @os.l
    public final g c() {
        return this.f9667h;
    }

    @os.l
    public final FrameLayout.LayoutParams d(@os.m View view) {
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        }
        FrameLayout.LayoutParams layoutParams3 = layoutParams2;
        if (a()) {
            return b().a(this.f9663d, this.f9664e, this.f9665f, this.f9666g, layoutParams3);
        }
        l2.a.f9640a.b(f9659k, "params error: layoutWidth=" + this.f9663d + ", layoutHeight=" + this.f9664e + ", videoWidth=" + this.f9665f + ", videoHeight=" + this.f9666g);
        return layoutParams3;
    }

    @os.l
    public final t0<Integer, Integer> e() {
        t0<Integer, Integer> realSize = b().getRealSize();
        l2.a.f9640a.e(f9659k, "get real size (" + realSize.getFirst().intValue() + ", " + realSize.getSecond().intValue() + ')');
        return realSize;
    }

    public final h f() {
        return (h) this.f9662c.getValue();
    }

    public final i g() {
        return (i) this.f9661b.getValue();
    }

    public final j h() {
        return (j) this.f9660a.getValue();
    }

    @os.m
    public final l2.e i() {
        return this.f9668i;
    }

    public final void j(@os.l g gVar) {
        l0.p(gVar, "<set-?>");
        this.f9667h = gVar;
    }

    public final void k(int i10, int i11) {
        this.f9663d = i10;
        this.f9664e = i11;
    }

    public final void l(@os.m l2.e eVar) {
        this.f9668i = eVar;
    }

    public final void m(int i10, int i11) {
        this.f9665f = i10;
        this.f9666g = i11;
    }
}
