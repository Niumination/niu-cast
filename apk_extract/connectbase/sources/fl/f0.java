package fl;

import com.transsion.widgetslib.widget.tablayout.TabLayout;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import lm.l2;
import nq.c2;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final short f6030a = -29921;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final byte[] f6031b = new byte[7];

    @xm.f(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0, 0, 0}, l = {52}, m = "deflateWhile", n = {"$this$deflateWhile", "deflater", "buffer", "predicate"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return f0.f(null, null, null, null, this);
        }
    }

    @xm.f(c = "io.ktor.util.DeflaterKt$deflated$1", f = "Deflater.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4}, l = {TabLayout.f3131k0, 77, 82, 90, ms.a.U}, m = "invokeSuspend", n = {"$this$writer", "crc", "deflater", "input", "compressed", "$this$writer", "crc", "deflater", "input", "compressed", "$this$writer", "crc", "deflater", "input", "compressed", "$this$writer", "crc", "deflater", "input", "compressed", "deflater", "input", "compressed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"})
    public static final class b extends xm.o implements jn.p<pl.m0, um.d<? super l2>, Object> {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        final /* synthetic */ pl.k $this_deflated;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        public static final class a extends kn.n0 implements jn.a<Boolean> {
            final /* synthetic */ Deflater $deflater;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Deflater deflater) {
                super(0);
                this.$deflater = deflater;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final Boolean invoke() {
                return Boolean.valueOf(!this.$deflater.needsInput());
            }
        }

        /* JADX INFO: renamed from: fl.f0$b$b, reason: collision with other inner class name */
        public static final class C0145b extends kn.n0 implements jn.a<Boolean> {
            final /* synthetic */ Deflater $deflater;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0145b(Deflater deflater) {
                super(0);
                this.$deflater = deflater;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final Boolean invoke() {
                return Boolean.valueOf(!this.$deflater.finished());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bm.h<ByteBuffer> hVar, boolean z10, pl.k kVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$pool = hVar;
            this.$gzip = z10;
            this.$this_deflated = kVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$pool, this.$gzip, this.$this_deflated, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00f2 A[Catch: all -> 0x013b, TRY_LEAVE, TryCatch #4 {all -> 0x013b, blocks: (B:41:0x00ea, B:43:0x00f2, B:55:0x0142, B:57:0x0146, B:60:0x0150, B:61:0x0151), top: B:86:0x00ea }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0109 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x010a  */
        /* JADX WARN: Code duplicated, block: B:49:0x0115  */
        /* JADX WARN: Code duplicated, block: B:50:0x0116 A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #3 {all -> 0x006a, blocks: (B:22:0x0065, B:47:0x010d, B:50:0x0116, B:27:0x0084), top: B:84:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x013a A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v13, types: [java.nio.ByteBuffer] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object, java.nio.ByteBuffer] */
        /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object, java.nio.ByteBuffer] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v31, types: [java.nio.ByteBuffer] */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, java.nio.ByteBuffer] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v22 */
        /* JADX WARN: Type inference failed for: r6v23 */
        /* JADX WARN: Type inference failed for: r6v24 */
        /* JADX WARN: Type inference failed for: r6v25 */
        /* JADX WARN: Type inference failed for: r6v26 */
        /* JADX WARN: Type inference failed for: r6v27 */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, java.nio.ByteBuffer] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, java.nio.ByteBuffer] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r7v8, types: [pl.k] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0115 -> B:37:0x00e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0138 -> B:37:0x00e0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 442
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fl.f0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.m0 m0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.util.DeflaterKt$deflated$2", f = "Deflater.kt", i = {}, l = {y5.a.f20714d0}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends xm.o implements jn.p<pl.i0, um.d<? super l2>, Object> {
        final /* synthetic */ um.g $coroutineContext;
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        final /* synthetic */ pl.n $this_deflated;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z10, bm.h<ByteBuffer> hVar, um.g gVar, pl.n nVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$gzip = z10;
            this.$pool = hVar;
            this.$coroutineContext = gVar;
            this.$this_deflated = nVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$gzip, this.$pool, this.$coroutineContext, this.$this_deflated, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                pl.k kVarG = f0.g(((pl.i0) this.L$0).a(), this.$gzip, this.$pool, this.$coroutineContext);
                pl.n nVar = this.$this_deflated;
                this.label = 1;
                if (pl.l.c(kVarG, nVar, Long.MAX_VALUE, this) == aVar) {
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
        public final Object invoke(@os.l pl.i0 i0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(i0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 1}, l = {37, 38, 39}, m = "putGzipHeader", n = {"$this$putGzipHeader", "$this$putGzipHeader"}, s = {"L$0", "L$0"})
    public static final class d extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f0.l(null, this);
        }
    }

    @xm.f(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0}, l = {43, 44}, m = "putGzipTrailer", n = {"$this$putGzipTrailer", "deflater"}, s = {"L$0", "L$1"})
    public static final class e extends xm.d {
        Object L$0;
        Object L$1;
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
            return f0.m(null, null, null, this);
        }
    }

    public static final void e(Deflater deflater, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byteBuffer.position(byteBuffer.position() + deflater.deflate(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object f(pl.n nVar, Deflater deflater, ByteBuffer byteBuffer, jn.a<Boolean> aVar, um.d<? super l2> dVar) {
        a aVar2;
        if (dVar instanceof a) {
            aVar2 = (a) dVar;
            int i10 = aVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(dVar);
            }
        } else {
            aVar2 = new a(dVar);
        }
        Object obj = aVar2.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar2.label;
        if (i11 == 0) {
            lm.d1.n(obj);
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jn.a<Boolean> aVar4 = (jn.a) aVar2.L$3;
            ByteBuffer byteBuffer2 = (ByteBuffer) aVar2.L$2;
            Deflater deflater2 = (Deflater) aVar2.L$1;
            pl.n nVar2 = (pl.n) aVar2.L$0;
            lm.d1.n(obj);
            aVar = aVar4;
            nVar = nVar2;
            byteBuffer = byteBuffer2;
            deflater = deflater2;
        }
        while (aVar.invoke().booleanValue()) {
            byteBuffer.clear();
            e(deflater, byteBuffer);
            byteBuffer.flip();
            aVar2.L$0 = nVar;
            aVar2.L$1 = deflater;
            aVar2.L$2 = byteBuffer;
            aVar2.L$3 = aVar;
            aVar2.label = 1;
            if (nVar.M(byteBuffer, aVar2) == aVar3) {
                return aVar3;
            }
        }
        return l2.f10208a;
    }

    @os.l
    public static final pl.k g(@os.l pl.k kVar, boolean z10, @os.l bm.h<ByteBuffer> hVar, @os.l um.g gVar) {
        kn.l0.p(kVar, "<this>");
        kn.l0.p(hVar, "pool");
        kn.l0.p(gVar, "coroutineContext");
        return pl.v.k(c2.f11831a, gVar, true, new b(hVar, z10, kVar, null)).a();
    }

    @os.l
    public static final pl.n h(@os.l pl.n nVar, boolean z10, @os.l bm.h<ByteBuffer> hVar, @os.l um.g gVar) {
        kn.l0.p(nVar, "<this>");
        kn.l0.p(hVar, "pool");
        kn.l0.p(gVar, "coroutineContext");
        return pl.v.c(c2.f11831a, gVar, true, new c(z10, hVar, gVar, nVar, null)).mo70a();
    }

    public static /* synthetic */ pl.k i(pl.k kVar, boolean z10, bm.h hVar, um.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            hVar = gl.b.a();
        }
        if ((i10 & 4) != 0) {
            gVar = nq.k1.g();
        }
        return g(kVar, z10, hVar, gVar);
    }

    public static /* synthetic */ pl.n j(pl.n nVar, boolean z10, bm.h hVar, um.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            hVar = gl.b.a();
        }
        if ((i10 & 4) != 0) {
            gVar = nq.k1.g();
        }
        return h(nVar, z10, hVar, gVar);
    }

    @os.l
    public static final byte[] k() {
        return f6031b;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0074 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object l(pl.n nVar, um.d<? super l2> dVar) {
        d dVar2;
        byte[] bArr;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i10 = dVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object obj = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 != 0) {
            if (i11 == 1) {
                nVar = (pl.n) dVar2.L$0;
                lm.d1.n(obj);
            } else if (i11 == 2) {
                nVar = (pl.n) dVar2.L$0;
                lm.d1.n(obj);
                bArr = f6031b;
                dVar2.L$0 = null;
                dVar2.label = 3;
                if (pl.o.f(nVar, bArr, dVar2) == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
            }
            return l2.f10208a;
        }
        lm.d1.n(obj);
        short sReverseBytes = Short.reverseBytes((short) (-29921));
        dVar2.L$0 = nVar;
        dVar2.label = 1;
        if (nVar.e0(sReverseBytes, dVar2) == aVar) {
            return aVar;
        }
        dVar2.L$0 = nVar;
        dVar2.label = 2;
        if (nVar.H((byte) 8, dVar2) == aVar) {
            return aVar;
        }
        bArr = f6031b;
        dVar2.L$0 = null;
        dVar2.label = 3;
        if (pl.o.f(nVar, bArr, dVar2) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object m(pl.n nVar, Checksum checksum, Deflater deflater, um.d<? super l2> dVar) {
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
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                deflater = (Deflater) eVar.L$1;
                nVar = (pl.n) eVar.L$0;
                lm.d1.n(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
            }
            return l2.f10208a;
        }
        lm.d1.n(obj);
        int iReverseBytes = Integer.reverseBytes((int) checksum.getValue());
        eVar.L$0 = nVar;
        eVar.L$1 = deflater;
        eVar.label = 1;
        if (nVar.h0(iReverseBytes, eVar) == aVar) {
            return aVar;
        }
        int iReverseBytes2 = Integer.reverseBytes(deflater.getTotalIn());
        eVar.L$0 = null;
        eVar.L$1 = null;
        eVar.label = 2;
        if (nVar.h0(iReverseBytes2, eVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    public static final void n(Deflater deflater, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            throw new IllegalArgumentException("buffer need to be array-backed");
        }
        deflater.setInput(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
    }

    public static final void o(@os.l Checksum checksum, @os.l ByteBuffer byteBuffer) {
        kn.l0.p(checksum, "<this>");
        kn.l0.p(byteBuffer, "buffer");
        if (!byteBuffer.hasArray()) {
            throw new IllegalArgumentException("buffer need to be array-backed");
        }
        checksum.update(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
    }
}
