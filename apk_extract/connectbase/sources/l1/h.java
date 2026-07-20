package l1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9572a = 8192;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9573b = 524288;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9574c = 2147483639;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9575d = 20;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final OutputStream f9576e = new a();

    public class a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int b10) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] b10) {
            b10.getClass();
        }

        @Override // java.io.OutputStream
        public void write(byte[] b10, int off, int len) {
            b10.getClass();
            c1.h0.f0(off, len + off, b10.length);
        }
    }

    public static byte[] a(Queue<byte[]> bufs, int totalLen) {
        if (bufs.isEmpty()) {
            return new byte[0];
        }
        byte[] bArrRemove = bufs.remove();
        if (bArrRemove.length == totalLen) {
            return bArrRemove;
        }
        int length = totalLen - bArrRemove.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArrRemove, totalLen);
        while (length > 0) {
            byte[] bArrRemove2 = bufs.remove();
            int iMin = Math.min(length, bArrRemove2.length);
            System.arraycopy(bArrRemove2, 0, bArrCopyOf, totalLen - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    @t1.a
    public static long b(InputStream from, OutputStream to2) throws IOException {
        from.getClass();
        to2.getClass();
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            int i10 = from.read(bArr);
            if (i10 == -1) {
                return j10;
            }
            to2.write(bArr, 0, i10);
            j10 += (long) i10;
        }
    }

    @t1.a
    public static long c(ReadableByteChannel from, WritableByteChannel to2) throws IOException {
        from.getClass();
        to2.getClass();
        long jWrite = 0;
        if (!(from instanceof FileChannel)) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[8192]);
            while (from.read(byteBufferWrap) != -1) {
                byteBufferWrap.flip();
                while (byteBufferWrap.hasRemaining()) {
                    jWrite += (long) to2.write(byteBufferWrap);
                }
                byteBufferWrap.clear();
            }
            return jWrite;
        }
        FileChannel fileChannel = (FileChannel) from;
        long jPosition = fileChannel.position();
        long j10 = jPosition;
        while (true) {
            long jTransferTo = fileChannel.transferTo(j10, va.q.f16829x, to2);
            j10 += jTransferTo;
            fileChannel.position(j10);
            if (jTransferTo <= 0 && j10 >= fileChannel.size()) {
                return j10 - jPosition;
            }
        }
    }

    public static byte[] d() {
        return new byte[8192];
    }

    @t1.a
    public static long e(InputStream in2) throws IOException {
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            long j11 = in2.read(bArr);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    public static InputStream f(InputStream in2, long limit) {
        return new d(in2, limit);
    }

    public static l1.c g(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.getClass();
        return new b(byteArrayInputStream);
    }

    public static l1.c h(byte[] bytes) {
        return g(new ByteArrayInputStream(bytes));
    }

    public static l1.c i(byte[] bytes, int start) {
        c1.h0.d0(start, bytes.length);
        return g(new ByteArrayInputStream(bytes, start, bytes.length - start));
    }

    public static l1.d j() {
        return l(new ByteArrayOutputStream());
    }

    public static l1.d k(int size) {
        if (size >= 0) {
            return l(new ByteArrayOutputStream(size));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(size)));
    }

    public static l1.d l(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.getClass();
        return new c(byteArrayOutputStream);
    }

    public static OutputStream m() {
        return f9576e;
    }

    @t1.a
    public static int n(InputStream in2, byte[] b10, int off, int len) throws IOException {
        in2.getClass();
        b10.getClass();
        if (len < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(len)));
        }
        c1.h0.f0(off, off + len, b10.length);
        int i10 = 0;
        while (i10 < len) {
            int i11 = in2.read(b10, off + i10, len - i10);
            if (i11 == -1) {
                break;
            }
            i10 += i11;
        }
        return i10;
    }

    @t1.a
    @e0
    public static <T> T o(InputStream input, e<T> processor) throws IOException {
        int i10;
        input.getClass();
        processor.getClass();
        byte[] bArr = new byte[8192];
        do {
            i10 = input.read(bArr);
            if (i10 == -1) {
                break;
            }
        } while (processor.b(bArr, 0, i10));
        return processor.a();
    }

    public static void p(InputStream in2, byte[] b10) throws IOException {
        q(in2, b10, 0, b10.length);
    }

    public static void q(InputStream in2, byte[] b10, int off, int len) throws IOException {
        int iN = n(in2, b10, off, len);
        if (iN == len) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + iN + " bytes; " + len + " bytes expected");
    }

    public static void r(InputStream in2, long n10) throws IOException {
        long jT = t(in2, n10);
        if (jT < n10) {
            throw new EOFException(k.d.a(j.b.a("reached end of stream after skipping ", jT, " bytes; "), n10, " bytes expected"));
        }
    }

    public static long s(InputStream in2, long n10) throws IOException {
        int iAvailable = in2.available();
        if (iAvailable == 0) {
            return 0L;
        }
        return in2.skip(Math.min(iAvailable, n10));
    }

    public static long t(InputStream in2, long n10) throws IOException {
        byte[] bArr = null;
        long j10 = 0;
        while (j10 < n10) {
            long j11 = n10 - j10;
            long jS = s(in2, j11);
            if (jS == 0) {
                int iMin = (int) Math.min(j11, 8192L);
                if (bArr == null) {
                    bArr = new byte[iMin];
                }
                jS = in2.read(bArr, 0, iMin);
                if (jS == -1) {
                    break;
                }
            }
            j10 += jS;
        }
        return j10;
    }

    public static byte[] u(InputStream in2) throws IOException {
        in2.getClass();
        return w(in2, new ArrayDeque(20), 0);
    }

    public static byte[] v(InputStream in2, long expectedSize) throws IOException {
        c1.h0.p(expectedSize >= 0, "expectedSize (%s) must be non-negative", expectedSize);
        if (expectedSize > 2147483639) {
            throw new OutOfMemoryError(expectedSize + " bytes is too large to fit in a byte array");
        }
        int i10 = (int) expectedSize;
        byte[] bArr = new byte[i10];
        int i11 = i10;
        while (i11 > 0) {
            int i12 = i10 - i11;
            int i13 = in2.read(bArr, i12, i11);
            if (i13 == -1) {
                return Arrays.copyOf(bArr, i12);
            }
            i11 -= i13;
        }
        int i14 = in2.read();
        if (i14 == -1) {
            return bArr;
        }
        ArrayDeque arrayDeque = new ArrayDeque(22);
        arrayDeque.add(bArr);
        arrayDeque.add(new byte[]{(byte) i14});
        return w(in2, arrayDeque, i10 + 1);
    }

    public static byte[] w(InputStream in2, Queue<byte[]> bufs, int totalLen) throws IOException {
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(totalLen) * 2));
        while (totalLen < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - totalLen);
            byte[] bArr = new byte[iMin2];
            bufs.add(bArr);
            int i10 = 0;
            while (i10 < iMin2) {
                int i11 = in2.read(bArr, i10, iMin2 - i10);
                if (i11 == -1) {
                    return a(bufs, totalLen);
                }
                i10 += i11;
                totalLen += i11;
            }
            iMin = m1.f.u(iMin, iMin < 4096 ? 4 : 2);
        }
        if (in2.read() == -1) {
            return a(bufs, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static class b implements l1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInput f9577a;

        public b(ByteArrayInputStream byteArrayInputStream) {
            this.f9577a = new DataInputStream(byteArrayInputStream);
        }

        @Override // l1.c, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.f9577a.readBoolean();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public byte readByte() {
            try {
                return this.f9577a.readByte();
            } catch (EOFException e10) {
                throw new IllegalStateException(e10);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // l1.c, java.io.DataInput
        public char readChar() {
            try {
                return this.f9577a.readChar();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public double readDouble() {
            try {
                return this.f9577a.readDouble();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public float readFloat() {
            try {
                return this.f9577a.readFloat();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public void readFully(byte[] b10) {
            try {
                this.f9577a.readFully(b10);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public int readInt() {
            try {
                return this.f9577a.readInt();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        @gm.a
        public String readLine() {
            try {
                return this.f9577a.readLine();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public long readLong() {
            try {
                return this.f9577a.readLong();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public short readShort() {
            try {
                return this.f9577a.readShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public String readUTF() {
            try {
                return this.f9577a.readUTF();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.f9577a.readUnsignedByte();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.f9577a.readUnsignedShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public int skipBytes(int n10) {
            try {
                return this.f9577a.skipBytes(n10);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // l1.c, java.io.DataInput
        public void readFully(byte[] b10, int off, int len) {
            try {
                this.f9577a.readFully(b10, off, len);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public static class c implements l1.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataOutput f9578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteArrayOutputStream f9579b;

        public c(ByteArrayOutputStream byteArrayOutputStream) {
            this.f9579b = byteArrayOutputStream;
            this.f9578a = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // l1.d
        public byte[] toByteArray() {
            return this.f9579b.toByteArray();
        }

        @Override // l1.d, java.io.DataOutput
        public void write(int b10) {
            try {
                this.f9578a.write(b10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeBoolean(boolean v10) {
            try {
                this.f9578a.writeBoolean(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeByte(int v10) {
            try {
                this.f9578a.writeByte(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeBytes(String s10) {
            try {
                this.f9578a.writeBytes(s10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeChar(int v10) {
            try {
                this.f9578a.writeChar(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeChars(String s10) {
            try {
                this.f9578a.writeChars(s10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeDouble(double v10) {
            try {
                this.f9578a.writeDouble(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeFloat(float v10) {
            try {
                this.f9578a.writeFloat(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeInt(int v10) {
            try {
                this.f9578a.writeInt(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeLong(long v10) {
            try {
                this.f9578a.writeLong(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeShort(int v10) {
            try {
                this.f9578a.writeShort(v10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void writeUTF(String s10) {
            try {
                this.f9578a.writeUTF(s10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void write(byte[] b10) {
            try {
                this.f9578a.write(b10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // l1.d, java.io.DataOutput
        public void write(byte[] b10, int off, int len) {
            try {
                this.f9578a.write(b10, off, len);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9581b;

        public d(InputStream in2, long limit) {
            super(in2);
            this.f9581b = -1L;
            in2.getClass();
            c1.h0.e(limit >= 0, "limit must be non-negative");
            this.f9580a = limit;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f9580a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int readLimit) {
            ((FilterInputStream) this).in.mark(readLimit);
            this.f9581b = this.f9580a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f9580a == 0) {
                return -1;
            }
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 != -1) {
                this.f9580a--;
            }
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f9581b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f9580a = this.f9581b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long n10) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(n10, this.f9580a));
            this.f9580a -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] b10, int off, int len) throws IOException {
            long j10 = this.f9580a;
            if (j10 == 0) {
                return -1;
            }
            int i10 = ((FilterInputStream) this).in.read(b10, off, (int) Math.min(len, j10));
            if (i10 != -1) {
                this.f9580a -= (long) i10;
            }
            return i10;
        }
    }
}
