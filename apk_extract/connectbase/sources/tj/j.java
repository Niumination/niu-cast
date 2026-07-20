package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends c implements o1, t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f15630a;

    public j(sj.o oVar, List<d> list) {
        super(oVar);
        this.f15630a = list;
        if (list.isEmpty()) {
            throw new sj.c.d("creating empty delayed merge object");
        }
        if (!(list.get(0) instanceof c)) {
            throw new sj.c.d("created a delayed merge object not guaranteed to be an object");
        }
        for (d dVar : list) {
            if ((dVar instanceof i) || (dVar instanceof j)) {
                throw new sj.c.d("placed nested DelayedMerge in a ConfigDelayedMergeObject, should have consolidated stack");
            }
        }
    }

    public static sj.c q() {
        return new sj.c.h("need to Config#resolve() before using this object, see the API docs for Config#resolve()");
    }

    @Override // tj.o1
    public Collection<d> a() {
        return this.f15630a;
    }

    @Override // tj.c
    public d attemptPeekWithPartialResolve(String str) {
        for (d dVar : this.f15630a) {
            if (!(dVar instanceof c)) {
                if (dVar instanceof o1) {
                    StringBuilder sbA = e.a.a("Key '", str, "' is not available at '");
                    sbA.append(origin().description());
                    sbA.append("' because value at '");
                    sbA.append(dVar.origin().description());
                    sbA.append("' has not been resolved and may turn out to contain or hide '");
                    throw new sj.c.h(j.c.a(sbA, str, "'. Be sure to Config#resolve() before using a config object."));
                }
                if (dVar.resolveStatus() != y0.UNRESOLVED) {
                    if (dVar.ignoresFallbacks()) {
                        return null;
                    }
                    throw new sj.c.d("resolved non-object should ignore fallbacks");
                }
                if (dVar instanceof sj.j) {
                    return null;
                }
                throw new sj.c.d("Expecting a list here, not " + dVar);
            }
            d dVarAttemptPeekWithPartialResolve = ((c) dVar).attemptPeekWithPartialResolve(str);
            if (dVarAttemptPeekWithPartialResolve != null) {
                if (dVarAttemptPeekWithPartialResolve.ignoresFallbacks()) {
                    return dVarAttemptPeekWithPartialResolve;
                }
            } else if (dVar instanceof o1) {
                throw new sj.c.d("should not be reached: unmergeable object returned null value");
            }
        }
        throw new sj.c.d("Delayed merge stack does not contain any unmergeable values");
    }

    @Override // tj.t0
    public d c(u0 u0Var, int i10) {
        return i.f(u0Var, this.f15630a, i10);
    }

    @Override // tj.d
    public boolean canEqual(Object obj) {
        return obj instanceof j;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        throw q();
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        throw q();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, sj.x>> entrySet() {
        throw q();
    }

    @Override // tj.d
    public boolean equals(Object obj) {
        if (!(obj instanceof j) || !(obj instanceof j)) {
            return false;
        }
        List<d> list = this.f15630a;
        List<d> list2 = ((j) obj).f15630a;
        return list == list2 || list.equals(list2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tj.c, sj.n, java.util.Map
    public sj.x get(Object obj) {
        throw q();
    }

    @Override // tj.h0
    public boolean hasDescendant(d dVar) {
        return d.hasDescendantInList(this.f15630a, dVar);
    }

    @Override // tj.d
    public int hashCode() {
        return this.f15630a.hashCode();
    }

    @Override // tj.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final j mergedWithNonObject(d dVar) {
        requireNotIgnoringFallbacks();
        return (j) mergedWithNonObject(this.f15630a, dVar);
    }

    @Override // tj.d
    public boolean ignoresFallbacks() {
        return i.r(this.f15630a);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        throw q();
    }

    public final j j(c cVar) {
        return mergedWithNonObject(cVar);
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        throw q();
    }

    @Override // tj.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final j mergedWithTheUnmergeable(o1 o1Var) {
        requireNotIgnoringFallbacks();
        return (j) mergedWithTheUnmergeable(this.f15630a, o1Var);
    }

    @Override // tj.c
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public j newCopy(y0 y0Var, sj.o oVar) {
        if (y0Var == y0.UNRESOLVED) {
            return new j(oVar, this.f15630a);
        }
        throw new sj.c.d("attempt to create resolved ConfigDelayedMergeObject");
    }

    @Override // tj.c, tj.d
    public c mergedWithObject(c cVar) {
        return mergedWithNonObject(cVar);
    }

    @Override // tj.c, tj.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public j relativized(p0 p0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<d> it = this.f15630a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().relativized(p0Var));
        }
        return new j(origin(), arrayList);
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, String str, sj.s sVar) {
        i.m(this.f15630a, sb2, i10, z10, str, sVar);
    }

    @Override // tj.h0
    public d replaceChild(d dVar, d dVar2) {
        List<d> listReplaceChildInList = d.replaceChildInList(this.f15630a, dVar, dVar2);
        if (listReplaceChildInList == null) {
            return null;
        }
        return new j(origin(), listReplaceChildInList);
    }

    @Override // tj.d
    public y0 resolveStatus() {
        return y0.UNRESOLVED;
    }

    @Override // tj.c, tj.d
    public w0<? extends c> resolveSubstitutions(u0 u0Var, x0 x0Var) throws d.c {
        return i.q(this, this.f15630a, u0Var, x0Var).a();
    }

    public j s(sj.m mVar) {
        return (j) super.withFallback(mVar);
    }

    @Override // java.util.Map
    public int size() {
        throw q();
    }

    public j t(String str) {
        throw q();
    }

    public j u(String str, sj.x xVar) {
        throw q();
    }

    @Override // sj.x
    public Object unwrapped() {
        throw q();
    }

    public j v(p0 p0Var, sj.x xVar) {
        throw q();
    }

    @Override // java.util.Map
    public Collection<sj.x> values() {
        throw q();
    }

    public j w(String str) {
        throw q();
    }

    @Override // tj.c, tj.d, sj.x, sj.m
    public sj.m withFallback(sj.m mVar) {
        return (j) super.withFallback(mVar);
    }

    @Override // tj.c, sj.n
    public sj.n withOnlyKey(String str) {
        throw q();
    }

    @Override // tj.c
    public c withOnlyPath(p0 p0Var) {
        throw q();
    }

    @Override // tj.c
    public c withOnlyPathOrNull(p0 p0Var) {
        throw q();
    }

    @Override // tj.c, sj.n
    public sj.n withValue(String str, sj.x xVar) {
        throw q();
    }

    @Override // tj.c, sj.n
    public sj.n withoutKey(String str) {
        throw q();
    }

    @Override // tj.c
    public c withoutPath(p0 p0Var) {
        throw q();
    }

    @Override // tj.c, sj.n, java.util.Map
    public sj.x get(Object obj) {
        throw q();
    }

    @Override // tj.c, tj.d
    public d mergedWithObject(c cVar) {
        return mergedWithNonObject(cVar);
    }

    @Override // tj.c, tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        render(sb2, i10, z10, null, sVar);
    }

    @Override // sj.x
    public Map<String, Object> unwrapped() {
        throw q();
    }

    @Override // tj.c, tj.d, sj.x, sj.m
    public sj.n withFallback(sj.m mVar) {
        return (j) super.withFallback(mVar);
    }

    @Override // tj.c, sj.n
    public c withOnlyKey(String str) {
        throw q();
    }

    @Override // tj.c, sj.n
    public c withValue(String str, sj.x xVar) {
        throw q();
    }

    @Override // tj.c, sj.n
    public c withoutKey(String str) {
        throw q();
    }

    @Override // tj.c, sj.n, java.util.Map
    public sj.x get(Object obj) {
        throw q();
    }

    @Override // tj.c, tj.d, sj.x, sj.m
    public sj.x withFallback(sj.m mVar) {
        return (j) super.withFallback(mVar);
    }

    @Override // tj.c
    public c withValue(p0 p0Var, sj.x xVar) {
        throw q();
    }

    @Override // tj.c, tj.d, sj.x, sj.m
    public c withFallback(sj.m mVar) {
        return (j) super.withFallback(mVar);
    }

    @Override // tj.c, tj.d, sj.x, sj.m
    public d withFallback(sj.m mVar) {
        return (j) super.withFallback(mVar);
    }
}
