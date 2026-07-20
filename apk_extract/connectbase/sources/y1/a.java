package y1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import v1.a0;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class a<E> extends z<Object> {
    public static final a0 FACTORY = new C0536a();
    private final Class<E> componentType;
    private final z<E> componentTypeAdapter;

    /* JADX INFO: renamed from: y1.a$a, reason: collision with other inner class name */
    public class C0536a implements a0 {
        @Override // v1.a0
        public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type arrayComponentType = x1.b.getArrayComponentType(type);
            return new a(eVar, eVar.getAdapter(c2.a.get(arrayComponentType)), x1.b.getRawType(arrayComponentType));
        }
    }

    public a(v1.e eVar, z<E> zVar, Class<E> cls) {
        this.componentTypeAdapter = new n(eVar, zVar, cls);
        this.componentType = cls;
    }

    @Override // v1.z
    public Object read(d2.a aVar) throws IOException {
        if (aVar.peek() == d2.c.NULL) {
            aVar.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.beginArray();
        while (aVar.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read(aVar));
        }
        aVar.endArray();
        int size = arrayList.size();
        if (!this.componentType.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.componentType, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.componentType, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(objNewInstance, i10, arrayList.get(i10));
        }
        return objNewInstance;
    }

    @Override // v1.z
    public void write(d2.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.nullValue();
            return;
        }
        dVar.beginArray();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.componentTypeAdapter.write(dVar, (E) Array.get(obj, i10));
        }
        dVar.endArray();
    }
}
