package y4;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends v4.p0 {
    private static final v4.q0 DOUBLE_FACTORY = newFactory(v4.m0.DOUBLE);
    private final v4.q gson;
    private final v4.n0 toNumberStrategy;

    public /* synthetic */ z(v4.q qVar, v4.n0 n0Var, int i8) {
        this(qVar, n0Var);
    }

    public static v4.q0 getFactory(v4.n0 n0Var) {
        return n0Var == v4.m0.DOUBLE ? DOUBLE_FACTORY : newFactory(n0Var);
    }

    private static v4.q0 newFactory(v4.n0 n0Var) {
        return new v(n0Var, 1);
    }

    private Object readTerminal(d5.b bVar, d5.c cVar) throws IOException {
        int i8 = y.f11074a[cVar.ordinal()];
        if (i8 == 3) {
            return bVar.nextString();
        }
        if (i8 == 4) {
            return this.toNumberStrategy.readNumber(bVar);
        }
        if (i8 == 5) {
            return Boolean.valueOf(bVar.nextBoolean());
        }
        if (i8 == 6) {
            bVar.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + cVar);
    }

    private Object tryBeginNesting(d5.b bVar, d5.c cVar) throws IOException {
        int i8 = y.f11074a[cVar.ordinal()];
        if (i8 == 1) {
            bVar.beginArray();
            return new ArrayList();
        }
        if (i8 != 2) {
            return null;
        }
        bVar.beginObject();
        return new x4.q();
    }

    @Override // v4.p0
    public Object read(d5.b bVar) throws IOException {
        d5.c cVarPeek = bVar.peek();
        Object objTryBeginNesting = tryBeginNesting(bVar, cVarPeek);
        if (objTryBeginNesting == null) {
            return readTerminal(bVar, cVarPeek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (bVar.hasNext()) {
                String strNextName = objTryBeginNesting instanceof Map ? bVar.nextName() : null;
                d5.c cVarPeek2 = bVar.peek();
                Object objTryBeginNesting2 = tryBeginNesting(bVar, cVarPeek2);
                boolean z2 = objTryBeginNesting2 != null;
                if (objTryBeginNesting2 == null) {
                    objTryBeginNesting2 = readTerminal(bVar, cVarPeek2);
                }
                if (objTryBeginNesting instanceof List) {
                    ((List) objTryBeginNesting).add(objTryBeginNesting2);
                } else {
                    ((Map) objTryBeginNesting).put(strNextName, objTryBeginNesting2);
                }
                if (z2) {
                    arrayDeque.addLast(objTryBeginNesting);
                    objTryBeginNesting = objTryBeginNesting2;
                }
            } else {
                if (objTryBeginNesting instanceof List) {
                    bVar.endArray();
                } else {
                    bVar.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return objTryBeginNesting;
                }
                objTryBeginNesting = arrayDeque.removeLast();
            }
        }
    }

    @Override // v4.p0
    public void write(d5.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.nullValue();
            return;
        }
        v4.p0 adapter = this.gson.getAdapter(obj.getClass());
        if (!(adapter instanceof z)) {
            adapter.write(dVar, obj);
        } else {
            dVar.beginObject();
            dVar.endObject();
        }
    }

    private z(v4.q qVar, v4.n0 n0Var) {
        this.gson = qVar;
        this.toNumberStrategy = n0Var;
    }
}
