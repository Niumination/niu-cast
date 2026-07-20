package vq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,161:1\n77#1,5:162\n77#1,5:168\n131#1,13:183\n1#2:167\n1360#3:173\n1446#3,5:174\n1549#3:179\n1620#3,3:180\n1064#4,2:196\n*S KotlinDebug\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n*L\n60#1:162,5\n61#1:168,5\n117#1:183,13\n99#1:173\n99#1:174,5\n101#1:179\n101#1:180,3\n153#1:196,2\n*E\n"})
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final q f17872a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f17873b = "META-INF/services/";

    public final e0 a(Class<e0> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <S> S b(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(null).newInstance(null));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    public final <S> List<S> c(Class<S> cls, ClassLoader classLoader) {
        try {
            return e(cls, classLoader);
        } catch (Throwable unused) {
            return nm.h0.V5(ServiceLoader.load(cls, classLoader));
        }
    }

    @os.l
    public final List<e0> d() {
        e0 e0Var;
        if (!r.a()) {
            return c(e0.class, e0.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            e0 e0Var2 = null;
            try {
                e0Var = (e0) e0.class.cast(Class.forName("oq.a", true, e0.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
            } catch (ClassNotFoundException unused) {
                e0Var = null;
            }
            if (e0Var != null) {
                arrayList.add(e0Var);
            }
            try {
                e0Var2 = (e0) e0.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, e0.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
            } catch (ClassNotFoundException unused2) {
            }
            if (e0Var2 == null) {
                return arrayList;
            }
            arrayList.add(e0Var2);
            return arrayList;
        } catch (Throwable unused3) {
            return c(e0.class, e0.class.getClassLoader());
        }
    }

    @os.l
    public final <S> List<S> e(@os.l Class<S> cls, @os.l ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources(f17873b.concat(cls.getName())));
        kn.l0.o(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            nm.d0.r0(arrayList, f17872a.f((URL) it.next()));
        }
        Set setA6 = nm.h0.a6(arrayList);
        if (setA6.isEmpty()) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader");
        }
        ArrayList arrayList2 = new ArrayList(nm.z.b0(setA6, 10));
        Iterator it2 = setA6.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f17872a.b((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    public final List<String> f(URL url) throws IllegalAccessException, IOException, InvocationTargetException {
        String string = url.toString();
        if (!jq.e0.s2(string, "jar", false, 2, null)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listG = f17872a.g(bufferedReader);
                dn.c.a(bufferedReader, null);
                return listG;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    dn.c.a(bufferedReader, th2);
                    throw th3;
                }
            }
        }
        String strU5 = jq.h0.u5(jq.h0.n5(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strN5 = jq.h0.n5(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strU5, false);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strN5)), "UTF-8"));
            try {
                List<String> listG2 = f17872a.g(bufferedReader2);
                dn.c.a(bufferedReader2, null);
                jarFile.close();
                return listG2;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    dn.c.a(bufferedReader2, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                try {
                    jarFile.close();
                    throw th7;
                } catch (Throwable th8) {
                    lm.p.a(th6, th8);
                    throw th6;
                }
            }
        }
    }

    public final List<String> g(BufferedReader bufferedReader) throws IOException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return nm.h0.V5(linkedHashSet);
            }
            String string = jq.h0.C5(jq.h0.v5(line, "#", null, 2, null)).toString();
            for (int i10 = 0; i10 < string.length(); i10++) {
                char cCharAt = string.charAt(i10);
                if (cCharAt != '.' && !Character.isJavaIdentifierPart(cCharAt)) {
                    throw new IllegalArgumentException(m.a.a("Illegal service provider class name: ", string).toString());
                }
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }

    public final <R> R h(JarFile jarFile, jn.l<? super JarFile, ? extends R> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        try {
            R rInvoke = lVar.invoke(jarFile);
            jarFile.close();
            return rInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    lm.p.a(th2, th4);
                    throw th2;
                }
            }
        }
    }
}
