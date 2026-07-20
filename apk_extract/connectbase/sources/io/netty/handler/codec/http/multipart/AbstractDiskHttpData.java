package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDiskHttpData extends AbstractHttpData {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractDiskHttpData.class);
    private File file;
    private FileChannel fileChannel;
    private boolean isRenamed;

    public AbstractDiskHttpData(String str, Charset charset, long j10) {
        super(str, charset, j10);
    }

    private static byte[] readFrom(File file) throws IOException {
        long length = file.length();
        if (length > 2147483647L) {
            throw new IllegalArgumentException("File too big to be loaded in memory");
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) length];
        try {
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            for (int i10 = 0; i10 < length; i10 += channel.read(byteBufferWrap)) {
            }
            randomAccessFile.close();
            return bArr;
        } catch (Throwable th2) {
            randomAccessFile.close();
            throw th2;
        }
    }

    private File tempFile() throws IOException {
        String postfix;
        String diskFilename = getDiskFilename();
        if (diskFilename != null) {
            postfix = "_" + Integer.toString(diskFilename.hashCode());
        } else {
            postfix = getPostfix();
        }
        File fileCreateTempFile = getBaseDirectory() == null ? PlatformDependent.createTempFile(getPrefix(), postfix, null) : PlatformDependent.createTempFile(getPrefix(), postfix, new File(getBaseDirectory()));
        if (deleteOnExit()) {
            DeleteFileOnExitHook.add(fileCreateTempFile.getPath());
        }
        return fileCreateTempFile;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z10) throws IOException {
        if (byteBuf != null) {
            try {
                int i10 = byteBuf.readableBytes();
                long j10 = i10;
                checkSize(this.size + j10);
                long j11 = this.definedSize;
                if (j11 > 0 && j11 < this.size + j10) {
                    throw new IOException("Out of size: " + (this.size + j10) + " > " + this.definedSize);
                }
                if (this.file == null) {
                    this.file = tempFile();
                }
                if (this.fileChannel == null) {
                    this.fileChannel = new RandomAccessFile(this.file, "rw").getChannel();
                }
                long jPosition = this.fileChannel.position();
                int i11 = byteBuf.readerIndex();
                int i12 = i10;
                while (i12 > 0) {
                    int bytes = byteBuf.getBytes(i11, this.fileChannel, jPosition, i12);
                    if (bytes < 0) {
                        break;
                    }
                    i12 -= bytes;
                    jPosition += (long) bytes;
                    i11 += bytes;
                }
                this.fileChannel.position(jPosition);
                byteBuf.readerIndex(i11);
                this.size += (long) (i10 - i12);
                byteBuf.release();
            } catch (Throwable th2) {
                byteBuf.release();
                throw th2;
            }
        }
        if (!z10) {
            ObjectUtil.checkNotNull(byteBuf, "buffer");
            return;
        }
        if (this.file == null) {
            this.file = tempFile();
        }
        if (this.fileChannel == null) {
            this.fileChannel = new RandomAccessFile(this.file, "rw").getChannel();
        }
        try {
            this.fileChannel.force(false);
            this.fileChannel.close();
            this.fileChannel = null;
            setCompleted();
        } catch (Throwable th3) {
            this.fileChannel.close();
            throw th3;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        String path;
        FileChannel fileChannel = this.fileChannel;
        if (fileChannel != null) {
            try {
                try {
                    try {
                        fileChannel.force(false);
                        this.fileChannel.close();
                    } catch (IOException e10) {
                        logger.warn("Failed to force.", (Throwable) e10);
                        this.fileChannel.close();
                    }
                } catch (IOException e11) {
                    logger.warn("Failed to close a file.", (Throwable) e11);
                }
                this.fileChannel = null;
            } catch (Throwable th2) {
                try {
                    this.fileChannel.close();
                } catch (IOException e12) {
                    logger.warn("Failed to close a file.", (Throwable) e12);
                }
                throw th2;
            }
        }
        if (this.isRenamed) {
            return;
        }
        File file = this.file;
        if (file == null || !file.exists()) {
            path = null;
        } else {
            path = this.file.getPath();
            if (!this.file.delete()) {
                logger.warn("Failed to delete: {}", this.file);
                path = null;
            }
        }
        if (deleteOnExit() && path != null) {
            DeleteFileOnExitHook.remove(path);
        }
        this.file = null;
    }

    public abstract boolean deleteOnExit();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() throws IOException {
        File file = this.file;
        return file == null ? EmptyArrays.EMPTY_BYTES : readFrom(file);
    }

    public abstract String getBaseDirectory();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() throws IOException {
        File file = this.file;
        return file == null ? Unpooled.EMPTY_BUFFER : Unpooled.wrappedBuffer(readFrom(file));
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i10) throws IOException {
        if (this.file == null || i10 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (this.fileChannel == null) {
            this.fileChannel = new RandomAccessFile(this.file, "r").getChannel();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10);
        int i11 = 0;
        while (i11 < i10) {
            try {
                int i12 = this.fileChannel.read(byteBufferAllocate);
                if (i12 == -1) {
                    this.fileChannel.close();
                    this.fileChannel = null;
                    break;
                }
                i11 += i12;
            } catch (IOException e10) {
                this.fileChannel.close();
                this.fileChannel = null;
                throw e10;
            }
        }
        if (i11 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        byteBufferAllocate.flip();
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(byteBufferAllocate);
        byteBufWrappedBuffer.readerIndex(0);
        byteBufWrappedBuffer.writerIndex(i11);
        return byteBufWrappedBuffer;
    }

    public abstract String getDiskFilename();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        return this.file;
    }

    public abstract String getPostfix();

    public abstract String getPrefix();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() throws IOException {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws Throwable {
        Throwable th2;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        IOException iOException;
        ObjectUtil.checkNotNull(file, "dest");
        File file2 = this.file;
        if (file2 == null) {
            throw new IOException("No file defined so cannot be renamed");
        }
        if (file2.renameTo(file)) {
            this.file = file;
            this.isRenamed = true;
            return true;
        }
        IOException iOException2 = null;
        long jTransferTo = 0;
        try {
            randomAccessFile = new RandomAccessFile(this.file, "r");
            try {
                randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    FileChannel channel2 = randomAccessFile2.getChannel();
                    long j10 = 8196;
                    while (true) {
                        long j11 = this.size;
                        if (jTransferTo < j11) {
                            long j12 = j10 < j11 - jTransferTo ? j11 - jTransferTo : j10;
                            jTransferTo += channel.transferTo(jTransferTo, j12, channel2);
                            j10 = j12;
                        } else {
                            try {
                                break;
                            } catch (IOException e10) {
                                iOException2 = e10;
                            }
                        }
                    }
                    randomAccessFile.close();
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e11) {
                        iOException = e11;
                        if (iOException2 == null) {
                            iOException2 = iOException;
                        } else {
                            logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) iOException);
                        }
                    }
                } catch (IOException e12) {
                    e = e12;
                    iOException2 = e;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e13) {
                            logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) e13);
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e14) {
                            iOException = e14;
                            logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) iOException);
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e15) {
                            iOException2 = e15;
                        }
                    }
                    if (randomAccessFile2 == null) {
                        throw th2;
                    }
                    try {
                        randomAccessFile2.close();
                        throw th2;
                    } catch (IOException e16) {
                        if (iOException2 == null) {
                            throw th2;
                        }
                        logger.warn("Multiple exceptions detected, the following will be suppressed {}", (Throwable) e16);
                        throw th2;
                    }
                }
            } catch (IOException e17) {
                e = e17;
                randomAccessFile2 = null;
            } catch (Throwable th4) {
                th2 = th4;
                randomAccessFile2 = null;
            }
        } catch (IOException e18) {
            e = e18;
            randomAccessFile = null;
            randomAccessFile2 = null;
        } catch (Throwable th5) {
            th2 = th5;
            randomAccessFile = null;
            randomAccessFile2 = null;
        }
        if (iOException2 != null) {
            throw iOException2;
        }
        if (jTransferTo != this.size) {
            if (file.delete()) {
                return false;
            }
            logger.warn("Failed to delete: {}", file);
            return false;
        }
        if (!this.file.delete()) {
            logger.warn("Failed to delete: {}", this.file);
        }
        this.file = file;
        this.isRenamed = true;
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        try {
            long j10 = byteBuf.readableBytes();
            this.size = j10;
            checkSize(j10);
            long j11 = this.definedSize;
            if (j11 > 0 && j11 < this.size) {
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            if (this.file == null) {
                this.file = tempFile();
            }
            if (byteBuf.readableBytes() == 0) {
                if (!this.file.createNewFile()) {
                    if (this.file.length() == 0) {
                        byteBuf.release();
                        return;
                    } else if (!this.file.delete() || !this.file.createNewFile()) {
                        throw new IOException("file exists already: " + this.file);
                    }
                }
                byteBuf.release();
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
            try {
                randomAccessFile.setLength(0L);
                FileChannel channel = randomAccessFile.getChannel();
                ByteBuffer byteBufferNioBuffer = byteBuf.nioBuffer();
                int iWrite = 0;
                while (iWrite < this.size) {
                    iWrite += channel.write(byteBufferNioBuffer);
                }
                byteBuf.readerIndex(byteBuf.readerIndex() + iWrite);
                channel.force(false);
                randomAccessFile.close();
                setCompleted();
                byteBuf.release();
            } catch (Throwable th2) {
                randomAccessFile.close();
                throw th2;
            }
        } catch (Throwable th3) {
            byteBuf.release();
            throw th3;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) throws IOException {
        File file = this.file;
        if (file == null) {
            return "";
        }
        return charset == null ? new String(readFrom(file), HttpConstants.DEFAULT_CHARSET.name()) : new String(readFrom(file), charset.name());
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        long length = file.length();
        checkSize(length);
        this.size = length;
        if (this.file != null) {
            delete();
        }
        this.file = file;
        this.isRenamed = true;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        if (this.file != null) {
            delete();
        }
        this.file = tempFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
        try {
            randomAccessFile.setLength(0L);
            FileChannel channel = randomAccessFile.getChannel();
            byte[] bArr = new byte[16384];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i10 = inputStream.read(bArr);
            int iWrite = 0;
            while (i10 > 0) {
                byteBufferWrap.position(i10).flip();
                iWrite += channel.write(byteBufferWrap);
                checkSize(iWrite);
                byteBufferWrap.clear();
                i10 = inputStream.read(bArr);
            }
            channel.force(false);
            randomAccessFile.close();
            long j10 = iWrite;
            this.size = j10;
            long j11 = this.definedSize;
            if (j11 > 0 && j11 < j10) {
                if (!this.file.delete()) {
                    logger.warn("Failed to delete: {}", this.file);
                }
                this.file = null;
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            this.isRenamed = true;
            setCompleted();
        } catch (Throwable th2) {
            randomAccessFile.close();
            throw th2;
        }
    }
}
