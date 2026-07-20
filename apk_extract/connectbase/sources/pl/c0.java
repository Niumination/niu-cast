package pl;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    @xm.f(c = "io.ktor.utils.io.LookAheadSessionKt", f = "LookAheadSession.kt", i = {0, 0, 1, 1, 1}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 60}, m = "consumeEachRemaining", n = {"$this$consumeEachRemaining", "visitor", "$this$consumeEachRemaining", "visitor", p6.s.f13016a}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    public static final class a extends xm.d {
        int I$0;
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
            return c0.a(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:21:0x005e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006b -> B:17:0x004b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0082 -> B:31:0x0085). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @tl.f0
    public static final java.lang.Object a(@os.l pl.d0 r6, @os.l jn.p<? super java.nio.ByteBuffer, ? super um.d<? super java.lang.Boolean>, ? extends java.lang.Object> r7, @os.l um.d<? super lm.l2> r8) {
        /*
            boolean r0 = r8 instanceof pl.c0.a
            if (r0 == 0) goto L13
            r0 = r8
            pl.c0$a r0 = (pl.c0.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.c0$a r0 = new pl.c0$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            jn.p r7 = (jn.p) r7
            java.lang.Object r2 = r0.L$0
            pl.d0 r2 = (pl.d0) r2
            lm.d1.n(r8)
            goto L85
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$1
            jn.p r6 = (jn.p) r6
            java.lang.Object r7 = r0.L$0
            pl.d0 r7 = (pl.d0) r7
            lm.d1.n(r8)
            goto L62
        L48:
            lm.d1.n(r8)
        L4b:
            r8 = 0
            java.nio.ByteBuffer r8 = r6.b(r8, r4)
            if (r8 != 0) goto L6f
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.w(r4, r0)
            if (r8 != r1) goto L5f
            return r1
        L5f:
            r5 = r7
            r7 = r6
            r6 = r5
        L62:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L6b
            goto L90
        L6b:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L4b
        L6f:
            int r2 = r8.remaining()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L82
            return r1
        L82:
            r5 = r2
            r2 = r6
            r6 = r5
        L85:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2.b0(r6)
            if (r8 != 0) goto L93
        L90:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L93:
            r6 = r2
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.c0.a(pl.d0, jn.p, um.d):java.lang.Object");
    }

    @tl.f0
    public static final void b(@os.l b0 b0Var, @os.l jn.l<? super ByteBuffer, Boolean> lVar) {
        boolean z10;
        kn.l0.p(b0Var, "<this>");
        kn.l0.p(lVar, "visitor");
        do {
            z10 = false;
            ByteBuffer byteBufferB = b0Var.b(0, 1);
            if (byteBufferB != null) {
                int iRemaining = byteBufferB.remaining();
                boolean zBooleanValue = lVar.invoke(byteBufferB).booleanValue();
                b0Var.b0(iRemaining);
                z10 = zBooleanValue;
            }
        } while (z10);
    }

    @tl.f0
    public static final Object c(d0 d0Var, jn.p<? super ByteBuffer, ? super um.d<? super Boolean>, ? extends Object> pVar, um.d<? super l2> dVar) {
        while (true) {
            ByteBuffer byteBufferB = d0Var.b(0, 1);
            if (byteBufferB != null) {
                int iRemaining = byteBufferB.remaining();
                boolean zBooleanValue = ((Boolean) pVar.invoke(byteBufferB, dVar)).booleanValue();
                d0Var.b0(iRemaining);
                if (!zBooleanValue) {
                    break;
                }
            } else if (!((Boolean) d0Var.w(1, dVar)).booleanValue()) {
                break;
            }
        }
        return l2.f10208a;
    }
}
