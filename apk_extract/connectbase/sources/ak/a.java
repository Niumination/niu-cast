package ak;

import ak.a;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@gm.c
public abstract class a<S extends a<S>> extends d<S> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public a(vj.f fVar, vj.e eVar) {
        super(fVar, eVar);
    }

    public static <T extends d<T>> T newStub(d.a<T> aVar, vj.f fVar) {
        return (T) newStub(aVar, fVar, vj.e.f17085l);
    }

    public static <T extends d<T>> T newStub(d.a<T> aVar, vj.f fVar, vj.e eVar) {
        return (T) aVar.newStub(fVar, eVar.x(g.f262c, g.EnumC0004g.ASYNC));
    }
}
