package um;

import kn.l0;
import lm.f1;
import lm.r;
import os.l;
import os.m;
import um.g.b;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
@r
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final jn.l<g.b, E> f16329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final g.c<?> f16330b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [um.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, jn.l<? super um.g$b, ? extends E extends B>, jn.l<um.g$b, E extends B>] */
    public b(@l g.c<B> cVar, @l jn.l<? super g.b, ? extends E> lVar) {
        l0.p(cVar, "baseKey");
        l0.p(lVar, "safeCast");
        this.f16329a = lVar;
        this.f16330b = cVar instanceof b ? (g.c<B>) ((b) cVar).f16330b : cVar;
    }

    public final boolean a(@l g.c<?> cVar) {
        l0.p(cVar, cb.b.c.f1408o);
        return cVar == this || this.f16330b == cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lum/g$b;)TE; */
    @m
    public final g.b b(@l g.b bVar) {
        l0.p(bVar, "element");
        return (g.b) this.f16329a.invoke(bVar);
    }
}
