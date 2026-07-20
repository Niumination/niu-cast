package cj;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1466a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecutorService f1468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorService f1469d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f1470a = new f();
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() <= 3 ? 1 : Runtime.getRuntime().availableProcessors() / 2;
        f1467b = iAvailableProcessors;
        f1468c = Executors.newFixedThreadPool(iAvailableProcessors);
        f1469d = Executors.newFixedThreadPool(iAvailableProcessors);
    }

    public f() {
    }

    public static f a() {
        return b.f1470a;
    }

    public Future b(cj.b bVar) {
        dj.c.b(bVar, "task == null");
        return f1468c.submit(bVar);
    }

    public f(a aVar) {
    }
}
