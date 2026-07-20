package jl;

import ik.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jq.j0;
import kn.l0;
import kn.l1;
import kn.m1;
import lm.y;
import nm.d0;
import nm.h0;
import nm.k0;
import nm.x;
import nm.z;
import os.l;
import os.m;
import un.g;
import un.s;
import un.u;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final e f8745a = new e();

    @Override // jl.a
    @l
    public List<String> a(@m Object obj) throws d {
        if (obj == null) {
            return k0.INSTANCE;
        }
        List<String> listC = b.c(obj);
        if (listC != null) {
            return listC;
        }
        if (obj instanceof Iterable) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                d0.r0(arrayList, f8745a.a(it.next()));
            }
            return arrayList;
        }
        un.d dVarD = l1.d(obj.getClass());
        Class cls = Integer.TYPE;
        m1 m1Var = l1.f9319a;
        if (l0.g(dVarD, m1Var.d(cls)) ? true : l0.g(dVarD, m1Var.d(Float.TYPE)) ? true : l0.g(dVarD, m1Var.d(Double.TYPE)) ? true : l0.g(dVarD, m1Var.d(Long.TYPE)) ? true : l0.g(dVarD, m1Var.d(Short.TYPE)) ? true : l0.g(dVarD, m1Var.d(Character.TYPE)) ? true : l0.g(dVarD, m1Var.d(Boolean.TYPE)) ? true : l0.g(dVarD, m1Var.d(String.class))) {
            return x.k(obj.toString());
        }
        throw new d("Class " + dVarD + " is not supported in default data conversion service");
    }

    @Override // jl.a
    @m
    public Object b(@l List<String> list, @l ol.b bVar) throws d {
        List<u> listN;
        u uVar;
        s sVar;
        l0.p(list, "values");
        l0.p(bVar, y0.a.f8215h);
        if (list.isEmpty()) {
            return null;
        }
        if (l0.g(bVar.getType(), l1.d(List.class))) {
            s sVarA = bVar.a();
            g gVarI = (sVarA == null || (listN = sVarA.n()) == null || (uVar = (u) h0.h5(listN)) == null || (sVar = uVar.f16349b) == null) ? null : sVar.i();
            un.d<?> dVar = gVarI instanceof un.d ? (un.d) gVarI : null;
            if (dVar != null) {
                List<String> list2 = list;
                ArrayList arrayList = new ArrayList(z.b0(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(f8745a.d((String) it.next(), dVar));
                }
                return arrayList;
            }
        }
        if (list.isEmpty()) {
            throw new d(l0.C("There are no values when trying to construct single value ", bVar));
        }
        if (list.size() <= 1) {
            return d((String) h0.h5(list), bVar.getType());
        }
        throw new d(l0.C("There are multiple values when trying to construct single value ", bVar));
    }

    public final Object c(un.d<?> dVar, String str) {
        if (l0.g(dVar, l1.d(Integer.TYPE))) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        Class cls = Float.TYPE;
        m1 m1Var = l1.f9319a;
        if (l0.g(dVar, m1Var.d(cls))) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (l0.g(dVar, m1Var.d(Double.TYPE))) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (l0.g(dVar, m1Var.d(Long.TYPE))) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (l0.g(dVar, m1Var.d(Short.TYPE))) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (l0.g(dVar, m1Var.d(Character.TYPE))) {
            return Character.valueOf(j0.F8(str));
        }
        if (l0.g(dVar, m1Var.d(Boolean.TYPE))) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (l0.g(dVar, m1Var.d(String.class))) {
            return str;
        }
        return null;
    }

    @l
    public final Object d(@l String str, @l un.d<?> dVar) throws d {
        l0.p(str, "value");
        l0.p(dVar, "klass");
        Object objC = c(dVar, str);
        if (objC != null) {
            return objC;
        }
        Object objB = b.b(str, dVar);
        if (objB != null) {
            return objB;
        }
        e(dVar.toString());
        throw new y();
    }

    public final Void e(String str) throws d {
        throw new d(n.a.a("Type ", str, " is not supported in default data conversion service"));
    }
}
