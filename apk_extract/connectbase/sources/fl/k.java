package fl;

import java.io.Closeable;
import lm.l2;
import nq.c2;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f6061a = 4096;

    @xm.f(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {0, 1, 1, 1, 1, 2, 2, 2}, l = {61, 63, 64}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$use$iv", "it", "closed$iv", "$this$launch", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$0", "L$1", "L$5", "I$0", "L$0", "L$1", "I$0"})
    public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
        final /* synthetic */ pl.n $first;
        final /* synthetic */ pl.n $second;
        final /* synthetic */ pl.k $this_copyToBoth;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pl.k kVar, pl.n nVar, pl.n nVar2, um.d<? super a> dVar) {
            super(2, dVar);
            this.$this_copyToBoth = kVar;
            this.$first = nVar;
            this.$second = nVar2;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$this_copyToBoth, this.$first, this.$second, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:28:0x007c A[Catch: all -> 0x006a, TryCatch #5 {all -> 0x006a, blocks: (B:52:0x0101, B:26:0x0074, B:28:0x007c, B:30:0x0084, B:32:0x008c, B:36:0x00a7, B:61:0x0111, B:62:0x0112, B:64:0x0116, B:67:0x011f, B:21:0x0065, B:59:0x010f, B:58:0x010c, B:55:0x0107, B:37:0x00b0, B:50:0x00f7), top: B:86:0x0065, inners: #0, #2 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00cd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:44:0x00ec A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:64:0x0116 A[Catch: all -> 0x006a, TryCatch #5 {all -> 0x006a, blocks: (B:52:0x0101, B:26:0x0074, B:28:0x007c, B:30:0x0084, B:32:0x008c, B:36:0x00a7, B:61:0x0111, B:62:0x0112, B:64:0x0116, B:67:0x011f, B:21:0x0065, B:59:0x010f, B:58:0x010c, B:55:0x0107, B:37:0x00b0, B:50:0x00f7), top: B:86:0x0065, inners: #0, #2 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ed -> B:46:0x00ef). Please report as a decompilation issue!!! */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            nq.s0 s0Var;
            nq.s0 s0Var2;
            Closeable closeable;
            pl.n nVar;
            pl.n nVar2;
            pl.k kVar;
            Throwable th2;
            nq.s0 s0Var3;
            pl.n nVar3;
            int i10;
            pl.n nVar4;
            tl.v vVar;
            tl.v vVarN2;
            nq.s0 s0Var4;
            pl.n nVar5;
            tl.v vVar2;
            tl.v vVarN3;
            Throwable thA;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = this.label;
            if (i11 == 0) {
                lm.d1.n(obj);
                s0Var = (nq.s0) this.L$0;
                if (this.$this_copyToBoth.p0()) {
                }
                if (s0Var instanceof pl.c) {
                    throw thA;
                }
                return l2.f10208a;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    int i12 = this.I$0;
                    tl.v vVar3 = (tl.v) this.L$5;
                    pl.k kVar2 = (pl.k) this.L$4;
                    pl.n nVar6 = (pl.n) this.L$3;
                    nVar4 = (pl.n) this.L$2;
                    Closeable closeable2 = (Closeable) this.L$1;
                    s0Var3 = (nq.s0) this.L$0;
                    try {
                        try {
                            lm.d1.n(obj);
                            i10 = i12;
                            kVar = kVar2;
                            vVar = vVar3;
                            nVar2 = nVar6;
                            closeable = closeable2;
                        } catch (Throwable th3) {
                            th2 = th3;
                            kVar = kVar2;
                            nVar2 = nVar6;
                            nVar3 = nVar4;
                            closeable = closeable2;
                            s0Var2 = s0Var3;
                            kVar.c(th2);
                            nVar3.f(th2);
                            nVar2.f(th2);
                            s0Var = s0Var2;
                            closeable.close();
                            if (this.$this_copyToBoth.p0()) {
                            }
                            if (s0Var instanceof pl.c) {
                                throw thA;
                            }
                            return l2.f10208a;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        nVar3 = nVar4;
                        s0Var2 = s0Var3;
                        kVar.c(th2);
                        nVar3.f(th2);
                        nVar2.f(th2);
                        s0Var = s0Var2;
                        closeable.close();
                        if (this.$this_copyToBoth.p0()) {
                        }
                        if (s0Var instanceof pl.c) {
                            throw thA;
                        }
                        return l2.f10208a;
                    }
                    vVarN2 = vVar.N2();
                    this.L$0 = s0Var3;
                    this.L$1 = closeable;
                    this.L$2 = nVar4;
                    this.L$3 = nVar2;
                    this.L$4 = kVar;
                    this.L$5 = null;
                    this.I$0 = i10;
                    this.label = 3;
                    if (nVar2.p(vVarN2, this) == aVar) {
                        return aVar;
                    }
                    nVar = nVar4;
                    s0Var2 = s0Var3;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kVar = (pl.k) this.L$4;
                    nVar2 = (pl.n) this.L$3;
                    nVar = (pl.n) this.L$2;
                    closeable = (Closeable) this.L$1;
                    s0Var2 = (nq.s0) this.L$0;
                    try {
                        lm.d1.n(obj);
                    } catch (Throwable th5) {
                        kVar.c(th5);
                        nVar.f(th5);
                        nVar2.f(th5);
                        s0Var = s0Var2;
                        closeable.close();
                        if (this.$this_copyToBoth.p0()) {
                        }
                        if (s0Var instanceof pl.c) {
                            throw thA;
                        }
                        return l2.f10208a;
                    }
                }
                l2 l2Var = l2.f10208a;
                s0Var = s0Var2;
                closeable.close();
                if (this.$this_copyToBoth.p0() && (!this.$first.e() || !this.$second.e())) {
                    pl.k kVar3 = this.$this_copyToBoth;
                    this.L$0 = s0Var;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 1;
                    Object objE = kVar3.E(4096L, 0, this);
                    if (objE == aVar) {
                        return aVar;
                    }
                    try {
                        s0Var4 = s0Var;
                        obj = objE;
                        closeable = (Closeable) obj;
                        nVar5 = this.$first;
                        nVar2 = this.$second;
                        kVar = this.$this_copyToBoth;
                        vVar2 = (tl.v) closeable;
                        vVarN3 = vVar2.N2();
                        this.L$0 = s0Var4;
                        this.L$1 = closeable;
                        this.L$2 = nVar5;
                        this.L$3 = nVar2;
                        this.L$4 = kVar;
                        this.L$5 = vVar2;
                        this.I$0 = 0;
                        this.label = 2;
                        if (nVar5.p(vVarN3, this) == aVar) {
                            return aVar;
                        }
                        s0Var3 = s0Var4;
                        nVar4 = nVar5;
                        vVar = vVar2;
                        i10 = 0;
                        vVarN2 = vVar.N2();
                        this.L$0 = s0Var3;
                        this.L$1 = closeable;
                        this.L$2 = nVar4;
                        this.L$3 = nVar2;
                        this.L$4 = kVar;
                        this.L$5 = null;
                        this.I$0 = i10;
                        this.label = 3;
                        if (nVar2.p(vVarN2, this) == aVar) {
                            return aVar;
                        }
                        nVar = nVar4;
                        s0Var2 = s0Var3;
                        l2 l2Var2 = l2.f10208a;
                        s0Var = s0Var2;
                        closeable.close();
                        if (this.$this_copyToBoth.p0()) {
                        }
                        if (s0Var instanceof pl.c) {
                            throw thA;
                        }
                    } catch (Throwable th6) {
                        try {
                            closeable.close();
                        } catch (Throwable th7) {
                            tl.a0.a(th6, th7);
                        }
                        throw th6;
                    }
                } else if ((s0Var instanceof pl.c) && (thA = ((pl.c) s0Var).a()) != null) {
                    throw thA;
                }
                return l2.f10208a;
            }
            nq.s0 s0Var5 = (nq.s0) this.L$0;
            try {
                lm.d1.n(obj);
                s0Var4 = s0Var5;
                closeable = (Closeable) obj;
                nVar5 = this.$first;
                nVar2 = this.$second;
                kVar = this.$this_copyToBoth;
                vVar2 = (tl.v) closeable;
                vVarN3 = vVar2.N2();
                this.L$0 = s0Var4;
                this.L$1 = closeable;
                this.L$2 = nVar5;
                this.L$3 = nVar2;
                this.L$4 = kVar;
                this.L$5 = vVar2;
                this.I$0 = 0;
                this.label = 2;
                if (nVar5.p(vVarN3, this) == aVar) {
                    return aVar;
                }
                s0Var3 = s0Var4;
                nVar4 = nVar5;
                vVar = vVar2;
                i10 = 0;
                vVarN2 = vVar.N2();
                this.L$0 = s0Var3;
                this.L$1 = closeable;
                this.L$2 = nVar4;
                this.L$3 = nVar2;
                this.L$4 = kVar;
                this.L$5 = null;
                this.I$0 = i10;
                this.label = 3;
                if (nVar2.p(vVarN2, this) == aVar) {
                    return aVar;
                }
                nVar = nVar4;
                s0Var2 = s0Var3;
                l2 l2Var3 = l2.f10208a;
                s0Var = s0Var2;
                closeable.close();
                if (this.$this_copyToBoth.p0()) {
                }
                if (s0Var instanceof pl.c) {
                    throw thA;
                }
                return l2.f10208a;
            } catch (Throwable th8) {
                try {
                    this.$first.f(th8);
                    this.$second.f(th8);
                } finally {
                    pl.o.a(this.$first);
                    pl.o.a(this.$second);
                }
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class b extends kn.n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ pl.n $first;
        final /* synthetic */ pl.n $second;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pl.n nVar, pl.n nVar2) {
            super(1);
            this.$first = nVar;
            this.$second = nVar2;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            if (th2 == null) {
                return;
            }
            this.$first.f(th2);
            this.$second.f(th2);
        }
    }

    @xm.f(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", i = {0, 1, 1, 1}, l = {25, 29}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$0", "L$1", "I$0"})
    public static final class c extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
        final /* synthetic */ pl.c $first;
        final /* synthetic */ pl.c $second;
        final /* synthetic */ pl.k $this_split;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        @xm.f(c = "io.ktor.util.ByteChannelsKt$split$1$1$1", f = "ByteChannels.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
            final /* synthetic */ tl.v $chunk;
            final /* synthetic */ pl.c $first;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(pl.c cVar, tl.v vVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$first = cVar;
                this.$chunk = vVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new a(this.$first, this.$chunk, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    pl.c cVar = this.$first;
                    tl.v vVarN2 = this.$chunk.N2();
                    this.label = 1;
                    if (cVar.p(vVarN2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lm.d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @xm.f(c = "io.ktor.util.ByteChannelsKt$split$1$1$2", f = "ByteChannels.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
            final /* synthetic */ tl.v $chunk;
            final /* synthetic */ pl.c $second;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(pl.c cVar, tl.v vVar, um.d<? super b> dVar) {
                super(2, dVar);
                this.$second = cVar;
                this.$chunk = vVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new b(this.$second, this.$chunk, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    pl.c cVar = this.$second;
                    tl.v vVarN2 = this.$chunk.N2();
                    this.label = 1;
                    if (cVar.p(vVarN2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lm.d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(pl.k kVar, pl.c cVar, pl.c cVar2, um.d<? super c> dVar) {
            super(2, dVar);
            this.$this_split = kVar;
            this.$first = cVar;
            this.$second = cVar2;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$this_split, this.$first, this.$second, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0047 A[Catch: all -> 0x0035, TryCatch #2 {all -> 0x0035, blocks: (B:30:0x009f, B:19:0x003f, B:21:0x0047, B:24:0x0058, B:41:0x00b2, B:42:0x00b3, B:44:0x00b7, B:47:0x00c0, B:14:0x002f, B:39:0x00b0, B:38:0x00ad, B:34:0x00a7), top: B:60:0x002f, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0057 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x0097 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x0098  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0098 -> B:29:0x009d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fl.k.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class d extends kn.n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ pl.c $first;
        final /* synthetic */ pl.c $second;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(pl.c cVar, pl.c cVar2) {
            super(1);
            this.$first = cVar;
            this.$second = cVar2;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            if (th2 == null) {
                return;
            }
            this.$first.c(th2);
            this.$second.c(th2);
        }
    }

    @xm.f(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", i = {}, l = {ms.a.U}, m = "toByteArray", n = {}, s = {})
    public static final class e extends xm.d {
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.c(null, this);
        }
    }

    @t0
    public static final void a(@os.l pl.k kVar, @os.l pl.n nVar, @os.l pl.n nVar2) {
        kn.l0.p(kVar, "<this>");
        kn.l0.p(nVar, "first");
        kn.l0.p(nVar2, y1.o.r.f20674f);
        nq.k.f(c2.f11831a, nq.k1.g(), null, new a(kVar, nVar, nVar2, null), 2, null).k0(new b(nVar, nVar2));
    }

    @os.l
    public static final lm.t0<pl.k, pl.k> b(@os.l pl.k kVar, @os.l nq.s0 s0Var) {
        kn.l0.p(kVar, "<this>");
        kn.l0.p(s0Var, "coroutineScope");
        pl.c cVarA = pl.e.a(true);
        pl.c cVarA2 = pl.e.a(true);
        nq.k.f(s0Var, null, null, new c(kVar, cVarA, cVarA2, null), 3, null).k0(new d(cVarA, cVarA2));
        return new lm.t0<>(cVarA, cVarA2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object c(@os.l pl.k kVar, @os.l um.d<? super byte[]> dVar) {
        e eVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object objM = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            lm.d1.n(objM);
            eVar.label = 1;
            objM = pl.m.m(kVar, eVar);
            if (objM == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lm.d1.n(objM);
        }
        return tl.d1.i((tl.v) objM, 0, 1, null);
    }
}
