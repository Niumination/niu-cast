package zl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import kn.k1;
import kn.l0;
import kn.n0;
import lm.d1;
import lm.l2;
import os.l;
import os.m;
import pl.n;
import xm.d;
import xm.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: zl.a$a, reason: collision with other inner class name */
    @f(c = "io.ktor.utils.io.jvm.nio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0}, l = {40}, m = "copyTo", n = {"ch", "copied", "eof", "copy", "limit", "needFlush"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0"})
    public static final class C0607a extends d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C0607a(um.d<? super C0607a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.b(null, null, 0L, this);
        }
    }

    public static final class b extends n0 implements jn.l<ByteBuffer, l2> {
        final /* synthetic */ k1.g $copied;
        final /* synthetic */ k1.a $eof;
        final /* synthetic */ long $limit;
        final /* synthetic */ ReadableByteChannel $this_copyTo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j10, k1.g gVar, ReadableByteChannel readableByteChannel, k1.a aVar) {
            super(1);
            this.$limit = j10;
            this.$copied = gVar;
            this.$this_copyTo = readableByteChannel;
            this.$eof = aVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(ByteBuffer byteBuffer) throws IOException {
            invoke2(byteBuffer);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l ByteBuffer byteBuffer) throws IOException {
            l0.p(byteBuffer, "bb");
            long j10 = this.$limit - this.$copied.element;
            if (j10 >= byteBuffer.remaining()) {
                int i10 = this.$this_copyTo.read(byteBuffer);
                if (i10 == -1) {
                    this.$eof.element = true;
                    return;
                } else {
                    this.$copied.element += (long) i10;
                    return;
                }
            }
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + ((int) j10));
            int i11 = this.$this_copyTo.read(byteBuffer);
            if (i11 == -1) {
                this.$eof.element = true;
            } else {
                this.$copied.element += (long) i11;
            }
            byteBuffer.limit(iLimit);
        }
    }

    @m
    public static final Object a(@l Pipe pipe, @l n nVar, long j10, @l um.d<? super Long> dVar) {
        Pipe.SourceChannel sourceChannelSource = pipe.source();
        l0.o(sourceChannelSource, "source()");
        return b(sourceChannelSource, nVar, j10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009b -> B:31:0x009e). Please report as a decompilation issue!!! */
    @m
    public static final Object b(@l ReadableByteChannel readableByteChannel, @l n nVar, long j10, @l um.d<? super Long> dVar) {
        C0607a c0607a;
        k1.a aVar;
        jn.l<? super ByteBuffer, l2> bVar;
        int i10;
        k1.g gVar;
        long j11;
        if (dVar instanceof C0607a) {
            c0607a = (C0607a) dVar;
            int i11 = c0607a.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c0607a.label = i11 - Integer.MIN_VALUE;
            } else {
                c0607a = new C0607a(dVar);
            }
        } else {
            c0607a = new C0607a(dVar);
        }
        Object obj = c0607a.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i12 = c0607a.label;
        if (i12 == 0) {
            d1.n(obj);
            if (j10 < 0) {
                throw new IllegalArgumentException(l0.C("Limit shouldn't be negative: ", new Long(j10)).toString());
            }
            if ((readableByteChannel instanceof SelectableChannel) && !((SelectableChannel) readableByteChannel).isBlocking()) {
                throw new IllegalArgumentException("Non-blocking channels are not supported");
            }
            k1.g gVar2 = new k1.g();
            aVar = new k1.a();
            bVar = new b(j10, gVar2, readableByteChannel, aVar);
            i10 = !nVar.q0() ? 1 : 0;
            gVar = gVar2;
            j11 = gVar.element;
            if (j11 < j10 || aVar.element) {
                return new Long(j11);
            }
            c0607a.L$0 = nVar;
            c0607a.L$1 = gVar;
            c0607a.L$2 = aVar;
            c0607a.L$3 = bVar;
            c0607a.J$0 = j10;
            c0607a.I$0 = i10;
            c0607a.label = 1;
            if (nVar.k0(1, bVar, c0607a) == aVar2) {
                return aVar2;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = c0607a.I$0;
            long j12 = c0607a.J$0;
            jn.l<? super ByteBuffer, l2> lVar = (jn.l) c0607a.L$3;
            aVar = (k1.a) c0607a.L$2;
            gVar = (k1.g) c0607a.L$1;
            n nVar2 = (n) c0607a.L$0;
            d1.n(obj);
            bVar = lVar;
            j10 = j12;
            nVar = nVar2;
        }
        if (i10 != 0) {
            nVar.flush();
        }
        j11 = gVar.element;
        if (j11 < j10) {
        }
        return new Long(j11);
    }

    public static /* synthetic */ Object c(Pipe pipe, n nVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return a(pipe, nVar, j10, dVar);
    }

    public static /* synthetic */ Object d(ReadableByteChannel readableByteChannel, n nVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return b(readableByteChannel, nVar, j10, dVar);
    }
}
