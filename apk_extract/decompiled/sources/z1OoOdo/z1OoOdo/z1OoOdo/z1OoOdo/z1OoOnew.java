package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import b8.e;
import b8.f;
import df.m;
import sk.b;
import sk.c;
import sk.d;
import tk.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z1OoOnew implements e, View.OnTouchListener, RecyclerView.OnItemTouchListener {
    public static float J = 400.0f;
    public static float K = 1.2f;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public boolean G;
    public final float H;
    public final float I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n6.a f11240c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f11242h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f11252t;
    public d8.d u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public VelocityTracker f11253v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f11254w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f11255x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sk.e f11238a = new sk.e();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11243i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11244j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11245k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11246l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11247m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11248n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11249o = 2;
    public int p = Integer.MAX_VALUE;
    public int q = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11250r = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11251s = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11256y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public sk.a f11257z = null;
    public f A = null;
    public boolean B = false;
    public boolean C = true;
    public final c e = new c(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f11241d = new m(this);

    public z1OoOnew(a aVar) {
        this.f11252t = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = true;
        this.f11239b = aVar;
        n6.a aVar2 = new n6.a(this);
        this.f11240c = aVar2;
        this.f11242h = aVar2;
        ViewConfiguration.get(aVar.getView().getContext());
        this.f11252t = 3;
        VelocityTracker velocityTracker = this.f11253v;
        if (velocityTracker == null) {
            this.f11253v = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        a();
        Context context = aVar.getView().getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        float f = displayMetrics.widthPixels;
        this.H = f;
        float f4 = displayMetrics.heightPixels;
        this.I = f4;
        float fMax = Math.max(f, f4);
        float fMin = Math.min(this.H, this.I);
        float f10 = displayMetrics.densityDpi / 160.0f;
        float f11 = fMax / f10;
        float f12 = fMin / f10;
        Log.d("BounceEffect", "initFoldScreenState maxWidthDp=" + f11 + " minWidthDp=" + f12);
        if (f11 < 400.0f) {
            this.D = true;
        } else if (f12 > 600.0f) {
            this.E = true;
        } else {
            this.F = true;
        }
        if (n()) {
            return;
        }
        this.G = false;
    }

    public final void a() {
        a aVar = this.f11239b;
        aVar.getView().setOnTouchListener(this);
        if (!(aVar.getView() instanceof ViewPager2) || ((ViewPager2) aVar.getView()).getChildAt(0) == null) {
            return;
        }
        ((ViewPager2) aVar.getView()).getChildAt(0).setOnTouchListener(this);
    }

    public final void b(boolean z2) {
        boolean z3;
        d8.d dVar;
        if (z2) {
            if (!this.f11245k && !this.f11244j && (dVar = this.u) != null) {
                dVar.b();
            }
            z3 = true;
        } else {
            z3 = false;
        }
        this.f11244j = z3;
        this.f11246l = z3;
    }

    public final void c(boolean z2) {
        boolean z3;
        d8.d dVar;
        if (z2) {
            if (!this.f11245k && !this.f11244j && (dVar = this.u) != null) {
                dVar.b();
            }
            z3 = true;
        } else {
            z3 = false;
        }
        this.f11245k = z3;
        this.f11247m = z3;
    }

    public final float e(float f) {
        double dPow;
        double d7;
        float f4 = 1.0f - f;
        if (this.D) {
            dPow = Math.pow(f4, 4.0d);
            d7 = 0.4000000059604645d;
        } else {
            dPow = Math.pow(f4, 4.0d);
            d7 = 0.800000011920929d;
        }
        return (float) (dPow * d7);
    }

    public abstract float f(float f, float f4, boolean z2, boolean z3);

    public abstract float g(VelocityTracker velocityTracker);

    public abstract float h(View view);

    public abstract void i();

    public abstract void j(View view, float f);

    public final void k(d dVar) {
        d dVar2 = this.f11242h;
        this.f11242h = dVar;
        dVar.e(dVar2);
        Log.d("BounceEffect", "from:" + dVar2.b() + "to" + this.f11242h.b());
    }

    public abstract b l();

    public abstract boolean m(View view);

    public boolean n() {
        return !(this instanceof z1OoOif);
    }

    public final void o() {
        this.e.getClass();
        ((b) this.f11240c.f8122b).f10146c = false;
        ((b) this.f11241d.f4460d).f10146c = false;
        this.p = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.f11250r = Integer.MAX_VALUE;
        this.f11251s = Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return this.f11242h.a(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean z2) {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11255x = motionEvent.getRawY();
            return this.f11242h.a(motionEvent);
        }
        if (action != 1) {
            if (action == 2) {
                this.f11254w = motionEvent.getRawY() - this.f11255x;
                this.f11255x = motionEvent.getRawY();
                return this.f11242h.c(motionEvent);
            }
            if (action != 3) {
                if (action != 6) {
                    return false;
                }
                o();
                return false;
            }
        }
        o();
        return this.f11242h.f(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
