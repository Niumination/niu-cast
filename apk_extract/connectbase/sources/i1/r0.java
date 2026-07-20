package i1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@w
public final class r0<K, V> extends q0<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.a
    public volatile transient a<K, V> f7640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @gm.a
    public volatile transient a<K, V> f7641d;

    public static final class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f7642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f7643b;

        public a(K key, V value) {
            this.f7642a = key;
            this.f7643b = value;
        }
    }

    public r0(Map<K, V> backingMap) {
        super(backingMap);
    }

    @Override // i1.q0
    public void d() {
        this.f7617b = null;
        this.f7640c = null;
        this.f7641d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.q0
    @gm.a
    public V f(Object key) {
        key.getClass();
        V vG = g(key);
        if (vG != null) {
            return vG;
        }
        V vH = h(key);
        if (vH != null) {
            m(key, vH);
        }
        return vH;
    }

    @Override // i1.q0
    @gm.a
    public V g(@gm.a Object obj) {
        V v10 = (V) super.g(obj);
        if (v10 != null) {
            return v10;
        }
        a<K, V> aVar = this.f7640c;
        if (aVar != null && aVar.f7642a == obj) {
            return aVar.f7643b;
        }
        a<K, V> aVar2 = this.f7641d;
        if (aVar2 == null || aVar2.f7642a != obj) {
            return null;
        }
        l(aVar2);
        return aVar2.f7643b;
    }

    public final void l(a<K, V> entry) {
        this.f7641d = this.f7640c;
        this.f7640c = entry;
    }

    public final void m(K key, V value) {
        l(new a<>(key, value));
    }
}
