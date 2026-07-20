package gl;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import jn.p;
import kn.k1;
import kn.l0;
import kn.n0;
import lm.a1;
import lm.d1;
import lm.l2;
import nq.c2;
import nq.r0;
import nq.t0;
import os.m;
import pl.i0;
import pl.m0;
import pl.n;
import pl.p0;
import pl.v;
import tl.a0;
import tl.o0;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    @xm.f(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1", f = "FileChannels.kt", i = {0, 0, 1, 1}, l = {48, ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL}, m = "invokeSuspend", n = {"$this$use$iv", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class a extends o implements p<m0, um.d<? super l2>, Object> {
        final /* synthetic */ long $endInclusive;
        final /* synthetic */ RandomAccessFile $file;
        final /* synthetic */ long $fileLength;
        final /* synthetic */ long $start;
        int I$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: gl.g$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1", f = "FileChannels.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "invokeSuspend", n = {"$this$writeSuspendSession"}, s = {"L$0"})
        public static final class C0181a extends o implements p<p0, um.d<? super l2>, Object> {
            final /* synthetic */ m0 $$this$writer;
            final /* synthetic */ FileChannel $fileChannel;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0181a(m0 m0Var, FileChannel fileChannel, um.d<? super C0181a> dVar) {
                super(2, dVar);
                this.$$this$writer = m0Var;
                this.$fileChannel = fileChannel;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@m Object obj, @os.l um.d<?> dVar) {
                C0181a c0181a = new C0181a(this.$$this$writer, this.$fileChannel, dVar);
                c0181a.L$0 = obj;
                return c0181a;
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@os.l Object obj) throws IOException {
                p0 p0Var;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    p0Var = (p0) this.L$0;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p0Var = (p0) this.L$0;
                    d1.n(obj);
                }
                while (true) {
                    o0 o0VarB = p0Var.b(1);
                    if (o0VarB == null) {
                        this.$$this$writer.mo71a().flush();
                        this.L$0 = p0Var;
                        this.label = 1;
                        if (p0Var.c(1, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        int iA = fl.j.a(this.$fileChannel, o0VarB);
                        if (iA == -1) {
                            return l2.f10208a;
                        }
                        p0Var.a(iA);
                    }
                }
            }

            @Override // jn.p
            @m
            public final Object invoke(@os.l p0 p0Var, @m um.d<? super l2> dVar) {
                return ((C0181a) create(p0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public static final class b extends n0 implements jn.l<ByteBuffer, Boolean> {
            final /* synthetic */ long $endInclusive;
            final /* synthetic */ FileChannel $fileChannel;
            final /* synthetic */ k1.g $position;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j10, k1.g gVar, FileChannel fileChannel) {
                super(1);
                this.$endInclusive = j10;
                this.$position = gVar;
                this.$fileChannel = fileChannel;
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l ByteBuffer byteBuffer) throws IOException {
                int i10;
                l0.p(byteBuffer, "buffer");
                long j10 = (this.$endInclusive - this.$position.element) + 1;
                if (j10 < byteBuffer.remaining()) {
                    int iLimit = byteBuffer.limit();
                    byteBuffer.limit(byteBuffer.position() + ((int) j10));
                    i10 = this.$fileChannel.read(byteBuffer);
                    byteBuffer.limit(iLimit);
                } else {
                    i10 = this.$fileChannel.read(byteBuffer);
                }
                if (i10 > 0) {
                    this.$position.element += (long) i10;
                }
                return Boolean.valueOf(i10 != -1 && this.$position.element <= this.$endInclusive);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, long j11, long j12, RandomAccessFile randomAccessFile, um.d<? super a> dVar) {
            super(2, dVar);
            this.$start = j10;
            this.$endInclusive = j11;
            this.$fileLength = j12;
            this.$file = randomAccessFile;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$start, this.$endInclusive, this.$fileLength, this.$file, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            Throwable th2;
            Closeable closeable;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                m0 m0Var = (m0) this.L$0;
                long j10 = this.$start;
                if (!(j10 >= 0)) {
                    throw new IllegalArgumentException(l0.C("start position shouldn't be negative but it is ", new Long(j10)).toString());
                }
                long j11 = this.$endInclusive;
                boolean z10 = j11 <= this.$fileLength - 1;
                RandomAccessFile randomAccessFile = this.$file;
                if (!z10) {
                    throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + randomAccessFile.length() + ", endInclusive = " + j11).toString());
                }
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    l0.o(channel, "file.channel");
                    if (j10 > 0) {
                        channel.position(j10);
                    }
                    if (j11 == -1) {
                        n nVarMo71a = m0Var.mo71a();
                        C0181a c0181a = new C0181a(m0Var, channel, null);
                        this.L$0 = randomAccessFile;
                        this.I$0 = 0;
                        this.label = 1;
                        if (nVarMo71a.J(c0181a, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        k1.g gVar = new k1.g();
                        gVar.element = j10;
                        n nVarMo71a2 = m0Var.mo71a();
                        b bVar = new b(j11, gVar, channel);
                        this.L$0 = randomAccessFile;
                        this.I$0 = 0;
                        this.label = 2;
                        if (nVarMo71a2.g0(bVar, this) == aVar) {
                            return aVar;
                        }
                    }
                    closeable = randomAccessFile;
                } catch (Throwable th3) {
                    th2 = th3;
                    closeable = randomAccessFile;
                    closeable.close();
                    throw th2;
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$0;
                try {
                    d1.n(obj);
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        closeable.close();
                        throw th2;
                    } catch (Throwable th5) {
                        a0.a(th2, th5);
                        throw th2;
                    }
                }
            }
            l2 l2Var = l2.f10208a;
            closeable.close();
            return l2Var;
        }

        @Override // jn.p
        @m
        public final Object invoke(@os.l m0 m0Var, @m um.d<? super l2> dVar) {
            return ((a) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", i = {0, 0, 0}, l = {y5.a.f20716e0}, m = "invokeSuspend", n = {"$this$use$iv", "file", "closed$iv"}, s = {"L$0", "L$1", "I$0"})
    public static final class b extends o implements p<i0, um.d<? super l2>, Object> {
        final /* synthetic */ File $this_writeChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(File file, um.d<? super b> dVar) {
            super(2, dVar);
            this.$this_writeChannel = file;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$this_writeChannel, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            Closeable closeable;
            RandomAccessFile randomAccessFile;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                i0 i0Var = (i0) this.L$0;
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.$this_writeChannel, "rw");
                try {
                    pl.k kVarA = i0Var.a();
                    FileChannel channel = randomAccessFile2.getChannel();
                    l0.o(channel, "file.channel");
                    this.L$0 = randomAccessFile2;
                    this.L$1 = randomAccessFile2;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = zl.b.d(kVarA, channel, 0L, this, 2, null);
                    if (obj == aVar) {
                        return aVar;
                    }
                    closeable = randomAccessFile2;
                    randomAccessFile = closeable;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = randomAccessFile2;
                    closeable.close();
                    throw th;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                RandomAccessFile randomAccessFile3 = (RandomAccessFile) this.L$1;
                closeable = (Closeable) this.L$0;
                try {
                    d1.n(obj);
                    randomAccessFile = randomAccessFile3;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        closeable.close();
                    } catch (Throwable th4) {
                        a0.a(th, th4);
                    }
                    throw th;
                }
            }
            randomAccessFile.setLength(((Number) obj).longValue());
            l2 l2Var = l2.f10208a;
            closeable.close();
            return l2Var;
        }

        @Override // jn.p
        @m
        public final Object invoke(@os.l i0 i0Var, @m um.d<? super l2> dVar) {
            return ((b) create(i0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final pl.k a(@os.l File file, long j10, long j11, @os.l um.g gVar) {
        l0.p(file, "<this>");
        l0.p(gVar, "coroutineContext");
        return v.k(t0.a(gVar), new r0("file-reader").plus(gVar), false, new a(j10, j11, file.length(), new RandomAccessFile(file, "r"), null)).a();
    }

    public static /* synthetic */ pl.k b(File file, long j10, long j11, um.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            j11 = -1;
        }
        long j13 = j11;
        if ((i10 & 4) != 0) {
            gVar = nq.k1.c();
        }
        return a(file, j12, j13, gVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Pool is not required here anymore so use writeChannel without specifying a pool.", replaceWith = @a1(expression = "writeChannel()", imports = {}))
    @os.l
    public static final n c(@os.l File file, @os.l bm.h<ByteBuffer> hVar) {
        l0.p(file, "<this>");
        l0.p(hVar, "pool");
        return e(file, null, 1, null);
    }

    @os.l
    public static final n d(@os.l File file, @os.l um.g gVar) {
        l0.p(file, "<this>");
        l0.p(gVar, "coroutineContext");
        return v.c(c2.f11831a, new r0("file-writer").plus(gVar), true, new b(file, null)).mo70a();
    }

    public static /* synthetic */ n e(File file, um.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = nq.k1.c();
        }
        return d(file, gVar);
    }
}
