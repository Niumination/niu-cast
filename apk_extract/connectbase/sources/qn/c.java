package qn;

import kn.l0;
import os.l;
import os.m;
import un.o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<V> implements f<Object, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public V f14054a;

    public c(V v10) {
        this.f14054a = v10;
    }

    @Override // qn.f, qn.e
    public V a(@m Object obj, @l o<?> oVar) {
        l0.p(oVar, "property");
        return this.f14054a;
    }

    @Override // qn.f
    public void b(@m Object obj, @l o<?> oVar, V v10) {
        l0.p(oVar, "property");
        V v11 = this.f14054a;
        if (d(oVar, v11, v10)) {
            this.f14054a = v10;
            c(oVar, v11, v10);
        }
    }

    public void c(@l o<?> oVar, V v10, V v11) {
        l0.p(oVar, "property");
    }

    public boolean d(@l o<?> oVar, V v10, V v11) {
        l0.p(oVar, "property");
        return true;
    }

    @l
    public String toString() {
        return "ObservableProperty(value=" + this.f14054a + ')';
    }
}
