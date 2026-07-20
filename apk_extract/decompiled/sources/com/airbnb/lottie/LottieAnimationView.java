package com.airbnb.lottie;

import af.r5;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.color.utilities.Contrast;
import j1.a0;
import j1.b0;
import j1.c0;
import j1.d;
import j1.e0;
import j1.f;
import j1.f0;
import j1.h;
import j1.h0;
import j1.i;
import j1.i0;
import j1.j;
import j1.j0;
import j1.k;
import j1.o;
import j1.s;
import j1.v;
import j1.w;
import j1.x;
import j1.y;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import s1.e;
import w1.b;
import x1.c;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final f p = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f1741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a0 f1742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1743d;
    public final x e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashSet f1749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashSet f1750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e0 f1751o;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1755d;
        public String e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1756h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1757i;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeString(this.f1752a);
            parcel.writeFloat(this.f1754c);
            parcel.writeInt(this.f1755d ? 1 : 0);
            parcel.writeString(this.e);
            parcel.writeInt(this.f1756h);
            parcel.writeInt(this.f1757i);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f1740a = new i(this, 1);
        this.f1741b = new i(this, 0);
        this.f1743d = 0;
        this.e = new x();
        this.f1746j = false;
        this.f1747k = false;
        this.f1748l = true;
        this.f1749m = new HashSet();
        this.f1750n = new HashSet();
        c(null, R$attr.lottieAnimationViewStyle);
    }

    private void setCompositionTask(e0 e0Var) {
        c0 c0Var = e0Var.f5955d;
        x xVar = this.e;
        if (c0Var != null && xVar == getDrawable() && xVar.f6011a == c0Var.f5943a) {
            return;
        }
        this.f1749m.add(h.SET_ANIMATION);
        this.e.d();
        b();
        e0Var.b(this.f1740a);
        e0Var.a(this.f1741b);
        this.f1751o = e0Var;
    }

    public final void a() {
        this.f1747k = false;
        this.f1749m.add(h.PLAY_OPTION);
        x xVar = this.e;
        xVar.f6016i.clear();
        xVar.f6012b.cancel();
        if (xVar.isVisible()) {
            return;
        }
        xVar.f6015h = w.NONE;
    }

    public final void b() {
        e0 e0Var = this.f1751o;
        if (e0Var != null) {
            i iVar = this.f1740a;
            synchronized (e0Var) {
                e0Var.f5952a.remove(iVar);
            }
            e0 e0Var2 = this.f1751o;
            i iVar2 = this.f1741b;
            synchronized (e0Var2) {
                e0Var2.f5953b.remove(iVar2);
            }
        }
    }

    public final void c(AttributeSet attributeSet, int i8) {
        String string;
        boolean zRemove;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i8, 0);
        this.f1748l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f1747k = true;
        }
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false);
        x xVar = this.e;
        if (z2) {
            xVar.f6012b.setRepeatCount(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_clipToCompositionBounds)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_clipToCompositionBounds, true));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            setClipTextToBoundingBox(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_clipTextToBoundingBox, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_defaultFontFileExtension)) {
            setDefaultFontFileExtension(typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_defaultFontFileExtension));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
        boolean zHasValue4 = typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_progress);
        float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f);
        if (zHasValue4) {
            this.f1749m.add(h.SET_PROGRESS);
        }
        xVar.u(f);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        y yVar = y.MergePathsApi19;
        HashSet hashSet = (HashSet) xVar.f6022o.f10264a;
        if (!z3) {
            zRemove = hashSet.remove(yVar);
        } else if (Build.VERSION.SDK_INT < yVar.minRequiredSdkVersion) {
            b.b(String.format("%s is not supported pre SDK %d", yVar.name(), Integer.valueOf(yVar.minRequiredSdkVersion)));
            zRemove = false;
        } else {
            zRemove = hashSet.add(yVar);
        }
        if (xVar.f6011a != null && zRemove) {
            xVar.c();
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_colorFilter)) {
            xVar.a(new p1.f("**"), b0.F, new c(new i0(AppCompatResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor(), PorterDuff.Mode.SRC_ATOP)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_renderMode)) {
            int i9 = R$styleable.LottieAnimationView_lottie_renderMode;
            h0 h0Var = h0.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i9, h0Var.ordinal());
            if (iOrdinal >= h0.values().length) {
                iOrdinal = h0Var.ordinal();
            }
            setRenderMode(h0.values()[iOrdinal]);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_asyncUpdates)) {
            int i10 = R$styleable.LottieAnimationView_lottie_asyncUpdates;
            j1.a aVar = j1.a.AUTOMATIC;
            int iOrdinal2 = typedArrayObtainStyledAttributes.getInt(i10, aVar.ordinal());
            if (iOrdinal2 >= h0.values().length) {
                iOrdinal2 = aVar.ordinal();
            }
            setAsyncUpdates(j1.a.values()[iOrdinal2]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_useCompositionFrameRate)) {
            setUseCompositionFrameRate(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_useCompositionFrameRate, false));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void d() {
        this.f1749m.add(h.PLAY_OPTION);
        this.e.l();
    }

    public j1.a getAsyncUpdates() {
        j1.a aVar = this.e.M;
        return aVar != null ? aVar : d.f5945a;
    }

    public boolean getAsyncUpdatesEnabled() {
        j1.a aVar = this.e.M;
        if (aVar == null) {
            aVar = d.f5945a;
        }
        return aVar == j1.a.ENABLED;
    }

    public boolean getClipTextToBoundingBox() {
        return this.e.f6027w;
    }

    public boolean getClipToCompositionBounds() {
        return this.e.q;
    }

    @Nullable
    public j getComposition() {
        Drawable drawable = getDrawable();
        x xVar = this.e;
        if (drawable == xVar) {
            return xVar.f6011a;
        }
        return null;
    }

    public long getDuration() {
        j composition = getComposition();
        if (composition != null) {
            return (long) composition.b();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.e.f6012b.f10639j;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.e.f6018k;
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.e.p;
    }

    public float getMaxFrame() {
        return this.e.f6012b.b();
    }

    public float getMinFrame() {
        return this.e.f6012b.c();
    }

    @Nullable
    public f0 getPerformanceTracker() {
        j jVar = this.e.f6011a;
        if (jVar != null) {
            return jVar.f5964a;
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getProgress() {
        return this.e.f6012b.a();
    }

    public h0 getRenderMode() {
        return this.e.f6029y ? h0.SOFTWARE : h0.HARDWARE;
    }

    public int getRepeatCount() {
        return this.e.f6012b.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.e.f6012b.getRepeatMode();
    }

    public float getSpeed() {
        return this.e.f6012b.f10636d;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if (drawable instanceof x) {
            if ((((x) drawable).f6029y ? h0.SOFTWARE : h0.HARDWARE) == h0.SOFTWARE) {
                this.e.invalidateSelf();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        x xVar = this.e;
        if (drawable2 == xVar) {
            super.invalidateDrawable(xVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f1747k) {
            return;
        }
        this.e.l();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i8;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1744h = savedState.f1752a;
        h hVar = h.SET_ANIMATION;
        HashSet hashSet = this.f1749m;
        if (!hashSet.contains(hVar) && !TextUtils.isEmpty(this.f1744h)) {
            setAnimation(this.f1744h);
        }
        this.f1745i = savedState.f1753b;
        if (!hashSet.contains(hVar) && (i8 = this.f1745i) != 0) {
            setAnimation(i8);
        }
        if (!hashSet.contains(h.SET_PROGRESS)) {
            this.e.u(savedState.f1754c);
        }
        if (!hashSet.contains(h.PLAY_OPTION) && savedState.f1755d) {
            d();
        }
        if (!hashSet.contains(h.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.e);
        }
        if (!hashSet.contains(h.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f1756h);
        }
        if (hashSet.contains(h.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.f1757i);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1752a = this.f1744h;
        savedState.f1753b = this.f1745i;
        x xVar = this.e;
        savedState.f1754c = xVar.f6012b.a();
        boolean zIsVisible = xVar.isVisible();
        w1.d dVar = xVar.f6012b;
        if (zIsVisible) {
            z2 = dVar.f10644o;
        } else {
            w wVar = xVar.f6015h;
            z2 = wVar == w.PLAY || wVar == w.RESUME;
        }
        savedState.f1755d = z2;
        savedState.e = xVar.f6018k;
        savedState.f1756h = dVar.getRepeatMode();
        savedState.f1757i = dVar.getRepeatCount();
        return savedState;
    }

    public void setAnimation(@RawRes final int i8) {
        e0 e0VarA;
        e0 e0Var;
        this.f1745i = i8;
        final String str = null;
        this.f1744h = null;
        if (isInEditMode()) {
            e0Var = new e0(new Callable() { // from class: j1.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieAnimationView lottieAnimationView = this.f5959a;
                    boolean z2 = lottieAnimationView.f1748l;
                    int i9 = i8;
                    if (!z2) {
                        return o.e(lottieAnimationView.getContext(), i9, null);
                    }
                    Context context = lottieAnimationView.getContext();
                    return o.e(context, i9, o.j(context, i9));
                }
            }, true);
        } else {
            if (this.f1748l) {
                Context context = getContext();
                final String strJ = o.j(context, i8);
                final WeakReference weakReference = new WeakReference(context);
                final Context applicationContext = context.getApplicationContext();
                e0VarA = o.a(strJ, new Callable() { // from class: j1.n
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Context context2 = (Context) weakReference.get();
                        if (context2 == null) {
                            context2 = applicationContext;
                        }
                        return o.e(context2, i8, strJ);
                    }
                }, null);
            } else {
                Context context2 = getContext();
                HashMap map = o.f5989a;
                final WeakReference weakReference2 = new WeakReference(context2);
                final Context applicationContext2 = context2.getApplicationContext();
                e0VarA = o.a(null, new Callable() { // from class: j1.n
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Context context3 = (Context) weakReference2.get();
                        if (context3 == null) {
                            context3 = applicationContext2;
                        }
                        return o.e(context3, i8, str);
                    }
                }, null);
            }
            e0Var = e0VarA;
        }
        setCompositionTask(e0Var);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        setCompositionTask(o.a(null, new Callable() { // from class: j1.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o.c(byteArrayInputStream, null);
            }
        }, new a4.c(byteArrayInputStream, 24)));
    }

    public void setAnimationFromUrl(String str) {
        e0 e0VarA;
        int i8 = 0;
        String str2 = null;
        if (this.f1748l) {
            Context context = getContext();
            HashMap map = o.f5989a;
            String strI = h0.a.i("url_", str);
            e0VarA = o.a(strI, new k(context, i8, str, strI), null);
        } else {
            e0VarA = o.a(null, new k(getContext(), i8, str, str2), null);
        }
        setCompositionTask(e0VarA);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.e.f6026v = z2;
    }

    public void setAsyncUpdates(j1.a aVar) {
        this.e.M = aVar;
    }

    public void setCacheComposition(boolean z2) {
        this.f1748l = z2;
    }

    public void setClipTextToBoundingBox(boolean z2) {
        x xVar = this.e;
        if (z2 != xVar.f6027w) {
            xVar.f6027w = z2;
            xVar.invalidateSelf();
        }
    }

    public void setClipToCompositionBounds(boolean z2) {
        x xVar = this.e;
        if (z2 != xVar.q) {
            xVar.q = z2;
            e eVar = xVar.f6023r;
            if (eVar != null) {
                eVar.J = z2;
            }
            xVar.invalidateSelf();
        }
    }

    public void setComposition(@NonNull j jVar) {
        j1.a aVar = d.f5945a;
        x xVar = this.e;
        xVar.setCallback(this);
        boolean z2 = true;
        this.f1746j = true;
        if (xVar.f6011a == jVar) {
            z2 = false;
        } else {
            xVar.L = true;
            xVar.d();
            xVar.f6011a = jVar;
            xVar.c();
            w1.d dVar = xVar.f6012b;
            boolean z3 = dVar.f10643n == null;
            dVar.f10643n = jVar;
            if (z3) {
                dVar.j(Math.max(dVar.f10641l, jVar.f5973l), Math.min(dVar.f10642m, jVar.f5974m));
            } else {
                dVar.j((int) jVar.f5973l, (int) jVar.f5974m);
            }
            float f = dVar.f10639j;
            dVar.f10639j = 0.0f;
            dVar.f10638i = 0.0f;
            dVar.i((int) f);
            dVar.f();
            xVar.u(dVar.getAnimatedFraction());
            ArrayList arrayList = xVar.f6016i;
            Iterator it = new ArrayList(arrayList).iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                if (vVar != null) {
                    vVar.run();
                }
                it.remove();
            }
            arrayList.clear();
            jVar.f5964a.f5956a = xVar.f6025t;
            xVar.e();
            Drawable.Callback callback = xVar.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(xVar);
            }
        }
        if (this.f1747k) {
            xVar.l();
        }
        this.f1746j = false;
        if (getDrawable() != xVar || z2) {
            if (!z2) {
                boolean zJ = xVar.j();
                setImageDrawable(null);
                setImageDrawable(xVar);
                if (zJ) {
                    xVar.n();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it2 = this.f1750n.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        x xVar = this.e;
        xVar.f6021n = str;
        r5 r5VarI = xVar.i();
        if (r5VarI != null) {
            r5VarI.f560h = str;
        }
    }

    public void setFailureListener(@Nullable a0 a0Var) {
        this.f1742c = a0Var;
    }

    public void setFallbackResource(@DrawableRes int i8) {
        this.f1743d = i8;
    }

    public void setFontAssetDelegate(j1.b bVar) {
        r5 r5Var = this.e.f6019l;
    }

    public void setFontMap(@Nullable Map<String, Typeface> map) {
        x xVar = this.e;
        if (map == xVar.f6020m) {
            return;
        }
        xVar.f6020m = map;
        xVar.invalidateSelf();
    }

    public void setFrame(int i8) {
        this.e.o(i8);
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z2) {
        this.e.f6014d = z2;
    }

    public void setImageAssetDelegate(j1.c cVar) {
        o1.a aVar = this.e.f6017j;
    }

    public void setImageAssetsFolder(String str) {
        this.e.f6018k = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f1745i = 0;
        this.f1744h = null;
        b();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f1745i = 0;
        this.f1744h = null;
        b();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i8) {
        this.f1745i = 0;
        this.f1744h = null;
        b();
        super.setImageResource(i8);
    }

    public void setMaintainOriginalImageBounds(boolean z2) {
        this.e.p = z2;
    }

    public void setMaxFrame(int i8) {
        this.e.p(i8);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        x xVar = this.e;
        j jVar = xVar.f6011a;
        if (jVar == null) {
            xVar.f6016i.add(new s(xVar, f, 0));
            return;
        }
        float fE = w1.f.e(jVar.f5973l, jVar.f5974m, f);
        w1.d dVar = xVar.f6012b;
        dVar.j(dVar.f10641l, fE);
    }

    public void setMinAndMaxFrame(String str) {
        this.e.r(str);
    }

    public void setMinFrame(int i8) {
        this.e.s(i8);
    }

    public void setMinProgress(float f) {
        x xVar = this.e;
        j jVar = xVar.f6011a;
        if (jVar == null) {
            xVar.f6016i.add(new s(xVar, f, 1));
        } else {
            xVar.s((int) w1.f.e(jVar.f5973l, jVar.f5974m, f));
        }
    }

    public void setOutlineMasksAndMattes(boolean z2) {
        x xVar = this.e;
        if (xVar.u == z2) {
            return;
        }
        xVar.u = z2;
        e eVar = xVar.f6023r;
        if (eVar != null) {
            eVar.p(z2);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        x xVar = this.e;
        xVar.f6025t = z2;
        j jVar = xVar.f6011a;
        if (jVar != null) {
            jVar.f5964a.f5956a = z2;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        this.f1749m.add(h.SET_PROGRESS);
        this.e.u(f);
    }

    public void setRenderMode(h0 h0Var) {
        x xVar = this.e;
        xVar.f6028x = h0Var;
        xVar.e();
    }

    public void setRepeatCount(int i8) {
        this.f1749m.add(h.SET_REPEAT_COUNT);
        this.e.f6012b.setRepeatCount(i8);
    }

    public void setRepeatMode(int i8) {
        this.f1749m.add(h.SET_REPEAT_MODE);
        this.e.f6012b.setRepeatMode(i8);
    }

    public void setSafeMode(boolean z2) {
        this.e.e = z2;
    }

    public void setSpeed(float f) {
        this.e.f6012b.f10636d = f;
    }

    public void setTextDelegate(j0 j0Var) {
        this.e.getClass();
    }

    public void setUseCompositionFrameRate(boolean z2) {
        this.e.f6012b.p = z2;
    }

    @Override // android.view.View
    public final void unscheduleDrawable(Drawable drawable) {
        x xVar;
        if (!this.f1746j && drawable == (xVar = this.e) && xVar.j()) {
            this.f1747k = false;
            xVar.k();
        } else if (!this.f1746j && (drawable instanceof x)) {
            x xVar2 = (x) drawable;
            if (xVar2.j()) {
                xVar2.k();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void setMaxFrame(String str) {
        this.e.q(str);
    }

    public void setMinFrame(String str) {
        this.e.t(str);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1740a = new i(this, 1);
        this.f1741b = new i(this, 0);
        this.f1743d = 0;
        this.e = new x();
        this.f1746j = false;
        this.f1747k = false;
        this.f1748l = true;
        this.f1749m = new HashSet();
        this.f1750n = new HashSet();
        c(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public void setAnimation(final String str) {
        e0 e0VarA;
        e0 e0Var;
        int i8 = 1;
        this.f1744h = str;
        this.f1745i = 0;
        if (isInEditMode()) {
            e0Var = new e0(new Callable() { // from class: j1.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieAnimationView lottieAnimationView = this.f5950a;
                    boolean z2 = lottieAnimationView.f1748l;
                    String str2 = str;
                    if (!z2) {
                        return o.b(lottieAnimationView.getContext(), str2, null);
                    }
                    Context context = lottieAnimationView.getContext();
                    HashMap map = o.f5989a;
                    return o.b(context, str2, "asset_" + str2);
                }
            }, true);
        } else {
            String str2 = null;
            if (this.f1748l) {
                Context context = getContext();
                HashMap map = o.f5989a;
                String strI = h0.a.i("asset_", str);
                e0VarA = o.a(strI, new k(context.getApplicationContext(), i8, str, strI), null);
            } else {
                Context context2 = getContext();
                HashMap map2 = o.f5989a;
                e0VarA = o.a(null, new k(context2.getApplicationContext(), i8, str, str2), null);
            }
            e0Var = e0VarA;
        }
        setCompositionTask(e0Var);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f1740a = new i(this, 1);
        this.f1741b = new i(this, 0);
        this.f1743d = 0;
        this.e = new x();
        this.f1746j = false;
        this.f1747k = false;
        this.f1748l = true;
        this.f1749m = new HashSet();
        this.f1750n = new HashSet();
        c(attributeSet, i8);
    }
}
