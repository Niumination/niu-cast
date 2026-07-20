package gl;

import fl.t0;
import java.nio.ByteBuffer;
import lm.l2;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    @xm.f(c = "io.ktor.util.cio.ReadersJvmKt", f = "ReadersJvm.kt", i = {0, 0, 0}, l = {18}, m = "pass", n = {"$this$pass", "buffer", "block"}, s = {"L$0", "L$1", "L$2"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.a(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0056 -> B:20:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @fl.t0
    public static final java.lang.Object a(@os.l pl.k r5, @os.l java.nio.ByteBuffer r6, @os.l jn.l<? super java.nio.ByteBuffer, lm.l2> r7, @os.l um.d<? super lm.l2> r8) {
        /*
            boolean r0 = r8 instanceof gl.j.a
            if (r0 == 0) goto L13
            r0 = r8
            gl.j$a r0 = (gl.j.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            gl.j$a r0 = new gl.j$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            jn.l r5 = (jn.l) r5
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            pl.k r7 = (pl.k) r7
            lm.d1.n(r8)
            r4 = r7
            r7 = r5
            r5 = r4
            goto L59
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            lm.d1.n(r8)
        L41:
            boolean r8 = r5.p0()
            if (r8 != 0) goto L60
            r6.clear()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r5.n0(r6, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            r6.flip()
            r7.invoke(r6)
            goto L41
        L60:
            boolean r6 = r5 instanceof pl.c
            if (r6 == 0) goto L6c
            java.lang.Throwable r5 = r5.a()
            if (r5 != 0) goto L6b
            goto L6c
        L6b:
            throw r5
        L6c:
            lm.l2 r5 = lm.l2.f10208a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: gl.j.a(pl.k, java.nio.ByteBuffer, jn.l, um.d):java.lang.Object");
    }

    @t0
    public static final Object b(pl.k kVar, ByteBuffer byteBuffer, jn.l<? super ByteBuffer, l2> lVar, um.d<? super l2> dVar) throws Throwable {
        Throwable thA;
        while (!kVar.p0()) {
            byteBuffer.clear();
            kVar.n0(byteBuffer, dVar);
            byteBuffer.flip();
            lVar.invoke(byteBuffer);
        }
        if (!(kVar instanceof pl.c) || (thA = kVar.a()) == null) {
            return l2.f10208a;
        }
        throw thA;
    }
}
