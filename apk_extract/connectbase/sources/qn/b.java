package qn;

import kn.l0;
import os.l;
import os.m;
import un.o;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements f<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public T f14053a;

    @Override // qn.f, qn.e
    @l
    public T a(@m Object obj, @l o<?> oVar) {
        l0.p(oVar, "property");
        T t10 = this.f14053a;
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Property " + oVar.getName() + " should be initialized before get.");
    }

    @Override // qn.f
    public void b(@m Object obj, @l o<?> oVar, @l T t10) {
        l0.p(oVar, "property");
        l0.p(t10, "value");
        this.f14053a = t10;
    }

    @l
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("NotNullProperty(");
        if (this.f14053a != null) {
            str = "value=" + this.f14053a;
        } else {
            str = "value not initialized yet";
        }
        return l.a.a(sb2, str, ')');
    }
}
