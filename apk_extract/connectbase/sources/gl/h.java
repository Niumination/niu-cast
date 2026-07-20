package gl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import jn.p;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.k1;
import nq.r2;
import nq.t0;
import os.m;
import pl.m0;
import pl.n;
import pl.v;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    @xm.f(c = "io.ktor.util.cio.InputStreamAdaptersKt$toByteReadChannel$1", f = "InputStreamAdapters.kt", i = {0, 0}, l = {34}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
    public static final class a extends o implements p<m0, um.d<? super l2>, Object> {
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        final /* synthetic */ InputStream $this_toByteReadChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bm.h<ByteBuffer> hVar, InputStream inputStream, um.d<? super a> dVar) {
            super(2, dVar);
            this.$pool = hVar;
            this.$this_toByteReadChannel = inputStream;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$pool, this.$this_toByteReadChannel, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) throws IOException {
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
        public final Object invoke(@os.l m0 m0Var, @m um.d<? super l2> dVar) {
            return ((a) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final pl.k a(@os.l InputStream inputStream, @os.l bm.h<ByteBuffer> hVar, @os.l um.g gVar, @os.l nq.l2 l2Var) {
        l0.p(inputStream, "<this>");
        l0.p(hVar, "pool");
        l0.p(gVar, "context");
        l0.p(l2Var, "parent");
        return v.k(t0.a(gVar), l2Var, true, new a(hVar, inputStream, null)).a();
    }

    public static /* synthetic */ pl.k b(InputStream inputStream, bm.h hVar, um.g gVar, nq.l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hVar = b.a();
        }
        if ((i10 & 2) != 0) {
            gVar = k1.g();
        }
        if ((i10 & 4) != 0) {
            l2Var = r2.c(null, 1, null);
        }
        return a(inputStream, hVar, gVar, l2Var);
    }
}
