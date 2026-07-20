package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import n0.j;
import n0.l;
import n0.n;
import n0.o;
import n0.p;
import n0.q;
import n0.s;
import n0.t;
import n0.u;
import n0.v;
import z0.h;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final String L = "LottieAnimationView";
    public static final l<Throwable> M = new a();
    public final Set<n> H;
    public int I;

    @Nullable
    public q<n0.g> J;

    @Nullable
    public n0.g K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<n0.g> f1742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<Throwable> f1743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public l<Throwable> f1744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @DrawableRes
    public int f1745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f1746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1748g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @RawRes
    public int f1749i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1750n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1751p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1752v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1753w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1754x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1755y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public t f1756z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f1761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1762f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1763g;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f1757a);
            parcel.writeFloat(this.f1759c);
            parcel.writeInt(this.f1760d ? 1 : 0);
            parcel.writeString(this.f1761e);
            parcel.writeInt(this.f1762f);
            parcel.writeInt(this.f1763g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1757a = parcel.readString();
            this.f1759c = parcel.readFloat();
            this.f1760d = parcel.readInt() == 1;
            this.f1761e = parcel.readString();
            this.f1762f = parcel.readInt();
            this.f1763g = parcel.readInt();
        }
    }

    public class a implements l<Throwable> {
        @Override // n0.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2) {
            if (!h.k(th2)) {
                throw new IllegalStateException("Unable to parse composition", th2);
            }
            z0.d.f("Unable to load composition.", th2);
        }
    }

    public class b implements l<n0.g> {
        public b() {
        }

        @Override // n0.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(n0.g gVar) {
            LottieAnimationView.this.setComposition(gVar);
        }
    }

    public class c implements l<Throwable> {
        public c() {
        }

        @Override // n0.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2) {
            if (LottieAnimationView.this.f1745d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f1745d);
            }
            l<Throwable> lVar = LottieAnimationView.this.f1744c;
            if (lVar == null) {
                lVar = LottieAnimationView.M;
            }
            lVar.onResult(th2);
        }
    }

    public class d implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1766a;

        public d(int i10) {
            this.f1766a = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return LottieAnimationView.this.f1755y ? n0.h.u(LottieAnimationView.this.getContext(), this.f1766a) : n0.h.v(LottieAnimationView.this.getContext(), this.f1766a, null);
        }
    }

    public class e implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1768a;

        public e(String str) {
            this.f1768a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return LottieAnimationView.this.f1755y ? n0.h.g(LottieAnimationView.this.getContext(), this.f1768a) : n0.h.h(LottieAnimationView.this.getContext(), this.f1768a, null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> extends a1.j<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a1.l f1770d;

        public f(a1.l lVar) {
            this.f1770d = lVar;
        }

        @Override // a1.j
        public T a(a1.b<T> bVar) {
            return (T) this.f1770d.a(bVar);
        }
    }

    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1772a;

        static {
            int[] iArr = new int[t.values().length];
            f1772a = iArr;
            try {
                iArr[t.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1772a[t.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1772a[t.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f1742a = new b();
        this.f1743b = new c();
        this.f1745d = 0;
        this.f1746e = new j();
        this.f1750n = false;
        this.f1751p = false;
        this.f1752v = false;
        this.f1753w = false;
        this.f1754x = false;
        this.f1755y = true;
        this.f1756z = t.AUTOMATIC;
        this.H = new HashSet();
        this.I = 0;
        u(null, R.attr.lottieAnimationViewStyle);
    }

    private void setCompositionTask(q<n0.g> qVar) {
        m();
        l();
        this.J = qVar.f(this.f1742a).e(this.f1743b);
    }

    public void A() {
        this.f1746e.U();
    }

    public void B() {
        this.H.clear();
    }

    public void C() {
        this.f1746e.V();
    }

    public void D(Animator.AnimatorListener animatorListener) {
        this.f1746e.W(animatorListener);
    }

    @RequiresApi(api = 19)
    public void E(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1746e.X(animatorPauseListener);
    }

    public boolean F(@NonNull n nVar) {
        return this.H.remove(nVar);
    }

    public void G(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1746e.Y(animatorUpdateListener);
    }

    public List<s0.f> H(s0.f fVar) {
        return this.f1746e.Z(fVar);
    }

    @MainThread
    public void I() {
        if (isShown()) {
            this.f1746e.a0();
            p();
        } else {
            this.f1750n = false;
            this.f1751p = true;
        }
    }

    public void J() {
        this.f1746e.b0();
    }

    public void K(InputStream inputStream, @Nullable String str) {
        setCompositionTask(n0.h.j(inputStream, str));
    }

    public void L(String str, @Nullable String str2) {
        K(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void M(String str, @Nullable String str2) {
        setCompositionTask(n0.h.x(getContext(), str, str2));
    }

    public final void N() {
        boolean zV = v();
        setImageDrawable(null);
        setImageDrawable(this.f1746e);
        if (zV) {
            this.f1746e.a0();
        }
    }

    public void O(int i10, int i11) {
        this.f1746e.l0(i10, i11);
    }

    public void P(String str, String str2, boolean z10) {
        this.f1746e.n0(str, str2, z10);
    }

    public void Q(@FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.f1746e.o0(f10, f11);
    }

    @Nullable
    public Bitmap R(String str, @Nullable Bitmap bitmap) {
        return this.f1746e.C0(str, bitmap);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z10) {
        n0.e.a("buildDrawingCache");
        this.I++;
        super.buildDrawingCache(z10);
        if (this.I == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z10) == null) {
            setRenderMode(t.HARDWARE);
        }
        this.I--;
        n0.e.b("buildDrawingCache");
    }

    public void e(Animator.AnimatorListener animatorListener) {
        this.f1746e.c(animatorListener);
    }

    @RequiresApi(api = 19)
    public void f(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1746e.d(animatorPauseListener);
    }

    public void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1746e.e(animatorUpdateListener);
    }

    @Nullable
    public n0.g getComposition() {
        return this.K;
    }

    public long getDuration() {
        n0.g gVar = this.K;
        if (gVar != null) {
            return (long) gVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f1746e.w();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f1746e.z();
    }

    public float getMaxFrame() {
        return this.f1746e.A();
    }

    public float getMinFrame() {
        return this.f1746e.C();
    }

    @Nullable
    public s getPerformanceTracker() {
        return this.f1746e.D();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f1746e.E();
    }

    public int getRepeatCount() {
        return this.f1746e.F();
    }

    public int getRepeatMode() {
        return this.f1746e.G();
    }

    public float getScale() {
        return this.f1746e.H();
    }

    public float getSpeed() {
        return this.f1746e.I();
    }

    public boolean h(@NonNull n nVar) {
        n0.g gVar = this.K;
        if (gVar != null) {
            nVar.a(gVar);
        }
        return this.H.add(nVar);
    }

    public <T> void i(s0.f fVar, T t10, a1.j<T> jVar) {
        this.f1746e.f(fVar, t10, jVar);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        j jVar = this.f1746e;
        if (drawable2 == jVar) {
            super.invalidateDrawable(jVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public <T> void j(s0.f fVar, T t10, a1.l<T> lVar) {
        this.f1746e.f(fVar, t10, new f(lVar));
    }

    @MainThread
    public void k() {
        this.f1752v = false;
        this.f1751p = false;
        this.f1750n = false;
        this.f1746e.k();
        p();
    }

    public final void l() {
        q<n0.g> qVar = this.J;
        if (qVar != null) {
            qVar.k(this.f1742a);
            this.J.j(this.f1743b);
        }
    }

    public final void m() {
        this.K = null;
        this.f1746e.l();
    }

    public void n() {
        this.f1746e.m();
    }

    public void o(boolean z10) {
        this.f1746e.q(z10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        if (this.f1754x || this.f1752v) {
            z();
            this.f1754x = false;
            this.f1752v = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (v()) {
            k();
            this.f1752v = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f1757a;
        this.f1748g = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f1748g);
        }
        int i10 = savedState.f1758b;
        this.f1749i = i10;
        if (i10 != 0) {
            setAnimation(i10);
        }
        setProgress(savedState.f1759c);
        if (savedState.f1760d) {
            z();
        }
        this.f1746e.h0(savedState.f1761e);
        setRepeatMode(savedState.f1762f);
        setRepeatCount(savedState.f1763g);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1757a = this.f1748g;
        savedState.f1758b = this.f1749i;
        savedState.f1759c = this.f1746e.E();
        savedState.f1760d = this.f1746e.N() || (!ViewCompat.isAttachedToWindow(this) && this.f1752v);
        savedState.f1761e = this.f1746e.z();
        savedState.f1762f = this.f1746e.G();
        savedState.f1763g = this.f1746e.F();
        return savedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        if (this.f1747f) {
            if (!isShown()) {
                if (v()) {
                    y();
                    this.f1751p = true;
                    return;
                }
                return;
            }
            if (this.f1751p) {
                I();
            } else if (this.f1750n) {
                z();
            }
            this.f1751p = false;
            this.f1750n = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final void p() {
        int i10 = g.f1772a[this.f1756z.ordinal()];
        int i11 = 2;
        if (i10 != 1) {
            if (i10 == 2 || i10 != 3) {
                i11 = 1;
            } else {
                n0.g gVar = this.K;
                if (gVar != null) {
                    gVar.r();
                }
                n0.g gVar2 = this.K;
                if (gVar2 != null && gVar2.m() > 4) {
                    i11 = 1;
                }
            }
        }
        if (i11 != getLayerType()) {
            setLayerType(i11, null);
        }
    }

    public final q<n0.g> q(String str) {
        if (isInEditMode()) {
            return new q<>(new e(str), true);
        }
        return this.f1755y ? n0.h.e(getContext(), str) : n0.h.f(getContext(), str, null);
    }

    public final q<n0.g> r(@RawRes int i10) {
        if (isInEditMode()) {
            return new q<>(new d(i10), true);
        }
        return this.f1755y ? n0.h.s(getContext(), i10) : n0.h.t(getContext(), i10, null);
    }

    public boolean s() {
        return this.f1746e.L();
    }

    public void setAnimation(@RawRes int i10) {
        this.f1749i = i10;
        this.f1748g = null;
        setCompositionTask(r(i10));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        L(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f1755y ? n0.h.w(getContext(), str) : n0.h.x(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f1746e.c0(z10);
    }

    public void setCacheComposition(boolean z10) {
        this.f1755y = z10;
    }

    public void setComposition(@NonNull n0.g gVar) {
        if (n0.e.f10921a) {
            Log.v(L, "Set Composition \n" + gVar);
        }
        this.f1746e.setCallback(this);
        this.K = gVar;
        this.f1753w = true;
        boolean zD0 = this.f1746e.d0(gVar);
        this.f1753w = false;
        p();
        if (getDrawable() != this.f1746e || zD0) {
            if (!zD0) {
                N();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<n> it = this.H.iterator();
            while (it.hasNext()) {
                it.next().a(gVar);
            }
        }
    }

    public void setFailureListener(@Nullable l<Throwable> lVar) {
        this.f1744c = lVar;
    }

    public void setFallbackResource(@DrawableRes int i10) {
        this.f1745d = i10;
    }

    public void setFontAssetDelegate(n0.c cVar) {
        this.f1746e.e0(cVar);
    }

    public void setFrame(int i10) {
        this.f1746e.f0(i10);
    }

    public void setImageAssetDelegate(n0.d dVar) {
        this.f1746e.g0(dVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f1746e.h0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        l();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        l();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        l();
        super.setImageResource(i10);
    }

    public void setMaxFrame(int i10) {
        this.f1746e.i0(i10);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f1746e.k0(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.f1746e.m0(str);
    }

    public void setMinFrame(int i10) {
        this.f1746e.p0(i10);
    }

    public void setMinProgress(float f10) {
        this.f1746e.r0(f10);
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        this.f1746e.s0(z10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f1746e.t0(z10);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f1746e.u0(f10);
    }

    public void setRenderMode(t tVar) {
        this.f1756z = tVar;
        p();
    }

    public void setRepeatCount(int i10) {
        this.f1746e.v0(i10);
    }

    public void setRepeatMode(int i10) {
        this.f1746e.w0(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f1746e.x0(z10);
    }

    public void setScale(float f10) {
        this.f1746e.y0(f10);
        if (getDrawable() == this.f1746e) {
            N();
        }
    }

    public void setSpeed(float f10) {
        this.f1746e.z0(f10);
    }

    public void setTextDelegate(v vVar) {
        this.f1746e.B0(vVar);
    }

    public boolean t() {
        return this.f1746e.M();
    }

    public final void u(@Nullable AttributeSet attributeSet, @AttrRes int i10) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i10, 0);
        this.f1755y = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f1752v = true;
            this.f1754x = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f1746e.v0(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        o(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            i(new s0.f("**"), o.E, new a1.j(new u(AppCompatResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.f1746e.y0(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i11 = R.styleable.LottieAnimationView_lottie_renderMode;
            t tVar = t.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i11, tVar.ordinal());
            if (iOrdinal >= t.values().length) {
                iOrdinal = tVar.ordinal();
            }
            setRenderMode(t.values()[iOrdinal]);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f1746e.A0(Boolean.valueOf(h.f(getContext()) != 0.0f));
        p();
        this.f1747f = true;
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        j jVar;
        if (!this.f1753w && drawable == (jVar = this.f1746e) && jVar.N()) {
            y();
        } else if (!this.f1753w && (drawable instanceof j)) {
            j jVar2 = (j) drawable;
            if (jVar2.N()) {
                jVar2.S();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public boolean v() {
        return this.f1746e.N();
    }

    public boolean w() {
        return this.f1746e.Q();
    }

    @Deprecated
    public void x(boolean z10) {
        this.f1746e.v0(z10 ? -1 : 0);
    }

    @MainThread
    public void y() {
        this.f1754x = false;
        this.f1752v = false;
        this.f1751p = false;
        this.f1750n = false;
        this.f1746e.S();
        p();
    }

    @MainThread
    public void z() {
        if (!isShown()) {
            this.f1750n = true;
        } else {
            this.f1746e.T();
            p();
        }
    }

    public void setMaxFrame(String str) {
        this.f1746e.j0(str);
    }

    public void setMinFrame(String str) {
        this.f1746e.q0(str);
    }

    public void setAnimation(String str) {
        this.f1748g = str;
        this.f1749i = 0;
        setCompositionTask(q(str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1742a = new b();
        this.f1743b = new c();
        this.f1745d = 0;
        this.f1746e = new j();
        this.f1750n = false;
        this.f1751p = false;
        this.f1752v = false;
        this.f1753w = false;
        this.f1754x = false;
        this.f1755y = true;
        this.f1756z = t.AUTOMATIC;
        this.H = new HashSet();
        this.I = 0;
        u(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1742a = new b();
        this.f1743b = new c();
        this.f1745d = 0;
        this.f1746e = new j();
        this.f1750n = false;
        this.f1751p = false;
        this.f1752v = false;
        this.f1753w = false;
        this.f1754x = false;
        this.f1755y = true;
        this.f1756z = t.AUTOMATIC;
        this.H = new HashSet();
        this.I = 0;
        u(attributeSet, i10);
    }
}
