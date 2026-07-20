package p1;

import c1.m0;
import c1.n0;
import el.b0;
import f1.i3;
import f1.k3;
import f1.p1;
import f1.t3;
import f1.x7;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import l1.h0;

/* JADX INFO: loaded from: classes.dex */
@d
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f12694b = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m0 f12695c = m0.j(" ").g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12696d = ".class";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t3<C0321c> f12697a;

    public static final class a extends C0321c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f12698d;

        public a(File file, String resourceName, ClassLoader loader) {
            super(file, resourceName, loader);
            this.f12698d = c.e(resourceName);
        }

        public String g() {
            return this.f12698d;
        }

        public String h() {
            return l.b(this.f12698d);
        }

        public String i() {
            int iLastIndexOf = this.f12698d.lastIndexOf(36);
            if (iLastIndexOf != -1) {
                return new c1.e.k('0', '9').V(this.f12698d.substring(iLastIndexOf + 1));
            }
            String strB = l.b(this.f12698d);
            return strB.isEmpty() ? this.f12698d : this.f12698d.substring(strB.length() + 1);
        }

        public boolean j() {
            return this.f12698d.indexOf(36) == -1;
        }

        public Class<?> k() {
            try {
                return this.f12703c.loadClass(this.f12698d);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // p1.c.C0321c
        public String toString() {
            return this.f12698d;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f12699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ClassLoader f12700b;

        public b(File home, ClassLoader classloader) {
            home.getClass();
            this.f12699a = home;
            classloader.getClass();
            this.f12700b = classloader;
        }

        public final File a() {
            return this.f12699a;
        }

        public final void b(File file, Set<File> scannedUris, t3.a<C0321c> builder) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        c(file, builder);
                    } else {
                        e(file, scannedUris, builder);
                    }
                }
            } catch (SecurityException e10) {
                c.f12694b.warning("Cannot access " + file + ": " + e10);
            }
        }

        public final void c(File directory, t3.a<C0321c> builder) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(directory.getCanonicalFile());
            d(directory, "", hashSet, builder);
        }

        public final void d(File directory, String packagePrefix, Set<File> currentPath, t3.a<C0321c> builder) throws IOException {
            File[] fileArrListFiles = directory.listFiles();
            if (fileArrListFiles == null) {
                c.f12694b.warning("Cannot read directory " + directory);
                return;
            }
            for (File file : fileArrListFiles) {
                String name = file.getName();
                if (file.isDirectory()) {
                    File canonicalFile = file.getCanonicalFile();
                    if (currentPath.add(canonicalFile)) {
                        d(canonicalFile, packagePrefix + name + "/", currentPath, builder);
                        currentPath.remove(canonicalFile);
                    }
                } else {
                    String strA = j.a.a(packagePrefix, name);
                    if (!strA.equals("META-INF/MANIFEST.MF")) {
                        builder.a(C0321c.e(file, strA, this.f12700b));
                    }
                }
            }
        }

        public final void e(File file, Set<File> scannedUris, t3.a<C0321c> builder) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    x7<File> it = c.h(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        File next = it.next();
                        if (scannedUris.add(next.getCanonicalFile())) {
                            b(next, scannedUris, builder);
                        }
                    }
                    f(jarFile, builder);
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        public boolean equals(@gm.a Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12699a.equals(bVar.f12699a) && this.f12700b.equals(bVar.f12700b);
        }

        public final void f(JarFile file, t3.a<C0321c> builder) {
            Enumeration<JarEntry> enumerationEntries = file.entries();
            while (enumerationEntries.hasMoreElements()) {
                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                if (!jarEntryNextElement.isDirectory() && !jarEntryNextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    builder.a(C0321c.e(new File(file.getName()), jarEntryNextElement.getName(), this.f12700b));
                }
            }
        }

        public t3<C0321c> g() throws IOException {
            return h(new HashSet());
        }

        public t3<C0321c> h(Set<File> scannedFiles) throws IOException {
            t3.a<C0321c> aVarBuilder = t3.builder();
            scannedFiles.add(this.f12699a);
            b(this.f12699a, scannedFiles, aVarBuilder);
            return aVarBuilder.e();
        }

        public int hashCode() {
            return this.f12699a.hashCode();
        }

        public String toString() {
            return this.f12699a.toString();
        }
    }

    /* JADX INFO: renamed from: p1.c$c, reason: collision with other inner class name */
    public static class C0321c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f12701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ClassLoader f12703c;

        public C0321c(File file, String resourceName, ClassLoader loader) {
            file.getClass();
            this.f12701a = file;
            resourceName.getClass();
            this.f12702b = resourceName;
            loader.getClass();
            this.f12703c = loader;
        }

        public static C0321c e(File file, String resourceName, ClassLoader loader) {
            return resourceName.endsWith(c.f12696d) ? new a(file, resourceName, loader) : new C0321c(file, resourceName, loader);
        }

        public final l1.g a() {
            return new h0.b(f());
        }

        public final l1.k b(Charset charset) {
            return h0.b(f(), charset);
        }

        public final File c() {
            return this.f12701a;
        }

        public final String d() {
            return this.f12702b;
        }

        public boolean equals(@gm.a Object obj) {
            if (!(obj instanceof C0321c)) {
                return false;
            }
            C0321c c0321c = (C0321c) obj;
            return this.f12702b.equals(c0321c.f12702b) && this.f12703c == c0321c.f12703c;
        }

        public final URL f() {
            URL resource = this.f12703c.getResource(this.f12702b);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.f12702b);
        }

        public int hashCode() {
            return this.f12702b.hashCode();
        }

        public String toString() {
            return this.f12702b;
        }
    }

    public c(t3<C0321c> resources) {
        this.f12697a = resources;
    }

    public static c b(ClassLoader classloader) throws IOException {
        t3<b> t3VarM = m(classloader);
        HashSet hashSet = new HashSet();
        x7<b> it = t3VarM.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().f12699a);
        }
        t3.a aVarBuilder = t3.builder();
        x7<b> it2 = t3VarM.iterator();
        while (it2.hasNext()) {
            aVarBuilder.c(it2.next().h(hashSet));
        }
        return new c(aVarBuilder.e());
    }

    public static i3<URL> d(ClassLoader classloader) {
        if (classloader instanceof URLClassLoader) {
            return i3.copyOf(((URLClassLoader) classloader).getURLs());
        }
        return classloader.equals(ClassLoader.getSystemClassLoader()) ? n() : i3.of();
    }

    @b1.e
    public static String e(String filename) {
        return filename.substring(0, filename.length() - 6).replace(b0.f4502a, n1.e.f11183c);
    }

    @b1.e
    public static k3<File, ClassLoader> f(ClassLoader classloader) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ClassLoader parent = classloader.getParent();
        if (parent != null) {
            linkedHashMap.putAll(f(parent));
        }
        x7<URL> it = d(classloader).iterator();
        while (it.hasNext()) {
            URL next = it.next();
            if (next.getProtocol().equals("file")) {
                File fileO = o(next);
                if (!linkedHashMap.containsKey(fileO)) {
                    linkedHashMap.put(fileO, classloader);
                }
            }
        }
        return k3.copyOf((Map) linkedHashMap);
    }

    @b1.e
    public static URL g(File jarFile, String path) throws MalformedURLException {
        return new URL(jarFile.toURI().toURL(), path);
    }

    @b1.e
    public static t3<File> h(File jarFile, @gm.a Manifest manifest) {
        if (manifest == null) {
            return t3.of();
        }
        t3.a aVarBuilder = t3.builder();
        String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (value != null) {
            for (String str : f12695c.n(value)) {
                try {
                    URL urlG = g(jarFile, str);
                    if (urlG.getProtocol().equals("file")) {
                        aVarBuilder.a(o(urlG));
                    }
                } catch (MalformedURLException unused) {
                    f12694b.warning("Invalid Class-Path entry: " + str);
                }
            }
        }
        return aVarBuilder.e();
    }

    public static t3<b> m(ClassLoader classloader) {
        t3.a aVarBuilder = t3.builder();
        x7<Map.Entry<File, ClassLoader>> it = f(classloader).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<File, ClassLoader> next = it.next();
            aVarBuilder.a(new b(next.getKey(), next.getValue()));
        }
        return aVarBuilder.e();
    }

    @b1.e
    public static i3<URL> n() {
        i3.a aVarBuilder = i3.builder();
        for (String str : m0.j(n0.PATH_SEPARATOR.value()).n(n0.JAVA_CLASS_PATH.value())) {
            try {
                try {
                    aVarBuilder.j(new File(str).toURI().toURL());
                } catch (SecurityException unused) {
                    aVarBuilder.j(new URL("file", (String) null, new File(str).getAbsolutePath()));
                }
            } catch (MalformedURLException e10) {
                f12694b.log(Level.WARNING, "malformed classpath entry: " + str, (Throwable) e10);
            }
        }
        return aVarBuilder.e();
    }

    @b1.e
    public static File o(URL url) {
        c1.h0.d(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public t3<a> c() {
        return p1.u(this.f12697a).q(a.class).I();
    }

    public t3<C0321c> i() {
        return this.f12697a;
    }

    public t3<a> j() {
        return p1.u(this.f12697a).q(a.class).o(new p1.b()).I();
    }

    public t3<a> k(String packageName) {
        packageName.getClass();
        t3.a aVarBuilder = t3.builder();
        x7<a> it = j().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (l.b(next.f12698d).equals(packageName)) {
                aVarBuilder.a(next);
            }
        }
        return aVarBuilder.e();
    }

    public t3<a> l(String packageName) {
        packageName.getClass();
        String strConcat = packageName.concat(".");
        t3.a aVarBuilder = t3.builder();
        x7<a> it = j().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f12698d.startsWith(strConcat)) {
                aVarBuilder.a(next);
            }
        }
        return aVarBuilder.e();
    }
}
