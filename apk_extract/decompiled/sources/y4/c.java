package y4;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends v4.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11034a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11036c;

    public c(i0 i0Var, x4.t tVar) {
        this.f11035b = i0Var;
        this.f11036c = tVar;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        switch (this.f11034a) {
            case 0:
                if (bVar.peek() == d5.c.NULL) {
                    bVar.nextNull();
                    return null;
                }
                Collection collection = (Collection) ((x4.t) this.f11036c).construct();
                bVar.beginArray();
                while (bVar.hasNext()) {
                    collection.add(((i0) this.f11035b).f11057b.read(bVar));
                }
                bVar.endArray();
                return collection;
            default:
                Object obj = ((c1) this.f11036c).f11042c.read(bVar);
                if (obj != null) {
                    Class cls = (Class) this.f11035b;
                    if (!cls.isInstance(obj)) {
                        throw new v4.a0("Expected a " + cls.getName() + " but was " + obj.getClass().getName() + "; at path " + bVar.getPreviousPath());
                    }
                }
                return obj;
        }
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        switch (this.f11034a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    dVar.beginArray();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((i0) this.f11035b).write(dVar, it.next());
                    }
                    dVar.endArray();
                } else {
                    dVar.nullValue();
                }
                break;
            default:
                ((c1) this.f11036c).f11042c.write(dVar, obj);
                break;
        }
    }

    public c(c1 c1Var, Class cls) {
        this.f11036c = c1Var;
        this.f11035b = cls;
    }
}
