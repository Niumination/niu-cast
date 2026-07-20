package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;

import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z1OoOnew implements g6.b, View.OnTouchListener, RecyclerView.OnItemTouchListener {
    public int J;
    public SpringAnimation K;
    public VelocityTracker L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final us.b f21781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f21782c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f21785f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21780a = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21786g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21787i = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f21788n = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f21789p = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f21790v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f21791w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f21792x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f21793y = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f21794z = Integer.MAX_VALUE;
    public int H = Integer.MAX_VALUE;
    public int I = Integer.MAX_VALUE;
    public boolean M = false;
    public ts.a N = null;
    public g6.c O = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z1OoOdo f21784e = new z1OoOdo();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f21783d = new e();

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f21795a;

        public a() {
            this.f21795a = z1OoOnew.this.r();
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public int a() {
            return 0;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean b(MotionEvent motionEvent) {
            z1OoOnew z1ooonew = z1OoOnew.this;
            int rawX = (int) (motionEvent.getRawX(0) + 0.5f);
            z1ooonew.H = rawX;
            z1ooonew.f21793y = rawX;
            z1OoOnew z1ooonew2 = z1OoOnew.this;
            int rawY = (int) (motionEvent.getRawY(0) + 0.5f);
            z1ooonew2.I = rawY;
            z1ooonew2.f21794z = rawY;
            z1OoOnew.s(z1OoOnew.this);
            z1OoOnew.this.L.addMovement(motionEvent);
            return false;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean c(MotionEvent motionEvent) {
            z1OoOnew z1ooonew = z1OoOnew.this;
            if (z1ooonew.f21786g && !z1ooonew.f21787i && !z1ooonew.f21788n) {
                z1ooonew.H = (int) (motionEvent.getRawX(0) + 0.5f);
                z1OoOnew.this.I = (int) (motionEvent.getRawY(0) + 0.5f);
                return false;
            }
            if (z1ooonew.f21789p || z1ooonew.f21790v) {
                z1ooonew.f21793y = z1ooonew.H;
                z1ooonew.f21794z = z1ooonew.I;
                z1ooonew.f21789p = false;
                z1ooonew.f21790v = false;
            }
            View viewA = z1ooonew.f21781b.a();
            boolean zA = this.f21795a.a(viewA, motionEvent, z1OoOnew.this.f21782c);
            z1OoOnew.o(z1OoOnew.this);
            z1OoOnew.this.L.addMovement(motionEvent);
            c cVar = this.f21795a;
            if (!cVar.f21799c || zA) {
                return false;
            }
            z1OoOnew z1ooonew2 = z1OoOnew.this;
            if (z1ooonew2.f21786g && ((z1ooonew2.f21787i && !cVar.f21800d) || (z1ooonew2.f21788n && cVar.f21800d))) {
                return false;
            }
            if (!(z1ooonew2.f21781b.c() && this.f21795a.f21800d) && (!z1OoOnew.this.f21781b.b() || this.f21795a.f21800d)) {
                return false;
            }
            z1OoOnew.this.f21780a.f21801a = motionEvent.getPointerId(0);
            d dVar = z1OoOnew.this.f21780a;
            dVar.f21802b = 0.0f;
            dVar.f21803c = this.f21795a.f21800d;
            Log.d("BounceEffect", "about to switch to overscroll mode, start mDir:" + z1OoOnew.this.f21780a.f21803c + "mAbsOffset:" + z1OoOnew.this.f21780a.f21802b);
            ts.a aVar = z1OoOnew.this.N;
            if (aVar != null) {
                aVar.a();
            }
            z1OoOnew z1ooonew3 = z1OoOnew.this;
            z1ooonew3.n(z1ooonew3.f21783d);
            c cVar2 = this.f21795a;
            float f10 = cVar2.f21798b;
            z1OoOnew z1ooonew4 = z1OoOnew.this;
            z1OoOnew.this.m(viewA, this.f21795a.f21797a + (z1ooonew4.i(cVar2.f21797a, f10, cVar2.f21800d == z1ooonew4.f21780a.f21803c) * f10));
            if (viewA instanceof AbsListView) {
                AbsListView absListView = (AbsListView) viewA;
                for (int i10 = 0; i10 < absListView.getChildCount(); i10++) {
                    View childAt = absListView.getChildAt(i10);
                    if (childAt != null) {
                        childAt.setPressed(false);
                        childAt.setSelected(false);
                    }
                }
            }
            viewA.cancelPendingInputEvents();
            viewA.setPressed(false);
            viewA.setSelected(false);
            z1OoOnew z1ooonew5 = z1OoOnew.this;
            if (!z1ooonew5.f21786g || (!z1ooonew5.f21788n && !z1ooonew5.f21787i)) {
                return true;
            }
            Log.d("BounceEffect", "report move to super");
            return false;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public void d(b bVar) {
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean e(MotionEvent motionEvent) {
            z1OoOnew.q(z1OoOnew.this);
            return false;
        }
    }

    public interface b {
        int a();

        boolean b(MotionEvent motionEvent);

        boolean c(MotionEvent motionEvent);

        void d(b bVar);

        boolean e(MotionEvent motionEvent);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f21797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f21798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f21800d;

        public abstract boolean a(View view, MotionEvent motionEvent, b bVar);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f21802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21803c;
    }

    public class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f21804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21805b;

        public e() {
            this.f21804a = z1OoOnew.this.r();
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public int a() {
            return this.f21805b;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean b(MotionEvent motionEvent) {
            z1OoOnew z1ooonew = z1OoOnew.this;
            int rawX = (int) (motionEvent.getRawX(0) + 0.5f);
            z1ooonew.H = rawX;
            z1ooonew.f21793y = rawX;
            z1OoOnew z1ooonew2 = z1OoOnew.this;
            int rawY = (int) (motionEvent.getRawY(0) + 0.5f);
            z1ooonew2.I = rawY;
            z1ooonew2.f21794z = rawY;
            Log.d("BounceEffect", "touch down overscroll");
            z1OoOnew.s(z1OoOnew.this);
            z1OoOnew.this.L.addMovement(motionEvent);
            return true;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean c(MotionEvent motionEvent) {
            if (z1OoOnew.this.f21780a.f21801a != motionEvent.getPointerId(0)) {
                z1OoOnew z1ooonew = z1OoOnew.this;
                z1ooonew.n(z1ooonew.f21784e);
                return true;
            }
            z1OoOnew.o(z1OoOnew.this);
            z1OoOnew.this.L.addMovement(motionEvent);
            z1OoOnew z1ooonew2 = z1OoOnew.this;
            if (z1ooonew2.f21786g && !z1ooonew2.f21787i && !z1ooonew2.f21788n) {
                z1ooonew2.H = (int) (motionEvent.getRawX(0) + 0.5f);
                z1OoOnew.this.I = (int) (motionEvent.getRawY(0) + 0.5f);
                return false;
            }
            View viewA = z1ooonew2.f21781b.a();
            this.f21804a.a(viewA, motionEvent, z1OoOnew.this.f21783d);
            c cVar = this.f21804a;
            float f10 = cVar.f21798b;
            z1OoOnew z1ooonew3 = z1OoOnew.this;
            float fI = z1ooonew3.i(cVar.f21797a, f10, cVar.f21800d == z1ooonew3.f21780a.f21803c) * f10;
            c cVar2 = this.f21804a;
            float f11 = cVar2.f21797a + fI;
            z1OoOnew z1ooonew4 = z1OoOnew.this;
            d dVar = z1ooonew4.f21780a;
            boolean z10 = dVar.f21803c;
            if ((z10 && !cVar2.f21800d && f11 <= dVar.f21802b) || (!z10 && cVar2.f21800d && f11 >= dVar.f21802b)) {
                z1ooonew4.n(z1ooonew4.f21782c);
                f11 = z1OoOnew.this.f21780a.f21802b;
            }
            z1OoOnew.this.m(viewA, f11);
            return true;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public void d(b bVar) {
            this.f21805b = z1OoOnew.this.f21780a.f21803c ? 1 : 2;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean e(MotionEvent motionEvent) {
            z1OoOnew z1ooonew = z1OoOnew.this;
            z1ooonew.n(z1ooonew.f21784e);
            z1OoOnew.q(z1OoOnew.this);
            Log.d("BounceEffect", "touch up overscroll");
            z1OoOnew z1ooonew2 = z1OoOnew.this;
            if (z1ooonew2.f21786g && (z1ooonew2.f21788n || z1ooonew2.f21787i)) {
                return false;
            }
            if (!(z1ooonew2.f21781b.a() instanceof RecyclerView)) {
                return true;
            }
            ((RecyclerView) z1OoOnew.this.f21781b.a()).stopScroll();
            return true;
        }
    }

    public class z1OoOdo implements b, DynamicAnimation.OnAnimationEndListener, DynamicAnimation.OnAnimationUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f21807a;

        public z1OoOdo() {
            this.f21807a = z1OoOnew.this.r();
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public int a() {
            return 3;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean b(MotionEvent motionEvent) {
            Log.d("BounceEffect", "touch down bounceback");
            if (z1OoOnew.this.f21780a.f21801a != motionEvent.getPointerId(0)) {
                return true;
            }
            z1OoOnew z1ooonew = z1OoOnew.this;
            int rawX = (int) (motionEvent.getRawX(0) + 0.5f);
            z1ooonew.H = rawX;
            z1ooonew.f21793y = rawX;
            z1OoOnew z1ooonew2 = z1OoOnew.this;
            int rawY = (int) (motionEvent.getRawY(0) + 0.5f);
            z1ooonew2.I = rawY;
            z1ooonew2.f21794z = rawY;
            z1OoOnew.s(z1OoOnew.this);
            z1OoOnew.this.L.addMovement(motionEvent);
            if (!z1OoOnew.this.f21786g) {
                return true;
            }
            Log.d("BounceEffect", "touch down bounceback not handle");
            return false;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean c(MotionEvent motionEvent) {
            if (z1OoOnew.this.f21780a.f21801a != motionEvent.getPointerId(0)) {
                return true;
            }
            View viewA = z1OoOnew.this.f21781b.a();
            this.f21807a.a(viewA, motionEvent, z1OoOnew.this.f21784e);
            z1OoOnew.o(z1OoOnew.this);
            z1OoOnew.this.L.addMovement(motionEvent);
            c cVar = this.f21807a;
            if (!cVar.f21799c) {
                return false;
            }
            float f10 = cVar.f21797a + cVar.f21798b;
            SpringAnimation springAnimation = z1OoOnew.this.K;
            if (springAnimation != null && springAnimation.isRunning()) {
                z1OoOnew z1ooonew = z1OoOnew.this;
                z1ooonew.M = true;
                z1ooonew.K.cancel();
            }
            z1OoOnew z1ooonew2 = z1OoOnew.this;
            if (z1ooonew2.f21780a.f21803c == this.f21807a.f21800d) {
                z1ooonew2.n(z1ooonew2.f21783d);
                Log.d("BounceEffect", "touch move bounceback handled");
                return true;
            }
            Log.d("BounceEffect", "out bounceback:" + f10 + "orig:" + z1OoOnew.this.f21780a.f21802b);
            z1OoOnew z1ooonew3 = z1OoOnew.this;
            d dVar = z1ooonew3.f21780a;
            boolean z10 = dVar.f21803c;
            if ((z10 && !this.f21807a.f21800d && f10 <= dVar.f21802b) || (!z10 && this.f21807a.f21800d && f10 >= dVar.f21802b)) {
                z1ooonew3.n(z1ooonew3.f21782c);
                f10 = z1OoOnew.this.f21780a.f21802b;
            }
            z1OoOnew.this.m(viewA, f10);
            return true;
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public void d(b bVar) {
            if (bVar == this) {
                return;
            }
            z1OoOnew.this.l();
            z1OoOnew.this.K.addEndListener(this);
            z1OoOnew.this.K.addUpdateListener(this);
            View viewA = z1OoOnew.this.f21781b.a();
            z1OoOnew.this.f21792x = viewA.getOverScrollMode();
            viewA.setOverScrollMode(2);
            if (z1OoOnew.this.t(viewA)) {
                z1OoOnew z1ooonew = z1OoOnew.this;
                z1ooonew.K.setStartVelocity(z1ooonew.j(z1ooonew.L));
                z1OoOnew.this.K.start();
            }
        }

        @Override // z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew.b
        public boolean e(MotionEvent motionEvent) {
            if (z1OoOnew.this.f21780a.f21801a != motionEvent.getPointerId(0)) {
                return true;
            }
            if (z1OoOnew.this.K != null) {
                Log.d("BounceEffect", "touch up bounceback start anim");
                z1OoOnew z1ooonew = z1OoOnew.this;
                if (z1ooonew.t(z1ooonew.f21781b.a())) {
                    z1OoOnew z1ooonew2 = z1OoOnew.this;
                    z1ooonew2.K.setStartVelocity(z1ooonew2.j(z1ooonew2.L));
                    z1OoOnew.this.K.start();
                }
            }
            z1OoOnew.q(z1OoOnew.this);
            View viewA = z1OoOnew.this.f21781b.a();
            this.f21807a.a(viewA, motionEvent, z1OoOnew.this.f21783d);
            Log.d("BounceEffect", "touch up bounceback");
            z1OoOnew z1ooonew3 = z1OoOnew.this;
            if (z1ooonew3.f21780a.f21803c != this.f21807a.f21800d) {
                viewA.setOverScrollMode(z1ooonew3.f21792x);
                Log.d("BounceEffect", "touch up bounceback not handle");
                return false;
            }
            if (z1ooonew3.f21781b.a() instanceof RecyclerView) {
                ((RecyclerView) z1OoOnew.this.f21781b.a()).stopScroll();
            }
            return true;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
            Log.d("BounceEffect", "onAnimationEnd");
            z1OoOnew.this.f21781b.a().setOverScrollMode(z1OoOnew.this.f21792x);
            z1OoOnew z1ooonew = z1OoOnew.this;
            if (z1ooonew.f21785f == z1ooonew.f21784e) {
                if (z1ooonew.M) {
                    z1ooonew.M = false;
                } else {
                    z1ooonew.n(z1ooonew.f21782c);
                }
            }
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            z1OoOnew z1ooonew = z1OoOnew.this;
            g6.c cVar = z1ooonew.O;
            if (cVar != null) {
                cVar.a(z1ooonew.k(z1ooonew.f21781b.a()));
            }
        }
    }

    public z1OoOnew(us.b bVar) {
        this.J = 0;
        this.f21781b = bVar;
        a aVar = new a();
        this.f21782c = aVar;
        this.f21785f = aVar;
        ViewConfiguration.get(bVar.a().getContext());
        this.J = 3;
        p();
        b();
    }

    public static void o(z1OoOnew z1ooonew) {
        if (z1ooonew.L == null) {
            z1ooonew.L = VelocityTracker.obtain();
        }
    }

    public static void q(z1OoOnew z1ooonew) {
        VelocityTracker velocityTracker = z1ooonew.L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            z1ooonew.L = null;
        }
    }

    public static void s(z1OoOnew z1ooonew) {
        VelocityTracker velocityTracker = z1ooonew.L;
        if (velocityTracker == null) {
            z1ooonew.L = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    @Override // g6.b
    public void a() {
        if (this.f21785f != this.f21782c) {
            Log.e("BounceEffect", "detaching while overscroll is in effect.");
            return;
        }
        this.f21781b.a().setOnTouchListener(null);
        if (!(this.f21781b.a() instanceof ViewPager2) || ((ViewPager2) this.f21781b.a()).getChildAt(0) == null) {
            return;
        }
        ((ViewPager2) this.f21781b.a()).getChildAt(0).setOnTouchListener(null);
    }

    @Override // g6.b
    public void b() {
        this.f21781b.a().setOnTouchListener(this);
        if (!(this.f21781b.a() instanceof ViewPager2) || ((ViewPager2) this.f21781b.a()).getChildAt(0) == null) {
            return;
        }
        ((ViewPager2) this.f21781b.a()).getChildAt(0).setOnTouchListener(this);
    }

    @Override // g6.b
    public void c(boolean z10) {
        boolean z11;
        SpringAnimation springAnimation;
        if (z10) {
            if (!this.f21788n && !this.f21787i && (springAnimation = this.K) != null) {
                springAnimation.cancel();
            }
            z11 = true;
        } else {
            z11 = false;
        }
        this.f21787i = z11;
        this.f21789p = z11;
    }

    @Override // g6.b
    public boolean d() {
        return this.f21785f == this.f21782c;
    }

    @Override // g6.b
    public void e(boolean z10) {
        boolean z11;
        SpringAnimation springAnimation;
        if (z10) {
            if (!this.f21788n && !this.f21787i && (springAnimation = this.K) != null) {
                springAnimation.cancel();
            }
            z11 = true;
        } else {
            z11 = false;
        }
        this.f21788n = z11;
        this.f21790v = z11;
    }

    @Override // g6.b
    public void f(boolean z10) {
        this.f21791w = z10;
    }

    @Override // g6.b
    public void g(boolean z10) {
        this.f21786g = z10;
    }

    @Override // g6.b
    public void h(g6.c cVar) {
        this.O = cVar;
    }

    public abstract float i(float f10, float f11, boolean z10);

    public abstract float j(VelocityTracker velocityTracker);

    public abstract float k(View view);

    public abstract void l();

    public abstract void m(View view, float f10);

    public void n(b bVar) {
        b bVar2 = this.f21785f;
        this.f21785f = bVar;
        bVar.d(bVar2);
        Log.d("BounceEffect", "from:" + bVar2.a() + TypedValues.TransitionType.S_TO + this.f21785f.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return this.f21785f.b(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return this.f21785f.b(motionEvent);
        }
        if (action != 1) {
            if (action == 2) {
                return this.f21785f.c(motionEvent);
            }
            if (action != 3) {
                return false;
            }
        }
        this.f21784e.getClass();
        this.f21782c.f21795a.f21799c = false;
        this.f21783d.f21804a.f21799c = false;
        this.f21793y = Integer.MAX_VALUE;
        this.f21794z = Integer.MAX_VALUE;
        this.H = Integer.MAX_VALUE;
        this.I = Integer.MAX_VALUE;
        return this.f21785f.e(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public final void p() {
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker == null) {
            this.L = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public abstract c r();

    public abstract boolean t(View view);
}
