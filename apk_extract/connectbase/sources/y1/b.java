package y1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import v1.a0;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a0 {
    private final x1.c constructorConstructor;

    public static final class a<E> extends z<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z<E> f20617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x1.k<? extends Collection<E>> f20618b;

        public a(v1.e eVar, Type type, z<E> zVar, x1.k<? extends Collection<E>> kVar) {
            this.f20617a = new n(eVar, zVar, type);
            this.f20618b = kVar;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<E> read(d2.a aVar) throws IOException {
            if (aVar.peek() == d2.c.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> collectionConstruct = this.f20618b.construct();
            aVar.beginArray();
            while (aVar.hasNext()) {
                collectionConstruct.add(this.f20617a.read(aVar));
            }
            aVar.endArray();
            return collectionConstruct;
        }

        @Override // v1.z
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(d2.d dVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                dVar.nullValue();
                return;
            }
            dVar.beginArray();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f20617a.write(dVar, it.next());
            }
            dVar.endArray();
        }
    }

    public b(x1.c cVar) {
        this.constructorConstructor = cVar;
    }

    @Override // v1.a0
    public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = x1.b.getCollectionElementType(type, rawType);
        return new a(eVar, collectionElementType, eVar.getAdapter(c2.a.get(collectionElementType)), this.constructorConstructor.get(aVar));
    }
}
