package l3;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f7319a;

    public w2(Unsafe unsafe) {
        this.f7319a = unsafe;
    }

    public abstract double a(long j8, Object obj);

    public abstract float b(long j8, Object obj);

    public abstract void c(Object obj, long j8, boolean z2);

    public abstract void d(Object obj, long j8, byte b9);

    public abstract void e(Object obj, long j8, double d7);

    public abstract void f(Object obj, long j8, float f);

    public abstract boolean g(long j8, Object obj);
}
