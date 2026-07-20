package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class OioByteStreamChannel extends AbstractOioByteChannel {
    private static final InputStream CLOSED_IN = new InputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.1
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    };
    private static final OutputStream CLOSED_OUT = new OutputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.2
        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            throw new ClosedChannelException();
        }
    };

    /* JADX INFO: renamed from: is, reason: collision with root package name */
    private InputStream f8300is;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    private OutputStream f8301os;
    private WritableByteChannel outChannel;

    public OioByteStreamChannel(Channel channel) {
        super(channel);
    }

    private static void checkEOF(FileRegion fileRegion) throws IOException {
        if (fileRegion.transferred() >= fileRegion.count()) {
            return;
        }
        throw new EOFException("Expected to be able to write " + fileRegion.count() + " bytes, but only wrote " + fileRegion.transferred());
    }

    public final void activate(InputStream inputStream, OutputStream outputStream) {
        if (this.f8300is != null) {
            throw new IllegalStateException("input was set already");
        }
        if (this.f8301os != null) {
            throw new IllegalStateException("output was set already");
        }
        this.f8300is = (InputStream) ObjectUtil.checkNotNull(inputStream, "is");
        this.f8301os = (OutputStream) ObjectUtil.checkNotNull(outputStream, "os");
        if (this.readWhenInactive) {
            eventLoop().execute(this.readTask);
            this.readWhenInactive = false;
        }
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public int available() {
        try {
            return this.f8300is.available();
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        InputStream inputStream = this.f8300is;
        OutputStream outputStream = this.f8301os;
        this.f8300is = CLOSED_IN;
        this.f8301os = CLOSED_OUT;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public int doReadBytes(ByteBuf byteBuf) throws Exception {
        RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
        handleRecvBufAllocHandle.attemptedBytesRead(Math.max(1, Math.min(available(), byteBuf.maxWritableBytes())));
        return byteBuf.writeBytes(this.f8300is, handleRecvBufAllocHandle.attemptedBytesRead());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public void doWriteBytes(ByteBuf byteBuf) throws Exception {
        OutputStream outputStream = this.f8301os;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        byteBuf.readBytes(outputStream, byteBuf.readableBytes());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public void doWriteFileRegion(FileRegion fileRegion) throws Exception {
        OutputStream outputStream = this.f8301os;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        if (this.outChannel == null) {
            this.outChannel = Channels.newChannel(outputStream);
        }
        long j10 = 0;
        do {
            long jTransferTo = fileRegion.transferTo(this.outChannel, j10);
            if (jTransferTo == -1) {
                checkEOF(fileRegion);
                return;
            }
            j10 += jTransferTo;
        } while (j10 < fileRegion.count());
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        OutputStream outputStream;
        InputStream inputStream = this.f8300is;
        return (inputStream == null || inputStream == CLOSED_IN || (outputStream = this.f8301os) == null || outputStream == CLOSED_OUT) ? false : true;
    }
}
