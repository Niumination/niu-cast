package io.netty.buffer;

import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    static final int CALCULATE_THRESHOLD = 4194304;
    static final int DEFAULT_INITIAL_CAPACITY = 256;
    static final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    /* JADX INFO: renamed from: io.netty.buffer.AbstractByteBufAllocator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        static {
            int[] iArr = new int[ResourceLeakDetector.Level.values().length];
            $SwitchMap$io$netty$util$ResourceLeakDetector$Level = iArr;
            try {
                iArr[ResourceLeakDetector.Level.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.PARANOID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, "toLeakAwareBuffer");
    }

    public AbstractByteBufAllocator() {
        this(false);
    }

    public static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf) {
        ByteBuf simpleLeakAwareByteBuf;
        ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack;
        int i10 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i10 == 1) {
            ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack2 = AbstractByteBuf.leakDetector.track(byteBuf);
            if (resourceLeakTrackerTrack2 == null) {
                return byteBuf;
            }
            simpleLeakAwareByteBuf = new SimpleLeakAwareByteBuf(byteBuf, resourceLeakTrackerTrack2);
        } else {
            if ((i10 != 2 && i10 != 3) || (resourceLeakTrackerTrack = AbstractByteBuf.leakDetector.track(byteBuf)) == null) {
                return byteBuf;
            }
            simpleLeakAwareByteBuf = new AdvancedLeakAwareByteBuf(byteBuf, resourceLeakTrackerTrack);
        }
        return simpleLeakAwareByteBuf;
    }

    private static void validate(int i10, int i11) {
        ObjectUtil.checkPositiveOrZero(i10, "initialCapacity");
        if (i10 > i11) {
            throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        return this.directByDefault ? directBuffer() : heapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i10, int i11) {
        ObjectUtil.checkPositiveOrZero(i10, "minNewCapacity");
        if (i10 > i11) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        if (i10 == 4194304) {
            return 4194304;
        }
        if (i10 <= 4194304) {
            return Math.min(MathUtil.findNextPositivePowerOfTwo(Math.max(i10, 64)), i11);
        }
        int i12 = (i10 / 4194304) * 4194304;
        return i12 > i11 - 4194304 ? i11 : i12 + 4194304;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        return this.directByDefault ? compositeDirectBuffer() : compositeHeapBuffer();
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return compositeDirectBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return compositeHeapBuffer(16);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return directBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return heapBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) ? directBuffer(256) : heapBuffer(256);
    }

    public abstract ByteBuf newDirectBuffer(int i10, int i11);

    public abstract ByteBuf newHeapBuffer(int i10, int i11);

    public String toString() {
        return StringUtil.simpleClassName(this) + "(directByDefault: " + this.directByDefault + ')';
    }

    public AbstractByteBufAllocator(boolean z10) {
        this.directByDefault = z10 && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i10) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i10));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i10) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i10));
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i10) {
        return directBuffer(i10, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i10) {
        return heapBuffer(i10, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return this.emptyBuf;
        }
        validate(i10, i11);
        return newDirectBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return this.emptyBuf;
        }
        validate(i10, i11);
        return newHeapBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i10) {
        if (this.directByDefault) {
            return directBuffer(i10);
        }
        return heapBuffer(i10);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i10) {
        if (this.directByDefault) {
            return compositeDirectBuffer(i10);
        }
        return compositeHeapBuffer(i10);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i10) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i10);
        }
        return directBuffer(i10);
    }

    public static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        CompositeByteBuf simpleLeakAwareCompositeByteBuf;
        ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack;
        int i10 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i10 == 1) {
            ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack2 = AbstractByteBuf.leakDetector.track(compositeByteBuf);
            if (resourceLeakTrackerTrack2 == null) {
                return compositeByteBuf;
            }
            simpleLeakAwareCompositeByteBuf = new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, resourceLeakTrackerTrack2);
        } else {
            if ((i10 != 2 && i10 != 3) || (resourceLeakTrackerTrack = AbstractByteBuf.leakDetector.track(compositeByteBuf)) == null) {
                return compositeByteBuf;
            }
            simpleLeakAwareCompositeByteBuf = new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, resourceLeakTrackerTrack);
        }
        return simpleLeakAwareCompositeByteBuf;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i10, int i11) {
        if (this.directByDefault) {
            return directBuffer(i10, i11);
        }
        return heapBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i10, int i11) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i10, i11);
        }
        return directBuffer(i10, i11);
    }
}
