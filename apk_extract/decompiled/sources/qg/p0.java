package qg;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mg.b0 f9091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yf.c f9092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f9093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ng.c f9094d;
    public final ReentrantReadWriteLock e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ClassLoader f9095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f9096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f9097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f9098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f9099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f9100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public mg.a f9101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ng.p f9102n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f9103o;

    public p0(mg.b0 rootConfig, ag.d0 configure) {
        ng.a engineFactory = ng.a.f8235a;
        Intrinsics.checkNotNullParameter(rootConfig, "rootConfig");
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(configure, "engineConfigBlock");
        this.f9091a = rootConfig;
        b environment = (b) rootConfig.f8047b;
        yf.c monitor = environment.f9066d;
        this.f9092b = monitor;
        this.f9093c = environment;
        Intrinsics.checkNotNullParameter(configure, "configure");
        ng.c configuration = new ng.c();
        Runtime.getRuntime().availableProcessors();
        configuration.f8251a = 1000L;
        configuration.f8252b = new ArrayList();
        configuration.f8253c = 45;
        configure.invoke(configuration);
        this.f9094d = configuration;
        this.e = new ReentrantReadWriteLock();
        this.f9096h = CollectionsKt.emptyList();
        pg.b bVar = environment.f9065c;
        sj.a aVarA = bVar.a("ktor.deployment.watch");
        List listH = aVarA != null ? aVarA.h() : null;
        listH = listH == null ? CollectionsKt.emptyList() : listH;
        this.f9097i = listH;
        this.f9098j = CollectionsKt.plus((Collection) listH, (Iterable) rootConfig.f8049d);
        sj.a aVarA2 = bVar.a("ktor.application.modules");
        List listH2 = aVarA2 != null ? aVarA2.h() : CollectionsKt.emptyList();
        this.f9099k = listH2;
        this.f9100l = listH2;
        this.f9101m = new mg.a(environment, rootConfig.f8046a, (String) rootConfig.e, monitor, (CoroutineContext) rootConfig.f, new PropertyReference0Impl(this) { // from class: qg.k0
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((p0) this.receiver).f9102n;
            }
        });
        l0 applicationProvider = new l0(this);
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(applicationProvider, "applicationProvider");
        this.f9102n = new ng.p(environment, monitor, rootConfig.f8046a, configuration, applicationProvider);
        this.f9103o = LazyKt.lazy(new ob.c(10));
    }

    public static void e(ClassLoader classLoader, String str, mg.a aVar) {
        j0 j0Var = new j0(classLoader, str, aVar);
        ThreadLocal threadLocal = rg.a.f9434a;
        Object arrayList = threadLocal.get();
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            threadLocal.set(arrayList);
        }
        List list = (List) arrayList;
        if (list.contains(str)) {
            throw new IllegalStateException(h0.a.j("Module startup is already in progress for function ", str, " (recursive module startup from module main?)").toString());
        }
        list.add(str);
        try {
            j0Var.invoke();
        } finally {
            list.remove(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0166  */
    /* JADX WARN: Code duplicated, block: B:89:0x0210  */
    public final Pair a() throws IOException {
        WatchEvent.Modifier modifier;
        Object objM159constructorimpl;
        boolean z2;
        boolean z3;
        char c9;
        String strReplace$default;
        b bVar = this.f9093c;
        mg.b0 b0Var = this.f9091a;
        vj.b bVar2 = bVar.f9064b;
        ClassLoader w0Var = bVar.f9063a;
        if (b0Var.f8046a) {
            List list = this.f9098j;
            if (list.isEmpty()) {
                bVar2.info("No ktor.deployment.watch patterns specified, automatic reload is not active.");
            } else {
                Set setC = h.c(w0Var);
                String parent = new File(System.getProperty("java.home")).getParent();
                ArrayList arrayList = new ArrayList(CollectionsKt.i(setC));
                Iterator it = setC.iterator();
                while (it.hasNext()) {
                    arrayList.add(((URL) it.next()).getFile());
                }
                bVar2.debug("Java Home: " + parent);
                StringBuilder sb2 = new StringBuilder("Class Loader: ");
                sb2.append(w0Var);
                sb2.append(": ");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    String string = ((String) obj).toString();
                    Intrinsics.checkNotNull(parent);
                    if (!StringsKt__StringsJVMKt.startsWith$default(string, parent, false, 2, null)) {
                        arrayList2.add(obj);
                    }
                }
                sb2.append(arrayList2);
                bVar2.debug(sb2.toString());
                List listListOf = CollectionsKt.listOf((Object[]) new Class[]{mg.d.class, hh.e.class, zf.z.class, Function1.class, vj.b.class, jh.o.class, wi.k.class, zg.h.class});
                HashSet hashSet = new HashSet();
                Iterator it2 = listListOf.iterator();
                while (it2.hasNext()) {
                    URL location = ((Class) it2.next()).getProtectionDomain().getCodeSource().getLocation();
                    if (location != null) {
                        hashSet.add(location);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : setC) {
                    URL url = (URL) obj2;
                    if (hashSet.contains(url)) {
                        z2 = false;
                    } else {
                        List list2 = list;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator it3 = list2.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    z3 = false;
                                    break;
                                }
                                String pattern = (String) it3.next();
                                Intrinsics.checkNotNullParameter(url, "url");
                                Intrinsics.checkNotNullParameter(pattern, "pattern");
                                String path = url.getPath();
                                if ((path == null || (strReplace$default = StringsKt__StringsJVMKt.replace$default(path, (c9 = File.separatorChar), '/', false, 4, (Object) null)) == null) ? false : StringsKt__StringsKt.contains(strReplace$default, (CharSequence) StringsKt__StringsJVMKt.replace$default(pattern, c9, '/', false, 4, (Object) null), true)) {
                                    z3 = true;
                                    break;
                                }
                            }
                        } else {
                            z3 = false;
                            break;
                        }
                        if (z3) {
                            String path2 = url.getPath();
                            if (path2 == null) {
                                path2 = "";
                            }
                            Intrinsics.checkNotNull(parent);
                            if (StringsKt__StringsJVMKt.startsWith$default(path2, parent, false, 2, null)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        arrayList3.add(obj2);
                    }
                }
                if (arrayList3.isEmpty()) {
                    bVar2.info("No ktor.deployment.watch patterns match classpath entries, automatic reload is not active");
                } else {
                    HashSet<Path> hashSet2 = new HashSet();
                    Iterator it4 = arrayList3.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        String path3 = ((URL) it4.next()).getPath();
                        if (path3 != null) {
                            String strDecode = URLDecoder.decode(path3, "utf-8");
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                objM159constructorimpl = Result.m159constructorimpl(new File(strDecode).toPath());
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
                            }
                            Path path4 = (Path) (Result.m165isFailureimpl(objM159constructorimpl) ? null : objM159constructorimpl);
                            if (path4 != null && Files.exists(path4, new LinkOption[0])) {
                                o0 o0Var = new o0(hashSet2);
                                if (Files.isDirectory(path4, new LinkOption[0])) {
                                    Files.walkFileTree(path4, o0Var);
                                }
                            }
                        }
                    }
                    Iterator it5 = hashSet2.iterator();
                    while (it5.hasNext()) {
                        bVar2.debug("Watching " + ((Path) it5.next()) + " for changes.");
                    }
                    ThreadLocal threadLocal = rg.a.f9434a;
                    if (System.getenv("ANDROID_DATA") != null) {
                        modifier = null;
                    } else {
                        try {
                            Class<?> cls = Class.forName("com.sun.nio.file.SensitivityWatchEventModifier");
                            Object obj3 = cls.getField("HIGH").get(cls);
                            if (obj3 instanceof WatchEvent.Modifier) {
                                modifier = (WatchEvent.Modifier) obj3;
                            } else {
                                modifier = null;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    WatchEvent.Modifier[] modifierArr = modifier != null ? new WatchEvent.Modifier[]{modifier} : new WatchEvent.Modifier[0];
                    ArrayList arrayList4 = new ArrayList();
                    for (Path path5 : hashSet2) {
                        WatchService watchService = (WatchService) this.f9103o.getValue();
                        WatchKey watchKeyRegister = watchService != null ? path5.register(watchService, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY}, (WatchEvent.Modifier[]) Arrays.copyOf(modifierArr, modifierArr.length)) : null;
                        if (watchKeyRegister != null) {
                            arrayList4.add(watchKeyRegister);
                        }
                    }
                    this.f9096h = arrayList4;
                    w0Var = new w0(arrayList3, w0Var);
                }
            }
        } else {
            bVar2.info("Autoreload is disabled because the development mode is off.");
        }
        Thread threadCurrentThread = Thread.currentThread();
        ClassLoader contextClassLoader = threadCurrentThread.getContextClassLoader();
        threadCurrentThread.setContextClassLoader(w0Var);
        try {
            return TuplesKt.to(d(w0Var), w0Var);
        } finally {
            threadCurrentThread.setContextClassLoader(contextClassLoader);
        }
    }

    public final mg.a b() {
        vj.b bVar = this.f9093c.f9064b;
        ReentrantReadWriteLock reentrantReadWriteLock = this.e;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            mg.a aVar = this.f9101m;
            if (aVar == null) {
                throw new IllegalStateException("EmbeddedServer was stopped");
            }
            if (this.f9091a.f8046a) {
                List list = this.f9096h;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    List<WatchEvent<?>> listPollEvents = ((WatchKey) it.next()).pollEvents();
                    Intrinsics.checkNotNullExpressionValue(listPollEvents, "pollEvents(...)");
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, listPollEvents);
                }
                if (!arrayList.isEmpty()) {
                    bVar.info("Changes in application detected.");
                    int size = arrayList.size();
                    while (true) {
                        Thread.sleep(200L);
                        List list2 = this.f9096h;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            List<WatchEvent<?>> listPollEvents2 = ((WatchKey) it2.next()).pollEvents();
                            Intrinsics.checkNotNullExpressionValue(listPollEvents2, "pollEvents(...)");
                            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, listPollEvents2);
                        }
                        if (arrayList2.isEmpty()) {
                            break;
                        }
                        bVar.debug("Waiting for more changes.");
                        size += arrayList2.size();
                    }
                    bVar.debug("Changes to " + size + " files caused application restart.");
                    Iterator it3 = CollectionsKt.take(arrayList, 5).iterator();
                    while (it3.hasNext()) {
                        bVar.debug("...  " + ((WatchEvent) it3.next()).context());
                    }
                    ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
                    int i8 = 0;
                    int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                    for (int i9 = 0; i9 < readHoldCount; i9++) {
                        lock2.unlock();
                    }
                    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                    writeLock.lock();
                    try {
                        c();
                        Pair pairA = a();
                        mg.a aVar2 = (mg.a) pairA.component1();
                        ClassLoader classLoader = (ClassLoader) pairA.component2();
                        this.f9101m = aVar2;
                        this.f9095g = classLoader;
                        Unit unit = Unit.INSTANCE;
                        while (i8 < readHoldCount) {
                            lock2.lock();
                            i8++;
                        }
                        writeLock.unlock();
                        aVar = this.f9101m;
                        if (aVar == null) {
                            throw new IllegalStateException("EmbeddedServer was stopped");
                        }
                    } catch (Throwable th2) {
                        while (i8 < readHoldCount) {
                            lock2.lock();
                            i8++;
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

    public final void c() {
        mg.a aVar = this.f9101m;
        ClassLoader classLoader = this.f9095g;
        this.f9101m = null;
        this.f9095g = null;
        if (aVar != null) {
            yf.a definition = mg.l.e;
            yf.c cVar = this.f9092b;
            Intrinsics.checkNotNullParameter(cVar, "<this>");
            Intrinsics.checkNotNullParameter(definition, "definition");
            try {
                cVar.a(definition, aVar);
            } catch (Throwable unused) {
            }
            try {
                aVar.s();
                w0 w0Var = classLoader instanceof w0 ? (w0) classLoader : null;
                if (w0Var != null) {
                    w0Var.close();
                }
            } catch (Throwable th2) {
                this.f9093c.f9064b.error("Failed to destroy application instance.", th2);
            }
            yf.a definition2 = mg.l.f;
            Intrinsics.checkNotNullParameter(cVar, "<this>");
            Intrinsics.checkNotNullParameter(definition2, "definition");
            try {
                cVar.a(definition2, aVar);
            } catch (Throwable unused2) {
            }
        }
        Iterator it = this.f9096h.iterator();
        while (it.hasNext()) {
            ((WatchKey) it.next()).cancel();
        }
        this.f9096h = new ArrayList();
    }

    public final mg.a d(ClassLoader classLoader) {
        mg.a aVar;
        if (this.f || (aVar = this.f9101m) == null) {
            mg.b0 b0Var = this.f9091a;
            aVar = new mg.a(this.f9093c, b0Var.f8046a, (String) b0Var.e, this.f9092b, (CoroutineContext) b0Var.f, new PropertyReference0Impl(this) { // from class: qg.m0
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((p0) this.receiver).f9102n;
                }
            });
        } else {
            this.f = true;
            Intrinsics.checkNotNull(aVar);
        }
        yf.a definition = mg.l.f8071a;
        yf.c cVar = this.f9092b;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(definition, "definition");
        try {
            cVar.a(definition, aVar);
        } catch (Throwable unused) {
        }
        try {
            new j0(this, 0, classLoader, aVar).invoke();
            ThreadLocal threadLocal = rg.a.f9434a;
            List list = (List) threadLocal.get();
            if (list != null && list.isEmpty()) {
                threadLocal.remove();
            }
            yf.a definition2 = mg.l.f8072b;
            Intrinsics.checkNotNullParameter(cVar, "<this>");
            Intrinsics.checkNotNullParameter(definition2, "definition");
            try {
                cVar.a(definition2, aVar);
            } catch (Throwable unused2) {
            }
            return aVar;
        } catch (Throwable th2) {
            List list2 = (List) rg.a.f9434a.get();
            if (list2 != null && list2.isEmpty()) {
                rg.a.f9434a.remove();
            }
            throw th2;
        }
    }

    public final void f(boolean z2) {
        ag.a stop = new ag.a(this, 13);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(stop, "stop");
        if (i1.f9082a) {
            this.f9092b.b(mg.l.f8071a, new gi.a(10, this, stop));
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.e;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i8 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i9 = 0; i9 < readHoldCount; i9++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            try {
                Pair pairA = a();
                mg.a aVar = (mg.a) pairA.component1();
                ClassLoader classLoader = (ClassLoader) pairA.component2();
                this.f9101m = aVar;
                this.f9095g = classLoader;
                Unit unit = Unit.INSTANCE;
                while (i8 < readHoldCount) {
                    lock.lock();
                    i8++;
                }
                writeLock.unlock();
                li.l0.p(li.h0.a(b().u), null, null, new n0(this, null), 3);
                ng.p pVar = this.f9102n;
                pVar.getClass();
            } catch (Throwable th2) {
                while (i8 < readHoldCount) {
                    lock.lock();
                    i8++;
                }
                writeLock.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            c();
            if (!this.f9098j.isEmpty()) {
                try {
                    WatchService watchService = (WatchService) this.f9103o.getValue();
                    if (watchService != null) {
                        watchService.close();
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw th3;
        }
    }

    public final void g(long j8, long j10) throws Throwable {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            ng.p pVar = this.f9102n;
            long millis = timeUnit.toMillis(j8);
            long millis2 = timeUnit.toMillis(j10);
            pVar.getClass();
            li.l0.q(new ng.l(pVar, millis, millis2, null));
        } catch (Exception e) {
            this.f9093c.f9064b.warn("Exception occurred during engine shutdown", e);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = this.e;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i8 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i9 = 0; i9 < readHoldCount; i9++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            c();
            Unit unit = Unit.INSTANCE;
            while (i8 < readHoldCount) {
                lock.lock();
                i8++;
            }
            writeLock.unlock();
            if (this.f9098j.isEmpty()) {
                return;
            }
            try {
                WatchService watchService = (WatchService) this.f9103o.getValue();
                if (watchService != null) {
                    watchService.close();
                }
            } catch (NoClassDefFoundError unused) {
            }
        } catch (Throwable th2) {
            while (i8 < readHoldCount) {
                lock.lock();
                i8++;
            }
            writeLock.unlock();
            throw th2;
        }
    }
}
