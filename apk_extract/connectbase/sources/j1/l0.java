package j1;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@l
public abstract class l0 extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f8422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f8423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f8424c;
    volatile transient long base;
    volatile transient int busy;

    @gm.a
    volatile transient b[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    public class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Unsafe f8425p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final long f8426q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f8427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile long f8428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile long f8429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f8430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f8431e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile long f8432f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile long f8433g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile long f8434h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile long f8435i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile long f8436j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public volatile long f8437k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public volatile long f8438l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile long f8439m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public volatile long f8440n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile long f8441o;

        static {
            try {
                Unsafe unsafeA = l0.a();
                f8425p = unsafeA;
                f8426q = unsafeA.objectFieldOffset(b.class.getDeclaredField("h"));
            } catch (Exception e10) {
                throw new Error(e10);
            }
        }

        public b(long x10) {
            this.f8434h = x10;
        }

        public final boolean a(long cmp, long val) {
            return f8425p.compareAndSwapLong(this, f8426q, cmp, val);
        }
    }

    static {
        try {
            Unsafe unsafeA = a();
            f8422a = unsafeA;
            f8423b = unsafeA.objectFieldOffset(l0.class.getDeclaredField("base"));
            f8424c = unsafeA.objectFieldOffset(l0.class.getDeclaredField("busy"));
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    public static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e10) {
                throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    public final boolean casBase(long cmp, long val) {
        return f8422a.compareAndSwapLong(this, f8423b, cmp, val);
    }

    public final boolean casBusy() {
        return f8422a.compareAndSwapInt(this, f8424c, 0, 1);
    }

    public abstract long fn(long currentValue, long newValue);

    public final void internalReset(long initialValue) {
        b[] bVarArr = this.cells;
        this.base = initialValue;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f8434h = initialValue;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    public final void retryUpdate(long x10, @gm.a int[] hc2, boolean wasUncontended) {
        int iNextInt;
        int[] iArr;
        boolean z10;
        int length;
        boolean z11;
        int length2;
        if (hc2 == null) {
            iArr = new int[1];
            threadHashCode.set(iArr);
            iNextInt = rng.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr[0] = iNextInt;
        } else {
            iNextInt = hc2[0];
            iArr = hc2;
        }
        boolean z12 = false;
        int i10 = iNextInt;
        boolean z13 = wasUncontended;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i10];
                if (bVar == null) {
                    if (this.busy == 0) {
                        b bVar2 = new b(x10);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                b[] bVarArr2 = this.cells;
                                if (bVarArr2 == null || (length2 = bVarArr2.length) <= 0) {
                                    z11 = false;
                                } else {
                                    int i11 = (length2 - 1) & i10;
                                    if (bVarArr2[i11] == null) {
                                        bVarArr2[i11] = bVar2;
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                }
                                this.busy = 0;
                                if (z11) {
                                    return;
                                }
                            } catch (Throwable th2) {
                                this.busy = 0;
                                throw th2;
                            }
                        }
                    }
                    z12 = false;
                    int i12 = i10 ^ (i10 << 13);
                    int i13 = i12 ^ (i12 >>> 17);
                    i10 = i13 ^ (i13 << 5);
                    iArr[0] = i10;
                } else {
                    if (z13) {
                        long j10 = bVar.f8434h;
                        if (bVar.a(j10, fn(j10, x10))) {
                            return;
                        }
                        if (length >= NCPU || this.cells != bVarArr) {
                            z12 = false;
                        } else if (!z12) {
                            z12 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == bVarArr) {
                                    b[] bVarArr3 = new b[length << 1];
                                    for (int i14 = 0; i14 < length; i14++) {
                                        bVarArr3[i14] = bVarArr[i14];
                                    }
                                    this.cells = bVarArr3;
                                }
                                this.busy = 0;
                                z12 = false;
                            } catch (Throwable th3) {
                                this.busy = 0;
                                throw th3;
                            }
                        }
                    } else {
                        z13 = true;
                    }
                    int i15 = i10 ^ (i10 << 13);
                    int i16 = i15 ^ (i15 >>> 17);
                    i10 = i16 ^ (i16 << 5);
                    iArr[0] = i10;
                }
            } else if (this.busy == 0 && this.cells == bVarArr && casBusy()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i10 & 1] = new b(x10);
                        this.cells = bVarArr4;
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.busy = 0;
                    if (z10) {
                        return;
                    }
                } catch (Throwable th4) {
                    this.busy = 0;
                    throw th4;
                }
            } else {
                long j11 = this.base;
                if (casBase(j11, fn(j11, x10))) {
                    return;
                }
            }
        }
    }
}
