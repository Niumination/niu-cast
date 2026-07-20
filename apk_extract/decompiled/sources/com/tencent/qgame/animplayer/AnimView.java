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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import c6.c;
import com.tencent.qgame.animplayer.textureview.InnerTextureView;
import com.transsion.message.bank.MessageBank;
import d6.d;
import d6.e;
import d6.f;
import d6.g;
import d6.h;
import d6.i;
import d6.l;
import d6.t;
import d6.u;
import d6.w;
import e6.b;
import f6.a;
import j6.k;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001;\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0010J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010$J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010$J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b+\u0010/J\u0017\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\fH\u0016¢\u0006\u0004\b1\u0010\u0010J\u001b\u00103\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b02H\u0016¢\u0006\u0004\b3\u00104R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010>R0\u0010F\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\f\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u00104\"\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/tencent/qgame/animplayer/AnimView;", "Ld6/u;", "Landroid/widget/FrameLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "autoDismiss", "", "setAutoDismiss", "(Z)V", "autoRelease", "setAutoRelease", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "Lf6/a;", "animListener", "setAnimListener", "(Lf6/a;)V", "Lf6/b;", "fetchResource", "setFetchResource", "(Lf6/b;)V", "Lf6/c;", "resourceClickListener", "setOnResourceClickListener", "(Lf6/c;)V", "playLoop", "setLoop", "(I)V", "mode", "setVideoMode", "fps", "setFps", "Lj6/c;", MessageBank.KEY_TYPE, "setScaleType", "(Lj6/c;)V", "Lj6/a;", "scaleType", "(Lj6/a;)V", "isMute", "setMute", "Lkotlin/Pair;", "getRealSize", "()Lkotlin/Pair;", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "getUiHandler", "()Landroid/os/Handler;", "uiHandler", "d6/f", "l", "getAnimProxyListener", "()Ld6/f;", "animProxyListener", "Le6/b;", "o", "Lkotlin/Pair;", "getMPlayBuff", "setMPlayBuff", "(Lkotlin/Pair;)V", "mPlayBuff", "vapplayer_release"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class AnimView extends FrameLayout implements u, TextureView.SurfaceTextureListener {
    public static final /* synthetic */ int p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Lazy uiHandler;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceTexture f2301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f2302d;
    public InnerTextureView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f2303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f2304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2306k;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Lazy animProxyListener;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2308m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2309n;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    public Pair mPlayBuff;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimView(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final f getAnimProxyListener() {
        return (f) this.animProxyListener.getValue();
    }

    private final Handler getUiHandler() {
        return (Handler) this.uiHandler.getValue();
    }

    public final void a() {
        b bVar = this.f2303h;
        if (bVar != null) {
            bVar.close();
        }
        e(new h(this));
    }

    public final void b() {
        if (this.f2308m) {
            getUiHandler().post(new e(this, 0));
            return;
        }
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter("onSizeChanged not called", NotificationCompat.CATEGORY_MESSAGE);
        this.f2309n = true;
    }

    public final void c(AssetManager assetManager, String assetsPath) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(assetsPath, "assetsPath");
        try {
            e6.a fileContainer = new e6.a(assetManager, assetsPath);
            Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
            e(new i(this, fileContainer));
        } catch (Throwable unused) {
            getAnimProxyListener().c(10007, "0x7 file can't read");
            getAnimProxyListener().a();
        }
    }

    public final void d(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            e6.a fileContainer = new e6.a(file);
            Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
            e(new i(this, fileContainer));
        } catch (Throwable unused) {
            getAnimProxyListener().c(10007, "0x7 file can't read");
            getAnimProxyListener().a();
        }
    }

    public final void e(Function0 function0) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else {
            getUiHandler().post(new c(1, function0));
        }
    }

    public final Pair<b, Boolean> getMPlayBuff() {
        return this.mPlayBuff;
    }

    public Pair<Integer, Integer> getRealSize() {
        Pair<Integer, Integer> pairA = this.f2304i.a().a();
        String msg = "get real size (" + pairA.getFirst().intValue() + ", " + pairA.getSecond().intValue() + ')';
        Intrinsics.checkNotNullParameter("AnimPlayer.ScaleTypeUtil", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        return pairA;
    }

    @Override // d6.u
    public SurfaceTexture getSurfaceTexture() {
        InnerTextureView innerTextureView = this.e;
        SurfaceTexture surfaceTexture = innerTextureView == null ? null : innerTextureView.getSurfaceTexture();
        return surfaceTexture == null ? this.f2301c : surfaceTexture;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        b fileContainer;
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter("onAttachedToWindow", NotificationCompat.CATEGORY_MESSAGE);
        super.onAttachedToWindow();
        d dVar = this.f2299a;
        dVar.f4318j = false;
        if (dVar.f4316h <= 0 || (fileContainer = this.f2303h) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
        e(new i(this, fileContainer));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter("onDetachedFromWindow", NotificationCompat.CATEGORY_MESSAGE);
        super.onDetachedFromWindow();
        if (this.f2306k) {
            d dVar = this.f2299a;
            dVar.f4318j = true;
            dVar.d();
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        String msg = o.d.f(i8, i9, "onSizeChanged w=", ", h=");
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        k kVar = this.f2304i;
        kVar.f6119d = i8;
        kVar.e = i9;
        this.f2308m = true;
        if (this.f2309n) {
            this.f2309n = false;
            b();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surface, int i8, int i9) {
        SurfaceTexture surfaceTexture;
        InnerTextureView innerTextureView;
        Intrinsics.checkNotNullParameter(surface, "surface");
        String msg = "onSurfaceTextureAvailable width=" + i8 + " height=" + i9;
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (!this.f2306k && (surfaceTexture = this.f2301c) != null && (innerTextureView = this.e) != null) {
            Intrinsics.checkNotNull(surfaceTexture);
            innerTextureView.setSurfaceTexture(surfaceTexture);
        }
        this.f2301c = surface;
        d dVar = this.f2299a;
        dVar.f4319k = true;
        Runnable runnable = dVar.f4320l;
        if (runnable != null) {
            runnable.run();
        }
        dVar.f4320l = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter("onSurfaceTextureDestroyed", NotificationCompat.CATEGORY_MESSAGE);
        this.f2301c = surface;
        if (!this.f2306k) {
            return false;
        }
        this.f2299a.d();
        getUiHandler().post(new e(this, 1));
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surface, int i8, int i9) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        String msg = "onSurfaceTextureSizeChanged " + i8 + " x " + i9;
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        t tVar = this.f2299a.f4314d;
        if (tVar == null) {
            return;
        }
        tVar.e = i8;
        tVar.f = i9;
        w wVar = tVar.f4347b;
        if (wVar == null) {
            return;
        }
        wVar.d(i8, i9);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        String msg = Intrinsics.stringPlus("onSurfaceTextureSizeChanged ", surface);
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    public void setAnimListener(a animListener) {
        this.f2302d = animListener;
    }

    public final void setAutoDismiss(boolean autoDismiss) {
        this.f2305j = autoDismiss;
        this.f2299a.f4312b = autoDismiss;
    }

    public final void setAutoRelease(boolean autoRelease) {
        this.f2306k = autoRelease;
    }

    public void setFetchResource(f6.b fetchResource) {
        Object obj = this.f2299a.p.f4924d;
    }

    public void setFps(int fps) {
        String msg = Intrinsics.stringPlus("setFps=", Integer.valueOf(fps));
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.f2299a.f4315g = fps;
    }

    public void setLoop(int playLoop) {
        d dVar = this.f2299a;
        t tVar = dVar.f4314d;
        if (tVar != null) {
            tVar.f4350g = playLoop;
        }
        l lVar = dVar.e;
        if (lVar != null) {
            lVar.f4331g = playLoop;
        }
        dVar.f4316h = playLoop;
    }

    public final void setMPlayBuff(Pair<? extends b, Boolean> pair) {
        this.mPlayBuff = pair;
    }

    public void setMute(boolean isMute) {
        String msg = Intrinsics.stringPlus("set mute=", Boolean.valueOf(isMute));
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.f2299a.f4322n = isMute;
    }

    public void setOnResourceClickListener(f6.c resourceClickListener) {
        Object obj = this.f2299a.p.f4924d;
    }

    public void setScaleType(j6.a scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.f2304i.f6122i = scaleType;
    }

    @Deprecated(message = "Compatible older version mp4")
    public final void setVideoMode(int mode) {
        this.f2299a.f4317i = mode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void setScaleType(j6.c type) {
        Intrinsics.checkNotNullParameter(type, "type");
        k kVar = this.f2304i;
        kVar.getClass();
        Intrinsics.checkNotNullParameter(type, "<set-?>");
        kVar.f6121h = type;
    }

    public /* synthetic */ AnimView(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.uiHandler = LazyKt.lazy(d6.k.INSTANCE);
        this.f2304i = new k();
        this.f2305j = true;
        this.f2306k = true;
        this.animProxyListener = LazyKt.lazy(new g(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AnimView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.AnimView)");
        this.f2305j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AnimView_anim_view_auto_dismiss, true);
        typedArrayObtainStyledAttributes.recycle();
        a();
        d dVar = new d(this);
        this.f2299a = dVar;
        dVar.f4312b = this.f2305j;
        dVar.f4313c = getAnimProxyListener();
    }
}
