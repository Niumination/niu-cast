package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rs.f;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
public class FileDescriptor {
    private static final int STATE_ALL_MASK = 7;
    private static final int STATE_CLOSED_MASK = 1;
    private static final int STATE_INPUT_SHUTDOWN_MASK = 2;
    private static final int STATE_OUTPUT_SHUTDOWN_MASK = 4;
    private static final AtomicIntegerFieldUpdater<FileDescriptor> stateUpdater = AtomicIntegerFieldUpdater.newUpdater(FileDescriptor.class, "state");

    /* JADX INFO: renamed from: fd, reason: collision with root package name */
    final int f8302fd;
    volatile int state;

    public FileDescriptor(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "fd");
        this.f8302fd = i10;
    }

    private static native int close(int i10);

    public static FileDescriptor from(String str) throws IOException {
        int iOpen = open((String) ObjectUtil.checkNotNull(str, "path"));
        if (iOpen >= 0) {
            return new FileDescriptor(iOpen);
        }
        throw Errors.newIOException("open", iOpen);
    }

    public static int inputShutdown(int i10) {
        return i10 | 2;
    }

    public static boolean isClosed(int i10) {
        return (i10 & 1) != 0;
    }

    public static boolean isInputShutdown(int i10) {
        return (i10 & 2) != 0;
    }

    public static boolean isOutputShutdown(int i10) {
        return (i10 & 4) != 0;
    }

    private static native long newPipe();

    private static native int open(String str);

    public static int outputShutdown(int i10) {
        return i10 | 4;
    }

    public static FileDescriptor[] pipe() throws IOException {
        long jNewPipe = newPipe();
        if (jNewPipe >= 0) {
            return new FileDescriptor[]{new FileDescriptor((int) (jNewPipe >>> 32)), new FileDescriptor((int) jNewPipe)};
        }
        throw Errors.newIOException("newPipe", (int) jNewPipe);
    }

    private static native int read(int i10, ByteBuffer byteBuffer, int i11, int i12);

    private static native int readAddress(int i10, long j10, int i11, int i12);

    private static native int write(int i10, ByteBuffer byteBuffer, int i11, int i12);

    private static native int writeAddress(int i10, long j10, int i11, int i12);

    private static native long writev(int i10, ByteBuffer[] byteBufferArr, int i11, int i12, long j10);

    private static native long writevAddresses(int i10, long j10, int i11);

    public final boolean casState(int i10, int i11) {
        return stateUpdater.compareAndSet(this, i10, i11);
    }

    public void close() throws IOException {
        int iClose;
        if (markClosed() && (iClose = close(this.f8302fd)) < 0) {
            throw Errors.newIOException("close", iClose);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FileDescriptor) && this.f8302fd == ((FileDescriptor) obj).f8302fd;
    }

    public int hashCode() {
        return this.f8302fd;
    }

    public final int intValue() {
        return this.f8302fd;
    }

    public boolean isOpen() {
        return !isClosed(this.state);
    }

    public boolean markClosed() {
        int i10;
        do {
            i10 = this.state;
            if (isClosed(i10)) {
                return false;
            }
        } while (!casState(i10, i10 | 7));
        return true;
    }

    public final int read(ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        int i12 = read(this.f8302fd, byteBuffer, i10, i11);
        if (i12 > 0) {
            return i12;
        }
        if (i12 == 0) {
            return -1;
        }
        return Errors.ioResult("read", i12);
    }

    public final int readAddress(long j10, int i10, int i11) throws IOException {
        int address = readAddress(this.f8302fd, j10, i10, i11);
        if (address > 0) {
            return address;
        }
        if (address == 0) {
            return -1;
        }
        return Errors.ioResult("readAddress", address);
    }

    public String toString() {
        return a.a(new StringBuilder("FileDescriptor{fd="), this.f8302fd, f.f14860b);
    }

    public final int write(ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        int iWrite = write(this.f8302fd, byteBuffer, i10, i11);
        return iWrite >= 0 ? iWrite : Errors.ioResult("write", iWrite);
    }

    public final int writeAddress(long j10, int i10, int i11) throws IOException {
        int iWriteAddress = writeAddress(this.f8302fd, j10, i10, i11);
        return iWriteAddress >= 0 ? iWriteAddress : Errors.ioResult("writeAddress", iWriteAddress);
    }

    public final long writev(ByteBuffer[] byteBufferArr, int i10, int i11, long j10) throws IOException {
        long jWritev = writev(this.f8302fd, byteBufferArr, i10, Math.min(Limits.IOV_MAX, i11), j10);
        return jWritev >= 0 ? jWritev : Errors.ioResult("writev", (int) jWritev);
    }

    public final long writevAddresses(long j10, int i10) throws IOException {
        long jWritevAddresses = writevAddresses(this.f8302fd, j10, i10);
        return jWritevAddresses >= 0 ? jWritevAddresses : Errors.ioResult("writevAddresses", (int) jWritevAddresses);
    }

    public static FileDescriptor from(File file) throws IOException {
        return from(((File) ObjectUtil.checkNotNull(file, "file")).getPath());
    }
}
