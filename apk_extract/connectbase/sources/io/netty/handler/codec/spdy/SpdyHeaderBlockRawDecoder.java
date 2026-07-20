package io.netty.handler.codec.spdy;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SpdyHeaderBlockRawDecoder extends SpdyHeaderBlockDecoder {
    private static final int LENGTH_FIELD_SIZE = 4;
    private ByteBuf cumulation;
    private int headerSize;
    private int length;
    private final int maxHeaderSize;
    private String name;
    private int numHeaders;
    private State state;

    /* JADX INFO: renamed from: io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State = iArr;
            try {
                iArr[State.READ_NUM_HEADERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_NAME_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.SKIP_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_VALUE_LENGTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.SKIP_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.END_HEADER_BLOCK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum State {
        READ_NUM_HEADERS,
        READ_NAME_LENGTH,
        READ_NAME,
        SKIP_NAME,
        READ_VALUE_LENGTH,
        READ_VALUE,
        SKIP_VALUE,
        END_HEADER_BLOCK,
        ERROR
    }

    public SpdyHeaderBlockRawDecoder(SpdyVersion spdyVersion, int i10) {
        ObjectUtil.checkNotNull(spdyVersion, "spdyVersion");
        this.maxHeaderSize = i10;
        this.state = State.READ_NUM_HEADERS;
    }

    private static int readLengthField(ByteBuf byteBuf) {
        int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
        byteBuf.skipBytes(4);
        return signedInt;
    }

    private void releaseBuffer() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            byteBuf.release();
            this.cumulation = null;
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        ObjectUtil.checkNotNull(byteBuf, "headerBlock");
        ObjectUtil.checkNotNull(spdyHeadersFrame, TypedValues.AttributesType.S_FRAME);
        ByteBuf byteBuf2 = this.cumulation;
        if (byteBuf2 == null) {
            decodeHeaderBlock(byteBuf, spdyHeadersFrame);
            if (byteBuf.isReadable()) {
                ByteBuf byteBufBuffer = byteBufAllocator.buffer(byteBuf.readableBytes());
                this.cumulation = byteBufBuffer;
                byteBufBuffer.writeBytes(byteBuf);
                return;
            }
            return;
        }
        byteBuf2.writeBytes(byteBuf);
        decodeHeaderBlock(this.cumulation, spdyHeadersFrame);
        if (this.cumulation.isReadable()) {
            this.cumulation.discardReadBytes();
        } else {
            releaseBuffer();
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0000 A[SYNTHETIC] */
    public void decodeHeaderBlock(ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        int i10;
        int i11;
        int i12;
        int i13;
        while (byteBuf.isReadable()) {
            switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[this.state.ordinal()]) {
                case 1:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int lengthField = readLengthField(byteBuf);
                    this.numHeaders = lengthField;
                    if (lengthField < 0) {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    } else if (lengthField != 0) {
                        this.state = State.READ_NAME_LENGTH;
                    } else {
                        this.state = State.END_HEADER_BLOCK;
                    }
                    break;
                case 2:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int lengthField2 = readLengthField(byteBuf);
                    this.length = lengthField2;
                    if (lengthField2 > 0) {
                        int i14 = this.maxHeaderSize;
                        if (lengthField2 <= i14 && (i10 = this.headerSize) <= i14 - lengthField2) {
                            this.headerSize = i10 + lengthField2;
                            this.state = State.READ_NAME;
                        } else {
                            this.headerSize = i14 + 1;
                            this.state = State.SKIP_NAME;
                            spdyHeadersFrame.setTruncated();
                        }
                    } else {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    }
                    break;
                case 3:
                    int i15 = byteBuf.readableBytes();
                    int i16 = this.length;
                    if (i15 < i16) {
                        return;
                    }
                    byte[] bArr = new byte[i16];
                    byteBuf.readBytes(bArr);
                    this.name = new String(bArr, "UTF-8");
                    if (!spdyHeadersFrame.headers().contains(this.name)) {
                        this.state = State.READ_VALUE_LENGTH;
                    } else {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    }
                    break;
                case 4:
                    int iMin = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(iMin);
                    int i17 = this.length - iMin;
                    this.length = i17;
                    if (i17 == 0) {
                        this.state = State.READ_VALUE_LENGTH;
                    }
                    break;
                case 5:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int lengthField3 = readLengthField(byteBuf);
                    this.length = lengthField3;
                    if (lengthField3 < 0) {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    } else if (lengthField3 != 0) {
                        int i18 = this.maxHeaderSize;
                        if (lengthField3 <= i18 && (i11 = this.headerSize) <= i18 - lengthField3) {
                            this.headerSize = i11 + lengthField3;
                            this.state = State.READ_VALUE;
                        } else {
                            this.headerSize = i18 + 1;
                            this.name = null;
                            this.state = State.SKIP_VALUE;
                            spdyHeadersFrame.setTruncated();
                        }
                    } else {
                        if (!spdyHeadersFrame.isTruncated()) {
                            spdyHeadersFrame.headers().add(this.name, "");
                        }
                        this.name = null;
                        int i19 = this.numHeaders - 1;
                        this.numHeaders = i19;
                        if (i19 != 0) {
                            this.state = State.READ_NAME_LENGTH;
                        } else {
                            this.state = State.END_HEADER_BLOCK;
                        }
                    }
                    break;
                case 6:
                    int i20 = byteBuf.readableBytes();
                    int i21 = this.length;
                    if (i20 < i21) {
                        return;
                    }
                    byte[] bArr2 = new byte[i21];
                    byteBuf.readBytes(bArr2);
                    int i22 = 0;
                    if (bArr2[0] != 0) {
                        int i23 = 0;
                        while (i22 < this.length) {
                            while (i22 < i21 && bArr2[i22] != 0) {
                                i22++;
                            }
                            if (i22 >= i21 || !((i13 = i22 + 1) == i21 || bArr2[i13] == 0)) {
                                try {
                                    spdyHeadersFrame.headers().add(this.name, new String(bArr2, i23, i22 - i23, "UTF-8"));
                                    i23 = i22 + 1;
                                    i22 = i23;
                                } catch (IllegalArgumentException unused) {
                                    this.state = State.ERROR;
                                    spdyHeadersFrame.setInvalid();
                                }
                            } else {
                                this.state = State.ERROR;
                                spdyHeadersFrame.setInvalid();
                            }
                            this.name = null;
                            if (this.state == State.ERROR) {
                                i12 = this.numHeaders - 1;
                                this.numHeaders = i12;
                                if (i12 == 0) {
                                    this.state = State.READ_NAME_LENGTH;
                                } else {
                                    this.state = State.END_HEADER_BLOCK;
                                }
                            }
                            break;
                        }
                        this.name = null;
                        if (this.state == State.ERROR) {
                            i12 = this.numHeaders - 1;
                            this.numHeaders = i12;
                            if (i12 == 0) {
                                this.state = State.READ_NAME_LENGTH;
                            } else {
                                this.state = State.END_HEADER_BLOCK;
                            }
                        }
                    } else {
                        this.state = State.ERROR;
                        spdyHeadersFrame.setInvalid();
                    }
                    break;
                case 7:
                    int iMin2 = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(iMin2);
                    int i24 = this.length - iMin2;
                    this.length = i24;
                    if (i24 == 0) {
                        int i25 = this.numHeaders - 1;
                        this.numHeaders = i25;
                        if (i25 != 0) {
                            this.state = State.READ_NAME_LENGTH;
                        } else {
                            this.state = State.END_HEADER_BLOCK;
                        }
                    }
                    break;
                case 8:
                    this.state = State.ERROR;
                    spdyHeadersFrame.setInvalid();
                    break;
                case 9:
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void end() {
        releaseBuffer();
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        if (this.state != State.END_HEADER_BLOCK) {
            spdyHeadersFrame.setInvalid();
        }
        releaseBuffer();
        this.headerSize = 0;
        this.name = null;
        this.state = State.READ_NUM_HEADERS;
    }
}
