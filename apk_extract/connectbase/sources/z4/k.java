package z4;

import android.hardware.display.VirtualDisplay;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VirtualDisplay f21827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r4.d f21828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r4.c f21829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t5.d f21831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f21832f;

    public k(@NonNull VirtualDisplay virtualDisplay, @NonNull r4.c cVar, t5.d dVar, @NonNull r4.d dVar2, boolean z10, int i10) {
        this.f21827a = virtualDisplay;
        this.f21828b = dVar2;
        this.f21829c = cVar;
        this.f21830d = z10;
        this.f21831e = dVar;
        this.f21832f = i10;
    }

    public int a() {
        return this.f21827a.getDisplay().getDisplayId();
    }

    public int b() {
        return this.f21828b.i();
    }

    public int c() {
        return this.f21832f;
    }

    public t5.d d() {
        return this.f21831e;
    }

    public r4.d e() {
        return this.f21828b;
    }

    public r4.c f() {
        return this.f21829c;
    }

    public VirtualDisplay g() {
        return this.f21827a;
    }

    public boolean h() {
        return this.f21830d;
    }

    public void i(int i10) {
        this.f21828b.s(i10);
    }
}
