package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SpdyFrameDecoder {
    private final SpdyFrameDecoderDelegate delegate;
    private byte flags;
    private int length;
    private final int maxChunkSize;
    private int numSettings;
    private final int spdyVersion;
    private State state;
    private int streamId;

    /* JADX INFO: renamed from: io.netty.handler.codec.spdy.SpdyFrameDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State = iArr;
            try {
                iArr[State.READ_COMMON_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_DATA_FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_STREAM_FRAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_REPLY_FRAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_RST_STREAM_FRAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTINGS_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_PING_FRAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_GOAWAY_FRAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADERS_FRAME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_WINDOW_UPDATE_FRAME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADER_BLOCK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.DISCARD_FRAME.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.FRAME_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public enum State {
        READ_COMMON_HEADER,
        READ_DATA_FRAME,
        READ_SYN_STREAM_FRAME,
        READ_SYN_REPLY_FRAME,
        READ_RST_STREAM_FRAME,
        READ_SETTINGS_FRAME,
        READ_SETTING,
        READ_PING_FRAME,
        READ_GOAWAY_FRAME,
        READ_HEADERS_FRAME,
        READ_WINDOW_UPDATE_FRAME,
        READ_HEADER_BLOCK,
        DISCARD_FRAME,
        FRAME_ERROR
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate) {
        this(spdyVersion, spdyFrameDecoderDelegate, 8192);
    }

    private static State getNextState(int i10, int i11) {
        switch (i10) {
            case 0:
                return State.READ_DATA_FRAME;
            case 1:
                return State.READ_SYN_STREAM_FRAME;
            case 2:
                return State.READ_SYN_REPLY_FRAME;
            case 3:
                return State.READ_RST_STREAM_FRAME;
            case 4:
                return State.READ_SETTINGS_FRAME;
            case 5:
            default:
                return i11 != 0 ? State.DISCARD_FRAME : State.READ_COMMON_HEADER;
            case 6:
                return State.READ_PING_FRAME;
            case 7:
                return State.READ_GOAWAY_FRAME;
            case 8:
                return State.READ_HEADERS_FRAME;
            case 9:
                return State.READ_WINDOW_UPDATE_FRAME;
        }
    }

    private static boolean hasFlag(byte b10, byte b11) {
        return (b10 & b11) != 0;
    }

    private static boolean isValidFrameHeader(int i10, int i11, byte b10, int i12) {
        switch (i11) {
            case 0:
                return i10 != 0;
            case 1:
                return i12 >= 10;
            case 2:
                return i12 >= 4;
            case 3:
                return b10 == 0 && i12 == 8;
            case 4:
                return i12 >= 4;
            case 5:
            default:
                return true;
            case 6:
                return i12 == 4;
            case 7:
                return i12 == 8;
            case 8:
                return i12 >= 4;
            case 9:
                return i12 == 8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void decode(ByteBuf byteBuf) {
        int unsignedShort;
        while (true) {
            int i10 = 0;
            z = false;
            boolean z10 = false;
            switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[this.state.ordinal()]) {
                case 1:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    int i11 = byteBuf.readerIndex();
                    int i12 = i11 + 4;
                    int i13 = i11 + 5;
                    byteBuf.skipBytes(8);
                    if ((byteBuf.getByte(i11) & 128) != 0) {
                        unsignedShort = SpdyCodecUtil.getUnsignedShort(byteBuf, i11) & 32767;
                        int unsignedShort2 = SpdyCodecUtil.getUnsignedShort(byteBuf, i11 + 2);
                        this.streamId = 0;
                        i10 = unsignedShort2;
                    } else {
                        unsignedShort = this.spdyVersion;
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, i11);
                    }
                    this.flags = byteBuf.getByte(i12);
                    int unsignedMedium = SpdyCodecUtil.getUnsignedMedium(byteBuf, i13);
                    this.length = unsignedMedium;
                    if (unsignedShort != this.spdyVersion) {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SPDY Version");
                    } else if (!isValidFrameHeader(this.streamId, i10, this.flags, unsignedMedium)) {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid Frame Error");
                    } else {
                        this.state = getNextState(i10, this.length);
                    }
                    break;
                case 2:
                    int i14 = this.length;
                    if (i14 != 0) {
                        int iMin = Math.min(this.maxChunkSize, i14);
                        if (byteBuf.readableBytes() < iMin) {
                            return;
                        }
                        ByteBuf byteBufBuffer = byteBuf.alloc().buffer(iMin);
                        byteBufBuffer.writeBytes(byteBuf, iMin);
                        int i15 = this.length - iMin;
                        this.length = i15;
                        if (i15 == 0) {
                            this.state = State.READ_COMMON_HEADER;
                        }
                        if (i15 == 0 && hasFlag(this.flags, (byte) 1)) {
                            z10 = true;
                        }
                        this.delegate.readDataFrame(this.streamId, z10, byteBufBuffer);
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readDataFrame(this.streamId, hasFlag(this.flags, (byte) 1), Unpooled.buffer(0));
                    }
                    break;
                case 3:
                    if (byteBuf.readableBytes() < 10) {
                        return;
                    }
                    int i16 = byteBuf.readerIndex();
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, i16);
                    int unsignedInt = SpdyCodecUtil.getUnsignedInt(byteBuf, i16 + 4);
                    byte b10 = (byte) ((byteBuf.getByte(i16 + 8) >> 5) & 7);
                    boolean zHasFlag = hasFlag(this.flags, (byte) 1);
                    boolean zHasFlag2 = hasFlag(this.flags, (byte) 2);
                    byteBuf.skipBytes(10);
                    this.length -= 10;
                    int i17 = this.streamId;
                    if (i17 != 0) {
                        this.state = State.READ_HEADER_BLOCK;
                        this.delegate.readSynStreamFrame(i17, unsignedInt, b10, zHasFlag, zHasFlag2);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SYN_STREAM Frame");
                    }
                    break;
                case 4:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    boolean zHasFlag3 = hasFlag(this.flags, (byte) 1);
                    byteBuf.skipBytes(4);
                    this.length -= 4;
                    int i18 = this.streamId;
                    if (i18 != 0) {
                        this.state = State.READ_HEADER_BLOCK;
                        this.delegate.readSynReplyFrame(i18, zHasFlag3);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SYN_REPLY Frame");
                    }
                    break;
                case 5:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                    byteBuf.skipBytes(8);
                    int i19 = this.streamId;
                    if (i19 == 0 || signedInt == 0) {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid RST_STREAM Frame");
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readRstStreamFrame(i19, signedInt);
                    }
                    break;
                case 6:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    boolean zHasFlag4 = hasFlag(this.flags, (byte) 1);
                    this.numSettings = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    byteBuf.skipBytes(4);
                    int i20 = this.length - 4;
                    this.length = i20;
                    if ((i20 & 7) == 0 && (i20 >> 3) == this.numSettings) {
                        this.state = State.READ_SETTING;
                        this.delegate.readSettingsFrame(zHasFlag4);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SETTINGS Frame");
                    }
                    break;
                case 7:
                    if (this.numSettings == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readSettingsEnd();
                    } else {
                        if (byteBuf.readableBytes() < 8) {
                            return;
                        }
                        byte b11 = byteBuf.getByte(byteBuf.readerIndex());
                        int unsignedMedium2 = SpdyCodecUtil.getUnsignedMedium(byteBuf, byteBuf.readerIndex() + 1);
                        int signedInt2 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        boolean zHasFlag5 = hasFlag(b11, (byte) 1);
                        boolean zHasFlag6 = hasFlag(b11, (byte) 2);
                        byteBuf.skipBytes(8);
                        this.numSettings--;
                        this.delegate.readSetting(unsignedMedium2, signedInt2, zHasFlag5, zHasFlag6);
                    }
                    break;
                case 8:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int signedInt3 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
                    byteBuf.skipBytes(4);
                    this.state = State.READ_COMMON_HEADER;
                    this.delegate.readPingFrame(signedInt3);
                    break;
                case 9:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    int unsignedInt2 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    int signedInt4 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                    byteBuf.skipBytes(8);
                    this.state = State.READ_COMMON_HEADER;
                    this.delegate.readGoAwayFrame(unsignedInt2, signedInt4);
                    break;
                case 10:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    boolean zHasFlag7 = hasFlag(this.flags, (byte) 1);
                    byteBuf.skipBytes(4);
                    this.length -= 4;
                    int i21 = this.streamId;
                    if (i21 != 0) {
                        this.state = State.READ_HEADER_BLOCK;
                        this.delegate.readHeadersFrame(i21, zHasFlag7);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid HEADERS Frame");
                    }
                    break;
                case 11:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    int unsignedInt3 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex() + 4);
                    byteBuf.skipBytes(8);
                    if (unsignedInt3 != 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readWindowUpdateFrame(this.streamId, unsignedInt3);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid WINDOW_UPDATE Frame");
                    }
                    break;
                case 12:
                    if (this.length == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readHeaderBlockEnd();
                    } else {
                        if (!byteBuf.isReadable()) {
                            return;
                        }
                        int iMin2 = Math.min(byteBuf.readableBytes(), this.length);
                        ByteBuf byteBufBuffer2 = byteBuf.alloc().buffer(iMin2);
                        byteBufBuffer2.writeBytes(byteBuf, iMin2);
                        this.length -= iMin2;
                        this.delegate.readHeaderBlock(byteBufBuffer2);
                    }
                    break;
                case 13:
                    int iMin3 = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(iMin3);
                    int i22 = this.length - iMin3;
                    this.length = i22;
                    if (i22 != 0) {
                        return;
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                    }
                    break;
                case 14:
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        }
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate, int i10) {
        this.spdyVersion = ((SpdyVersion) ObjectUtil.checkNotNull(spdyVersion, "spdyVersion")).getVersion();
        this.delegate = (SpdyFrameDecoderDelegate) ObjectUtil.checkNotNull(spdyFrameDecoderDelegate, "delegate");
        this.maxChunkSize = ObjectUtil.checkPositive(i10, "maxChunkSize");
        this.state = State.READ_COMMON_HEADER;
    }
}
