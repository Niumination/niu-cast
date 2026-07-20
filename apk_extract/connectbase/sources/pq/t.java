package pq;

import com.transsion.widgetslib.widget.OSMaskImageView;
import java.util.concurrent.CancellationException;
import kn.l0;
import kn.r1;
import lm.a1;
import lm.l2;
import lm.z0;
import nq.c3;
import nq.w1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,141:1\n82#1,11:142\n105#1:153\n82#1,6:154\n106#1,2:160\n92#1:162\n88#1,3:163\n33#1,5:166\n*S KotlinDebug\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n105#1:142,11\n116#1:153\n116#1:154,6\n116#1:160,2\n116#1:162\n116#1:163,3\n129#1:166,5\n*E\n"})
public final /* synthetic */ class t {

    @r1({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$consumeEach$1\n*L\n1#1,141:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {106}, m = "consumeEach", n = {k4.f.f8937e, "$this$consume$iv"}, s = {"L$0", "L$1"})
    public static final class a<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return t.e(null, null, this);
        }
    }

    @r1({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$consumeEach$3\n*L\n1#1,141:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {OSMaskImageView.f2731x}, m = "consumeEach", n = {k4.f.f8937e, "channel$iv"}, s = {"L$0", "L$1"})
    public static final class b<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return t.d(null, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {149}, m = "toList", n = {"$this$toList_u24lambda_u243", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
    public static final class c<E> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return t.j(null, this);
        }
    }

    @z0
    public static final void a(@os.l f0<?> f0Var, @os.m Throwable th2) {
        CancellationException cancellationExceptionA = null;
        if (th2 != null) {
            cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = w1.a("Channel was consumed, consumer had failed", th2);
            }
        }
        f0Var.b(cancellationExceptionA);
    }

    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @c3
    public static final <E, R> R b(@os.l d<E> dVar, @os.l jn.l<? super f0<? extends E>, ? extends R> lVar) {
        f0<E> f0VarV = dVar.v();
        try {
            return lVar.invoke(f0VarV);
        } finally {
            f0.a.b(f0VarV, null, 1, null);
        }
    }

    public static final <E, R> R c(@os.l f0<? extends E> f0Var, @os.l jn.l<? super f0<? extends E>, ? extends R> lVar) {
        try {
            R rInvoke = lVar.invoke(f0Var);
            a(f0Var, null);
            return rInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                a(f0Var, th2);
                throw th3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:28:0x006b A[Catch: all -> 0x0075, TryCatch #1 {all -> 0x0075, blocks: (B:26:0x0063, B:28:0x006b, B:31:0x0078), top: B:42:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005f -> B:14:0x0036). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> java.lang.Object d(@os.l pq.d<E> r6, @os.l jn.l<? super E, lm.l2> r7, @os.l um.d<? super lm.l2> r8) {
        /*
            boolean r0 = r8 instanceof pq.t.b
            if (r0 == 0) goto L13
            r0 = r8
            pq.t$b r0 = (pq.t.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.t$b r0 = new pq.t$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            jn.l r2 = (jn.l) r2
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L38
            r5 = r0
            r0 = r7
            r7 = r2
        L36:
            r2 = r5
            goto L63
        L38:
            r6 = move-exception
            goto L85
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            lm.d1.n(r8)
            pq.f0 r6 = r6.v()
            pq.n r8 = r6.iterator()     // Catch: java.lang.Throwable -> L81
            r5 = r8
            r8 = r6
            r6 = r5
        L50:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L7e
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L7e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L7e
            r0.label = r4     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r2 = r6.b(r0)     // Catch: java.lang.Throwable -> L7e
            if (r2 != r1) goto L5f
            return r1
        L5f:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L36
        L63:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L75
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L75
            if (r8 == 0) goto L78
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L75
            r7.invoke(r8)     // Catch: java.lang.Throwable -> L75
            r8 = r0
            r0 = r2
            goto L50
        L75:
            r6 = move-exception
            r7 = r0
            goto L85
        L78:
            lm.l2 r6 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L75
            pq.f0.a.b(r0, r3, r4, r3)
            return r6
        L7e:
            r6 = move-exception
            r7 = r8
            goto L85
        L81:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L85:
            pq.f0.a.b(r7, r3, r4, r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.t.d(pq.d, jn.l, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062 A[Catch: all -> 0x0033, TryCatch #1 {all -> 0x0033, blocks: (B:12:0x002f, B:25:0x005a, B:27:0x0062, B:21:0x0048, B:28:0x006b), top: B:39:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0057 -> B:25:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final <E> java.lang.Object e(@os.l pq.f0<? extends E> r5, @os.l jn.l<? super E, lm.l2> r6, @os.l um.d<? super lm.l2> r7) {
        /*
            boolean r0 = r7 instanceof pq.t.a
            if (r0 == 0) goto L13
            r0 = r7
            pq.t$a r0 = (pq.t.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.t$a r0 = new pq.t$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$2
            pq.n r5 = (pq.n) r5
            java.lang.Object r6 = r0.L$1
            pq.f0 r6 = (pq.f0) r6
            java.lang.Object r2 = r0.L$0
            jn.l r2 = (jn.l) r2
            lm.d1.n(r7)     // Catch: java.lang.Throwable -> L33
            goto L5a
        L33:
            r5 = move-exception
            goto L76
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            lm.d1.n(r7)
            pq.n r7 = r5.iterator()     // Catch: java.lang.Throwable -> L72
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L48:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L33
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L33
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L33
            r0.label = r3     // Catch: java.lang.Throwable -> L33
            java.lang.Object r2 = r5.b(r0)     // Catch: java.lang.Throwable -> L33
            if (r2 != r1) goto L57
            return r1
        L57:
            r4 = r2
            r2 = r7
            r7 = r4
        L5a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L33
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L6b
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L33
            r2.invoke(r7)     // Catch: java.lang.Throwable -> L33
            r7 = r2
            goto L48
        L6b:
            lm.l2 r5 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L33
            r7 = 0
            a(r6, r7)
            return r5
        L72:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L76:
            throw r5     // Catch: java.lang.Throwable -> L77
        L77:
            r7 = move-exception
            a(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.t.e(pq.f0, jn.l, um.d):java.lang.Object");
    }

    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object f(d<E> dVar, jn.l<? super E, l2> lVar, um.d<? super l2> dVar2) {
        f0<E> f0VarV = dVar.v();
        try {
            n<E> it = f0VarV.iterator();
            while (((Boolean) it.b(null)).booleanValue()) {
                lVar.invoke(it.next());
            }
            return l2.f10208a;
        } finally {
            f0.a.b(f0VarV, null, 1, null);
        }
    }

    public static final <E> Object g(f0<? extends E> f0Var, jn.l<? super E, l2> lVar, um.d<? super l2> dVar) {
        try {
            n<? extends E> it = f0Var.iterator();
            while (((Boolean) it.b(null)).booleanValue()) {
                lVar.invoke(it.next());
            }
            l2 l2Var = l2.f10208a;
            a(f0Var, null);
            return l2Var;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                a(f0Var, th2);
                throw th3;
            }
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ yq.g h(f0 f0Var) {
        l0.n(f0Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return f0Var.C();
    }

    @lm.k(level = lm.m.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @a1(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object i(f0 f0Var, um.d dVar) {
        l0.n(f0Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return f0Var.u(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0062 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0063  */
    /* JADX WARN: Code duplicated, block: B:27:0x006e A[Catch: all -> 0x0037, TryCatch #2 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0066, B:27:0x006e, B:28:0x0077), top: B:43:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0063 -> B:25:0x0066). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final <E> java.lang.Object j(@os.l pq.f0<? extends E> r7, @os.l um.d<? super java.util.List<? extends E>> r8) {
        /*
            boolean r0 = r8 instanceof pq.t.c
            if (r0 == 0) goto L13
            r0 = r8
            pq.t$c r0 = (pq.t.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.t$c r0 = new pq.t$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r7 = r0.L$3
            pq.n r7 = (pq.n) r7
            java.lang.Object r2 = r0.L$2
            pq.f0 r2 = (pq.f0) r2
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L37
            goto L66
        L37:
            r7 = move-exception
            r8 = r2
            goto L88
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            lm.d1.n(r8)
            om.b r8 = new om.b
            r8.<init>()
            pq.n r2 = r7.iterator()     // Catch: java.lang.Throwable -> L84
            r4 = r8
            r5 = r4
            r8 = r7
            r7 = r2
        L52:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L82
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L82
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L82
            r0.L$3 = r7     // Catch: java.lang.Throwable -> L82
            r0.label = r3     // Catch: java.lang.Throwable -> L82
            java.lang.Object r2 = r7.b(r0)     // Catch: java.lang.Throwable -> L82
            if (r2 != r1) goto L63
            return r1
        L63:
            r6 = r2
            r2 = r8
            r8 = r6
        L66:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L37
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L37
            if (r8 == 0) goto L77
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L37
            r4.add(r8)     // Catch: java.lang.Throwable -> L37
            r8 = r2
            goto L52
        L77:
            lm.l2 r7 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L37
            r7 = 0
            a(r2, r7)
            java.util.List r7 = nm.x.a(r5)
            return r7
        L82:
            r7 = move-exception
            goto L88
        L84:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L88:
            throw r7     // Catch: java.lang.Throwable -> L89
        L89:
            r0 = move-exception
            a(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.t.j(pq.f0, um.d):java.lang.Object");
    }
}
