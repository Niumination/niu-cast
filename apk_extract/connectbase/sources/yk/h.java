package yk;

import ik.b1;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
@v
public abstract class h implements dk.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dk.a f21403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final fl.c f21404b;

    public h(@os.l dk.a aVar) {
        l0.p(aVar, n1.i.f11236l);
        this.f21403a = aVar;
        this.f21404b = fl.e.b(false, 1, null);
    }

    public static /* synthetic */ void h(h hVar, l lVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putResponseAttribute");
        }
        if ((i10 & 1) != 0) {
            lVar = hVar.f();
        }
        hVar.g(lVar);
    }

    @Override // dk.b
    @os.l
    public final dk.a a() {
        return this.f21403a;
    }

    @os.l
    public abstract k b();

    @Override // dk.b
    @os.l
    public final fl.c c() {
        return this.f21404b;
    }

    @os.l
    public abstract l f();

    @v
    public final void g(@os.l l lVar) {
        l0.p(lVar, "response");
        fl.c cVar = this.f21404b;
        l.f21420f.getClass();
        cVar.g(l.f21421g, lVar);
    }

    @Override // dk.b
    @os.l
    public b1 getParameters() {
        return b().j();
    }
}
