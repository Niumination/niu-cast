package com.google.protobuf;

import h0.a;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        public AbstractBufferedEncoder(int i8) {
            super();
            if (i8 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i8, 20)];
            this.buffer = bArr;
            this.limit = bArr.length;
        }

        public final void buffer(byte b9) {
            byte[] bArr = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            bArr[i8] = b9;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int i8) {
            byte[] bArr = this.buffer;
            int i9 = this.position;
            int i10 = i9 + 1;
            this.position = i10;
            bArr[i9] = (byte) (i8 & 255);
            int i11 = i9 + 2;
            this.position = i11;
            bArr[i10] = (byte) ((i8 >> 8) & 255);
            int i12 = i9 + 3;
            this.position = i12;
            bArr[i11] = (byte) ((i8 >> 16) & 255);
            this.position = i9 + 4;
            bArr[i12] = (byte) ((i8 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long j8) {
            byte[] bArr = this.buffer;
            int i8 = this.position;
            int i9 = i8 + 1;
            this.position = i9;
            bArr[i8] = (byte) (j8 & 255);
            int i10 = i8 + 2;
            this.position = i10;
            bArr[i9] = (byte) ((j8 >> 8) & 255);
            int i11 = i8 + 3;
            this.position = i11;
            bArr[i10] = (byte) ((j8 >> 16) & 255);
            int i12 = i8 + 4;
            this.position = i12;
            bArr[i11] = (byte) (255 & (j8 >> 24));
            int i13 = i8 + 5;
            this.position = i13;
            bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
            int i14 = i8 + 6;
            this.position = i14;
            bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
            int i15 = i8 + 7;
            this.position = i15;
            bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
            this.position = i8 + 8;
            bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int i8) {
            if (i8 >= 0) {
                bufferUInt32NoTag(i8);
            } else {
                bufferUInt64NoTag(i8);
            }
        }

        public final void bufferTag(int i8, int i9) {
            bufferUInt32NoTag(WireFormat.makeTag(i8, i9));
        }

        public final void bufferUInt32NoTag(int i8) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((i8 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i9 = this.position;
                    this.position = i9 + 1;
                    bArr[i9] = (byte) ((i8 & 127) | 128);
                    this.totalBytesWritten++;
                    i8 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                bArr2[i10] = (byte) i8;
                this.totalBytesWritten++;
                return;
            }
            long j8 = this.position;
            while ((i8 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                UnsafeUtil.putByte(bArr3, i11, (byte) ((i8 & 127) | 128));
                i8 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i12 = this.position;
            this.position = i12 + 1;
            UnsafeUtil.putByte(bArr4, i12, (byte) i8);
            this.totalBytesWritten += (int) (((long) this.position) - j8);
        }

        public final void bufferUInt64NoTag(long j8) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    bArr[i8] = (byte) ((((int) j8) & 127) | 128);
                    this.totalBytesWritten++;
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                bArr2[i9] = (byte) j8;
                this.totalBytesWritten++;
                return;
            }
            long j10 = this.position;
            while ((j8 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                UnsafeUtil.putByte(bArr3, i10, (byte) ((((int) j8) & 127) | 128));
                j8 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i11 = this.position;
            this.position = i11 + 1;
            UnsafeUtil.putByte(bArr4, i11, (byte) j8);
            this.totalBytesWritten += (int) (((long) this.position) - j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public ArrayEncoder(byte[] bArr, int i8, int i9) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i10 = i8 + i9;
            if ((i8 | i9 | (bArr.length - i10)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            this.buffer = bArr;
            this.offset = i8;
            this.position = i8;
            this.limit = i10;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte b9) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr[i8] = b9;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i8, boolean z2) throws IOException {
            writeTag(i8, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i8, byte[] bArr) throws IOException {
            writeByteArray(i8, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i8, int i9) throws IOException {
            writeUInt32NoTag(i9);
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i8, ByteBuffer byteBuffer) throws IOException {
            writeTag(i8, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i8, ByteString byteString) throws IOException {
            writeTag(i8, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i8, int i9) throws IOException {
            writeTag(i8, 5);
            writeFixed32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i8) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i9 = this.position;
                int i10 = i9 + 1;
                this.position = i10;
                bArr[i9] = (byte) (i8 & 255);
                int i11 = i9 + 2;
                this.position = i11;
                bArr[i10] = (byte) ((i8 >> 8) & 255);
                int i12 = i9 + 3;
                this.position = i12;
                bArr[i11] = (byte) ((i8 >> 16) & 255);
                this.position = i9 + 4;
                bArr[i12] = (byte) ((i8 >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i8, long j8) throws IOException {
            writeTag(i8, 1);
            writeFixed64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j8) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i8 = this.position;
                int i9 = i8 + 1;
                this.position = i9;
                bArr[i8] = (byte) (((int) j8) & 255);
                int i10 = i8 + 2;
                this.position = i10;
                bArr[i9] = (byte) (((int) (j8 >> 8)) & 255);
                int i11 = i8 + 3;
                this.position = i11;
                bArr[i10] = (byte) (((int) (j8 >> 16)) & 255);
                int i12 = i8 + 4;
                this.position = i12;
                bArr[i11] = (byte) (((int) (j8 >> 24)) & 255);
                int i13 = i8 + 5;
                this.position = i13;
                bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
                int i14 = i8 + 6;
                this.position = i14;
                bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
                int i15 = i8 + 7;
                this.position = i15;
                bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
                this.position = i8 + 8;
                bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i8, int i9) throws IOException {
            writeTag(i8, 0);
            writeInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i8) throws IOException {
            if (i8 >= 0) {
                writeUInt32NoTag(i8);
            } else {
                writeUInt64NoTag(i8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i8, int i9) throws IOException {
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i8, MessageLite messageLite) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i8, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i8, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i8, String str) throws IOException {
            writeTag(i8, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws IOException {
            int i8 = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int i9 = i8 + iComputeUInt32SizeNoTag2;
                    this.position = i9;
                    int iEncode = Utf8.encode(str, this.buffer, i9, spaceLeft());
                    this.position = i8;
                    writeUInt32NoTag((iEncode - i8) - iComputeUInt32SizeNoTag2);
                    this.position = iEncode;
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                }
            } catch (Utf8.UnpairedSurrogateException e) {
                this.position = i8;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i8, int i9) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i8, i9));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i8, int i9) throws IOException {
            writeTag(i8, 0);
            writeUInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i8) throws IOException {
            while ((i8 & (-128)) != 0) {
                try {
                    byte[] bArr = this.buffer;
                    int i9 = this.position;
                    this.position = i9 + 1;
                    bArr[i9] = (byte) ((i8 & 127) | 128);
                    i8 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr2 = this.buffer;
            int i10 = this.position;
            this.position = i10 + 1;
            bArr2[i10] = (byte) i8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i8, long j8) throws IOException {
            writeTag(i8, 0);
            writeUInt64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j8) throws IOException {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    UnsafeUtil.putByte(bArr, i8, (byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                UnsafeUtil.putByte(bArr2, i9, (byte) j8);
                return;
            }
            while ((j8 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    bArr3[i10] = (byte) ((((int) j8) & 127) | 128);
                    j8 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i11 = this.position;
            this.position = i11 + 1;
            bArr4[i11] = (byte) j8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i8, byte[] bArr, int i9, int i10) throws IOException {
            writeTag(i8, 2);
            writeByteArrayNoTag(bArr, i9, i10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i8, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i8, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] bArr, int i8, int i9) throws IOException {
            try {
                System.arraycopy(bArr, i8, this.buffer, this.position, i9);
                this.position += i9;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i9)), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, iRemaining);
                this.position += iRemaining;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(iRemaining)), e);
            }
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        public ByteOutputEncoder(ByteOutput byteOutput, int i8) {
            super(i8);
            if (byteOutput == null) {
                throw new NullPointerException("out");
            }
            this.out = byteOutput;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i8) throws IOException {
            if (this.limit - this.position < i8) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b9) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i8, boolean z2) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i8, 0);
            buffer(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr) throws IOException {
            writeByteArray(i8, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i8, int i9) throws IOException {
            writeUInt32NoTag(i9);
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i8, ByteBuffer byteBuffer) throws IOException {
            writeTag(i8, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i8, ByteString byteString) throws IOException {
            writeTag(i8, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i8, int i9) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i8, 5);
            bufferFixed32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i8) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i8, long j8) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i8, 1);
            bufferFixed64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j8) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i8, int i9) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i8, 0);
            bufferInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i8) throws IOException {
            if (i8 >= 0) {
                writeUInt32NoTag(i8);
            } else {
                writeUInt64NoTag(i8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i8, int i9) throws IOException {
            flush();
            this.out.writeLazy(bArr, i8, i9);
            this.totalBytesWritten += i9;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i8, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i8, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i8, String str) throws IOException {
            writeTag(i8, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i8 = iComputeUInt32SizeNoTag + length;
            int i9 = this.limit;
            if (i8 > i9) {
                byte[] bArr = new byte[length];
                int iEncode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(iEncode);
                writeLazy(bArr, 0, iEncode);
                return;
            }
            if (i8 > i9 - this.position) {
                doFlush();
            }
            int i10 = this.position;
            try {
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int i11 = i10 + iComputeUInt32SizeNoTag2;
                    this.position = i11;
                    int iEncode2 = Utf8.encode(str, this.buffer, i11, this.limit - i11);
                    this.position = i10;
                    int i12 = (iEncode2 - i10) - iComputeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i12);
                    this.position = iEncode2;
                    this.totalBytesWritten += i12;
                } else {
                    int iEncodedLength = Utf8.encodedLength(str);
                    bufferUInt32NoTag(iEncodedLength);
                    this.position = Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    this.totalBytesWritten += iEncodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException e) {
                this.totalBytesWritten -= this.position - i10;
                this.position = i10;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i8, int i9) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i8, i9));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i8, int i9) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i8, 0);
            bufferUInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i8) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i8, long j8) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i8, 0);
            bufferUInt64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j8) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr, int i9, int i10) throws IOException {
            writeTag(i8, 2);
            writeByteArrayNoTag(bArr, i9, i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i8, int i9) throws IOException {
            flush();
            this.out.write(bArr, i8, i9);
            this.totalBytesWritten += i9;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super(a.i("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str));
        }

        public OutOfSpaceException(Throwable th2) {
            super(MESSAGE, th2);
        }

        public OutOfSpaceException(String str, Throwable th2) {
            super(a.i("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th2);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        public OutputStreamEncoder(OutputStream outputStream, int i8) {
            super(i8);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i8) throws IOException {
            if (this.limit - this.position < i8) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b9) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i8, boolean z2) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i8, 0);
            buffer(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr) throws IOException {
            writeByteArray(i8, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i8, int i9) throws IOException {
            writeUInt32NoTag(i9);
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i8, ByteBuffer byteBuffer) throws IOException {
            writeTag(i8, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i8, ByteString byteString) throws IOException {
            writeTag(i8, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i8, int i9) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i8, 5);
            bufferFixed32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i8) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i8, long j8) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i8, 1);
            bufferFixed64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j8) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i8, int i9) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i8, 0);
            bufferInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i8) throws IOException {
            if (i8 >= 0) {
                writeUInt32NoTag(i8);
            } else {
                writeUInt64NoTag(i8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i8, int i9) throws IOException {
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i8, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i8, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i8, String str) throws IOException {
            writeTag(i8, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int iEncodedLength;
            try {
                int length = str.length() * 3;
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i8 = iComputeUInt32SizeNoTag + length;
                int i9 = this.limit;
                if (i8 > i9) {
                    byte[] bArr = new byte[length];
                    int iEncode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(iEncode);
                    writeLazy(bArr, 0, iEncode);
                    return;
                }
                if (i8 > i9 - this.position) {
                    doFlush();
                }
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i10 = this.position;
                try {
                    if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                        int i11 = i10 + iComputeUInt32SizeNoTag2;
                        this.position = i11;
                        int iEncode2 = Utf8.encode(str, this.buffer, i11, this.limit - i11);
                        this.position = i10;
                        iEncodedLength = (iEncode2 - i10) - iComputeUInt32SizeNoTag2;
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = iEncode2;
                    } else {
                        iEncodedLength = Utf8.encodedLength(str);
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    }
                    this.totalBytesWritten += iEncodedLength;
                } catch (Utf8.UnpairedSurrogateException e) {
                    this.totalBytesWritten -= this.position - i10;
                    this.position = i10;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    throw new OutOfSpaceException(e4);
                }
            } catch (Utf8.UnpairedSurrogateException e10) {
                inefficientWriteStringNoTag(str, e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i8, int i9) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i8, i9));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i8, int i9) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i8, 0);
            bufferUInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i8) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i8, long j8) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i8, 0);
            bufferUInt64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j8) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr, int i9, int i10) throws IOException {
            writeTag(i8, 2);
            writeByteArrayNoTag(bArr, i9, i10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i8, int i9) throws IOException {
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
            doFlush();
            if (i14 <= this.limit) {
                System.arraycopy(bArr, i13, this.buffer, 0, i14);
                this.position = i14;
            } else {
                this.out.write(bArr, i13, i14);
            }
            this.totalBytesWritten += i14;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i8 = this.limit;
            int i9 = this.position;
            if (i8 - i9 >= iRemaining) {
                byteBuffer.get(this.buffer, i9, iRemaining);
                this.position += iRemaining;
                this.totalBytesWritten += iRemaining;
                return;
            }
            int i10 = i8 - i9;
            byteBuffer.get(this.buffer, i9, i10);
            int i11 = iRemaining - i10;
            this.position = this.limit;
            this.totalBytesWritten += i10;
            doFlush();
            while (true) {
                int i12 = this.limit;
                if (i11 > i12) {
                    byteBuffer.get(this.buffer, 0, i12);
                    this.out.write(this.buffer, 0, this.limit);
                    int i13 = this.limit;
                    i11 -= i13;
                    this.totalBytesWritten += i13;
                } else {
                    byteBuffer.get(this.buffer, 0, i11);
                    this.position = i11;
                    this.totalBytesWritten += i11;
                    return;
                }
            }
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws IOException {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, this.buffer.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b9) throws IOException {
            try {
                this.buffer.put(b9);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i8, boolean z2) throws IOException {
            writeTag(i8, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr) throws IOException {
            writeByteArray(i8, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i8, int i9) throws IOException {
            writeUInt32NoTag(i9);
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i8, ByteBuffer byteBuffer) throws IOException {
            writeTag(i8, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i8, ByteString byteString) throws IOException {
            writeTag(i8, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i8, int i9) throws IOException {
            writeTag(i8, 5);
            writeFixed32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i8) throws IOException {
            try {
                this.buffer.putInt(i8);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i8, long j8) throws IOException {
            writeTag(i8, 1);
            writeFixed64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j8) throws IOException {
            try {
                this.buffer.putLong(j8);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i8, int i9) throws IOException {
            writeTag(i8, 0);
            writeInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i8) throws IOException {
            if (i8 >= 0) {
                writeUInt32NoTag(i8);
            } else {
                writeUInt64NoTag(i8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i8, int i9) throws IOException {
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i8, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i8, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i8, String str) throws IOException {
            writeTag(i8, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int iPosition = this.buffer.position();
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int iPosition2 = this.buffer.position() + iComputeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, iPosition2);
                    encode(str);
                    int iPosition3 = this.buffer.position();
                    Java8Compatibility.position(this.buffer, iPosition);
                    writeUInt32NoTag(iPosition3 - iPosition2);
                    Java8Compatibility.position(this.buffer, iPosition3);
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    encode(str);
                }
            } catch (Utf8.UnpairedSurrogateException e) {
                Java8Compatibility.position(this.buffer, iPosition);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i8, int i9) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i8, i9));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i8, int i9) throws IOException {
            writeTag(i8, 0);
            writeUInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i8) throws IOException {
            while ((i8 & (-128)) != 0) {
                try {
                    this.buffer.put((byte) ((i8 & 127) | 128));
                    i8 >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new OutOfSpaceException(e);
                }
            }
            this.buffer.put((byte) i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i8, long j8) throws IOException {
            writeTag(i8, 0);
            writeUInt64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j8) throws IOException {
            while (((-128) & j8) != 0) {
                try {
                    this.buffer.put((byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new OutOfSpaceException(e);
                }
            }
            this.buffer.put((byte) j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr, int i9, int i10) throws IOException {
            writeTag(i8, 2);
            writeByteArrayNoTag(bArr, i9, i10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i8, int i9) throws IOException {
            try {
                this.buffer.put(bArr, i8, i9);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(e);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = jAddressOffset;
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            this.initialPosition = jPosition;
            long jLimit = jAddressOffset + ((long) byteBuffer.limit());
            this.limit = jLimit;
            this.oneVarintLimit = jLimit - 10;
            this.position = jPosition;
        }

        private int bufferPos(long j8) {
            return (int) (j8 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j8) {
            Java8Compatibility.position(this.buffer, bufferPos(j8));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, bufferPos(this.position));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b9) throws IOException {
            long j8 = this.position;
            if (j8 >= this.limit) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
            }
            this.position = 1 + j8;
            UnsafeUtil.putByte(j8, b9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i8, boolean z2) throws IOException {
            writeTag(i8, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr) throws IOException {
            writeByteArray(i8, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i8, int i9) throws IOException {
            writeUInt32NoTag(i9);
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i8, ByteBuffer byteBuffer) throws IOException {
            writeTag(i8, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i8, ByteString byteString) throws IOException {
            writeTag(i8, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i8, int i9) throws IOException {
            writeTag(i8, 5);
            writeFixed32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i8) throws IOException {
            this.buffer.putInt(bufferPos(this.position), i8);
            this.position += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i8, long j8) throws IOException {
            writeTag(i8, 1);
            writeFixed64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j8) throws IOException {
            this.buffer.putLong(bufferPos(this.position), j8);
            this.position += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i8, int i9) throws IOException {
            writeTag(i8, 0);
            writeInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i8) throws IOException {
            if (i8 >= 0) {
                writeUInt32NoTag(i8);
            } else {
                writeUInt64NoTag(i8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i8, int i9) throws IOException {
            write(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i8, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i8, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i8);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i8, String str) throws IOException {
            writeTag(i8, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            long j8 = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int iBufferPos = bufferPos(this.position) + iComputeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, iBufferPos);
                    Utf8.encodeUtf8(str, this.buffer);
                    int iPosition = this.buffer.position() - iBufferPos;
                    writeUInt32NoTag(iPosition);
                    this.position += (long) iPosition;
                } else {
                    int iEncodedLength = Utf8.encodedLength(str);
                    writeUInt32NoTag(iEncodedLength);
                    repositionBuffer(this.position);
                    Utf8.encodeUtf8(str, this.buffer);
                    this.position += (long) iEncodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException e) {
                this.position = j8;
                repositionBuffer(j8);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i8, int i9) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i8, i9));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i8, int i9) throws IOException {
            writeTag(i8, 0);
            writeUInt32NoTag(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i8) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((i8 & (-128)) != 0) {
                    long j8 = this.position;
                    this.position = j8 + 1;
                    UnsafeUtil.putByte(j8, (byte) ((i8 & 127) | 128));
                    i8 >>>= 7;
                }
                long j10 = this.position;
                this.position = 1 + j10;
                UnsafeUtil.putByte(j10, (byte) i8);
                return;
            }
            while (true) {
                long j11 = this.position;
                if (j11 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                }
                if ((i8 & (-128)) == 0) {
                    this.position = 1 + j11;
                    UnsafeUtil.putByte(j11, (byte) i8);
                    return;
                } else {
                    this.position = j11 + 1;
                    UnsafeUtil.putByte(j11, (byte) ((i8 & 127) | 128));
                    i8 >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i8, long j8) throws IOException {
            writeTag(i8, 0);
            writeUInt64NoTag(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j8) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((j8 & (-128)) != 0) {
                    long j10 = this.position;
                    this.position = j10 + 1;
                    UnsafeUtil.putByte(j10, (byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                }
                long j11 = this.position;
                this.position = 1 + j11;
                UnsafeUtil.putByte(j11, (byte) j8);
                return;
            }
            while (true) {
                long j12 = this.position;
                if (j12 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                }
                if ((j8 & (-128)) == 0) {
                    this.position = 1 + j12;
                    UnsafeUtil.putByte(j12, (byte) j8);
                    return;
                } else {
                    this.position = j12 + 1;
                    UnsafeUtil.putByte(j12, (byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i8, byte[] bArr, int i9, int i10) throws IOException {
            writeTag(i8, 2);
            writeByteArrayNoTag(bArr, i9, i10);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i8, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i8, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i8, int i9) throws IOException {
            if (bArr != null && i8 >= 0 && i9 >= 0 && bArr.length - i9 >= i8) {
                long j8 = i9;
                long j10 = this.limit - j8;
                long j11 = this.position;
                if (j10 >= j11) {
                    UnsafeUtil.copyMemory(bArr, i8, j11, j8);
                    this.position += j8;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i9)));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int iRemaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += (long) iRemaining;
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }
    }

    public static int computeBoolSize(int i8, boolean z2) {
        return computeBoolSizeNoTag(z2) + computeTagSize(i8);
    }

    public static int computeBoolSizeNoTag(boolean z2) {
        return 1;
    }

    public static int computeByteArraySize(int i8, byte[] bArr) {
        return computeByteArraySizeNoTag(bArr) + computeTagSize(i8);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i8, ByteBuffer byteBuffer) {
        return computeByteBufferSizeNoTag(byteBuffer) + computeTagSize(i8);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i8, ByteString byteString) {
        return computeBytesSizeNoTag(byteString) + computeTagSize(i8);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
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

    public static int computeFixed32Size(int i8, int i9) {
        return computeFixed32SizeNoTag(i9) + computeTagSize(i8);
    }

    public static int computeFixed32SizeNoTag(int i8) {
        return 4;
    }

    public static int computeFixed64Size(int i8, long j8) {
        return computeFixed64SizeNoTag(j8) + computeTagSize(i8);
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

    @Deprecated
    public static int computeGroupSize(int i8, MessageLite messageLite) {
        return messageLite.getSerializedSize() + (computeTagSize(i8) * 2);
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i8, int i9) {
        return computeInt32SizeNoTag(i9) + computeTagSize(i8);
    }

    public static int computeInt32SizeNoTag(int i8) {
        if (i8 >= 0) {
            return computeUInt32SizeNoTag(i8);
        }
        return 10;
    }

    public static int computeInt64Size(int i8, long j8) {
        return computeInt64SizeNoTag(j8) + computeTagSize(i8);
    }

    public static int computeInt64SizeNoTag(long j8) {
        return computeUInt64SizeNoTag(j8);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i8, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSize(3, lazyFieldLite) + computeUInt32Size(2, i8) + (computeTagSize(1) * 2);
    }

    public static int computeLazyFieldSize(int i8, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSizeNoTag(lazyFieldLite) + computeTagSize(i8);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int i8) {
        return computeUInt32SizeNoTag(i8) + i8;
    }

    public static int computeMessageSetExtensionSize(int i8, MessageLite messageLite) {
        return computeMessageSize(3, messageLite) + computeUInt32Size(2, i8) + (computeTagSize(1) * 2);
    }

    public static int computeMessageSize(int i8, MessageLite messageLite) {
        return computeMessageSizeNoTag(messageLite) + computeTagSize(i8);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    public static int computePreferredBufferSize(int i8) {
        if (i8 > 4096) {
            return 4096;
        }
        return i8;
    }

    public static int computeRawMessageSetExtensionSize(int i8, ByteString byteString) {
        return computeBytesSize(3, byteString) + computeUInt32Size(2, i8) + (computeTagSize(1) * 2);
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i8) {
        return computeUInt32SizeNoTag(i8);
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j8) {
        return computeUInt64SizeNoTag(j8);
    }

    public static int computeSFixed32Size(int i8, int i9) {
        return computeSFixed32SizeNoTag(i9) + computeTagSize(i8);
    }

    public static int computeSFixed32SizeNoTag(int i8) {
        return 4;
    }

    public static int computeSFixed64Size(int i8, long j8) {
        return computeSFixed64SizeNoTag(j8) + computeTagSize(i8);
    }

    public static int computeSFixed64SizeNoTag(long j8) {
        return 8;
    }

    public static int computeSInt32Size(int i8, int i9) {
        return computeSInt32SizeNoTag(i9) + computeTagSize(i8);
    }

    public static int computeSInt32SizeNoTag(int i8) {
        return computeUInt32SizeNoTag(encodeZigZag32(i8));
    }

    public static int computeSInt64Size(int i8, long j8) {
        return computeSInt64SizeNoTag(j8) + computeTagSize(i8);
    }

    public static int computeSInt64SizeNoTag(long j8) {
        return computeUInt64SizeNoTag(encodeZigZag64(j8));
    }

    public static int computeStringSize(int i8, String str) {
        return computeStringSizeNoTag(str) + computeTagSize(i8);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i8) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i8, 0));
    }

    public static int computeUInt32Size(int i8, int i9) {
        return computeUInt32SizeNoTag(i9) + computeTagSize(i8);
    }

    public static int computeUInt32SizeNoTag(int i8) {
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

    public static int computeUInt64Size(int i8, long j8) {
        return computeUInt64SizeNoTag(j8) + computeTagSize(i8);
    }

    public static int computeUInt64SizeNoTag(long j8) {
        int i8;
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (j8 < 0) {
            return 10;
        }
        if (((-34359738368L) & j8) != 0) {
            j8 >>>= 28;
            i8 = 6;
        } else {
            i8 = 2;
        }
        if (((-2097152) & j8) != 0) {
            i8 += 2;
            j8 >>>= 14;
        }
        return (j8 & (-16384)) != 0 ? i8 + 1 : i8;
    }

    public static int encodeZigZag32(int i8) {
        return (i8 >> 31) ^ (i8 << 1);
    }

    public static long encodeZigZag64(long j8) {
        return (j8 >> 63) ^ (j8 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException(e);
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte b9) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i8, int i9) throws IOException;

    public abstract void writeBool(int i8, boolean z2) throws IOException;

    public final void writeBoolNoTag(boolean z2) throws IOException {
        write(z2 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i8, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i8, byte[] bArr, int i9, int i10) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i8, int i9) throws IOException;

    public abstract void writeByteBuffer(int i8, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i8, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i8, double d7) throws IOException {
        writeFixed64(i8, Double.doubleToRawLongBits(d7));
    }

    public final void writeDoubleNoTag(double d7) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d7));
    }

    public final void writeEnum(int i8, int i9) throws IOException {
        writeInt32(i8, i9);
    }

    public final void writeEnumNoTag(int i8) throws IOException {
        writeInt32NoTag(i8);
    }

    public abstract void writeFixed32(int i8, int i9) throws IOException;

    public abstract void writeFixed32NoTag(int i8) throws IOException;

    public abstract void writeFixed64(int i8, long j8) throws IOException;

    public abstract void writeFixed64NoTag(long j8) throws IOException;

    public final void writeFloat(int i8, float f) throws IOException {
        writeFixed32(i8, Float.floatToRawIntBits(f));
    }

    public final void writeFloatNoTag(float f) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void writeGroup(int i8, MessageLite messageLite) throws IOException {
        writeTag(i8, 3);
        writeGroupNoTag(messageLite);
        writeTag(i8, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i8, int i9) throws IOException;

    public abstract void writeInt32NoTag(int i8) throws IOException;

    public final void writeInt64(int i8, long j8) throws IOException {
        writeUInt64(i8, j8);
    }

    public final void writeInt64NoTag(long j8) throws IOException {
        writeUInt64NoTag(j8);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i8, int i9) throws IOException;

    public abstract void writeMessage(int i8, MessageLite messageLite) throws IOException;

    public abstract void writeMessage(int i8, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(int i8, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b9) throws IOException {
        write(b9);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i8) throws IOException {
        writeFixed32NoTag(i8);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j8) throws IOException {
        writeFixed64NoTag(j8);
    }

    public abstract void writeRawMessageSetExtension(int i8, ByteString byteString) throws IOException;

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i8) throws IOException {
        writeUInt32NoTag(i8);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j8) throws IOException {
        writeUInt64NoTag(j8);
    }

    public final void writeSFixed32(int i8, int i9) throws IOException {
        writeFixed32(i8, i9);
    }

    public final void writeSFixed32NoTag(int i8) throws IOException {
        writeFixed32NoTag(i8);
    }

    public final void writeSFixed64(int i8, long j8) throws IOException {
        writeFixed64(i8, j8);
    }

    public final void writeSFixed64NoTag(long j8) throws IOException {
        writeFixed64NoTag(j8);
    }

    public final void writeSInt32(int i8, int i9) throws IOException {
        writeUInt32(i8, encodeZigZag32(i9));
    }

    public final void writeSInt32NoTag(int i8) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i8));
    }

    public final void writeSInt64(int i8, long j8) throws IOException {
        writeUInt64(i8, encodeZigZag64(j8));
    }

    public final void writeSInt64NoTag(long j8) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j8));
    }

    public abstract void writeString(int i8, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i8, int i9) throws IOException;

    public abstract void writeUInt32(int i8, int i9) throws IOException;

    public abstract void writeUInt32NoTag(int i8) throws IOException;

    public abstract void writeUInt64(int i8, long j8) throws IOException;

    public abstract void writeUInt64NoTag(long j8) throws IOException;

    private CodedOutputStream() {
    }

    @Deprecated
    public static int computeGroupSize(int i8, MessageLite messageLite, Schema schema) {
        return computeGroupSizeNoTag(messageLite, schema) + (computeTagSize(i8) * 2);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public static int computeMessageSize(int i8, MessageLite messageLite, Schema schema) {
        return computeMessageSizeNoTag(messageLite, schema) + computeTagSize(i8);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i8) {
        return new OutputStreamEncoder(outputStream, i8);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.wrapper);
    }

    public final void writeRawByte(int i8) throws IOException {
        write((byte) i8);
    }

    public final void writeRawBytes(byte[] bArr, int i8, int i9) throws IOException {
        write(bArr, i8, i9);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.writeTo(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i8, int i9) {
        return new ArrayEncoder(bArr, i8, i9);
    }

    @Deprecated
    public final void writeGroup(int i8, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i8, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i8, 4);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (UnsafeDirectNioEncoder.isSupported()) {
                return newUnsafeInstance(byteBuffer);
            }
            return newSafeInstance(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i8) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(ByteOutput byteOutput, int i8) {
        if (i8 >= 0) {
            return new ByteOutputEncoder(byteOutput, i8);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
