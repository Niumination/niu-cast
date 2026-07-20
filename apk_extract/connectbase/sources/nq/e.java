package nq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n314#2,9:128\n323#2,2:141\n13#3:137\n19#3:140\n13579#4,2:138\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n*L\n71#1:128,9\n71#1:141,2\n78#1:137\n90#1:140\n83#1:138,2\n*E\n"})
public final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11838b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a1<T>[] f11839a;

    @in.x
    private volatile int notCompletedCount;

    @kn.r1({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n11335#2:128\n11670#2,3:129\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n*L\n121#1:128\n121#1:129,3\n*E\n"})
    public final class a extends s2 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public static final AtomicReferenceFieldUpdater f11840i = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");

        @os.m
        @in.x
        private volatile Object _disposer;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final p<List<? extends T>> f11841e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public n1 f11842f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(p<? super List<? extends T>> pVar) {
            this.f11841e = pVar;
        }

        @os.m
        public final e<T>.b E() {
            return (b) f11840i.get(this);
        }

        @os.l
        public final n1 F() {
            n1 n1Var = this.f11842f;
            if (n1Var != null) {
                return n1Var;
            }
            kn.l0.S("handle");
            return null;
        }

        public final void G(@os.m e<T>.b bVar) {
            f11840i.set(this, bVar);
        }

        public final void H(@os.l n1 n1Var) {
            this.f11842f = n1Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
            invoke2(th2);
            return lm.l2.f10208a;
        }

        @Override // nq.f0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@os.m Throwable th2) {
            if (th2 != null) {
                Object objJ = this.f11841e.j(th2);
                if (objJ != null) {
                    this.f11841e.M(objJ);
                    e<T>.b bVarE = E();
                    if (bVarE != null) {
                        bVarE.j();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.f11838b.decrementAndGet(e.this) == 0) {
                p<List<? extends T>> pVar = this.f11841e;
                a1<T>[] a1VarArr = e.this.f11839a;
                ArrayList arrayList = new ArrayList(a1VarArr.length);
                for (a1<T> a1Var : a1VarArr) {
                    arrayList.add(a1Var.p());
                }
                lm.c1.a aVar = lm.c1.Companion;
                pVar.resumeWith(lm.c1.m59constructorimpl(arrayList));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@os.l a1<? extends T>[] a1VarArr) {
        this.f11839a = a1VarArr;
        this.notCompletedCount = a1VarArr.length;
    }

    @os.m
    public final Object c(@os.l um.d<? super List<? extends T>> dVar) {
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        int length = this.f11839a.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            a1<T> a1Var = this.f11839a[i10];
            a1Var.start();
            a aVar = new a(qVar);
            aVar.f11842f = a1Var.k0(aVar);
            lm.l2 l2Var = lm.l2.f10208a;
            aVarArr[i10] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i11 = 0; i11 < length; i11++) {
            aVarArr[i11].G(bVar);
        }
        if (qVar.isCompleted()) {
            bVar.j();
        } else {
            qVar.H(bVar);
        }
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objZ;
    }

    @kn.r1({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n13579#2,2:128\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n*L\n96#1:128,2\n*E\n"})
    public final class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final e<T>.a[] f11844a;

        public b(e<T>.a[] aVarArr) {
            this.f11844a = aVarArr;
        }

        @Override // jn.l
        public lm.l2 invoke(Throwable th2) {
            j();
            return lm.l2.f10208a;
        }

        public final void j() {
            for (e<T>.a aVar : this.f11844a) {
                aVar.F().dispose();
            }
        }

        @os.l
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f11844a + ']';
        }

        @Override // nq.o
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@os.m Throwable th2) {
            j();
        }
    }
}
