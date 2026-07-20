package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.ObjectUtil;
import j.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMemoryHttpData extends AbstractHttpData {
    private ByteBuf byteBuf;
    private int chunkPosition;

    public AbstractMemoryHttpData(String str, Charset charset, long j10) {
        super(str, charset, j10);
        this.byteBuf = Unpooled.EMPTY_BUFFER;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z10) throws IOException {
        if (byteBuf != null) {
            long j10 = byteBuf.readableBytes();
            try {
                checkSize(this.size + j10);
                long j11 = this.definedSize;
                if (j11 > 0 && j11 < this.size + j10) {
                    byteBuf.release();
                    throw new IOException("Out of size: " + (this.size + j10) + " > " + this.definedSize);
                }
                this.size += j10;
                ByteBuf byteBuf2 = this.byteBuf;
                if (byteBuf2 == null) {
                    this.byteBuf = byteBuf;
                } else if (j10 == 0) {
                    byteBuf.release();
                } else if (byteBuf2.readableBytes() == 0) {
                    this.byteBuf.release();
                    this.byteBuf = byteBuf;
                } else {
                    ByteBuf byteBuf3 = this.byteBuf;
                    if (byteBuf3 instanceof CompositeByteBuf) {
                        ((CompositeByteBuf) byteBuf3).addComponent(true, byteBuf);
                    } else {
                        CompositeByteBuf compositeByteBufCompositeBuffer = Unpooled.compositeBuffer(Integer.MAX_VALUE);
                        compositeByteBufCompositeBuffer.addComponents(true, this.byteBuf, byteBuf);
                        this.byteBuf = compositeByteBufCompositeBuffer;
                    }
                }
            } catch (IOException e10) {
                byteBuf.release();
                throw e10;
            }
        }
        if (z10) {
            setCompleted();
        } else {
            ObjectUtil.checkNotNull(byteBuf, "buffer");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.release();
            this.byteBuf = null;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return Unpooled.EMPTY_BUFFER.array();
        }
        byte[] bArr = new byte[byteBuf.readableBytes()];
        ByteBuf byteBuf2 = this.byteBuf;
        byteBuf2.getBytes(byteBuf2.readerIndex(), bArr);
        return bArr;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i10) throws IOException {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null || i10 == 0 || byteBuf.readableBytes() == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        int i11 = this.byteBuf.readableBytes();
        int i12 = this.chunkPosition;
        int i13 = i11 - i12;
        if (i13 == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        if (i13 < i10) {
            i10 = i13;
        }
        ByteBuf byteBufRetainedSlice = this.byteBuf.retainedSlice(i12, i10);
        this.chunkPosition += i10;
        return byteBufRetainedSlice;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        throw new IOException("Not represented by a file");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws IOException {
        ObjectUtil.checkNotNull(file, "dest");
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            if (file.createNewFile()) {
                return true;
            }
            throw new IOException("file exists already: " + file);
        }
        int i10 = byteBuf.readableBytes();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                long jWrite = 0;
                if (this.byteBuf.nioBufferCount() == 1) {
                    ByteBuffer byteBufferNioBuffer = this.byteBuf.nioBuffer();
                    while (jWrite < i10) {
                        jWrite += (long) channel.write(byteBufferNioBuffer);
                    }
                } else {
                    ByteBuffer[] byteBufferArrNioBuffers = this.byteBuf.nioBuffers();
                    while (jWrite < i10) {
                        jWrite += channel.write(byteBufferArrNioBuffers);
                    }
                }
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                return jWrite == ((long) i10);
            } catch (Throwable th2) {
                channel.close();
                throw th2;
            }
        } catch (Throwable th3) {
            randomAccessFile.close();
            throw th3;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        long j10 = byteBuf.readableBytes();
        try {
            checkSize(j10);
            long j11 = this.definedSize;
            if (j11 > 0 && j11 < j10) {
                byteBuf.release();
                StringBuilder sbA = b.a("Out of size: ", j10, " > ");
                sbA.append(this.definedSize);
                throw new IOException(sbA.toString());
            }
            ByteBuf byteBuf2 = this.byteBuf;
            if (byteBuf2 != null) {
                byteBuf2.release();
            }
            this.byteBuf = byteBuf;
            this.size = j10;
            setCompleted();
        } catch (IOException e10) {
            byteBuf.release();
            throw e10;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return "";
        }
        if (charset == null) {
            charset = HttpConstants.DEFAULT_CHARSET;
        }
        return byteBuf.toString(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return touch((Object) null);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        byte[] bArr = new byte[16384];
        ByteBuf byteBufBuffer = Unpooled.buffer();
        try {
            int i10 = inputStream.read(bArr);
            int i11 = 0;
            while (i10 > 0) {
                byteBufBuffer.writeBytes(bArr, 0, i10);
                i11 += i10;
                checkSize(i11);
                i10 = inputStream.read(bArr);
            }
            long j10 = i11;
            this.size = j10;
            long j11 = this.definedSize;
            if (j11 > 0 && j11 < j10) {
                byteBufBuffer.release();
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            ByteBuf byteBuf = this.byteBuf;
            if (byteBuf != null) {
                byteBuf.release();
            }
            this.byteBuf = byteBufBuffer;
            setCompleted();
        } catch (IOException e10) {
            byteBufBuffer.release();
            throw e10;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        ObjectUtil.checkNotNull(file, "file");
        long length = file.length();
        if (length <= 2147483647L) {
            checkSize(length);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[(int) length]);
                    for (int i10 = 0; i10 < length; i10 += channel.read(byteBufferWrap)) {
                    }
                    channel.close();
                    randomAccessFile.close();
                    byteBufferWrap.flip();
                    ByteBuf byteBuf = this.byteBuf;
                    if (byteBuf != null) {
                        byteBuf.release();
                    }
                    this.byteBuf = Unpooled.wrappedBuffer(Integer.MAX_VALUE, byteBufferWrap);
                    this.size = length;
                    setCompleted();
                    return;
                } catch (Throwable th2) {
                    channel.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                randomAccessFile.close();
                throw th3;
            }
        }
        throw new IllegalArgumentException("File too big to be loaded in memory");
    }
}
