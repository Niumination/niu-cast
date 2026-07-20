package pl;

import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    @xm.f(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {320, 323}, m = "copyToImpl", n = {"$this$copyToImpl", "dst", "buffer", "limit", "dstNeedsFlush", "copied", "$this$copyToImpl", "dst", "buffer", "limit", "dstNeedsFlush", "copied", ik.f.b.f7973h}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "I$1"})
    public static final class a extends xm.d {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
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
            return l.d(null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", i = {0, 0}, l = {279}, m = "joinToImplSuspend", n = {"dst", "close"}, s = {"L$0", "Z$0"})
    public static final class b extends xm.d {
        Object L$0;
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
            return l.f(null, null, false, this);
        }
    }

    @os.m
    public static final Object c(@os.l k kVar, @os.l n nVar, long j10, @os.l um.d<? super Long> dVar) {
        if (kVar == nVar) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (j10 == 0) {
            return new Long(0L);
        }
        if ((kVar instanceof pl.a) && (nVar instanceof pl.a)) {
            return ((pl.a) nVar).s1((pl.a) kVar, j10, null, dVar);
        }
        return ((kVar instanceof f) && (nVar instanceof f)) ? wl.k.b((f) kVar, (f) nVar, Long.MAX_VALUE, dVar) : d(kVar, nVar, j10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0090  */
    /* JADX WARN: Code duplicated, block: B:26:0x0092 A[Catch: all -> 0x0106, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0106, blocks: (B:42:0x00fc, B:44:0x0102, B:26:0x0092), top: B:54:0x00fc }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00b1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d8 A[Catch: all -> 0x0046, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0046, blocks: (B:13:0x003e, B:33:0x00c6, B:30:0x00bc, B:36:0x00d8, B:20:0x0065), top: B:56:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:44:0x0102 A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #0 {all -> 0x0106, blocks: (B:42:0x00fc, B:44:0x0102, B:26:0x0092), top: B:54:0x00fc }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ef -> B:40:0x00f8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(pl.k r19, pl.n r20, long r21, um.d<? super java.lang.Long> r23) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.l.d(pl.k, pl.n, long, um.d):java.lang.Object");
    }

    @os.m
    public static final Object e(@os.l k kVar, @os.l n nVar, boolean z10, @os.l um.d<? super l2> dVar) {
        if (nVar == kVar) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if ((kVar instanceof pl.a) && (nVar instanceof pl.a)) {
            Object objK1 = ((pl.a) nVar).K1((pl.a) kVar, z10, dVar);
            return objK1 == wm.a.COROUTINE_SUSPENDED ? objK1 : l2.f10208a;
        }
        Object objF = f(kVar, nVar, z10, dVar);
        return objF == wm.a.COROUTINE_SUSPENDED ? objF : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object f(k kVar, n nVar, boolean z10, um.d<? super l2> dVar) {
        b bVar;
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
            d1.n(obj);
            bVar.L$0 = nVar;
            bVar.Z$0 = z10;
            bVar.label = 1;
            if (c(kVar, nVar, Long.MAX_VALUE, bVar) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z10 = bVar.Z$0;
            nVar = (n) bVar.L$0;
            d1.n(obj);
        }
        if (z10) {
            o.a(nVar);
        } else {
            nVar.flush();
        }
        return l2.f10208a;
    }
}
