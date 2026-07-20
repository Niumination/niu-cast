package xm;

import kn.l0;
import kn.r1;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationImpl.kt\nkotlin/coroutines/jvm/internal/ContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
@f1(version = "1.3")
public abstract class d extends a {

    @os.m
    private final um.g _context;

    @os.m
    private transient um.d<Object> intercepted;

    public d(@os.m um.d<Object> dVar, @os.m um.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        um.g gVar = this._context;
        l0.m(gVar);
        return gVar;
    }

    @os.l
    public final um.d<Object> intercepted() {
        um.d<Object> dVarInterceptContinuation = this.intercepted;
        if (dVarInterceptContinuation == null) {
            um.e eVar = (um.e) getContext().get(um.e.G);
            if (eVar == null || (dVarInterceptContinuation = eVar.interceptContinuation(this)) == null) {
                dVarInterceptContinuation = this;
            }
            this.intercepted = dVarInterceptContinuation;
        }
        return dVarInterceptContinuation;
    }

    @Override // xm.a
    public void releaseIntercepted() {
        um.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            um.g.b bVar = getContext().get(um.e.G);
            l0.m(bVar);
            ((um.e) bVar).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = c.f20292a;
    }

    public d(@os.m um.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
