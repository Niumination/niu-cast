package e1;

import f1.k3;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@i
public abstract class k<K, V> extends j<K, V> implements l<K, V> {

    public static abstract class a<K, V> extends k<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l<K, V> f3944a;

        public a(l<K, V> delegate) {
            delegate.getClass();
            this.f3944a = delegate;
        }

        @Override // e1.k, e1.j, f1.j2
        public c delegate() {
            return this.f3944a;
        }

        @Override // e1.k
        /* JADX INFO: renamed from: l */
        public final l<K, V> delegate() {
            return this.f3944a;
        }

        @Override // e1.k, e1.j, f1.j2
        public Object delegate() {
            return this.f3944a;
        }
    }

    @Override // e1.l, c1.t
    public V apply(K key) {
        return delegate().apply(key);
    }

    @Override // e1.l
    @t1.a
    public V get(K key) throws ExecutionException {
        return delegate().get(key);
    }

    @Override // e1.l
    @t1.a
    public k3<K, V> getAll(Iterable<? extends K> keys) throws ExecutionException {
        return delegate().getAll(keys);
    }

    @Override // e1.l
    @t1.a
    public V getUnchecked(K key) {
        return delegate().getUnchecked(key);
    }

    @Override // e1.j, f1.j2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract l<K, V> delegate();

    @Override // e1.l
    public void refresh(K key) {
        delegate().refresh(key);
    }
}
