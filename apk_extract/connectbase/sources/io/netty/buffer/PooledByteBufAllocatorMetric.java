package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
    private final PooledByteBufAllocator allocator;

    public PooledByteBufAllocatorMetric(PooledByteBufAllocator pooledByteBufAllocator) {
        this.allocator = pooledByteBufAllocator;
    }

    public int chunkSize() {
        return this.allocator.chunkSize();
    }

    public List<PoolArenaMetric> directArenas() {
        return this.allocator.directArenas();
    }

    public List<PoolArenaMetric> heapArenas() {
        return this.allocator.heapArenas();
    }

    public int normalCacheSize() {
        return this.allocator.normalCacheSize();
    }

    public int numDirectArenas() {
        return this.allocator.numDirectArenas();
    }

    public int numHeapArenas() {
        return this.allocator.numHeapArenas();
    }

    public int numThreadLocalCaches() {
        return this.allocator.numThreadLocalCaches();
    }

    public int smallCacheSize() {
        return this.allocator.smallCacheSize();
    }

    @Deprecated
    public int tinyCacheSize() {
        return this.allocator.tinyCacheSize();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append("(usedHeapMemory: ");
        sb2.append(usedHeapMemory());
        sb2.append("; usedDirectMemory: ");
        sb2.append(usedDirectMemory());
        sb2.append("; numHeapArenas: ");
        sb2.append(numHeapArenas());
        sb2.append("; numDirectArenas: ");
        sb2.append(numDirectArenas());
        sb2.append("; smallCacheSize: ");
        sb2.append(smallCacheSize());
        sb2.append("; normalCacheSize: ");
        sb2.append(normalCacheSize());
        sb2.append("; numThreadLocalCaches: ");
        sb2.append(numThreadLocalCaches());
        sb2.append("; chunkSize: ");
        sb2.append(chunkSize());
        sb2.append(')');
        return sb2.toString();
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetric
    public long usedDirectMemory() {
        return this.allocator.usedDirectMemory();
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetric
    public long usedHeapMemory() {
        return this.allocator.usedHeapMemory();
    }
}
