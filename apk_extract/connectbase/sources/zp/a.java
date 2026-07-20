package zp;

import eo.d1;
import eo.e;
import eo.e1;
import eo.f;
import eo.h;
import eo.i;
import fo.g;
import ik.y0;
import in.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jn.l;
import kn.l0;
import kn.n0;
import lm.i0;
import nm.s0;
import os.m;
import vp.a1;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.g1;
import vp.h0;
import vp.h1;
import vp.j1;
import vp.l1;
import vp.n1;
import vp.o1;
import vp.u0;
import vp.z;
import yp.v;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: zp.a$a, reason: collision with other inner class name */
    public static final class C0611a extends n0 implements l<n1, Boolean> {
        public static final C0611a INSTANCE = new C0611a();

        public C0611a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l n1 n1Var) {
            l0.p(n1Var, "it");
            h hVarD = n1Var.G0().d();
            return Boolean.valueOf(hVarD == null ? false : a.n(hVarD));
        }
    }

    public static final class b extends n0 implements l<n1, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l n1 n1Var) {
            l0.p(n1Var, "it");
            h hVarD = n1Var.G0().d();
            boolean z10 = false;
            if (hVarD != null && ((hVarD instanceof d1) || (hVarD instanceof e1))) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class c extends n0 implements l<n1, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l n1 n1Var) {
            l0.p(n1Var, "it");
            return Boolean.valueOf((n1Var instanceof u0) || (n1Var.G0() instanceof v) || h0.a(n1Var));
        }
    }

    @os.l
    public static final c1 a(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return new vp.e1(f0Var);
    }

    public static final boolean b(@os.l f0 f0Var, @os.l l<? super n1, Boolean> lVar) {
        l0.p(f0Var, "<this>");
        l0.p(lVar, "predicate");
        return j1.c(f0Var, lVar);
    }

    public static final boolean c(f0 f0Var, a1 a1Var, Set<? extends e1> set) {
        boolean zC;
        if (l0.g(f0Var.G0(), a1Var)) {
            return true;
        }
        h hVarD = f0Var.G0().d();
        i iVar = hVarD instanceof i ? (i) hVarD : null;
        List<e1> listR = iVar == null ? null : iVar.r();
        Iterable<s0> iterableH6 = nm.h0.h6(f0Var.F0());
        if (!(iterableH6 instanceof Collection) || !((Collection) iterableH6).isEmpty()) {
            for (s0 s0Var : iterableH6) {
                int i10 = s0Var.f11691a;
                c1 c1Var = (c1) s0Var.f11692b;
                e1 e1Var = listR == null ? null : (e1) nm.h0.W2(listR, i10);
                if ((e1Var == null || set == null || !set.contains(e1Var)) && !c1Var.a()) {
                    f0 type = c1Var.getType();
                    l0.o(type, "argument.type");
                    zC = c(type, a1Var, set);
                } else {
                    zC = false;
                }
                if (zC) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean d(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return b(f0Var, C0611a.INSTANCE);
    }

    @os.l
    public static final c1 e(@os.l f0 f0Var, @os.l o1 o1Var, @m e1 e1Var) {
        l0.p(f0Var, y0.a.f8215h);
        l0.p(o1Var, "projectionKind");
        if ((e1Var == null ? null : e1Var.m()) == o1Var) {
            o1Var = o1.INVARIANT;
        }
        return new vp.e1(o1Var, f0Var);
    }

    @os.l
    public static final Set<e1> f(@os.l f0 f0Var, @m Set<? extends e1> set) {
        l0.p(f0Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        g(f0Var, f0Var, linkedHashSet, set);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(f0 f0Var, f0 f0Var2, Set<e1> set, Set<? extends e1> set2) {
        h hVarD = f0Var.G0().d();
        if (hVarD instanceof e1) {
            if (!l0.g(f0Var.G0(), f0Var2.G0())) {
                set.add(hVarD);
                return;
            }
            for (f0 f0Var3 : ((e1) hVarD).getUpperBounds()) {
                l0.o(f0Var3, "upperBound");
                g(f0Var3, f0Var2, set, set2);
            }
            return;
        }
        h hVarD2 = f0Var.G0().d();
        i iVar = hVarD2 instanceof i ? (i) hVarD2 : null;
        List<e1> listR = iVar == null ? null : iVar.r();
        int i10 = 0;
        for (c1 c1Var : f0Var.F0()) {
            int i11 = i10 + 1;
            e1 e1Var = listR == null ? null : (e1) nm.h0.W2(listR, i10);
            if ((e1Var == null || set2 == null || !set2.contains(e1Var)) && !c1Var.a() && !nm.h0.W1(set, c1Var.getType().G0().d()) && !l0.g(c1Var.getType().G0(), f0Var2.G0())) {
                f0 type = c1Var.getType();
                l0.o(type, "argument.type");
                g(type, f0Var2, set, set2);
            }
            i10 = i11;
        }
    }

    @os.l
    public static final ao.h h(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        ao.h hVarN = f0Var.G0().n();
        l0.o(hVarN, "constructor.builtIns");
        return hVarN;
    }

    @os.l
    public static final f0 i(@os.l e1 e1Var) {
        Object obj;
        l0.p(e1Var, "<this>");
        List<f0> upperBounds = e1Var.getUpperBounds();
        l0.o(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<f0> upperBounds2 = e1Var.getUpperBounds();
        l0.o(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            h hVarD = ((f0) next).G0().d();
            e eVar = hVarD instanceof e ? (e) hVarD : null;
            if (eVar != null && eVar.getKind() != f.INTERFACE && eVar.getKind() != f.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        f0 f0Var = (f0) obj;
        if (f0Var != null) {
            return f0Var;
        }
        List<f0> upperBounds3 = e1Var.getUpperBounds();
        l0.o(upperBounds3, "upperBounds");
        Object objB2 = nm.h0.B2(upperBounds3);
        l0.o(objB2, "upperBounds.first()");
        return (f0) objB2;
    }

    @j
    public static final boolean j(@os.l e1 e1Var) {
        l0.p(e1Var, "typeParameter");
        return l(e1Var, null, null, 6, null);
    }

    @j
    public static final boolean k(@os.l e1 e1Var, @m a1 a1Var, @m Set<? extends e1> set) {
        l0.p(e1Var, "typeParameter");
        List<f0> upperBounds = e1Var.getUpperBounds();
        l0.o(upperBounds, "typeParameter.upperBounds");
        List<f0> list = upperBounds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (f0 f0Var : list) {
            l0.o(f0Var, "upperBound");
            if (c(f0Var, e1Var.q().G0(), set) && (a1Var == null || l0.g(f0Var.G0(), a1Var))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean l(e1 e1Var, a1 a1Var, Set set, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            a1Var = null;
        }
        if ((i10 & 4) != 0) {
            set = null;
        }
        return k(e1Var, a1Var, set);
    }

    public static final boolean m(@os.l f0 f0Var, @os.l f0 f0Var2) {
        l0.p(f0Var, "<this>");
        l0.p(f0Var2, "superType");
        return wp.e.f19851a.c(f0Var, f0Var2);
    }

    public static final boolean n(@os.l h hVar) {
        l0.p(hVar, "<this>");
        return (hVar instanceof e1) && (((e1) hVar).b() instanceof d1);
    }

    public static final boolean o(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return j1.n(f0Var);
    }

    @os.l
    public static final f0 p(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        f0 f0VarO = j1.o(f0Var);
        l0.o(f0VarO, "makeNotNullable(this)");
        return f0VarO;
    }

    @os.l
    public static final f0 q(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        f0 f0VarP = j1.p(f0Var);
        l0.o(f0VarP, "makeNullable(this)");
        return f0VarP;
    }

    @os.l
    public static final f0 r(@os.l f0 f0Var, @os.l g gVar) {
        l0.p(f0Var, "<this>");
        l0.p(gVar, "newAnnotations");
        return (f0Var.getAnnotations().isEmpty() && gVar.isEmpty()) ? f0Var : f0Var.J0().O0(gVar);
    }

    @os.l
    public static final f0 s(@os.l f0 f0Var, @os.l h1 h1Var, @os.l Map<a1, ? extends c1> map, @os.l o1 o1Var, @m Set<? extends e1> set) {
        n1 n1VarF;
        l0.p(f0Var, "<this>");
        l0.p(h1Var, "substitutor");
        l0.p(map, "substitutionMap");
        l0.p(o1Var, "variance");
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof z) {
            z zVar = (z) n1VarJ0;
            vp.n0 n0VarF = zVar.f17773b;
            if (!n0VarF.G0().getParameters().isEmpty() && n0VarF.G0().d() != null) {
                List<e1> parameters = n0VarF.G0().getParameters();
                l0.o(parameters, "constructor.parameters");
                List<e1> list = parameters;
                ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
                for (e1 e1Var : list) {
                    c1 s0Var = (c1) nm.h0.W2(f0Var.F0(), e1Var.f());
                    if ((set != null && set.contains(e1Var)) || s0Var == null || !map.containsKey(s0Var.getType().G0())) {
                        s0Var = new vp.s0(e1Var);
                    }
                    arrayList.add(s0Var);
                }
                n0VarF = g1.f(n0VarF, arrayList, null, 2, null);
            }
            vp.n0 n0VarF2 = zVar.f17774c;
            if (!n0VarF2.G0().getParameters().isEmpty() && n0VarF2.G0().d() != null) {
                List<e1> parameters2 = n0VarF2.G0().getParameters();
                l0.o(parameters2, "constructor.parameters");
                List<e1> list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(nm.z.b0(list2, 10));
                for (e1 e1Var2 : list2) {
                    c1 s0Var2 = (c1) nm.h0.W2(f0Var.F0(), e1Var2.f());
                    if ((set != null && set.contains(e1Var2)) || s0Var2 == null || !map.containsKey(s0Var2.getType().G0())) {
                        s0Var2 = new vp.s0(e1Var2);
                    }
                    arrayList2.add(s0Var2);
                }
                n0VarF2 = g1.f(n0VarF2, arrayList2, null, 2, null);
            }
            n1VarF = g0.d(n0VarF, n0VarF2);
        } else {
            if (!(n1VarJ0 instanceof vp.n0)) {
                throw new i0();
            }
            vp.n0 n0Var = (vp.n0) n1VarJ0;
            if (n0Var.G0().getParameters().isEmpty() || n0Var.G0().d() == null) {
                n1VarF = n0Var;
            } else {
                List<e1> parameters3 = n0Var.G0().getParameters();
                l0.o(parameters3, "constructor.parameters");
                List<e1> list3 = parameters3;
                ArrayList arrayList3 = new ArrayList(nm.z.b0(list3, 10));
                for (e1 e1Var3 : list3) {
                    c1 s0Var3 = (c1) nm.h0.W2(f0Var.F0(), e1Var3.f());
                    if ((set != null && set.contains(e1Var3)) || s0Var3 == null || !map.containsKey(s0Var3.getType().G0())) {
                        s0Var3 = new vp.s0(e1Var3);
                    }
                    arrayList3.add(s0Var3);
                }
                n1VarF = g1.f(n0Var, arrayList3, null, 2, null);
            }
        }
        f0 f0VarN = h1Var.n(l1.b(n1VarF, n1VarJ0), o1Var);
        l0.o(f0VarN, "replaceArgumentsByParame…ubstitute(it, variance) }");
        return f0VarN;
    }

    @os.l
    public static final f0 t(@os.l f0 f0Var) {
        vp.n0 n0Var;
        n1 n1VarF;
        l0.p(f0Var, "<this>");
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof z) {
            z zVar = (z) n1VarJ0;
            vp.n0 n0VarF = zVar.f17773b;
            if (!n0VarF.G0().getParameters().isEmpty() && n0VarF.G0().d() != null) {
                List<e1> parameters = n0VarF.G0().getParameters();
                l0.o(parameters, "constructor.parameters");
                List<e1> list = parameters;
                ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new vp.s0((e1) it.next()));
                }
                n0VarF = g1.f(n0VarF, arrayList, null, 2, null);
            }
            vp.n0 n0VarF2 = zVar.f17774c;
            if (!n0VarF2.G0().getParameters().isEmpty() && n0VarF2.G0().d() != null) {
                List<e1> parameters2 = n0VarF2.G0().getParameters();
                l0.o(parameters2, "constructor.parameters");
                List<e1> list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(nm.z.b0(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new vp.s0((e1) it2.next()));
                }
                n0VarF2 = g1.f(n0VarF2, arrayList2, null, 2, null);
            }
            n1VarF = g0.d(n0VarF, n0VarF2);
        } else {
            if (!(n1VarJ0 instanceof vp.n0)) {
                throw new i0();
            }
            n0Var = (vp.n0) n1VarJ0;
            if (!n0Var.G0().getParameters().isEmpty() && n0Var.G0().d() != null) {
                n1VarF = n0Var;
                n1VarF = n0Var;
                List<e1> parameters3 = n0Var.G0().getParameters();
                l0.o(parameters3, "constructor.parameters");
                List<e1> list3 = parameters3;
                ArrayList arrayList3 = new ArrayList(nm.z.b0(list3, 10));
                Iterator<T> it3 = list3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new vp.s0((e1) it3.next()));
                }
                n1VarF = g1.f(n0Var, arrayList3, null, 2, null);
            }
        }
        n1VarF = n0Var;
        n1VarF = n0Var;
        n1VarF = n0Var;
        return l1.b(n1VarF, n1VarJ0);
    }

    public static final boolean u(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return b(f0Var, b.INSTANCE);
    }

    public static final boolean v(@m f0 f0Var) {
        return f0Var == null || b(f0Var, c.INSTANCE);
    }
}
