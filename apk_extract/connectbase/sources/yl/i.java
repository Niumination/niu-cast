package yl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import jn.p;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.c2;
import nq.k1;
import os.l;
import os.m;
import pl.m0;
import pl.n;
import pl.v;
import tl.f0;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    @xm.f(c = "io.ktor.utils.io.jvm.javaio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {28}, m = "copyTo", n = {"$this$copyTo", "channel", "buffer", "limit", "copied", "bufferSize", "rc"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "I$0"})
    public static final class a extends xm.d {
        int I$0;
        long J$0;
        long J$1;
        long J$2;
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
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.a(null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1", f = "Reading.kt", i = {0, 0}, l = {60}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
    public static final class b extends o implements p<m0, um.d<? super l2>, Object> {
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        final /* synthetic */ InputStream $this_toByteReadChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bm.h<ByteBuffer> hVar, InputStream inputStream, um.d<? super b> dVar) {
            super(2, dVar);
            this.$pool = hVar;
            this.$this_toByteReadChannel = inputStream;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            b bVar = new b(this.$pool, this.$this_toByteReadChannel, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws IOException {
            ByteBuffer byteBufferW0;
            m0 m0Var;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                m0 m0Var2 = (m0) this.L$0;
                byteBufferW0 = this.$pool.W0();
                m0Var = m0Var2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBufferW0 = (ByteBuffer) this.L$1;
                m0Var = (m0) this.L$0;
                try {
                    d1.n(obj);
                } catch (Throwable th2) {
                    try {
                        m0Var.mo71a().f(th2);
                    } finally {
                        this.$pool.recycle(byteBufferW0);
                        this.$this_toByteReadChannel.close();
                    }
                }
            }
            while (true) {
                byteBufferW0.clear();
                int i11 = this.$this_toByteReadChannel.read(byteBufferW0.array(), byteBufferW0.arrayOffset() + byteBufferW0.position(), byteBufferW0.remaining());
                if (i11 < 0) {
                    return l2.f10208a;
                }
                if (i11 != 0) {
                    byteBufferW0.position(byteBufferW0.position() + i11);
                    byteBufferW0.flip();
                    n nVarMo71a = m0Var.mo71a();
                    this.L$0 = m0Var;
                    this.L$1 = byteBufferW0;
                    this.label = 1;
                    if (nVarMo71a.M(byteBufferW0, this) == aVar) {
                        return aVar;
                    }
                }
            }
        }

        @Override // jn.p
        @m
        public final Object invoke(@l m0 m0Var, @m um.d<? super l2> dVar) {
            return ((b) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2", f = "Reading.kt", i = {0, 0}, l = {89}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
    public static final class c extends o implements p<m0, um.d<? super l2>, Object> {
        final /* synthetic */ bm.h<byte[]> $pool;
        final /* synthetic */ InputStream $this_toByteReadChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bm.h<byte[]> hVar, InputStream inputStream, um.d<? super c> dVar) {
            super(2, dVar);
            this.$pool = hVar;
            this.$this_toByteReadChannel = inputStream;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            c cVar = new c(this.$pool, this.$this_toByteReadChannel, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws IOException {
            byte[] bArrW0;
            m0 m0Var;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                m0 m0Var2 = (m0) this.L$0;
                bArrW0 = this.$pool.W0();
                m0Var = m0Var2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bArrW0 = (byte[]) this.L$1;
                m0Var = (m0) this.L$0;
                try {
                    d1.n(obj);
                } catch (Throwable th2) {
                    try {
                        m0Var.mo71a().f(th2);
                        this.$pool.recycle(bArrW0);
                    } finally {
                        this.$pool.recycle(bArrW0);
                        this.$this_toByteReadChannel.close();
                    }
                }
            }
            while (true) {
                int i11 = this.$this_toByteReadChannel.read(bArrW0, 0, bArrW0.length);
                if (i11 < 0) {
                    this.$pool.recycle(bArrW0);
                    return l2.f10208a;
                }
                if (i11 != 0) {
                    n nVarMo71a = m0Var.mo71a();
                    this.L$0 = m0Var;
                    this.L$1 = bArrW0;
                    this.label = 1;
                    if (nVarMo71a.i(bArrW0, 0, i11, this) == aVar) {
                        return aVar;
                    }
                }
            }
        }

        @Override // jn.p
        @m
        public final Object invoke(@l m0 m0Var, @m um.d<? super l2> dVar) {
            return ((c) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b3 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x009f -> B:48:0x00a6). Please report as a decompilation issue!!! */
    @m
    public static final Object a(@l InputStream inputStream, @l n nVar, long j10, @l um.d<? super Long> dVar) throws Throwable {
        a aVar;
        byte[] bArr;
        long length;
        byte[] bArr2;
        long j11;
        a aVar2;
        long j12;
        InputStream inputStream2;
        n nVar2;
        int i10;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i11 = aVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                aVar.label = i11 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i12 = aVar.label;
        if (i12 == 0) {
            d1.n(obj);
            if (j10 < 0) {
                throw new IllegalArgumentException(l0.C("Limit shouldn't be negative: ", new Long(j10)).toString());
            }
            byte[] bArrW0 = bm.a.a().W0();
            try {
                length = bArrW0.length;
                bArr2 = bArrW0;
                j11 = 0;
                aVar2 = aVar;
                j12 = j10;
                inputStream2 = inputStream;
                nVar2 = nVar;
                while (true) {
                    if (j11 >= j12) {
                    }
                    Long l10 = new Long(j11);
                    bm.a.a().recycle(bArr2);
                    return l10;
                }
            } catch (Throwable th2) {
                th = th2;
                bArr = bArrW0;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i13 = aVar.I$0;
            long j13 = aVar.J$2;
            long j14 = aVar.J$1;
            long j15 = aVar.J$0;
            bArr = (byte[]) aVar.L$2;
            n nVar3 = (n) aVar.L$1;
            InputStream inputStream3 = (InputStream) aVar.L$0;
            try {
                d1.n(obj);
                bArr2 = bArr;
                nVar2 = nVar3;
                aVar2 = aVar;
                j12 = j15;
                long j16 = j13;
                try {
                    long j17 = j14 + ((long) i13);
                    inputStream2 = inputStream3;
                    length = j16;
                    j11 = j17;
                    do {
                        if (j11 >= j12 && (i10 = inputStream2.read(bArr2, 0, (int) Math.min(j12 - j11, length))) != -1) {
                        }
                        Long l11 = new Long(j11);
                        bm.a.a().recycle(bArr2);
                        return l11;
                    } while (i10 <= 0);
                    aVar2.L$0 = inputStream2;
                    aVar2.L$1 = nVar2;
                    aVar2.L$2 = bArr2;
                    aVar2.J$0 = j12;
                    aVar2.J$1 = j11;
                    aVar2.J$2 = length;
                    aVar2.I$0 = i10;
                    aVar2.label = 1;
                    if (nVar2.i(bArr2, 0, i10, aVar2) == aVar3) {
                        return aVar3;
                    }
                    inputStream3 = inputStream2;
                    i13 = i10;
                    long j18 = length;
                    j14 = j11;
                    j16 = j18;
                    long j19 = j14 + ((long) i13);
                    inputStream2 = inputStream3;
                    length = j16;
                    j11 = j19;
                    while (true) {
                        if (j11 >= j12) {
                        }
                        Long l12 = new Long(j11);
                        bm.a.a().recycle(bArr2);
                        return l12;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bArr = bArr2;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        bm.a.a().recycle(bArr);
        throw th;
    }

    public static /* synthetic */ Object b(InputStream inputStream, n nVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return a(inputStream, nVar, j10, dVar);
    }

    @f0
    @l
    public static final pl.k c(@l InputStream inputStream, @l um.g gVar, @l bm.h<ByteBuffer> hVar) {
        l0.p(inputStream, "<this>");
        l0.p(gVar, "context");
        l0.p(hVar, "pool");
        return v.k(c2.f11831a, gVar, true, new b(hVar, inputStream, null)).a();
    }

    public static /* synthetic */ pl.k d(InputStream inputStream, um.g gVar, bm.h hVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.c();
        }
        return c(inputStream, gVar, hVar);
    }

    @in.i(name = "toByteReadChannelWithArrayPool")
    @f0
    @l
    public static final pl.k e(@l InputStream inputStream, @l um.g gVar, @l bm.h<byte[]> hVar) {
        l0.p(inputStream, "<this>");
        l0.p(gVar, "context");
        l0.p(hVar, "pool");
        return v.k(c2.f11831a, gVar, true, new c(hVar, inputStream, null)).a();
    }

    public static /* synthetic */ pl.k f(InputStream inputStream, um.g gVar, bm.h hVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = k1.c();
        }
        if ((i10 & 2) != 0) {
            hVar = bm.a.a();
        }
        return e(inputStream, gVar, hVar);
    }
}
