package y1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import v1.a0;
import v1.q;
import v1.u;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class h implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20620a;
    private final x1.c constructorConstructor;

    public final class a<K, V> extends z<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z<K> f20621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z<V> f20622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final x1.k<? extends Map<K, V>> f20623c;

        public a(v1.e eVar, Type type, z<K> zVar, Type type2, z<V> zVar2, x1.k<? extends Map<K, V>> kVar) {
            this.f20621a = new n(eVar, zVar, type);
            this.f20622b = new n(eVar, zVar2, type2);
            this.f20623c = kVar;
        }

        public final String a(v1.k kVar) {
            if (!kVar.isJsonPrimitive()) {
                if (kVar.isJsonNull()) {
                    return d6.a.E;
                }
                throw new AssertionError();
            }
            q asJsonPrimitive = kVar.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return String.valueOf(asJsonPrimitive.getAsNumber());
            }
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.toString(asJsonPrimitive.getAsBoolean());
            }
            if (asJsonPrimitive.isString()) {
                return asJsonPrimitive.getAsString();
            }
            throw new AssertionError();
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<K, V> read(d2.a aVar) throws IOException {
            d2.c cVarPeek = aVar.peek();
            if (cVarPeek == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> mapConstruct = this.f20623c.construct();
            if (cVarPeek == d2.c.BEGIN_ARRAY) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    K k10 = this.f20621a.read(aVar);
                    if (mapConstruct.put(k10, this.f20622b.read(aVar)) != null) {
                        throw new u(c0.a.a("duplicate key: ", k10));
                    }
                    aVar.endArray();
                }
                aVar.endArray();
            } else {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    x1.g.INSTANCE.promoteNameToValue(aVar);
                    K k11 = this.f20621a.read(aVar);
                    if (mapConstruct.put(k11, this.f20622b.read(aVar)) != null) {
                        throw new u(c0.a.a("duplicate key: ", k11));
                    }
                }
                aVar.endObject();
            }
            return mapConstruct;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Map<K, V> map) throws IOException {
            if (map == null) {
                dVar.nullValue();
                return;
            }
            if (!h.this.f20620a) {
                dVar.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    dVar.name(String.valueOf(entry.getKey()));
                    this.f20622b.write(dVar, entry.getValue());
                }
                dVar.endObject();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z10 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                v1.k jsonTree = this.f20621a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z10 |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (!z10) {
                dVar.beginObject();
                int size = arrayList.size();
                while (i10 < size) {
                    dVar.name(a((v1.k) arrayList.get(i10)));
                    this.f20622b.write(dVar, (V) arrayList2.get(i10));
                    i10++;
                }
                dVar.endObject();
                return;
            }
            dVar.beginArray();
            int size2 = arrayList.size();
            while (i10 < size2) {
                dVar.beginArray();
                x1.o.write((v1.k) arrayList.get(i10), dVar);
                this.f20622b.write(dVar, (V) arrayList2.get(i10));
                dVar.endArray();
                i10++;
            }
            dVar.endArray();
        }
    }

    public h(x1.c cVar, boolean z10) {
        this.constructorConstructor = cVar;
        this.f20620a = z10;
    }

    private z<?> getKeyAdapter(v1.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? o.BOOLEAN_AS_STRING : eVar.getAdapter(c2.a.get(type));
    }

    @Override // v1.a0
    public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] mapKeyAndValueTypes = x1.b.getMapKeyAndValueTypes(type, rawType);
        return new a(eVar, mapKeyAndValueTypes[0], getKeyAdapter(eVar, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], eVar.getAdapter(c2.a.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(aVar));
    }
}
