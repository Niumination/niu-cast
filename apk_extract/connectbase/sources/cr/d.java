package cr;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends z, WritableByteChannel {
    d C0(long j10) throws IOException;

    long F1(a0 a0Var) throws IOException;

    d N() throws IOException;

    d T1(f fVar) throws IOException;

    d V(String str) throws IOException;

    d a1(int i10) throws IOException;

    c buffer();

    d c0(String str, int i10, int i11) throws IOException;

    d e1(a0 a0Var, long j10) throws IOException;

    @Override // cr.z, java.io.Flushable
    void flush() throws IOException;

    d j1(int i10) throws IOException;

    OutputStream outputStream();

    d r() throws IOException;

    d s(int i10) throws IOException;

    d u1(long j10) throws IOException;

    d w1(String str, Charset charset) throws IOException;

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i10, int i11) throws IOException;

    d writeByte(int i10) throws IOException;

    d writeInt(int i10) throws IOException;

    d writeLong(long j10) throws IOException;

    d writeShort(int i10) throws IOException;

    d x(long j10) throws IOException;

    d z0(String str, int i10, int i11, Charset charset) throws IOException;
}
