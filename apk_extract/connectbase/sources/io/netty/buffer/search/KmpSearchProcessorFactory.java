package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes2.dex */
public class KmpSearchProcessorFactory extends AbstractSearchProcessorFactory {
    private final int[] jumpTable;
    private final byte[] needle;

    public static class Processor implements SearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final byte[] needle;

        public Processor(byte[] bArr, int[] iArr) {
            this.needle = bArr;
            this.jumpTable = iArr;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            while (true) {
                long j10 = this.currentPosition;
                if (j10 <= 0 || PlatformDependent.getByte(this.needle, j10) == b10) {
                    break;
                }
                this.currentPosition = PlatformDependent.getInt(this.jumpTable, this.currentPosition);
            }
            if (PlatformDependent.getByte(this.needle, this.currentPosition) == b10) {
                this.currentPosition++;
            }
            long j11 = this.currentPosition;
            if (j11 != this.needle.length) {
                return true;
            }
            this.currentPosition = PlatformDependent.getInt(this.jumpTable, j11);
            return false;
        }

        @Override // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentPosition = 0L;
        }
    }

    public KmpSearchProcessorFactory(byte[] bArr) {
        this.needle = (byte[]) bArr.clone();
        int i10 = 1;
        this.jumpTable = new int[bArr.length + 1];
        int i11 = 0;
        while (i10 < bArr.length) {
            while (i11 > 0 && bArr[i11] != bArr[i10]) {
                i11 = this.jumpTable[i11];
            }
            if (bArr[i11] == bArr[i10]) {
                i11++;
            }
            i10++;
            this.jumpTable[i10] = i11;
        }
    }

    @Override // io.netty.buffer.search.SearchProcessorFactory
    public Processor newSearchProcessor() {
        return new Processor(this.needle, this.jumpTable);
    }
}
