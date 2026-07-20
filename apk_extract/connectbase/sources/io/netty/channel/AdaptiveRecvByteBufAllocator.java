package io.netty.channel;

import h.a;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {

    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT;
    static final int DEFAULT_INITIAL = 2048;
    static final int DEFAULT_MAXIMUM = 65536;
    static final int DEFAULT_MINIMUM = 64;
    private static final int INDEX_DECREMENT = 1;
    private static final int INDEX_INCREMENT = 4;
    private static final int[] SIZE_TABLE;
    private final int initial;
    private final int maxIndex;
    private final int minIndex;

    public final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private boolean decreaseNow;
        private int index;
        private final int maxIndex;
        private final int minIndex;
        private int nextReceiveBufferSize;

        public HandleImpl(int i10, int i11, int i12) {
            super();
            this.minIndex = i10;
            this.maxIndex = i11;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(i12);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        private void record(int i10) {
            if (i10 > AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 1)]) {
                if (i10 >= this.nextReceiveBufferSize) {
                    this.index = Math.min(this.index + 4, this.maxIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                return;
            }
            if (!this.decreaseNow) {
                this.decreaseNow = true;
                return;
            }
            this.index = Math.max(this.index - 1, this.minIndex);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
            this.decreaseNow = false;
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i10) {
            if (i10 == attemptedBytesRead()) {
                record(i10);
            }
            super.lastBytesRead(i10);
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            record(totalBytesRead());
        }
    }

    static {
        int i10;
        ArrayList arrayList = new ArrayList();
        int i11 = 16;
        while (true) {
            if (i11 >= 512) {
                break;
            }
            arrayList.add(Integer.valueOf(i11));
            i11 += 16;
        }
        for (i10 = 512; i10 > 0; i10 <<= 1) {
            arrayList.add(Integer.valueOf(i10));
        }
        SIZE_TABLE = new int[arrayList.size()];
        int i12 = 0;
        while (true) {
            int[] iArr = SIZE_TABLE;
            if (i12 >= iArr.length) {
                DEFAULT = new AdaptiveRecvByteBufAllocator();
                return;
            } else {
                iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
                i12++;
            }
        }
    }

    public AdaptiveRecvByteBufAllocator() {
        this(64, 2048, 65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSizeTableIndex(int i10) {
        int length = SIZE_TABLE.length - 1;
        int i11 = 0;
        while (length >= i11) {
            if (length == i11) {
                return length;
            }
            int i12 = (i11 + length) >>> 1;
            int[] iArr = SIZE_TABLE;
            int i13 = iArr[i12];
            int i14 = i12 + 1;
            if (i10 > iArr[i14]) {
                i11 = i14;
            } else {
                if (i10 >= i13) {
                    return i10 == i13 ? i12 : i14;
                }
                length = i12 - 1;
            }
        }
        return i11;
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
    }

    public AdaptiveRecvByteBufAllocator(int i10, int i11, int i12) {
        ObjectUtil.checkPositive(i10, "minimum");
        if (i11 < i10) {
            throw new IllegalArgumentException(a.a("initial: ", i11));
        }
        if (i12 < i11) {
            throw new IllegalArgumentException(a.a("maximum: ", i12));
        }
        int sizeTableIndex = getSizeTableIndex(i10);
        int[] iArr = SIZE_TABLE;
        if (iArr[sizeTableIndex] < i10) {
            this.minIndex = sizeTableIndex + 1;
        } else {
            this.minIndex = sizeTableIndex;
        }
        int sizeTableIndex2 = getSizeTableIndex(i12);
        if (iArr[sizeTableIndex2] > i12) {
            this.maxIndex = sizeTableIndex2 - 1;
        } else {
            this.maxIndex = sizeTableIndex2;
        }
        this.initial = i11;
    }

    @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public AdaptiveRecvByteBufAllocator respectMaybeMoreData(boolean z10) {
        super.respectMaybeMoreData(z10);
        return this;
    }
}
