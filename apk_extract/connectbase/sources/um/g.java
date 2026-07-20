package um;

import jn.p;
import kn.l0;
import kn.n0;
import lm.f1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: um.g$a$a, reason: collision with other inner class name */
        public static final class C0439a extends n0 implements p<g, b, g> {
            public static final C0439a INSTANCE = new C0439a();

            public C0439a() {
                super(2);
            }

            @Override // jn.p
            @l
            public final g invoke(@l g gVar, @l b bVar) {
                um.c cVar;
                l0.p(gVar, "acc");
                l0.p(bVar, "element");
                g gVarMinusKey = gVar.minusKey(bVar.getKey());
                i iVar = i.INSTANCE;
                if (gVarMinusKey == iVar) {
                    return bVar;
                }
                e.b bVar2 = e.G;
                e eVar = (e) gVarMinusKey.get(bVar2);
                if (eVar == null) {
                    cVar = new um.c(gVarMinusKey, bVar);
                } else {
                    g gVarMinusKey2 = gVarMinusKey.minusKey(bVar2);
                    if (gVarMinusKey2 == iVar) {
                        return new um.c(bVar, eVar);
                    }
                    cVar = new um.c(new um.c(gVarMinusKey2, bVar), eVar);
                }
                return cVar;
            }
        }

        @l
        public static g a(@l g gVar, @l g gVar2) {
            l0.p(gVar2, "context");
            return gVar2 == i.INSTANCE ? gVar : (g) gVar2.fold(gVar, C0439a.INSTANCE);
        }
    }

    public interface b extends g {

        public static final class a {
            public static <R> R a(@l b bVar, R r10, @l p<? super R, ? super b, ? extends R> pVar) {
                l0.p(pVar, "operation");
                return pVar.invoke(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @m
            public static <E extends b> E b(@l b bVar, @l c<E> cVar) {
                l0.p(cVar, cb.b.c.f1408o);
                if (!l0.g(bVar.getKey(), cVar)) {
                    return null;
                }
                l0.n(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            @l
            public static g c(@l b bVar, @l c<?> cVar) {
                l0.p(cVar, cb.b.c.f1408o);
                return l0.g(bVar.getKey(), cVar) ? i.INSTANCE : bVar;
            }

            @l
            public static g d(@l b bVar, @l g gVar) {
                l0.p(gVar, "context");
                return a.a(bVar, gVar);
            }
        }

        @Override // um.g
        <R> R fold(R r10, @l p<? super R, ? super b, ? extends R> pVar);

        @Override // um.g
        @m
        <E extends b> E get(@l c<E> cVar);

        @l
        c<?> getKey();

        @Override // um.g
        @l
        g minusKey(@l c<?> cVar);
    }

    public interface c<E extends b> {
    }

    <R> R fold(R r10, @l p<? super R, ? super b, ? extends R> pVar);

    @m
    <E extends b> E get(@l c<E> cVar);

    @l
    g minusKey(@l c<?> cVar);

    @l
    g plus(@l g gVar);
}
