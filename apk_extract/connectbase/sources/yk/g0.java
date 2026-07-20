package yk;

import java.lang.reflect.Method;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {
    @os.l
    public static final String a(@os.l lm.v<?> vVar) {
        l0.p(vVar, "<this>");
        un.i iVar = vVar instanceof un.i ? (un.i) vVar : null;
        Method methodE = iVar != null ? wn.e.e(iVar) : null;
        if (methodE == null) {
            return l0.C(vVar.getClass().getName(), ".invoke");
        }
        Class<?> declaringClass = methodE.getDeclaringClass();
        String name = methodE.getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) declaringClass.getName());
        sb2.append(n1.e.f11183c);
        sb2.append((Object) name);
        return sb2.toString();
    }
}
