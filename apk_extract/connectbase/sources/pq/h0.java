package pq;

import com.transsion.widgetslib.widget.tablayout.TabLayout;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.c2;
import nq.c3;
import nq.k1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
public final class h0 {

    @xm.f(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    public static final class a extends xm.d {
        long J$0;
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
            return h0.c(0L, 0L, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"channel", "delayMillis", "deadline", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
    public static final class b extends xm.d {
        long J$0;
        long J$1;
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
            return h0.d(0L, 0L, null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {TabLayout.f3131k0, 73}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends xm.o implements jn.p<d0<? super l2>, um.d<? super l2>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        final /* synthetic */ i0 $mode;
        private /* synthetic */ Object L$0;
        int label;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13245a;

            static {
                int[] iArr = new int[i0.values().length];
                try {
                    iArr[i0.FIXED_PERIOD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[i0.FIXED_DELAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f13245a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i0 i0Var, long j10, long j11, um.d<? super c> dVar) {
            super(2, dVar);
            this.$mode = i0Var;
            this.$delayMillis = j10;
            this.$initialDelayMillis = j11;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$mode, this.$delayMillis, this.$initialDelayMillis, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                d0 d0Var = (d0) this.L$0;
                int i11 = a.f13245a[this.$mode.ordinal()];
                if (i11 == 1) {
                    long j10 = this.$delayMillis;
                    long j11 = this.$initialDelayMillis;
                    g0 g0VarA = d0Var.a();
                    this.label = 1;
                    if (h0.d(j10, j11, g0VarA, this) == aVar) {
                        return aVar;
                    }
                } else if (i11 == 2) {
                    long j12 = this.$delayMillis;
                    long j13 = this.$initialDelayMillis;
                    g0 g0VarA2 = d0Var.a();
                    this.label = 2;
                    if (h0.c(j12, j13, g0VarA2, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l d0<? super l2> d0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0070  */
    /* JADX WARN: Code duplicated, block: B:28:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007b -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object c(long r6, long r8, pq.g0<? super lm.l2> r10, um.d<? super lm.l2> r11) {
        /*
            boolean r0 = r11 instanceof pq.h0.a
            if (r0 == 0) goto L13
            r0 = r11
            pq.h0$a r0 = (pq.h0.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pq.h0$a r0 = new pq.h0$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L51
            if (r2 == r5) goto L46
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            pq.g0 r8 = (pq.g0) r8
            lm.d1.n(r11)
        L32:
            r10 = r8
            goto L61
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            pq.g0 r8 = (pq.g0) r8
            lm.d1.n(r11)
            goto L71
        L46:
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            r10 = r8
            pq.g0 r10 = (pq.g0) r10
            lm.d1.n(r11)
            goto L61
        L51:
            lm.d1.n(r11)
            r0.L$0 = r10
            r0.J$0 = r6
            r0.label = r5
            java.lang.Object r8 = nq.d1.b(r8, r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            lm.l2 r8 = lm.l2.f10208a
            r0.L$0 = r10
            r0.J$0 = r6
            r0.label = r4
            java.lang.Object r8 = r10.L(r8, r0)
            if (r8 != r1) goto L70
            return r1
        L70:
            r8 = r10
        L71:
            r0.L$0 = r8
            r0.J$0 = r6
            r0.label = r3
            java.lang.Object r9 = nq.d1.b(r6, r0)
            if (r9 != r1) goto L32
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.h0.c(long, long, pq.g0, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00db  */
    /* JADX WARN: Code duplicated, block: B:49:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00fa -> B:31:0x00a8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0110 -> B:15:0x003b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(long r18, long r20, pq.g0<? super lm.l2> r22, um.d<? super lm.l2> r23) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pq.h0.d(long, long, pq.g0, um.d):java.lang.Object");
    }

    @c3
    @os.l
    public static final f0<l2> e(long j10, long j11, @os.l um.g gVar, @os.l i0 i0Var) {
        if (j10 < 0) {
            throw new IllegalArgumentException(j1.g.a("Expected non-negative delay, but has ", j10, " ms").toString());
        }
        if (j11 >= 0) {
            return b0.c(c2.f11831a, k1.g().plus(gVar), 0, new c(i0Var, j10, j11, null));
        }
        throw new IllegalArgumentException(j1.g.a("Expected non-negative initial delay, but has ", j11, " ms").toString());
    }

    public static /* synthetic */ f0 f(long j10, long j11, um.g gVar, i0 i0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = j10;
        }
        if ((i10 & 4) != 0) {
            gVar = um.i.INSTANCE;
        }
        if ((i10 & 8) != 0) {
            i0Var = i0.FIXED_PERIOD;
        }
        return e(j10, j11, gVar, i0Var);
    }
}
