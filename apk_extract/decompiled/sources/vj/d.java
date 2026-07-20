package vj;

import af.w0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import xj.g;
import xj.h;
import xj.i;
import xj.j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f10607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final xj.e f10608b = new xj.e(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final xj.e f10609c = new xj.e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile xj.e f10610d;
    public static final String[] e;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            property.equalsIgnoreCase("true");
        }
        e = new String[]{"2.0"};
    }

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        final ClassLoader classLoader = d.class.getClassLoader();
        String property = System.getProperty("slf4j.provider");
        xj.e eVar = null;
        if (property != null && !property.isEmpty()) {
            try {
                String str = "Attempting to load provider \"" + property + "\" specified via \"slf4j.provider\" system property";
                h hVar = i.f11012a;
                if (i.c(g.INFO)) {
                    i.b().println("SLF4J(I): " + str);
                }
                eVar = (xj.e) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e4) {
                i.a("Specified SLF4JServiceProvider (" + property + ") does not implement SLF4JServiceProvider interface", e4);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
                i.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e10);
            }
        }
        if (eVar != null) {
            arrayList.add(eVar);
            return arrayList;
        }
        Iterator it = (System.getSecurityManager() == null ? ServiceLoader.load(xj.e.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: vj.c
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ServiceLoader.load(xj.e.class, classLoader);
            }
        })).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add((xj.e) it.next());
            } catch (ServiceConfigurationError e11) {
                String str2 = "A service provider failed to instantiate:\n" + e11.getMessage();
                i.b().println("SLF4J(E): " + str2);
            }
        }
        return arrayList;
    }

    public static b b(String str) {
        xj.e eVar;
        a aVar;
        if (f10607a == 0) {
            synchronized (d.class) {
                try {
                    if (f10607a == 0) {
                        f10607a = 1;
                        c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        int i8 = f10607a;
        if (i8 == 1) {
            eVar = f10608b;
        } else {
            if (i8 == 2) {
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
            }
            if (i8 == 3) {
                eVar = f10610d;
            } else {
                if (i8 != 4) {
                    throw new IllegalStateException("Unreachable code");
                }
                eVar = f10609c;
            }
        }
        switch (eVar.f11010a) {
            case 0:
                aVar = (se.h) eVar.f11011b;
                break;
            default:
                aVar = (w0) eVar.f11011b;
                break;
        }
        return aVar.d(str);
    }

    public static final void c() {
        try {
            ArrayList arrayListA = a();
            g(arrayListA);
            if (arrayListA.isEmpty()) {
                f10607a = 4;
                i.d("No SLF4J providers were found.");
                i.d("Defaulting to no-operation (NOP) logger implementation");
                i.d("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = d.class.getClassLoader();
                    Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    while (systemResources.hasMoreElements()) {
                        linkedHashSet.add(systemResources.nextElement());
                    }
                } catch (IOException e4) {
                    i.a("Error getting resources from path", e4);
                }
                f(linkedHashSet);
            } else {
                f10610d = (xj.e) arrayListA.get(0);
                f10610d.getClass();
                f10607a = 3;
                e(arrayListA);
            }
            d();
            if (f10607a == 3) {
                try {
                    switch (f10610d.f11010a) {
                        case 0:
                            boolean z2 = false;
                            for (String str : e) {
                                if ("2.0.99".startsWith(str)) {
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                return;
                            }
                            i.d("The requested version 2.0.99 by your slf4j provider is not compatible with " + Arrays.asList(e).toString());
                            i.d("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                            return;
                        default:
                            throw new UnsupportedOperationException();
                    }
                } catch (Throwable th2) {
                    i.a("Unexpected problem occurred during version sanity check", th2);
                }
            }
        } catch (Exception e10) {
            f10607a = 2;
            i.a("Failed to instantiate SLF4J LoggerFactory", e10);
            throw new IllegalStateException("Unexpected initialization failure", e10);
        }
    }

    public static void d() {
        xj.e eVar = f10608b;
        synchronized (eVar) {
            try {
                ((w0) eVar.f11011b).f640a = true;
                w0 w0Var = (w0) eVar.f11011b;
                w0Var.getClass();
                for (j jVar : new ArrayList(((ConcurrentHashMap) w0Var.f641b).values())) {
                    jVar.f11015b = b(jVar.f11014a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = (LinkedBlockingQueue) ((w0) f10608b.f11011b).f642c;
        int size = linkedBlockingQueue.size();
        ArrayList<wj.c> arrayList = new ArrayList(128);
        int i8 = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            for (wj.c cVar : arrayList) {
                if (cVar != null) {
                    j jVar2 = cVar.f10791c;
                    String str = jVar2.f11014a;
                    if (jVar2.f11015b == null) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!(jVar2.f11015b instanceof xj.d)) {
                        if (!jVar2.b()) {
                            i.d(str);
                        } else if (jVar2.isEnabledForLevel(cVar.f10789a) && jVar2.b()) {
                            try {
                                jVar2.f11017d.invoke(jVar2.f11015b, cVar);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i9 = i8 + 1;
                if (i8 == 0) {
                    if (cVar.f10791c.b()) {
                        i.d("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        i.d("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        i.d("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(cVar.f10791c.f11015b instanceof xj.d)) {
                        i.d("The following set of substitute loggers may have been accessed");
                        i.d("during the initialization phase. Logging calls during this");
                        i.d("phase were not honored. However, subsequent logging calls to these");
                        i.d("loggers will work as normally expected.");
                        i.d("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i8 = i9;
            }
            arrayList.clear();
        }
        w0 w0Var2 = (w0) f10608b.f11011b;
        ((ConcurrentHashMap) w0Var2.f641b).clear();
        ((LinkedBlockingQueue) w0Var2.f642c).clear();
    }

    public static void e(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No providers were found which is impossible after successful initialization.");
        }
        if (arrayList.size() > 1) {
            String str = "Actual provider is of type [" + arrayList.get(0) + "]";
            h hVar = i.f11012a;
            if (i.c(g.INFO)) {
                i.b().println("SLF4J(I): " + str);
                return;
            }
            return;
        }
        String str2 = "Connected with provider of type [" + ((xj.e) arrayList.get(0)).getClass().getName() + "]";
        h hVar2 = i.f11012a;
        if (i.c(g.DEBUG)) {
            i.b().println("SLF4J(D): " + str2);
        }
    }

    public static void f(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        i.d("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            i.d("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        i.d("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void g(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            i.d("Class path contains multiple SLF4J providers.");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i.d("Found provider [" + ((xj.e) it.next()) + "]");
            }
            i.d("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
