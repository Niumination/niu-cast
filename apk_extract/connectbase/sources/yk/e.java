package yk;

import ik.r0;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kn.l0;
import kn.n0;
import lm.l2;
import lm.t0;
import nm.k0;

/* JADX INFO: loaded from: classes2.dex */
@v
public final class e implements yk.b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public static final a f21380t = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ClassLoader f21381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ps.a f21382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ek.a f21383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<x> f21384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final List<jn.l<dk.a, l2>> f21385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final List<String> f21386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final um.g f21387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final String f21388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f21389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public dk.a f21390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f21391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.m
    public ClassLoader f21392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public final ReentrantReadWriteLock f21393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public List<? extends WatchKey> f21394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public final List<String> f21395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final List<String> f21396p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public final List<String> f21397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public final lm.d0 f21398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public final dk.f f21399s;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends n0 implements jn.a<l2> {
        final /* synthetic */ ClassLoader $currentClassLoader;
        final /* synthetic */ dk.a $newInstance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ClassLoader classLoader, dk.a aVar) {
            super(0);
            this.$currentClassLoader = classLoader;
            this.$newInstance = aVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            e eVar = e.this;
            List<String> list = eVar.f21397q;
            ClassLoader classLoader = this.$currentClassLoader;
            dk.a aVar = this.$newInstance;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                eVar.w((String) it.next(), classLoader, aVar);
            }
            e eVar2 = e.this;
            List<jn.l<dk.a, l2>> list2 = eVar2.f21385e;
            ClassLoader classLoader2 = this.$currentClassLoader;
            dk.a aVar2 = this.$newInstance;
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                jn.l lVar = (jn.l) it2.next();
                try {
                    eVar2.w(g0.a(lVar), classLoader2, aVar2);
                } catch (zk.c unused) {
                    lVar.invoke(aVar2);
                }
            }
        }
    }

    public static final class c extends n0 implements jn.a<l2> {
        final /* synthetic */ ClassLoader $currentClassLoader;
        final /* synthetic */ String $name;
        final /* synthetic */ dk.a $newInstance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ClassLoader classLoader, String str, dk.a aVar) {
            super(0);
            this.$currentClassLoader = classLoader;
            this.$name = str;
            this.$newInstance = aVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            zk.b.c(e.this, this.$currentClassLoader, this.$name, this.$newInstance);
        }
    }

    public static final class d extends SimpleFileVisitor<Path> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashSet<Path> f21400a;

        public d(HashSet<Path> hashSet) {
            this.f21400a = hashSet;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        @os.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileVisitResult preVisitDirectory(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) {
            l0.p(path, "dir");
            l0.p(basicFileAttributes, "attrs");
            this.f21400a.add(path);
            return FileVisitResult.CONTINUE;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileVisitResult visitFile(@os.l Path path, @os.l BasicFileAttributes basicFileAttributes) {
            l0.p(path, "file");
            l0.p(basicFileAttributes, "attrs");
            Path parent = path.getParent();
            if (parent != null) {
                this.f21400a.add(parent);
            }
            return FileVisitResult.CONTINUE;
        }
    }

    /* JADX INFO: renamed from: yk.e$e, reason: collision with other inner class name */
    public static final class C0543e extends n0 implements jn.a<WatchService> {
        public static final C0543e INSTANCE = new C0543e();

        public C0543e() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final WatchService invoke() {
            try {
                return FileSystems.getDefault().newWatchService();
            } catch (NoClassDefFoundError unused) {
                return null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@os.l ClassLoader classLoader, @os.l ps.a aVar, @os.l ek.a aVar2, @os.l List<? extends x> list, @os.l List<? extends jn.l<? super dk.a, l2>> list2, @os.l List<String> list3, @os.l um.g gVar, @os.l String str, boolean z10) {
        l0.p(classLoader, "classLoader");
        l0.p(aVar, "log");
        l0.p(aVar2, "config");
        l0.p(list, "connectors");
        l0.p(list2, "modules");
        l0.p(list3, "watchPaths");
        l0.p(gVar, "parentCoroutineContext");
        l0.p(str, "rootPath");
        this.f21381a = classLoader;
        this.f21382b = aVar;
        this.f21383c = aVar2;
        this.f21384d = list;
        this.f21385e = list2;
        this.f21386f = list3;
        this.f21387g = gVar;
        this.f21388h = str;
        this.f21389i = z10;
        this.f21390j = new dk.a(this);
        this.f21393m = new ReentrantReadWriteLock();
        List<String> list4 = k0.INSTANCE;
        this.f21394n = list4;
        this.f21395o = nm.h0.E4(s(), list3);
        ek.b bVarC = aVar2.c("ktor.application.modules");
        List<String> listB = bVarC == null ? null : bVarC.b();
        list4 = listB != null ? listB : list4;
        this.f21396p = list4;
        this.f21397q = list4;
        this.f21398r = lm.f0.b(C0543e.INSTANCE);
        this.f21399s = new dk.f();
    }

    @Override // yk.b
    @os.l
    public dk.a a() {
        return q();
    }

    @Override // dk.e
    @os.l
    public ek.a b() {
        return this.f21383c;
    }

    @Override // dk.e
    @os.l
    public dk.f c() {
        return this.f21399s;
    }

    @Override // yk.b
    @os.l
    public List<x> d() {
        return this.f21384d;
    }

    @Override // dk.e
    @os.l
    public String e() {
        return this.f21388h;
    }

    @Override // dk.e
    @os.l
    public ClassLoader f() {
        return this.f21381a;
    }

    @Override // dk.e
    @os.l
    public um.g g() {
        return this.f21387g;
    }

    @Override // dk.e
    public boolean h() {
        return this.f21389i;
    }

    @Override // dk.e
    @os.l
    public ps.a i() {
        return this.f21382b;
    }

    public final void l(jn.a<l2> aVar) {
        try {
            aVar.invoke();
            if (zk.a.d().get() == null) {
                return;
            }
        } finally {
            List<String> list = zk.a.d().get();
            if (list != null && list.isEmpty()) {
                zk.a.f21942a.remove();
            }
        }
    }

    public final void m(String str, jn.a<l2> aVar) {
        ThreadLocal<List<String>> threadLocalD = zk.a.d();
        List<String> arrayList = threadLocalD.get();
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            threadLocalD.set(arrayList);
        }
        List<String> list = arrayList;
        if (list.contains(str)) {
            throw new IllegalStateException(n.a.a("Module startup is already in progress for function ", str, " (recursive module startup from module main?)").toString());
        }
        list.add(str);
        try {
            aVar.invoke();
        } finally {
            list.remove(str);
        }
    }

    public final void n() throws IOException {
        try {
            WatchService watchServiceU = u();
            if (watchServiceU == null) {
                return;
            }
            watchServiceU.close();
        } catch (NoClassDefFoundError unused) {
        }
    }

    public final t0<dk.a, ClassLoader> o() throws IOException {
        ClassLoader classLoaderP = p();
        Thread threadCurrentThread = Thread.currentThread();
        ClassLoader contextClassLoader = threadCurrentThread.getContextClassLoader();
        threadCurrentThread.setContextClassLoader(classLoaderP);
        try {
            return new t0<>(v(classLoaderP), classLoaderP);
        } finally {
            threadCurrentThread.setContextClassLoader(contextClassLoader);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0154 A[PHI: r2
      0x0154: PHI (r2v5 java.util.List<java.lang.String>) = 
      (r2v2 java.util.List<java.lang.String>)
      (r2v7 java.util.List<java.lang.String>)
      (r2v2 java.util.List<java.lang.String>)
     binds: [B:31:0x0106, B:72:0x0154, B:35:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    public final ClassLoader p() throws IOException {
        List<String> list;
        ClassLoader classLoader = this.f21381a;
        if (!this.f21389i) {
            this.f21382b.info("Autoreload is disabled because the development mode is off.");
            return classLoader;
        }
        List<String> list2 = this.f21395o;
        if (list2.isEmpty()) {
            this.f21382b.info("No ktor.deployment.watch patterns specified, automatic reload is not active.");
            return classLoader;
        }
        Set<URL> setA = o.a(classLoader);
        String parent = new File(System.getProperty("java.home")).getParent();
        ArrayList arrayList = new ArrayList(nm.z.b0(setA, 10));
        Iterator<T> it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(((URL) it.next()).getFile());
        }
        this.f21382b.debug(l0.C("Java Home: ", parent));
        ps.a aVar = this.f21382b;
        StringBuilder sb2 = new StringBuilder("Class Loader: ");
        sb2.append(classLoader);
        sb2.append(": ");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String string = ((String) obj).toString();
            l0.o(parent, "jre");
            if (!jq.e0.s2(string, parent, false, 2, null)) {
                arrayList2.add(obj);
            }
        }
        sb2.append(arrayList2);
        aVar.debug(sb2.toString());
        List listO = nm.y.O(dk.e.class, yk.b.class, nl.e.class, r0.class, jn.l.class, ps.a.class, pl.k.class, tl.g0.class, fl.c.class);
        HashSet hashSet = new HashSet();
        Iterator it2 = listO.iterator();
        while (it2.hasNext()) {
            URL location = ((Class) it2.next()).getProtectionDomain().getCodeSource().getLocation();
            if (location != null) {
                hashSet.add(location);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : setA) {
            URL url = (URL) obj2;
            if (hashSet.contains(url)) {
                list = list2;
                break;
                break;
            }
            List<String> list3 = list2;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                list = list2;
                break;
                break;
            }
            Iterator<T> it3 = list3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    list = list2;
                    break;
                }
                String str = (String) it3.next();
                String string2 = url.toString();
                list = list2;
                l0.o(string2, "url.toString()");
                if (jq.h0.T2(string2, str, false, 2, null)) {
                    String path = url.getPath();
                    if (path == null) {
                        path = "";
                    }
                    l0.o(parent, "jre");
                    if (!jq.e0.s2(path, parent, false, 2, null)) {
                        arrayList3.add(obj2);
                        break;
                    }
                    break;
                }
                list2 = list;
            }
            list2 = list;
        }
        if (arrayList3.isEmpty()) {
            this.f21382b.info("No ktor.deployment.watch patterns match classpath entries, automatic reload is not active");
            return classLoader;
        }
        z(arrayList3);
        return new e0(arrayList3, classLoader);
    }

    public final dk.a q() {
        ReentrantReadWriteLock.ReadLock lock = this.f21393m.readLock();
        lock.lock();
        try {
            dk.a aVar = this.f21390j;
            if (aVar == null) {
                throw new IllegalStateException("ApplicationEngineEnvironment was not started");
            }
            if (this.f21389i) {
                List<? extends WatchKey> list = this.f21394n;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    List<WatchEvent<?>> listPollEvents = ((WatchKey) it.next()).pollEvents();
                    l0.o(listPollEvents, "it.pollEvents()");
                    nm.d0.r0(arrayList, listPollEvents);
                }
                if (!arrayList.isEmpty()) {
                    this.f21382b.info("Changes in application detected.");
                    int size = arrayList.size();
                    while (true) {
                        Thread.sleep(200L);
                        List<? extends WatchKey> list2 = this.f21394n;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<T> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            List<WatchEvent<?>> listPollEvents2 = ((WatchKey) it2.next()).pollEvents();
                            l0.o(listPollEvents2, "it.pollEvents()");
                            nm.d0.r0(arrayList2, listPollEvents2);
                        }
                        if (arrayList2.isEmpty()) {
                            break;
                        }
                        this.f21382b.debug("Waiting for more changes.");
                        size += arrayList2.size();
                    }
                    this.f21382b.debug("Changes to " + size + " files caused application restart.");
                    Iterator it3 = nm.h0.J5(arrayList, 5).iterator();
                    while (it3.hasNext()) {
                        this.f21382b.debug(l0.C("...  ", ((WatchEvent) it3.next()).context()));
                    }
                    ReentrantReadWriteLock reentrantReadWriteLock = this.f21393m;
                    ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
                    int i10 = 0;
                    int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                    int i11 = 0;
                    while (i11 < readHoldCount) {
                        i11++;
                        lock2.unlock();
                    }
                    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                    writeLock.lock();
                    try {
                        r();
                        t0<dk.a, ClassLoader> t0VarO = o();
                        dk.a aVarComponent1 = t0VarO.component1();
                        ClassLoader classLoaderComponent2 = t0VarO.component2();
                        this.f21390j = aVarComponent1;
                        this.f21392l = classLoaderComponent2;
                        l2 l2Var = l2.f10208a;
                        while (i10 < readHoldCount) {
                            i10++;
                            lock2.lock();
                        }
                        writeLock.unlock();
                        aVar = this.f21390j;
                        if (aVar == null) {
                            throw new IllegalStateException("ApplicationEngineEnvironment was not started");
                        }
                    } catch (Throwable th2) {
                        while (i10 < readHoldCount) {
                            i10++;
                            lock2.lock();
                        }
                        writeLock.unlock();
                        throw th2;
                    }
                }
            }
            lock.unlock();
            return aVar;
        } catch (Throwable th3) {
            lock.unlock();
            throw th3;
        }
    }

    public final void r() {
        dk.a aVar = this.f21390j;
        ClassLoader classLoader = this.f21392l;
        this.f21390j = null;
        this.f21392l = null;
        if (aVar != null) {
            y(dk.k.e(), aVar);
            try {
                aVar.X();
                e0 e0Var = classLoader instanceof e0 ? (e0) classLoader : null;
                if (e0Var != null) {
                    e0Var.close();
                }
            } catch (Throwable th2) {
                this.f21382b.error("Failed to destroy application instance.", th2);
            }
            y(dk.k.f3721e, aVar);
        }
        Iterator<T> it = this.f21394n.iterator();
        while (it.hasNext()) {
            ((WatchKey) it.next()).cancel();
        }
        this.f21394n = new ArrayList();
    }

    public final List<String> s() {
        ek.b bVarC = this.f21383c.c("ktor.deployment.watch");
        List<String> listB = bVarC == null ? null : bVarC.b();
        return listB == null ? k0.INSTANCE : listB;
    }

    @Override // yk.b
    public void start() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.f21393m;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i11 = 0;
        while (i11 < readHoldCount) {
            i11++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            try {
                t0<dk.a, ClassLoader> t0VarO = o();
                dk.a aVarComponent1 = t0VarO.component1();
                ClassLoader classLoaderComponent2 = t0VarO.component2();
                this.f21390j = aVarComponent1;
                this.f21392l = classLoaderComponent2;
                l2 l2Var = l2.f10208a;
                while (i10 < readHoldCount) {
                    i10++;
                    lock.lock();
                }
                writeLock.unlock();
            } catch (Throwable th2) {
                r();
                if (!this.f21395o.isEmpty()) {
                    n();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            while (i10 < readHoldCount) {
                i10++;
                lock.lock();
            }
            writeLock.unlock();
            throw th3;
        }
    }

    @Override // yk.b
    public void stop() throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = this.f21393m;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i11 = 0;
        while (i11 < readHoldCount) {
            i11++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            r();
            l2 l2Var = l2.f10208a;
            while (i10 < readHoldCount) {
                i10++;
                lock.lock();
            }
            writeLock.unlock();
            if (this.f21395o.isEmpty()) {
                return;
            }
            n();
        } catch (Throwable th2) {
            while (i10 < readHoldCount) {
                i10++;
                lock.lock();
            }
            writeLock.unlock();
            throw th2;
        }
    }

    @os.l
    public final List<String> t() {
        return this.f21397q;
    }

    public final WatchService u() {
        return (WatchService) this.f21398r.getValue();
    }

    public final dk.a v(ClassLoader classLoader) {
        dk.a aVar;
        if (this.f21391k || (aVar = this.f21390j) == null) {
            aVar = new dk.a(this);
        } else {
            this.f21391k = true;
            l0.m(aVar);
        }
        y(dk.k.b(), aVar);
        l(new b(classLoader, aVar));
        y(dk.k.f3718b, aVar);
        return aVar;
    }

    public final void w(String str, ClassLoader classLoader, dk.a aVar) {
        m(str, new c(classLoader, str, aVar));
    }

    public final void x() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.f21393m;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i11 = 0;
        while (i11 < readHoldCount) {
            i11++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            r();
            t0<dk.a, ClassLoader> t0VarO = o();
            dk.a aVarComponent1 = t0VarO.component1();
            ClassLoader classLoaderComponent2 = t0VarO.component2();
            this.f21390j = aVarComponent1;
            this.f21392l = classLoaderComponent2;
            l2 l2Var = l2.f10208a;
            while (i10 < readHoldCount) {
                i10++;
                lock.lock();
            }
        } finally {
            while (i10 < readHoldCount) {
                i10++;
                lock.lock();
            }
            writeLock.unlock();
        }
    }

    public final void y(dk.m<dk.a> mVar, dk.a aVar) {
        try {
            this.f21399s.a(mVar, aVar);
        } catch (Throwable th2) {
            this.f21382b.error("One or more of the handlers thrown an exception", th2);
        }
    }

    public final void z(List<URL> list) throws IOException {
        HashSet<Path> hashSet = new HashSet();
        Iterator<URL> it = list.iterator();
        while (it.hasNext()) {
            String path = it.next().getPath();
            if (path != null) {
                Path path2 = new File(URLDecoder.decode(path, "utf-8")).toPath();
                if (Files.exists(path2, new LinkOption[0])) {
                    d dVar = new d(hashSet);
                    if (Files.isDirectory(path2, new LinkOption[0])) {
                        Files.walkFileTree(path2, dVar);
                    }
                }
            }
        }
        for (Path path3 : hashSet) {
            this.f21382b.debug("Watching " + path3 + " for changes.");
        }
        WatchEvent.Modifier modifierE = zk.a.e();
        WatchEvent.Modifier[] modifierArr = modifierE == null ? null : new WatchEvent.Modifier[]{modifierE};
        if (modifierArr == null) {
            modifierArr = new WatchEvent.Modifier[0];
        }
        ArrayList arrayList = new ArrayList();
        for (Path path4 : hashSet) {
            WatchService watchServiceU = u();
            WatchKey watchKeyRegister = watchServiceU == null ? null : path4.register(watchServiceU, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY}, (WatchEvent.Modifier[]) Arrays.copyOf(modifierArr, modifierArr.length));
            if (watchKeyRegister != null) {
                arrayList.add(watchKeyRegister);
            }
        }
        this.f21394n = arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@os.l ClassLoader classLoader, @os.l ps.a aVar, @os.l ek.a aVar2, @os.l List<? extends x> list, @os.l List<? extends jn.l<? super dk.a, l2>> list2, @os.l List<String> list3, @os.l um.g gVar, @os.l String str) {
        this(classLoader, aVar, aVar2, list, list2, list3, gVar, str, true);
        l0.p(classLoader, "classLoader");
        l0.p(aVar, "log");
        l0.p(aVar2, "config");
        l0.p(list, "connectors");
        l0.p(list2, "modules");
        l0.p(list3, "watchPaths");
        l0.p(gVar, "parentCoroutineContext");
        l0.p(str, "rootPath");
    }

    public e(ClassLoader classLoader, ps.a aVar, ek.a aVar2, List list, List list2, List list3, um.g gVar, String str, int i10, kn.w wVar) {
        this(classLoader, aVar, aVar2, list, list2, (i10 & 32) != 0 ? k0.INSTANCE : list3, (i10 & 64) != 0 ? um.i.INSTANCE : gVar, (i10 & 128) != 0 ? "" : str);
    }

    public e(ClassLoader classLoader, ps.a aVar, ek.a aVar2, List list, List list2, List list3, um.g gVar, String str, boolean z10, int i10, kn.w wVar) {
        this(classLoader, aVar, aVar2, list, list2, (i10 & 32) != 0 ? k0.INSTANCE : list3, (i10 & 64) != 0 ? um.i.INSTANCE : gVar, (i10 & 128) != 0 ? "" : str, (i10 & 256) != 0 ? true : z10);
    }
}
