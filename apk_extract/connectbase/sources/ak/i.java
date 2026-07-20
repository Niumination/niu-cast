package ak;

import vj.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class i {

    public enum a {
        BLOCKING(g.EnumC0004g.BLOCKING),
        ASYNC(g.EnumC0004g.ASYNC),
        FUTURE(g.EnumC0004g.FUTURE);

        private final g.EnumC0004g internalType;

        a(g.EnumC0004g enumC0004g) {
            this.internalType = enumC0004g;
        }

        public static a of(g.EnumC0004g enumC0004g) {
            for (a aVar : values()) {
                if (aVar.internalType == enumC0004g) {
                    return aVar;
                }
            }
            throw new AssertionError("Unknown StubType: " + enumC0004g.name());
        }
    }

    public static a a(vj.e eVar) {
        return a.of((g.EnumC0004g) eVar.j(g.f262c));
    }

    public static vj.e.c<g.EnumC0004g> b() {
        return g.f262c;
    }

    public static vj.e c(vj.e eVar, a aVar) {
        return eVar.x(g.f262c, aVar.internalType);
    }
}
