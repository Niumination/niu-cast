package fl;

import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {
    public static final <R> R a(ik.b1 b1Var, String str) {
        kn.l0.p(b1Var, "<this>");
        kn.l0.p(str, "name");
        kn.l0.P();
        Type typeF = un.b0.f(null);
        kn.l0.P();
        return (R) c(b1Var, str, ol.d.e(typeF, kn.l1.d(Object.class), null));
    }

    @os.l
    public static final String b(@os.l ik.b1 b1Var, @os.l String str) throws gk.o0 {
        kn.l0.p(b1Var, "<this>");
        kn.l0.p(str, "name");
        String str2 = b1Var.get(str);
        if (str2 != null) {
            return str2;
        }
        throw new gk.o0(str);
    }

    @lm.z0
    @os.l
    public static final <R> R c(@os.l ik.b1 b1Var, @os.l String str, @os.l ol.b bVar) throws gk.o0, gk.v0 {
        kn.l0.p(b1Var, "<this>");
        kn.l0.p(str, "name");
        kn.l0.p(bVar, "typeInfo");
        List<String> listB = b1Var.b(str);
        if (listB == null) {
            throw new gk.o0(str);
        }
        try {
            R r10 = (R) jl.e.f8745a.b(listB, bVar);
            if (r10 != null) {
                return r10;
            }
            throw new NullPointerException("null cannot be cast to non-null type R of io.ktor.util.ParametersKt.getOrFailImpl");
        } catch (Exception e10) {
            throw new gk.v0(str, wn.c.a(bVar.getType()), e10);
        }
    }

    @lm.k(message = "Please use overload with typeInfo parameter")
    @lm.z0
    @os.l
    public static final <R> R d(@os.l ik.b1 b1Var, @os.l String str, @os.l un.d<R> dVar, @os.l Type type) throws gk.o0, gk.v0 {
        kn.l0.p(b1Var, "<this>");
        kn.l0.p(str, "name");
        kn.l0.p(dVar, ik.y0.a.f8215h);
        kn.l0.p(type, "javaType");
        List<String> listB = b1Var.b(str);
        if (listB == null) {
            throw new gk.o0(str);
        }
        try {
            return (R) vn.f.a(dVar, e0.f6029a.b(listB, type));
        } catch (Exception e10) {
            throw new gk.v0(str, wn.c.a(dVar), e10);
        }
    }

    public static final <R> R e(ik.b1 b1Var, Object obj, un.o<?> oVar) {
        kn.l0.p(b1Var, "<this>");
        kn.l0.p(oVar, "property");
        String name = oVar.getName();
        kn.l0.P();
        Type typeF = un.b0.f(null);
        kn.l0.P();
        return (R) c(b1Var, name, ol.d.e(typeF, kn.l1.d(Object.class), null));
    }
}
