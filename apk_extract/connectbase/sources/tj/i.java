package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends d implements o1, t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f15625a;

    public i(sj.o oVar, List<d> list) {
        super(oVar);
        this.f15625a = list;
        if (list.isEmpty()) {
            throw new sj.c.d("creating empty delayed merge value");
        }
        for (d dVar : list) {
            if ((dVar instanceof i) || (dVar instanceof j)) {
                throw new sj.c.d("placed nested DelayedMerge in a ConfigDelayedMerge, should have consolidated stack");
            }
        }
    }

    public static d f(u0 u0Var, List<d> list, int i10) {
        List<d> listSubList = list.subList(i10, list.size());
        d dVar = null;
        if (listSubList.isEmpty()) {
            if (m.N()) {
                m.K(u0Var.b(), "Nothing else in the merge stack, replacing with null");
            }
            return null;
        }
        for (d dVarWithFallback : listSubList) {
            if (dVar != null) {
                dVarWithFallback = dVar.withFallback((sj.m) dVarWithFallback);
            }
            dVar = dVarWithFallback;
        }
        return dVar;
    }

    public static void m(List<d> list, StringBuilder sb2, int i10, boolean z10, String str, sj.s sVar) {
        boolean z11 = sVar.f15096b;
        if (z11) {
            sb2.append("# unresolved merge of " + list.size() + " values follows (\n");
            if (str == null) {
                d.indent(sb2, i10, sVar);
                sb2.append("# this unresolved merge will not be parseable because it's at the root of the object\n");
                d.indent(sb2, i10, sVar);
                sb2.append("# the HOCON format has no way to list multiple root objects in a single file\n");
            }
        }
        ArrayList<d> arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.reverse(arrayList);
        int i11 = 0;
        for (d dVar : arrayList) {
            if (z11) {
                d.indent(sb2, i10, sVar);
                if (str != null) {
                    StringBuilder sbA = h.b.a("#     unmerged value ", i11, " for key ");
                    sbA.append(n.i(str));
                    sbA.append(" from ");
                    sb2.append(sbA.toString());
                } else {
                    sb2.append("#     unmerged value " + i11 + " from ");
                }
                i11++;
                sb2.append(dVar.origin().description());
                sb2.append("\n");
                for (String str2 : dVar.origin().comments()) {
                    d.indent(sb2, i10, sVar);
                    sb2.append("# ");
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }
            d.indent(sb2, i10, sVar);
            if (str != null) {
                sb2.append(n.i(str));
                if (sVar.f15097c) {
                    sb2.append(" : ");
                } else {
                    sb2.append(":");
                }
            }
            dVar.render(sb2, i10, z10, sVar);
            sb2.append(ks.g.f9491d);
            if (sVar.f15097c) {
                sb2.append('\n');
            }
        }
        sb2.setLength(sb2.length() - 1);
        if (sVar.f15097c) {
            sb2.setLength(sb2.length() - 1);
            sb2.append("\n");
        }
        if (z11) {
            d.indent(sb2, i10, sVar);
            sb2.append("# ) end of unresolved merge\n");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static w0<? extends d> q(t0 t0Var, List<d> list, u0 u0Var, x0 x0Var) throws d.c {
        x0 x0VarE;
        if (m.N()) {
            m.K(u0Var.b(), "delayed merge stack has " + list.size() + " items:");
            int i10 = 0;
            for (d dVar : list) {
                m.K(u0Var.b() + 1, i10 + ": " + dVar);
                i10++;
            }
        }
        d dVarWithFallback = null;
        u0 u0Var2 = u0Var;
        int i11 = 0;
        for (d dVar2 : list) {
            if (dVar2 instanceof t0) {
                throw new sj.c.d("A delayed merge should not contain another one: " + t0Var);
            }
            if (dVar2 instanceof o1) {
                d dVarC = t0Var.c(u0Var, i11 + 1);
                if (m.N()) {
                    m.K(u0Var2.b(), "remainder portion: " + dVarC);
                }
                if (m.N()) {
                    m.K(u0Var2.b(), "building sourceForEnd");
                }
                x0 x0VarH = x0Var.h((d) t0Var, dVarC);
                if (m.N()) {
                    m.K(u0Var2.b(), "  sourceForEnd before reset parents but after replace: " + x0VarH);
                }
                x0VarE = x0VarH.i();
            } else {
                if (m.N()) {
                    m.K(u0Var2.b(), "will resolve end against the original source with parent pushed");
                }
                x0VarE = x0Var.e(t0Var);
            }
            if (m.N()) {
                m.K(u0Var2.b(), "sourceForEnd      =" + x0VarE);
            }
            if (m.N()) {
                int iB = u0Var2.b();
                StringBuilder sb2 = new StringBuilder("Resolving highest-priority item in delayed merge ");
                sb2.append(dVar2);
                sb2.append(" against ");
                sb2.append(x0VarE);
                sb2.append(" endWasRemoved=");
                sb2.append(x0Var != x0VarE);
                m.K(iB, sb2.toString());
            }
            w0<? extends d> w0VarL = u0Var2.l(dVar2, x0VarE);
            sj.m mVar = w0VarL.f15745b;
            u0Var2 = w0VarL.f15744a;
            if (mVar != null) {
                if (dVarWithFallback == null) {
                    dVarWithFallback = mVar;
                } else {
                    if (m.N()) {
                        m.K(u0Var2.b() + 1, "merging " + dVarWithFallback + " with fallback " + mVar);
                    }
                    dVarWithFallback = dVarWithFallback.withFallback(mVar);
                }
            }
            i11++;
            if (m.N()) {
                m.K(u0Var2.b(), "stack merged, yielding: " + dVarWithFallback);
            }
        }
        return new w0<>(u0Var2, dVarWithFallback);
    }

    public static boolean r(List<d> list) {
        return list.get(list.size() - 1).ignoresFallbacks();
    }

    @Override // tj.o1
    public Collection<d> a() {
        return this.f15625a;
    }

    @Override // tj.t0
    public d c(u0 u0Var, int i10) {
        return f(u0Var, this.f15625a, i10);
    }

    @Override // tj.d
    public boolean canEqual(Object obj) {
        return obj instanceof i;
    }

    @Override // tj.d
    public boolean equals(Object obj) {
        if (!(obj instanceof i) || !(obj instanceof i)) {
            return false;
        }
        List<d> list = this.f15625a;
        List<d> list2 = ((i) obj).f15625a;
        return list == list2 || list.equals(list2);
    }

    @Override // tj.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public i mergedWithNonObject(d dVar) {
        return (i) mergedWithNonObject(this.f15625a, dVar);
    }

    @Override // tj.h0
    public boolean hasDescendant(d dVar) {
        return d.hasDescendantInList(this.f15625a, dVar);
    }

    @Override // tj.d
    public int hashCode() {
        return this.f15625a.hashCode();
    }

    @Override // tj.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final i mergedWithObject(c cVar) {
        return (i) mergedWithObject(this.f15625a, cVar);
    }

    @Override // tj.d
    public boolean ignoresFallbacks() {
        return r(this.f15625a);
    }

    @Override // tj.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final i mergedWithTheUnmergeable(o1 o1Var) {
        return (i) mergedWithTheUnmergeable(this.f15625a, o1Var);
    }

    @Override // tj.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public i relativized(p0 p0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<d> it = this.f15625a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().relativized(p0Var));
        }
        return new i(origin(), arrayList);
    }

    @Override // tj.d
    public d newCopy(sj.o oVar) {
        return new i(oVar, this.f15625a);
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, String str, sj.s sVar) {
        m(this.f15625a, sb2, i10, z10, str, sVar);
    }

    @Override // tj.h0
    public d replaceChild(d dVar, d dVar2) {
        List<d> listReplaceChildInList = d.replaceChildInList(this.f15625a, dVar, dVar2);
        if (listReplaceChildInList == null) {
            return null;
        }
        return new i(origin(), listReplaceChildInList);
    }

    @Override // tj.d
    public y0 resolveStatus() {
        return y0.UNRESOLVED;
    }

    @Override // tj.d
    public w0<? extends d> resolveSubstitutions(u0 u0Var, x0 x0Var) throws d.c {
        return q(this, this.f15625a, u0Var, x0Var);
    }

    @Override // sj.x
    public Object unwrapped() {
        throw new sj.c.h("called unwrapped() on value with unresolved substitutions, need to Config#resolve() first, see API docs");
    }

    @Override // sj.x
    public sj.z valueType() {
        throw new sj.c.h("called valueType() on value with unresolved substitutions, need to Config#resolve() first, see API docs");
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        render(sb2, i10, z10, null, sVar);
    }
}
