package y4;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends v4.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f11064a = new n();

    private n() {
    }

    public static v4.u a(d5.b bVar, d5.c cVar) throws IOException {
        int i8 = m.f11063a[cVar.ordinal()];
        if (i8 == 3) {
            return new v4.z(bVar.nextString());
        }
        if (i8 == 4) {
            return new v4.z(new x4.l(bVar.nextString()));
        }
        if (i8 == 5) {
            return new v4.z(Boolean.valueOf(bVar.nextBoolean()));
        }
        if (i8 == 6) {
            bVar.nextNull();
            return v4.w.INSTANCE;
        }
        throw new IllegalStateException("Unexpected token: " + cVar);
    }

    public static v4.u b(d5.b bVar, d5.c cVar) throws IOException {
        int i8 = m.f11063a[cVar.ordinal()];
        if (i8 == 1) {
            bVar.beginArray();
            return new v4.t();
        }
        if (i8 != 2) {
            return null;
        }
        bVar.beginObject();
        return new v4.x();
    }

    public static void c(v4.u uVar, d5.d dVar) throws IOException {
        if (uVar == null || uVar.isJsonNull()) {
            dVar.nullValue();
            return;
        }
        if (uVar.isJsonPrimitive()) {
            v4.z asJsonPrimitive = uVar.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                dVar.value(asJsonPrimitive.getAsNumber());
                return;
            } else if (asJsonPrimitive.isBoolean()) {
                dVar.value(asJsonPrimitive.getAsBoolean());
                return;
            } else {
                dVar.value(asJsonPrimitive.getAsString());
                return;
            }
        }
        if (uVar.isJsonArray()) {
            dVar.beginArray();
            Iterator<v4.u> it = uVar.getAsJsonArray().iterator();
            while (it.hasNext()) {
                c(it.next(), dVar);
            }
            dVar.endArray();
            return;
        }
        if (!uVar.isJsonObject()) {
            throw new IllegalArgumentException("Couldn't write " + uVar.getClass());
        }
        dVar.beginObject();
        for (Map.Entry<String, v4.u> entry : uVar.getAsJsonObject().entrySet()) {
            dVar.name(entry.getKey());
            c(entry.getValue(), dVar);
        }
        dVar.endObject();
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar instanceof q) {
            return ((q) bVar).g();
        }
        d5.c cVarPeek = bVar.peek();
        v4.u uVarB = b(bVar, cVarPeek);
        if (uVarB == null) {
            return a(bVar, cVarPeek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (bVar.hasNext()) {
                String strNextName = uVarB instanceof v4.x ? bVar.nextName() : null;
                d5.c cVarPeek2 = bVar.peek();
                v4.u uVarB2 = b(bVar, cVarPeek2);
                boolean z2 = uVarB2 != null;
                if (uVarB2 == null) {
                    uVarB2 = a(bVar, cVarPeek2);
                }
                if (uVarB instanceof v4.t) {
                    ((v4.t) uVarB).add(uVarB2);
                } else {
                    ((v4.x) uVarB).add(strNextName, uVarB2);
                }
                if (z2) {
                    arrayDeque.addLast(uVarB);
                    uVarB = uVarB2;
                }
            } else {
                if (uVarB instanceof v4.t) {
                    bVar.endArray();
                } else {
                    bVar.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return uVarB;
                }
                uVarB = (v4.u) arrayDeque.removeLast();
            }
        }
    }

    @Override // v4.p0
    public final /* bridge */ /* synthetic */ void write(d5.d dVar, Object obj) throws IOException {
        c((v4.u) obj, dVar);
    }
}
