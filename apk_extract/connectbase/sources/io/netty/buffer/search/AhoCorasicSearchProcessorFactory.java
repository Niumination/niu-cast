package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class AhoCorasicSearchProcessorFactory extends AbstractMultiSearchProcessorFactory {
    static final int ALPHABET_SIZE = 256;
    static final int BITS_PER_SYMBOL = 8;
    private final int[] jumpTable;
    private final int[] matchForNeedleId;

    public static class Context {
        int[] jumpTable;
        int[] matchForNeedleId;

        private Context() {
        }
    }

    public static class Processor implements MultiSearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final int[] matchForNeedleId;

        public Processor(int[] iArr, int[] iArr2) {
            this.jumpTable = iArr;
            this.matchForNeedleId = iArr2;
        }

        @Override // io.netty.buffer.search.MultiSearchProcessor
        public int getFoundNeedleId() {
            return this.matchForNeedleId[((int) this.currentPosition) >> 8];
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            long j10 = PlatformDependent.getInt(this.jumpTable, this.currentPosition | (((long) b10) & 255));
            this.currentPosition = j10;
            if (j10 >= 0) {
                return true;
            }
            this.currentPosition = -j10;
            return false;
        }

        @Override // io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentPosition = 0L;
        }
    }

    public AhoCorasicSearchProcessorFactory(byte[]... bArr) {
        int i10 = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2.length == 0) {
                throw new IllegalArgumentException("Needle must be non empty");
            }
        }
        Context contextBuildTrie = buildTrie(bArr);
        this.jumpTable = contextBuildTrie.jumpTable;
        this.matchForNeedleId = contextBuildTrie.matchForNeedleId;
        linkSuffixes();
        while (true) {
            int[] iArr = this.jumpTable;
            if (i10 >= iArr.length) {
                return;
            }
            int[] iArr2 = this.matchForNeedleId;
            int i11 = iArr[i10];
            if (iArr2[i11 >> 8] >= 0) {
                iArr[i10] = -i11;
            }
            i10++;
        }
    }

    private static Context buildTrie(byte[][] bArr) {
        ArrayList arrayList = new ArrayList(256);
        for (int i10 = 0; i10 < 256; i10++) {
            arrayList.add(-1);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(-1);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int iIntValue = 0;
            for (byte b10 : bArr[i11]) {
                int i12 = iIntValue + (b10 & 255);
                if (((Integer) arrayList.get(i12)).intValue() == -1) {
                    arrayList.set(i12, Integer.valueOf(arrayList.size()));
                    for (int i13 = 0; i13 < 256; i13++) {
                        arrayList.add(-1);
                    }
                    arrayList2.add(-1);
                }
                iIntValue = ((Integer) arrayList.get(i12)).intValue();
            }
            arrayList2.set(iIntValue >> 8, Integer.valueOf(i11));
        }
        Context context = new Context();
        context.jumpTable = new int[arrayList.size()];
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            context.jumpTable[i14] = ((Integer) arrayList.get(i14)).intValue();
        }
        context.matchForNeedleId = new int[arrayList2.size()];
        for (int i15 = 0; i15 < arrayList2.size(); i15++) {
            context.matchForNeedleId[i15] = ((Integer) arrayList2.get(i15)).intValue();
        }
        return context;
    }

    private void linkSuffixes() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(0);
        int[] iArr = new int[this.matchForNeedleId.length];
        Arrays.fill(iArr, -1);
        while (!arrayDeque.isEmpty()) {
            int iIntValue = ((Integer) arrayDeque.remove()).intValue();
            int i10 = iIntValue >> 8;
            int i11 = iArr[i10];
            if (i11 == -1) {
                i11 = 0;
            }
            int[] iArr2 = this.matchForNeedleId;
            if (iArr2[i10] == -1) {
                iArr2[i10] = iArr2[i11 >> 8];
            }
            for (int i12 = 0; i12 < 256; i12++) {
                int i13 = iIntValue | i12;
                int[] iArr3 = this.jumpTable;
                int i14 = iArr3[i13];
                int i15 = iArr3[i11 | i12];
                if (i14 != -1) {
                    int i16 = i14 >> 8;
                    if (iIntValue <= 0 || i15 == -1) {
                        i15 = 0;
                    }
                    iArr[i16] = i15;
                    arrayDeque.add(Integer.valueOf(i14));
                } else {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    iArr3[i13] = i15;
                }
            }
        }
    }

    @Override // io.netty.buffer.search.SearchProcessorFactory
    public Processor newSearchProcessor() {
        return new Processor(this.jumpTable, this.matchForNeedleId);
    }
}
