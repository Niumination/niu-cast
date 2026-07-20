package cr;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends a0, ReadableByteChannel {
    void A0(long j10) throws IOException;

    c C();

    long D0(byte b10) throws IOException;

    long G1(z zVar) throws IOException;

    long H(byte b10, long j10) throws IOException;

    int H1() throws IOException;

    String I0(long j10) throws IOException;

    boolean J(long j10, f fVar) throws IOException;

    f K0(long j10) throws IOException;

    String K1() throws IOException;

    long L(byte b10, long j10, long j11) throws IOException;

    String L1(long j10, Charset charset) throws IOException;

    @gm.j
    String M() throws IOException;

    String P(long j10) throws IOException;

    long Q(f fVar, long j10) throws IOException;

    boolean T(long j10, f fVar, int i10, int i11) throws IOException;

    byte[] X0() throws IOException;

    long Z1() throws IOException;

    boolean b1() throws IOException;

    @Deprecated
    c buffer();

    InputStream c2();

    boolean d0(long j10) throws IOException;

    long d2(f fVar, long j10) throws IOException;

    long g1() throws IOException;

    void h1(c cVar, long j10) throws IOException;

    String i0() throws IOException;

    long l1(f fVar) throws IOException;

    byte[] n0(long j10) throws IOException;

    String o1(Charset charset) throws IOException;

    e peek();

    int q1() throws IOException;

    short r0() throws IOException;

    int r1(q qVar) throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    long s0() throws IOException;

    long s1(f fVar) throws IOException;

    void skip(long j10) throws IOException;

    f v1() throws IOException;
}
