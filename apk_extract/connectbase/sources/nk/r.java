package nk;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    @xm.f(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", i = {0, 0, 1, 1}, l = {y5.a.f20724i0, y5.a.f20726j0}, m = "forEachPart", n = {"$this$forEachPart", "partHandler", "$this$forEachPart", "partHandler"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class a extends xm.d {
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
            return r.a(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", i = {0, 1, 1}, l = {126, 131}, m = "readAllParts", n = {"$this$readAllParts", "$this$readAllParts", "parts"}, s = {"L$0", "L$0", "L$1"})
    public static final class b extends xm.d {
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
            return r.b(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x0063  */
    /* JADX WARN: Code duplicated, block: B:28:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:13:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object a(@os.l nk.p r6, @os.l jn.p<? super nk.u, ? super um.d<? super lm.l2>, ? extends java.lang.Object> r7, @os.l um.d<? super lm.l2> r8) {
        /*
            boolean r0 = r8 instanceof nk.r.a
            if (r0 == 0) goto L13
            r0 = r8
            nk.r$a r0 = (nk.r.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            nk.r$a r0 = new nk.r$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            jn.p r6 = (jn.p) r6
            java.lang.Object r7 = r0.L$0
            nk.p r7 = (nk.p) r7
            lm.d1.n(r8)
        L31:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L4c
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r6 = r0.L$1
            jn.p r6 = (jn.p) r6
            java.lang.Object r7 = r0.L$0
            nk.p r7 = (nk.p) r7
            lm.d1.n(r8)
            goto L5c
        L49:
            lm.d1.n(r8)
        L4c:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.b(r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            r5 = r7
            r7 = r6
            r6 = r5
        L5c:
            nk.u r8 = (nk.u) r8
            if (r8 != 0) goto L63
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L63:
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r6.invoke(r8, r0)
            if (r8 != r1) goto L31
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: nk.r.a(nk.p, jn.p, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006c -> B:27:0x006f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object b(@os.l nk.p r6, @os.l um.d<? super java.util.List<? extends nk.u>> r7) {
        /*
            boolean r0 = r7 instanceof nk.r.b
            if (r0 == 0) goto L13
            r0 = r7
            nk.r$b r0 = (nk.r.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            nk.r$b r0 = new nk.r$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r2 = r0.L$0
            nk.p r2 = (nk.p) r2
            lm.d1.n(r7)
            goto L6f
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.lang.Object r6 = r0.L$0
            nk.p r6 = (nk.p) r6
            lm.d1.n(r7)
            goto L50
        L42:
            lm.d1.n(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r6.b(r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            nk.u r7 = (nk.u) r7
            if (r7 != 0) goto L57
            nm.k0 r6 = nm.k0.INSTANCE
            return r6
        L57:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r2.add(r7)
            r5 = r2
            r2 = r6
            r6 = r5
        L62:
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r2.b(r0)
            if (r7 != r1) goto L6f
            return r1
        L6f:
            nk.u r7 = (nk.u) r7
            if (r7 != 0) goto L74
            return r6
        L74:
            r6.add(r7)
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: nk.r.b(nk.p, um.d):java.lang.Object");
    }
}
