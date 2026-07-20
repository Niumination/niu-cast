package io.netty.channel;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultFileRegion extends AbstractReferenceCounted implements FileRegion {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultFileRegion.class);
    private final long count;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f8291f;
    private FileChannel file;
    private final long position;
    private long transferred;

    public DefaultFileRegion(FileChannel fileChannel, long j10, long j11) {
        this.file = (FileChannel) ObjectUtil.checkNotNull(fileChannel, "fileChannel");
        this.position = ObjectUtil.checkPositiveOrZero(j10, "position");
        this.count = ObjectUtil.checkPositiveOrZero(j11, "count");
        this.f8291f = null;
    }

    public static void validate(DefaultFileRegion defaultFileRegion, long j10) throws IOException {
        long size = defaultFileRegion.file.size();
        if (defaultFileRegion.position + (defaultFileRegion.count - j10) + j10 <= size) {
            return;
        }
        StringBuilder sbA = b.a("Underlying file size ", size, " smaller then requested count ");
        sbA.append(defaultFileRegion.count);
        throw new IOException(sbA.toString());
    }

    @Override // io.netty.channel.FileRegion
    public long count() {
        return this.count;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        FileChannel fileChannel = this.file;
        if (fileChannel == null) {
            return;
        }
        this.file = null;
        try {
            fileChannel.close();
        } catch (IOException e10) {
            logger.warn("Failed to close a file.", (Throwable) e10);
        }
    }

    public boolean isOpen() {
        return this.file != null;
    }

    public void open() throws IOException {
        if (isOpen() || refCnt() <= 0) {
            return;
        }
        this.file = new RandomAccessFile(this.f8291f, "r").getChannel();
    }

    @Override // io.netty.channel.FileRegion
    public long position() {
        return this.position;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion touch() {
        return this;
    }

    @Override // io.netty.channel.FileRegion
    public long transferTo(WritableByteChannel writableByteChannel, long j10) throws IOException {
        long j11 = this.count - j10;
        if (j11 < 0 || j10 < 0) {
            throw new IllegalArgumentException(k0.a(b.a("position out of range: ", j10, " (expected: 0 - "), this.count - 1, ')'));
        }
        if (j11 == 0) {
            return 0L;
        }
        if (refCnt() == 0) {
            throw new IllegalReferenceCountException(0);
        }
        open();
        long jTransferTo = this.file.transferTo(this.position + j10, j11, writableByteChannel);
        if (jTransferTo > 0) {
            this.transferred += jTransferTo;
        } else if (jTransferTo == 0) {
            validate(this, j10);
        }
        return jTransferTo;
    }

    @Override // io.netty.channel.FileRegion
    @Deprecated
    public long transfered() {
        return this.transferred;
    }

    @Override // io.netty.channel.FileRegion
    public long transferred() {
        return this.transferred;
    }

    @Override // io.netty.util.ReferenceCounted
    public FileRegion touch(Object obj) {
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain(int i10) {
        super.retain(i10);
        return this;
    }

    public DefaultFileRegion(File file, long j10, long j11) {
        this.f8291f = (File) ObjectUtil.checkNotNull(file, "file");
        this.position = ObjectUtil.checkPositiveOrZero(j10, "position");
        this.count = ObjectUtil.checkPositiveOrZero(j11, "count");
    }
}
