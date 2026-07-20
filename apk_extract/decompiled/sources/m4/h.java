package m4;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import k3.jb;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class h extends jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f7921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f7922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f7923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f7924d;
    public static final long e;
    public static final long f;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e4) {
                throw new RuntimeException("Could not initialize intrinsics", e4.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new g());
        }
        try {
            f7923c = unsafe.objectFieldOffset(j.class.getDeclaredField("c"));
            f7922b = unsafe.objectFieldOffset(j.class.getDeclaredField("b"));
            f7924d = unsafe.objectFieldOffset(j.class.getDeclaredField("a"));
            e = unsafe.objectFieldOffset(i.class.getDeclaredField("a"));
            f = unsafe.objectFieldOffset(i.class.getDeclaredField("b"));
            f7921a = unsafe;
        } catch (NoSuchFieldException e10) {
            throw new RuntimeException(e10);
        } catch (RuntimeException e11) {
            throw e11;
        }
    }

    @Override // k3.jb
    public final boolean a(j jVar, d dVar, d dVar2) {
        return f7921a.compareAndSwapObject(jVar, f7922b, dVar, dVar2);
    }

    @Override // k3.jb
    public final boolean b(j jVar, Object obj, Object obj2) {
        return f7921a.compareAndSwapObject(jVar, f7924d, obj, obj2);
    }

    @Override // k3.jb
    public final boolean c(j jVar, i iVar, i iVar2) {
        return f7921a.compareAndSwapObject(jVar, f7923c, iVar, iVar2);
    }

    @Override // k3.jb
    public final d d(j jVar) {
        d dVar;
        d dVar2 = d.f7913d;
        do {
            dVar = jVar.f7932b;
            if (dVar2 == dVar) {
                return dVar;
            }
        } while (!a(jVar, dVar, dVar2));
        return dVar;
    }

    @Override // k3.jb
    public final i e(j jVar) {
        i iVar;
        i iVar2 = i.f7925c;
        do {
            iVar = jVar.f7933c;
            if (iVar2 == iVar) {
                return iVar;
            }
        } while (!c(jVar, iVar, iVar2));
        return iVar;
    }

    @Override // k3.jb
    public final void f(i iVar, i iVar2) {
        f7921a.putObject(iVar, f, iVar2);
    }

    @Override // k3.jb
    public final void g(i iVar, Thread thread) {
        f7921a.putObject(iVar, e, thread);
    }
}
