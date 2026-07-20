package io.netty.handler.codec.compression;

import e8.w;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Bzip2Decoder extends ByteToMessageDecoder {
    private int blockCRC;
    private Bzip2BlockDecompressor blockDecompressor;
    private int blockSize;
    private Bzip2HuffmanStageDecoder huffmanStageDecoder;
    private int streamCRC;
    private State currentState = State.INIT;
    private final Bzip2BitReader reader = new Bzip2BitReader();

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Bzip2Decoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.INIT_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.INIT_BLOCK_PARAMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_USED_MAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_USED_BITMAPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_SELECTORS_NUMBER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_SELECTORS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_LENGTH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.DECODE_HUFFMAN_DATA.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.EOF.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public enum State {
        INIT,
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        RECEIVE_HUFFMAN_USED_MAP,
        RECEIVE_HUFFMAN_USED_BITMAPS,
        RECEIVE_SELECTORS_NUMBER,
        RECEIVE_SELECTORS,
        RECEIVE_HUFFMAN_LENGTH,
        DECODE_HUFFMAN_DATA,
        EOF
    }

    /* JADX WARN: Code duplicated, block: B:100:0x019e  */
    /* JADX WARN: Code duplicated, block: B:103:0x01a5 A[LOOP:7: B:103:0x01a5->B:118:0x01d1, LOOP_START, PHI: r7 r8
      0x01a5: PHI (r7v7 int) = (r7v5 int), (r7v8 int) binds: [B:101:0x01a2, B:118:0x01d1] A[DONT_GENERATE, DONT_INLINE]
      0x01a5: PHI (r8v6 boolean) = (r8v4 boolean), (r8v14 boolean) binds: [B:101:0x01a2, B:118:0x01d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:104:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:111:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d1 A[LOOP:7: B:103:0x01a5->B:118:0x01d1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:122:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:124:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:127:0x01fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:128:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:130:0x0202  */
    /* JADX WARN: Code duplicated, block: B:136:0x021d A[Catch: all -> 0x0221, LOOP:8: B:156:0x0217->B:136:0x021d, LOOP_END, TryCatch #0 {all -> 0x0221, blocks: (B:134:0x0217, B:136:0x021d, B:139:0x0223), top: B:156:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x015f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x01da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0223 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:59:0x0101  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    /* JADX WARN: Code duplicated, block: B:65:0x011f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x0139 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x013a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0159  */
    /* JADX WARN: Code duplicated, block: B:83:0x0162  */
    /* JADX WARN: Code duplicated, block: B:86:0x0169 A[LOOP:4: B:84:0x0163->B:86:0x0169, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:91:0x0189  */
    /* JADX WARN: Code duplicated, block: B:95:0x0193 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0195  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Bzip2BlockDecompressor bzip2BlockDecompressor;
        int i10;
        ByteBuf byteBufBuffer;
        int i11;
        Bzip2HuffmanStageDecoder bzip2HuffmanStageDecoder;
        int i12;
        byte[][] bArr;
        int i13;
        int bits;
        boolean z10;
        int i14;
        int i15;
        int i16;
        Bzip2HuffmanStageDecoder bzip2HuffmanStageDecoder2;
        byte[] bArr2;
        int length;
        Bzip2MoveToFrontTable bzip2MoveToFrontTable;
        int i17;
        int i18;
        int bits2;
        Bzip2BlockDecompressor bzip2BlockDecompressor2;
        int i19;
        int iBitCount;
        byte[] bArr3;
        int i20;
        int bits3;
        int i21;
        int i22;
        int i23;
        if (byteBuf.isReadable()) {
            Bzip2BitReader bzip2BitReader = this.reader;
            bzip2BitReader.setByteBuf(byteBuf);
            while (true) {
                int i24 = 16;
                boolean z11 = false;
                switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[this.currentState.ordinal()]) {
                    case 1:
                        if (byteBuf.readableBytes() < 4) {
                            return;
                        }
                        if (byteBuf.readUnsignedMedium() != 4348520) {
                            throw new DecompressionException("Unexpected stream identifier contents. Mismatched bzip2 protocol version?");
                        }
                        int i25 = byteBuf.readByte() - 48;
                        if (i25 < 1 || i25 > 9) {
                            throw new DecompressionException("block size is invalid");
                        }
                        this.blockSize = i25 * w.f4155d;
                        this.streamCRC = 0;
                        this.currentState = State.INIT_BLOCK;
                        break;
                    case 2:
                        if (!bzip2BitReader.hasReadableBytes(10)) {
                            return;
                        }
                        int bits4 = bzip2BitReader.readBits(24);
                        int bits5 = bzip2BitReader.readBits(24);
                        if (bits4 == 1536581 && bits5 == 3690640) {
                            if (bzip2BitReader.readInt() != this.streamCRC) {
                                throw new DecompressionException("stream CRC error");
                            }
                            this.currentState = State.EOF;
                            break;
                        } else {
                            if (bits4 != 3227993 || bits5 != 2511705) {
                                throw new DecompressionException("bad block header");
                            }
                            this.blockCRC = bzip2BitReader.readInt();
                            this.currentState = State.INIT_BLOCK_PARAMS;
                            if (!bzip2BitReader.hasReadableBits(25)) {
                                return;
                            }
                            this.blockDecompressor = new Bzip2BlockDecompressor(this.blockSize, this.blockCRC, bzip2BitReader.readBoolean(), bzip2BitReader.readBits(24), bzip2BitReader);
                            this.currentState = State.RECEIVE_HUFFMAN_USED_MAP;
                            if (!bzip2BitReader.hasReadableBits(16)) {
                                return;
                            }
                            this.blockDecompressor.huffmanInUse16 = bzip2BitReader.readBits(16);
                            this.currentState = State.RECEIVE_HUFFMAN_USED_BITMAPS;
                            bzip2BlockDecompressor2 = this.blockDecompressor;
                            i19 = bzip2BlockDecompressor2.huffmanInUse16;
                            iBitCount = Integer.bitCount(i19);
                            bArr3 = bzip2BlockDecompressor2.huffmanSymbolMap;
                            if (!bzip2BitReader.hasReadableBits((iBitCount * 16) + 3)) {
                                return;
                            }
                            if (iBitCount > 0) {
                                i21 = 0;
                                i20 = 0;
                                while (i21 < i24) {
                                    if (((32768 >>> i21) & i19) != 0) {
                                        i22 = i21 << 4;
                                        i23 = 0;
                                        while (i23 < i24) {
                                            if (bzip2BitReader.readBoolean()) {
                                                bArr3[i20] = (byte) i22;
                                                i20++;
                                            }
                                            i23++;
                                            i22++;
                                            i24 = 16;
                                        }
                                    }
                                    i21++;
                                    i24 = 16;
                                }
                            } else {
                                i20 = 0;
                            }
                            bzip2BlockDecompressor2.huffmanEndOfBlockSymbol = i20 + 1;
                            bits3 = bzip2BitReader.readBits(3);
                            if (bits3 >= 2 || bits3 > 6) {
                                throw new DecompressionException("incorrect huffman groups number");
                            }
                            int i26 = i20 + 2;
                            if (i26 > 258) {
                                throw new DecompressionException("incorrect alphabet size");
                            }
                            this.huffmanStageDecoder = new Bzip2HuffmanStageDecoder(bzip2BitReader, bits3, i26);
                            this.currentState = State.RECEIVE_SELECTORS_NUMBER;
                            if (!bzip2BitReader.hasReadableBits(15)) {
                                return;
                            }
                            bits2 = bzip2BitReader.readBits(15);
                            if (bits2 >= 1 || bits2 > 18002) {
                                throw new DecompressionException("incorrect selectors number");
                            }
                            this.huffmanStageDecoder.selectors = new byte[bits2];
                            this.currentState = State.RECEIVE_SELECTORS;
                            bzip2HuffmanStageDecoder2 = this.huffmanStageDecoder;
                            bArr2 = bzip2HuffmanStageDecoder2.selectors;
                            length = bArr2.length;
                            bzip2MoveToFrontTable = bzip2HuffmanStageDecoder2.tableMTF;
                            for (i17 = bzip2HuffmanStageDecoder2.currentSelector; i17 < length; i17++) {
                                if (!bzip2BitReader.hasReadableBits(6)) {
                                    bzip2HuffmanStageDecoder2.currentSelector = i17;
                                    return;
                                }
                                i18 = 0;
                                while (bzip2BitReader.readBoolean()) {
                                    i18++;
                                }
                                bArr2[i17] = bzip2MoveToFrontTable.indexToFront(i18);
                            }
                            this.currentState = State.RECEIVE_HUFFMAN_LENGTH;
                            bzip2HuffmanStageDecoder = this.huffmanStageDecoder;
                            i12 = bzip2HuffmanStageDecoder.totalTables;
                            bArr = bzip2HuffmanStageDecoder.tableCodeLengths;
                            i13 = bzip2HuffmanStageDecoder.alphabetSize;
                            bits = bzip2HuffmanStageDecoder.currentLength;
                            z10 = bzip2HuffmanStageDecoder.modifyLength;
                            i14 = bzip2HuffmanStageDecoder.currentGroup;
                            while (true) {
                                if (i14 < i12) {
                                    if (bzip2BitReader.hasReadableBits(5)) {
                                        if (bits < 0) {
                                            bits = bzip2BitReader.readBits(5);
                                        }
                                        i15 = bzip2HuffmanStageDecoder.currentAlpha;
                                        while (true) {
                                            if (i15 >= i13) {
                                                bzip2HuffmanStageDecoder.currentAlpha = 0;
                                                i14++;
                                                z10 = false;
                                                bits = -1;
                                            } else if (bzip2BitReader.isReadable()) {
                                                while (true) {
                                                    if (z10 && !bzip2BitReader.readBoolean()) {
                                                        bArr[i14][i15] = (byte) bits;
                                                        i15++;
                                                    } else if (bzip2BitReader.isReadable()) {
                                                        if (bzip2BitReader.readBoolean()) {
                                                            i16 = -1;
                                                        } else {
                                                            i16 = 1;
                                                        }
                                                        bits += i16;
                                                        if (bzip2BitReader.isReadable()) {
                                                            z10 = false;
                                                        } else {
                                                            z10 = false;
                                                        }
                                                    } else {
                                                        z10 = true;
                                                        z11 = true;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        i15 = 0;
                                    }
                                    z11 = true;
                                } else {
                                    i15 = 0;
                                }
                            }
                            if (z11) {
                                bzip2HuffmanStageDecoder.currentGroup = i14;
                                bzip2HuffmanStageDecoder.currentLength = bits;
                                bzip2HuffmanStageDecoder.currentAlpha = i15;
                                bzip2HuffmanStageDecoder.modifyLength = z10;
                                return;
                            }
                            bzip2HuffmanStageDecoder.createHuffmanDecodingTables();
                            this.currentState = State.DECODE_HUFFMAN_DATA;
                            bzip2BlockDecompressor = this.blockDecompressor;
                            i10 = byteBuf.readerIndex();
                            if (!bzip2BlockDecompressor.decodeHuffmanData(this.huffmanStageDecoder)) {
                                return;
                            }
                            if (byteBuf.readerIndex() == i10 && byteBuf.isReadable()) {
                                bzip2BitReader.refill();
                            }
                            byteBufBuffer = channelHandlerContext.alloc().buffer(bzip2BlockDecompressor.blockLength());
                            while (true) {
                                try {
                                    i11 = bzip2BlockDecompressor.read();
                                    if (i11 >= 0) {
                                        this.currentState = State.INIT_BLOCK;
                                        int iCheckCRC = bzip2BlockDecompressor.checkCRC();
                                        int i27 = this.streamCRC;
                                        this.streamCRC = iCheckCRC ^ ((i27 >>> 31) | (i27 << 1));
                                        list.add(byteBufBuffer);
                                        return;
                                    }
                                    byteBufBuffer.writeByte(i11);
                                } catch (Throwable th2) {
                                    if (byteBufBuffer != null) {
                                        byteBufBuffer.release();
                                    }
                                    throw th2;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (!bzip2BitReader.hasReadableBits(25)) {
                            return;
                        }
                        this.blockDecompressor = new Bzip2BlockDecompressor(this.blockSize, this.blockCRC, bzip2BitReader.readBoolean(), bzip2BitReader.readBits(24), bzip2BitReader);
                        this.currentState = State.RECEIVE_HUFFMAN_USED_MAP;
                        if (!bzip2BitReader.hasReadableBits(16)) {
                            return;
                        }
                        this.blockDecompressor.huffmanInUse16 = bzip2BitReader.readBits(16);
                        this.currentState = State.RECEIVE_HUFFMAN_USED_BITMAPS;
                        bzip2BlockDecompressor2 = this.blockDecompressor;
                        i19 = bzip2BlockDecompressor2.huffmanInUse16;
                        iBitCount = Integer.bitCount(i19);
                        bArr3 = bzip2BlockDecompressor2.huffmanSymbolMap;
                        if (!bzip2BitReader.hasReadableBits((iBitCount * 16) + 3)) {
                            return;
                        }
                        if (iBitCount > 0) {
                            i21 = 0;
                            i20 = 0;
                            while (i21 < i24) {
                                if (((32768 >>> i21) & i19) != 0) {
                                    i22 = i21 << 4;
                                    i23 = 0;
                                    while (i23 < i24) {
                                        if (bzip2BitReader.readBoolean()) {
                                            bArr3[i20] = (byte) i22;
                                            i20++;
                                        }
                                        i23++;
                                        i22++;
                                        i24 = 16;
                                    }
                                }
                                i21++;
                                i24 = 16;
                            }
                        } else {
                            i20 = 0;
                        }
                        bzip2BlockDecompressor2.huffmanEndOfBlockSymbol = i20 + 1;
                        bits3 = bzip2BitReader.readBits(3);
                        if (bits3 >= 2) {
                        }
                        throw new DecompressionException("incorrect huffman groups number");
                    case 4:
                        if (!bzip2BitReader.hasReadableBits(16)) {
                            return;
                        }
                        this.blockDecompressor.huffmanInUse16 = bzip2BitReader.readBits(16);
                        this.currentState = State.RECEIVE_HUFFMAN_USED_BITMAPS;
                        bzip2BlockDecompressor2 = this.blockDecompressor;
                        i19 = bzip2BlockDecompressor2.huffmanInUse16;
                        iBitCount = Integer.bitCount(i19);
                        bArr3 = bzip2BlockDecompressor2.huffmanSymbolMap;
                        if (!bzip2BitReader.hasReadableBits((iBitCount * 16) + 3)) {
                            return;
                        }
                        if (iBitCount > 0) {
                            i21 = 0;
                            i20 = 0;
                            while (i21 < i24) {
                                if (((32768 >>> i21) & i19) != 0) {
                                    i22 = i21 << 4;
                                    i23 = 0;
                                    while (i23 < i24) {
                                        if (bzip2BitReader.readBoolean()) {
                                            bArr3[i20] = (byte) i22;
                                            i20++;
                                        }
                                        i23++;
                                        i22++;
                                        i24 = 16;
                                    }
                                }
                                i21++;
                                i24 = 16;
                            }
                        } else {
                            i20 = 0;
                        }
                        bzip2BlockDecompressor2.huffmanEndOfBlockSymbol = i20 + 1;
                        bits3 = bzip2BitReader.readBits(3);
                        if (bits3 >= 2) {
                        }
                        throw new DecompressionException("incorrect huffman groups number");
                    case 5:
                        bzip2BlockDecompressor2 = this.blockDecompressor;
                        i19 = bzip2BlockDecompressor2.huffmanInUse16;
                        iBitCount = Integer.bitCount(i19);
                        bArr3 = bzip2BlockDecompressor2.huffmanSymbolMap;
                        if (!bzip2BitReader.hasReadableBits((iBitCount * 16) + 3)) {
                            return;
                        }
                        if (iBitCount > 0) {
                            i21 = 0;
                            i20 = 0;
                            while (i21 < i24) {
                                if (((32768 >>> i21) & i19) != 0) {
                                    i22 = i21 << 4;
                                    i23 = 0;
                                    while (i23 < i24) {
                                        if (bzip2BitReader.readBoolean()) {
                                            bArr3[i20] = (byte) i22;
                                            i20++;
                                        }
                                        i23++;
                                        i22++;
                                        i24 = 16;
                                    }
                                }
                                i21++;
                                i24 = 16;
                            }
                        } else {
                            i20 = 0;
                        }
                        bzip2BlockDecompressor2.huffmanEndOfBlockSymbol = i20 + 1;
                        bits3 = bzip2BitReader.readBits(3);
                        if (bits3 >= 2) {
                        }
                        throw new DecompressionException("incorrect huffman groups number");
                    case 6:
                        if (!bzip2BitReader.hasReadableBits(15)) {
                            return;
                        }
                        bits2 = bzip2BitReader.readBits(15);
                        if (bits2 >= 1) {
                            break;
                        }
                        throw new DecompressionException("incorrect selectors number");
                    case 7:
                        bzip2HuffmanStageDecoder2 = this.huffmanStageDecoder;
                        bArr2 = bzip2HuffmanStageDecoder2.selectors;
                        length = bArr2.length;
                        bzip2MoveToFrontTable = bzip2HuffmanStageDecoder2.tableMTF;
                        while (i17 < length) {
                            if (!bzip2BitReader.hasReadableBits(6)) {
                                bzip2HuffmanStageDecoder2.currentSelector = i17;
                                return;
                            }
                            i18 = 0;
                            while (bzip2BitReader.readBoolean()) {
                                i18++;
                            }
                            bArr2[i17] = bzip2MoveToFrontTable.indexToFront(i18);
                        }
                        this.currentState = State.RECEIVE_HUFFMAN_LENGTH;
                        bzip2HuffmanStageDecoder = this.huffmanStageDecoder;
                        i12 = bzip2HuffmanStageDecoder.totalTables;
                        bArr = bzip2HuffmanStageDecoder.tableCodeLengths;
                        i13 = bzip2HuffmanStageDecoder.alphabetSize;
                        bits = bzip2HuffmanStageDecoder.currentLength;
                        z10 = bzip2HuffmanStageDecoder.modifyLength;
                        i14 = bzip2HuffmanStageDecoder.currentGroup;
                        while (true) {
                            if (i14 < i12) {
                                if (bzip2BitReader.hasReadableBits(5)) {
                                    i15 = 0;
                                } else {
                                    if (bits < 0) {
                                        bits = bzip2BitReader.readBits(5);
                                    }
                                    i15 = bzip2HuffmanStageDecoder.currentAlpha;
                                    while (true) {
                                        if (i15 >= i13) {
                                            bzip2HuffmanStageDecoder.currentAlpha = 0;
                                            i14++;
                                            z10 = false;
                                            bits = -1;
                                        } else if (bzip2BitReader.isReadable()) {
                                            while (true) {
                                                if (z10) {
                                                }
                                                if (bzip2BitReader.isReadable()) {
                                                    z10 = true;
                                                    z11 = true;
                                                } else {
                                                    if (bzip2BitReader.readBoolean()) {
                                                        i16 = -1;
                                                    } else {
                                                        i16 = 1;
                                                    }
                                                    bits += i16;
                                                    if (bzip2BitReader.isReadable()) {
                                                        z10 = false;
                                                    } else {
                                                        z10 = false;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        bArr[i14][i15] = (byte) bits;
                                        i15++;
                                    }
                                }
                                z11 = true;
                            } else {
                                i15 = 0;
                            }
                        }
                        if (z11) {
                            bzip2HuffmanStageDecoder.currentGroup = i14;
                            bzip2HuffmanStageDecoder.currentLength = bits;
                            bzip2HuffmanStageDecoder.currentAlpha = i15;
                            bzip2HuffmanStageDecoder.modifyLength = z10;
                            return;
                        }
                        bzip2HuffmanStageDecoder.createHuffmanDecodingTables();
                        this.currentState = State.DECODE_HUFFMAN_DATA;
                        bzip2BlockDecompressor = this.blockDecompressor;
                        i10 = byteBuf.readerIndex();
                        if (!bzip2BlockDecompressor.decodeHuffmanData(this.huffmanStageDecoder)) {
                            return;
                        }
                        if (byteBuf.readerIndex() == i10) {
                            bzip2BitReader.refill();
                        }
                        byteBufBuffer = channelHandlerContext.alloc().buffer(bzip2BlockDecompressor.blockLength());
                        while (true) {
                            i11 = bzip2BlockDecompressor.read();
                            if (i11 >= 0) {
                                this.currentState = State.INIT_BLOCK;
                                int iCheckCRC2 = bzip2BlockDecompressor.checkCRC();
                                int i28 = this.streamCRC;
                                this.streamCRC = iCheckCRC2 ^ ((i28 >>> 31) | (i28 << 1));
                                list.add(byteBufBuffer);
                                return;
                            }
                            byteBufBuffer.writeByte(i11);
                        }
                        break;
                    case 8:
                        bzip2HuffmanStageDecoder = this.huffmanStageDecoder;
                        i12 = bzip2HuffmanStageDecoder.totalTables;
                        bArr = bzip2HuffmanStageDecoder.tableCodeLengths;
                        i13 = bzip2HuffmanStageDecoder.alphabetSize;
                        bits = bzip2HuffmanStageDecoder.currentLength;
                        z10 = bzip2HuffmanStageDecoder.modifyLength;
                        i14 = bzip2HuffmanStageDecoder.currentGroup;
                        while (true) {
                            if (i14 < i12) {
                                if (bzip2BitReader.hasReadableBits(5)) {
                                    i15 = 0;
                                } else {
                                    if (bits < 0) {
                                        bits = bzip2BitReader.readBits(5);
                                    }
                                    i15 = bzip2HuffmanStageDecoder.currentAlpha;
                                    while (true) {
                                        if (i15 >= i13) {
                                            bzip2HuffmanStageDecoder.currentAlpha = 0;
                                            i14++;
                                            z10 = false;
                                            bits = -1;
                                        } else if (bzip2BitReader.isReadable()) {
                                            while (true) {
                                                if (z10) {
                                                }
                                                if (bzip2BitReader.isReadable()) {
                                                    z10 = true;
                                                    z11 = true;
                                                } else {
                                                    if (bzip2BitReader.readBoolean()) {
                                                        i16 = -1;
                                                    } else {
                                                        i16 = 1;
                                                    }
                                                    bits += i16;
                                                    if (bzip2BitReader.isReadable()) {
                                                        z10 = false;
                                                    } else {
                                                        z10 = false;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        bArr[i14][i15] = (byte) bits;
                                        i15++;
                                    }
                                }
                                z11 = true;
                            } else {
                                i15 = 0;
                            }
                        }
                        if (z11) {
                            bzip2HuffmanStageDecoder.currentGroup = i14;
                            bzip2HuffmanStageDecoder.currentLength = bits;
                            bzip2HuffmanStageDecoder.currentAlpha = i15;
                            bzip2HuffmanStageDecoder.modifyLength = z10;
                            return;
                        }
                        bzip2HuffmanStageDecoder.createHuffmanDecodingTables();
                        this.currentState = State.DECODE_HUFFMAN_DATA;
                        bzip2BlockDecompressor = this.blockDecompressor;
                        i10 = byteBuf.readerIndex();
                        if (!bzip2BlockDecompressor.decodeHuffmanData(this.huffmanStageDecoder)) {
                            return;
                        }
                        if (byteBuf.readerIndex() == i10) {
                            bzip2BitReader.refill();
                        }
                        byteBufBuffer = channelHandlerContext.alloc().buffer(bzip2BlockDecompressor.blockLength());
                        while (true) {
                            i11 = bzip2BlockDecompressor.read();
                            if (i11 >= 0) {
                                this.currentState = State.INIT_BLOCK;
                                int iCheckCRC3 = bzip2BlockDecompressor.checkCRC();
                                int i29 = this.streamCRC;
                                this.streamCRC = iCheckCRC3 ^ ((i29 >>> 31) | (i29 << 1));
                                list.add(byteBufBuffer);
                                return;
                            }
                            byteBufBuffer.writeByte(i11);
                        }
                        break;
                    case 9:
                        bzip2BlockDecompressor = this.blockDecompressor;
                        i10 = byteBuf.readerIndex();
                        if (!bzip2BlockDecompressor.decodeHuffmanData(this.huffmanStageDecoder)) {
                            return;
                        }
                        if (byteBuf.readerIndex() == i10) {
                            bzip2BitReader.refill();
                        }
                        byteBufBuffer = channelHandlerContext.alloc().buffer(bzip2BlockDecompressor.blockLength());
                        while (true) {
                            i11 = bzip2BlockDecompressor.read();
                            if (i11 >= 0) {
                                this.currentState = State.INIT_BLOCK;
                                int iCheckCRC4 = bzip2BlockDecompressor.checkCRC();
                                int i210 = this.streamCRC;
                                this.streamCRC = iCheckCRC4 ^ ((i210 >>> 31) | (i210 << 1));
                                list.add(byteBufBuffer);
                                return;
                            }
                            byteBufBuffer.writeByte(i11);
                        }
                        break;
                    case 10:
                        byteBuf.skipBytes(byteBuf.readableBytes());
                        return;
                    default:
                        throw new IllegalStateException();
                }
            }
        }
    }

    public boolean isClosed() {
        return this.currentState == State.EOF;
    }
}
