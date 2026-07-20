package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SpdyFrameEncoder {
    private final int version;

    public SpdyFrameEncoder(SpdyVersion spdyVersion) {
        this.version = ((SpdyVersion) ObjectUtil.checkNotNull(spdyVersion, "spdyVersion")).getVersion();
    }

    private void writeControlFrameHeader(ByteBuf byteBuf, int i10, byte b10, int i11) {
        byteBuf.writeShort(this.version | 32768);
        byteBuf.writeShort(i10);
        byteBuf.writeByte(b10);
        byteBuf.writeMedium(i11);
    }

    public ByteBuf encodeDataFrame(ByteBufAllocator byteBufAllocator, int i10, boolean z10, ByteBuf byteBuf) {
        int i11 = byteBuf.readableBytes();
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(i11 + 8).order(ByteOrder.BIG_ENDIAN);
        byteBufOrder.writeInt(i10 & Integer.MAX_VALUE);
        byteBufOrder.writeByte(z10 ? 1 : 0);
        byteBufOrder.writeMedium(i11);
        byteBufOrder.writeBytes(byteBuf, byteBuf.readerIndex(), i11);
        return byteBufOrder;
    }

    public ByteBuf encodeGoAwayFrame(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 7, (byte) 0, 8);
        byteBufOrder.writeInt(i10);
        byteBufOrder.writeInt(i11);
        return byteBufOrder;
    }

    public ByteBuf encodeHeadersFrame(ByteBufAllocator byteBufAllocator, int i10, boolean z10, ByteBuf byteBuf) {
        int i11 = byteBuf.readableBytes();
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(i11 + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 8, z10 ? (byte) 1 : (byte) 0, i11 + 4);
        byteBufOrder.writeInt(i10);
        byteBufOrder.writeBytes(byteBuf, byteBuf.readerIndex(), i11);
        return byteBufOrder;
    }

    public ByteBuf encodePingFrame(ByteBufAllocator byteBufAllocator, int i10) {
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 6, (byte) 0, 4);
        byteBufOrder.writeInt(i10);
        return byteBufOrder;
    }

    public ByteBuf encodeRstStreamFrame(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 3, (byte) 0, 8);
        byteBufOrder.writeInt(i10);
        byteBufOrder.writeInt(i11);
        return byteBufOrder;
    }

    public ByteBuf encodeSettingsFrame(ByteBufAllocator byteBufAllocator, SpdySettingsFrame spdySettingsFrame) {
        Set<Integer> setIds = spdySettingsFrame.ids();
        int size = setIds.size();
        boolean zClearPreviouslyPersistedSettings = spdySettingsFrame.clearPreviouslyPersistedSettings();
        int i10 = size * 8;
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(i10 + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 4, zClearPreviouslyPersistedSettings ? (byte) 1 : (byte) 0, i10 + 4);
        byteBufOrder.writeInt(size);
        for (Integer num : setIds) {
            byte b10 = spdySettingsFrame.isPersistValue(num.intValue()) ? (byte) 1 : (byte) 0;
            if (spdySettingsFrame.isPersisted(num.intValue())) {
                b10 = (byte) (b10 | 2);
            }
            byteBufOrder.writeByte(b10);
            byteBufOrder.writeMedium(num.intValue());
            byteBufOrder.writeInt(spdySettingsFrame.getValue(num.intValue()));
        }
        return byteBufOrder;
    }

    public ByteBuf encodeSynReplyFrame(ByteBufAllocator byteBufAllocator, int i10, boolean z10, ByteBuf byteBuf) {
        int i11 = byteBuf.readableBytes();
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(i11 + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 2, z10 ? (byte) 1 : (byte) 0, i11 + 4);
        byteBufOrder.writeInt(i10);
        byteBufOrder.writeBytes(byteBuf, byteBuf.readerIndex(), i11);
        return byteBufOrder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ByteBuf encodeSynStreamFrame(ByteBufAllocator byteBufAllocator, int i10, int i11, byte b10, boolean z10, boolean z11, ByteBuf byteBuf) {
        int i12 = byteBuf.readableBytes();
        byte b11 = z10;
        if (z11) {
            b11 = (byte) (z10 | 2);
        }
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(i12 + 18).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 1, b11, i12 + 10);
        byteBufOrder.writeInt(i10);
        byteBufOrder.writeInt(i11);
        byteBufOrder.writeShort((b10 & 255) << 13);
        byteBufOrder.writeBytes(byteBuf, byteBuf.readerIndex(), i12);
        return byteBufOrder;
    }

    public ByteBuf encodeWindowUpdateFrame(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        ByteBuf byteBufOrder = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(byteBufOrder, 9, (byte) 0, 8);
        byteBufOrder.writeInt(i10);
        byteBufOrder.writeInt(i11);
        return byteBufOrder;
    }
}
