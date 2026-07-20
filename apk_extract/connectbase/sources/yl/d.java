package yl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.InputStream;
import kn.l0;
import nq.b0;
import nq.l2;
import nq.o2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final pl.k f21448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final b0 f21449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final a f21450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public byte[] f21451d;

    public static final class a extends yl.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ l2 f21452g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d f21453h;

        /* JADX INFO: renamed from: yl.d$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1", f = "Blocking.kt", i = {0, 0, 1}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, 40}, m = "loop", n = {"this", "this_$iv", "this"}, s = {"L$0", "L$1", "L$0"})
        public static final class C0549a extends xm.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C0549a(um.d<? super C0549a> dVar) {
                super(dVar);
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return a.this.i(this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l2 l2Var, d dVar) {
            super(l2Var);
            this.f21452g = l2Var;
            this.f21453h = dVar;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0056  */
        /* JADX WARN: Code duplicated, block: B:21:0x005b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x0075 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x007f  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0073 -> B:25:0x0076). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:27:0x007f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // yl.a
        @os.m
        public java.lang.Object i(@os.l um.d<? super lm.l2> r9) {
            /*
                r8 = this;
                boolean r0 = r9 instanceof yl.d.a.C0549a
                if (r0 == 0) goto L13
                r0 = r9
                yl.d$a$a r0 = (yl.d.a.C0549a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                yl.d$a$a r0 = new yl.d$a$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.result
                wm.a r1 = wm.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L42
                if (r2 == r4) goto L36
                if (r2 != r3) goto L2e
                java.lang.Object r8 = r0.L$0
                yl.d$a r8 = (yl.d.a) r8
                lm.d1.n(r9)
                goto L76
            L2e:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L36:
                java.lang.Object r8 = r0.L$1
                yl.a r8 = (yl.a) r8
                java.lang.Object r8 = r0.L$0
                yl.d$a r8 = (yl.d.a) r8
                lm.d1.n(r9)
                goto L5c
            L42:
                lm.d1.n(r9)
                r9 = 0
            L46:
                r8.result = r9
                r0.L$0 = r8
                r0.L$1 = r8
                r0.label = r4
                java.lang.Object r9 = r8.l(r0)
                wm.a r2 = wm.a.COROUTINE_SUSPENDED
                if (r9 != r2) goto L59
                xm.h.c(r0)
            L59:
                if (r9 != r1) goto L5c
                return r1
            L5c:
                byte[] r9 = (byte[]) r9
                yl.d r2 = r8.f21453h
                pl.k r2 = yl.d.b(r2)
                int r5 = r8.f21441d
                int r6 = r8.f21442e
                r0.L$0 = r8
                r7 = 0
                r0.L$1 = r7
                r0.label = r3
                java.lang.Object r9 = r2.v(r9, r5, r6, r0)
                if (r9 != r1) goto L76
                return r1
            L76:
                java.lang.Number r9 = (java.lang.Number) r9
                int r9 = r9.intValue()
                r2 = -1
                if (r9 != r2) goto L46
                yl.d r0 = r8.f21453h
                nq.b0 r0 = yl.d.c(r0)
                r0.complete()
                r8.result = r9
                lm.l2 r8 = lm.l2.f10208a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: yl.d.a.i(um.d):java.lang.Object");
        }
    }

    public d(@m l2 l2Var, @l pl.k kVar) {
        l0.p(kVar, "channel");
        this.f21448a = kVar;
        b.d();
        this.f21449b = new o2(l2Var);
        this.f21450c = new a(l2Var, this);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f21448a.d();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            super.close();
            pl.m.a(this.f21448a);
            if (!this.f21449b.isCompleted()) {
                l2.a.b(this.f21449b, null, 1, null);
            }
            this.f21450c.n();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        try {
            byte[] bArr = this.f21451d;
            if (bArr == null) {
                bArr = new byte[1];
                this.f21451d = bArr;
            }
            int iP = this.f21450c.p(bArr, 0, 1);
            if (iP == -1) {
                return -1;
            }
            if (iP != 1) {
                throw new IllegalStateException(l0.C("rc should be 1 or -1 but got ", Integer.valueOf(iP)).toString());
            }
            return bArr[0] & 255;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(@m byte[] bArr, int i10, int i11) {
        a aVar;
        aVar = this.f21450c;
        l0.m(bArr);
        return aVar.p(bArr, i10, i11);
    }
}
