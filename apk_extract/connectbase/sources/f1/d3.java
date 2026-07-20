package f1;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@t1.j(containerOf = {"B"})
public final class d3<B> extends d2<Class<? extends B>, B> implements a0<B>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3<Object> f4800a = new d3<>(k3.of());
    private final k3<Class<? extends B>, B> delegate;

    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k3.b<Class<? extends B>, B> f4801a = k3.builder();

        public static <T> T b(Class<T> cls, Object obj) {
            return (T) o1.q.f(cls).cast(obj);
        }

        public d3<B> a() {
            k3<Class<? extends B>, B> k3VarD = this.f4801a.d();
            return k3VarD.isEmpty() ? d3.of() : new d3<>(k3VarD);
        }

        @t1.a
        public <T extends B> b<B> c(Class<T> key, T value) {
            this.f4801a.i(key, value);
            return this;
        }

        @t1.a
        public <T extends B> b<B> d(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class key = entry.getKey();
                T value = entry.getValue();
                this.f4801a.i((Class<? extends B>) key, (B) b(key, value));
            }
            return this;
        }
    }

    public static <B> b<B> builder() {
        return new b<>();
    }

    public static <B, S extends B> d3<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        return map instanceof d3 ? (d3) map : new b().d(map).a();
    }

    public static <B> d3<B> of() {
        return (d3<B>) f4800a;
    }

    @Override // f1.a0
    @gm.a
    public <T extends B> T getInstance(Class<T> cls) {
        k3<Class<? extends B>, B> k3Var = this.delegate;
        cls.getClass();
        return k3Var.get(cls);
    }

    @Override // f1.a0
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public <T extends B> T putInstance(Class<T> type, T value) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? of() : this;
    }

    public d3(k3<Class<? extends B>, B> delegate) {
        this.delegate = delegate;
    }

    public static <B, T extends B> d3<B> of(Class<T> type, T value) {
        return new d3<>(k3.of(type, value));
    }

    @Override // f1.d2, f1.j2
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
