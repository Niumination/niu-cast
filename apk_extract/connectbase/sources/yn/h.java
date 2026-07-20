package yn;

import eo.h1;
import eo.j1;
import eo.t0;
import eo.w0;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import os.l;
import os.m;
import vp.f0;
import xn.h0;
import xn.y;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    @m
    public static final Object a(@m Object obj, @l eo.b bVar) {
        l0.p(bVar, "descriptor");
        if ((bVar instanceof t0) && hp.f.d((j1) bVar)) {
            return obj;
        }
        f0 f0VarE = e(bVar);
        Class<?> clsI = f0VarE == null ? null : i(f0VarE);
        return clsI == null ? obj : f(clsI, bVar).invoke(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @l
    public static final <M extends Member> d<M> b(@l d<? extends M> dVar, @l eo.b bVar, boolean z10) {
        f0 returnType;
        l0.p(dVar, "<this>");
        l0.p(bVar, "descriptor");
        if (!hp.f.a(bVar)) {
            List<h1> listH = bVar.h();
            l0.o(listH, "descriptor.valueParameters");
            List<h1> list = listH;
            if ((list instanceof Collection) && list.isEmpty()) {
                returnType = bVar.getReturnType();
                return returnType != null ? dVar : dVar;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                f0 type = ((h1) it.next()).getType();
                l0.o(type, "it.type");
                if (hp.f.c(type)) {
                }
            }
            returnType = bVar.getReturnType();
            if ((returnType != null || !hp.f.c(returnType)) && ((dVar instanceof c) || !g(bVar))) {
                return dVar;
            }
        }
        return new g(bVar, dVar, z10);
    }

    public static /* synthetic */ d c(d dVar, eo.b bVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return b(dVar, bVar, z10);
    }

    @l
    public static final Method d(@l Class<?> cls, @l eo.b bVar) {
        l0.p(cls, "<this>");
        l0.p(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, bVar).getReturnType());
            l0.o(declaredMethod, "{\n        getDeclaredMet…riptor).returnType)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new y("No box method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    public static final f0 e(eo.b bVar) {
        w0 w0VarR = bVar.R();
        w0 w0VarO = bVar.O();
        if (w0VarR != null) {
            return w0VarR.getType();
        }
        if (w0VarO != null) {
            if (bVar instanceof eo.l) {
                return w0VarO.getType();
            }
            eo.m mVarB = bVar.b();
            eo.e eVar = mVarB instanceof eo.e ? (eo.e) mVarB : null;
            if (eVar != null) {
                return eVar.q();
            }
        }
        return null;
    }

    @l
    public static final Method f(@l Class<?> cls, @l eo.b bVar) {
        l0.p(cls, "<this>");
        l0.p(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            l0.o(declaredMethod, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new y("No unbox method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    public static final boolean g(eo.b bVar) {
        f0 f0VarE = e(bVar);
        return f0VarE != null && hp.f.c(f0VarE);
    }

    @m
    public static final Class<?> h(@m eo.m mVar) {
        if (!(mVar instanceof eo.e) || !hp.f.b(mVar)) {
            return null;
        }
        eo.e eVar = (eo.e) mVar;
        Class<?> clsP = h0.p(eVar);
        if (clsP != null) {
            return clsP;
        }
        throw new y("Class object for the class " + eVar.getName() + " cannot be found (classId=" + lp.a.h((eo.h) mVar) + ')');
    }

    @m
    public static final Class<?> i(@l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return h(f0Var.G0().d());
    }
}
