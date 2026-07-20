package wn;

import in.i;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kn.l0;
import os.l;
import un.j;
import un.o;
import xn.h0;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "KCallablesJvm")
public final class b {
    public static final boolean a(@l un.c<?> cVar) {
        yn.d<?> dVarH;
        l0.p(cVar, "<this>");
        if (cVar instanceof j) {
            o oVar = (o) cVar;
            Field fieldC = e.c(oVar);
            if (!(fieldC == null ? true : fieldC.isAccessible())) {
                return false;
            }
            Method methodD = e.d(oVar);
            if (!(methodD == null ? true : methodD.isAccessible())) {
                return false;
            }
            Method methodF = e.f((j) cVar);
            if (!(methodF == null ? true : methodF.isAccessible())) {
                return false;
            }
        } else if (cVar instanceof o) {
            o oVar2 = (o) cVar;
            Field fieldC2 = e.c(oVar2);
            if (!(fieldC2 == null ? true : fieldC2.isAccessible())) {
                return false;
            }
            Method methodD2 = e.d(oVar2);
            if (!(methodD2 == null ? true : methodD2.isAccessible())) {
                return false;
            }
        } else if (cVar instanceof o.c) {
            Field fieldC3 = e.c(((o.c) cVar).j());
            if (!(fieldC3 == null ? true : fieldC3.isAccessible())) {
                return false;
            }
            Method methodE = e.e((un.i) cVar);
            if (!(methodE == null ? true : methodE.isAccessible())) {
                return false;
            }
        } else if (cVar instanceof j.b) {
            Field fieldC4 = e.c(((j.b) cVar).j());
            if (!(fieldC4 == null ? true : fieldC4.isAccessible())) {
                return false;
            }
            Method methodE2 = e.e((un.i) cVar);
            if (!(methodE2 == null ? true : methodE2.isAccessible())) {
                return false;
            }
        } else {
            if (!(cVar instanceof un.i)) {
                throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
            }
            un.i iVar = (un.i) cVar;
            Method methodE3 = e.e(iVar);
            if (!(methodE3 == null ? true : methodE3.isAccessible())) {
                return false;
            }
            xn.f<?> fVarB = h0.b(cVar);
            Member memberB = (fVarB == null || (dVarH = fVarB.H()) == null) ? null : dVarH.b();
            AccessibleObject accessibleObject = memberB instanceof AccessibleObject ? (AccessibleObject) memberB : null;
            if (!(accessibleObject == null ? true : accessibleObject.isAccessible())) {
                return false;
            }
            Constructor constructorA = e.a(iVar);
            if (!(constructorA == null ? true : constructorA.isAccessible())) {
                return false;
            }
        }
        return true;
    }

    public static final void b(@l un.c<?> cVar, boolean z10) {
        yn.d<?> dVarH;
        l0.p(cVar, "<this>");
        if (cVar instanceof j) {
            o oVar = (o) cVar;
            Field fieldC = e.c(oVar);
            if (fieldC != null) {
                fieldC.setAccessible(z10);
            }
            Method methodD = e.d(oVar);
            if (methodD != null) {
                methodD.setAccessible(z10);
            }
            Method methodF = e.f((j) cVar);
            if (methodF == null) {
                return;
            }
            methodF.setAccessible(z10);
            return;
        }
        if (cVar instanceof o) {
            o oVar2 = (o) cVar;
            Field fieldC2 = e.c(oVar2);
            if (fieldC2 != null) {
                fieldC2.setAccessible(z10);
            }
            Method methodD2 = e.d(oVar2);
            if (methodD2 == null) {
                return;
            }
            methodD2.setAccessible(z10);
            return;
        }
        if (cVar instanceof o.c) {
            Field fieldC3 = e.c(((o.c) cVar).j());
            if (fieldC3 != null) {
                fieldC3.setAccessible(z10);
            }
            Method methodE = e.e((un.i) cVar);
            if (methodE == null) {
                return;
            }
            methodE.setAccessible(z10);
            return;
        }
        if (cVar instanceof j.b) {
            Field fieldC4 = e.c(((j.b) cVar).j());
            if (fieldC4 != null) {
                fieldC4.setAccessible(z10);
            }
            Method methodE2 = e.e((un.i) cVar);
            if (methodE2 == null) {
                return;
            }
            methodE2.setAccessible(z10);
            return;
        }
        if (!(cVar instanceof un.i)) {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        un.i iVar = (un.i) cVar;
        Method methodE3 = e.e(iVar);
        if (methodE3 != null) {
            methodE3.setAccessible(z10);
        }
        xn.f<?> fVarB = h0.b(cVar);
        Member memberB = (fVarB == null || (dVarH = fVarB.H()) == null) ? null : dVarH.b();
        AccessibleObject accessibleObject = memberB instanceof AccessibleObject ? (AccessibleObject) memberB : null;
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
        Constructor constructorA = e.a(iVar);
        if (constructorA == null) {
            return;
        }
        constructorA.setAccessible(z10);
    }
}
