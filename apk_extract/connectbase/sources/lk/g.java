package lk;

import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kn.l0;
import lm.l2;
import nm.p;
import os.l;
import tl.d1;
import tl.r0;
import tl.s;
import tl.v;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final byte[] f10124a = {0, 0, 0, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final byte[] f10125b = {0, 0, -1, -1};

    @l
    public static final byte[] a(@l Deflater deflater, @l byte[] bArr) {
        l0.p(deflater, "<this>");
        l0.p(bArr, "data");
        deflater.setInput(bArr);
        s sVarA = w0.a(0);
        try {
            bm.h<ByteBuffer> hVarA = gl.b.a();
            ByteBuffer byteBufferW0 = hVarA.W0();
            try {
                ByteBuffer byteBuffer = byteBufferW0;
                while (!deflater.needsInput()) {
                    b(sVarA, deflater, byteBuffer, false);
                }
                while (b(sVarA, deflater, byteBuffer, true) != 0) {
                }
                l2 l2Var = l2.f10208a;
                hVarA.recycle(byteBufferW0);
                v vVarZ2 = sVarA.z2();
                if (b.a(vVarZ2, f10124a)) {
                    byte[] bArrF = d1.f(vVarZ2, ((int) vVarZ2.S0()) - f10125b.length);
                    vVarZ2.z2();
                    return bArrF;
                }
                s sVarA2 = w0.a(0);
                try {
                    sVarA2.l2(vVarZ2);
                    sVarA2.d1((byte) 0);
                    return d1.i(sVarA2.z2(), 0, 1, null);
                } catch (Throwable th2) {
                    sVarA2.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                hVarA.recycle(byteBufferW0);
                throw th3;
            }
        } catch (Throwable th4) {
            sVarA.close();
            throw th4;
        }
    }

    public static final int b(s sVar, Deflater deflater, ByteBuffer byteBuffer, boolean z10) {
        byteBuffer.clear();
        int iDeflate = z10 ? deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2) : deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        if (iDeflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + iDeflate);
        byteBuffer.flip();
        r0.a(sVar, byteBuffer);
        return iDeflate;
    }

    @l
    public static final byte[] c(@l Inflater inflater, @l byte[] bArr) {
        l0.p(inflater, "<this>");
        l0.p(bArr, "data");
        byte[] bArrG3 = p.g3(bArr, f10125b);
        inflater.setInput(bArrG3);
        s sVarA = w0.a(0);
        try {
            bm.h<ByteBuffer> hVarA = gl.b.a();
            ByteBuffer byteBufferW0 = hVarA.W0();
            try {
                ByteBuffer byteBuffer = byteBufferW0;
                long length = ((long) bArrG3.length) + inflater.getBytesRead();
                while (inflater.getBytesRead() < length) {
                    byteBuffer.clear();
                    byteBuffer.position(byteBuffer.position() + inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
                    byteBuffer.flip();
                    r0.a(sVarA, byteBuffer);
                }
                l2 l2Var = l2.f10208a;
                return d1.i(sVarA.z2(), 0, 1, null);
            } finally {
                hVarA.recycle(byteBufferW0);
            }
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }
}
