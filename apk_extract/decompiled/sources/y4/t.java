package y4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends v4.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f11066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f11067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x4.t f11068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u f11069d;

    public t(u uVar, i0 i0Var, i0 i0Var2, x4.t tVar) {
        this.f11069d = uVar;
        this.f11066a = i0Var;
        this.f11067b = i0Var2;
        this.f11068c = tVar;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        d5.c cVarPeek = bVar.peek();
        if (cVarPeek == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        Map map = (Map) this.f11068c.construct();
        if (cVarPeek == d5.c.BEGIN_ARRAY) {
            bVar.beginArray();
            while (bVar.hasNext()) {
                bVar.beginArray();
                Object obj = this.f11066a.f11057b.read(bVar);
                if (map.put(obj, this.f11067b.f11057b.read(bVar)) != null) {
                    throw new v4.a0(a1.a.p(obj, "duplicate key: "));
                }
                bVar.endArray();
            }
            bVar.endArray();
        } else {
            bVar.beginObject();
            while (bVar.hasNext()) {
                x4.k.INSTANCE.promoteNameToValue(bVar);
                Object obj2 = this.f11066a.f11057b.read(bVar);
                if (map.put(obj2, this.f11067b.f11057b.read(bVar)) != null) {
                    throw new v4.a0(a1.a.p(obj2, "duplicate key: "));
                }
            }
            bVar.endObject();
        }
        return map;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        String asString;
        Map map = (Map) obj;
        if (map == null) {
            dVar.nullValue();
            return;
        }
        boolean z2 = this.f11069d.f11070a;
        i0 i0Var = this.f11067b;
        if (!z2) {
            dVar.beginObject();
            for (Map.Entry entry : map.entrySet()) {
                dVar.name(String.valueOf(entry.getKey()));
                i0Var.write(dVar, entry.getValue());
            }
            dVar.endObject();
            return;
        }
        ArrayList arrayList = new ArrayList(map.size());
        ArrayList arrayList2 = new ArrayList(map.size());
        int i8 = 0;
        boolean z3 = false;
        for (Map.Entry entry2 : map.entrySet()) {
            v4.u jsonTree = this.f11066a.toJsonTree(entry2.getKey());
            arrayList.add(jsonTree);
            arrayList2.add(entry2.getValue());
            z3 |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
        }
        if (z3) {
            dVar.beginArray();
            int size = arrayList.size();
            while (i8 < size) {
                dVar.beginArray();
                x4.c0.write((v4.u) arrayList.get(i8), dVar);
                i0Var.write(dVar, arrayList2.get(i8));
                dVar.endArray();
                i8++;
            }
            dVar.endArray();
            return;
        }
        dVar.beginObject();
        int size2 = arrayList.size();
        while (i8 < size2) {
            v4.u uVar = (v4.u) arrayList.get(i8);
            if (uVar.isJsonPrimitive()) {
                v4.z asJsonPrimitive = uVar.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    asString = String.valueOf(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    asString = Boolean.toString(asJsonPrimitive.getAsBoolean());
                } else {
                    if (!asJsonPrimitive.isString()) {
                        throw new AssertionError();
                    }
                    asString = asJsonPrimitive.getAsString();
                }
            } else {
                if (!uVar.isJsonNull()) {
                    throw new AssertionError();
                }
                asString = "null";
            }
            dVar.name(asString);
            i0Var.write(dVar, arrayList2.get(i8));
            i8++;
        }
        dVar.endObject();
    }
}
