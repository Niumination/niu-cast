package fk;

import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ck.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final nk.a f5060c = nk.c.f8331d.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ck.a f5061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ck.b f5062b;

    public e(ck.a aVar, ck.b bVar) {
        this.f5061a = aVar;
        this.f5062b = bVar;
    }

    @Override // ek.b
    /* JADX INFO: renamed from: call */
    public final void mo0call(Object obj) {
        ck.i iVar = (ck.i) obj;
        try {
            nk.a aVar = f5060c;
            ck.b bVar = this.f5062b;
            aVar.getClass();
            ck.i iVar2 = (ck.i) bVar.call(iVar);
            try {
                iVar2.getClass();
                this.f5061a.mo0call(iVar2);
            } catch (Throwable th2) {
                x1.b(th2);
                iVar2.onError(th2);
            }
        } catch (Throwable th3) {
            x1.b(th3);
            iVar.onError(th3);
        }
    }
}
