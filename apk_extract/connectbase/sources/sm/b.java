package sm;

import an.f;
import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
@i(name = "ThreadsKt")
public final class b {

    public static final class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.a<l2> f15172a;

        public a(jn.a<l2> aVar) {
            this.f15172a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f15172a.invoke();
        }
    }

    @f
    public static final <T> T a(ThreadLocal<T> threadLocal, jn.a<? extends T> aVar) {
        l0.p(threadLocal, "<this>");
        l0.p(aVar, ks.c.f9460f);
        T t10 = threadLocal.get();
        if (t10 != null) {
            return t10;
        }
        T tInvoke = aVar.invoke();
        threadLocal.set(tInvoke);
        return tInvoke;
    }

    @l
    public static final Thread b(boolean z10, boolean z11, @m ClassLoader classLoader, @m String str, int i10, @l jn.a<l2> aVar) {
        l0.p(aVar, "block");
        a aVar2 = new a(aVar);
        if (z11) {
            aVar2.setDaemon(true);
        }
        if (i10 > 0) {
            aVar2.setPriority(i10);
        }
        if (str != null) {
            aVar2.setName(str);
        }
        if (classLoader != null) {
            aVar2.setContextClassLoader(classLoader);
        }
        if (z10) {
            aVar2.start();
        }
        return aVar2;
    }

    public static /* synthetic */ Thread c(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, jn.a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        boolean z12 = z10;
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        boolean z13 = z11;
        ClassLoader classLoader2 = (i11 & 4) != 0 ? null : classLoader;
        String str2 = (i11 & 8) != 0 ? null : str;
        if ((i11 & 16) != 0) {
            i10 = -1;
        }
        return b(z12, z13, classLoader2, str2, i10, aVar);
    }
}
