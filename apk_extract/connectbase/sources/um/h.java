package um;

import kn.l0;
import lm.f1;
import lm.r;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    @m
    @f1(version = "1.3")
    @r
    public static final <E extends g.b> E a(@l g.b bVar, @l g.c<E> cVar) {
        E e10;
        l0.p(bVar, "<this>");
        l0.p(cVar, cb.b.c.f1408o);
        if (!(cVar instanceof b)) {
            if (bVar.getKey() == cVar) {
                return bVar;
            }
            return null;
        }
        b bVar2 = (b) cVar;
        if (!bVar2.a(bVar.getKey()) || (e10 = (E) bVar2.b(bVar)) == null) {
            return null;
        }
        return e10;
    }

    @f1(version = "1.3")
    @r
    @l
    public static final g b(@l g.b bVar, @l g.c<?> cVar) {
        l0.p(bVar, "<this>");
        l0.p(cVar, cb.b.c.f1408o);
        if (!(cVar instanceof b)) {
            return bVar.getKey() == cVar ? i.INSTANCE : bVar;
        }
        b bVar2 = (b) cVar;
        return (!bVar2.a(bVar.getKey()) || bVar2.b(bVar) == null) ? bVar : i.INSTANCE;
    }
}
