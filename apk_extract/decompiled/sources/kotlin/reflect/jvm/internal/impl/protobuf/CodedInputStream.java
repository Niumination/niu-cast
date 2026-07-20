package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CodedInputStream {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(InputStream inputStream) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    public static int decodeZigZag32(int i8) {
        return (-(i8 & 1)) ^ (i8 >>> 1);
    }

    public static long decodeZigZag64(long j8) {
        return (-(j8 & 1)) ^ (j8 >>> 1);
    }

    private void ensureAvailable(int i8) throws IOException {
        if (this.bufferSize - this.bufferPos < i8) {
            refillBuffer(i8);
        }
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    private byte[] readRawBytesSlowPath(int i8) throws IOException {
        if (i8 <= 0) {
            if (i8 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i9 = this.totalBytesRetired;
        int i10 = this.bufferPos;
        int i11 = i9 + i10 + i8;
        int i12 = this.currentLimit;
        if (i11 > i12) {
            skipRawBytes((i12 - i9) - i10);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i8 < 4096) {
            byte[] bArr = new byte[i8];
            int i13 = this.bufferSize - i10;
            System.arraycopy(this.buffer, i10, bArr, 0, i13);
            this.bufferPos = this.bufferSize;
            int i14 = i8 - i13;
            ensureAvailable(i14);
            System.arraycopy(this.buffer, 0, bArr, i13, i14);
            this.bufferPos = i14;
            return bArr;
        }
        int i15 = this.bufferSize;
        this.totalBytesRetired = i9 + i15;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int length = i15 - i10;
        int i16 = i8 - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i16 > 0) {
            int iMin = Math.min(i16, 4096);
            byte[] bArr2 = new byte[iMin];
            int i17 = 0;
            while (i17 < iMin) {
                InputStream inputStream = this.input;
                int i18 = inputStream == null ? -1 : inputStream.read(bArr2, i17, iMin - i17);
                if (i18 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += i18;
                i17 += i18;
            }
            i16 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(this.buffer, i10, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    private void recomputeBufferSizeAfterLimit() {
        int i8 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i8;
        int i9 = this.totalBytesRetired + i8;
        int i10 = this.currentLimit;
        if (i9 <= i10) {
            this.bufferSizeAfterLimit = 0;
            return;
        }
        int i11 = i9 - i10;
        this.bufferSizeAfterLimit = i11;
        this.bufferSize = i8 - i11;
    }

    private void refillBuffer(int i8) throws IOException {
        if (!tryRefillBuffer(i8)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void skipRawBytesSlowPath(int i8) throws IOException {
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i9 = this.totalBytesRetired;
        int i10 = this.bufferPos;
        int i11 = i9 + i10 + i8;
        int i12 = this.currentLimit;
        if (i11 > i12) {
            skipRawBytes((i12 - i9) - i10);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i13 = this.bufferSize;
        int i14 = i13 - i10;
        this.bufferPos = i13;
        refillBuffer(1);
        while (true) {
            int i15 = i8 - i14;
            int i16 = this.bufferSize;
            if (i15 <= i16) {
                this.bufferPos = i15;
                return;
            } else {
                i14 += i16;
                this.bufferPos = i16;
                refillBuffer(1);
            }
        }
    }

    private boolean tryRefillBuffer(int i8) throws IOException {
        int i9 = this.bufferPos;
        if (i9 + i8 <= this.bufferSize) {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i8);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
        if (this.totalBytesRetired + i9 + i8 > this.currentLimit) {
            return false;
        }
        RefillCallback refillCallback = this.refillCallback;
        if (refillCallback != null) {
            refillCallback.onRefill();
        }
        if (this.input != null) {
            int i10 = this.bufferPos;
            if (i10 > 0) {
                int i11 = this.bufferSize;
                if (i11 > i10) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i10, bArr, 0, i11 - i10);
                }
                this.totalBytesRetired += i10;
                this.bufferSize -= i10;
                this.bufferPos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i12 = this.bufferSize;
            int i13 = inputStream.read(bArr2, i12, bArr2.length - i12);
            if (i13 == 0 || i13 < -1 || i13 > this.buffer.length) {
                StringBuilder sb3 = new StringBuilder(102);
                sb3.append("InputStream#read(byte[]) returned invalid result: ");
                sb3.append(i13);
                sb3.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb3.toString());
            }
            if (i13 > 0) {
                this.bufferSize += i13;
                if ((this.totalBytesRetired + i8) - this.sizeLimit > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                recomputeBufferSizeAfterLimit();
                if (this.bufferSize >= i8) {
                    return true;
                }
                return tryRefillBuffer(i8);
            }
        }
        return false;
    }

    public void checkLastTagWas(int i8) throws InvalidProtocolBufferException {
        if (this.lastTag != i8) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        int i8 = this.currentLimit;
        if (i8 == Integer.MAX_VALUE) {
            return -1;
        }
        return i8 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !tryRefillBuffer(1);
    }

    public void popLimit(int i8) {
        this.currentLimit = i8;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i8) throws InvalidProtocolBufferException {
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i9 = this.totalBytesRetired + this.bufferPos + i8;
        int i10 = this.currentLimit;
        if (i9 > i10) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = i9;
        recomputeBufferSizeAfterLimit();
        return i10;
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public ByteString readBytes() throws IOException {
        int rawVarint32 = readRawVarint32();
        int i8 = this.bufferSize;
        int i9 = this.bufferPos;
        if (rawVarint32 > i8 - i9 || rawVarint32 <= 0) {
            return rawVarint32 == 0 ? ByteString.EMPTY : new LiteralByteString(readRawBytesSlowPath(rawVarint32));
        }
        ByteString boundedByteString = (this.bufferIsImmutable && this.enableAliasing) ? new BoundedByteString(this.buffer, this.bufferPos, rawVarint32) : ByteString.copyFrom(this.buffer, i9, rawVarint32);
        this.bufferPos += rawVarint32;
        return boundedByteString;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i8, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i9 = this.recursionDepth;
        if (i9 >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth = i9 + 1;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(i8, 4));
        this.recursionDepth--;
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int rawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int iPushLimit = pushLimit(rawVarint32);
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(iPushLimit);
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i8 = this.bufferPos;
        this.bufferPos = i8 + 1;
        return bArr[i8];
    }

    public int readRawLittleEndian32() throws IOException {
        int i8 = this.bufferPos;
        if (this.bufferSize - i8 < 4) {
            refillBuffer(4);
            i8 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i8 + 4;
        return (bArr[i8] & UByte.MAX_VALUE) | ((bArr[i8 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i8 + 2] & UByte.MAX_VALUE) << 16) | ((bArr[i8 + 3] & UByte.MAX_VALUE) << 24);
    }

    public long readRawLittleEndian64() throws IOException {
        int i8 = this.bufferPos;
        if (this.bufferSize - i8 < 8) {
            refillBuffer(8);
            i8 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i8 + 8;
        return ((((long) bArr[i8 + 7]) & 255) << 56) | (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48);
    }

    public int readRawVarint32() throws IOException {
        int i8;
        int i9 = this.bufferPos;
        int i10 = this.bufferSize;
        if (i10 != i9) {
            byte[] bArr = this.buffer;
            int i11 = i9 + 1;
            byte b9 = bArr[i9];
            if (b9 >= 0) {
                this.bufferPos = i11;
                return b9;
            }
            if (i10 - i11 >= 9) {
                int i12 = i9 + 2;
                int i13 = (bArr[i11] << 7) ^ b9;
                long j8 = i13;
                if (j8 < 0) {
                    i8 = (int) ((-128) ^ j8);
                } else {
                    int i14 = i9 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    long j10 = i15;
                    if (j10 >= 0) {
                        i8 = (int) (16256 ^ j10);
                    } else {
                        int i16 = i9 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        long j11 = i17;
                        if (j11 < 0) {
                            i8 = (int) ((-2080896) ^ j11);
                        } else {
                            i14 = i9 + 5;
                            byte b10 = bArr[i16];
                            int i18 = (int) (((long) (i17 ^ (b10 << 28))) ^ 266354560);
                            if (b10 < 0) {
                                i16 = i9 + 6;
                                if (bArr[i14] < 0) {
                                    i14 = i9 + 7;
                                    if (bArr[i16] < 0) {
                                        i16 = i9 + 8;
                                        if (bArr[i14] < 0) {
                                            i14 = i9 + 9;
                                            if (bArr[i16] < 0) {
                                                int i19 = i9 + 10;
                                                if (bArr[i14] >= 0) {
                                                    i12 = i19;
                                                    i8 = i18;
                                                }
                                            }
                                        }
                                    }
                                }
                                i8 = i18;
                            }
                            i8 = i18;
                        }
                        i12 = i16;
                    }
                    i12 = i14;
                }
                this.bufferPos = i12;
                return i8;
            }
        }
        return (int) readRawVarint64SlowPath();
    }

    public long readRawVarint64() throws IOException {
        long j8;
        long j10;
        long j11;
        int i8 = this.bufferPos;
        int i9 = this.bufferSize;
        if (i9 != i8) {
            byte[] bArr = this.buffer;
            int i10 = i8 + 1;
            byte b9 = bArr[i8];
            if (b9 >= 0) {
                this.bufferPos = i10;
                return b9;
            }
            if (i9 - i10 >= 9) {
                int i11 = i8 + 2;
                long j12 = (bArr[i10] << 7) ^ b9;
                if (j12 >= 0) {
                    int i12 = i8 + 3;
                    long j13 = j12 ^ ((long) (bArr[i11] << 14));
                    if (j13 >= 0) {
                        j11 = 16256;
                    } else {
                        i11 = i8 + 4;
                        j12 = j13 ^ ((long) (bArr[i12] << 21));
                        if (j12 < 0) {
                            j10 = -2080896;
                        } else {
                            i12 = i8 + 5;
                            j13 = j12 ^ (((long) bArr[i11]) << 28);
                            if (j13 >= 0) {
                                j11 = 266354560;
                            } else {
                                i11 = i8 + 6;
                                j12 = j13 ^ (((long) bArr[i12]) << 35);
                                if (j12 >= 0) {
                                    i12 = i8 + 7;
                                    j13 = j12 ^ (((long) bArr[i11]) << 42);
                                    if (j13 >= 0) {
                                        j11 = 4363953127296L;
                                    } else {
                                        i11 = i8 + 8;
                                        j12 = j13 ^ (((long) bArr[i12]) << 49);
                                        if (j12 < 0) {
                                            j10 = -558586000294016L;
                                        } else {
                                            i12 = i8 + 9;
                                            long j14 = (j12 ^ (((long) bArr[i11]) << 56)) ^ 71499008037633920L;
                                            if (j14 < 0) {
                                                i11 = i8 + 10;
                                                if (bArr[i12] >= 0) {
                                                    j8 = j14;
                                                }
                                            } else {
                                                j8 = j14;
                                                i11 = i12;
                                            }
                                        }
                                    }
                                    this.bufferPos = i11;
                                    return j8;
                                }
                                j10 = -34093383808L;
                            }
                        }
                    }
                    j8 = j13 ^ j11;
                    i11 = i12;
                    this.bufferPos = i11;
                    return j8;
                }
                j10 = -128;
                j8 = j12 ^ j10;
                this.bufferPos = i11;
                return j8;
            }
        }
        return readRawVarint64SlowPath();
    }

    public long readRawVarint64SlowPath() throws IOException {
        long j8 = 0;
        for (int i8 = 0; i8 < 64; i8 += 7) {
            byte rawByte = readRawByte();
            j8 |= ((long) (rawByte & ByteCompanionObject.MAX_VALUE)) << i8;
            if ((rawByte & ByteCompanionObject.MIN_VALUE) == 0) {
                return j8;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int rawVarint32 = readRawVarint32();
        int i8 = this.bufferSize;
        int i9 = this.bufferPos;
        if (rawVarint32 > i8 - i9 || rawVarint32 <= 0) {
            return rawVarint32 == 0 ? "" : new String(readRawBytesSlowPath(rawVarint32), "UTF-8");
        }
        String str = new String(this.buffer, i9, rawVarint32, "UTF-8");
        this.bufferPos += rawVarint32;
        return str;
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] rawBytesSlowPath;
        int rawVarint32 = readRawVarint32();
        int i8 = this.bufferPos;
        if (rawVarint32 <= this.bufferSize - i8 && rawVarint32 > 0) {
            rawBytesSlowPath = this.buffer;
            this.bufferPos = i8 + rawVarint32;
        } else {
            if (rawVarint32 == 0) {
                return "";
            }
            rawBytesSlowPath = readRawBytesSlowPath(rawVarint32);
            i8 = 0;
        }
        if (Utf8.isValidUtf8(rawBytesSlowPath, i8, i8 + rawVarint32)) {
            return new String(rawBytesSlowPath, i8, rawVarint32, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int rawVarint32 = readRawVarint32();
        this.lastTag = rawVarint32;
        if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
            return this.lastTag;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public boolean skipField(int i8, CodedOutputStream codedOutputStream) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i8);
        if (tagWireType == 0) {
            long int64 = readInt64();
            codedOutputStream.writeRawVarint32(i8);
            codedOutputStream.writeUInt64NoTag(int64);
            return true;
        }
        if (tagWireType == 1) {
            long rawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i8);
            codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
            return true;
        }
        if (tagWireType == 2) {
            ByteString bytes = readBytes();
            codedOutputStream.writeRawVarint32(i8);
            codedOutputStream.writeBytesNoTag(bytes);
            return true;
        }
        if (tagWireType == 3) {
            codedOutputStream.writeRawVarint32(i8);
            skipMessage(codedOutputStream);
            int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i8), 4);
            checkLastTagWas(iMakeTag);
            codedOutputStream.writeRawVarint32(iMakeTag);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int rawLittleEndian32 = readRawLittleEndian32();
        codedOutputStream.writeRawVarint32(i8);
        codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
        return true;
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int tag;
        do {
            tag = readTag();
            if (tag == 0) {
                return;
            }
        } while (skipField(tag, codedOutputStream));
    }

    public void skipRawBytes(int i8) throws IOException {
        int i9 = this.bufferSize;
        int i10 = this.bufferPos;
        if (i8 > i9 - i10 || i8 < 0) {
            skipRawBytesSlowPath(i8);
        } else {
            this.bufferPos = i10 + i8;
        }
    }

    public static CodedInputStream newInstance(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int rawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
            return partialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.refillCallback = null;
        this.buffer = literalByteString.bytes;
        int offsetIntoBytes = literalByteString.getOffsetIntoBytes();
        this.bufferPos = offsetIntoBytes;
        this.bufferSize = offsetIntoBytes + literalByteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public static int readRawVarint32(int i8, InputStream inputStream) throws IOException {
        if ((i8 & 128) == 0) {
            return i8;
        }
        int i9 = i8 & 127;
        int i10 = 7;
        while (i10 < 32) {
            int i11 = inputStream.read();
            if (i11 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i9 |= (i11 & 127) << i10;
            if ((i11 & 128) == 0) {
                return i9;
            }
            i10 += 7;
        }
        while (i10 < 64) {
            int i12 = inputStream.read();
            if (i12 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i12 & 128) == 0) {
                return i9;
            }
            i10 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
}
