package xn;

import eo.t0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kn.l0;
import vp.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    public static final yn.d<?> b(t.a<?, ?> aVar, boolean z10) {
        d.e eVar;
        Method method;
        yn.d aVar2;
        bp.a.c setter;
        yn.d cVar;
        j.f20365a.getClass();
        if (j.f20367c.matches(aVar.M().f20416g)) {
            return yn.j.f21501a;
        }
        e eVarF = d0.f20319a.f(aVar.M().L());
        if (eVarF instanceof e.c) {
            e.c cVar2 = (e.c) eVarF;
            bp.a.d dVar = cVar2.f20326c;
            if (z10) {
                if (dVar.hasGetter()) {
                    setter = dVar.getGetter();
                } else {
                    setter = null;
                }
            } else if (dVar.hasSetter()) {
                setter = dVar.getSetter();
            } else {
                setter = null;
            }
            Method methodG = setter == null ? null : aVar.M().G().G(cVar2.f20327d.c(setter.getName()), cVar2.f20327d.c(setter.getDesc()));
            if (methodG != null) {
                if (!Modifier.isStatic(methodG.getModifiers())) {
                    cVar = aVar.K() ? new yn.e.h.a(methodG, f(aVar)) : new yn.e.h.d(methodG);
                } else if (d(aVar)) {
                    cVar = aVar.K() ? new yn.e.h.b(methodG) : new yn.e.h.C0556e(methodG);
                } else {
                    cVar = aVar.K() ? new yn.e.h.c(methodG, f(aVar)) : new yn.e.h.f(methodG);
                }
                aVar2 = cVar;
            } else if (hp.f.d(aVar.M().L()) && l0.g(aVar.M().L().getVisibility(), eo.t.f4632d)) {
                Class<?> clsH = yn.h.h(aVar.M().L().b());
                if (clsH == null) {
                    throw new y("Underlying property of inline class " + aVar.M() + " should have a field");
                }
                Method methodF = yn.h.f(clsH, aVar.M().L());
                aVar2 = aVar.K() ? new yn.i.a(methodF, f(aVar)) : new yn.i.b(methodF);
            } else {
                Field fieldR = aVar.M().R();
                if (fieldR == null) {
                    throw new y(l0.C("No accessors or field is found for property ", aVar.M()));
                }
                aVar2 = c(aVar, z10, fieldR);
            }
        } else if (eVarF instanceof e.a) {
            aVar2 = c(aVar, z10, ((e.a) eVarF).f20321a);
        } else {
            if (!(eVarF instanceof e.b)) {
                if (!(eVarF instanceof e.d)) {
                    throw new lm.i0();
                }
                if (z10) {
                    eVar = ((e.d) eVarF).f20330a;
                } else {
                    eVar = ((e.d) eVarF).f20331b;
                    if (eVar == null) {
                        throw new y(l0.C("No setter found for property ", aVar.M()));
                    }
                }
                j jVarG = aVar.M().G();
                cp.d.b bVar = eVar.f20317a;
                Method methodG2 = jVarG.G(bVar.f3367a, bVar.f3368b);
                if (methodG2 == null) {
                    throw new y(l0.C("No accessor found for property ", aVar.M()));
                }
                Modifier.isStatic(methodG2.getModifiers());
                return aVar.K() ? new yn.e.h.a(methodG2, f(aVar)) : new yn.e.h.d(methodG2);
            }
            if (z10) {
                method = ((e.b) eVarF).f20322a;
            } else {
                e.b bVar2 = (e.b) eVarF;
                method = bVar2.f20323b;
                if (method == null) {
                    throw new y(l0.C("No source found for setter of Java method property: ", bVar2.f20322a));
                }
            }
            aVar2 = aVar.K() ? new yn.e.h.a(method, f(aVar)) : new yn.e.h.d(method);
        }
        return yn.h.c(aVar2, aVar.L(), false, 2, null);
    }

    public static final yn.e<Field> c(t.a<?, ?> aVar, boolean z10, Field field) {
        yn.e<Field> aVar2;
        if (g(aVar.M().L()) || !Modifier.isStatic(field.getModifiers())) {
            if (!z10) {
                aVar2 = aVar.K() ? new yn.e.g.a(field, e(aVar), f(aVar)) : new yn.e.g.c(field, e(aVar));
            } else {
                if (!aVar.K()) {
                    return new yn.e.f.c(field);
                }
                aVar2 = new yn.e.f.a(field, f(aVar));
            }
        } else if (d(aVar)) {
            if (z10) {
                return aVar.K() ? new yn.e.f.b(field) : new yn.e.f.d(field);
            }
            aVar2 = aVar.K() ? new yn.e.g.b(field, e(aVar)) : new yn.e.g.d(field, e(aVar));
        } else {
            if (z10) {
                return new yn.e.f.C0554e(field);
            }
            aVar2 = new yn.e.g.C0555e(field, e(aVar));
        }
        return aVar2;
    }

    public static final boolean d(t.a<?, ?> aVar) {
        return aVar.M().L().getAnnotations().p(h0.j());
    }

    public static final boolean e(t.a<?, ?> aVar) {
        return !j1.m(aVar.M().L().getType());
    }

    @os.m
    public static final Object f(@os.l t.a<?, ?> aVar) {
        l0.p(aVar, "<this>");
        return aVar.M().N();
    }

    public static final boolean g(t0 t0Var) {
        eo.m mVarB = t0Var.b();
        l0.o(mVarB, "containingDeclaration");
        if (!hp.d.x(mVarB)) {
            return false;
        }
        eo.m mVarB2 = mVarB.b();
        return !(hp.d.D(mVarB2, eo.f.INTERFACE) || hp.d.D(mVarB2, eo.f.ANNOTATION_CLASS)) || ((t0Var instanceof tp.k) && cp.g.f(((tp.k) t0Var).U));
    }
}
