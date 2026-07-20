package sq;

import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,176:1\n107#2:177\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n153#1:177\n*E\n"})
public final /* synthetic */ class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n1#1,113:1\n154#2,2:114\n*E\n"})
    public static final class a<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pq.d f15309a;

        public a(pq.d dVar) {
            this.f15309a = dVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            Object objD = m.d(jVar, this.f15309a.v(), dVar);
            return objD == wm.a.COROUTINE_SUSPENDED ? objD : l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", i = {0, 0, 0, 1, 1, 1}, l = {36, 37}, m = "emitAllImpl$FlowKt__ChannelsKt", n = {"$this$emitAllImpl", "channel", "consume", "$this$emitAllImpl", "channel", "consume"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
    public static final class b<T> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
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
            return m.e(null, null, false, this);
        }
    }

    @lm.k(level = lm.m.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @os.l
    public static final <T> i<T> b(@os.l pq.d<T> dVar) {
        return new a(dVar);
    }

    @os.l
    public static final <T> i<T> c(@os.l pq.f0<? extends T> f0Var) {
        return new e(f0Var, true, null, 0, null, 28, null);
    }

    @os.m
    public static final <T> Object d(@os.l j<? super T> jVar, @os.l pq.f0<? extends T> f0Var, @os.l um.d<? super l2> dVar) {
        Object objE = e(jVar, f0Var, true, dVar);
        return objE == wm.a.COROUTINE_SUSPENDED ? objE : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0070 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x007d A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0034, B:24:0x0060, B:28:0x0075, B:30:0x007d, B:20:0x0052, B:23:0x005c), top: B:42:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0092 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0094  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008f -> B:14:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <T> java.lang.Object e(sq.j<? super T> r6, pq.f0<? extends T> r7, boolean r8, um.d<? super lm.l2> r9) {
        /*
            boolean r0 = r9 instanceof sq.m.b
            if (r0 == 0) goto L13
            r0 = r9
            sq.m$b r0 = (sq.m.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            sq.m$b r0 = new sq.m$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            sq.j r2 = (sq.j) r2
            lm.d1.n(r9)     // Catch: java.lang.Throwable -> L3a
        L37:
            r9 = r6
            r6 = r2
            goto L60
        L3a:
            r6 = move-exception
            goto L9b
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            pq.n r6 = (pq.n) r6
            java.lang.Object r7 = r0.L$1
            pq.f0 r7 = (pq.f0) r7
            java.lang.Object r2 = r0.L$0
            sq.j r2 = (sq.j) r2
            lm.d1.n(r9)     // Catch: java.lang.Throwable -> L3a
            goto L75
        L56:
            lm.d1.n(r9)
            sq.t.b(r6)
            pq.n r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3a
        L60:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L3a
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r2 = r9.b(r0)     // Catch: java.lang.Throwable -> L3a
            if (r2 != r1) goto L71
            return r1
        L71:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L75:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3a
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3a
            if (r9 == 0) goto L92
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3a
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L3a
            r0.label = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L3a
            if (r9 != r1) goto L37
            return r1
        L92:
            if (r8 == 0) goto L98
            r6 = 0
            pq.t.a(r7, r6)
        L98:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L9b:
            throw r6     // Catch: java.lang.Throwable -> L9c
        L9c:
            r9 = move-exception
            if (r8 == 0) goto La2
            pq.t.a(r7, r6)
        La2:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: sq.m.e(sq.j, pq.f0, boolean, um.d):java.lang.Object");
    }

    @os.l
    public static final <T> pq.f0<T> f(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var) {
        return tq.f.b(iVar).n(s0Var);
    }

    @os.l
    public static final <T> i<T> g(@os.l pq.f0<? extends T> f0Var) {
        return new e(f0Var, false, null, 0, null, 28, null);
    }
}
