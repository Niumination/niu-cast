package vq;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.r1;
import lm.l2;
import nq.g2;
import vq.f1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
@g2
public class e1<T extends f1 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f17833b = AtomicIntegerFieldUpdater.newUpdater(e1.class, "_size");

    @in.x
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public T[] f17834a;

    @lm.z0
    public final void a(@os.l T t10) {
        t10.d(this);
        f1[] f1VarArrJ = j();
        int i10 = f17833b.get(this);
        o(i10 + 1);
        f1VarArrJ[i10] = t10;
        t10.h(i10);
        q(i10);
    }

    public final void b(@os.l T t10) {
        synchronized (this) {
            a(t10);
            l2 l2Var = l2.f10208a;
        }
    }

    public final boolean c(@os.l T t10, @os.l jn.l<? super T, Boolean> lVar) {
        boolean z10;
        synchronized (this) {
            if (lVar.invoke(f()).booleanValue()) {
                a(t10);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public final void d() {
        synchronized (this) {
            try {
                T[] tArr = this.f17834a;
                if (tArr != null) {
                    nm.p.V1(tArr, null, 0, 0, 6, null);
                }
                f17833b.set(this, 0);
                l2 l2Var = l2.f10208a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @os.m
    public final T e(@os.l jn.l<? super T, Boolean> lVar) {
        T t10;
        synchronized (this) {
            try {
                int i10 = f17833b.get(this);
                int i11 = 0;
                while (true) {
                    t10 = null;
                    if (i11 >= i10) {
                        break;
                    }
                    T[] tArr = this.f17834a;
                    if (tArr != null) {
                        t10 = (Object) tArr[i11];
                    }
                    kn.l0.m(t10);
                    if (lVar.invoke(t10).booleanValue()) {
                        break;
                    }
                    i11++;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t10;
    }

    @os.m
    @lm.z0
    public final T f() {
        T[] tArr = this.f17834a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int g() {
        return f17833b.get(this);
    }

    public final boolean h() {
        return f17833b.get(this) == 0;
    }

    @os.m
    public final T i() {
        T t10;
        synchronized (this) {
            t10 = (T) f();
        }
        return t10;
    }

    public final T[] j() {
        T[] tArr = this.f17834a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new f1[4];
            this.f17834a = tArr2;
            return tArr2;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17833b;
        if (atomicIntegerFieldUpdater.get(this) < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, atomicIntegerFieldUpdater.get(this) * 2);
        kn.l0.o(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((f1[]) objArrCopyOf);
        this.f17834a = tArr3;
        return tArr3;
    }

    public final boolean k(@os.l T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.b() == null) {
                z10 = false;
            } else {
                l(t10.f());
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003c  */
    @lm.z0
    @os.l
    public final T l(int i10) {
        T[] tArr = this.f17834a;
        kn.l0.m(tArr);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17833b;
        o(atomicIntegerFieldUpdater.get(this) - 1);
        if (i10 < atomicIntegerFieldUpdater.get(this)) {
            r(i10, atomicIntegerFieldUpdater.get(this));
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                T t10 = tArr[i10];
                kn.l0.m(t10);
                T t11 = tArr[i11];
                kn.l0.m(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    r(i10, i11);
                    q(i11);
                } else {
                    p(i10);
                }
            } else {
                p(i10);
            }
        }
        T t12 = tArr[atomicIntegerFieldUpdater.get(this)];
        kn.l0.m(t12);
        t12.d(null);
        t12.h(-1);
        tArr[atomicIntegerFieldUpdater.get(this)] = null;
        return t12;
    }

    @os.m
    public final T m(@os.l jn.l<? super T, Boolean> lVar) {
        synchronized (this) {
            f1 f1VarF = f();
            T t10 = null;
            if (f1VarF == null) {
                return null;
            }
            if (lVar.invoke(f1VarF).booleanValue()) {
                t10 = (T) l(0);
            }
            return t10;
        }
    }

    @os.m
    public final T n() {
        T t10;
        synchronized (this) {
            t10 = f17833b.get(this) > 0 ? (T) l(0) : null;
        }
        return t10;
    }

    public final void o(int i10) {
        f17833b.set(this, i10);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    public final void p(int i10) {
        while (true) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17833b;
            if (i12 >= atomicIntegerFieldUpdater.get(this)) {
                return;
            }
            T[] tArr = this.f17834a;
            kn.l0.m(tArr);
            int i13 = i11 + 2;
            if (i13 < atomicIntegerFieldUpdater.get(this)) {
                T t10 = tArr[i13];
                kn.l0.m(t10);
                T t11 = tArr[i12];
                kn.l0.m(t11);
                if (((Comparable) t10).compareTo(t11) >= 0) {
                    i13 = i12;
                }
            } else {
                i13 = i12;
            }
            T t12 = tArr[i10];
            kn.l0.m(t12);
            T t13 = tArr[i13];
            kn.l0.m(t13);
            if (((Comparable) t12).compareTo(t13) <= 0) {
                return;
            }
            r(i10, i13);
            i10 = i13;
        }
    }

    public final void q(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f17834a;
            kn.l0.m(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            kn.l0.m(t10);
            T t11 = tArr[i10];
            kn.l0.m(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            r(i10, i11);
            i10 = i11;
        }
    }

    public final void r(int i10, int i11) {
        T[] tArr = this.f17834a;
        kn.l0.m(tArr);
        T t10 = tArr[i11];
        kn.l0.m(t10);
        T t11 = tArr[i10];
        kn.l0.m(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.h(i10);
        t11.h(i11);
    }
}
