package nh;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements d {
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(c.class, "top");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceArray f8282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f8283d;
    private volatile /* synthetic */ long top;

    public c(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "capacity should be positive but it is ").toString());
        }
        if (i8 > 536870911) {
            throw new IllegalArgumentException(a1.a.o(i8, "capacity should be less or equal to 536870911 but it is ").toString());
        }
        this.top = 0L;
        int iHighestOneBit = Integer.highestOneBit((i8 * 4) - 1) * 2;
        this.f8280a = iHighestOneBit;
        this.f8281b = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
        int i9 = iHighestOneBit + 1;
        this.f8282c = new AtomicReferenceArray(i9);
        this.f8283d = new int[i9];
    }

    @Override // nh.d
    public final Object R() {
        Object objA;
        Object objG = g();
        return (objG == null || (objA = a(objG)) == null) ? c() : objA;
    }

    public Object a(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        return instance;
    }

    public abstract Object c();

    @Override // java.lang.AutoCloseable
    public final void close() {
        while (true) {
            Object instance = g();
            if (instance == null) {
                return;
            } else {
                Intrinsics.checkNotNullParameter(instance, "instance");
            }
        }
    }

    public final Object g() {
        int i8;
        while (true) {
            long j8 = this.top;
            i8 = 0;
            if (j8 == 0) {
                break;
            }
            long j10 = ((j8 >> 32) & 4294967295L) + 1;
            int i9 = (int) (4294967295L & j8);
            if (i9 == 0) {
                break;
            }
            if (e.compareAndSet(this, j8, (j10 << 32) | ((long) this.f8283d[i9]))) {
                i8 = i9;
                break;
            }
        }
        if (i8 == 0) {
            return null;
        }
        return this.f8282c.getAndSet(i8, null);
    }

    public void h(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // nh.d
    public final void h0(Object instance) {
        long j8;
        long j10;
        Intrinsics.checkNotNullParameter(instance, "instance");
        h(instance);
        int iIdentityHashCode = ((System.identityHashCode(instance) * (-1640531527)) >>> this.f8281b) + 1;
        for (int i8 = 0; i8 < 8; i8++) {
            if (this.f8282c.compareAndSet(iIdentityHashCode, null, instance)) {
                if (iIdentityHashCode <= 0) {
                    throw new IllegalArgumentException("index should be positive");
                }
                do {
                    j8 = this.top;
                    j10 = ((((j8 >> 32) & 4294967295L) + 1) << 32) | ((long) iIdentityHashCode);
                    this.f8283d[iIdentityHashCode] = (int) (4294967295L & j8);
                } while (!e.compareAndSet(this, j8, j10));
                return;
            }
            iIdentityHashCode--;
            if (iIdentityHashCode == 0) {
                iIdentityHashCode = this.f8280a;
            }
        }
        Intrinsics.checkNotNullParameter(instance, "instance");
    }
}
