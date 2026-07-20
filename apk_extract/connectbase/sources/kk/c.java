package kk;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import jq.a0;
import kn.l0;
import lm.a1;
import lm.d1;
import lm.l2;
import nq.c2;
import nq.s0;
import pl.h0;
import pl.i0;
import pl.m0;
import pl.v;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9197a = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9198b = 2048;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9199c = 4088;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final bm.h<StringBuilder> f9200d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final short f9201e = 3338;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final byte[] f9202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final byte[] f9203g;

    public static final class a extends bm.d<StringBuilder> {
        public a() {
            super(2048);
        }

        @Override // bm.d
        @os.l
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public StringBuilder n() {
            return new StringBuilder(128);
        }

        @Override // bm.d
        @os.l
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public StringBuilder d(@os.l StringBuilder sb2) {
            l0.p(sb2, "instance");
            a0.Y(sb2);
            return sb2;
        }
    }

    @xm.f(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1", f = "ChunkedTransferEncoding.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<m0, um.d<? super l2>, Object> {
        final /* synthetic */ long $contentLength;
        final /* synthetic */ pl.k $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pl.k kVar, long j10, um.d<? super b> dVar) {
            super(2, dVar);
            this.$input = kVar;
            this.$contentLength = j10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$input, this.$contentLength, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                m0 m0Var = (m0) this.L$0;
                pl.k kVar = this.$input;
                pl.n nVarMo71a = m0Var.mo71a();
                long j10 = this.$contentLength;
                this.label = 1;
                if (c.b(kVar, nVarMo71a, j10, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l m0 m0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: kk.c$c, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {75, 85, ms.a.T}, m = "decodeChunked", n = {"input", "out", "chunkSizeBuffer", "totalBytesCopied", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1"})
    public static final class C0243c extends xm.d {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C0243c(um.d<? super C0243c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.b(null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$2", f = "ChunkedTransferEncoding.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.p<i0, um.d<? super l2>, Object> {
        final /* synthetic */ pl.n $output;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(pl.n nVar, um.d<? super d> dVar) {
            super(2, dVar);
            this.$output = nVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            d dVar2 = new d(this.$output, dVar);
            dVar2.L$0 = obj;
            return dVar2;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                i0 i0Var = (i0) this.L$0;
                pl.n nVar = this.$output;
                pl.k kVarA = i0Var.a();
                this.label = 1;
                if (c.f(nVar, kVarA, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l i0 i0Var, @os.m um.d<? super l2> dVar) {
            return ((d) create(i0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4}, l = {179, 132, 183, 186, 137}, m = "encodeChunked", n = {"output", "input", "$this$read_u24default$iv", "output", "input", "$this$read_u24default$iv", "buffer$iv", "output", "input", "$this$read_u24default$iv", "buffer$iv", "bytesRead$iv", "output", "input", "cause$iv", "output", "input"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class e extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return c.f(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3}, l = {165, 166, 168, 169}, m = "writeChunk-xQX3x9Y", n = {"$this$writeChunk", "memory", "startIndex", "endIndex", ik.f.b.f7973h, "$this$writeChunk", "memory", "startIndex", "endIndex", ik.f.b.f7973h, "$this$writeChunk", ik.f.b.f7973h, "$this$writeChunk", ik.f.b.f7973h}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "I$0", "L$0", "I$0"})
    public static final class f extends xm.d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public f(um.d<? super f> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.m(null, null, 0, 0, this);
        }
    }

    static {
        Charset charset = jq.f.f8800b;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        f9202f = rl.a.j(charsetEncoderNewEncoder, "\r\n", 0, 2);
        CharsetEncoder charsetEncoderNewEncoder2 = charset.newEncoder();
        l0.o(charsetEncoderNewEncoder2, "charset.newEncoder()");
        f9203g = rl.a.j(charsetEncoderNewEncoder2, "0\r\n\r\n", 0, 5);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0097 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0098  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a2 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a8 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ae A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c1 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f6 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:56:0x0100  */
    /* JADX WARN: Code duplicated, block: B:58:0x010b  */
    /* JADX WARN: Code duplicated, block: B:59:0x010f A[Catch: all -> 0x0040, TRY_ENTER, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0117 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0133 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x013b A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x003b, B:50:0x00ee, B:52:0x00f6, B:31:0x009a, B:33:0x00a2, B:35:0x00a8, B:37:0x00ae, B:43:0x00c1, B:46:0x00d4, B:47:0x00d8, B:40:0x00b9, B:63:0x0133, B:64:0x013a, B:65:0x013b, B:66:0x0142, B:59:0x010f, B:60:0x0116, B:61:0x0117, B:62:0x0132, B:21:0x005b, B:24:0x006f), top: B:74:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Appendable, java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.CharSequence, java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Appendable, java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.CharSequence, java.lang.Object] */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00eb -> B:50:0x00ee). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @lm.k(message = "The contentLength is ignored for chunked transfer encoding", replaceWith = @lm.a1(expression = "decodeChunked(input, out)", imports = {}))
    public static final java.lang.Object b(@os.l pl.k r10, @os.l pl.n r11, long r12, @os.l um.d<? super lm.l2> r14) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.c.b(pl.k, pl.n, long, um.d):java.lang.Object");
    }

    @os.m
    public static final Object c(@os.l pl.k kVar, @os.l pl.n nVar, @os.l um.d<? super l2> dVar) {
        Object objB = b(kVar, nVar, -1L, dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
    }

    @lm.k(message = "Specify content length if known or pass -1L", replaceWith = @a1(expression = "decodeChunked(input, -1L)", imports = {}))
    @os.l
    public static final pl.l0 d(@os.l s0 s0Var, @os.l pl.k kVar) {
        l0.p(s0Var, "<this>");
        l0.p(kVar, "input");
        return e(s0Var, kVar, -1L);
    }

    @os.l
    public static final pl.l0 e(@os.l s0 s0Var, @os.l pl.k kVar, long j10) {
        l0.p(s0Var, "<this>");
        l0.p(kVar, "input");
        return v.o(s0Var, s0Var.getCoroutineContext(), false, new b(kVar, j10, null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00b8 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #5 {all -> 0x005b, blocks: (B:23:0x0056, B:71:0x0152, B:41:0x00b2, B:43:0x00b8, B:74:0x0157), top: B:91:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d1 A[Catch: all -> 0x00d9, TRY_LEAVE, TryCatch #4 {all -> 0x00d9, blocks: (B:47:0x00cd, B:49:0x00d1), top: B:93:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:63:0x012e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [kk.c$e, um.d] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kk.c$e, um.d] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object, pl.n] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object, pl.n] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kk.c$e] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v26, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v4, types: [kk.c$e, um.d] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r1v9, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [pl.k] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [pl.k] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [tl.e] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, tl.e] */
    /* JADX WARN: Type inference failed for: r3v7, types: [kk.c$e, um.d] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x012c -> B:29:0x0072). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object f(@os.l pl.n r19, @os.l pl.k r20, @os.l um.d<? super lm.l2> r21) {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.c.f(pl.n, pl.k, um.d):java.lang.Object");
    }

    @os.m
    public static final Object g(@os.l pl.n nVar, @os.l um.g gVar, @os.l um.d<? super h0> dVar) {
        return v.c(c2.f11831a, gVar, false, new d(nVar, null));
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void k() {
    }

    public static final void l(pl.k kVar) throws Throwable {
        Throwable thA = kVar instanceof pl.c ? kVar.a() : null;
        if (thA != null) {
            throw thA;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object m(pl.n nVar, ByteBuffer byteBuffer, int i10, int i11, um.d<? super Integer> dVar) {
        f fVar;
        int i12;
        pl.n nVar2;
        int i13;
        ByteBuffer byteBuffer2;
        int i14;
        pl.n nVar3;
        byte[] bArr;
        if (dVar instanceof f) {
            fVar = (f) dVar;
            int i15 = fVar.label;
            if ((i15 & Integer.MIN_VALUE) != 0) {
                fVar.label = i15 - Integer.MIN_VALUE;
            } else {
                fVar = new f(dVar);
            }
        } else {
            fVar = new f(dVar);
        }
        Object obj = fVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i16 = fVar.label;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = fVar.I$2;
                i11 = fVar.I$1;
                i10 = fVar.I$0;
                byteBuffer = (ByteBuffer) fVar.L$1;
                pl.n nVar4 = (pl.n) fVar.L$0;
                d1.n(obj);
                i12 = i17;
                nVar = nVar4;
            } else if (i16 == 2) {
                i13 = fVar.I$2;
                i14 = fVar.I$1;
                i10 = fVar.I$0;
                byteBuffer2 = (ByteBuffer) fVar.L$1;
                nVar2 = (pl.n) fVar.L$0;
                d1.n(obj);
                fVar.L$0 = nVar2;
                fVar.L$1 = null;
                fVar.I$0 = i13;
                fVar.label = 3;
                if (nVar2.z(byteBuffer2, i10, i14, fVar) == aVar) {
                    return aVar;
                }
                nVar3 = nVar2;
                bArr = f9202f;
                fVar.L$0 = nVar3;
                fVar.I$0 = i13;
                fVar.label = 4;
                if (pl.o.f(nVar3, bArr, fVar) == aVar) {
                    return aVar;
                }
            } else if (i16 == 3) {
                i13 = fVar.I$0;
                nVar3 = (pl.n) fVar.L$0;
                d1.n(obj);
                bArr = f9202f;
                fVar.L$0 = nVar3;
                fVar.I$0 = i13;
                fVar.label = 4;
                if (pl.o.f(nVar3, bArr, fVar) == aVar) {
                    return aVar;
                }
            } else {
                if (i16 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i13 = fVar.I$0;
                nVar3 = (pl.n) fVar.L$0;
                d1.n(obj);
            }
            nVar3.flush();
            return new Integer(i13);
        }
        d1.n(obj);
        i12 = i11 - i10;
        fVar.L$0 = nVar;
        fVar.L$1 = byteBuffer;
        fVar.I$0 = i10;
        fVar.I$1 = i11;
        fVar.I$2 = i12;
        fVar.label = 1;
        if (lk.f.q(nVar, i12, fVar) == aVar) {
            return aVar;
        }
        fVar.L$0 = nVar;
        fVar.L$1 = byteBuffer;
        fVar.I$0 = i10;
        fVar.I$1 = i11;
        fVar.I$2 = i12;
        fVar.label = 2;
        if (nVar.e0(f9201e, fVar) == aVar) {
            return aVar;
        }
        nVar2 = nVar;
        i13 = i12;
        int i18 = i11;
        byteBuffer2 = byteBuffer;
        i14 = i18;
        fVar.L$0 = nVar2;
        fVar.L$1 = null;
        fVar.I$0 = i13;
        fVar.label = 3;
        if (nVar2.z(byteBuffer2, i10, i14, fVar) == aVar) {
            return aVar;
        }
        nVar3 = nVar2;
        bArr = f9202f;
        fVar.L$0 = nVar3;
        fVar.I$0 = i13;
        fVar.label = 4;
        if (pl.o.f(nVar3, bArr, fVar) == aVar) {
            return aVar;
        }
        nVar3.flush();
        return new Integer(i13);
    }
}
