package fl;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements c {
    @Override // fl.c
    @os.m
    public final <T> T b(@os.l b<T> bVar) {
        kn.l0.p(bVar, cb.b.c.f1408o);
        return (T) j().get(bVar);
    }

    @Override // fl.c
    public final <T> void c(@os.l b<T> bVar) {
        kn.l0.p(bVar, cb.b.c.f1408o);
        j().remove(bVar);
    }

    @Override // fl.c
    public final boolean d(@os.l b<?> bVar) {
        kn.l0.p(bVar, cb.b.c.f1408o);
        return j().containsKey(bVar);
    }

    @Override // fl.c
    @os.m
    public <T> T e(@os.l b<T> bVar) {
        return (T) c.a.c(this, bVar);
    }

    @Override // fl.c
    @os.l
    public final List<b<?>> f() {
        return nm.h0.V5(j().keySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // fl.c
    public final <T> void g(@os.l b<T> bVar, @os.l T t10) {
        kn.l0.p(bVar, cb.b.c.f1408o);
        kn.l0.p(t10, "value");
        j().put(bVar, t10);
    }

    @Override // fl.c
    @os.l
    public <T> T h(@os.l b<T> bVar) {
        return (T) c.a.a(this, bVar);
    }

    @Override // fl.c
    @os.l
    public <T> T i(@os.l b<T> bVar) {
        return (T) c.a.b(this, bVar);
    }

    @os.l
    public abstract Map<b<?>, Object> j();
}
