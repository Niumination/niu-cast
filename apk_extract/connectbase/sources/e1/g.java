package e1;

import c1.q0;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import q1.h1;
import q1.s1;
import q1.t1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@i
public abstract class g<K, V> {

    public class a extends g<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f3936b;

        public a(final Executor val$executor) {
            this.f3936b = val$executor;
        }

        public static /* synthetic */ Object b(g gVar, Object obj, Object obj2) throws Exception {
            return gVar.reload(obj, obj2).get();
        }

        @Override // e1.g
        public V load(K k10) throws Exception {
            return (V) g.this.load(k10);
        }

        @Override // e1.g
        public Map<K, V> loadAll(Iterable<? extends K> keys) throws Exception {
            return g.this.loadAll(keys);
        }

        @Override // e1.g
        public s1<V> reload(final K key, final V oldValue) {
            final g gVar = g.this;
            t1 t1VarB = t1.b(new Callable() { // from class: e1.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return g.a.b(gVar, key, oldValue);
                }
            });
            this.f3936b.execute(t1VarB);
            return t1VarB;
        }
    }

    public static final class b<K, V> extends g<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final c1.t<K, V> computingFunction;

        public b(c1.t<K, V> computingFunction) {
            computingFunction.getClass();
            this.computingFunction = computingFunction;
        }

        @Override // e1.g
        public V load(K key) {
            c1.t<K, V> tVar = this.computingFunction;
            key.getClass();
            return tVar.apply(key);
        }
    }

    public static final class c extends RuntimeException {
        public c(String message) {
            super(message);
        }
    }

    public static final class d<V> extends g<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final q0<V> computingSupplier;

        public d(q0<V> computingSupplier) {
            computingSupplier.getClass();
            this.computingSupplier = computingSupplier;
        }

        @Override // e1.g
        public V load(Object key) {
            key.getClass();
            return this.computingSupplier.get();
        }
    }

    public static final class e extends UnsupportedOperationException {
    }

    @b1.c
    public static <K, V> g<K, V> asyncReloading(final g<K, V> loader, final Executor executor) {
        loader.getClass();
        executor.getClass();
        return loader.new a(executor);
    }

    public static <K, V> g<K, V> from(c1.t<K, V> function) {
        return new b(function);
    }

    public abstract V load(K key) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> keys) throws Exception {
        throw new e();
    }

    @b1.c
    public s1<V> reload(K key, V oldValue) throws Exception {
        key.getClass();
        oldValue.getClass();
        return h1.o(load(key));
    }

    public static <V> g<Object, V> from(q0<V> supplier) {
        return new d(supplier);
    }
}
