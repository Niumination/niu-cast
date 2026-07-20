package k5;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class j0 implements e0<j.d, MotionEvent> {
    public static final int A = 4;
    public static final int B = 8;
    public static final int C = 16;
    public static final int D = 2048;
    public static final int E = 4096;
    public static final int F = 2304;
    public static final int G = 2305;
    public static final int H = 3;
    public static final int I = 0;
    public static final int J = 1;
    public static final int K = 2;
    public static final int L = 3;
    public static final int M = 4;
    public static final float N;
    public static final int O;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9029r = "MouseEventConverter";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f9030s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f9031t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f9032u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f9033v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f9034w = 5;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f9035x = 6;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f9036y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f9037z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f9038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9040c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f9046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f9047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f9048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f9049l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public i6.c<j.d> f9051n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9041d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9042e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a[] f9043f = new a[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9044g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9045h = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9050m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f9052o = new f0();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f9053p = new g0();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f9054q = new h0();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f9055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f9056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f9057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f9058d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f9059e;

        public final void i() {
            this.f9059e = false;
            this.f9055a = 0.0f;
            this.f9056b = 0.0f;
            this.f9057c = 0.0f;
            this.f9058d = 0.0f;
        }

        public final void j(float f10, float f11) {
            this.f9055a = f10;
            this.f9056b = f11;
            this.f9059e = true;
        }

        public final void k(float f10, float f11) {
            this.f9057c = f10;
            this.f9058d = f11;
            this.f9059e = true;
        }

        public a() {
            this.f9055a = 0.0f;
            this.f9056b = 0.0f;
            this.f9057c = 0.0f;
            this.f9058d = 0.0f;
            this.f9059e = false;
        }
    }

    public interface b {
        boolean a(float f10, float f11);
    }

    static {
        float f10 = DisplayMetrics.DENSITY_DEVICE_STABLE / 160.0f;
        N = f10;
        O = (int) (((double) (f10 * 2.0f)) + 0.5d);
    }

    public j0(View view) {
        this.f9038a = view;
        for (int i10 = 0; i10 < 3; i10++) {
            this.f9043f[i10] = new a();
        }
    }

    public static /* synthetic */ boolean A(float f10, float f11) {
        if (f10 != f11) {
            return false;
        }
        return f10 == 1.0f || f11 == 2.0f;
    }

    private Pair<Double, Double> h(float f10, float f11) {
        int i10 = this.f9050m;
        if (i10 == 1) {
            return new Pair<>(Double.valueOf(q(Math.abs(this.f9040c - f11))), Double.valueOf(p(f10)));
        }
        if (i10 == 2) {
            return new Pair<>(Double.valueOf(p(Math.abs(this.f9039b - f10))), Double.valueOf(q(Math.abs(this.f9040c - f11))));
        }
        if (i10 != 3) {
            return new Pair<>(Double.valueOf(p(f10)), Double.valueOf(q(f11)));
        }
        return new Pair<>(Double.valueOf(q(f11)), Double.valueOf(p(Math.abs(this.f9039b - f10))));
    }

    private double p(float f10) {
        if (this.f9039b == 0) {
            return 0.0d;
        }
        return ((double) (f10 - this.f9038a.getLeft())) / ((double) this.f9039b);
    }

    private double q(float f10) {
        if (this.f9040c == 0) {
            return 0.0d;
        }
        return ((double) (f10 - this.f9038a.getTop())) / ((double) this.f9040c);
    }

    public static /* synthetic */ boolean y(float f10, float f11) {
        return f10 != f11;
    }

    public static /* synthetic */ boolean z(float f10, float f11) {
        if (f10 != f11) {
            return false;
        }
        return f10 == 3.0f || f11 == 4.0f;
    }

    public final boolean B(MotionEvent motionEvent) {
        float fAbs = Math.abs(this.f9048k - motionEvent.getX());
        float fAbs2 = Math.abs(this.f9049l - motionEvent.getY());
        return Math.sqrt((double) ((fAbs2 * fAbs2) + (fAbs * fAbs))) > 1.0d;
    }

    public final void C(j.d dVar) {
        i6.c<j.d> cVar = this.f9051n;
        if (cVar != null) {
            cVar.a(dVar);
        }
    }

    public final void D() {
        int i10 = this.f9041d;
        if (i10 == 1) {
            k4.m.e(f9029r, "onError:mouse left button up");
            C(i(this.f9046i, this.f9047j, 4));
            I();
        } else if (i10 == 3) {
            k4.m.e(f9029r, "onError:end zoom mode");
            C(new j.d(0L, G, 0.0d, 0.0d));
        }
    }

    public final void E(MotionEvent motionEvent) {
        if (this.f9041d == 6) {
            k4.m.b(f9029r, "onMove in error mode,not response");
            return;
        }
        if (B(motionEvent)) {
            if (this.f9041d == 1) {
                if (this.f9042e && u(motionEvent)) {
                    this.f9042e = false;
                    k4.m.e(f9029r, "on mouse move with left click:send left down first");
                    C(i(this.f9046i, this.f9047j, 2));
                }
                this.f9048k = motionEvent.getX();
                this.f9049l = motionEvent.getY();
                k4.m.e(f9029r, "on mouse move with left click:x-" + this.f9048k + ",y-" + this.f9049l);
                C(i(motionEvent.getX(), motionEvent.getY(), 1));
            }
            if (motionEvent.getPointerCount() != 2) {
                return;
            }
            int i10 = (this.f9044g + 1) % 3;
            this.f9044g = i10;
            this.f9043f[i10].j(motionEvent.getX(0), motionEvent.getY(0));
            this.f9043f[this.f9044g].k(motionEvent.getX(1), motionEvent.getY(1));
            int i11 = this.f9041d;
            if (i11 == 2) {
                r(motionEvent);
                return;
            }
            if (i11 == 3) {
                int iM = m();
                m2.b.a("on zoom,zDelta:", iM, f9029r);
                C(j(this.f9046i, this.f9047j, F, iM));
            } else if (i11 == 5) {
                int iK = k();
                m2.b.a("on scroll horizontal,zDelta:", iK, f9029r);
                C(j(this.f9046i, this.f9047j, 4096, iK));
            } else if (i11 == 4) {
                int iL = l();
                m2.b.a("on scroll vertical,zDelta:", iL, f9029r);
                C(j(this.f9046i, this.f9047j, 2048, iL));
            }
        }
    }

    public final void F() {
        int i10 = this.f9041d;
        if (i10 == 6) {
            k4.m.c(f9029r, "onPointerDown in error mode,not response");
            return;
        }
        if (this.f9045h > 2) {
            D();
            this.f9041d = 6;
            k4.m.c(f9029r, "already 2 point");
        } else if (i10 != 1) {
            k4.m.c(f9029r, "onTwoFingerDown without mode left click,release");
            this.f9041d = 6;
        } else {
            this.f9041d = 2;
            k4.m.b(f9029r, "mouse left up reason for two finger");
            C(i(this.f9046i, this.f9047j, 4));
        }
    }

    public final void G(MotionEvent motionEvent) {
        this.f9046i = motionEvent.getX();
        this.f9047j = motionEvent.getY();
        this.f9045h = 1;
        k4.m.e(f9029r, "mouse left down without send event");
        this.f9042e = true;
    }

    public final void H(MotionEvent motionEvent) {
        int i10 = this.f9041d;
        if (i10 == 6) {
            k4.m.c(f9029r, "onPressUp in error mode,not response");
            return;
        }
        if (i10 == 1) {
            if (this.f9042e) {
                k4.m.e(f9029r, "mouse left button down before up");
                this.f9042e = false;
                C(i(motionEvent.getX(), motionEvent.getY(), 2));
            }
            k4.m.e(f9029r, "mouse left button up");
            C(i(motionEvent.getX(), motionEvent.getY(), 4));
            I();
            return;
        }
        if (i10 == 2) {
            k4.m.e(f9029r, "mouse right button down");
            C(i(motionEvent.getX(), motionEvent.getY(), 8));
            k4.m.e(f9029r, "mouse right button up");
            C(i(motionEvent.getX(), motionEvent.getY(), 16));
            I();
            return;
        }
        if (i10 == 3) {
            k4.m.e(f9029r, "end zoom mode");
            C(new j.d(0L, G, 0.0d, 0.0d));
            I();
        } else if (i10 == 5) {
            k4.m.e(f9029r, "end scroll horizontal mode");
            I();
        } else if (i10 == 4) {
            k4.m.e(f9029r, "end scroll vertical mode");
            I();
        }
    }

    public final void I() {
        this.f9045h = 0;
        this.f9048k = 0.0f;
        this.f9049l = 0.0f;
        for (a aVar : this.f9043f) {
            aVar.i();
        }
        this.f9044g = -1;
    }

    @Override // k5.e0
    public void a(int i10, int i11) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        this.f9039b = i10;
        this.f9040c = i11;
    }

    @Override // k5.e0
    public void b(int i10) {
        m2.b.a("setOrientation:", i10, f9029r);
        this.f9050m = i10;
    }

    @Override // k5.e0
    public void d(i6.c<j.d> cVar) {
        this.f9051n = cVar;
    }

    public final j.d i(float f10, float f11, int i10) {
        Pair<Double, Double> pairH = h(f10, f11);
        return new j.d(SystemClock.elapsedRealtime(), i10, ((Double) pairH.first).doubleValue(), ((Double) pairH.second).doubleValue());
    }

    public final j.d j(float f10, float f11, int i10, int i11) {
        Pair<Double, Double> pairH = h(f10, f11);
        return new j.d(SystemClock.elapsedRealtime(), i10, ((Double) pairH.first).doubleValue(), ((Double) pairH.second).doubleValue(), i11);
    }

    public final int k() {
        a[] aVarArr = this.f9043f;
        int i10 = this.f9044g;
        a aVar = aVarArr[i10];
        a aVar2 = i10 == 0 ? aVarArr[2] : aVarArr[i10 - 1];
        return (int) n(aVar.f9055a - aVar2.f9055a, aVar.f9057c - aVar2.f9057c);
    }

    public final int l() {
        a[] aVarArr = this.f9043f;
        int i10 = this.f9044g;
        a aVar = aVarArr[i10];
        a aVar2 = i10 == 0 ? aVarArr[2] : aVarArr[i10 - 1];
        return (int) n(aVar.f9056b - aVar2.f9056b, aVar.f9058d - aVar2.f9058d);
    }

    public final int m() {
        a[] aVarArr = this.f9043f;
        int i10 = this.f9044g;
        a aVar = aVarArr[i10];
        a aVar2 = i10 == 0 ? aVarArr[2] : aVarArr[i10 - 1];
        float f10 = aVar.f9055a - aVar.f9057c;
        float f11 = aVar.f9056b - aVar.f9058d;
        float f12 = aVar2.f9055a - aVar2.f9057c;
        float f13 = aVar2.f9056b - aVar2.f9058d;
        return (int) (Math.sqrt((f11 * f11) + (f10 * f10)) - Math.sqrt((f13 * f13) + (f12 * f12)));
    }

    public final double n(float f10, float f11) {
        if (f10 == f11 && f10 == 0.0f) {
            return 0.0d;
        }
        if (f10 < 0.0f) {
            if (f11 > 0.0f) {
                return 0.0d;
            }
            return Math.floor(Math.min(f10, f11));
        }
        if (f11 < 0.0f) {
            return 0.0d;
        }
        return Math.ceil(Math.max(Math.abs(f10), Math.abs(f11)));
    }

    public final int o(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        float fAbs = Math.abs(f14);
        float fAbs2 = Math.abs(f15);
        int i10 = O;
        if (fAbs < i10 && fAbs2 < i10) {
            return 0;
        }
        if (fAbs2 > fAbs) {
            return f15 < 0.0f ? 1 : 2;
        }
        return f14 < 0.0f ? 3 : 4;
    }

    public final void r(MotionEvent motionEvent) {
        if (this.f9044g == -1) {
            k4.m.e(f9029r, "inferGesture:no point");
            return;
        }
        if (!this.f9043f[2].f9059e) {
            k4.m.e(f9029r, "no sufficient sample point");
            return;
        }
        if (t(this.f9052o)) {
            k4.m.b(f9029r, "enter zoom mode");
            this.f9041d = 3;
            C(i(motionEvent.getX(), motionEvent.getY(), 1));
        } else if (t(this.f9053p)) {
            k4.m.e(f9029r, "enter scroll horizontal mode");
            this.f9041d = 5;
            C(i(motionEvent.getX(), motionEvent.getY(), 1));
        } else if (t(this.f9054q)) {
            k4.m.e(f9029r, "enter scroll vertical mode");
            C(i(motionEvent.getX(), motionEvent.getY(), 1));
            this.f9041d = 4;
        }
    }

    @Override // k5.e0
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f9041d = 1;
            G(motionEvent);
            return;
        }
        if (action == 1) {
            H(motionEvent);
            this.f9042e = false;
            return;
        }
        if (action == 2) {
            E(motionEvent);
            return;
        }
        if (action == 5) {
            this.f9045h++;
            F();
        } else {
            if (action != 6) {
                return;
            }
            this.f9045h--;
            k4.m.b(f9029r, "point up--" + this.f9045h);
        }
    }

    public final boolean t(b bVar) {
        a[] aVarArr = this.f9043f;
        a aVar = aVarArr[1];
        float f10 = aVar.f9055a;
        float f11 = aVar.f9056b;
        a aVar2 = aVarArr[0];
        int iO = o(f10, f11, aVar2.f9055a, aVar2.f9056b);
        a[] aVarArr2 = this.f9043f;
        a aVar3 = aVarArr2[1];
        float f12 = aVar3.f9057c;
        float f13 = aVar3.f9058d;
        a aVar4 = aVarArr2[0];
        return bVar.a((float) iO, (float) o(f12, f13, aVar4.f9057c, aVar4.f9058d));
    }

    public final boolean u(MotionEvent motionEvent) {
        float fAbs = Math.abs(this.f9046i - motionEvent.getX());
        float fAbs2 = Math.abs(this.f9047j - motionEvent.getY());
        return Math.sqrt((double) ((fAbs2 * fAbs2) + (fAbs * fAbs))) > 10.0d;
    }

    public final boolean v() {
        return t(this.f9053p);
    }

    public final boolean w() {
        return t(this.f9054q);
    }

    public final boolean x() {
        return t(this.f9052o);
    }
}
