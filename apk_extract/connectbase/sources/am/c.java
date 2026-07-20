package am;

import bm.h;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kn.l0;
import lm.k;
import lm.l2;
import lm.y;
import os.l;
import ql.f;
import ql.i;
import tl.d1;
import tl.m;
import tl.n;
import tl.o0;
import tl.s;
import tl.v;
import tl.w0;
import tn.u;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    @k(message = "Use read(Memory) instead.")
    public static final int a(@l ReadableByteChannel readableByteChannel, @l tl.e eVar) throws IOException {
        l0.p(readableByteChannel, "<this>");
        l0.p(eVar, "buffer");
        m mVar = eVar.f15821b;
        int i10 = mVar.f15872a;
        int i11 = mVar.f15874c;
        if (i10 - i11 == 0) {
            return 0;
        }
        int i12 = readableByteChannel.read(i.j(eVar.f15820a, i11, i10 - i11));
        if (i12 == -1) {
            return -1;
        }
        eVar.b(i12);
        return i12;
    }

    @k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final int b(ReadableByteChannel readableByteChannel, o0 o0Var) {
        l0.p(readableByteChannel, "<this>");
        l0.p(o0Var, "buffer");
        m mVar = o0Var.f15821b;
        if (mVar.f15872a - mVar.f15874c == 0) {
            return 0;
        }
        return readableByteChannel.read(o0Var.C2());
    }

    public static final int c(@l ReadableByteChannel readableByteChannel, @l ByteBuffer byteBuffer, int i10, int i11) {
        l0.p(readableByteChannel, "$this$read");
        l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        return readableByteChannel.read(i.j(byteBuffer, i10, i11));
    }

    public static /* synthetic */ int d(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = byteBuffer.limit() - i10;
        }
        return c(readableByteChannel, byteBuffer, i10, i11);
    }

    @l
    public static final v e(@l ReadableByteChannel readableByteChannel, long j10) {
        l0.p(readableByteChannel, "<this>");
        return h(readableByteChannel, j10, Long.MAX_VALUE);
    }

    @l
    public static final v f(@l ReadableByteChannel readableByteChannel, long j10) {
        l0.p(readableByteChannel, "<this>");
        return h(readableByteChannel, 1L, j10);
    }

    @l
    public static final v g(@l ReadableByteChannel readableByteChannel, long j10) {
        l0.p(readableByteChannel, "<this>");
        return h(readableByteChannel, j10, j10);
    }

    public static final v h(ReadableByteChannel readableByteChannel, long j10, long j11) {
        long j12 = 0;
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException(l0.C("min shouldn't be negative: ", Long.valueOf(j10)).toString());
        }
        if (j10 > j11) {
            StringBuilder sbA = j.b.a("min shouldn't be greater than max: ", j10, " > ");
            sbA.append(j11);
            throw new IllegalArgumentException(sbA.toString().toString());
        }
        if (j11 == 0) {
            v.f15884f.getClass();
            return v.f15885g;
        }
        ul.b.e eVar = ul.b.f16311i;
        eVar.getClass();
        h hVar = ul.b.f16315w;
        ul.b bVarA = eVar.a();
        ul.b bVar = bVarA;
        ul.b bVar2 = bVar;
        while (true) {
            if (j12 >= j10 && (j12 != j10 || i10 != 0)) {
                break;
            }
            try {
                int iC = (int) u.C(j11 - j12, 2147483647L);
                m mVar = bVar2.f15821b;
                int i11 = mVar.f15872a - mVar.f15874c;
                ul.b bVar3 = (i11 > 200 || i11 >= iC) ? bVar2 : null;
                if (bVar3 == null) {
                    Object objW0 = hVar.W0();
                    ul.b bVar4 = (ul.b) objW0;
                    if (bVar == bVarA) {
                        bVar = bVar4;
                        bVar2 = bVar;
                    }
                    bVar3 = (ul.b) objW0;
                }
                if (bVar2 != bVar3) {
                    bVar2.l2(bVar3);
                    bVar2 = bVar3;
                }
                ByteBuffer byteBuffer = bVar3.f15820a;
                m mVar2 = bVar3.f15821b;
                int i12 = mVar2.f15874c;
                int i13 = mVar2.f15872a - i12;
                ByteBuffer byteBufferN = f.n(byteBuffer, i12, i13);
                int iLimit = byteBufferN.limit();
                int i14 = i10;
                if (byteBufferN.remaining() > iC) {
                    byteBufferN.limit(byteBufferN.position() + iC);
                }
                int i15 = readableByteChannel.read(byteBufferN);
                if (i15 == -1) {
                    throw new EOFException("Premature end of stream: was read " + j12 + " bytes of " + j10);
                }
                byteBufferN.limit(iLimit);
                ul.b bVar5 = bVarA;
                j12 += (long) i15;
                if (byteBufferN.limit() != i13) {
                    throw new IllegalStateException("Buffer's limit change is not allowed");
                }
                bVar3.b(byteBufferN.position());
                bVarA = bVar5;
                i10 = i14;
            } catch (Throwable th2) {
                n.k(bVar, hVar);
                throw th2;
            }
        }
        return new v(bVar, (h<ul.b>) hVar);
    }

    @k(message = "Use write(Memory) instead.")
    public static final int i(@l WritableByteChannel writableByteChannel, @l tl.e eVar) throws IOException {
        l0.p(writableByteChannel, "<this>");
        l0.p(eVar, "buffer");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int iWrite = writableByteChannel.write(i.j(byteBuffer, i10, mVar.f15874c - i10));
        eVar.h(iWrite);
        return iWrite;
    }

    @k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int j(WritableByteChannel writableByteChannel, o0 o0Var) {
        l0.p(writableByteChannel, "<this>");
        l0.p(o0Var, "buffer");
        return writableByteChannel.write(o0Var.A2());
    }

    public static final int k(@l WritableByteChannel writableByteChannel, @l ByteBuffer byteBuffer, int i10, int i11) {
        l0.p(writableByteChannel, "$this$write");
        l0.p(byteBuffer, "source");
        return writableByteChannel.write(i.j(byteBuffer, i10, i11));
    }

    public static /* synthetic */ int l(WritableByteChannel writableByteChannel, ByteBuffer byteBuffer, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = byteBuffer.limit() - i10;
        }
        return k(writableByteChannel, byteBuffer, i10, i11);
    }

    @os.m
    public static final v m(@l WritableByteChannel writableByteChannel, @l jn.l<? super s, l2> lVar) {
        l0.p(writableByteChannel, "<this>");
        l0.p(lVar, "builder");
        s sVarA = w0.a(0);
        try {
            lVar.invoke(sVarA);
            v vVarZ2 = sVarA.z2();
            try {
                if (n(writableByteChannel, vVarZ2)) {
                    return null;
                }
                return vVarZ2;
            } catch (Throwable th2) {
                vVarZ2.z2();
                throw th2;
            }
        } catch (Throwable th3) {
            sVarA.close();
            throw th3;
        }
    }

    public static final boolean n(@l WritableByteChannel writableByteChannel, @l v vVar) {
        int iWrite;
        l0.p(writableByteChannel, "<this>");
        l0.p(vVar, "p");
        do {
            try {
                ul.b bVarI2 = vVar.i2(1);
                if (bVarI2 == null) {
                    d1.c(1);
                    throw new y();
                }
                m mVar = bVarI2.f15821b;
                int i10 = mVar.f15873b;
                try {
                    ByteBuffer byteBuffer = bVarI2.f15820a;
                    int i11 = mVar.f15874c - i10;
                    ByteBuffer byteBufferN = f.n(byteBuffer, i10, i11);
                    iWrite = writableByteChannel.write(byteBufferN);
                    if (byteBufferN.limit() != i11) {
                        throw new IllegalStateException("Buffer's limit change is not allowed");
                    }
                    bVarI2.h(byteBufferN.position());
                    m mVar2 = bVarI2.f15821b;
                    int i12 = mVar2.f15873b;
                    if (i12 < i10) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (i12 == mVar2.f15874c) {
                        vVar.E(bVarI2);
                    } else {
                        vVar.f15790b.f15800c = i12;
                    }
                    if (vVar.B1()) {
                        return true;
                    }
                } catch (Throwable th2) {
                    m mVar3 = bVarI2.f15821b;
                    int i13 = mVar3.f15873b;
                    if (i13 < i10) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (i13 == mVar3.f15874c) {
                        vVar.E(bVarI2);
                    } else {
                        vVar.f15790b.f15800c = i13;
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                vVar.z2();
                throw th3;
            }
        } while (iWrite != 0);
        return false;
    }
}
