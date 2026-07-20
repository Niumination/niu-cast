package um;

import jn.p;
import kn.l0;
import lm.f1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public interface e extends g.b {

    @l
    public static final b G = b.f16331a;

    public static final class a {
        public static <R> R a(@l e eVar, R r10, @l p<? super R, ? super g.b, ? extends R> pVar) {
            l0.p(pVar, "operation");
            return (R) g.b.a.a(eVar, r10, pVar);
        }

        @m
        public static <E extends g.b> E b(@l e eVar, @l g.c<E> cVar) {
            E e10;
            l0.p(cVar, cb.b.c.f1408o);
            if (!(cVar instanceof um.b)) {
                if (e.G != cVar) {
                    return null;
                }
                l0.n(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            um.b bVar = (um.b) cVar;
            if (!bVar.a(eVar.getKey()) || (e10 = (E) bVar.b(eVar)) == null) {
                return null;
            }
            return e10;
        }

        @l
        public static g c(@l e eVar, @l g.c<?> cVar) {
            l0.p(cVar, cb.b.c.f1408o);
            if (!(cVar instanceof um.b)) {
                return e.G == cVar ? i.INSTANCE : eVar;
            }
            um.b bVar = (um.b) cVar;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : i.INSTANCE;
        }

        @l
        public static g d(@l e eVar, @l g gVar) {
            l0.p(gVar, "context");
            return g.b.a.d(eVar, gVar);
        }

        public static void e(@l e eVar, @l d<?> dVar) {
            l0.p(dVar, "continuation");
        }
    }

    public static final class b implements g.c<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f16331a = new b();
    }

    @Override // um.g.b, um.g
    @m
    <E extends g.b> E get(@l g.c<E> cVar);

    @l
    <T> d<T> interceptContinuation(@l d<? super T> dVar);

    @Override // um.g.b, um.g
    @l
    g minusKey(@l g.c<?> cVar);

    void releaseInterceptedContinuation(@l d<?> dVar);
}
