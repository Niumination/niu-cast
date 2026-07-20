package y4;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends v4.p0 {
    private static final v4.q0 LAZILY_PARSED_NUMBER_FACTORY = newFactory(v4.m0.LAZILY_PARSED_NUMBER);
    private final v4.n0 toNumberStrategy;

    private x(v4.n0 n0Var) {
        this.toNumberStrategy = n0Var;
    }

    public static v4.q0 getFactory(v4.n0 n0Var) {
        return n0Var == v4.m0.LAZILY_PARSED_NUMBER ? LAZILY_PARSED_NUMBER_FACTORY : newFactory(n0Var);
    }

    private static v4.q0 newFactory(v4.n0 n0Var) {
        return new v(new x(n0Var), 0);
    }

    @Override // v4.p0
    public Number read(d5.b bVar) throws IOException {
        d5.c cVarPeek = bVar.peek();
        int i8 = w.f11073a[cVarPeek.ordinal()];
        if (i8 == 1) {
            bVar.nextNull();
            return null;
        }
        if (i8 == 2 || i8 == 3) {
            return this.toNumberStrategy.readNumber(bVar);
        }
        throw new v4.a0("Expecting number, got: " + cVarPeek + "; at path " + bVar.getPath());
    }

    @Override // v4.p0
    public void write(d5.d dVar, Number number) throws IOException {
        dVar.value(number);
    }
}
