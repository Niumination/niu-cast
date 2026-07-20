package wl;

import lm.d1;
import lm.l2;
import tn.u;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    @xm.f(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {27, 33, 41}, m = "copyToSequentialImpl", n = {"$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "transferred"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2"})
    public static final class a extends xm.d {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
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
            return k.b(null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 1, 1}, l = {57, 63}, m = "copyToTail", n = {"dst", "lastPiece", "lastPiece", "rc"}, s = {"L$0", "L$1", "L$0", "I$0"})
    public static final class b extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return k.c(null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0}, l = {8}, m = "joinToImpl", n = {"dst", "closeOnEnd"}, s = {"L$0", "Z$0"})
    public static final class c extends xm.d {
        Object L$0;
        boolean Z$0;
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
            return k.d(null, null, false, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0094  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0104 A[PHI: r0 r3 r5 r11 r13 r14
      0x0104: PHI (r0v11 long) = (r0v6 long), (r0v15 long) binds: [B:41:0x00e0, B:48:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      0x0104: PHI (r3v6 wl.k$a) = (r3v3 wl.k$a), (r3v7 wl.k$a) binds: [B:41:0x00e0, B:48:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      0x0104: PHI (r5v6 pl.f) = (r5v2 pl.f), (r5v8 pl.f) binds: [B:41:0x00e0, B:48:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      0x0104: PHI (r11v9 long) = (r11v3 long), (r11v11 long) binds: [B:41:0x00e0, B:48:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      0x0104: PHI (r13v6 pl.f) = (r13v0 pl.f), (r13v8 pl.f) binds: [B:41:0x00e0, B:48:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      0x0104: PHI (r14v1 long) = (r14v0 long), (r14v2 long) binds: [B:41:0x00e0, B:48:0x00fd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e0 -> B:49:0x0104). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00e8 -> B:48:0x00fd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00fa -> B:48:0x00fd). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object b(@os.l pl.f r19, @os.l pl.f r20, long r21, @os.l um.d<? super java.lang.Long> r23) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wl.k.b(pl.f, pl.f, long, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [pl.f] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, pl.f] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2, types: [ul.b] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [pl.f] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v9, types: [ul.b] */
    public static final Object c(pl.f fVar, pl.f fVar2, long j10, um.d<? super Long> dVar) throws Throwable {
        b bVar;
        ul.b bVar2;
        Object objL1;
        ?? r10;
        int iIntValue;
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
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    ul.b bVar3 = (ul.b) bVar.L$1;
                    pl.f fVar3 = (pl.f) bVar.L$0;
                    d1.n(obj);
                    r10 = fVar3;
                    objL1 = obj;
                    bVar2 = bVar3;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    iIntValue = bVar.I$0;
                    ul.b bVar4 = (ul.b) bVar.L$0;
                    d1.n(obj);
                    fVar2 = bVar4;
                }
                Long l10 = new Long(iIntValue);
                ul.b.f16311i.getClass();
                fVar2.j2(ul.b.f16315w);
                return l10;
            }
            d1.n(obj);
            ul.b.f16311i.getClass();
            bVar2 = (ul.b) ul.b.f16315w.W0();
            try {
                bVar2.w0((int) u.C(j10, bVar2.f15822c));
                bVar.L$0 = fVar2;
                bVar.L$1 = bVar2;
                bVar.label = 1;
                objL1 = fVar.l1(bVar2, bVar);
                r10 = fVar2;
                if (objL1 == aVar) {
                    return aVar;
                }
            } catch (Throwable th2) {
                th = th2;
                fVar2 = bVar2;
                ul.b.f16311i.getClass();
                fVar2.j2(ul.b.f16315w);
                throw th;
            }
            iIntValue = ((Number) objL1).intValue();
            if (iIntValue == -1) {
                ul.b.e eVar = ul.b.f16311i;
                eVar.getClass();
                bVar2.j2(ul.b.f16315w);
                Long l11 = new Long(0L);
                eVar.getClass();
                bVar2.j2(ul.b.f16315w);
                return l11;
            }
            bVar.L$0 = bVar2;
            bVar.L$1 = null;
            bVar.I$0 = iIntValue;
            bVar.label = 2;
            if (r10.h(bVar2, bVar) == aVar) {
                return aVar;
            }
            fVar2 = bVar2;
            Long l12 = new Long(iIntValue);
            ul.b.f16311i.getClass();
            fVar2.j2(ul.b.f16315w);
            return l12;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object d(@os.l pl.f fVar, @os.l pl.f fVar2, boolean z10, @os.l um.d<? super l2> dVar) {
        c cVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(obj);
            cVar.L$0 = fVar2;
            cVar.Z$0 = z10;
            cVar.label = 1;
            if (b(fVar, fVar2, Long.MAX_VALUE, cVar) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z10 = cVar.Z$0;
            fVar2 = (pl.f) cVar.L$0;
            d1.n(obj);
        }
        if (z10) {
            pl.o.a(fVar2);
        }
        return l2.f10208a;
    }
}
