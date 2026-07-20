package yk;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kn.l0;
import nm.k0;
import nm.m0;
import nm.p1;
import nm.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            String str = (String) t10;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i11 < str.length()) {
                char cCharAt = str.charAt(i11);
                i11++;
                if (cCharAt == '/') {
                    i12++;
                }
            }
            Integer numValueOf = Integer.valueOf(i12);
            String str2 = (String) t11;
            int i13 = 0;
            while (i10 < str2.length()) {
                char cCharAt2 = str2.charAt(i10);
                i10++;
                if (cCharAt2 == '/') {
                    i13++;
                }
            }
            return rm.g.l(numValueOf, Integer.valueOf(i13));
        }
    }

    @os.l
    public static final Set<URL> a(@os.l ClassLoader classLoader) {
        l0.p(classLoader, "<this>");
        ClassLoader parent = classLoader.getParent();
        Set<URL> setA = parent == null ? null : a(parent);
        if (setA == null) {
            setA = m0.INSTANCE;
        }
        if (!(classLoader instanceof URLClassLoader)) {
            List<URL> listC = c(classLoader);
            return listC == null ? setA : p1.D(setA, listC);
        }
        URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
        l0.o(uRLs, "urLs");
        return p1.D(nm.h0.a6(nm.r.Ta(uRLs)), setA);
    }

    public static final Field b(Class<?> cls) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        l0.o(declaredFields, "declaredFields");
        int length = declaredFields.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i10];
            i10++;
            if (l0.g(field.getName(), "ucp") && l0.g(field.getType().getSimpleName(), "URLClassPath")) {
                break;
            }
        }
        if (field != null) {
            return field;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        Field fieldB = superclass == null ? null : b(superclass);
        if (fieldB == null) {
            return null;
        }
        return fieldB;
    }

    public static final List<URL> c(ClassLoader classLoader) {
        Method method;
        try {
            try {
                Field fieldB = b(classLoader.getClass());
                if (fieldB == null) {
                    return null;
                }
                fieldB.setAccessible(true);
                Object obj = fieldB.get(classLoader);
                if (obj == null || (method = obj.getClass().getMethod("getURLs", null)) == null) {
                    return null;
                }
                method.setAccessible(true);
                URL[] urlArr = (URL[]) method.invoke(obj, null);
                if (urlArr == null) {
                    return null;
                }
                return nm.r.Ky(urlArr);
            } catch (Throwable unused) {
                return d(classLoader);
            }
        } catch (Throwable unused2) {
            return null;
        }
        return null;
    }

    public static final List<URL> d(ClassLoader classLoader) throws IOException {
        List<String> listA = new n(classLoader).a();
        ArrayList<String> arrayList = new ArrayList(nm.z.b0(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(jq.e0.h2((String) it.next(), n1.e.f11183c, el.b0.f4502a, false, 4, null));
        }
        HashSet hashSet = new HashSet();
        for (String str : arrayList) {
            List listQ4 = jq.h0.Q4(str, new char[]{el.b0.f4502a}, false, 0, 6, null);
            tn.l lVar = new tn.l(1, listQ4.size(), 1);
            ArrayList arrayList2 = new ArrayList(nm.z.b0(lVar, 10));
            Iterator<Integer> it2 = lVar.iterator();
            while (it2.hasNext()) {
                arrayList2.add(nm.h0.m3(listQ4.subList(0, ((v0) it2).nextInt()), "/", null, null, 0, null, null, 62, null));
            }
            nm.d0.r0(hashSet, nm.h0.F4(arrayList2, str));
        }
        List listF4 = nm.h0.F4(nm.h0.u5(hashSet, new a()), "");
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = listF4.iterator();
        while (true) {
            Iterable list = null;
            if (!it3.hasNext()) {
                break;
            }
            Enumeration<URL> resources = classLoader.getResources((String) it3.next());
            if (resources != null) {
                list = Collections.list(resources);
                l0.o(list, "list(this)");
            }
            if (list == null) {
                list = k0.INSTANCE;
            }
            nm.d0.r0(arrayList3, list);
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            String path = ((URL) obj).getPath();
            l0.o(path, "it.path");
            if (hashSet2.add(jq.h0.u5(path, '!', null, 2, null))) {
                arrayList4.add(obj);
            }
        }
        return arrayList4;
    }
}
