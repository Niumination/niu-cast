package com.tencent.qgame.animplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.qgame.animplayer.AnimView;
import com.tencent.qgame.animplayer.textureview.InnerTextureView;
import f2.g;
import f2.o;
import f2.y;
import ik.y0;
import in.j;
import java.io.File;
import kn.l0;
import kn.n0;
import kn.w;
import l2.k;
import lm.d0;
import lm.f0;
import lm.l2;
import lm.t0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public class AnimView extends FrameLayout implements y, TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @l
    public static final a f1792y = new a();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @l
    public static final String f1793z = "AnimPlayer.AnimView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final g f1794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final d0 f1795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public SurfaceTexture f1796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public h2.a f1797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public InnerTextureView f1798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public g2.c f1799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final k f1800g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1801i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1802n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public final d0 f1803p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1804v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1805w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @m
    public t0<? extends g2.c, Boolean> f1806x;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public static final class b extends n0 implements jn.a<a> {

        public static final class a implements h2.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AnimView f1807a;

            public a(AnimView animView) {
                this.f1807a = animView;
            }

            @Override // h2.a
            public void a() {
                t0<g2.c, Boolean> mPlayBuff = this.f1807a.getMPlayBuff();
                l2 l2Var = null;
                if (mPlayBuff != null) {
                    AnimView animView = this.f1807a;
                    animView.B(mPlayBuff.getFirst(), mPlayBuff.getSecond().booleanValue());
                    animView.setMPlayBuff(null);
                    l2Var = l2.f10208a;
                }
                if (l2Var == null) {
                    AnimView animView2 = this.f1807a;
                    if (animView2.f1801i) {
                        animView2.v();
                    } else {
                        g2.c cVar = animView2.f1799f;
                        if (cVar != null) {
                            cVar.close();
                        }
                    }
                    h2.a aVar = animView2.f1797d;
                    if (aVar == null) {
                        return;
                    }
                    aVar.a();
                }
            }

            @Override // h2.a
            public void b() {
                this.f1807a.v();
                h2.a aVar = this.f1807a.f1797d;
                if (aVar == null) {
                    return;
                }
                aVar.b();
            }

            @Override // h2.a
            public void c(int i10, @m String str) {
                h2.a aVar = this.f1807a.f1797d;
                if (aVar == null) {
                    return;
                }
                aVar.c(i10, str);
            }

            @Override // h2.a
            public void d() {
                h2.a aVar = this.f1807a.f1797d;
                if (aVar == null) {
                    return;
                }
                aVar.d();
            }

            @Override // h2.a
            public void e(int i10, @m f2.a aVar) {
                h2.a aVar2 = this.f1807a.f1797d;
                if (aVar2 == null) {
                    return;
                }
                aVar2.e(i10, aVar);
            }

            @Override // h2.a
            public boolean f(@l f2.a aVar) {
                l0.p(aVar, "config");
                k kVar = this.f1807a.f1800g;
                int i10 = aVar.f5653c;
                int i11 = aVar.f5654d;
                kVar.f9665f = i10;
                kVar.f9666g = i11;
                h2.a aVar2 = this.f1807a.f1797d;
                Boolean boolValueOf = aVar2 == null ? null : Boolean.valueOf(aVar2.f(aVar));
                return boolValueOf == null ? h2.a.C0189a.a(this, aVar) : boolValueOf.booleanValue();
            }
        }

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final a invoke() {
            return new a(AnimView.this);
        }
    }

    public static final class c extends n0 implements jn.a<l2> {
        public c() {
            super(0);
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnimView.this.removeAllViews();
        }
    }

    public static final class d extends n0 implements jn.a<l2> {
        final /* synthetic */ g2.c $fileContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g2.c cVar) {
            super(0);
            this.$fileContainer = cVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (AnimView.this.getVisibility() != 0) {
                l2.a.f9640a.b(AnimView.f1793z, "AnimView is GONE, can't play");
                return;
            }
            if (AnimView.this.f1794a.z()) {
                l2.a.f9640a.b(AnimView.f1793z, "is running can not start");
                return;
            }
            AnimView animView = AnimView.this;
            g2.c cVar = this.$fileContainer;
            animView.f1799f = cVar;
            animView.f1794a.W(cVar);
        }
    }

    public static final class e extends n0 implements jn.a<l2> {
        final /* synthetic */ g2.c $fileContainer;
        final /* synthetic */ boolean $isLoop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(g2.c cVar, boolean z10) {
            super(0);
            this.$fileContainer = cVar;
            this.$isLoop = z10;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (AnimView.this.getVisibility() != 0) {
                l2.a.f9640a.b(AnimView.f1793z, "AnimView is GONE, can't play");
                return;
            }
            if (AnimView.this.f1794a.z()) {
                AnimView.this.f1794a.a0();
                AnimView.this.setMPlayBuff(new t0<>(this.$fileContainer, Boolean.valueOf(this.$isLoop)));
            } else {
                AnimView animView = AnimView.this;
                g2.c cVar = this.$fileContainer;
                animView.f1799f = cVar;
                animView.f1794a.Y(cVar, this.$isLoop);
            }
        }
    }

    public static final class f extends n0 implements jn.a<Handler> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public AnimView(@l Context context) {
        this(context, null, 0, 6, null);
        l0.p(context, "context");
    }

    public static final void E(jn.a aVar) {
        l0.p(aVar, "$f");
        aVar.invoke();
    }

    private final b.a getAnimProxyListener() {
        return (b.a) this.f1803p.getValue();
    }

    private final Handler getUiHandler() {
        return (Handler) this.f1795b.getValue();
    }

    public static final void w(AnimView animView) {
        l0.p(animView, "this$0");
        InnerTextureView innerTextureView = animView.f1798e;
        if (innerTextureView != null) {
            innerTextureView.setSurfaceTextureListener(null);
        }
        animView.f1798e = null;
        animView.removeAllViews();
    }

    public static final void x(AnimView animView) {
        l0.p(animView, "this$0");
        animView.removeAllViews();
        Context context = animView.getContext();
        l0.o(context, "context");
        InnerTextureView innerTextureView = new InnerTextureView(context, null, 0, 6, null);
        innerTextureView.setPlayer(animView.f1794a);
        innerTextureView.setOpaque(false);
        innerTextureView.setSurfaceTextureListener(animView);
        innerTextureView.setLayoutParams(animView.f1800g.d(innerTextureView));
        l2 l2Var = l2.f10208a;
        animView.f1798e = innerTextureView;
        animView.addView(innerTextureView);
    }

    public static final void z(AnimView animView) {
        l0.p(animView, "this$0");
        InnerTextureView innerTextureView = animView.f1798e;
        if (innerTextureView != null) {
            innerTextureView.setSurfaceTextureListener(null);
        }
        animView.f1798e = null;
        animView.removeAllViews();
    }

    public final void A(@l AssetManager assetManager, @l String str, boolean z10) {
        l0.p(assetManager, "assetManager");
        l0.p(str, "assetsPath");
        try {
            B(new g2.a(assetManager, str), z10);
        } catch (Throwable unused) {
            getAnimProxyListener().c(o.f5792q, o.f5800y);
            getAnimProxyListener().a();
        }
    }

    public final void B(@l g2.c cVar, boolean z10) {
        l0.p(cVar, "fileContainer");
        D(new e(cVar, z10));
    }

    public final void C(@l File file, boolean z10) {
        l0.p(file, "file");
        try {
            B(new g2.b(file), z10);
        } catch (Throwable unused) {
            getAnimProxyListener().c(o.f5792q, o.f5800y);
            getAnimProxyListener().a();
        }
    }

    public final void D(final jn.a<l2> aVar) {
        if (l0.g(Looper.myLooper(), Looper.getMainLooper())) {
            aVar.invoke();
        } else {
            getUiHandler().post(new Runnable() { // from class: f2.h
                @Override // java.lang.Runnable
                public final void run() {
                    AnimView.E(aVar);
                }
            });
        }
    }

    @Override // f2.y
    public void a() {
        this.f1794a.a0();
    }

    @Override // f2.y
    public void b() {
        if (this.f1804v) {
            getUiHandler().post(new Runnable() { // from class: f2.j
                @Override // java.lang.Runnable
                public final void run() {
                    AnimView.x(this.f5758a);
                }
            });
        } else {
            l2.a.f9640a.b(f1793z, "onSizeChanged not called");
            this.f1805w = true;
        }
    }

    @Override // f2.y
    public void c(@l g2.c cVar) {
        l0.p(cVar, "fileContainer");
        D(new d(cVar));
    }

    @Override // f2.y
    public void d(boolean z10, boolean z11) {
        g gVar = this.f1794a;
        gVar.f5745i = z10;
        gVar.f5746j = z11;
    }

    @Override // f2.y
    public void e(@l File file) {
        l0.p(file, "file");
        try {
            c(new g2.b(file));
        } catch (Throwable unused) {
            getAnimProxyListener().c(o.f5792q, o.f5800y);
            getAnimProxyListener().a();
        }
    }

    @Override // f2.y
    public void f(@l AssetManager assetManager, @l String str) {
        l0.p(assetManager, "assetManager");
        l0.p(str, "assetsPath");
        try {
            c(new g2.a(assetManager, str));
        } catch (Throwable unused) {
            getAnimProxyListener().c(o.f5792q, o.f5800y);
            getAnimProxyListener().a();
        }
    }

    @Override // f2.y
    public void g(@m i2.b bVar) {
        this.f1794a.b0(bVar);
    }

    @m
    public final t0<g2.c, Boolean> getMPlayBuff() {
        return this.f1806x;
    }

    @Override // f2.y
    @l
    public t0<Integer, Integer> getRealSize() {
        return this.f1800g.e();
    }

    @Override // f2.y
    @m
    public SurfaceTexture getSurfaceTexture() {
        InnerTextureView innerTextureView = this.f1798e;
        SurfaceTexture surfaceTexture = innerTextureView == null ? null : innerTextureView.getSurfaceTexture();
        return surfaceTexture == null ? this.f1796c : surfaceTexture;
    }

    @Override // f2.y
    public boolean isRunning() {
        return this.f1794a.z();
    }

    public void l() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        g2.c cVar;
        l2.a.f9640a.e(f1793z, "onAttachedToWindow");
        super.onAttachedToWindow();
        g gVar = this.f1794a;
        gVar.f5749m = false;
        if (gVar.f5744h <= 0 || (cVar = this.f1799f) == null) {
            return;
        }
        c(cVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        l2.a.f9640a.e(f1793z, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        if (this.f1802n) {
            g gVar = this.f1794a;
            gVar.f5749m = true;
            gVar.D();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        l2.a.f9640a.e(f1793z, e0.a.a("onSizeChanged w=", i10, ", h=", i11));
        k kVar = this.f1800g;
        kVar.f9663d = i10;
        kVar.f9664e = i11;
        this.f1804v = true;
        if (this.f1805w) {
            this.f1805w = false;
            b();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@l SurfaceTexture surfaceTexture, int i10, int i11) {
        SurfaceTexture surfaceTexture2;
        InnerTextureView innerTextureView;
        l0.p(surfaceTexture, "surface");
        l2.a.f9640a.e(f1793z, e0.a.a("onSurfaceTextureAvailable width=", i10, " height=", i11));
        if (!this.f1802n && (surfaceTexture2 = this.f1796c) != null && (innerTextureView = this.f1798e) != null) {
            l0.m(surfaceTexture2);
            innerTextureView.setSurfaceTexture(surfaceTexture2);
        }
        this.f1796c = surfaceTexture;
        this.f1794a.C(i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@l SurfaceTexture surfaceTexture) {
        l0.p(surfaceTexture, "surface");
        l2.a.f9640a.e(f1793z, "onSurfaceTextureDestroyed");
        this.f1796c = surfaceTexture;
        if (!this.f1802n) {
            return false;
        }
        this.f1794a.D();
        getUiHandler().post(new Runnable() { // from class: f2.k
            @Override // java.lang.Runnable
            public final void run() {
                AnimView.w(this.f5759a);
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@l SurfaceTexture surfaceTexture, int i10, int i11) {
        l0.p(surfaceTexture, "surface");
        l2.a.f9640a.e(f1793z, e0.a.a("onSurfaceTextureSizeChanged ", i10, " x ", i11));
        this.f1794a.E(i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@l SurfaceTexture surfaceTexture) {
        l0.p(surfaceTexture, "surface");
        l2.a.f9640a.e(f1793z, l0.C("onSurfaceTextureSizeChanged ", surfaceTexture));
    }

    @Override // f2.y
    public void setAnimListener(@m h2.a aVar) {
        this.f1797d = aVar;
    }

    public final void setAutoDismiss(boolean z10) {
        this.f1801i = z10;
        this.f1794a.f5738b = z10;
    }

    public final void setAutoRelease(boolean z10) {
        this.f1802n = z10;
    }

    @Override // f2.y
    public void setFetchResource(@m h2.b bVar) {
        j2.e eVar = this.f1794a.f5755s.f8909b;
        if (eVar == null) {
            return;
        }
        eVar.f8487b = bVar;
    }

    @Override // f2.y
    public void setFps(int i10) {
        l2.a.f9640a.e(f1793z, l0.C("setFps=", Integer.valueOf(i10)));
        this.f1794a.f5743g = i10;
    }

    @Override // f2.y
    public void setLoop(int i10) {
        this.f1794a.Q(i10);
    }

    public final void setMPlayBuff(@m t0<? extends g2.c, Boolean> t0Var) {
        this.f1806x = t0Var;
    }

    @Override // f2.y
    public void setMute(boolean z10) {
        l2.a.f9640a.b(f1793z, l0.C("set mute=", Boolean.valueOf(z10)));
        this.f1794a.f5753q = z10;
    }

    @Override // f2.y
    public void setOnResourceClickListener(@m h2.c cVar) {
        j2.e eVar = this.f1794a.f5755s.f8909b;
        if (eVar == null) {
            return;
        }
        eVar.f8488c = cVar;
    }

    @Override // f2.y
    public void setScaleType(@l l2.g gVar) {
        l0.p(gVar, y0.a.f8215h);
        this.f1800g.j(gVar);
    }

    @lm.k(message = "Compatible older version mp4")
    public final void setVideoMode(int i10) {
        this.f1794a.f5748l = i10;
    }

    public void t(boolean z10) {
        j2.e eVar = this.f1794a.f5755s.f8909b;
        if (eVar == null) {
            return;
        }
        eVar.f8495j = z10;
    }

    @lm.k(message = "Compatible older version mp4, default false")
    public final void u(boolean z10) {
        this.f1794a.f5747k = z10;
    }

    public final void v() {
        g2.c cVar = this.f1799f;
        if (cVar != null) {
            cVar.close();
        }
        D(new c());
    }

    public final void y() {
        g gVar = this.f1794a;
        gVar.f5749m = true;
        gVar.D();
        getUiHandler().post(new Runnable() { // from class: f2.i
            @Override // java.lang.Runnable
            public final void run() {
                AnimView.z(this.f5757a);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public AnimView(@l Context context, @m AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        l0.p(context, "context");
    }

    @Override // f2.y
    public void setScaleType(@l l2.e eVar) {
        l0.p(eVar, "scaleType");
        this.f1800g.f9668i = eVar;
    }

    public /* synthetic */ AnimView(Context context, AttributeSet attributeSet, int i10, int i11, w wVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @j
    public AnimView(@l Context context, @m AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l0.p(context, "context");
        this.f1795b = f0.b(f.INSTANCE);
        this.f1800g = new k();
        this.f1801i = true;
        this.f1802n = true;
        this.f1803p = f0.b(new b());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnimView);
        l0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.AnimView)");
        this.f1801i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AnimView_anim_view_auto_dismiss, true);
        typedArrayObtainStyledAttributes.recycle();
        v();
        g gVar = new g(this);
        this.f1794a = gVar;
        gVar.f5738b = this.f1801i;
        gVar.f5739c = getAnimProxyListener();
    }
}
