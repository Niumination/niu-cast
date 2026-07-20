package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes2.dex */
public class BitapSearchProcessorFactory extends AbstractSearchProcessorFactory {
    private final long[] bitMasks = new long[256];
    private final long successBit;

    public static class Processor implements SearchProcessor {
        private final long[] bitMasks;
        private long currentMask;
        private final long successBit;

        public Processor(long[] jArr, long j10) {
            this.bitMasks = jArr;
            this.successBit = j10;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            long j10 = ((this.currentMask << 1) | 1) & PlatformDependent.getLong(this.bitMasks, ((long) b10) & 255);
            this.currentMask = j10;
            return (this.successBit & j10) == 0;
        }

        @Override // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentMask = 0L;
        }
    }

    public BitapSearchProcessorFactory(byte[] bArr) {
        if (bArr.length > 64) {
            throw new IllegalArgumentException("Maximum supported search pattern length is 64, got " + bArr.length);
        }
        long j10 = 1;
        for (byte b10 : bArr) {
            long[] jArr = this.bitMasks;
            int i10 = b10 & 255;
            jArr[i10] = jArr[i10] | j10;
            j10 <<= 1;
        }
        this.successBit = 1 << (bArr.length - 1);
    }

    @Override // io.netty.buffer.search.SearchProcessorFactory
    public Processor newSearchProcessor() {
        return new Processor(this.bitMasks, this.successBit);
    }
}
