package j1;

import af.r5;
import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class x extends Drawable implements Drawable.Callback, Animatable {
    public static final List Q = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
    public static final ThreadPoolExecutor R = new ThreadPoolExecutor(0, 2, 35, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new w1.c());
    public Bitmap A;
    public Canvas B;
    public Rect C;
    public RectF D;
    public k1.a E;
    public Rect F;
    public Rect G;
    public RectF H;
    public RectF I;
    public Matrix J;
    public Matrix K;
    public boolean L;
    public a M;
    public final Semaphore N;
    public final a4.c O;
    public float P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f6011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w1.d f6012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6014d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w f6015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f6016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o1.a f6017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r5 f6019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f6020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f6021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final tj.x f6022o;
    public boolean p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public s1.e f6023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6025t;
    public boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6026v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6027w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public h0 f6028x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6029y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Matrix f6030z;

    public x() {
        w1.d dVar = new w1.d();
        this.f6012b = dVar;
        this.f6013c = true;
        this.f6014d = false;
        this.e = false;
        this.f6015h = w.NONE;
        this.f6016i = new ArrayList();
        tj.x xVar = new tj.x();
        xVar.f10264a = new HashSet();
        this.f6022o = xVar;
        this.p = false;
        this.q = true;
        this.f6024s = 255;
        this.f6027w = false;
        this.f6028x = h0.AUTOMATIC;
        this.f6029y = false;
        this.f6030z = new Matrix();
        this.L = false;
        a4.a aVar = new a4.a(this, 2);
        this.N = new Semaphore(1);
        this.O = new a4.c(this, 25);
        this.P = -3.4028235E38f;
        dVar.addUpdateListener(aVar);
    }

    public static void f(Rect rect, RectF rectF) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void a(final p1.f fVar, final ColorFilter colorFilter, final x1.c cVar) {
        s1.e eVar = this.f6023r;
        if (eVar == null) {
            this.f6016i.add(new v() { // from class: j1.r
                @Override // j1.v
                public final void run() {
                    this.f5999a.a(fVar, colorFilter, cVar);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (fVar == p1.f.f8637c) {
            eVar.e(colorFilter, cVar);
        } else {
            p1.g gVar = fVar.f8639b;
            if (gVar != null) {
                gVar.e(colorFilter, cVar);
            } else {
                ArrayList arrayList = new ArrayList();
                this.f6023r.c(fVar, 0, arrayList, new p1.f(new String[0]));
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    ((p1.f) arrayList.get(i8)).f8639b.e(colorFilter, cVar);
                }
                zIsEmpty = true ^ arrayList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (colorFilter == b0.f5942z) {
                u(this.f6012b.a());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    public final boolean b(Context context) {
        n1.a aVar;
        if (this.f6014d) {
            return true;
        }
        if (this.f6013c) {
            d.f5948d.getClass();
            if (context != null) {
                g3.h hVar = w1.g.f10647a;
                if (Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                    aVar = n1.a.STANDARD_MOTION;
                } else {
                    aVar = n1.a.REDUCED_MOTION;
                }
            } else {
                aVar = n1.a.STANDARD_MOTION;
            }
            if (aVar == n1.a.STANDARD_MOTION) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        j jVar = this.f6011a;
        if (jVar == null) {
            return;
        }
        f5.a aVar = u1.s.f10313a;
        Rect rect = jVar.f5972k;
        s1.e eVar = new s1.e(this, new s1.i(Collections.emptyList(), jVar, "__container", -1L, s1.g.PRE_COMP, -1L, null, Collections.emptyList(), new q1.d(), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), s1.h.NONE, null, false, null, null, r1.h.NORMAL), jVar.f5971j, jVar);
        this.f6023r = eVar;
        if (this.u) {
            eVar.p(true);
        }
        this.f6023r.J = this.q;
    }

    public final void d() {
        w1.d dVar = this.f6012b;
        if (dVar.f10644o) {
            dVar.cancel();
            if (!isVisible()) {
                this.f6015h = w.NONE;
            }
        }
        this.f6011a = null;
        this.f6023r = null;
        this.f6017j = null;
        this.P = -3.4028235E38f;
        dVar.f10643n = null;
        dVar.f10641l = -2.1474836E9f;
        dVar.f10642m = 2.1474836E9f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        j jVar;
        s1.e eVar = this.f6023r;
        if (eVar == null) {
            return;
        }
        a aVar = this.M;
        if (aVar == null) {
            aVar = d.f5945a;
        }
        boolean z2 = aVar == a.ENABLED;
        ThreadPoolExecutor threadPoolExecutor = R;
        Semaphore semaphore = this.N;
        a4.c cVar = this.O;
        w1.d dVar = this.f6012b;
        if (z2) {
            try {
                semaphore.acquire();
            } catch (InterruptedException unused) {
                a aVar2 = d.f5945a;
                if (!z2) {
                    return;
                }
                semaphore.release();
                if (eVar.I == dVar.a()) {
                    return;
                }
            } catch (Throwable th2) {
                a aVar3 = d.f5945a;
                if (z2) {
                    semaphore.release();
                    if (eVar.I != dVar.a()) {
                        threadPoolExecutor.execute(cVar);
                    }
                }
                throw th2;
            }
        }
        a aVar4 = d.f5945a;
        if (z2 && (jVar = this.f6011a) != null) {
            float f = this.P;
            float fA = dVar.a();
            this.P = fA;
            if (Math.abs(fA - f) * jVar.b() >= 50.0f) {
                u(dVar.a());
            }
        }
        if (this.e) {
            try {
                if (this.f6029y) {
                    m(canvas, eVar);
                } else {
                    g(canvas);
                }
            } catch (Throwable unused2) {
                w1.b.f10628a.getClass();
                a aVar5 = d.f5945a;
            }
        } else if (this.f6029y) {
            m(canvas, eVar);
        } else {
            g(canvas);
        }
        this.L = false;
        if (z2) {
            semaphore.release();
            if (eVar.I == dVar.a()) {
                return;
            }
            threadPoolExecutor.execute(cVar);
        }
    }

    public final void e() {
        j jVar = this.f6011a;
        if (jVar == null) {
            return;
        }
        this.f6029y = this.f6028x.useSoftwareRendering(Build.VERSION.SDK_INT, jVar.f5976o, jVar.p);
    }

    public final void g(Canvas canvas) {
        s1.e eVar = this.f6023r;
        j jVar = this.f6011a;
        if (eVar == null || jVar == null) {
            return;
        }
        Matrix matrix = this.f6030z;
        matrix.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            matrix.preScale(bounds.width() / jVar.f5972k.width(), bounds.height() / jVar.f5972k.height());
            matrix.preTranslate(bounds.left, bounds.top);
        }
        eVar.g(canvas, matrix, this.f6024s);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6024s;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        j jVar = this.f6011a;
        if (jVar == null) {
            return -1;
        }
        return jVar.f5972k.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        j jVar = this.f6011a;
        if (jVar == null) {
            return -1;
        }
        return jVar.f5972k.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final Context h() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public final r5 i() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f6019l == null) {
            r5 r5Var = new r5(getCallback());
            this.f6019l = r5Var;
            String str = this.f6021n;
            if (str != null) {
                r5Var.f560h = str;
            }
        }
        return this.f6019l;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        if (this.L) {
            return;
        }
        this.L = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return j();
    }

    public final boolean j() {
        w1.d dVar = this.f6012b;
        if (dVar == null) {
            return false;
        }
        return dVar.f10644o;
    }

    public final void k() {
        this.f6016i.clear();
        w1.d dVar = this.f6012b;
        dVar.h(true);
        Iterator it = dVar.f10635c.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorPauseListener) it.next()).onAnimationPause(dVar);
        }
        if (isVisible()) {
            return;
        }
        this.f6015h = w.NONE;
    }

    public final void l() {
        if (this.f6023r == null) {
            this.f6016i.add(new u(this, 1));
            return;
        }
        e();
        boolean zB = b(h());
        w1.d dVar = this.f6012b;
        if (zB || dVar.getRepeatCount() == 0) {
            if (isVisible()) {
                dVar.f10644o = true;
                boolean zD = dVar.d();
                Iterator it = dVar.f10634b.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationStart(dVar, zD);
                }
                dVar.i((int) (dVar.d() ? dVar.b() : dVar.c()));
                dVar.f10637h = 0L;
                dVar.f10640k = 0;
                if (dVar.f10644o) {
                    dVar.h(false);
                    Choreographer.getInstance().postFrameCallback(dVar);
                }
                this.f6015h = w.NONE;
            } else {
                this.f6015h = w.PLAY;
            }
        }
        if (b(h())) {
            return;
        }
        Iterator it2 = Q.iterator();
        p1.i iVarD = null;
        while (it2.hasNext()) {
            iVarD = this.f6011a.d((String) it2.next());
            if (iVarD != null) {
                break;
            }
        }
        if (iVarD != null) {
            o((int) iVarD.f8643b);
        } else {
            o((int) (dVar.f10636d < 0.0f ? dVar.c() : dVar.b()));
        }
        dVar.h(true);
        dVar.e(dVar.d());
        if (isVisible()) {
            return;
        }
        this.f6015h = w.NONE;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00d5  */
    public final void m(Canvas canvas, s1.e eVar) {
        boolean z2;
        if (this.f6011a == null || eVar == null) {
            return;
        }
        if (this.B == null) {
            this.B = new Canvas();
            this.I = new RectF();
            this.J = new Matrix();
            this.K = new Matrix();
            this.C = new Rect();
            this.D = new RectF();
            this.E = new k1.a();
            this.F = new Rect();
            this.G = new Rect();
            this.H = new RectF();
        }
        canvas.getMatrix(this.J);
        canvas.getClipBounds(this.C);
        Rect rect = this.C;
        this.D.set(rect.left, rect.top, rect.right, rect.bottom);
        this.J.mapRect(this.D);
        f(this.C, this.D);
        if (this.q) {
            this.I.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            eVar.d(this.I, null, false);
        }
        this.J.mapRect(this.I);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        RectF rectF = this.I;
        rectF.set(rectF.left * fWidth, rectF.top * fHeight, rectF.right * fWidth, rectF.bottom * fHeight);
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            ViewParent parent = ((View) callback).getParent();
            if (parent instanceof ViewGroup) {
                z2 = !((ViewGroup) parent).getClipChildren();
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (!z2) {
            RectF rectF2 = this.I;
            Rect rect2 = this.C;
            rectF2.intersect(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        int iCeil = (int) Math.ceil(this.I.width());
        int iCeil2 = (int) Math.ceil(this.I.height());
        if (iCeil <= 0 || iCeil2 <= 0) {
            return;
        }
        Bitmap bitmap = this.A;
        if (bitmap == null || bitmap.getWidth() < iCeil || this.A.getHeight() < iCeil2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
            this.A = bitmapCreateBitmap;
            this.B.setBitmap(bitmapCreateBitmap);
            this.L = true;
        } else if (this.A.getWidth() > iCeil || this.A.getHeight() > iCeil2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.A, 0, 0, iCeil, iCeil2);
            this.A = bitmapCreateBitmap2;
            this.B.setBitmap(bitmapCreateBitmap2);
            this.L = true;
        }
        if (this.L) {
            Matrix matrix = this.f6030z;
            matrix.set(this.J);
            matrix.preScale(fWidth, fHeight);
            RectF rectF3 = this.I;
            matrix.postTranslate(-rectF3.left, -rectF3.top);
            this.A.eraseColor(0);
            eVar.g(this.B, matrix, this.f6024s);
            this.J.invert(this.K);
            this.K.mapRect(this.H, this.I);
            f(this.G, this.H);
        }
        this.F.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.A, this.F, this.G, this.E);
    }

    public final void n() {
        if (this.f6023r == null) {
            this.f6016i.add(new u(this, 0));
            return;
        }
        e();
        boolean zB = b(h());
        w1.d dVar = this.f6012b;
        if (zB || dVar.getRepeatCount() == 0) {
            if (isVisible()) {
                dVar.f10644o = true;
                dVar.h(false);
                Choreographer.getInstance().postFrameCallback(dVar);
                dVar.f10637h = 0L;
                if (dVar.d() && dVar.f10639j == dVar.c()) {
                    dVar.i(dVar.b());
                } else if (!dVar.d() && dVar.f10639j == dVar.b()) {
                    dVar.i(dVar.c());
                }
                Iterator it = dVar.f10635c.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorPauseListener) it.next()).onAnimationResume(dVar);
                }
                this.f6015h = w.NONE;
            } else {
                this.f6015h = w.RESUME;
            }
        }
        if (b(h())) {
            return;
        }
        o((int) (dVar.f10636d < 0.0f ? dVar.c() : dVar.b()));
        dVar.h(true);
        dVar.e(dVar.d());
        if (isVisible()) {
            return;
        }
        this.f6015h = w.NONE;
    }

    public final void o(int i8) {
        if (this.f6011a == null) {
            this.f6016i.add(new q(this, i8, 2));
        } else {
            this.f6012b.i(i8);
        }
    }

    public final void p(int i8) {
        if (this.f6011a == null) {
            this.f6016i.add(new q(this, i8, 0));
            return;
        }
        w1.d dVar = this.f6012b;
        dVar.j(dVar.f10641l, i8 + 0.99f);
    }

    public final void q(String str) {
        j jVar = this.f6011a;
        if (jVar == null) {
            this.f6016i.add(new p(this, str, 1));
            return;
        }
        p1.i iVarD = jVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(h0.a.j("Cannot find marker with name ", str, "."));
        }
        p((int) (iVarD.f8643b + iVarD.f8644c));
    }

    public final void r(String str) {
        j jVar = this.f6011a;
        ArrayList arrayList = this.f6016i;
        if (jVar == null) {
            arrayList.add(new p(this, str, 0));
            return;
        }
        p1.i iVarD = jVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(h0.a.j("Cannot find marker with name ", str, "."));
        }
        int i8 = (int) iVarD.f8643b;
        int i9 = ((int) iVarD.f8644c) + i8;
        if (this.f6011a == null) {
            arrayList.add(new t(this, i8, i9));
        } else {
            this.f6012b.j(i8, i9 + 0.99f);
        }
    }

    public final void s(int i8) {
        if (this.f6011a == null) {
            this.f6016i.add(new q(this, i8, 1));
        } else {
            w1.d dVar = this.f6012b;
            dVar.j(i8, (int) dVar.f10642m);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j8) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i8) {
        this.f6024s = i8;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        w1.b.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z3) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z2, z3);
        if (z2) {
            w wVar = this.f6015h;
            if (wVar == w.PLAY) {
                l();
            } else if (wVar == w.RESUME) {
                n();
            }
        } else if (this.f6012b.f10644o) {
            k();
            this.f6015h = w.RESUME;
        } else if (zIsVisible) {
            this.f6015h = w.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        l();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f6016i.clear();
        w1.d dVar = this.f6012b;
        dVar.h(true);
        dVar.e(dVar.d());
        if (isVisible()) {
            return;
        }
        this.f6015h = w.NONE;
    }

    public final void t(String str) {
        j jVar = this.f6011a;
        if (jVar == null) {
            this.f6016i.add(new p(this, str, 2));
            return;
        }
        p1.i iVarD = jVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(h0.a.j("Cannot find marker with name ", str, "."));
        }
        s((int) iVarD.f8643b);
    }

    public final void u(float f) {
        j jVar = this.f6011a;
        if (jVar == null) {
            this.f6016i.add(new s(this, f, 2));
            return;
        }
        a aVar = d.f5945a;
        this.f6012b.i(w1.f.e(jVar.f5973l, jVar.f5974m, f));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }
}
