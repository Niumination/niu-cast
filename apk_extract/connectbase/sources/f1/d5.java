package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@b1.d
public final class d5<B> extends d2<Class<? extends B>, B> implements a0<B>, Serializable {
    private final Map<Class<? extends B>, B> delegate;

    public class a extends e2<Class<? extends B>, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f4802a;

        public a(final Map.Entry val$entry) {
            this.f4802a = val$entry;
        }

        @Override // f1.e2, f1.j2
        /* JADX INFO: renamed from: l */
        public Map.Entry<Class<? extends B>, B> delegate() {
            return this.f4802a;
        }

        @Override // f1.e2, java.util.Map.Entry
        @m5
        public B setValue(@m5 B b10) {
            d5.l(getKey(), b10);
            return (B) super.setValue(b10);
        }
    }

    public class b extends l2<Map.Entry<Class<? extends B>, B>> {

        public class a extends o7<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public a(final b this$1, Iterator backingIterator) {
                super(backingIterator);
            }

            @Override // f1.o7
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> from) {
                return d5.access$100(from);
            }
        }

        public b() {
        }

        @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(delegate().iterator());
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return d5.this.delegate().entrySet();
        }
    }

    public static final class c<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        public c(Map<Class<? extends B>, B> backingMap) {
            this.backingMap = backingMap;
        }

        public Object readResolve() {
            return d5.create(this.backingMap);
        }
    }

    public d5(Map<Class<? extends B>, B> delegate) {
        delegate.getClass();
        this.delegate = delegate;
    }

    public static Map.Entry access$100(Map.Entry entry) {
        return new a(entry);
    }

    public static <B> d5<B> create() {
        return new d5<>(new HashMap());
    }

    @gm.a
    @t1.a
    public static <T> T l(Class<T> cls, @gm.a Object obj) {
        return (T) o1.q.f(cls).cast(obj);
    }

    public static <B> Map.Entry<Class<? extends B>, B> m(final Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new c(delegate());
    }

    @Override // f1.d2, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    @Override // f1.a0
    @gm.a
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) l(cls, get(cls));
    }

    @Override // f1.d2, java.util.Map, f1.w
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            l((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.a0
    @gm.a
    @t1.a
    public <T extends B> T putInstance(Class<T> cls, @m5 T t10) {
        return (T) l(cls, put((Class<? extends T>) cls, t10));
    }

    public static <B> d5<B> create(Map<Class<? extends B>, B> backingMap) {
        return new d5<>(backingMap);
    }

    @Override // f1.d2, f1.j2
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // f1.d2, java.util.Map, f1.w
    @gm.a
    @t1.a
    public B put(Class<? extends B> cls, @m5 B b10) {
        l(cls, b10);
        return (B) super.put(cls, b10);
    }
}
