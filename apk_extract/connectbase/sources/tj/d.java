package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements sj.x, m0 {
    private final g1 origin;

    public interface a {
        d a(String str, d dVar) throws Exception;
    }

    public abstract class b implements a {
        public b() {
        }

        @Override // tj.d.a
        public final d a(String str, d dVar) throws Exception {
            try {
                return b(str, dVar);
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new sj.c.d("Unexpected exception", e11);
            }
        }

        public abstract d b(String str, d dVar);
    }

    public static class c extends Exception {
        private static final long serialVersionUID = 1;
        private final String traceString;

        public c(u0 u0Var) {
            super("was not possible to resolve");
            this.traceString = u0Var.o();
        }

        public String traceString() {
            return this.traceString;
        }
    }

    public d(sj.o oVar) {
        this.origin = (g1) oVar;
    }

    public static boolean hasDescendantInList(List<d> list, d dVar) {
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == dVar) {
                return true;
            }
        }
        for (sj.m mVar : list) {
            if ((mVar instanceof h0) && ((h0) mVar).hasDescendant(dVar)) {
                return true;
            }
        }
        return false;
    }

    public static void indent(StringBuilder sb2, int i10, sj.s sVar) {
        if (sVar.f15097c) {
            while (i10 > 0) {
                sb2.append("    ");
                i10--;
            }
        }
    }

    public static List<d> replaceChildInList(List<d> list, d dVar, d dVar2) {
        int i10 = 0;
        while (i10 < list.size() && list.get(i10) != dVar) {
            i10++;
        }
        if (i10 == list.size()) {
            throw new sj.c.d("tried to replace " + dVar + " which is not in " + list);
        }
        ArrayList arrayList = new ArrayList(list);
        if (dVar2 != null) {
            arrayList.set(i10, dVar2);
        } else {
            arrayList.remove(i10);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof sj.x;
    }

    public d constructDelayedMerge(sj.o oVar, List<d> list) {
        return new i(oVar, list);
    }

    public final d e(Collection<d> collection, d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        arrayList.add(dVar);
        return constructDelayedMerge(tj.c.mergeOrigins(arrayList), arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof sj.x) || !canEqual(obj)) {
            return false;
        }
        sj.x xVar = (sj.x) obj;
        return valueType() == xVar.valueType() && n.b(unwrapped(), xVar.unwrapped());
    }

    public int hashCode() {
        Object objUnwrapped = unwrapped();
        if (objUnwrapped == null) {
            return 0;
        }
        return objUnwrapped.hashCode();
    }

    public boolean ignoresFallbacks() {
        return resolveStatus() == y0.RESOLVED;
    }

    public final d mergedWithNonObject(Collection<d> collection, d dVar) {
        requireNotIgnoringFallbacks();
        return resolveStatus() == y0.RESOLVED ? withFallbacksIgnored() : e(collection, dVar);
    }

    public final d mergedWithObject(Collection<d> collection, tj.c cVar) {
        requireNotIgnoringFallbacks();
        if (this instanceof tj.c) {
            throw new sj.c.d("Objects must reimplement mergedWithObject");
        }
        return mergedWithNonObject(collection, cVar);
    }

    public final d mergedWithTheUnmergeable(Collection<d> collection, o1 o1Var) {
        requireNotIgnoringFallbacks();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        arrayList.addAll(o1Var.a());
        return constructDelayedMerge(tj.c.mergeOrigins(arrayList), arrayList);
    }

    public abstract d newCopy(sj.o oVar);

    public d relativized(p0 p0Var) {
        return this;
    }

    public void render(StringBuilder sb2, int i10, boolean z10, String str, sj.s sVar) {
        if (str != null) {
            sb2.append(sVar.f15098d ? n.i(str) : n.j(str));
            if (sVar.f15098d) {
                if (sVar.f15097c) {
                    sb2.append(" : ");
                } else {
                    sb2.append(":");
                }
            } else if (!(this instanceof sj.n)) {
                sb2.append("=");
            } else if (sVar.f15097c) {
                sb2.append(' ');
            }
        }
        render(sb2, i10, z10, sVar);
    }

    public final void requireNotIgnoringFallbacks() {
        if (ignoresFallbacks()) {
            throw new sj.c.d("method should not have been called with ignoresFallbacks=true ".concat(getClass().getSimpleName()));
        }
    }

    public y0 resolveStatus() {
        return y0.RESOLVED;
    }

    public w0<? extends d> resolveSubstitutions(u0 u0Var, x0 x0Var) throws c {
        return new w0<>(u0Var, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        render(sb2, 0, true, null, sj.s.a());
        return getClass().getSimpleName() + "(" + sb2.toString() + ")";
    }

    public String transformToString() {
        return null;
    }

    public d withFallbacksIgnored() {
        if (ignoresFallbacks()) {
            return this;
        }
        throw new sj.c.d("value class doesn't implement forced fallback-ignoring " + this);
    }

    public c1 atKey(sj.o oVar, String str) {
        return new f1(oVar, Collections.singletonMap(str, this)).toConfig();
    }

    public c1 atPath(sj.o oVar, p0 p0Var) {
        c1 c1VarAtKey = atKey(oVar, p0Var.d());
        for (p0 p0VarH = p0Var.h(); p0VarH != null; p0VarH = p0VarH.h()) {
            c1VarAtKey = c1VarAtKey.atKey(oVar, p0VarH.d());
        }
        return c1VarAtKey;
    }

    @Override // sj.x
    public g1 origin() {
        return this.origin;
    }

    @Override // tj.m0
    public d toFallbackValue() {
        return this;
    }

    @Override // sj.x
    public d withOrigin(sj.o oVar) {
        return this.origin == oVar ? this : newCopy(oVar);
    }

    @Override // sj.x, sj.m
    public d withFallback(sj.m mVar) {
        if (ignoresFallbacks()) {
            return this;
        }
        sj.x fallbackValue = ((m0) mVar).toFallbackValue();
        if (fallbackValue instanceof o1) {
            return mergedWithTheUnmergeable((o1) fallbackValue);
        }
        if (fallbackValue instanceof tj.c) {
            return mergedWithObject((tj.c) fallbackValue);
        }
        return mergedWithNonObject((d) fallbackValue);
    }

    @Override // sj.x
    public c1 atKey(String str) {
        return atKey(g1.t("atKey(" + str + ")"), str);
    }

    public d mergedWithNonObject(d dVar) {
        requireNotIgnoringFallbacks();
        return mergedWithNonObject(Collections.singletonList(this), dVar);
    }

    public d mergedWithObject(tj.c cVar) {
        requireNotIgnoringFallbacks();
        return mergedWithObject(Collections.singletonList(this), cVar);
    }

    public d mergedWithTheUnmergeable(o1 o1Var) {
        requireNotIgnoringFallbacks();
        return mergedWithTheUnmergeable(Collections.singletonList(this), o1Var);
    }

    @Override // sj.x
    public c1 atPath(String str) {
        return atPath(g1.t("atPath(" + str + ")"), r0.d(str));
    }

    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        sb2.append(unwrapped().toString());
    }

    @Override // sj.x
    public final String render() {
        return render(sj.s.b());
    }

    @Override // sj.x
    public final String render(sj.s sVar) {
        StringBuilder sb2 = new StringBuilder();
        render(sb2, 0, true, null, sVar);
        return sb2.toString();
    }
}
