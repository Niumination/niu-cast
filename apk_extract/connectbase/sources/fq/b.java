package fq;

import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b<Object, Object> f6328c = new b<>(d.a(), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<a<e<K, V>>> f6329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6330b;

    public b(d<a<e<K, V>>> dVar, int i10) {
        this.f6329a = dVar;
        this.f6330b = i10;
    }

    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i10 != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    @l
    public static <K, V> b<K, V> c() {
        b<K, V> bVar = (b<K, V>) f6328c;
        if (bVar == null) {
            a(0);
        }
        return bVar;
    }

    public static <K, V> int f(a<e<K, V>> aVar, Object obj) {
        int i10 = 0;
        while (aVar != null && aVar.f6326c > 0) {
            if (aVar.f6324a.key.equals(obj)) {
                return i10;
            }
            aVar = aVar.f6325b;
            i10++;
        }
        return -1;
    }

    public boolean b(Object obj) {
        return f(e(obj.hashCode()), obj) != -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V d(Object obj) {
        for (a aVarE = e(obj.hashCode()); aVarE != null && aVarE.f6326c > 0; aVarE = aVarE.f6325b) {
            e eVar = (e) aVarE.f6324a;
            if (eVar.key.equals(obj)) {
                return eVar.value;
            }
        }
        return null;
    }

    public final a<e<K, V>> e(int i10) {
        a<e<K, V>> aVarB = this.f6329a.b(i10);
        return aVarB == null ? a.b() : aVarB;
    }

    @l
    public b<K, V> g(Object obj) {
        a<e<K, V>> aVarE = e(obj.hashCode());
        int iF = f(aVarE, obj);
        if (iF == -1) {
            return this;
        }
        a<e<K, V>> aVarE2 = aVarE.e(iF);
        return aVarE2.f6326c == 0 ? new b<>(this.f6329a.c(obj.hashCode()), this.f6330b - 1) : new b<>(this.f6329a.d(obj.hashCode(), aVarE2), this.f6330b - 1);
    }

    @l
    public b<K, V> h(K k10, V v10) {
        a<e<K, V>> aVarE = e(k10.hashCode());
        int i10 = aVarE.f6326c;
        int iF = f(aVarE, k10);
        if (iF != -1) {
            aVarE = aVarE.e(iF);
        }
        e eVar = new e(k10, v10);
        aVarE.getClass();
        a<e<K, V>> aVar = new a<>(eVar, aVarE);
        return new b<>(this.f6329a.d(k10.hashCode(), aVar), (this.f6330b - i10) + aVar.f6326c);
    }

    public int i() {
        return this.f6330b;
    }
}
