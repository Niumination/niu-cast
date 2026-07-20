package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class Snappy {
    private static final int COPY_1_BYTE_OFFSET = 1;
    private static final int COPY_2_BYTE_OFFSET = 2;
    private static final int COPY_4_BYTE_OFFSET = 3;
    private static final int LITERAL = 0;
    private static final int MAX_HT_SIZE = 16384;
    private static final int MIN_COMPRESSIBLE_BYTES = 15;
    private static final int NOT_ENOUGH_INPUT = -1;
    private static final int PREAMBLE_NOT_FULL = -1;
    private State state = State.READING_PREAMBLE;
    private byte tag;
    private int written;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Snappy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Snappy$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Snappy$State = iArr;
            try {
                iArr[State.READING_PREAMBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_TAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_LITERAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_COPY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum State {
        READING_PREAMBLE,
        READING_TAG,
        READING_LITERAL,
        READING_COPY
    }

    private static int bitsToEncode(int i10) {
        int iHighestOneBit = Integer.highestOneBit(i10);
        int i11 = 0;
        while (true) {
            iHighestOneBit >>= 1;
            if (iHighestOneBit == 0) {
                return i11;
            }
            i11++;
        }
    }

    public static int calculateChecksum(ByteBuf byteBuf) {
        return calculateChecksum(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static int decodeCopyWith1ByteOffset(byte b10, ByteBuf byteBuf, ByteBuf byteBuf2, int i10) {
        if (!byteBuf.isReadable()) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i11 = ((b10 & 28) >> 2) + 4;
        int unsignedByte = (((b10 & 224) << 8) >> 5) | byteBuf.readUnsignedByte();
        validateOffset(unsignedByte, i10);
        byteBuf2.markReaderIndex();
        if (unsignedByte < i11) {
            for (int i12 = i11 / unsignedByte; i12 > 0; i12--) {
                byteBuf2.readerIndex(iWriterIndex - unsignedByte);
                byteBuf2.readBytes(byteBuf2, unsignedByte);
            }
            int i13 = i11 % unsignedByte;
            if (i13 != 0) {
                byteBuf2.readerIndex(iWriterIndex - unsignedByte);
                byteBuf2.readBytes(byteBuf2, i13);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - unsignedByte);
            byteBuf2.readBytes(byteBuf2, i11);
        }
        byteBuf2.resetReaderIndex();
        return i11;
    }

    private static int decodeCopyWith2ByteOffset(byte b10, ByteBuf byteBuf, ByteBuf byteBuf2, int i10) {
        if (byteBuf.readableBytes() < 2) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i11 = ((b10 >> 2) & 63) + 1;
        int unsignedShortLE = byteBuf.readUnsignedShortLE();
        validateOffset(unsignedShortLE, i10);
        byteBuf2.markReaderIndex();
        if (unsignedShortLE < i11) {
            for (int i12 = i11 / unsignedShortLE; i12 > 0; i12--) {
                byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
                byteBuf2.readBytes(byteBuf2, unsignedShortLE);
            }
            int i13 = i11 % unsignedShortLE;
            if (i13 != 0) {
                byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
                byteBuf2.readBytes(byteBuf2, i13);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
            byteBuf2.readBytes(byteBuf2, i11);
        }
        byteBuf2.resetReaderIndex();
        return i11;
    }

    private static int decodeCopyWith4ByteOffset(byte b10, ByteBuf byteBuf, ByteBuf byteBuf2, int i10) {
        if (byteBuf.readableBytes() < 4) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i11 = ((b10 >> 2) & 63) + 1;
        int intLE = byteBuf.readIntLE();
        validateOffset(intLE, i10);
        byteBuf2.markReaderIndex();
        if (intLE < i11) {
            for (int i12 = i11 / intLE; i12 > 0; i12--) {
                byteBuf2.readerIndex(iWriterIndex - intLE);
                byteBuf2.readBytes(byteBuf2, intLE);
            }
            int i13 = i11 % intLE;
            if (i13 != 0) {
                byteBuf2.readerIndex(iWriterIndex - intLE);
                byteBuf2.readBytes(byteBuf2, i13);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - intLE);
            byteBuf2.readBytes(byteBuf2, i11);
        }
        byteBuf2.resetReaderIndex();
        return i11;
    }

    public static int decodeLiteral(byte b10, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf.markReaderIndex();
        int unsignedByte = (b10 >> 2) & 63;
        switch (unsignedByte) {
            case 60:
                if (!byteBuf.isReadable()) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedByte();
                break;
                break;
            case 61:
                if (byteBuf.readableBytes() < 2) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedShortLE();
                break;
            case 62:
                if (byteBuf.readableBytes() < 3) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedMediumLE();
                break;
            case 63:
                if (byteBuf.readableBytes() < 4) {
                    return -1;
                }
                unsignedByte = byteBuf.readIntLE();
                break;
        }
        int i10 = unsignedByte + 1;
        if (byteBuf.readableBytes() < i10) {
            byteBuf.resetReaderIndex();
            return -1;
        }
        byteBuf2.writeBytes(byteBuf, i10);
        return i10;
    }

    private static void encodeCopy(ByteBuf byteBuf, int i10, int i11) {
        while (i11 >= 68) {
            encodeCopyWithOffset(byteBuf, i10, 64);
            i11 -= 64;
        }
        if (i11 > 64) {
            encodeCopyWithOffset(byteBuf, i10, 60);
            i11 -= 60;
        }
        encodeCopyWithOffset(byteBuf, i10, i11);
    }

    private static void encodeCopyWithOffset(ByteBuf byteBuf, int i10, int i11) {
        if (i11 < 12 && i10 < 2048) {
            byteBuf.writeByte(((i11 - 4) << 2) | 1 | ((i10 >> 8) << 5));
            byteBuf.writeByte(i10 & 255);
        } else {
            byteBuf.writeByte(((i11 - 1) << 2) | 2);
            byteBuf.writeByte(i10 & 255);
            byteBuf.writeByte((i10 >> 8) & 255);
        }
    }

    public static void encodeLiteral(ByteBuf byteBuf, ByteBuf byteBuf2, int i10) {
        if (i10 < 61) {
            byteBuf2.writeByte((i10 - 1) << 2);
        } else {
            int i11 = i10 - 1;
            int iBitsToEncode = bitsToEncode(i11) / 8;
            int i12 = iBitsToEncode + 1;
            byteBuf2.writeByte((iBitsToEncode + 60) << 2);
            for (int i13 = 0; i13 < i12; i13++) {
                byteBuf2.writeByte((i11 >> (i13 * 8)) & 255);
            }
        }
        byteBuf2.writeBytes(byteBuf, i10);
    }

    private static int findMatchingLength(ByteBuf byteBuf, int i10, int i11, int i12) {
        int i13 = 0;
        while (i11 <= i12 - 4 && byteBuf.getInt(i11) == byteBuf.getInt(i10 + i13)) {
            i11 += 4;
            i13 += 4;
        }
        while (i11 < i12 && byteBuf.getByte(i10 + i13) == byteBuf.getByte(i11)) {
            i11++;
            i13++;
        }
        return i13;
    }

    private static short[] getHashTable(int i10) {
        int i11 = 256;
        while (i11 < 16384 && i11 < i10) {
            i11 <<= 1;
        }
        return new short[i11];
    }

    private static int hash(ByteBuf byteBuf, int i10, int i11) {
        return (byteBuf.getInt(i10) * 506832829) >>> i11;
    }

    public static int maskChecksum(long j10) {
        return (int) (((j10 << 17) | (j10 >> 15)) - 1568478504);
    }

    private static int readPreamble(ByteBuf byteBuf) {
        int i10 = 0;
        int i11 = 0;
        while (byteBuf.isReadable()) {
            short unsignedByte = byteBuf.readUnsignedByte();
            int i12 = i11 + 1;
            i10 |= (unsignedByte & 127) << (i11 * 7);
            if ((unsignedByte & 128) == 0) {
                return i10;
            }
            if (i12 >= 4) {
                throw new DecompressionException("Preamble is greater than 4 bytes");
            }
            i11 = i12;
        }
        return 0;
    }

    public static void validateChecksum(int i10, ByteBuf byteBuf) {
        validateChecksum(i10, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static void validateOffset(int i10, int i11) {
        if (i10 == 0) {
            throw new DecompressionException("Offset is less than minimum permissible value");
        }
        if (i10 < 0) {
            throw new DecompressionException("Offset is greater than maximum value supported by this implementation");
        }
        if (i10 > i11) {
            throw new DecompressionException("Offset exceeds size of chunk");
        }
    }

    public void decode(ByteBuf byteBuf, ByteBuf byteBuf2) {
        while (byteBuf.isReadable()) {
            int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Snappy$State[this.state.ordinal()];
            if (i10 == 1) {
                int preamble = readPreamble(byteBuf);
                if (preamble == -1 || preamble == 0) {
                    return;
                }
                byteBuf2.ensureWritable(preamble);
                this.state = State.READING_TAG;
            } else if (i10 != 2) {
                if (i10 == 3) {
                    int iDecodeLiteral = decodeLiteral(this.tag, byteBuf, byteBuf2);
                    if (iDecodeLiteral == -1) {
                        return;
                    }
                    this.state = State.READING_TAG;
                    this.written += iDecodeLiteral;
                } else if (i10 == 4) {
                    byte b10 = this.tag;
                    int i11 = b10 & 3;
                    if (i11 == 1) {
                        int iDecodeCopyWith1ByteOffset = decodeCopyWith1ByteOffset(b10, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith1ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith1ByteOffset;
                    } else if (i11 == 2) {
                        int iDecodeCopyWith2ByteOffset = decodeCopyWith2ByteOffset(b10, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith2ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith2ByteOffset;
                    } else if (i11 == 3) {
                        int iDecodeCopyWith4ByteOffset = decodeCopyWith4ByteOffset(b10, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith4ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith4ByteOffset;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (!byteBuf.isReadable()) {
                return;
            }
            byte b11 = byteBuf.readByte();
            this.tag = b11;
            int i12 = b11 & 3;
            if (i12 == 0) {
                this.state = State.READING_LITERAL;
            } else if (i12 == 1 || i12 == 2 || i12 == 3) {
                this.state = State.READING_COPY;
            }
        }
    }

    public void encode(ByteBuf byteBuf, ByteBuf byteBuf2, int i10) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        while (true) {
            i11 = i10 >>> (i14 * 7);
            if ((i11 & (-128)) == 0) {
                break;
            }
            byteBuf2.writeByte((i11 & 127) | 128);
            i14++;
        }
        byteBuf2.writeByte(i11);
        int i15 = byteBuf.readerIndex();
        short[] hashTable = getHashTable(i10);
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(hashTable.length) + 1;
        if (i10 - i15 >= 15) {
            int i16 = i15 + 1;
            int iHash = hash(byteBuf, i16, iNumberOfLeadingZeros);
            int i17 = i15;
            loop1: while (true) {
                int i18 = 32;
                while (true) {
                    int i19 = i18 + 1;
                    int i20 = (i18 >> 5) + i16;
                    i12 = i10 - 4;
                    if (i20 > i12) {
                        break loop1;
                    }
                    int iHash2 = hash(byteBuf, i20, iNumberOfLeadingZeros);
                    i13 = hashTable[iHash] + i15;
                    hashTable[iHash] = (short) (i16 - i15);
                    if (byteBuf.getInt(i16) == byteBuf.getInt(i13)) {
                        break;
                    }
                    i16 = i20;
                    i18 = i19;
                    iHash = iHash2;
                }
                encodeLiteral(byteBuf, byteBuf2, i16 - i17);
                while (true) {
                    int iFindMatchingLength = findMatchingLength(byteBuf, i13 + 4, i16 + 4, i10) + 4;
                    i17 = i16 + iFindMatchingLength;
                    encodeCopy(byteBuf2, i16 - i13, iFindMatchingLength);
                    byteBuf.readerIndex(byteBuf.readerIndex() + iFindMatchingLength);
                    int i21 = i17 - 1;
                    if (i17 >= i12) {
                        break loop1;
                    }
                    int i22 = i17 - i15;
                    hashTable[hash(byteBuf, i21, iNumberOfLeadingZeros)] = (short) (i22 - 1);
                    int iHash3 = hash(byteBuf, i17, iNumberOfLeadingZeros);
                    i13 = i15 + hashTable[iHash3];
                    hashTable[iHash3] = (short) i22;
                    if (byteBuf.getInt(i17) != byteBuf.getInt(i13)) {
                        break;
                    } else {
                        i16 = i17;
                    }
                }
                iHash = hash(byteBuf, i17 + 1, iNumberOfLeadingZeros);
                i16 = i17 + 1;
            }
            i15 = i17;
        }
        if (i15 < i10) {
            encodeLiteral(byteBuf, byteBuf2, i10 - i15);
        }
    }

    public int getPreamble(ByteBuf byteBuf) {
        if (this.state != State.READING_PREAMBLE) {
            return 0;
        }
        int i10 = byteBuf.readerIndex();
        try {
            return readPreamble(byteBuf);
        } finally {
            byteBuf.readerIndex(i10);
        }
    }

    public void reset() {
        this.state = State.READING_PREAMBLE;
        this.tag = (byte) 0;
        this.written = 0;
    }

    public static int calculateChecksum(ByteBuf byteBuf, int i10, int i11) {
        Crc32c crc32c = new Crc32c();
        try {
            crc32c.update(byteBuf, i10, i11);
            return maskChecksum(crc32c.getValue());
        } finally {
            crc32c.reset();
        }
    }

    public static void validateChecksum(int i10, ByteBuf byteBuf, int i11, int i12) {
        int iCalculateChecksum = calculateChecksum(byteBuf, i11, i12);
        if (iCalculateChecksum == i10) {
            return;
        }
        throw new DecompressionException("mismatching checksum: " + Integer.toHexString(iCalculateChecksum) + " (expected: " + Integer.toHexString(i10) + ')');
    }
}
