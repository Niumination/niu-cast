package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@b1.d
public final class i6 {

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Field f4978a;

        public void a(T instance, int value) {
            try {
                this.f4978a.set(instance, Integer.valueOf(value));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        public void b(T instance, Object value) {
            try {
                this.f4978a.set(instance, value);
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        public b(Field field) {
            this.f4978a = field;
            field.setAccessible(true);
        }
    }

    public static <T> b<T> a(Class<T> clazz, String fieldName) {
        try {
            return new b<>(clazz.getDeclaredField(fieldName));
        } catch (NoSuchFieldException e10) {
            throw new AssertionError(e10);
        }
    }

    public static <K, V> void b(Map<K, V> map, ObjectInputStream stream) throws IOException, ClassNotFoundException {
        c(map, stream, stream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(Map<K, V> map, ObjectInputStream stream, int size) throws IOException, ClassNotFoundException {
        for (int i10 = 0; i10 < size; i10++) {
            map.put(stream.readObject(), stream.readObject());
        }
    }

    public static <K, V> void d(v4<K, V> multimap, ObjectInputStream stream) throws IOException, ClassNotFoundException {
        e(multimap, stream, stream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(v4<K, V> multimap, ObjectInputStream stream, int distinctKeys) throws IOException, ClassNotFoundException {
        for (int i10 = 0; i10 < distinctKeys; i10++) {
            Collection collection = multimap.get(stream.readObject());
            int i11 = stream.readInt();
            for (int i12 = 0; i12 < i11; i12++) {
                collection.add(stream.readObject());
            }
        }
    }

    public static <E> void f(b5<E> multiset, ObjectInputStream stream) throws IOException, ClassNotFoundException {
        g(multiset, stream, stream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(b5<E> multiset, ObjectInputStream stream, int distinctElements) throws IOException, ClassNotFoundException {
        for (int i10 = 0; i10 < distinctElements; i10++) {
            multiset.add(stream.readObject(), stream.readInt());
        }
    }

    public static int h(ObjectInputStream stream) throws IOException {
        return stream.readInt();
    }

    public static <K, V> void i(Map<K, V> map, ObjectOutputStream stream) throws IOException {
        stream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    public static <K, V> void j(v4<K, V> multimap, ObjectOutputStream stream) throws IOException {
        stream.writeInt(multimap.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
            stream.writeObject(entry.getKey());
            stream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                stream.writeObject(it.next());
            }
        }
    }

    public static <E> void k(b5<E> multiset, ObjectOutputStream stream) throws IOException {
        stream.writeInt(multiset.entrySet().size());
        for (b5.a<E> aVar : multiset.entrySet()) {
            stream.writeObject(aVar.getElement());
            stream.writeInt(aVar.getCount());
        }
    }
}
