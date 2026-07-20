package y4;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends v4.p0 {
    private final e0 fieldsData;

    public b0(e0 e0Var) {
        this.fieldsData = e0Var;
    }

    public abstract Object a();

    public abstract Object b(Object obj);

    public abstract void c(Object obj, d5.b bVar, c0 c0Var);

    @Override // v4.p0
    public Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        Object objA = a();
        Map map = this.fieldsData.f11045a;
        try {
            bVar.beginObject();
            while (bVar.hasNext()) {
                c0 c0Var = (c0) map.get(bVar.nextName());
                if (c0Var == null) {
                    bVar.skipValue();
                } else {
                    c(objA, bVar, c0Var);
                }
            }
            bVar.endObject();
            return b(objA);
        } catch (IllegalAccessException e) {
            throw a5.d.createExceptionForUnexpectedIllegalAccess(e);
        } catch (IllegalStateException e4) {
            throw new v4.a0(e4);
        }
    }

    @Override // v4.p0
    public void write(d5.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.nullValue();
            return;
        }
        dVar.beginObject();
        try {
            Iterator it = this.fieldsData.f11046b.iterator();
            while (it.hasNext()) {
                ((c0) it.next()).a(dVar, obj);
            }
            dVar.endObject();
        } catch (IllegalAccessException e) {
            throw a5.d.createExceptionForUnexpectedIllegalAccess(e);
        }
    }
}
