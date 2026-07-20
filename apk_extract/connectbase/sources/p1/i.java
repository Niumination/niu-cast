package p1;

import f1.d2;
import f1.e2;
import f1.h4;
import f1.l2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@d
public final class i<B> extends d2<q<? extends B>, B> implements p<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<q<? extends B>, B> f12711a = new HashMap();

    public static final class a<K, V> extends e2<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map.Entry<K, V> f12712a;

        /* JADX INFO: renamed from: p1.i$a$a, reason: collision with other inner class name */
        public class C0322a extends l2<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Set f12713a;

            public C0322a(final Set val$entries) {
                this.f12713a = val$entries;
            }

            @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return a.r(super.iterator());
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
            public Set<Map.Entry<K, V>> delegate() {
                return this.f12713a;
            }
        }

        public a(Map.Entry<K, V> delegate) {
            delegate.getClass();
            this.f12712a = delegate;
        }

        public static /* synthetic */ a m(Map.Entry entry) {
            return new a(entry);
        }

        public static <K, V> Iterator<Map.Entry<K, V>> r(Iterator<Map.Entry<K, V>> entries) {
            return h4.c0(entries, new h());
        }

        public static <K, V> Set<Map.Entry<K, V>> s(Set<Map.Entry<K, V>> entries) {
            return new C0322a(entries);
        }

        @Override // f1.e2, f1.j2
        public Object delegate() {
            return this.f12712a;
        }

        @Override // f1.e2
        /* JADX INFO: renamed from: l */
        public Map.Entry<K, V> delegate() {
            return this.f12712a;
        }

        @Override // f1.e2, java.util.Map.Entry
        @k
        public V setValue(@k V value) {
            throw new UnsupportedOperationException();
        }
    }

    @gm.a
    private <T extends B> T m(q<T> qVar) {
        return this.f12711a.get(qVar);
    }

    @Override // f1.d2, f1.j2
    public Object delegate() {
        return this.f12711a;
    }

    @Override // f1.d2, java.util.Map
    public Set<Map.Entry<q<? extends B>, B>> entrySet() {
        return new a.C0322a(super.entrySet());
    }

    @Override // p1.p
    @gm.a
    public <T extends B> T getInstance(Class<T> cls) {
        return this.f12711a.get(q.of((Class) cls));
    }

    @Override // f1.d2, java.util.Map, f1.w
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public B put(q<? extends B> key, @k B value) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // p1.p
    @gm.a
    public <T extends B> T n(q<T> qVar) {
        return this.f12711a.get(qVar.rejectTypeVariables());
    }

    @Override // p1.p
    @gm.a
    @t1.a
    public <T extends B> T o(q<T> qVar, @k T t10) {
        return this.f12711a.put(qVar.rejectTypeVariables(), t10);
    }

    @Override // f1.d2, java.util.Map, f1.w
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends q<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // p1.p
    @gm.a
    @t1.a
    public <T extends B> T putInstance(Class<T> cls, @k T t10) {
        return this.f12711a.put(q.of((Class) cls), t10);
    }

    @gm.a
    public final <T extends B> T q(q<T> qVar, @k T t10) {
        return this.f12711a.put(qVar, t10);
    }

    @Override // f1.d2, f1.j2
    public Map<q<? extends B>, B> delegate() {
        return this.f12711a;
    }
}
