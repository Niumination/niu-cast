package no;

import java.util.Map;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class c0<T> implements b0<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Map<dp.c, T> f11731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final up.f f11732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.h<dp.c, T> f11733d;

    public static final class a extends n0 implements jn.l<dp.c, T> {
        final /* synthetic */ c0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c0<T> c0Var) {
            super(1);
            this.this$0 = c0Var;
        }

        @Override // jn.l
        @os.m
        public final T invoke(dp.c cVar) {
            l0.o(cVar, "it");
            return (T) dp.e.a(cVar, this.this$0.f11731b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(@os.l Map<dp.c, ? extends T> map) {
        l0.p(map, "states");
        this.f11731b = map;
        up.f fVar = new up.f("Java nullability annotation states", (Runnable) null, (jn.l<InterruptedException, l2>) null);
        this.f11732c = fVar;
        up.h<dp.c, T> hVarF = fVar.f(new a(this));
        l0.o(hVarF, "storageManager.createMem…cificFqname(states)\n    }");
        this.f11733d = hVarF;
    }

    @Override // no.b0
    @os.m
    public T a(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return this.f11733d.invoke(cVar);
    }

    @os.l
    public final Map<dp.c, T> b() {
        return this.f11731b;
    }
}
