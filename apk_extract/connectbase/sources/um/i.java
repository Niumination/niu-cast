package um;

import java.io.Serializable;
import jn.p;
import kn.l0;
import lm.f1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public final class i implements g, Serializable {

    @l
    public static final i INSTANCE = new i();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // um.g
    public <R> R fold(R r10, @l p<? super R, ? super g.b, ? extends R> pVar) {
        l0.p(pVar, "operation");
        return r10;
    }

    @Override // um.g
    @m
    public <E extends g.b> E get(@l g.c<E> cVar) {
        l0.p(cVar, cb.b.c.f1408o);
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // um.g
    @l
    public g minusKey(@l g.c<?> cVar) {
        l0.p(cVar, cb.b.c.f1408o);
        return this;
    }

    @Override // um.g
    @l
    public g plus(@l g gVar) {
        l0.p(gVar, "context");
        return gVar;
    }

    @l
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
