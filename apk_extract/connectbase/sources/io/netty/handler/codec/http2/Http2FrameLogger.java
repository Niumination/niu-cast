package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.logging.LogLevel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class Http2FrameLogger extends ChannelHandlerAdapter {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final InternalLogLevel level;
    private final InternalLogger logger;

    public enum Direction {
        INBOUND,
        OUTBOUND
    }

    public Http2FrameLogger(LogLevel logLevel) {
        this(checkAndConvertLevel(logLevel), InternalLoggerFactory.getInstance((Class<?>) Http2FrameLogger.class));
    }

    private static InternalLogLevel checkAndConvertLevel(LogLevel logLevel) {
        return ((LogLevel) ObjectUtil.checkNotNull(logLevel, "level")).toInternalLevel();
    }

    private String toString(ByteBuf byteBuf) {
        if (this.level == InternalLogLevel.TRACE || byteBuf.readableBytes() <= 64) {
            return ByteBufUtil.hexDump(byteBuf);
        }
        return ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), 64)) + "...";
    }

    public boolean isEnabled() {
        return this.logger.isEnabled(this.level);
    }

    public void logData(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} DATA: streamId={} padding={} endStream={} length={} bytes={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), Integer.valueOf(i11), Boolean.valueOf(z10), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logGoAway(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} GO_AWAY: lastStreamId={} errorCode={} length={} bytes={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), Long.valueOf(j10), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logHeaders(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} HEADERS: streamId={} headers={} padding={} endStream={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), http2Headers, Integer.valueOf(i11), Boolean.valueOf(z10));
        }
    }

    public void logPing(Direction direction, ChannelHandlerContext channelHandlerContext, long j10) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PING: ack=false bytes={}", channelHandlerContext.channel(), direction.name(), Long.valueOf(j10));
        }
    }

    public void logPingAck(Direction direction, ChannelHandlerContext channelHandlerContext, long j10) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PING: ack=true bytes={}", channelHandlerContext.channel(), direction.name(), Long.valueOf(j10));
        }
    }

    public void logPriority(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PRIORITY: streamId={} streamDependency={} weight={} exclusive={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), Integer.valueOf(i11), Short.valueOf(s10), Boolean.valueOf(z10));
        }
    }

    public void logPushPromise(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} PUSH_PROMISE: streamId={} promisedStreamId={} headers={} padding={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), Integer.valueOf(i11), http2Headers, Integer.valueOf(i12));
        }
    }

    public void logRstStream(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, long j10) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} RST_STREAM: streamId={} errorCode={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), Long.valueOf(j10));
        }
    }

    public void logSettings(Direction direction, ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} SETTINGS: ack=false settings={}", channelHandlerContext.channel(), direction.name(), http2Settings);
        }
    }

    public void logSettingsAck(Direction direction, ChannelHandlerContext channelHandlerContext) {
        this.logger.log(this.level, "{} {} SETTINGS: ack=true", channelHandlerContext.channel(), direction.name());
    }

    public void logUnknownFrame(Direction direction, ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} UNKNOWN: frameType={} streamId={} flags={} length={} bytes={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(b10 & 255), Integer.valueOf(i10), Short.valueOf(http2Flags.value()), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logWindowsUpdate(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, int i11) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} WINDOW_UPDATE: streamId={} windowSizeIncrement={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    public Http2FrameLogger(LogLevel logLevel, String str) {
        this(checkAndConvertLevel(logLevel), InternalLoggerFactory.getInstance((String) ObjectUtil.checkNotNull(str, "name")));
    }

    public Http2FrameLogger(LogLevel logLevel, Class<?> cls) {
        this(checkAndConvertLevel(logLevel), InternalLoggerFactory.getInstance((Class<?>) ObjectUtil.checkNotNull(cls, "clazz")));
    }

    private Http2FrameLogger(InternalLogLevel internalLogLevel, InternalLogger internalLogger) {
        this.level = internalLogLevel;
        this.logger = internalLogger;
    }

    public void logHeaders(Direction direction, ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) {
        if (isEnabled()) {
            this.logger.log(this.level, "{} {} HEADERS: streamId={} headers={} streamDependency={} weight={} exclusive={} padding={} endStream={}", channelHandlerContext.channel(), direction.name(), Integer.valueOf(i10), http2Headers, Integer.valueOf(i11), Short.valueOf(s10), Boolean.valueOf(z10), Integer.valueOf(i12), Boolean.valueOf(z11));
        }
    }
}
