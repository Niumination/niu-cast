package wn;

import in.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kn.l0;
import os.l;
import os.m;
import un.b0;
import un.h;
import un.j;
import un.o;
import un.q;
import un.s;
import xn.h0;
import xn.t;
import xn.v;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "ReflectJvmMapping")
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19736a;

        static {
            int[] iArr = new int[xo.a.EnumC0527a.values().length];
            iArr[xo.a.EnumC0527a.FILE_FACADE.ordinal()] = 1;
            iArr[xo.a.EnumC0527a.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[xo.a.EnumC0527a.MULTIFILE_CLASS_PART.ordinal()] = 3;
            f19736a = iArr;
        }
    }

    @m
    public static final <T> Constructor<T> a(@l un.i<? extends T> iVar) {
        l0.p(iVar, "<this>");
        xn.f<?> fVarB = h0.b(iVar);
        Member memberB = fVarB == null ? null : fVarB.F().b();
        if (memberB instanceof Constructor) {
            return (Constructor) memberB;
        }
        return null;
    }

    public static /* synthetic */ void b(un.i iVar) {
    }

    @m
    public static final Field c(@l o<?> oVar) {
        l0.p(oVar, "<this>");
        t<?> tVarD = h0.d(oVar);
        if (tVarD == null) {
            return null;
        }
        return tVarD.R();
    }

    @m
    public static final Method d(@l o<?> oVar) {
        l0.p(oVar, "<this>");
        return e(oVar.getGetter());
    }

    @m
    public static final Method e(@l un.i<?> iVar) {
        l0.p(iVar, "<this>");
        xn.f<?> fVarB = h0.b(iVar);
        Member memberB = fVarB == null ? null : fVarB.F().b();
        if (memberB instanceof Method) {
            return (Method) memberB;
        }
        return null;
    }

    @m
    public static final Method f(@l j<?> jVar) {
        l0.p(jVar, "<this>");
        return e(jVar.getSetter());
    }

    @l
    public static final Type g(@l s sVar) {
        l0.p(sVar, "<this>");
        Type typeP = ((v) sVar).p();
        return typeP == null ? b0.f(sVar) : typeP;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final h h(Member member) {
        jo.f.a aVar = jo.f.f8758c;
        Class<?> declaringClass = member.getDeclaringClass();
        l0.o(declaringClass, "declaringClass");
        jo.f fVarA = aVar.a(declaringClass);
        String str = null;
        Object[] objArr = 0;
        xo.a.EnumC0527a enumC0527a = fVarA == null ? null : fVarA.f8760b.f20438a;
        int i10 = enumC0527a == null ? -1 : a.f19736a[enumC0527a.ordinal()];
        int i11 = 2;
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            return null;
        }
        Class<?> declaringClass2 = member.getDeclaringClass();
        l0.o(declaringClass2, "declaringClass");
        return new xn.o(declaringClass2, str, i11, objArr == true ? 1 : 0);
    }

    @m
    public static final <T> un.i<T> i(@l Constructor<T> constructor) {
        T next;
        l0.p(constructor, "<this>");
        Class<T> declaringClass = constructor.getDeclaringClass();
        l0.o(declaringClass, "declaringClass");
        Iterator<T> it = in.b.i(declaringClass).g().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (l0.g(a((un.i) next), constructor)) {
                return (un.i) next;
            }
        }
        next = null;
        return (un.i) next;
    }

    @m
    public static final un.i<?> j(@l Method method) {
        Object next;
        l0.p(method, "<this>");
        Object obj = null;
        if (Modifier.isStatic(method.getModifiers())) {
            h hVarH = h(method);
            if (hVarH != null) {
                Collection<un.c<?>> collectionD = hVarH.d();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : collectionD) {
                    if (obj2 instanceof un.i) {
                        arrayList.add(obj2);
                    }
                }
                for (Object obj3 : arrayList) {
                    if (l0.g(e((un.i) obj3), method)) {
                        obj = obj3;
                        break;
                    }
                }
                return (un.i) obj;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            l0.o(declaringClass, "declaringClass");
            un.d<?> dVarG = vn.f.g(in.b.i(declaringClass));
            if (dVarG != null) {
                Iterator<T> it = vn.f.y(dVarG).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Method methodE = e((un.i) next);
                    if (methodE != null && l0.g(methodE.getName(), method.getName()) && Arrays.equals(methodE.getParameterTypes(), method.getParameterTypes()) && l0.g(methodE.getReturnType(), method.getReturnType())) {
                        break;
                    }
                }
                un.i<?> iVar = (un.i) next;
                if (iVar != null) {
                    return iVar;
                }
            }
        }
        Class<?> declaringClass2 = method.getDeclaringClass();
        l0.o(declaringClass2, "declaringClass");
        for (Object obj4 : vn.f.y(in.b.i(declaringClass2))) {
            if (l0.g(e((un.i) obj4), method)) {
                obj = obj4;
                break;
            }
        }
        return (un.i) obj;
    }

    @m
    public static final o<?> k(@l Field field) {
        l0.p(field, "<this>");
        Object obj = null;
        if (field.isSynthetic()) {
            return null;
        }
        h hVarH = h(field);
        if (hVarH == null) {
            Class<?> declaringClass = field.getDeclaringClass();
            l0.o(declaringClass, "declaringClass");
            for (Object obj2 : vn.f.G(in.b.i(declaringClass))) {
                if (l0.g(c((q) obj2), field)) {
                    obj = obj2;
                    break;
                }
            }
            return (o) obj;
        }
        Collection<un.c<?>> collectionD = hVarH.d();
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : collectionD) {
            if (obj3 instanceof o) {
                arrayList.add(obj3);
            }
        }
        for (Object obj4 : arrayList) {
            if (l0.g(c((o) obj4), field)) {
                obj = obj4;
                break;
            }
        }
        return (o) obj;
    }
}
