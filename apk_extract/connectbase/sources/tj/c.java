package tj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends d implements sj.n, h0 {
    private final c1 config;

    public c(sj.o oVar) {
        super(oVar);
        this.config = new c1(this);
    }

    public static d f(c cVar, p0 p0Var) {
        try {
            p0 p0Var2 = p0Var.f15727b;
            d dVarAttemptPeekWithPartialResolve = cVar.attemptPeekWithPartialResolve(p0Var.f15726a);
            if (p0Var2 == null) {
                return dVarAttemptPeekWithPartialResolve;
            }
            if (dVarAttemptPeekWithPartialResolve instanceof c) {
                return f((c) dVarAttemptPeekWithPartialResolve, p0Var2);
            }
            return null;
        } catch (sj.c.h e10) {
            throw m.v(p0Var, e10);
        }
    }

    private static UnsupportedOperationException g(String str) {
        return new UnsupportedOperationException(m.a.a("ConfigObject is immutable, you can't call Map.", str));
    }

    public static sj.o mergeOrigins(Collection<? extends d> collection) {
        if (collection.isEmpty()) {
            throw new sj.c.d("can't merge origins on empty list");
        }
        ArrayList arrayList = new ArrayList();
        g1 g1VarOrigin = null;
        int i10 = 0;
        for (sj.x xVar : collection) {
            if (g1VarOrigin == null) {
                g1VarOrigin = xVar.origin();
            }
            if (!(xVar instanceof c) || ((c) xVar).resolveStatus() != y0.RESOLVED || !((sj.n) xVar).isEmpty()) {
                arrayList.add(xVar.origin());
                i10++;
            }
        }
        if (i10 == 0) {
            arrayList.add(g1VarOrigin);
        }
        return g1.l(arrayList);
    }

    public abstract d attemptPeekWithPartialResolve(String str);

    @Override // java.util.Map
    public void clear() {
        throw g("clear");
    }

    @Override // tj.d
    public /* bridge */ /* synthetic */ d constructDelayedMerge(sj.o oVar, List list) {
        return constructDelayedMerge(oVar, (List<d>) list);
    }

    @Override // sj.n, java.util.Map
    public abstract sj.x get(Object obj);

    @Override // tj.d
    public abstract c mergedWithObject(c cVar);

    public abstract c newCopy(y0 y0Var, sj.o oVar);

    public final d peekAssumingResolved(String str, p0 p0Var) {
        try {
            return attemptPeekWithPartialResolve(str);
        } catch (sj.c.h e10) {
            throw m.v(p0Var, e10);
        }
    }

    public d peekPath(p0 p0Var) {
        return f(this, p0Var);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends sj.x> map) {
        throw g("putAll");
    }

    @Override // tj.d
    public abstract c relativized(p0 p0Var);

    @Override // tj.d
    public abstract void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar);

    @Override // tj.d
    public abstract w0<? extends c> resolveSubstitutions(u0 u0Var, x0 x0Var) throws d.c;

    @Override // sj.x
    public sj.z valueType() {
        return sj.z.OBJECT;
    }

    @Override // sj.n
    public abstract c withOnlyKey(String str);

    public abstract c withOnlyPath(p0 p0Var);

    public abstract c withOnlyPathOrNull(p0 p0Var);

    @Override // sj.n
    public abstract c withValue(String str, sj.x xVar);

    public abstract c withValue(p0 p0Var, sj.x xVar);

    @Override // sj.n
    public abstract c withoutKey(String str);

    public abstract c withoutPath(p0 p0Var);

    @Override // tj.d
    public c constructDelayedMerge(sj.o oVar, List<d> list) {
        return new j(oVar, list);
    }

    @Override // tj.d
    public c newCopy(sj.o oVar) {
        return newCopy(resolveStatus(), oVar);
    }

    @Override // java.util.Map
    public sj.x put(String str, sj.x xVar) {
        throw g("put");
    }

    @Override // java.util.Map
    public sj.x remove(Object obj) {
        throw g("remove");
    }

    @Override // sj.n
    public c1 toConfig() {
        return this.config;
    }

    @Override // tj.d, tj.m0
    public c toFallbackValue() {
        return this;
    }

    @Override // tj.d, sj.x
    public c withOrigin(sj.o oVar) {
        return (c) super.withOrigin(oVar);
    }

    @Override // tj.d, sj.x, sj.m
    public c withFallback(sj.m mVar) {
        return (c) super.withFallback(mVar);
    }

    public static sj.o mergeOrigins(c... cVarArr) {
        return mergeOrigins(Arrays.asList(cVarArr));
    }
}
