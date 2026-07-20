package vq;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import lm.l2;
import q1.w2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,269:1\n46#1,8:284\n107#2,7:270\n107#2,7:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n74#1:284,8\n27#1:270,7\n85#1:277,7\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17835a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final u0 f17836b = new u0("CLOSED");

    public static final boolean b(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int i10, jn.l<? super Integer, Boolean> lVar) {
        int i11;
        do {
            i11 = atomicIntegerFieldUpdater.get(obj);
            if (!lVar.invoke(Integer.valueOf(i11)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i11, i11 + i10));
        return true;
    }

    public static final boolean c(Object obj, AtomicIntegerArray atomicIntegerArray, int i10, int i11, jn.l<? super Integer, Boolean> lVar) {
        int i12;
        do {
            i12 = atomicIntegerArray.get(i10);
            if (!lVar.invoke(Integer.valueOf(i12)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i10, i12, i12 + i11));
        return true;
    }

    @os.l
    public static final <N extends g<N>> N d(@os.l N n10) {
        while (true) {
            Object objA = g.a(n10);
            if (objA == f17836b) {
                return n10;
            }
            g gVar = (g) objA;
            if (gVar != null) {
                n10 = (N) gVar;
            } else if (n10.j()) {
                return n10;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final Object e(@os.m Object obj, @os.l AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j10, @os.l Object obj2, @os.l jn.p<? super Long, Object, Object> pVar) {
        Object objG;
        loop0: while (true) {
            objG = g(obj2, j10, pVar);
            if (!s0.h(objG)) {
                r0 r0VarF = s0.f(objG);
                while (true) {
                    r0 r0Var = (r0) atomicReferenceFieldUpdater.get(obj);
                    if (r0Var.f17877c >= r0VarF.f17877c) {
                        break loop0;
                    }
                    if (!r0VarF.s()) {
                        break;
                    }
                    if (j.d.a(atomicReferenceFieldUpdater, obj, r0Var, r0VarF)) {
                        if (!r0Var.o()) {
                            break loop0;
                        }
                        r0Var.l();
                        break loop0;
                    }
                    if (r0VarF.o()) {
                        r0VarF.l();
                    }
                }
            } else {
                break;
            }
        }
        return objG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final Object f(@os.m Object obj, @os.l AtomicReferenceArray atomicReferenceArray, int i10, long j10, @os.l Object obj2, @os.l jn.p<? super Long, Object, Object> pVar) {
        Object objG;
        loop0: while (true) {
            objG = g(obj2, j10, pVar);
            if (!s0.h(objG)) {
                r0 r0VarF = s0.f(objG);
                while (true) {
                    r0 r0Var = (r0) atomicReferenceArray.get(i10);
                    if (r0Var.f17877c >= r0VarF.f17877c) {
                        break loop0;
                    }
                    if (!r0VarF.s()) {
                        break;
                    }
                    if (w2.a(atomicReferenceArray, i10, r0Var, r0VarF)) {
                        if (!r0Var.o()) {
                            break loop0;
                        }
                        r0Var.l();
                        break loop0;
                    }
                    if (r0VarF.o()) {
                        r0VarF.l();
                    }
                }
            } else {
                break;
            }
        }
        return objG;
    }

    @os.l
    public static final <S extends r0<S>> Object g(@os.l S s10, long j10, @os.l jn.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.f17877c >= j10 && !s10.h()) {
                return s10;
            }
            Object objA = g.a(s10);
            u0 u0Var = f17836b;
            if (objA == u0Var) {
                return u0Var;
            }
            S sInvoke = (S) ((g) objA);
            if (sInvoke == null) {
                sInvoke = pVar.invoke(Long.valueOf(s10.f17877c + 1), s10);
                if (s10.m(sInvoke)) {
                    if (s10.h()) {
                        s10.l();
                    }
                }
            }
            s10 = (Object) sInvoke;
        }
    }

    public static final void h(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static final void i(AtomicReferenceArray atomicReferenceArray, int i10, jn.l<Object, l2> lVar) {
        while (true) {
            lVar.invoke(atomicReferenceArray.get(i10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean j(@os.m Object obj, @os.l AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, @os.l Object obj2) {
        while (true) {
            r0 r0Var = (r0) atomicReferenceFieldUpdater.get(obj);
            if (r0Var.f17877c >= obj2.f17877c) {
                return true;
            }
            if (!obj2.s()) {
                return false;
            }
            if (j.d.a(atomicReferenceFieldUpdater, obj, r0Var, obj2)) {
                if (r0Var.o()) {
                    r0Var.l();
                }
                return true;
            }
            if (obj2.o()) {
                obj2.l();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean k(@os.m Object obj, @os.l AtomicReferenceArray atomicReferenceArray, int i10, @os.l Object obj2) {
        while (true) {
            r0 r0Var = (r0) atomicReferenceArray.get(i10);
            if (r0Var.f17877c >= obj2.f17877c) {
                return true;
            }
            if (!obj2.s()) {
                return false;
            }
            if (w2.a(atomicReferenceArray, i10, r0Var, obj2)) {
                if (r0Var.o()) {
                    r0Var.l();
                }
                return true;
            }
            if (obj2.o()) {
                obj2.l();
            }
        }
    }
}
