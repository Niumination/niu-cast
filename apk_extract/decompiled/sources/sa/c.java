package sa;

import android.util.Log;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.rd;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f9586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f9587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f9588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AnimView f9589d;
    public final /* synthetic */ VapResource e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f9590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Boolean f9591i;

    public c(AtomicBoolean atomicBoolean, Ref.IntRef intRef, AtomicBoolean atomicBoolean2, AnimView animView, VapResource vapResource, boolean z2, Boolean bool) {
        this.f9586a = atomicBoolean;
        this.f9587b = intRef;
        this.f9588c = atomicBoolean2;
        this.f9589d = animView;
        this.e = vapResource;
        this.f9590h = z2;
        this.f9591i = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2 = this.f9586a.get();
        AnimView animView = this.f9589d;
        if (!z2) {
            Ref.IntRef intRef = this.f9587b;
            if (intRef.element < 5) {
                AtomicBoolean atomicBoolean = this.f9588c;
                if (atomicBoolean.compareAndSet(false, true)) {
                    int i8 = intRef.element + 1;
                    intRef.element = i8;
                    String strM = o.d.m("firstFrame not rendered, retry #", "AnimView", "tag", "log", i8);
                    if (gc.f6462a <= 5) {
                        Log.w(gc.f6463b.concat("AnimView"), strM);
                    }
                    rd.a(animView, this.e, this.f9591i, this.f9590h);
                    atomicBoolean.set(false);
                    animView.postDelayed(this, 300L);
                    return;
                }
            }
        }
        animView.removeCallbacks(this);
    }
}
