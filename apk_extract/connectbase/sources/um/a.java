package um;

import jn.p;
import kn.l0;
import lm.f1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public abstract class a implements g.b {

    @l
    private final g.c<?> key;

    public a(@l g.c<?> cVar) {
        l0.p(cVar, cb.b.c.f1408o);
        this.key = cVar;
    }

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @l p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r10, pVar);
    }

    @Override // um.g.b, um.g
    @m
    public <E extends g.b> E get(@l g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // um.g.b
    @l
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // um.g.b, um.g
    @l
    public g minusKey(@l g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // um.g
    @l
    public g plus(@l g gVar) {
        return g.b.a.d(this, gVar);
    }
}
