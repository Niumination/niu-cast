package pl;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    @xm.f(c = "io.ktor.utils.io.ConsumeEachKt", f = "ConsumeEach.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2}, l = {46, 50, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "consumeEachBufferRange", n = {"$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "buffer$iv", "bytesRead$iv", "cause$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
    public static final class a extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return u.a(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ce A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:31:0x00c0, B:33:0x00ce, B:37:0x00e0, B:39:0x00ea, B:43:0x00f3, B:36:0x00d7), top: B:61:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00d7 A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:31:0x00c0, B:33:0x00ce, B:37:0x00e0, B:39:0x00ea, B:43:0x00f3, B:36:0x00d7), top: B:61:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ea A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:31:0x00c0, B:33:0x00ce, B:37:0x00e0, B:39:0x00ea, B:43:0x00f3, B:36:0x00d7), top: B:61:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:45:0x011f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0120  */
    /* JADX WARN: Code duplicated, block: B:49:0x0127  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0120 -> B:47:0x0123). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object a(@os.l pl.k r18, @os.l jn.p<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r19, @os.l um.d<? super lm.l2> r20) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.u.a(pl.k, jn.p, um.d):java.lang.Object");
    }

    public static final Object b(k kVar, jn.p<? super ByteBuffer, ? super Boolean, Boolean> pVar, um.d<? super l2> dVar) {
        ByteBuffer byteBufferO;
        boolean zBooleanValue;
        do {
            boolean z10 = true;
            tl.e eVarA = (tl.e) g0.h(kVar, 1, dVar);
            if (eVarA == null) {
                eVarA = tl.e.f15818d.a();
            }
            try {
                ByteBuffer byteBuffer = eVarA.f15820a;
                tl.m mVar = eVarA.f15821b;
                long j10 = mVar.f15873b;
                long j11 = mVar.f15874c;
                if (j11 > j10) {
                    byteBufferO = ql.f.o(byteBuffer, j10, j11 - j10);
                } else {
                    ql.f.f14043b.getClass();
                    byteBufferO = ql.f.f14044c;
                }
                if (byteBufferO.remaining() != kVar.d() || !kVar.e()) {
                    z10 = false;
                }
                zBooleanValue = pVar.invoke(byteBufferO, Boolean.valueOf(z10)).booleanValue();
                g0.c(kVar, eVarA, byteBufferO.position(), dVar);
                if (z10 && kVar.p0()) {
                    break;
                }
            } catch (Throwable th2) {
                g0.c(kVar, eVarA, 0, dVar);
                throw th2;
            }
        } while (zBooleanValue);
        return l2.f10208a;
    }
}
