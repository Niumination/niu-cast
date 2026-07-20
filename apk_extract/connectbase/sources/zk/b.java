package zk;

import dk.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jq.h0;
import kn.l0;
import kn.u1;
import nm.c1;
import nm.r;
import nm.z;
import os.l;
import rs.f;
import un.d;
import un.i;
import un.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final <R> R a(e eVar, Object obj, i<? extends R> iVar, dk.a aVar) throws Throwable {
        Object obj2;
        List<n> parameters = iVar.getParameters();
        ArrayList<n> arrayList = new ArrayList();
        for (Object obj3 : parameters) {
            if (!((n) obj3).z()) {
                arrayList.add(obj3);
            }
        }
        int iJ = c1.j(z.b0(arrayList, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (n nVar : arrayList) {
            if (nVar.getKind() == n.b.INSTANCE) {
                obj2 = obj;
            } else if (a.h(nVar)) {
                obj2 = eVar;
            } else {
                if (!a.g(nVar)) {
                    if (!h0.T2(nVar.getType().toString(), "Application", false, 2, null)) {
                        StringBuilder sb2 = new StringBuilder("Parameter type '");
                        sb2.append(nVar.getType());
                        sb2.append("' of parameter '");
                        String name = nVar.getName();
                        if (name == null) {
                            name = "<receiver>";
                        }
                        throw new IllegalArgumentException(j.c.a(sb2, name, "' is not supported"));
                    }
                    Type typeG = wn.e.g(nVar.getType());
                    Class cls = typeG instanceof Class ? (Class) typeG : null;
                    ClassLoader classLoader = cls != null ? cls.getClassLoader() : null;
                    StringBuilder sb3 = new StringBuilder("Parameter type ");
                    sb3.append(nVar.getType());
                    sb3.append(":{");
                    sb3.append(classLoader);
                    sb3.append("} is not supported.Application is loaded as ");
                    Class<dk.a> cls2 = a.f21944c;
                    sb3.append(cls2);
                    sb3.append(":{");
                    sb3.append(cls2.getClassLoader());
                    sb3.append(f.f14860b);
                    throw new IllegalArgumentException(sb3.toString());
                }
                obj2 = aVar;
            }
            linkedHashMap.put(nVar, obj2);
        }
        try {
            return iVar.callBy(linkedHashMap);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause == null) {
                throw e10;
            }
            throw cause;
        }
    }

    public static final Object b(e eVar, d<?> dVar, dk.a aVar) {
        Object objH = dVar.h();
        if (objH != null) {
            return objH;
        }
        Collection<i<?>> collectionG = dVar.g();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionG) {
            List<n> parameters = ((i) obj).getParameters();
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                Iterator<T> it = parameters.iterator();
                while (true) {
                    if (it.hasNext()) {
                        n nVar = (n) it.next();
                        if (!nVar.z() && !a.h(nVar) && !a.g(nVar)) {
                            break;
                        }
                    }
                }
            }
            arrayList.add(obj);
        }
        i iVarA = a.a(arrayList);
        if (iVarA != null) {
            return a(eVar, null, iVarA, aVar);
        }
        throw new RuntimeException(l0.C("There are no applicable constructors found in class ", dVar));
    }

    public static final void c(@l e eVar, @l ClassLoader classLoader, @l String str, @l dk.a aVar) {
        l0.p(eVar, "<this>");
        l0.p(classLoader, "classLoader");
        l0.p(str, "fqName");
        l0.p(aVar, n1.i.f11236l);
        char[] charArray = ".#".toCharArray();
        l0.o(charArray, "this as java.lang.String).toCharArray()");
        int iH3 = h0.H3(str, charArray, 0, false, 6, null);
        if (iH3 == -1) {
            throw new c("Module function cannot be found for the fully qualified name '" + str + '\'');
        }
        int i10 = 0;
        String strSubstring = str.substring(0, iH3);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iH3 + 1);
        l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
        Class<?> clsJ = a.j(classLoader, strSubstring);
        if (clsJ == null) {
            throw new c("Module function cannot be found for the fully qualified name '" + str + '\'');
        }
        Method[] methods = clsJ.getMethods();
        l0.o(methods, "clazz.methods");
        ArrayList<Method> arrayList = new ArrayList();
        int length = methods.length;
        while (i10 < length) {
            Method method = methods[i10];
            i10++;
            if (l0.g(method.getName(), strSubstring2) && Modifier.isStatic(method.getModifiers())) {
                arrayList.add(method);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Method method2 : arrayList) {
            l0.o(method2, "it");
            i<?> iVarJ = wn.e.j(method2);
            if (iVarJ != null) {
                arrayList2.add(iVarJ);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (a.f((i) obj)) {
                arrayList3.add(obj);
            }
        }
        i iVarA = a.a(arrayList3);
        if (iVarA != null) {
            List<n> parameters = iVarA.getParameters();
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                Iterator<T> it = parameters.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (((n) it.next()).getKind() != n.b.INSTANCE);
            }
            a(eVar, null, iVarA, aVar);
            return;
        }
        try {
            if (jn.l.class.isAssignableFrom(clsJ)) {
                Constructor<?>[] declaredConstructors = clsJ.getDeclaredConstructors();
                l0.o(declaredConstructors, "clazz.declaredConstructors");
                Constructor constructor = (Constructor) r.gt(declaredConstructors);
                if (constructor.getParameterCount() != 0) {
                    throw new c("Module function with captured variables cannot be instantiated '" + str + '\'');
                }
                constructor.setAccessible(true);
                Object objNewInstance = constructor.newInstance(null);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<io.ktor.application.Application, kotlin.Unit>");
                }
                ((jn.l) u1.q(objNewInstance, 1)).invoke(aVar);
                return;
            }
        } catch (NoSuchMethodError unused) {
        }
        d<?> dVarK = a.k(clsJ);
        if (dVarK == null) {
            throw new c("Module function cannot be found for the fully qualified name '" + str + '\'');
        }
        Collection<i<?>> collectionY = vn.f.y(dVarK);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : collectionY) {
            i iVar = (i) obj2;
            if (l0.g(iVar.getName(), strSubstring2) && a.f(iVar)) {
                arrayList4.add(obj2);
            }
        }
        i iVarA2 = a.a(arrayList4);
        if (iVarA2 != null) {
            a(eVar, b(eVar, dVarK, aVar), iVarA2, aVar);
            return;
        }
        throw new ClassNotFoundException("Module function cannot be found for the fully qualified name '" + str + '\'');
    }
}
