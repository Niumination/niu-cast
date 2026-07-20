package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

/* JADX INFO: loaded from: classes3.dex */
abstract class MpscChunkedAtomicArrayQueueColdProducerFields<E> extends BaseMpscLinkedAtomicArrayQueue<E> {
    protected final long maxQueueCapacity;

    public MpscChunkedAtomicArrayQueueColdProducerFields(int i10, int i11) {
        super(i10);
        RangeUtil.checkGreaterThanOrEqual(i11, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(i10), Pow2.roundToPowerOfTwo(i11), "initialCapacity");
        this.maxQueueCapacity = ((long) Pow2.roundToPowerOfTwo(i11)) << 1;
    }
}
