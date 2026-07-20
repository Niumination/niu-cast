package y4;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends v4.p0 {
    public static final v4.q0 FACTORY = new a();
    private final Class<Object> componentType;
    private final v4.p0 componentTypeAdapter;

    public b(v4.q qVar, v4.p0 p0Var, Class<Object> cls) {
        this.componentTypeAdapter = new i0(qVar, p0Var, cls);
        this.componentType = cls;
    }

    @Override // v4.p0
    public Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bVar.beginArray();
        while (bVar.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read(bVar));
        }
        bVar.endArray();
        int size = arrayList.size();
        if (!this.componentType.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.componentType, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.componentType, size);
        for (int i8 = 0; i8 < size; i8++) {
            Array.set(objNewInstance, i8, arrayList.get(i8));
        }
        return objNewInstance;
    }

    @Override // v4.p0
    public void write(d5.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.nullValue();
            return;
        }
        dVar.beginArray();
        int length = Array.getLength(obj);
        for (int i8 = 0; i8 < length; i8++) {
            this.componentTypeAdapter.write(dVar, Array.get(obj, i8));
        }
        dVar.endArray();
    }
}
