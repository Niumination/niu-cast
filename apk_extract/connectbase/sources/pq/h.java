package pq;

import kn.n0;
import kn.r1;
import lm.l2;
import nq.c2;
import nq.c3;
import nq.k1;
import nq.m0;
import nq.o0;
import nq.s0;
import nq.t0;
import nq.t2;
import nq.u0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,202:1\n48#2,4:203\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n51#1:203,4\n*E\n"})
public final class h {

    @r1({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n1#1,110:1\n51#2:111\n*E\n"})
    public static final class a extends um.a implements o0 {
        public a(o0.b bVar) {
            super(bVar);
        }

        @Override // nq.o0
        public void g0(@os.l um.g gVar, @os.l Throwable th2) {
        }
    }

    public static final class b extends n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ f0<E> $this_broadcast;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(f0<? extends E> f0Var) {
            super(1);
            this.$this_broadcast = f0Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            t.a(this.$this_broadcast, th2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @xm.f(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {56, 57}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
    public static final class c<E> extends xm.o implements jn.p<d0<? super E>, um.d<? super l2>, Object> {
        final /* synthetic */ f0<E> $channel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(f0<? extends E> f0Var, um.d<? super c> dVar) {
            super(2, dVar);
            this.$channel = f0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$channel, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0046 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0047  */
        /* JADX WARN: Code duplicated, block: B:18:0x0052  */
        /* JADX WARN: Code duplicated, block: B:20:0x0062 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0063  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0060 -> B:7:0x0017). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
            /*
                r6 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2d
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r6.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r6.L$0
                pq.d0 r4 = (pq.d0) r4
                lm.d1.n(r7)
            L17:
                r7 = r4
                goto L3a
            L19:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L21:
                java.lang.Object r1 = r6.L$1
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r6.L$0
                pq.d0 r4 = (pq.d0) r4
                lm.d1.n(r7)
                goto L4a
            L2d:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                pq.d0 r7 = (pq.d0) r7
                pq.f0<E> r1 = r6.$channel
                pq.n r1 = r1.iterator()
            L3a:
                r6.L$0 = r7
                r6.L$1 = r1
                r6.label = r3
                java.lang.Object r4 = r1.b(r6)
                if (r4 != r0) goto L47
                return r0
            L47:
                r5 = r4
                r4 = r7
                r7 = r5
            L4a:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L63
                java.lang.Object r7 = r1.next()
                r6.L$0 = r4
                r6.L$1 = r1
                r6.label = r2
                java.lang.Object r7 = r4.L(r7, r6)
                if (r7 != r0) goto L17
                return r0
            L63:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: pq.h.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l d0<? super E> d0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @c3
    @os.l
    public static final <E> d<E> a(@os.l s0 s0Var, @os.l um.g gVar, int i10, @os.l u0 u0Var, @os.m jn.l<? super Throwable, l2> lVar, @lm.b @os.l jn.p<? super d0<? super E>, ? super um.d<? super l2>, ? extends Object> pVar) {
        um.g gVarD = m0.d(s0Var, gVar);
        d dVarA = f.a(i10);
        g a0Var = u0Var.isLazy() ? new a0(gVarD, dVarA, pVar) : new g(gVarD, dVarA, true);
        if (lVar != null) {
            ((t2) a0Var).k0(lVar);
        }
        u0Var.invoke(pVar, a0Var, (um.d) a0Var);
        return (d<E>) a0Var;
    }

    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @c3
    @os.l
    public static final <E> d<E> b(@os.l f0<? extends E> f0Var, int i10, @os.l u0 u0Var) {
        return c(t0.m(t0.m(c2.f11831a, k1.g()), new a((um.g.c<?>) o0.f11887j)), null, i10, u0Var, new b(f0Var), new c(f0Var, null), 1, null);
    }

    public static /* synthetic */ d c(s0 s0Var, um.g gVar, int i10, u0 u0Var, jn.l lVar, jn.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        um.g gVar2 = gVar;
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            u0Var = u0.LAZY;
        }
        u0 u0Var2 = u0Var;
        if ((i11 & 8) != 0) {
            lVar = null;
        }
        return a(s0Var, gVar2, i12, u0Var2, lVar, pVar);
    }

    public static /* synthetic */ d d(f0 f0Var, int i10, u0 u0Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        if ((i11 & 2) != 0) {
            u0Var = u0.LAZY;
        }
        return b(f0Var, i10, u0Var);
    }
}
