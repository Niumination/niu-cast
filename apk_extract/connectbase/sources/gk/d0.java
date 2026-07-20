package gk;

import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements fl.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.d<?> f6576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public jn.p<? super List<String>, ? super Type, ? extends Object> f6577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public jn.l<Object, ? extends List<String>> f6578c;

    public d0(@os.l un.d<?> dVar) {
        kn.l0.p(dVar, "klass");
        this.f6576a = dVar;
    }

    @Override // fl.v
    @os.l
    public List<String> a(@os.m Object obj) throws fl.c0 {
        jn.l<Object, ? extends List<String>> lVar = this.f6578c;
        if (lVar != null) {
            return lVar.invoke(obj);
        }
        throw new fl.c0("Encoder was not specified for class '" + this.f6576a + '\'');
    }

    @Override // fl.v
    @os.m
    public Object b(@os.l List<String> list, @os.l Type type) throws fl.c0 {
        kn.l0.p(list, "values");
        kn.l0.p(type, ik.y0.a.f8215h);
        jn.p<? super List<String>, ? super Type, ? extends Object> pVar = this.f6577b;
        if (pVar != null) {
            return pVar.invoke(list, type);
        }
        throw new fl.c0("Decoder was not specified for class '" + this.f6576a + '\'');
    }

    public final void c(@os.l jn.p<? super List<String>, ? super Type, ? extends Object> pVar) {
        kn.l0.p(pVar, "converter");
        if (this.f6577b == null) {
            this.f6577b = pVar;
            return;
        }
        throw new IllegalStateException("Decoder has already been set for type '" + this.f6576a + '\'');
    }

    public final void d(@os.l jn.l<Object, ? extends List<String>> lVar) {
        kn.l0.p(lVar, "converter");
        if (this.f6578c == null) {
            this.f6578c = lVar;
            return;
        }
        throw new IllegalStateException("Encoder has already been set for type '" + this.f6576a + '\'');
    }
}
