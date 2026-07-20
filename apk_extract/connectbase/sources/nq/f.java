package nq;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n37#2,2:128\n13579#3,2:130\n1855#4,2:132\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n42#1:128,2\n54#1:130,2\n66#1:132,2\n*E\n"})
public final class f {

    @xm.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {54}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
    public static final class a extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.d(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "joinAll", n = {}, s = {})
    public static final class b extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.c(null, this);
        }
    }

    @os.m
    public static final <T> Object a(@os.l Collection<? extends a1<? extends T>> collection, @os.l um.d<? super List<? extends T>> dVar) {
        return collection.isEmpty() ? nm.k0.INSTANCE : new e((a1[]) collection.toArray(new a1[0])).c(dVar);
    }

    @os.m
    public static final <T> Object b(@os.l a1<? extends T>[] a1VarArr, @os.l um.d<? super List<? extends T>> dVar) {
        return a1VarArr.length == 0 ? nm.k0.INSTANCE : new e(a1VarArr).c(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object c(@os.l Collection<? extends l2> collection, @os.l um.d<? super lm.l2> dVar) {
        b bVar;
        Iterator it;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object obj = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 == 0) {
            lm.d1.n(obj);
            it = collection.iterator();
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) bVar.L$0;
            lm.d1.n(obj);
        }
        while (it.hasNext()) {
            l2 l2Var = (l2) it.next();
            bVar.L$0 = it;
            bVar.label = 1;
            if (l2Var.t(bVar) == aVar) {
                return aVar;
            }
        }
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0042  */
    /* JADX WARN: Code duplicated, block: B:18:0x0052 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0050 -> B:19:0x0053). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object d(@os.l nq.l2[] r6, @os.l um.d<? super lm.l2> r7) {
        /*
            boolean r0 = r7 instanceof nq.f.a
            if (r0 == 0) goto L13
            r0 = r7
            nq.f$a r0 = (nq.f.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            nq.f$a r0 = new nq.f$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r6 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            nq.l2[] r4 = (nq.l2[]) r4
            lm.d1.n(r7)
            r7 = r4
            goto L53
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            lm.d1.n(r7)
            int r7 = r6.length
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L40:
            if (r2 >= r6) goto L55
            r4 = r7[r2]
            r0.L$0 = r7
            r0.I$0 = r2
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r4 = r4.t(r0)
            if (r4 != r1) goto L53
            return r1
        L53:
            int r2 = r2 + r3
            goto L40
        L55:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: nq.f.d(nq.l2[], um.d):java.lang.Object");
    }
}
