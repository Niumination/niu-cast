package qi;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import li.c1;
import li.d1;

/* JADX INFO: loaded from: classes3.dex */
public class a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9129b = AtomicIntegerFieldUpdater.newUpdater(a0.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c1[] f9130a;

    public final void a(c1 c1Var) {
        c1Var.b((d1) this);
        c1[] c1VarArr = this.f9130a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9129b;
        if (c1VarArr == null) {
            c1VarArr = new c1[4];
            this.f9130a = c1VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= c1VarArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(c1VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            c1VarArr = (c1[]) objArrCopyOf;
            this.f9130a = c1VarArr;
        }
        int i8 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i8 + 1);
        c1VarArr[i8] = c1Var;
        c1Var.f7439b = i8;
        c(i8);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0045  */
    /* JADX WARN: Code duplicated, block: B:14:0x0052  */
    /* JADX WARN: Code duplicated, block: B:17:0x0063  */
    /* JADX WARN: Code duplicated, block: B:21:0x0075 A[LOOP:0: B:9:0x003a->B:21:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x007a A[EDGE_INSN: B:24:0x007a->B:22:0x007a BREAK  A[LOOP:0: B:9:0x003a->B:21:0x0075], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x007a A[EDGE_INSN: B:25:0x007a->B:22:0x007a BREAK  A[LOOP:0: B:9:0x003a->B:21:0x0075], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:? A[SYNTHETIC] */
    public final c1 b(int i8) {
        int i9;
        int i10;
        Object[] objArr;
        int i11;
        Comparable comparable;
        Comparable comparable2;
        Comparable comparable3;
        Object obj;
        Object[] objArr2 = this.f9130a;
        Intrinsics.checkNotNull(objArr2);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9129b;
        atomicIntegerFieldUpdater.set(this, atomicIntegerFieldUpdater.get(this) - 1);
        if (i8 < atomicIntegerFieldUpdater.get(this)) {
            d(i8, atomicIntegerFieldUpdater.get(this));
            int i12 = (i8 - 1) / 2;
            if (i8 > 0) {
                c1 c1Var = objArr2[i8];
                Intrinsics.checkNotNull(c1Var);
                Object obj2 = objArr2[i12];
                Intrinsics.checkNotNull(obj2);
                if (c1Var.compareTo(obj2) < 0) {
                    d(i8, i12);
                    c(i12);
                } else {
                    while (true) {
                        i9 = i8 * 2;
                        i10 = i9 + 1;
                        if (i10 >= atomicIntegerFieldUpdater.get(this)) {
                            break;
                        }
                        objArr = this.f9130a;
                        Intrinsics.checkNotNull(objArr);
                        i11 = i9 + 2;
                        if (i11 < atomicIntegerFieldUpdater.get(this)) {
                            comparable3 = objArr[i11];
                            Intrinsics.checkNotNull(comparable3);
                            obj = objArr[i10];
                            Intrinsics.checkNotNull(obj);
                            if (comparable3.compareTo(obj) >= 0) {
                                i11 = i10;
                            }
                        } else {
                            i11 = i10;
                        }
                        comparable = objArr[i8];
                        Intrinsics.checkNotNull(comparable);
                        comparable2 = objArr[i11];
                        Intrinsics.checkNotNull(comparable2);
                        if (comparable.compareTo(comparable2) <= 0) {
                            break;
                        }
                        d(i8, i11);
                        i8 = i11;
                    }
                }
            } else {
                while (true) {
                    i9 = i8 * 2;
                    i10 = i9 + 1;
                    if (i10 >= atomicIntegerFieldUpdater.get(this)) {
                        break;
                        break;
                    }
                    objArr = this.f9130a;
                    Intrinsics.checkNotNull(objArr);
                    i11 = i9 + 2;
                    if (i11 < atomicIntegerFieldUpdater.get(this)) {
                        comparable3 = objArr[i11];
                        Intrinsics.checkNotNull(comparable3);
                        obj = objArr[i10];
                        Intrinsics.checkNotNull(obj);
                        if (comparable3.compareTo(obj) >= 0) {
                            i11 = i10;
                        }
                    } else {
                        i11 = i10;
                    }
                    comparable = objArr[i8];
                    Intrinsics.checkNotNull(comparable);
                    comparable2 = objArr[i11];
                    Intrinsics.checkNotNull(comparable2);
                    if (comparable.compareTo(comparable2) <= 0) {
                        break;
                        break;
                    }
                    d(i8, i11);
                    i8 = i11;
                }
            }
        }
        c1 c1Var2 = objArr2[atomicIntegerFieldUpdater.get(this)];
        Intrinsics.checkNotNull(c1Var2);
        c1Var2.b(null);
        c1Var2.f7439b = -1;
        objArr2[atomicIntegerFieldUpdater.get(this)] = null;
        return c1Var2;
    }

    public final void c(int i8) {
        while (i8 > 0) {
            c1[] c1VarArr = this.f9130a;
            Intrinsics.checkNotNull(c1VarArr);
            int i9 = (i8 - 1) / 2;
            c1 c1Var = c1VarArr[i9];
            Intrinsics.checkNotNull(c1Var);
            c1 c1Var2 = c1VarArr[i8];
            Intrinsics.checkNotNull(c1Var2);
            if (c1Var.compareTo(c1Var2) <= 0) {
                return;
            }
            d(i8, i9);
            i8 = i9;
        }
    }

    public final void d(int i8, int i9) {
        c1[] c1VarArr = this.f9130a;
        Intrinsics.checkNotNull(c1VarArr);
        c1 c1Var = c1VarArr[i9];
        Intrinsics.checkNotNull(c1Var);
        c1 c1Var2 = c1VarArr[i8];
        Intrinsics.checkNotNull(c1Var2);
        c1VarArr[i8] = c1Var;
        c1VarArr[i9] = c1Var2;
        c1Var.f7439b = i8;
        c1Var2.f7439b = i9;
    }
}
