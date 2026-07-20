package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int totalBytesWritten = 0;
    private int position = 0;

    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.limit = bArr.length;
    }

    public static int computeBoolSize(int i8, boolean z2) {
        return computeBoolSizeNoTag(z2) + computeTagSize(i8);
    }

    public static int computeBoolSizeNoTag(boolean z2) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeBytesSize(int i8, ByteString byteString) {
        return computeBytesSizeNoTag(byteString) + computeTagSize(i8);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return byteString.size() + computeRawVarint32Size(byteString.size());
    }

    public static int computeDoubleSize(int i8, double d7) {
        return computeDoubleSizeNoTag(d7) + computeTagSize(i8);
    }

    public static int computeDoubleSizeNoTag(double d7) {
        return 8;
    }

    public static int computeEnumSize(int i8, int i9) {
        return computeEnumSizeNoTag(i9) + computeTagSize(i8);
    }

    public static int computeEnumSizeNoTag(int i8) {
        return computeInt32SizeNoTag(i8);
    }

    public static int computeFixed32SizeNoTag(int i8) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long j8) {
        return 8;
    }

    public static int computeFloatSize(int i8, float f) {
        return computeFloatSizeNoTag(f) + computeTagSize(i8);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i8, int i9) {
        return computeInt32SizeNoTag(i9) + computeTagSize(i8);
    }

    public static int computeInt32SizeNoTag(int i8) {
        if (i8 >= 0) {
            return computeRawVarint32Size(i8);
        }
        return 10;
    }

    public static int computeInt64SizeNoTag(long j8) {
        return computeRawVarint64Size(j8);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int serializedSize = lazyFieldLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeMessageSize(int i8, MessageLite messageLite) {
        return computeMessageSizeNoTag(messageLite) + computeTagSize(i8);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computePreferredBufferSize(int i8) {
        if (i8 > 4096) {
            return 4096;
        }
        return i8;
    }

    public static int computeRawVarint32Size(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeRawVarint64Size(long j8) {
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (((-16384) & j8) == 0) {
            return 2;
        }
        if (((-2097152) & j8) == 0) {
            return 3;
        }
        if (((-268435456) & j8) == 0) {
            return 4;
        }
        if (((-34359738368L) & j8) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j8) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j8) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j8) == 0) {
            return 8;
        }
        return (j8 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int i8) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j8) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int i8) {
        return computeRawVarint32Size(encodeZigZag32(i8));
    }

    public static int computeSInt64Size(int i8, long j8) {
        return computeSInt64SizeNoTag(j8) + computeTagSize(i8);
    }

    public static int computeSInt64SizeNoTag(long j8) {
        return computeRawVarint64Size(encodeZigZag64(j8));
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int computeTagSize(int i8) {
        return computeRawVarint32Size(WireFormat.makeTag(i8, 0));
    }

    public static int computeUInt32SizeNoTag(int i8) {
        return computeRawVarint32Size(i8);
    }

    public static int computeUInt64SizeNoTag(long j8) {
        return computeRawVarint64Size(j8);
    }

    public static int encodeZigZag32(int i8) {
        return (i8 >> 31) ^ (i8 << 1);
    }

    public static long encodeZigZag64(long j8) {
        return (j8 >> 63) ^ (j8 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i8) {
        return new CodedOutputStream(outputStream, new byte[i8]);
    }

    private void refreshBuffer() throws IOException {
        OutputStream outputStream = this.output;
        if (outputStream == null) {
            throw new OutOfSpaceException();
        }
        outputStream.write(this.buffer, 0, this.position);
        this.position = 0;
    }

    public void flush() throws IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public void writeBool(int i8, boolean z2) throws IOException {
        writeTag(i8, 0);
        writeBoolNoTag(z2);
    }

    public void writeBoolNoTag(boolean z2) throws IOException {
        writeRawByte(z2 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeBytes(int i8, ByteString byteString) throws IOException {
        writeTag(i8, 2);
        writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeDouble(int i8, double d7) throws IOException {
        writeTag(i8, 1);
        writeDoubleNoTag(d7);
    }

    public void writeDoubleNoTag(double d7) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d7));
    }

    public void writeEnum(int i8, int i9) throws IOException {
        writeTag(i8, 0);
        writeEnumNoTag(i9);
    }

    public void writeEnumNoTag(int i8) throws IOException {
        writeInt32NoTag(i8);
    }

    public void writeFixed32NoTag(int i8) throws IOException {
        writeRawLittleEndian32(i8);
    }

    public void writeFixed64NoTag(long j8) throws IOException {
        writeRawLittleEndian64(j8);
    }

    public void writeFloat(int i8, float f) throws IOException {
        writeTag(i8, 5);
        writeFloatNoTag(f);
    }

    public void writeFloatNoTag(float f) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(f));
    }

    public void writeGroup(int i8, MessageLite messageLite) throws IOException {
        writeTag(i8, 3);
        writeGroupNoTag(messageLite);
        writeTag(i8, 4);
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public void writeInt32(int i8, int i9) throws IOException {
        writeTag(i8, 0);
        writeInt32NoTag(i9);
    }

    public void writeInt32NoTag(int i8) throws IOException {
        if (i8 >= 0) {
            writeRawVarint32(i8);
        } else {
            writeRawVarint64(i8);
        }
    }

    public void writeInt64NoTag(long j8) throws IOException {
        writeRawVarint64(j8);
    }

    public void writeMessage(int i8, MessageLite messageLite) throws IOException {
        writeTag(i8, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageSetExtension(int i8, MessageLite messageLite) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i8);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b9) throws IOException {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i8 = this.position;
        this.position = i8 + 1;
        bArr[i8] = b9;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawLittleEndian32(int i8) throws IOException {
        writeRawByte(i8 & 255);
        writeRawByte((i8 >> 8) & 255);
        writeRawByte((i8 >> 16) & 255);
        writeRawByte((i8 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j8) throws IOException {
        writeRawByte(((int) j8) & 255);
        writeRawByte(((int) (j8 >> 8)) & 255);
        writeRawByte(((int) (j8 >> 16)) & 255);
        writeRawByte(((int) (j8 >> 24)) & 255);
        writeRawByte(((int) (j8 >> 32)) & 255);
        writeRawByte(((int) (j8 >> 40)) & 255);
        writeRawByte(((int) (j8 >> 48)) & 255);
        writeRawByte(((int) (j8 >> 56)) & 255);
    }

    public void writeRawVarint32(int i8) throws IOException {
        while ((i8 & (-128)) != 0) {
            writeRawByte((i8 & 127) | 128);
            i8 >>>= 7;
        }
        writeRawByte(i8);
    }

    public void writeRawVarint64(long j8) throws IOException {
        while (((-128) & j8) != 0) {
            writeRawByte((((int) j8) & 127) | 128);
            j8 >>>= 7;
        }
        writeRawByte((int) j8);
    }

    public void writeSFixed32NoTag(int i8) throws IOException {
        writeRawLittleEndian32(i8);
    }

    public void writeSFixed64NoTag(long j8) throws IOException {
        writeRawLittleEndian64(j8);
    }

    public void writeSInt32NoTag(int i8) throws IOException {
        writeRawVarint32(encodeZigZag32(i8));
    }

    public void writeSInt64(int i8, long j8) throws IOException {
        writeTag(i8, 0);
        writeSInt64NoTag(j8);
    }

    public void writeSInt64NoTag(long j8) throws IOException {
        writeRawVarint64(encodeZigZag64(j8));
    }

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i8, int i9) throws IOException {
        writeRawVarint32(WireFormat.makeTag(i8, i9));
    }

    public void writeUInt32(int i8, int i9) throws IOException {
        writeTag(i8, 0);
        writeUInt32NoTag(i9);
    }

    public void writeUInt32NoTag(int i8) throws IOException {
        writeRawVarint32(i8);
    }

    public void writeUInt64NoTag(long j8) throws IOException {
        writeRawVarint64(j8);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = this.limit;
        int i11 = this.position;
        if (i10 - i11 >= i9) {
            System.arraycopy(bArr, i8, this.buffer, i11, i9);
            this.position += i9;
            this.totalBytesWritten += i9;
            return;
        }
        int i12 = i10 - i11;
        System.arraycopy(bArr, i8, this.buffer, i11, i12);
        int i13 = i8 + i12;
        int i14 = i9 - i12;
        this.position = this.limit;
        this.totalBytesWritten += i12;
        refreshBuffer();
        if (i14 <= this.limit) {
            System.arraycopy(bArr, i13, this.buffer, 0, i14);
            this.position = i14;
        } else {
            this.output.write(bArr, i13, i14);
        }
        this.totalBytesWritten += i14;
    }

    public void writeRawByte(int i8) throws IOException {
        writeRawByte((byte) i8);
    }

    public void writeRawBytes(ByteString byteString, int i8, int i9) throws IOException {
        int i10 = this.limit;
        int i11 = this.position;
        if (i10 - i11 >= i9) {
            byteString.copyTo(this.buffer, i8, i11, i9);
            this.position += i9;
            this.totalBytesWritten += i9;
            return;
        }
        int i12 = i10 - i11;
        byteString.copyTo(this.buffer, i8, i11, i12);
        int i13 = i8 + i12;
        int i14 = i9 - i12;
        this.position = this.limit;
        this.totalBytesWritten += i12;
        refreshBuffer();
        if (i14 <= this.limit) {
            byteString.copyTo(this.buffer, i13, 0, i14);
            this.position = i14;
        } else {
            byteString.writeTo(this.output, i13, i14);
        }
        this.totalBytesWritten += i14;
    }
}
