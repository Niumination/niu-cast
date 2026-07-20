package n0;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j extends Drawable implements Drawable.Callback, Animatable {
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = -1;

    @Nullable
    public v0.b H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f10986a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n0.g f10987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0.e f10988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f10989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<r> f10992g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f10993i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public r0.b f10994n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public String f10995p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public n0.d f10996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public r0.a f10997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public n0.c f10998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public v f10999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11000z;

    public class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11001a;

        public a(String str) {
            this.f11001a = str;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.m0(this.f11001a);
        }
    }

    public class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f11005c;

        public b(String str, String str2, boolean z10) {
            this.f11003a = str;
            this.f11004b = str2;
            this.f11005c = z10;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.n0(this.f11003a, this.f11004b, this.f11005c);
        }
    }

    public class c implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11008b;

        public c(int i10, int i11) {
            this.f11007a = i10;
            this.f11008b = i11;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.l0(this.f11007a, this.f11008b);
        }
    }

    public class d implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f11010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f11011b;

        public d(float f10, float f11) {
            this.f11010a = f10;
            this.f11011b = f11;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.o0(this.f11010a, this.f11011b);
        }
    }

    public class e implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11013a;

        public e(int i10) {
            this.f11013a = i10;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.f0(this.f11013a);
        }
    }

    public class f implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f11015a;

        public f(float f10) {
            this.f11015a = f10;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.u0(this.f11015a);
        }
    }

    public class g implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s0.f f11017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a1.j f11019c;

        public g(s0.f fVar, Object obj, a1.j jVar) {
            this.f11017a = fVar;
            this.f11018b = obj;
            this.f11019c = jVar;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.f(this.f11017a, this.f11018b, this.f11019c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class h<T> extends a1.j<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a1.l f11021d;

        public h(a1.l lVar) {
            this.f11021d = lVar;
        }

        @Override // a1.j
        public T a(a1.b<T> bVar) {
            return (T) this.f11021d.a(bVar);
        }
    }

    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (j.this.H != null) {
                j jVar = j.this;
                jVar.H.H(jVar.f10988c.i());
            }
        }
    }

    /* JADX INFO: renamed from: n0.j$j, reason: collision with other inner class name */
    public class C0289j implements r {
        public C0289j() {
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.T();
        }
    }

    public class k implements r {
        public k() {
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.a0();
        }
    }

    public class l implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11026a;

        public l(int i10) {
            this.f11026a = i10;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.p0(this.f11026a);
        }
    }

    public class m implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f11028a;

        public m(float f10) {
            this.f11028a = f10;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.r0(this.f11028a);
        }
    }

    public class n implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11030a;

        public n(int i10) {
            this.f11030a = i10;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.i0(this.f11030a);
        }
    }

    public class o implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f11032a;

        public o(float f10) {
            this.f11032a = f10;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.k0(this.f11032a);
        }
    }

    public class p implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11034a;

        public p(String str) {
            this.f11034a = str;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.q0(this.f11034a);
        }
    }

    public class q implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11036a;

        public q(String str) {
            this.f11036a = str;
        }

        @Override // n0.j.r
        public void a(n0.g gVar) {
            j.this.j0(this.f11036a);
        }
    }

    public interface r {
        void a(n0.g gVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface s {
    }

    public j() {
        z0.e eVar = new z0.e();
        this.f10988c = eVar;
        this.f10989d = 1.0f;
        this.f10990e = true;
        this.f10991f = false;
        this.f10992g = new ArrayList<>();
        i iVar = new i();
        this.f10993i = iVar;
        this.I = 255;
        this.M = true;
        this.N = false;
        eVar.addUpdateListener(iVar);
    }

    public float A() {
        return this.f10988c.l();
    }

    public void A0(Boolean bool) {
        this.f10990e = bool.booleanValue();
    }

    public final float B(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f10987b.b().width(), canvas.getHeight() / this.f10987b.b().height());
    }

    public void B0(v vVar) {
        this.f10999y = vVar;
    }

    public float C() {
        return this.f10988c.m();
    }

    @Nullable
    public Bitmap C0(String str, @Nullable Bitmap bitmap) {
        r0.b bVarY = y();
        if (bVarY == null) {
            z0.d.e("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapE = bVarY.e(str, bitmap);
        invalidateSelf();
        return bitmapE;
    }

    @Nullable
    public n0.s D() {
        n0.g gVar = this.f10987b;
        if (gVar != null) {
            return gVar.n();
        }
        return null;
    }

    public boolean D0() {
        return this.f10999y == null && this.f10987b.c().size() > 0;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float E() {
        return this.f10988c.i();
    }

    public int F() {
        return this.f10988c.getRepeatCount();
    }

    public int G() {
        return this.f10988c.getRepeatMode();
    }

    public float H() {
        return this.f10989d;
    }

    public float I() {
        return this.f10988c.n();
    }

    @Nullable
    public v J() {
        return this.f10999y;
    }

    @Nullable
    public Typeface K(String str, String str2) {
        r0.a aVarV = v();
        if (aVarV != null) {
            return aVarV.b(str, str2);
        }
        return null;
    }

    public boolean L() {
        v0.b bVar = this.H;
        return bVar != null && bVar.K();
    }

    public boolean M() {
        v0.b bVar = this.H;
        return bVar != null && bVar.L();
    }

    public boolean N() {
        z0.e eVar = this.f10988c;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean O() {
        return this.L;
    }

    public boolean P() {
        return this.f10988c.getRepeatCount() == -1;
    }

    public boolean Q() {
        return this.f11000z;
    }

    @Deprecated
    public void R(boolean z10) {
        this.f10988c.setRepeatCount(z10 ? -1 : 0);
    }

    public void S() {
        this.f10992g.clear();
        this.f10988c.p();
    }

    @MainThread
    public void T() {
        if (this.H == null) {
            this.f10992g.add(new C0289j());
            return;
        }
        if (this.f10990e || F() == 0) {
            this.f10988c.q();
        }
        if (this.f10990e) {
            return;
        }
        f0((int) (I() < 0.0f ? C() : A()));
        this.f10988c.h();
    }

    public void U() {
        this.f10988c.removeAllListeners();
    }

    public void V() {
        this.f10988c.removeAllUpdateListeners();
        this.f10988c.addUpdateListener(this.f10993i);
    }

    public void W(Animator.AnimatorListener animatorListener) {
        this.f10988c.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void X(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f10988c.removePauseListener(animatorPauseListener);
    }

    public void Y(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f10988c.removeUpdateListener(animatorUpdateListener);
    }

    public List<s0.f> Z(s0.f fVar) {
        if (this.H == null) {
            z0.d.e("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.H.e(fVar, 0, arrayList, new s0.f(new String[0]));
        return arrayList;
    }

    @MainThread
    public void a0() {
        if (this.H == null) {
            this.f10992g.add(new k());
            return;
        }
        if (this.f10990e || F() == 0) {
            this.f10988c.u();
        }
        if (this.f10990e) {
            return;
        }
        f0((int) (I() < 0.0f ? C() : A()));
        this.f10988c.h();
    }

    public void b0() {
        this.f10988c.v();
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.f10988c.addListener(animatorListener);
    }

    public void c0(boolean z10) {
        this.L = z10;
    }

    @RequiresApi(api = 19)
    public void d(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f10988c.addPauseListener(animatorPauseListener);
    }

    public boolean d0(n0.g gVar) {
        if (this.f10987b == gVar) {
            return false;
        }
        this.N = false;
        l();
        this.f10987b = gVar;
        j();
        this.f10988c.w(gVar);
        u0(this.f10988c.getAnimatedFraction());
        y0(this.f10989d);
        Iterator it = new ArrayList(this.f10992g).iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.a(gVar);
            }
            it.remove();
        }
        this.f10992g.clear();
        gVar.x(this.J);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.N = false;
        n0.e.a("Drawable#draw");
        if (this.f10991f) {
            try {
                n(canvas);
            } catch (Throwable th2) {
                z0.d.c("Lottie crashed in draw!", th2);
            }
        } else {
            n(canvas);
        }
        n0.e.b("Drawable#draw");
    }

    public void e(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f10988c.addUpdateListener(animatorUpdateListener);
    }

    public void e0(n0.c cVar) {
        this.f10998x = cVar;
        r0.a aVar = this.f10997w;
        if (aVar != null) {
            aVar.d(cVar);
        }
    }

    public <T> void f(s0.f fVar, T t10, a1.j<T> jVar) {
        v0.b bVar = this.H;
        if (bVar == null) {
            this.f10992g.add(new g(fVar, t10, jVar));
            return;
        }
        boolean zIsEmpty = true;
        if (fVar == s0.f.f14910c) {
            bVar.f(t10, jVar);
        } else if (fVar.d() != null) {
            fVar.d().f(t10, jVar);
        } else {
            List<s0.f> listZ = Z(fVar);
            for (int i10 = 0; i10 < listZ.size(); i10++) {
                listZ.get(i10).d().f(t10, jVar);
            }
            zIsEmpty = true ^ listZ.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t10 == n0.o.C) {
                u0(E());
            }
        }
    }

    public void f0(int i10) {
        if (this.f10987b == null) {
            this.f10992g.add(new e(i10));
        } else {
            this.f10988c.x(i10);
        }
    }

    public <T> void g(s0.f fVar, T t10, a1.l<T> lVar) {
        f(fVar, t10, new h(lVar));
    }

    public void g0(n0.d dVar) {
        this.f10996v = dVar;
        r0.b bVar = this.f10994n;
        if (bVar != null) {
            bVar.d(dVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.I;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            return -1;
        }
        return (int) (H() * gVar.b().height());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            return -1;
        }
        return (int) (H() * gVar.b().width());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final float h(Rect rect) {
        return rect.width() / rect.height();
    }

    public void h0(@Nullable String str) {
        this.f10995p = str;
    }

    public final boolean i() {
        n0.g gVar = this.f10987b;
        return gVar == null || getBounds().isEmpty() || h(getBounds()) == h(gVar.b());
    }

    public void i0(int i10) {
        if (this.f10987b == null) {
            this.f10992g.add(new n(i10));
        } else {
            this.f10988c.y(i10 + 0.99f);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.N) {
            return;
        }
        this.N = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return N();
    }

    public final void j() {
        v0.b bVar = new v0.b(this, x0.s.a(this.f10987b), this.f10987b.j(), this.f10987b);
        this.H = bVar;
        if (this.K) {
            bVar.F(true);
        }
    }

    public void j0(String str) {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            this.f10992g.add(new q(str));
            return;
        }
        s0.i iVarK = gVar.k(str);
        if (iVarK == null) {
            throw new IllegalArgumentException(n.a.a("Cannot find marker with name ", str, "."));
        }
        i0((int) (iVarK.f14917b + iVarK.f14918c));
    }

    public void k() {
        this.f10992g.clear();
        this.f10988c.cancel();
    }

    public void k0(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            this.f10992g.add(new o(f10));
        } else {
            i0((int) z0.g.k(gVar.p(), this.f10987b.f(), f10));
        }
    }

    public void l() {
        if (this.f10988c.isRunning()) {
            this.f10988c.cancel();
        }
        this.f10987b = null;
        this.H = null;
        this.f10994n = null;
        this.f10988c.g();
        invalidateSelf();
    }

    public void l0(int i10, int i11) {
        if (this.f10987b == null) {
            this.f10992g.add(new c(i10, i11));
        } else {
            this.f10988c.z(i10, i11 + 0.99f);
        }
    }

    public void m() {
        this.M = false;
    }

    public void m0(String str) {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            this.f10992g.add(new a(str));
            return;
        }
        s0.i iVarK = gVar.k(str);
        if (iVarK == null) {
            throw new IllegalArgumentException(n.a.a("Cannot find marker with name ", str, "."));
        }
        int i10 = (int) iVarK.f14917b;
        l0(i10, ((int) iVarK.f14918c) + i10);
    }

    public final void n(@NonNull Canvas canvas) {
        if (i()) {
            p(canvas);
        } else {
            o(canvas);
        }
    }

    public void n0(String str, String str2, boolean z10) {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            this.f10992g.add(new b(str, str2, z10));
            return;
        }
        s0.i iVarK = gVar.k(str);
        if (iVarK == null) {
            throw new IllegalArgumentException(n.a.a("Cannot find marker with name ", str, "."));
        }
        int i10 = (int) iVarK.f14917b;
        s0.i iVarK2 = this.f10987b.k(str2);
        if (iVarK2 == null) {
            throw new IllegalArgumentException(n.a.a("Cannot find marker with name ", str2, "."));
        }
        l0(i10, (int) (iVarK2.f14917b + (z10 ? 1.0f : 0.0f)));
    }

    public final void o(Canvas canvas) {
        float f10;
        if (this.H == null) {
            return;
        }
        Rect bounds = getBounds();
        float fWidth = bounds.width() / this.f10987b.b().width();
        float fHeight = bounds.height() / this.f10987b.b().height();
        int iSave = -1;
        if (this.M) {
            float fMin = Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                f10 = 1.0f / fMin;
                fWidth /= f10;
                fHeight /= f10;
            } else {
                f10 = 1.0f;
            }
            if (f10 > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f11 = fWidth2 * fMin;
                float f12 = fMin * fHeight2;
                canvas.translate(fWidth2 - f11, fHeight2 - f12);
                canvas.scale(f10, f10, f11, f12);
            }
        }
        this.f10986a.reset();
        this.f10986a.preScale(fWidth, fHeight);
        this.H.g(canvas, this.f10986a, this.I);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public void o0(@FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            this.f10992g.add(new d(f10, f11));
        } else {
            l0((int) z0.g.k(gVar.p(), this.f10987b.f(), f10), (int) z0.g.k(this.f10987b.p(), this.f10987b.f(), f11));
        }
    }

    public final void p(Canvas canvas) {
        float f10;
        int iSave;
        if (this.H == null) {
            return;
        }
        float f11 = this.f10989d;
        float fB = B(canvas);
        if (f11 > fB) {
            f10 = this.f10989d / fB;
        } else {
            fB = f11;
            f10 = 1.0f;
        }
        if (f10 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.f10987b.b().width() / 2.0f;
            float fHeight = this.f10987b.b().height() / 2.0f;
            float f12 = fWidth * fB;
            float f13 = fHeight * fB;
            canvas.translate((H() * fWidth) - f12, (H() * fHeight) - f13);
            canvas.scale(f10, f10, f12, f13);
        } else {
            iSave = -1;
        }
        this.f10986a.reset();
        this.f10986a.preScale(fB, fB);
        this.H.g(canvas, this.f10986a, this.I);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public void p0(int i10) {
        if (this.f10987b == null) {
            this.f10992g.add(new l(i10));
        } else {
            this.f10988c.A(i10);
        }
    }

    public void q(boolean z10) {
        if (this.f11000z == z10) {
            return;
        }
        this.f11000z = z10;
        if (this.f10987b != null) {
            j();
        }
    }

    public void q0(String str) {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            this.f10992g.add(new p(str));
            return;
        }
        s0.i iVarK = gVar.k(str);
        if (iVarK == null) {
            throw new IllegalArgumentException(n.a.a("Cannot find marker with name ", str, "."));
        }
        p0((int) iVarK.f14917b);
    }

    public boolean r() {
        return this.f11000z;
    }

    public void r0(float f10) {
        n0.g gVar = this.f10987b;
        if (gVar == null) {
            this.f10992g.add(new m(f10));
        } else {
            p0((int) z0.g.k(gVar.p(), this.f10987b.f(), f10));
        }
    }

    @MainThread
    public void s() {
        this.f10992g.clear();
        this.f10988c.h();
    }

    public void s0(boolean z10) {
        if (this.K == z10) {
            return;
        }
        this.K = z10;
        v0.b bVar = this.H;
        if (bVar != null) {
            bVar.F(z10);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i10) {
        this.I = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        z0.d.e("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        T();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        s();
    }

    public n0.g t() {
        return this.f10987b;
    }

    public void t0(boolean z10) {
        this.J = z10;
        n0.g gVar = this.f10987b;
        if (gVar != null) {
            gVar.x(z10);
        }
    }

    @Nullable
    public final Context u() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void u0(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.f10987b == null) {
            this.f10992g.add(new f(f10));
            return;
        }
        n0.e.a("Drawable#setProgress");
        this.f10988c.x(z0.g.k(this.f10987b.p(), this.f10987b.f(), f10));
        n0.e.b("Drawable#setProgress");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final r0.a v() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f10997w == null) {
            this.f10997w = new r0.a(getCallback(), this.f10998x);
        }
        return this.f10997w;
    }

    public void v0(int i10) {
        this.f10988c.setRepeatCount(i10);
    }

    public int w() {
        return (int) this.f10988c.j();
    }

    public void w0(int i10) {
        this.f10988c.setRepeatMode(i10);
    }

    @Nullable
    public Bitmap x(String str) {
        r0.b bVarY = y();
        if (bVarY != null) {
            return bVarY.a(str);
        }
        return null;
    }

    public void x0(boolean z10) {
        this.f10991f = z10;
    }

    public final r0.b y() {
        if (getCallback() == null) {
            return null;
        }
        r0.b bVar = this.f10994n;
        if (bVar != null && !bVar.b(u())) {
            this.f10994n = null;
        }
        if (this.f10994n == null) {
            this.f10994n = new r0.b(getCallback(), this.f10995p, this.f10996v, this.f10987b.i());
        }
        return this.f10994n;
    }

    public void y0(float f10) {
        this.f10989d = f10;
    }

    @Nullable
    public String z() {
        return this.f10995p;
    }

    public void z0(float f10) {
        this.f10988c.B(f10);
    }
}
