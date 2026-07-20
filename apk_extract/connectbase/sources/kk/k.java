package kk;

import com.transsion.widgetslib.widget.OSMaskImageView;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetEncoder;
import jq.h0;
import kn.k1;
import kn.l0;
import kn.n0;
import lm.d1;
import lm.l2;
import nq.s0;
import nq.t0;
import pl.b0;
import pq.d0;
import pq.f0;
import tl.r0;
import tl.s;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final ByteBuffer f9232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final ByteBuffer f9233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f9234c = 45;

    @xm.f(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {415, 418}, m = "copyUntilBoundary", n = {"name", "boundaryPrefixed", "input", "writeFully", "buffer", "limit", "copied", "name", "boundaryPrefixed", "input", "writeFully", "buffer", "limit", "copied", "rc"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "I$0"})
    public static final class a extends xm.d {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return k.l(null, null, null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1", f = "Multipart.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 10, 10, 13}, l = {336, 339, 342, 349, 350, 353, 358, 362, 367, 377, 380, 389, 389, 392, 394}, m = "invokeSuspend", n = {"$this$produce", "firstBoundary", "preamble", "readBeforeParse", "$this$produce", "firstBoundary", "readBeforeParse", "$this$produce", "readBeforeParse", "$this$produce", "trailingBuffer", "readBeforeParse", "$this$produce", "trailingBuffer", "readBeforeParse", "$this$produce", "trailingBuffer", "readBeforeParse", "$this$produce", "trailingBuffer", "body", "headers", "readBeforeParse", "$this$produce", "trailingBuffer", "body", "headers", "readBeforeParse", "$this$produce", "trailingBuffer", "body", "headers", "hh", "readBeforeParse", "$this$produce", "trailingBuffer", "readBeforeParse", "$this$produce", "readBeforeParse", "$this$produce"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "J$0", "L$0", "J$0", "L$0"})
    public static final class b extends xm.o implements jn.p<d0<? super kk.j>, um.d<? super l2>, Object> {
        final /* synthetic */ ByteBuffer $boundaryPrefixed;
        final /* synthetic */ pl.k $input;
        final /* synthetic */ Long $totalLength;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pl.k kVar, ByteBuffer byteBuffer, Long l10, um.d<? super b> dVar) {
            super(2, dVar);
            this.$input = kVar;
            this.$boundaryPrefixed = byteBuffer;
            this.$totalLength = l10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$input, this.$boundaryPrefixed, this.$totalLength, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:114:0x033f  */
        /* JADX WARN: Code duplicated, block: B:52:0x01bd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:55:0x01d6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x01df  */
        /* JADX WARN: Code duplicated, block: B:60:0x01f4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x0215 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:64:0x0216  */
        /* JADX WARN: Code duplicated, block: B:67:0x0231 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:71:0x023a A[Catch: all -> 0x034a, TRY_LEAVE, TryCatch #3 {all -> 0x034a, blocks: (B:69:0x0234, B:71:0x023a), top: B:140:0x0234 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x026e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:76:0x026f  */
        /* JADX WARN: Code duplicated, block: B:79:0x0293 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:82:0x029c  */
        /* JADX WARN: Code duplicated, block: B:84:0x02a4  */
        /* JADX WARN: Code duplicated, block: B:86:0x02ba A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:87:0x02bb  */
        /* JADX WARN: Code duplicated, block: B:89:0x02c2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0291 -> B:80:0x0294). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r28) {
            /*
                Method dump skipped, instruction units count: 934
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kk.k.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l d0<? super kk.j> d0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 0, 0, 0, 1}, l = {128, OSMaskImageView.f2731x}, m = "parsePart", n = {"boundaryPrefixed", "input", "output", "limit", "headers"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0"})
    public static final class c extends xm.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.y(null, null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 1}, l = {188, 190}, m = "parsePartBodyImpl", n = {"output", "output"}, s = {"L$0", "L$0"})
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
            return k.C(null, null, null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt$parsePartBodyImpl$size$1", f = "Multipart.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.p<ByteBuffer, um.d<? super l2>, Object> {
        final /* synthetic */ pl.n $output;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(pl.n nVar, um.d<? super e> dVar) {
            super(2, dVar);
            this.$output = nVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            e eVar = new e(this.$output, dVar);
            eVar.L$0 = obj;
            return eVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                ByteBuffer byteBuffer = (ByteBuffer) this.L$0;
                pl.n nVar = this.$output;
                this.label = 1;
                if (nVar.M(byteBuffer, this) == aVar) {
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
        public final Object invoke(@os.l ByteBuffer byteBuffer, @os.m um.d<? super l2> dVar) {
            return ((e) create(byteBuffer, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0}, l = {153}, m = "parsePartHeadersImpl", n = {"builder"}, s = {"L$0"})
    public static final class f extends xm.d {
        Object L$0;
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
            return k.F(null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt$parsePreambleImpl$2", f = "Multipart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends xm.o implements jn.p<ByteBuffer, um.d<? super l2>, Object> {
        final /* synthetic */ s $output;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(s sVar, um.d<? super g> dVar) {
            super(2, dVar);
            this.$output = sVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            g gVar = new g(this.$output, dVar);
            gVar.L$0 = obj;
            return gVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            r0.a(this.$output, (ByteBuffer) this.L$0);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l ByteBuffer byteBuffer, @os.m um.d<? super l2> dVar) {
            return ((g) create(byteBuffer, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 1}, l = {211, 217}, m = "skipBoundary", n = {"input", "result"}, s = {"L$0", "L$0"})
    public static final class h extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public h(um.d<? super h> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.K(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt$skipBoundary$2", f = "Multipart.kt", i = {0, 1}, l = {218, 229}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "$this$lookAheadSuspend"}, s = {"L$0", "L$0"})
    public static final class i extends xm.o implements jn.p<pl.d0, um.d<? super l2>, Object> {
        final /* synthetic */ k1.a $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(k1.a aVar, um.d<? super i> dVar) {
            super(2, dVar);
            this.$result = aVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            i iVar = new i(this.$result, dVar);
            iVar.L$0 = obj;
            return iVar;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x007c  */
        /* JADX WARN: Code duplicated, block: B:33:0x0086  */
        /* JADX WARN: Code duplicated, block: B:35:0x0090  */
        /* JADX WARN: Code duplicated, block: B:37:0x0093  */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws IOException {
            pl.d0 d0Var;
            pl.d0 d0Var2;
            ByteBuffer byteBufferB;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    pl.d0 d0Var3 = (pl.d0) this.L$0;
                    d1.n(obj);
                    d0Var = d0Var3;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d0Var2 = (pl.d0) this.L$0;
                    d1.n(obj);
                }
                byteBufferB = d0Var2.b(1, 1);
                if (byteBufferB != null) {
                    throw new IOException("Failed to pass multipart boundary: unexpected end of stream");
                }
                if (byteBufferB.get(byteBufferB.position()) == 45) {
                    return l2.f10208a;
                }
                this.$result.element = true;
                d0Var2.b0(2);
                return l2.f10208a;
            }
            d1.n(obj);
            d0Var = (pl.d0) this.L$0;
            this.L$0 = d0Var;
            this.label = 1;
            if (d0Var.w(1, this) == aVar) {
                return aVar;
            }
            ByteBuffer byteBufferB2 = d0Var.b(0, 1);
            if (byteBufferB2 == null) {
                throw new IOException("Failed to pass multipart boundary: unexpected end of stream");
            }
            if (byteBufferB2.get(byteBufferB2.position()) != 45) {
                return l2.f10208a;
            }
            if (byteBufferB2.remaining() > 1 && byteBufferB2.get(byteBufferB2.position() + 1) == 45) {
                this.$result.element = true;
                d0Var.b0(2);
                return l2.f10208a;
            }
            this.L$0 = d0Var;
            this.label = 2;
            if (d0Var.w(2, this) == aVar) {
                return aVar;
            }
            d0Var2 = d0Var;
            byteBufferB = d0Var2.b(1, 1);
            if (byteBufferB != null) {
                throw new IOException("Failed to pass multipart boundary: unexpected end of stream");
            }
            if (byteBufferB.get(byteBufferB.position()) == 45) {
                return l2.f10208a;
            }
            this.$result.element = true;
            d0Var2.b0(2);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.d0 d0Var, @os.m um.d<? super l2> dVar) {
            return ((i) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class j extends n0 implements jn.l<b0, l2> {
        final /* synthetic */ ByteBuffer $delimiter;
        final /* synthetic */ k1.a $found;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(k1.a aVar, ByteBuffer byteBuffer) {
            super(1);
            this.$found = aVar;
            this.$delimiter = byteBuffer;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(b0 b0Var) {
            invoke2(b0Var);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l b0 b0Var) {
            l0.p(b0Var, "$this$lookAhead");
            this.$found.element = k.P(b0Var, this.$delimiter) == this.$delimiter.remaining();
        }
    }

    /* JADX INFO: renamed from: kk.k$k, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0}, l = {619}, m = "trySkipDelimiterSuspend", n = {"result"}, s = {"L$0"})
    public static final class C0245k extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0245k(um.d<? super C0245k> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.Q(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.MultipartKt$trySkipDelimiterSuspend$2", f = "Multipart.kt", i = {0, 1}, l = {620, 620}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "$this$lookAheadSuspend"}, s = {"L$0", "L$0"})
    public static final class l extends xm.o implements jn.p<pl.d0, um.d<? super l2>, Object> {
        final /* synthetic */ ByteBuffer $delimiter;
        final /* synthetic */ k1.a $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ByteBuffer byteBuffer, k1.a aVar, um.d<? super l> dVar) {
            super(2, dVar);
            this.$delimiter = byteBuffer;
            this.$result = aVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            l lVar = new l(this.$delimiter, this.$result, dVar);
            lVar.L$0 = obj;
            return lVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x005b  */
        /* JADX WARN: Code duplicated, block: B:24:0x0063  */
        /* JADX WARN: Code duplicated, block: B:27:0x0072  */
        /* JADX WARN: Code duplicated, block: B:29:0x0075  */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws IOException {
            pl.d0 d0Var;
            pl.d0 d0Var2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    d0Var = (pl.d0) this.L$0;
                    d1.n(obj);
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d0Var2 = (pl.d0) this.L$0;
                    d1.n(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    this.$result.element = false;
                    return l2.f10208a;
                }
                d0Var = d0Var2;
                if (k.P(d0Var, this.$delimiter) == this.$delimiter.remaining()) {
                    return l2.f10208a;
                }
                throw new IOException("Broken delimiter occurred");
            }
            d1.n(obj);
            pl.d0 d0Var3 = (pl.d0) this.L$0;
            int iRemaining = this.$delimiter.remaining();
            this.L$0 = d0Var3;
            this.label = 1;
            Object objW = d0Var3.w(iRemaining, this);
            if (objW == aVar) {
                return aVar;
            }
            d0Var = d0Var3;
            obj = objW;
            if (!((Boolean) obj).booleanValue()) {
                this.L$0 = d0Var;
                this.label = 2;
                obj = d0Var.w(1, this);
                if (obj == aVar) {
                    return aVar;
                }
                d0Var2 = d0Var;
                if (!((Boolean) obj).booleanValue()) {
                    this.$result.element = false;
                    return l2.f10208a;
                }
                d0Var = d0Var2;
            }
            if (k.P(d0Var, this.$delimiter) == this.$delimiter.remaining()) {
                return l2.f10208a;
            }
            throw new IOException("Broken delimiter occurred");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.d0 d0Var, @os.m um.d<? super l2> dVar) {
            return ((l) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    static {
        CharsetEncoder charsetEncoderNewEncoder = jq.f.f8800b.newEncoder();
        l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(rl.a.j(charsetEncoderNewEncoder, "\r\n", 0, 2));
        l0.m(byteBufferWrap);
        f9232a = byteBufferWrap;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8192);
        l0.m(byteBufferAllocate);
        f9233b = byteBufferAllocate;
    }

    @os.m
    @lm.k(message = "This is going to be removed. Use parseMultipart instead.")
    public static final Object A(@os.l ByteBuffer byteBuffer, @os.l pl.k kVar, @os.l pl.n nVar, @os.l kk.f fVar, long j10, @os.l um.d<? super Long> dVar) {
        return C(byteBuffer, kVar, nVar, fVar, j10, dVar);
    }

    public static Object B(ByteBuffer byteBuffer, pl.k kVar, pl.n nVar, kk.f fVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return C(byteBuffer, kVar, nVar, fVar, j10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object C(ByteBuffer byteBuffer, pl.k kVar, pl.n nVar, kk.f fVar, long j10, um.d<? super Long> dVar) throws Throwable {
        d dVar2;
        long jLongValue;
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
        d dVar3 = dVar2;
        Object objL = dVar3.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar3.label;
        if (i11 == 0) {
            d1.n(objL);
            CharSequence charSequenceE = fVar.e("Content-Length");
            Long l10 = charSequenceE == null ? null : new Long(lk.f.m(charSequenceE));
            if (l10 == null) {
                e eVar = new e(nVar, null);
                dVar3.L$0 = nVar;
                dVar3.label = 2;
                objL = l("part", byteBuffer, kVar, eVar, j10, dVar3);
                if (objL == aVar) {
                    return aVar;
                }
                jLongValue = ((Number) objL).longValue();
            } else {
                if (l10.longValue() > j10) {
                    throw new IOException("Multipart part content length limit of " + j10 + " exceeded (actual size is " + l10 + ')');
                }
                long jLongValue2 = l10.longValue();
                dVar3.L$0 = nVar;
                dVar3.label = 1;
                objL = pl.l.c(kVar, nVar, jLongValue2, dVar3);
                if (objL == aVar) {
                    return aVar;
                }
                jLongValue = ((Number) objL).longValue();
            }
        } else if (i11 == 1) {
            nVar = (pl.n) dVar3.L$0;
            d1.n(objL);
            jLongValue = ((Number) objL).longValue();
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nVar = (pl.n) dVar3.L$0;
            d1.n(objL);
            jLongValue = ((Number) objL).longValue();
        }
        nVar.flush();
        return new Long(jLongValue);
    }

    public static /* synthetic */ Object D(ByteBuffer byteBuffer, pl.k kVar, pl.n nVar, kk.f fVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return C(byteBuffer, kVar, nVar, fVar, j10, dVar);
    }

    @os.m
    @lm.k(message = "This is going to be removed. Use parseMultipart instead.")
    public static final Object E(@os.l pl.k kVar, @os.l um.d<? super kk.f> dVar) {
        return F(kVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object F(pl.k kVar, um.d<? super kk.f> dVar) throws Throwable {
        f fVar;
        Throwable th2;
        lk.c cVar;
        if (dVar instanceof f) {
            fVar = (f) dVar;
            int i10 = fVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar = new f(dVar);
            }
        } else {
            fVar = new f(dVar);
        }
        f fVar2 = fVar;
        Object obj = fVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = fVar2.label;
        if (i11 == 0) {
            d1.n(obj);
            lk.c cVar2 = new lk.c(null, 1, null);
            try {
                fVar2.L$0 = cVar2;
                fVar2.label = 1;
                Object objJ = kk.i.j(kVar, cVar2, null, fVar2, 4, null);
                if (objJ == aVar) {
                    return aVar;
                }
                obj = objJ;
                cVar = cVar2;
            } catch (Throwable th3) {
                th2 = th3;
                cVar = cVar2;
                cVar.r();
                throw th2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (lk.c) fVar2.L$0;
            try {
                d1.n(obj);
            } catch (Throwable th4) {
                th2 = th4;
                cVar.r();
                throw th2;
            }
        }
        kk.f fVar3 = (kk.f) obj;
        if (fVar3 != null) {
            return fVar3;
        }
        throw new EOFException("Failed to parse multipart headers: unexpected end of stream");
    }

    @os.m
    @lm.k(message = "This is going to be removed. Use parseMultipart instead.")
    public static final Object G(@os.l ByteBuffer byteBuffer, @os.l pl.k kVar, @os.l s sVar, long j10, @os.l um.d<? super Long> dVar) {
        return I(byteBuffer, kVar, sVar, j10, dVar);
    }

    public static Object H(ByteBuffer byteBuffer, pl.k kVar, s sVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return I(byteBuffer, kVar, sVar, j10, dVar);
    }

    public static final Object I(ByteBuffer byteBuffer, pl.k kVar, s sVar, long j10, um.d<? super Long> dVar) {
        return l("preamble/prologue", byteBuffer, kVar, new g(sVar, null), j10, dVar);
    }

    public static /* synthetic */ Object J(ByteBuffer byteBuffer, pl.k kVar, s sVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return I(byteBuffer, kVar, sVar, j10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object K(ByteBuffer byteBuffer, pl.k kVar, um.d<? super Boolean> dVar) {
        h hVar;
        k1.a aVar;
        if (dVar instanceof h) {
            hVar = (h) dVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar);
            }
        } else {
            hVar = new h(dVar);
        }
        Object objL = hVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = hVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                kVar = (pl.k) hVar.L$0;
                d1.n(objL);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (k1.a) hVar.L$0;
                d1.n(objL);
            }
            return Boolean.valueOf(aVar.element);
        }
        d1.n(objL);
        hVar.L$0 = kVar;
        hVar.label = 1;
        objL = L(kVar, byteBuffer, hVar);
        if (objL == aVar2) {
            return aVar2;
        }
        if (!((Boolean) objL).booleanValue()) {
            return Boolean.TRUE;
        }
        aVar = new k1.a();
        i iVar = new i(aVar, null);
        hVar.L$0 = aVar;
        hVar.label = 2;
        if (kVar.G(iVar, hVar) == aVar2) {
            return aVar2;
        }
        return Boolean.valueOf(aVar.element);
    }

    @os.m
    public static final Object L(@os.l pl.k kVar, @os.l ByteBuffer byteBuffer, @os.l um.d<? super Boolean> dVar) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (byteBuffer.remaining() <= 8192) {
            k1.a aVar = new k1.a();
            kVar.X(new j(aVar, byteBuffer));
            return aVar.element ? Boolean.TRUE : Q(kVar, byteBuffer, dVar);
        }
        throw new IllegalArgumentException(("Delimiter of " + byteBuffer.remaining() + " bytes is too long: at most 8192 bytes could be checked").toString());
    }

    public static final boolean M(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10) {
        int iMin = Math.min(byteBuffer.remaining(), byteBuffer2.remaining() - i10);
        if (iMin <= 0) {
            return false;
        }
        int iPosition = byteBuffer.position();
        int iPosition2 = byteBuffer2.position() + i10;
        int i11 = 0;
        while (i11 < iMin) {
            int i12 = i11 + 1;
            if (byteBuffer.get(iPosition + i11) != byteBuffer2.get(i11 + iPosition2)) {
                return false;
            }
            i11 = i12;
        }
        return true;
    }

    public static /* synthetic */ boolean N(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return M(byteBuffer, byteBuffer2, i10);
    }

    public static final int O(b0 b0Var, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferB = b0Var.b(0, 1);
        if (byteBufferB == null) {
            return 0;
        }
        int iP = p(byteBufferB, byteBuffer);
        if (iP != 0) {
            return -1;
        }
        int iMin = Math.min(byteBufferB.remaining() - iP, byteBuffer.remaining());
        int iRemaining = byteBuffer.remaining() - iMin;
        if (iRemaining > 0) {
            ByteBuffer byteBufferB2 = b0Var.b(iP + iMin, iRemaining);
            if (byteBufferB2 == null) {
                return iMin;
            }
            if (!M(byteBufferB2, byteBuffer, iMin)) {
                return -1;
            }
        }
        return byteBuffer.remaining();
    }

    public static final int P(b0 b0Var, ByteBuffer byteBuffer) throws IOException {
        int iO = O(b0Var, byteBuffer);
        if (iO == -1) {
            throw new IOException("Failed to skip delimiter: actual bytes differ from delimiter bytes");
        }
        if (iO < byteBuffer.remaining()) {
            return iO;
        }
        b0Var.b0(byteBuffer.remaining());
        return byteBuffer.remaining();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object Q(pl.k kVar, ByteBuffer byteBuffer, um.d<? super Boolean> dVar) {
        C0245k c0245k;
        k1.a aVar;
        if (dVar instanceof C0245k) {
            c0245k = (C0245k) dVar;
            int i10 = c0245k.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0245k.label = i10 - Integer.MIN_VALUE;
            } else {
                c0245k = new C0245k(dVar);
            }
        } else {
            c0245k = new C0245k(dVar);
        }
        Object obj = c0245k.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0245k.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.a aVar3 = new k1.a();
            aVar3.element = true;
            l lVar = new l(byteBuffer, aVar3, null);
            c0245k.L$0 = aVar3;
            c0245k.label = 1;
            if (kVar.G(lVar, c0245k) == aVar2) {
                return aVar2;
            }
            aVar = aVar3;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (k1.a) c0245k.L$0;
            d1.n(obj);
        }
        return Boolean.valueOf(aVar.element);
    }

    @os.m
    @lm.k(message = "This is going to be removed. Use parseMultipart instead.")
    public static final Object j(@os.l ByteBuffer byteBuffer, @os.l pl.k kVar, @os.l um.d<? super Boolean> dVar) {
        return K(byteBuffer, kVar, dVar);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Simply copy required number of bytes from input to output instead")
    public static final Object k(kk.f fVar, pl.k kVar, pl.n nVar, um.d dVar) {
        CharSequence charSequenceE = fVar.e("Content-Length");
        Object objC = pl.l.c(kVar, nVar, charSequenceE == null ? Long.MAX_VALUE : lk.f.m(charSequenceE), dVar);
        return objC == wm.a.COROUTINE_SUSPENDED ? objC : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00af  */
    /* JADX WARN: Code duplicated, block: B:29:0x00c9 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:13:0x0042, B:27:0x00c1, B:29:0x00c9, B:32:0x00d6, B:20:0x0075), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d6 A[Catch: all -> 0x0051, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:13:0x0042, B:27:0x00c1, B:29:0x00c9, B:32:0x00d6, B:20:0x0075), top: B:47:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:38:0x0105  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00f2 -> B:36:0x00ff). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object l(java.lang.String r20, java.nio.ByteBuffer r21, pl.k r22, jn.p<? super java.nio.ByteBuffer, ? super um.d<? super lm.l2>, ? extends java.lang.Object> r23, long r24, um.d<? super java.lang.Long> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.k.l(java.lang.String, java.nio.ByteBuffer, pl.k, jn.p, long, um.d):java.lang.Object");
    }

    public static /* synthetic */ Object m(String str, ByteBuffer byteBuffer, pl.k kVar, jn.p pVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return l(str, byteBuffer, kVar, pVar, j10, dVar);
    }

    @lm.k(message = "This is going to be removed.")
    public static final boolean n(@os.l kk.f fVar) {
        l0.p(fVar, "headers");
        CharSequence charSequenceE = fVar.e("Content-Type");
        if (charSequenceE == null) {
            return false;
        }
        return h0.d5(charSequenceE, "multipart/", false, 2, null);
    }

    public static final int o(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        char c10 = 0;
        int i11 = 0;
        while (i10 < length) {
            i10++;
            char cCharAt = charSequence.charAt(i10);
            if (c10 != 0) {
                char c11 = 2;
                if (c10 != 1) {
                    if (c10 != 2) {
                        c11 = 4;
                        if (c10 != 3) {
                            if (c10 == 4) {
                                c10 = 3;
                            }
                        } else if (cCharAt == '\"') {
                            i11 = 0;
                            c10 = 1;
                        } else if (cCharAt == '\\') {
                            c10 = c11;
                        }
                    } else if (cCharAt == '\"') {
                        c10 = 3;
                    } else if (cCharAt == ',') {
                        c10 = 0;
                    } else if (cCharAt == ';') {
                        i11 = 0;
                        c10 = 1;
                    }
                } else if (cCharAt == '=') {
                    c10 = c11;
                } else if (cCharAt == ';') {
                    i11 = 0;
                } else if (cCharAt == ',') {
                    c10 = 0;
                } else if (cCharAt != ' ') {
                    if (i11 == 0 && h0.Z4(charSequence, "boundary=", i10, true)) {
                        return i10;
                    }
                    i11++;
                }
            } else if (cCharAt == ';') {
                i11 = 0;
                c10 = 1;
            }
        }
        return -1;
    }

    public static final int p(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iPosition = byteBuffer2.position();
        int iRemaining = byteBuffer2.remaining();
        byte b10 = byteBuffer2.get(iPosition);
        int iLimit = byteBuffer.limit();
        int iPosition2 = byteBuffer.position();
        while (iPosition2 < iLimit) {
            int i10 = iPosition2 + 1;
            if (byteBuffer.get(iPosition2) == b10) {
                int i11 = 1;
                while (true) {
                    if (i11 < iRemaining) {
                        int i12 = i11 + 1;
                        int i13 = iPosition2 + i11;
                        if (i13 != iLimit) {
                            if (byteBuffer.get(i13) != byteBuffer2.get(i11 + iPosition)) {
                                break;
                            }
                            i11 = i12;
                        }
                    }
                    return iPosition2 - byteBuffer.position();
                }
            }
            iPosition2 = i10;
        }
        return -1;
    }

    @lm.k(message = "This is going to become internal. Use parseMultipart instead or file a ticket explaining why do you need this function.")
    @os.l
    public static final ByteBuffer q(@os.l CharSequence charSequence) {
        l0.p(charSequence, "contentType");
        return r(charSequence);
    }

    @os.l
    public static final ByteBuffer r(@os.l CharSequence charSequence) throws IOException {
        l0.p(charSequence, "contentType");
        int iO = o(charSequence);
        if (iO == -1) {
            throw new IOException("Failed to parse multipart: Content-Type's boundary parameter is missing");
        }
        int i10 = iO + 9;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(74);
        l0.o(byteBufferAllocate, "allocate(74)");
        byteBufferAllocate.put((byte) 13);
        byteBufferAllocate.put((byte) 10);
        byteBufferAllocate.put(f9234c);
        byteBufferAllocate.put(f9234c);
        int length = charSequence.length();
        char c10 = 0;
        while (i10 < length) {
            i10++;
            char cCharAt = charSequence.charAt(i10);
            int i11 = cCharAt & kn.r.f9345c;
            if ((65535 & cCharAt) > 127) {
                StringBuilder sb2 = new StringBuilder("Failed to parse multipart: wrong boundary byte 0x");
                String string = Integer.toString(i11, jq.d.a(16));
                l0.o(string, "toString(this, checkRadix(radix))");
                sb2.append(string);
                sb2.append(" - should be 7bit character");
                throw new IOException(sb2.toString());
            }
            if (c10 == 0) {
                if (cCharAt != ' ') {
                    if (cCharAt != '\"') {
                        if (cCharAt == ';' || cCharAt == ',') {
                            break;
                        }
                        byteBufferAllocate.put((byte) i11);
                        c10 = 1;
                    } else {
                        c10 = 2;
                    }
                }
            } else if (c10 != 1) {
                if (c10 != 2) {
                    if (c10 == 3) {
                        if (!byteBufferAllocate.hasRemaining()) {
                            throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
                        }
                        byteBufferAllocate.put((byte) i11);
                        c10 = 2;
                    }
                } else if (cCharAt == '\\') {
                    c10 = 3;
                } else {
                    if (cCharAt == '\"') {
                        break;
                    }
                    if (!byteBufferAllocate.hasRemaining()) {
                        throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
                    }
                    byteBufferAllocate.put((byte) i11);
                }
            } else {
                if (cCharAt == ' ' || cCharAt == ',' || cCharAt == ';') {
                    break;
                }
                if (!byteBufferAllocate.hasRemaining()) {
                    throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
                }
                byteBufferAllocate.put((byte) i11);
            }
        }
        byteBufferAllocate.flip();
        if (byteBufferAllocate.remaining() != 4) {
            return byteBufferAllocate;
        }
        throw new IOException("Empty multipart boundary is not allowed");
    }

    @lm.k(message = "This is going to be removed. Use parseMultipart(contentType) instead.")
    @os.l
    public static final f0<kk.j> s(@os.l s0 s0Var, @os.l ByteBuffer byteBuffer, @os.l pl.k kVar, @os.m Long l10) {
        l0.p(s0Var, "<this>");
        l0.p(byteBuffer, "boundaryPrefixed");
        l0.p(kVar, "input");
        return pq.b0.f(s0Var, null, 0, new b(kVar, byteBuffer, l10, null), 3, null);
    }

    @os.l
    public static final f0<kk.j> t(@os.l s0 s0Var, @os.l pl.k kVar, @os.l CharSequence charSequence, @os.m Long l10) throws IOException {
        l0.p(s0Var, "<this>");
        l0.p(kVar, "input");
        l0.p(charSequence, "contentType");
        if (h0.d5(charSequence, "multipart/", false, 2, null)) {
            return s(s0Var, r(charSequence), kVar, l10);
        }
        throw new IOException(l0.C("Failed to parse multipart: Content-Type should be multipart/* but it is ", charSequence));
    }

    @os.l
    public static final f0<kk.j> u(@os.l s0 s0Var, @os.l pl.k kVar, @os.l kk.f fVar) throws IOException {
        l0.p(s0Var, "<this>");
        l0.p(kVar, "input");
        l0.p(fVar, "headers");
        CharSequence charSequenceE = fVar.e("Content-Type");
        if (charSequenceE == null) {
            throw new IOException("Failed to parse multipart: no Content-Type header");
        }
        CharSequence charSequenceE2 = fVar.e("Content-Length");
        return t(s0Var, kVar, charSequenceE, charSequenceE2 == null ? null : Long.valueOf(lk.f.m(charSequenceE2)));
    }

    @lm.k(level = lm.m.HIDDEN, message = "Use parseMultipart with coroutine scope specified")
    public static final /* synthetic */ f0 v(um.g gVar, ByteBuffer byteBuffer, pl.k kVar, Long l10) {
        l0.p(gVar, "coroutineContext");
        l0.p(byteBuffer, "boundaryPrefixed");
        l0.p(kVar, "input");
        return s(t0.a(gVar), byteBuffer, kVar, l10);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Specify coroutine scope explicitly")
    public static final /* synthetic */ f0 w(um.g gVar, pl.k kVar, CharSequence charSequence, Long l10) {
        l0.p(gVar, "coroutineContext");
        l0.p(kVar, "input");
        l0.p(charSequence, "contentType");
        return t(t0.a(gVar), kVar, charSequence, l10);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Specify CoroutineScope explicitly")
    public static final /* synthetic */ f0 x(um.g gVar, pl.k kVar, kk.f fVar) {
        l0.p(gVar, "coroutineContext");
        l0.p(kVar, "input");
        l0.p(fVar, "headers");
        return u(t0.a(gVar), kVar, fVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kk.f] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    @os.m
    @lm.k(message = "This is going to be removed. Use parseMultipart instead.")
    public static final Object y(@os.l ByteBuffer byteBuffer, @os.l pl.k kVar, @os.l pl.n nVar, long j10, @os.l um.d<? super lm.t0<kk.f, Long>> dVar) throws Throwable {
        c cVar;
        ?? r10;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        c cVar2 = cVar;
        Object objF = cVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar2.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    j10 = cVar2.J$0;
                    nVar = (pl.n) cVar2.L$2;
                    kVar = (pl.k) cVar2.L$1;
                    ByteBuffer byteBuffer2 = (ByteBuffer) cVar2.L$0;
                    d1.n(objF);
                    r10 = byteBuffer2;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kk.f fVar = (kk.f) cVar2.L$0;
                    d1.n(objF);
                    byteBuffer = fVar;
                }
                return new lm.t0(byteBuffer, new Long(((Number) objF).longValue()));
            }
            d1.n(objF);
            cVar2.L$0 = byteBuffer;
            cVar2.L$1 = kVar;
            cVar2.L$2 = nVar;
            cVar2.J$0 = j10;
            cVar2.label = 1;
            objF = F(kVar, cVar2);
            if (objF == aVar) {
                r10 = byteBuffer;
                return aVar;
            }
            r10 = byteBuffer;
            ?? r11 = r10;
            pl.n nVar2 = nVar;
            long j11 = j10;
            kk.f fVar2 = (kk.f) objF;
            cVar2.L$0 = fVar2;
            cVar2.L$1 = null;
            cVar2.L$2 = null;
            cVar2.label = 2;
            objF = C(r11, kVar, nVar2, fVar2, j11, cVar2);
            byteBuffer = fVar2;
            if (objF == aVar) {
                return aVar;
            }
            return new lm.t0(byteBuffer, new Long(((Number) objF).longValue()));
        } catch (Throwable th2) {
            byteBuffer.j();
            throw th2;
        }
    }

    public static /* synthetic */ Object z(ByteBuffer byteBuffer, pl.k kVar, pl.n nVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return y(byteBuffer, kVar, nVar, j10, dVar);
    }
}
