package i2;

import android.view.MotionEvent;
import f2.g;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class a implements k2.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final C0211a f7668d = new C0211a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final String f7669e = "AnimPlayer.MaskAnimPlugin";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final g f7670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public c f7671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public f2.a f7672c;

    /* JADX INFO: renamed from: i2.a$a, reason: collision with other inner class name */
    public static final class C0211a {
        public C0211a() {
        }

        public C0211a(w wVar) {
        }
    }

    public a(@l g gVar) {
        l0.p(gVar, "player");
        this.f7670a = gVar;
    }

    @Override // k2.b
    public void a(int i10) {
        f2.a aVar;
        c cVar;
        g gVar = this.f7670a;
        if (!gVar.f5745i || (aVar = gVar.f5754r.f5673b) == null) {
            return;
        }
        this.f7672c = aVar;
        if (aVar == null || (cVar = this.f7671b) == null) {
            return;
        }
        cVar.d(aVar);
    }

    @Override // k2.b
    public void b() {
        h();
    }

    @Override // k2.b
    public boolean c(@l MotionEvent motionEvent) {
        return k2.b.a.d(this, motionEvent);
    }

    @Override // k2.b
    public void d() {
        h();
    }

    @Override // k2.b
    public int e(@l f2.a aVar) {
        l0.p(aVar, "config");
        return 0;
    }

    @Override // k2.b
    public void f(int i10) {
    }

    @Override // k2.b
    public void g() {
        l2.a.f9640a.e(f7669e, "mask render init");
        if (this.f7670a.f5745i) {
            c cVar = new c(this);
            this.f7671b = cVar;
            cVar.c(this.f7670a.f5746j);
        }
    }

    public final void h() {
        b bVar;
        f2.a aVar = this.f7672c;
        if (aVar == null || (bVar = aVar.f5664n) == null) {
            return;
        }
        bVar.e();
    }

    @l
    public final g i() {
        return this.f7670a;
    }
}
