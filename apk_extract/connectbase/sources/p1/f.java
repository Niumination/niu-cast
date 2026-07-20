package p1;

import f1.d2;
import f1.k3;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@d
public final class f<B> extends d2<q<? extends B>, B> implements p<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k3<q<? extends B>, B> f12704a;

    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k3.b<q<? extends B>, B> f12705a;

        public f<B> a() {
            return new f<>(this.f12705a.d());
        }

        @t1.a
        public <T extends B> b<B> b(Class<T> key, T value) {
            this.f12705a.i(q.of((Class) key), value);
            return this;
        }

        @t1.a
        public <T extends B> b<B> c(q<T> key, T value) {
            this.f12705a.i(key.rejectTypeVariables(), value);
            return this;
        }

        public b() {
            this.f12705a = k3.builder();
        }
    }

    public static <B> b<B> l() {
        return new b<>();
    }

    public static <B> f<B> m() {
        return new f<>(k3.of());
    }

    @Override // f1.d2, f1.j2
    public Object delegate() {
        return this.f12704a;
    }

    @Override // p1.p
    @gm.a
    public <T extends B> T getInstance(Class<T> cls) {
        return this.f12704a.get(q.of((Class) cls));
    }

    @Override // p1.p
    @gm.a
    public <T extends B> T n(q<T> qVar) {
        return this.f12704a.get(qVar.rejectTypeVariables());
    }

    @Override // p1.p
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public <T extends B> T o(q<T> type, T value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.d2, java.util.Map, f1.w
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public Object put(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.d2, java.util.Map, f1.w
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends q<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    @Override // p1.p
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public <T extends B> T putInstance(Class<T> type, T value) {
        throw new UnsupportedOperationException();
    }

    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public B q(q<? extends B> key, B value) {
        throw new UnsupportedOperationException();
    }

    @gm.a
    public final <T extends B> T r(q<T> qVar) {
        return this.f12704a.get(qVar);
    }

    public f(k3<q<? extends B>, B> delegate) {
        this.f12704a = delegate;
    }

    @Override // f1.d2, f1.j2
    public Map<q<? extends B>, B> delegate() {
        return this.f12704a;
    }
}
