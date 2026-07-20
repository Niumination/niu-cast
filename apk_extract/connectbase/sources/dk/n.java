package dk;

import nq.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends IllegalStateException implements l0<n> {

    @os.l
    private final fl.b<?> key;

    public n(@os.l fl.b<?> bVar) {
        kn.l0.p(bVar, cb.b.c.f1408o);
        this.key = bVar;
    }

    @os.l
    public final fl.b<?> getKey() {
        return this.key;
    }

    @Override // java.lang.Throwable
    @os.l
    public String getMessage() {
        return j.c.a(new StringBuilder("Application feature "), this.key.f6017a, " is not installed");
    }

    @Override // nq.l0
    @os.m
    public n createCopy() {
        n nVar = new n(this.key);
        nVar.initCause(this);
        return nVar;
    }
}
