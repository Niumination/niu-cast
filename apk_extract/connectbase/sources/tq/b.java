package tq;

import java.util.Arrays;
import kn.l0;
import kn.r1;
import lm.c1;
import lm.l2;
import sq.u0;
import tq.d;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n28#2,4:144\n20#3:137\n20#3:142\n20#3:148\n1#4:143\n13579#5,2:149\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n30#1:133,4\n45#1:138,4\n76#1:144,4\n30#1:137\n45#1:142\n76#1:148\n95#1:149,2\n*E\n"})
public abstract class b<S extends d<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public S[] f16021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public a0 f16024d;

    @os.l
    public final u0<Integer> d() {
        a0 a0Var;
        synchronized (this) {
            a0Var = this.f16024d;
            if (a0Var == null) {
                a0Var = new a0(this.f16022b);
                this.f16024d = a0Var;
            }
        }
        return a0Var;
    }

    @os.l
    public final S i() {
        S s10;
        a0 a0Var;
        synchronized (this) {
            try {
                S[] sArr = this.f16021a;
                if (sArr == null) {
                    sArr = (S[]) k(2);
                    this.f16021a = sArr;
                } else if (this.f16022b >= sArr.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    l0.o(objArrCopyOf, "copyOf(this, newSize)");
                    this.f16021a = (S[]) ((d[]) objArrCopyOf);
                    sArr = (S[]) ((d[]) objArrCopyOf);
                }
                int i10 = this.f16023c;
                do {
                    s10 = sArr[i10];
                    if (s10 == null) {
                        s10 = (S) j();
                        sArr[i10] = s10;
                    }
                    i10++;
                    if (i10 >= sArr.length) {
                        i10 = 0;
                    }
                    l0.n(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s10.a(this));
                this.f16023c = i10;
                this.f16022b++;
                a0Var = this.f16024d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (a0Var != null) {
            a0Var.e0(1);
        }
        return s10;
    }

    @os.l
    public abstract S j();

    @os.l
    public abstract S[] k(int i10);

    public final void l(@os.l jn.l<? super S, l2> lVar) {
        S[] sArr;
        if (this.f16022b == 0 || (sArr = this.f16021a) == null) {
            return;
        }
        for (a1.d dVar : sArr) {
            if (dVar != null) {
                lVar.invoke(dVar);
            }
        }
    }

    public final void m(@os.l S s10) {
        a0 a0Var;
        int i10;
        um.d<l2>[] dVarArrB;
        synchronized (this) {
            try {
                int i11 = this.f16022b - 1;
                this.f16022b = i11;
                a0Var = this.f16024d;
                if (i11 == 0) {
                    this.f16023c = 0;
                }
                l0.n(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                dVarArrB = s10.b(this);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (um.d<l2> dVar : dVarArrB) {
            if (dVar != null) {
                c1.a aVar = c1.Companion;
                dVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
            }
        }
        if (a0Var != null) {
            a0Var.e0(-1);
        }
    }

    public final int n() {
        return this.f16022b;
    }

    @os.m
    public final S[] o() {
        return this.f16021a;
    }
}
