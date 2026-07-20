package cf;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends af.l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f1466d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i8) {
        super(cVar, 1);
        this.f1465c = i8;
        switch (i8) {
            case 1:
                this.f1466d = cVar;
                super(cVar, 1);
                ph.b.c();
                break;
            default:
                this.f1466d = cVar;
                ph.b.c();
                break;
        }
    }

    @Override // af.l0
    public final void a() {
        c cVar;
        int i8;
        c cVar2;
        switch (this.f1465c) {
            case 0:
                qj.f fVar = new qj.f();
                ph.b.d();
                try {
                    ph.a aVar = ph.b.f8887a;
                    aVar.getClass();
                    synchronized (this.f1466d.f1491a) {
                        qj.f fVar2 = this.f1466d.f1492b;
                        fVar.k0(fVar2, fVar2.h());
                        cVar = this.f1466d;
                        cVar.f1495h = false;
                        i8 = cVar.f1502o;
                        break;
                    }
                    cVar.f1498k.k0(fVar, fVar.f9195b);
                    synchronized (this.f1466d.f1491a) {
                        this.f1466d.f1502o -= i8;
                        break;
                    }
                    aVar.getClass();
                    return;
                } catch (Throwable th2) {
                    try {
                        ph.b.f8887a.getClass();
                        break;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            default:
                qj.f fVar3 = new qj.f();
                ph.b.d();
                try {
                    ph.a aVar2 = ph.b.f8887a;
                    aVar2.getClass();
                    synchronized (this.f1466d.f1491a) {
                        qj.f fVar4 = this.f1466d.f1492b;
                        fVar3.k0(fVar4, fVar4.f9195b);
                        cVar2 = this.f1466d;
                        cVar2.f1496i = false;
                        break;
                    }
                    cVar2.f1498k.k0(fVar3, fVar3.f9195b);
                    this.f1466d.f1498k.flush();
                    aVar2.getClass();
                    return;
                } catch (Throwable th4) {
                    try {
                        ph.b.f8887a.getClass();
                        break;
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                    throw th4;
                }
        }
    }
}
