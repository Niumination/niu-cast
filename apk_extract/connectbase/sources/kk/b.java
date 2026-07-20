package kk;

import androidx.constraintlayout.widget.ConstraintLayout;
import fl.t0;
import java.io.File;
import java.io.FileInputStream;
import kn.k1;
import kn.l0;
import kn.n0;
import kn.w;
import lm.d0;
import lm.d1;
import lm.l2;
import nk.u;
import nq.s0;
import pq.f0;
import tl.g0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class b implements nk.p, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final um.g f9193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final f0<kk.j> f9196d;

    @xm.f(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "eventToData", n = {"evt"}, s = {"L$0"})
    public static final class a extends xm.d {
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
            return b.this.g(null, this);
        }
    }

    /* JADX INFO: renamed from: kk.b$b, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4}, l = {68, 74, 85, 88, y5.a.f20714d0}, m = "partToData", n = {"this", "part", "part", "headers", "part", "headers", "buffer", "part", "headers", "buffer", "part", "headers", "buffer", "tmp", "out"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6"})
    public static final class C0242b extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C0242b(um.d<? super C0242b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.i(null, this);
        }
    }

    public static final class c extends n0 implements jn.a<l2> {
        final /* synthetic */ kk.j.b $part;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kk.j.b bVar) {
            super(0);
            this.$part = bVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() throws InterruptedException {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws InterruptedException {
            this.$part.a();
        }
    }

    public static final class d extends n0 implements jn.a<g0> {
        final /* synthetic */ g0 $input;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g0 g0Var) {
            super(0);
            this.$input = g0Var;
        }

        @Override // jn.a
        @os.l
        public final g0 invoke() {
            return this.$input;
        }
    }

    public static final class e extends n0 implements jn.a<l2> {
        final /* synthetic */ kk.j.b $part;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(kk.j.b bVar) {
            super(0);
            this.$part = bVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() throws InterruptedException {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws InterruptedException {
            this.$part.a();
        }
    }

    public static final class f extends n0 implements jn.a<g0> {
        final /* synthetic */ d0<g0> $lazyInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(d0<? extends g0> d0Var) {
            super(0);
            this.$lazyInput = d0Var;
        }

        @Override // jn.a
        @os.l
        public final g0 invoke() {
            return this.$lazyInput.getValue();
        }
    }

    public static final class g extends n0 implements jn.a<l2> {
        final /* synthetic */ k1.a $closed;
        final /* synthetic */ d0<g0> $lazyInput;
        final /* synthetic */ kk.j.b $part;
        final /* synthetic */ File $tmp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(k1.a aVar, d0<? extends g0> d0Var, kk.j.b bVar, File file) {
            super(0);
            this.$closed = aVar;
            this.$lazyInput = d0Var;
            this.$part = bVar;
            this.$tmp = file;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() throws InterruptedException {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws InterruptedException {
            this.$closed.element = true;
            if (this.$lazyInput.isInitialized()) {
                this.$lazyInput.getValue().close();
            }
            this.$part.a();
            this.$tmp.delete();
        }
    }

    public static final class h extends n0 implements jn.a<g0> {
        final /* synthetic */ k1.a $closed;
        final /* synthetic */ File $tmp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(k1.a aVar, File file) {
            super(0);
            this.$closed = aVar;
            this.$tmp = file;
        }

        @Override // jn.a
        @os.l
        public final g0 invoke() {
            if (this.$closed.element) {
                throw new IllegalStateException("Already disposed");
            }
            return cm.b.b(new FileInputStream(this.$tmp), null, 1, null);
        }
    }

    @xm.f(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0}, l = {35, 38}, m = "readPart", n = {"this"}, s = {"L$0"})
    public static final class i extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public i(um.d<? super i> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.b(this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0, 1}, l = {44, 45}, m = "readPartSuspend", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class j extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public j(um.d<? super j> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.j(this);
        }
    }

    public b(@os.l um.g gVar, @os.l pl.k kVar, @os.l CharSequence charSequence, @os.m Long l10, int i10, int i11) {
        l0.p(gVar, "coroutineContext");
        l0.p(kVar, "channel");
        l0.p(charSequence, "contentType");
        this.f9193a = gVar;
        this.f9194b = i10;
        this.f9195c = i11;
        this.f9196d = k.t(this, kVar, charSequence, l10);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0054  */
    /* JADX WARN: Code duplicated, block: B:25:0x005e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0064 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005c -> B:26:0x005f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:29:0x0064
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // nk.p
    @os.m
    public java.lang.Object b(@os.l um.d<? super nk.u> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kk.b.i
            if (r0 == 0) goto L13
            r0 = r6
            kk.b$i r0 = (kk.b.i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kk.b$i r0 = new kk.b$i
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lm.d1.n(r6)
            goto L53
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            java.lang.Object r5 = r0.L$0
            kk.b r5 = (kk.b) r5
            lm.d1.n(r6)
            goto L5f
        L3a:
            lm.d1.n(r6)
        L3d:
            pq.f0<kk.j> r6 = r5.f9196d
            java.lang.Object r6 = r6.poll()
            kk.j r6 = (kk.j) r6
            if (r6 != 0) goto L54
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r5.j(r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            return r6
        L54:
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.g(r6, r0)
            if (r6 != r1) goto L5f
            return r1
        L5f:
            nk.u r6 = (nk.u) r6
            if (r6 != 0) goto L64
            goto L3d
        L64:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.b.b(um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(kk.j jVar, um.d<? super u> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objI = aVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                d1.n(objI);
                if (!(jVar instanceof kk.j.b)) {
                    jVar.a();
                    return null;
                }
                aVar.L$0 = jVar;
                aVar.label = 1;
                objI = i((kk.j.b) jVar, aVar);
                if (objI == obj) {
                    return obj;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objI);
            }
            return (u) objI;
        } catch (Throwable th2) {
            jVar.a();
            throw th2;
        }
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f9193a;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x01a0 A[Catch: all -> 0x005b, LOOP:0: B:69:0x019a->B:71:0x01a0, LOOP_END, TryCatch #4 {all -> 0x005b, blocks: (B:16:0x0056, B:75:0x01c3, B:77:0x01cb, B:83:0x01fa, B:69:0x019a, B:71:0x01a0, B:72:0x01a4), top: B:105:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x01cb A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #4 {all -> 0x005b, blocks: (B:16:0x0056, B:75:0x01c3, B:77:0x01cb, B:83:0x01fa, B:69:0x019a, B:71:0x01a0, B:72:0x01a4), top: B:105:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:83:0x01fa A[Catch: all -> 0x005b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x005b, blocks: (B:16:0x0056, B:75:0x01c3, B:77:0x01cb, B:83:0x01fa, B:69:0x019a, B:71:0x01a0, B:72:0x01a4), top: B:105:0x0056 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Object, java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01c0 -> B:75:0x01c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object i(kk.j.b r18, um.d<? super nk.u> r19) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.b.i(kk.j$b, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0060 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0058 -> B:27:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object j(um.d<? super nk.u> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kk.b.j
            if (r0 == 0) goto L13
            r0 = r6
            kk.b$j r0 = (kk.b.j) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kk.b$j r0 = new kk.b$j
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            kk.b r5 = (kk.b) r5
            lm.d1.n(r6)     // Catch: pq.v -> L61
            goto L5b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            java.lang.Object r5 = r0.L$0
            kk.b r5 = (kk.b) r5
            lm.d1.n(r6)     // Catch: pq.v -> L61
            goto L4e
        L3e:
            lm.d1.n(r6)
        L41:
            pq.f0<kk.j> r6 = r5.f9196d     // Catch: pq.v -> L61
            r0.L$0 = r5     // Catch: pq.v -> L61
            r0.label = r4     // Catch: pq.v -> L61
            java.lang.Object r6 = r6.n(r0)     // Catch: pq.v -> L61
            if (r6 != r1) goto L4e
            return r1
        L4e:
            kk.j r6 = (kk.j) r6     // Catch: pq.v -> L61
            r0.L$0 = r5     // Catch: pq.v -> L61
            r0.label = r3     // Catch: pq.v -> L61
            java.lang.Object r6 = r5.g(r6, r0)     // Catch: pq.v -> L61
            if (r6 != r1) goto L5b
            return r1
        L5b:
            nk.u r6 = (nk.u) r6     // Catch: pq.v -> L61
            if (r6 != 0) goto L60
            goto L41
        L60:
            return r6
        L61:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.b.j(um.d):java.lang.Object");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ b(um.g gVar, pl.k kVar, CharSequence charSequence, Long l10, int i10, int i11, int i12, w wVar) {
        int i13 = (i12 & 16) != 0 ? 65536 : i10;
        this(gVar, kVar, charSequence, l10, i13, (i12 & 32) != 0 ? i13 : i11);
    }
}
