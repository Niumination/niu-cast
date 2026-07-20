package tj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d implements o1, h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f15622a;

    public h(sj.o oVar, List<d> list) {
        super(oVar);
        this.f15622a = list;
        if (list.size() < 2) {
            throw new sj.c.d("Created concatenation with less than 2 items: " + this);
        }
        boolean z10 = false;
        for (d dVar : list) {
            if (dVar instanceof h) {
                throw new sj.c.d("ConfigConcatenation should never be nested: " + this);
            }
            if (dVar instanceof o1) {
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        throw new sj.c.d("Created concatenation without an unmergeable in it: " + this);
    }

    public static d f(List<d> list) {
        List<d> listG = g(list);
        if (listG.isEmpty()) {
            return null;
        }
        return listG.size() == 1 ? listG.get(0) : new h(g1.m(listG), listG);
    }

    public static List<d> g(List<d> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList<d> arrayList = new ArrayList(list.size());
        for (d dVar : list) {
            if (dVar instanceof h) {
                arrayList.addAll(((h) dVar).f15622a);
            } else {
                arrayList.add(dVar);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (d dVar2 : arrayList) {
            if (arrayList2.isEmpty()) {
                arrayList2.add(dVar2);
            } else {
                j(arrayList2, dVar2);
            }
        }
        return arrayList2;
    }

    public static boolean i(d dVar) {
        return (dVar instanceof g0) && !((g0) dVar).wasQuoted();
    }

    public static void j(ArrayList<d> arrayList, d dVar) {
        d aVar = arrayList.get(arrayList.size() - 1);
        if ((aVar instanceof sj.n) && (dVar instanceof e1)) {
            aVar = i0.a(aVar, sj.z.LIST);
        } else if ((aVar instanceof e1) && (dVar instanceof sj.n)) {
            dVar = i0.a(dVar, sj.z.LIST);
        }
        boolean z10 = aVar instanceof sj.n;
        if (z10 && (dVar instanceof sj.n)) {
            aVar = dVar.withFallback((sj.m) aVar);
        } else {
            boolean z11 = aVar instanceof e1;
            if (z11 && (dVar instanceof e1)) {
                aVar = ((e1) aVar).concatenate((e1) dVar);
            } else if ((!z11 && !z10) || !i(dVar)) {
                if ((aVar instanceof h) || (dVar instanceof h)) {
                    throw new sj.c.d("unflattened ConfigConcatenation");
                }
                if ((aVar instanceof o1) || (dVar instanceof o1)) {
                    aVar = null;
                } else {
                    String strTransformToString = aVar.transformToString();
                    String strTransformToString2 = dVar.transformToString();
                    if (strTransformToString == null || strTransformToString2 == null) {
                        throw new sj.c.n(aVar.origin(), "Cannot concatenate object or list with a non-object-or-list, " + aVar + " and " + dVar + " are not compatible");
                    }
                    aVar = new g0.a(g1.p(aVar.origin(), dVar.origin()), strTransformToString.concat(strTransformToString2));
                }
            }
        }
        if (aVar == null) {
            arrayList.add(dVar);
        } else {
            arrayList.remove(arrayList.size() - 1);
            arrayList.add(aVar);
        }
    }

    @Override // tj.o1
    public Collection<h> a() {
        return Collections.singleton(this);
    }

    @Override // tj.d
    public boolean canEqual(Object obj) {
        return obj instanceof h;
    }

    @Override // tj.d
    public boolean equals(Object obj) {
        return (obj instanceof h) && (obj instanceof h) && this.f15622a.equals(((h) obj).f15622a);
    }

    @Override // tj.h0
    public boolean hasDescendant(d dVar) {
        return d.hasDescendantInList(this.f15622a, dVar);
    }

    @Override // tj.d
    public int hashCode() {
        return this.f15622a.hashCode();
    }

    @Override // tj.d
    public boolean ignoresFallbacks() {
        return false;
    }

    @Override // tj.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public h newCopy(sj.o oVar) {
        return new h(oVar, this.f15622a);
    }

    public final sj.c.h m() {
        return new sj.c.h("need to Config#resolve(), see the API docs for Config#resolve(); substitution not resolved: " + this);
    }

    @Override // tj.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public h relativized(p0 p0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<d> it = this.f15622a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().relativized(p0Var));
        }
        return new h(origin(), arrayList);
    }

    @Override // tj.h0
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public h replaceChild(d dVar, d dVar2) {
        List<d> listReplaceChildInList = d.replaceChildInList(this.f15622a, dVar, dVar2);
        if (listReplaceChildInList == null) {
            return null;
        }
        return new h(origin(), listReplaceChildInList);
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        Iterator<d> it = this.f15622a.iterator();
        while (it.hasNext()) {
            it.next().render(sb2, i10, z10, sVar);
        }
    }

    @Override // tj.d
    public y0 resolveStatus() {
        return y0.UNRESOLVED;
    }

    @Override // tj.d
    public w0<? extends d> resolveSubstitutions(u0 u0Var, x0 x0Var) throws d.c {
        if (m.N()) {
            int iB = u0Var.b();
            int i10 = iB + 2;
            m.K(iB + 1, "concatenation has " + this.f15622a.size() + " pieces:");
            Iterator<d> it = this.f15622a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                m.K(i10, i11 + ": " + it.next());
                i11++;
            }
        }
        ArrayList arrayList = new ArrayList(this.f15622a.size());
        u0 u0VarM = u0Var;
        for (d dVar : this.f15622a) {
            p0 p0Var = u0VarM.f15736c;
            w0<? extends d> w0VarL = u0VarM.m(null).l(dVar, x0Var);
            Object obj = w0VarL.f15745b;
            u0VarM = w0VarL.f15744a.m(p0Var);
            if (m.N()) {
                m.K(u0Var.b(), "resolved concat piece to " + obj);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        List<d> listG = g(arrayList);
        if (listG.size() > 1 && u0Var.f15735b.f15101b) {
            return new w0<>(u0VarM, new h(origin(), listG));
        }
        if (listG.isEmpty()) {
            return new w0<>(u0VarM, null);
        }
        if (listG.size() == 1) {
            return new w0<>(u0VarM, listG.get(0));
        }
        throw new sj.c.d("Bug in the library; resolved list was joined to too many values: " + listG);
    }

    @Override // sj.x
    public Object unwrapped() {
        throw m();
    }

    @Override // sj.x
    public sj.z valueType() {
        throw m();
    }
}
