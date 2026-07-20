package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes3.dex */
abstract class ByteBufChecksum implements Checksum {
    private static final Method ADLER32_UPDATE_METHOD = updateByteBuffer(new Adler32());
    private static final Method CRC32_UPDATE_METHOD = updateByteBuffer(new CRC32());
    private final ByteProcessor updateProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.ByteBufChecksum.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) throws Exception {
            ByteBufChecksum.this.update(b10);
            return true;
        }
    };

    public static final class ReflectiveByteBufChecksum extends SlowByteBufChecksum {
        private final Method method;

        public ReflectiveByteBufChecksum(Checksum checksum, Method method) {
            super(checksum);
            this.method = method;
        }

        @Override // io.netty.handler.codec.compression.ByteBufChecksum
        public void update(ByteBuf byteBuf, int i10, int i11) {
            if (byteBuf.hasArray()) {
                update(byteBuf.array(), byteBuf.arrayOffset() + i10, i11);
            } else {
                try {
                    this.method.invoke(this.checksum, CompressionUtil.safeNioBuffer(byteBuf, i10, i11));
                } catch (Throwable unused) {
                    throw new Error();
                }
            }
        }
    }

    public static class SlowByteBufChecksum extends ByteBufChecksum {
        protected final Checksum checksum;

        public SlowByteBufChecksum(Checksum checksum) {
            this.checksum = checksum;
        }

        @Override // java.util.zip.Checksum
        public long getValue() {
            return this.checksum.getValue();
        }

        @Override // java.util.zip.Checksum
        public void reset() {
            this.checksum.reset();
        }

        @Override // java.util.zip.Checksum
        public void update(int i10) {
            this.checksum.update(i10);
        }

        @Override // java.util.zip.Checksum
        public void update(byte[] bArr, int i10, int i11) {
            this.checksum.update(bArr, i10, i11);
        }
    }

    private static Method updateByteBuffer(Checksum checksum) {
        if (PlatformDependent.javaVersion() >= 8) {
            try {
                Method declaredMethod = checksum.getClass().getDeclaredMethod("update", ByteBuffer.class);
                declaredMethod.invoke(checksum, ByteBuffer.allocate(1));
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static ByteBufChecksum wrapChecksum(Checksum checksum) {
        Method method;
        Method method2;
        ObjectUtil.checkNotNull(checksum, "checksum");
        if (checksum instanceof ByteBufChecksum) {
            return (ByteBufChecksum) checksum;
        }
        if (!(checksum instanceof Adler32) || (method2 = ADLER32_UPDATE_METHOD) == null) {
            return (!(checksum instanceof CRC32) || (method = CRC32_UPDATE_METHOD) == null) ? new SlowByteBufChecksum(checksum) : new ReflectiveByteBufChecksum(checksum, method);
        }
        return new ReflectiveByteBufChecksum(checksum, method2);
    }

    public void update(ByteBuf byteBuf, int i10, int i11) {
        if (byteBuf.hasArray()) {
            update(byteBuf.array(), byteBuf.arrayOffset() + i10, i11);
        } else {
            byteBuf.forEachByte(i10, i11, this.updateProcessor);
        }
    }
}
