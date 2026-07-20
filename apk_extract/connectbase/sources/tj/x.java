package tj;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends t {
    public x(Collection<a> collection) {
        super(collection);
    }

    @Override // tj.t
    public t d(Collection collection) {
        return new x(collection);
    }

    public x e(y yVar, b bVar, sj.v vVar) {
        p0 p0Var = yVar.f15754a;
        ArrayList arrayList = new ArrayList(this.f15733a);
        ArrayList arrayList2 = new ArrayList(h());
        b bVarC = (!(bVar instanceof t) || arrayList2.isEmpty()) ? bVar : ((t) bVar).c((a) arrayList2.get(arrayList2.size() - 1));
        boolean z10 = false;
        boolean z11 = (arrayList2.size() > 0 && (arrayList2.get(0) instanceof b0) && n1.l(((b0) arrayList2.get(0)).b())) ? false : true;
        if (p0Var.e() > 1) {
            for (int size = this.f15733a.size() - 1; size >= 0; size--) {
                if (this.f15733a.get(size) instanceof v) {
                    v vVar2 = (v) this.f15733a.get(size);
                    p0 p0Var2 = vVar2.c().f15754a;
                    if (p0Var.l(p0Var2) && (vVar2.f() instanceof x)) {
                        arrayList.set(size, vVar2.d(((x) vVar2.f()).e(yVar.c(p0Var2.e()), bVar, vVar)));
                        return new x(arrayList);
                    }
                }
            }
        }
        if (!this.f15733a.isEmpty() && (this.f15733a.get(0) instanceof b0) && ((b0) this.f15733a.get(0)).b() == n1.f15690f) {
            z10 = true;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList2);
        arrayList3.add(yVar.b());
        arrayList3.add(new b0(n1.v(null, " ")));
        arrayList3.add(new b0(n1.f15689e));
        arrayList3.add(new b0(new n1.b(null, " ")));
        if (p0Var.e() == 1) {
            arrayList3.add(bVarC);
        } else {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(new b0(n1.f15690f));
            if (arrayList2.isEmpty()) {
                arrayList4.add(new b0(new n1.c(null)));
            }
            arrayList4.addAll(arrayList2);
            arrayList4.add(new b0(n1.f15691g));
            arrayList3.add(new x(arrayList4).e(yVar.c(1), bVarC, vVar));
        }
        if (vVar == sj.v.JSON || z10 || z11) {
            int size2 = arrayList.size() - 1;
            while (size2 >= 0) {
                if ((vVar == sj.v.JSON || z11) && (arrayList.get(size2) instanceof v)) {
                    int i10 = size2 + 1;
                    if (i10 >= arrayList.size() || !(arrayList.get(i10) instanceof b0) || ((b0) arrayList.get(i10)).b() != n1.f15687c) {
                        arrayList.add(i10, new b0(n1.f15687c));
                        break;
                    }
                    break;
                }
                if (z10 && (arrayList.get(size2) instanceof b0) && ((b0) arrayList.get(size2)).f15573a == n1.f15691g) {
                    int i11 = size2 - 1;
                    a aVar = (a) arrayList.get(i11);
                    boolean z12 = aVar instanceof b0;
                    if (z12 && (((b0) aVar).b() instanceof n1.c)) {
                        arrayList.add(i11, new v(arrayList3));
                    } else if (z12 && (((b0) aVar).b() instanceof n1.b)) {
                        int i12 = size2 - 2;
                        a aVar2 = (a) arrayList.get(i12);
                        if (z11) {
                            arrayList.add(i11, new v(arrayList3));
                        } else if ((aVar2 instanceof b0) && (((b0) aVar2).b() instanceof n1.c)) {
                            arrayList.add(i12, new v(arrayList3));
                            size2 -= 2;
                        } else {
                            arrayList.add(size2, new v(arrayList3));
                        }
                    } else {
                        arrayList.add(size2, new v(arrayList3));
                    }
                    size2--;
                }
                size2--;
            }
        }
        if (!z10) {
            if (!arrayList.isEmpty() && (arrayList.get(arrayList.size() - 1) instanceof b0) && (((b0) arrayList.get(arrayList.size() - 1)).b() instanceof n1.c)) {
                arrayList.add(arrayList.size() - 1, new v(arrayList3));
            } else {
                arrayList.add(new v(arrayList3));
            }
        }
        return new x(arrayList);
    }

    public x f(p0 p0Var, b bVar, sj.v vVar) {
        ArrayList arrayList = new ArrayList(this.f15733a);
        boolean z10 = false;
        b bVar2 = bVar;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) instanceof b0) {
                k1 k1VarB = ((b0) arrayList.get(size)).b();
                if (vVar == sj.v.JSON && !z10 && k1VarB == n1.f15687c) {
                    arrayList.remove(size);
                }
            } else if (arrayList.get(size) instanceof v) {
                v vVar2 = (v) arrayList.get(size);
                p0 p0Var2 = vVar2.c().f15754a;
                if ((bVar2 == null && p0Var2.equals(p0Var)) || (p0Var2.l(p0Var) && !p0Var2.equals(p0Var))) {
                    arrayList.remove(size);
                    while (size < arrayList.size() && (arrayList.get(size) instanceof b0)) {
                        k1 k1VarB2 = ((b0) arrayList.get(size)).b();
                        if (!n1.k(k1VarB2) && k1VarB2 != n1.f15687c) {
                            break;
                        }
                        arrayList.remove(size);
                    }
                } else if (p0Var2.equals(p0Var)) {
                    int i10 = size - 1;
                    a aVar = i10 > 0 ? (a) arrayList.get(i10) : null;
                    arrayList.set(size, vVar2.d(((bVar instanceof t) && (aVar instanceof b0) && n1.k(((b0) aVar).b())) ? ((t) bVar).c(aVar) : bVar));
                    z10 = true;
                    bVar2 = null;
                } else {
                    if (p0Var.l(p0Var2) && (vVar2.f() instanceof x)) {
                        arrayList.set(size, vVar2.d(((x) vVar2.f()).f(p0Var.m(p0Var2.e()), bVar2, vVar)));
                        if (bVar2 != null && !vVar2.equals(this.f15733a.get(size))) {
                            bVar2 = null;
                        }
                    }
                    z10 = true;
                }
            }
        }
        return new x(arrayList);
    }

    public boolean g(p0 p0Var) {
        for (a aVar : this.f15733a) {
            if (aVar instanceof v) {
                v vVar = (v) aVar;
                p0 p0Var2 = vVar.c().f15754a;
                if (p0Var2.equals(p0Var) || p0Var2.l(p0Var) || (p0Var.l(p0Var2) && (vVar.f() instanceof x) && ((x) vVar.f()).g(p0Var.m(p0Var2.e())))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e3  */
    public final Collection<a> h() {
        String strE;
        int i10;
        ArrayList arrayList = new ArrayList();
        if (this.f15733a.isEmpty()) {
            return arrayList;
        }
        boolean z10 = false;
        for (int i11 = 0; i11 < this.f15733a.size(); i11++) {
            if (z10) {
                if ((this.f15733a.get(i11) instanceof b0) && n1.k(((b0) this.f15733a.get(i11)).b()) && (i10 = i11 + 1) < this.f15733a.size() && ((this.f15733a.get(i10) instanceof v) || (this.f15733a.get(i10) instanceof w))) {
                    arrayList.add(this.f15733a.get(i11));
                    return arrayList;
                }
            } else if ((this.f15733a.get(i11) instanceof b0) && n1.l(((b0) this.f15733a.get(i11)).b())) {
                arrayList.add(new b0(new n1.c(null)));
                z10 = true;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new b0(n1.v(null, " ")));
        } else {
            ArrayList<a> arrayList2 = this.f15733a;
            a aVar = arrayList2.get(arrayList2.size() - 1);
            if ((aVar instanceof b0) && ((b0) aVar).b() == n1.f15691g) {
                ArrayList<a> arrayList3 = this.f15733a;
                a aVar2 = arrayList3.get(arrayList3.size() - 2);
                if (aVar2 instanceof b0) {
                    b0 b0Var = (b0) aVar2;
                    if (b0Var.b() instanceof n1.b) {
                        strE = b0Var.b().e();
                    } else {
                        strE = "";
                    }
                } else {
                    strE = "";
                }
                arrayList.add(new b0(new n1.b(null, j.a.a(strE, "  "))));
            }
        }
        return arrayList;
    }

    public x i(Collection<a> collection) {
        return new x(collection);
    }

    public x j(String str, sj.v vVar) {
        return f(r0.i(str, vVar).f15754a, null, vVar);
    }

    public x k(String str, b bVar) {
        return l(str, bVar, sj.v.CONF);
    }

    public x l(String str, b bVar, sj.v vVar) {
        return m(r0.i(str, vVar), bVar, vVar);
    }

    public final x m(y yVar, b bVar, sj.v vVar) {
        x xVarF = f(yVar.f15754a, bVar, vVar);
        return !xVarF.g(yVar.f15754a) ? xVarF.e(yVar, bVar, vVar) : xVarF;
    }
}
