package sa;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.rd;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f9580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimView f9581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f9582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f9583d;
    public final /* synthetic */ VapResource e;
    public final /* synthetic */ Boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f9584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f9585h;

    public b(AtomicBoolean atomicBoolean, AnimView animView, c cVar, Ref.IntRef intRef, VapResource vapResource, Boolean bool, boolean z2, AtomicBoolean atomicBoolean2) {
        this.f9580a = atomicBoolean;
        this.f9581b = animView;
        this.f9582c = cVar;
        this.f9583d = intRef;
        this.e = vapResource;
        this.f = bool;
        this.f9584g = z2;
        this.f9585h = atomicBoolean2;
    }

    @Override // f6.a
    public final void a() {
        Intrinsics.checkNotNullParameter("AnimView", "tag");
        Intrinsics.checkNotNullParameter("onVideoComplete", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("AnimView"), "onVideoComplete");
        }
        this.f9581b.removeCallbacks(this.f9582c);
    }

    @Override // f6.a
    public final void b() {
        Intrinsics.checkNotNullParameter("AnimView", "tag");
        Intrinsics.checkNotNullParameter("onVideoDestroy", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("AnimView"), "onVideoDestroy");
        }
        this.f9581b.removeCallbacks(this.f9582c);
        this.f9580a.set(false);
        this.f9585h.set(false);
        this.f9583d.element = 0;
    }

    @Override // f6.a
    public final void c(int i8, String str) {
        Log.d("AnimView", "onFailed: " + i8 + ", " + str);
        Ref.IntRef intRef = this.f9583d;
        int i9 = intRef.element;
        boolean z2 = this.f9584g;
        Boolean bool = this.f;
        VapResource vapResource = this.e;
        AnimView animView = this.f9581b;
        if (i9 <= 1) {
            intRef.element = i9 + 1;
            rd.a(animView, vapResource, bool, z2);
            return;
        }
        Log.d("AnimView", "newView");
        ViewGroup.LayoutParams layoutParams = animView.getLayoutParams();
        Context context = animView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        AnimView animView2 = new AnimView(context, null, 6, 0);
        animView2.setLayoutParams(layoutParams);
        ViewParent parent = animView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        viewGroup.removeView(animView);
        viewGroup.addView(animView2);
        d.i(animView2, vapResource, bool, z2);
    }

    @Override // f6.a
    public final void d() {
        this.f9583d.element = 0;
    }

    @Override // f6.a
    public final void e(int i8, d6.a aVar) {
        if (i8 == 0 && this.f9580a.compareAndSet(false, true)) {
            Intrinsics.checkNotNullParameter("AnimView", "tag");
            Intrinsics.checkNotNullParameter("firstFrame rendered", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("AnimView"), "firstFrame rendered");
            }
            this.f9581b.removeCallbacks(this.f9582c);
        }
    }

    @Override // f6.a
    public final boolean f(d6.a config) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(config, "config");
        return true;
    }
}
