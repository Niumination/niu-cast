package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k.b;
import k.c;
import lm.g2;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBufAllocator alloc;
    private int componentCount;
    private Component[] components;
    private final boolean direct;
    private boolean freed;
    private Component lastAccessed;
    private final int maxNumComponents;
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.emptyList().iterator();
    static final ByteWrapper<byte[]> BYTE_ARRAY_WRAPPER = new ByteWrapper<byte[]>() { // from class: io.netty.buffer.CompositeByteBuf.1
        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public boolean isEmpty(byte[] bArr) {
            return bArr.length == 0;
        }

        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public ByteBuf wrap(byte[] bArr) {
            return Unpooled.wrappedBuffer(bArr);
        }
    };
    static final ByteWrapper<ByteBuffer> BYTE_BUFFER_WRAPPER = new ByteWrapper<ByteBuffer>() { // from class: io.netty.buffer.CompositeByteBuf.2
        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public boolean isEmpty(ByteBuffer byteBuffer) {
            return !byteBuffer.hasRemaining();
        }

        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public ByteBuf wrap(ByteBuffer byteBuffer) {
            return Unpooled.wrappedBuffer(byteBuffer);
        }
    };

    public interface ByteWrapper<T> {
        boolean isEmpty(T t10);

        ByteBuf wrap(T t10);
    }

    public static final class Component {
        int adjustment;
        final ByteBuf buf;
        int endOffset;
        int offset;
        private ByteBuf slice;
        int srcAdjustment;
        final ByteBuf srcBuf;

        public Component(ByteBuf byteBuf, int i10, ByteBuf byteBuf2, int i11, int i12, int i13, ByteBuf byteBuf3) {
            this.srcBuf = byteBuf;
            this.srcAdjustment = i10 - i12;
            this.buf = byteBuf2;
            this.adjustment = i11 - i12;
            this.offset = i12;
            this.endOffset = i12 + i13;
            this.slice = byteBuf3;
        }

        public ByteBuf duplicate() {
            return this.srcBuf.duplicate();
        }

        public void free() {
            this.slice = null;
            this.srcBuf.release();
        }

        public int idx(int i10) {
            return i10 + this.adjustment;
        }

        public ByteBuffer internalNioBuffer(int i10, int i11) {
            return this.srcBuf.internalNioBuffer(srcIdx(i10), i11);
        }

        public int length() {
            return this.endOffset - this.offset;
        }

        public void reposition(int i10) {
            int i11 = i10 - this.offset;
            this.endOffset += i11;
            this.srcAdjustment -= i11;
            this.adjustment -= i11;
            this.offset = i10;
        }

        public ByteBuf slice() {
            ByteBuf byteBuf = this.slice;
            if (byteBuf != null) {
                return byteBuf;
            }
            ByteBuf byteBufSlice = this.srcBuf.slice(srcIdx(this.offset), length());
            this.slice = byteBufSlice;
            return byteBufSlice;
        }

        public int srcIdx(int i10) {
            return i10 + this.srcAdjustment;
        }

        public void transferTo(ByteBuf byteBuf) {
            byteBuf.writeBytes(this.buf, idx(this.offset), length());
            free();
        }
    }

    public final class CompositeByteBufIterator implements Iterator<ByteBuf> {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = CompositeByteBuf.this.numComponents();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.size > this.index;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteBuf next() {
            if (this.size != CompositeByteBuf.this.numComponents()) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            try {
                Component[] componentArr = CompositeByteBuf.this.components;
                int i10 = this.index;
                this.index = i10 + 1;
                return componentArr[i10].slice();
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10, int i11) {
        super(Integer.MAX_VALUE);
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        if (i10 < 1) {
            throw new IllegalArgumentException(b.a("maxNumComponents: ", i10, " (expected: >= 1)"));
        }
        this.direct = z10;
        this.maxNumComponents = i10;
        this.components = newCompArray(i11, i10);
    }

    private void addComp(int i10, Component component) {
        shiftComps(i10, 1);
        this.components[i10] = component;
    }

    private int addComponent0(boolean z10, int i10, ByteBuf byteBuf) {
        boolean z11 = false;
        try {
            checkComponentIndex(i10);
            Component componentNewComponent = newComponent(ensureAccessible(byteBuf), 0);
            int length = componentNewComponent.length();
            checkForOverflow(capacity(), length);
            addComp(i10, componentNewComponent);
            z11 = true;
            if (length > 0 && i10 < this.componentCount - 1) {
                updateComponentOffsets(i10);
            } else if (i10 > 0) {
                componentNewComponent.reposition(this.components[i10 - 1].endOffset);
            }
            if (z10) {
                this.writerIndex += length;
            }
            return i10;
        } catch (Throwable th2) {
            if (!z11) {
                byteBuf.release();
            }
            throw th2;
        }
    }

    private CompositeByteBuf addComponents0(boolean z10, int i10, ByteBuf[] byteBufArr, int i11) {
        ByteBuf byteBuf;
        int length = byteBufArr.length;
        int i12 = length - i11;
        int iCapacity = capacity();
        int i13 = 0;
        for (int i14 = i11; i14 < byteBufArr.length && (byteBuf = byteBufArr[i14]) != null; i14++) {
            i13 += byteBuf.readableBytes();
            checkForOverflow(iCapacity, i13);
        }
        int i15 = Integer.MAX_VALUE;
        try {
            checkComponentIndex(i10);
            shiftComps(i10, i12);
            int i16 = i10 > 0 ? this.components[i10 - 1].endOffset : 0;
            i15 = i10;
            while (i11 < length) {
                ByteBuf byteBuf2 = byteBufArr[i11];
                if (byteBuf2 == null) {
                    break;
                }
                Component componentNewComponent = newComponent(ensureAccessible(byteBuf2), i16);
                this.components[i15] = componentNewComponent;
                i16 = componentNewComponent.endOffset;
                i11++;
                i15++;
            }
            if (i15 < this.componentCount) {
                int i17 = i12 + i10;
                if (i15 < i17) {
                    removeCompRange(i15, i17);
                    while (i11 < length) {
                        ReferenceCountUtil.safeRelease(byteBufArr[i11]);
                        i11++;
                    }
                }
                updateComponentOffsets(i15);
            }
            if (z10 && i15 > i10 && i15 <= this.componentCount) {
                int i18 = this.writerIndex;
                Component[] componentArr = this.components;
                this.writerIndex = (componentArr[i15 - 1].endOffset - componentArr[i10].offset) + i18;
            }
            return this;
        } catch (Throwable th2) {
            if (i15 < this.componentCount) {
                int i19 = i12 + i10;
                if (i15 < i19) {
                    removeCompRange(i15, i19);
                    while (i11 < length) {
                        ReferenceCountUtil.safeRelease(byteBufArr[i11]);
                        i11++;
                    }
                }
                updateComponentOffsets(i15);
            }
            if (z10 && i15 > i10 && i15 <= this.componentCount) {
                int i20 = this.writerIndex;
                Component[] componentArr2 = this.components;
                this.writerIndex = (componentArr2[i15 - 1].endOffset - componentArr2[i10].offset) + i20;
            }
            throw th2;
        }
    }

    private ByteBuf allocBuffer(int i10) {
        boolean z10 = this.direct;
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        return z10 ? byteBufAllocatorAlloc.directBuffer(i10) : byteBufAllocatorAlloc.heapBuffer(i10);
    }

    private void checkComponentIndex(int i10) {
        ensureAccessible();
        if (i10 < 0 || i10 > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i10), Integer.valueOf(this.componentCount)));
        }
    }

    private static void checkForOverflow(int i10, int i11) {
        if (i10 + i11 >= 0) {
            return;
        }
        throw new IllegalArgumentException("Can't increase by " + i11 + " as capacity(" + i10 + ") would overflow 2147483647");
    }

    private void clearComps() {
        removeCompRange(0, this.componentCount);
    }

    private void consolidate0(int i10, int i11) {
        if (i11 <= 1) {
            return;
        }
        int i12 = i10 + i11;
        ByteBuf byteBufAllocBuffer = allocBuffer(this.components[i12 - 1].endOffset - (i10 != 0 ? this.components[i10].offset : 0));
        for (int i13 = i10; i13 < i12; i13++) {
            this.components[i13].transferTo(byteBufAllocBuffer);
        }
        this.lastAccessed = null;
        removeCompRange(i10 + 1, i12);
        this.components[i10] = newComponent(byteBufAllocBuffer, 0);
        if (i10 == 0 && i11 == this.componentCount) {
            return;
        }
        updateComponentOffsets(i10);
    }

    private void consolidateIfNeeded() {
        int i10 = this.componentCount;
        if (i10 > this.maxNumComponents) {
            consolidate0(0, i10);
        }
    }

    private void copyTo(int i10, int i11, int i12, ByteBuf byteBuf) {
        int i13 = 0;
        while (i11 > 0) {
            Component component = this.components[i12];
            int iMin = Math.min(i11, component.endOffset - i10);
            component.buf.getBytes(component.idx(i10), byteBuf, i13, iMin);
            i10 += iMin;
            i13 += iMin;
            i11 -= iMin;
            i12++;
        }
        byteBuf.writerIndex(byteBuf.capacity());
    }

    private static ByteBuf ensureAccessible(ByteBuf byteBuf) {
        if (!AbstractByteBuf.checkAccessible || byteBuf.isAccessible()) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(0);
    }

    private Component findComponent(int i10) {
        Component component = this.lastAccessed;
        if (component == null || i10 < component.offset || i10 >= component.endOffset) {
            checkIndex(i10);
            return findIt(i10);
        }
        ensureAccessible();
        return component;
    }

    private Component findComponent0(int i10) {
        Component component = this.lastAccessed;
        return (component == null || i10 < component.offset || i10 >= component.endOffset) ? findIt(i10) : component;
    }

    private Component findIt(int i10) {
        int i11 = this.componentCount;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            Component component = this.components[i13];
            if (component == null) {
                throw new IllegalStateException("No component found for offset. Composite buffer layout might be outdated, e.g. from a discardReadBytes call.");
            }
            if (i10 >= component.endOffset) {
                i12 = i13 + 1;
            } else {
                if (i10 >= component.offset) {
                    this.lastAccessed = component;
                    return component;
                }
                i11 = i13 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private static Component[] newCompArray(int i10, int i11) {
        return new Component[Math.max(i10, Math.min(16, i11))];
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    private Component newComponent(ByteBuf byteBuf, int i10) {
        int i11;
        int iIdx;
        ByteBuf byteBuf2;
        int i12 = byteBuf.readerIndex();
        int i13 = byteBuf.readableBytes();
        ByteBuf byteBufUnwrap = byteBuf;
        while (true) {
            if (!(byteBufUnwrap instanceof WrappedByteBuf) && !(byteBufUnwrap instanceof SwappedByteBuf)) {
                break;
            }
            byteBufUnwrap = byteBufUnwrap.unwrap();
        }
        if (!(byteBufUnwrap instanceof AbstractUnpooledSlicedByteBuf)) {
            if (byteBufUnwrap instanceof PooledSlicedByteBuf) {
                iIdx = ((PooledSlicedByteBuf) byteBufUnwrap).adjustment + i12;
                byteBufUnwrap = byteBufUnwrap.unwrap();
            } else {
                if ((byteBufUnwrap instanceof DuplicatedByteBuf) || (byteBufUnwrap instanceof PooledDuplicatedByteBuf)) {
                    byteBufUnwrap = byteBufUnwrap.unwrap();
                }
                i11 = i12;
            }
            if (byteBuf.capacity() == i13) {
                byteBuf2 = byteBuf;
            } else {
                byteBuf2 = null;
            }
            ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
            return new Component(byteBuf.order(byteOrder), i12, byteBufUnwrap.order(byteOrder), i11, i10, i13, byteBuf2);
        }
        iIdx = ((AbstractUnpooledSlicedByteBuf) byteBufUnwrap).idx(0) + i12;
        byteBufUnwrap = byteBufUnwrap.unwrap();
        i11 = iIdx;
        if (byteBuf.capacity() == i13) {
            byteBuf2 = byteBuf;
        } else {
            byteBuf2 = null;
        }
        ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
        return new Component(byteBuf.order(byteOrder2), i12, byteBufUnwrap.order(byteOrder2), i11, i10, i13, byteBuf2);
    }

    private void removeComp(int i10) {
        removeCompRange(i10, i10 + 1);
    }

    private void removeCompRange(int i10, int i11) {
        if (i10 >= i11) {
            return;
        }
        int i12 = this.componentCount;
        if (i11 < i12) {
            Component[] componentArr = this.components;
            System.arraycopy(componentArr, i11, componentArr, i10, i12 - i11);
        }
        int i13 = (i12 - i11) + i10;
        for (int i14 = i13; i14 < i12; i14++) {
            this.components[i14] = null;
        }
        this.componentCount = i13;
    }

    private void shiftComps(int i10, int i11) {
        Component[] componentArr;
        int i12 = this.componentCount;
        int i13 = i12 + i11;
        Component[] componentArr2 = this.components;
        if (i13 > componentArr2.length) {
            int iMax = Math.max((i12 >> 1) + i12, i13);
            if (i10 == i12) {
                componentArr = (Component[]) Arrays.copyOf(this.components, iMax, Component[].class);
            } else {
                Component[] componentArr3 = new Component[iMax];
                if (i10 > 0) {
                    System.arraycopy(this.components, 0, componentArr3, 0, i10);
                }
                if (i10 < i12) {
                    System.arraycopy(this.components, i10, componentArr3, i11 + i10, i12 - i10);
                }
                componentArr = componentArr3;
            }
            this.components = componentArr;
        } else if (i10 < i12) {
            System.arraycopy(componentArr2, i10, componentArr2, i11 + i10, i12 - i10);
        }
        this.componentCount = i13;
    }

    private int toComponentIndex0(int i10) {
        int i11 = this.componentCount;
        int i12 = 0;
        if (i10 == 0) {
            for (int i13 = 0; i13 < i11; i13++) {
                if (this.components[i13].endOffset > 0) {
                    return i13;
                }
            }
        }
        if (i11 <= 2) {
            return (i11 == 1 || i10 < this.components[0].endOffset) ? 0 : 1;
        }
        while (i12 <= i11) {
            int i14 = (i12 + i11) >>> 1;
            Component component = this.components[i14];
            if (i10 >= component.endOffset) {
                i12 = i14 + 1;
            } else {
                if (i10 >= component.offset) {
                    return i14;
                }
                i11 = i14 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private void updateComponentOffsets(int i10) {
        int i11 = this.componentCount;
        if (i11 <= i10) {
            return;
        }
        int i12 = i10 > 0 ? this.components[i10 - 1].endOffset : 0;
        while (i10 < i11) {
            Component component = this.components[i10];
            component.reposition(i12);
            i12 = component.endOffset;
            i10++;
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        return componentFindComponent0.buf.getByte(componentFindComponent0.idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 4 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getInt(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i10 + 2) & g2.f10190d) | ((_getShort(i10) & g2.f10190d) << 16);
        }
        return ((_getShort(i10 + 2) & g2.f10190d) << 16) | (_getShort(i10) & g2.f10190d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 4 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getIntLE(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i10 + 2) & g2.f10190d) << 16) | (_getShortLE(i10) & g2.f10190d);
        }
        return (_getShortLE(i10 + 2) & g2.f10190d) | ((_getShortLE(i10) & g2.f10190d) << 16);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 8 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getLong(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (((long) _getInt(i10 + 4)) & 4294967295L) | ((((long) _getInt(i10)) & 4294967295L) << 32);
        }
        return ((((long) _getInt(i10 + 4)) & 4294967295L) << 32) | (((long) _getInt(i10)) & 4294967295L);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 8 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getLongLE(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((((long) _getIntLE(i10 + 4)) & 4294967295L) << 32) | (((long) _getIntLE(i10)) & 4294967295L);
        }
        return (((long) _getIntLE(i10 + 4)) & 4294967295L) | ((((long) _getIntLE(i10)) & 4294967295L) << 32);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 2 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getShort(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i10 + 1) & 255) | ((_getByte(i10) & 255) << 8));
        }
        return (short) (((_getByte(i10 + 1) & 255) << 8) | (_getByte(i10) & 255));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 2 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getShortLE(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i10 + 1) & 255) << 8) | (_getByte(i10) & 255));
        }
        return (short) ((_getByte(i10 + 1) & 255) | ((_getByte(i10) & 255) << 8));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 3 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getUnsignedMedium(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i10 + 2) & 255) | ((_getShort(i10) & g2.f10190d) << 8);
        }
        return ((_getByte(i10 + 2) & 255) << 16) | (_getShort(i10) & g2.f10190d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 3 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getUnsignedMediumLE(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i10 + 2) & 255) << 16) | (_getShortLE(i10) & g2.f10190d);
        }
        return (_getByte(i10 + 2) & 255) | ((_getShortLE(i10) & g2.f10190d) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        componentFindComponent0.buf.setByte(componentFindComponent0.idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 4 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setInt(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i10, (short) (i11 >>> 16));
            _setShort(i10 + 2, (short) i11);
        } else {
            _setShort(i10, (short) i11);
            _setShort(i10 + 2, (short) (i11 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 4 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setIntLE(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i10, (short) i11);
            _setShortLE(i10 + 2, (short) (i11 >>> 16));
        } else {
            _setShortLE(i10, (short) (i11 >>> 16));
            _setShortLE(i10 + 2, (short) i11);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 8 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setLong(componentFindComponent0.idx(i10), j10);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setInt(i10, (int) (j10 >>> 32));
            _setInt(i10 + 4, (int) j10);
        } else {
            _setInt(i10, (int) j10);
            _setInt(i10 + 4, (int) (j10 >>> 32));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 8 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setLongLE(componentFindComponent0.idx(i10), j10);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setIntLE(i10, (int) j10);
            _setIntLE(i10 + 4, (int) (j10 >>> 32));
        } else {
            _setIntLE(i10, (int) (j10 >>> 32));
            _setIntLE(i10 + 4, (int) j10);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 3 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setMedium(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i10, (short) (i11 >> 8));
            _setByte(i10 + 2, (byte) i11);
        } else {
            _setShort(i10, (short) i11);
            _setByte(i10 + 2, (byte) (i11 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 3 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setMediumLE(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i10, (short) i11);
            _setByte(i10 + 2, (byte) (i11 >>> 16));
        } else {
            _setShortLE(i10, (short) (i11 >> 8));
            _setByte(i10 + 2, (byte) i11);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 2 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setShort(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i10, (byte) (i11 >>> 8));
            _setByte(i10 + 1, (byte) i11);
        } else {
            _setByte(i10, (byte) i11);
            _setByte(i10 + 1, (byte) (i11 >>> 8));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 2 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setShortLE(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i10, (byte) i11);
            _setByte(i10 + 1, (byte) (i11 >>> 8));
        } else {
            _setByte(i10, (byte) (i11 >>> 8));
            _setByte(i10 + 1, (byte) i11);
        }
    }

    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        return addComponent(false, byteBuf);
    }

    public CompositeByteBuf addComponents(ByteBuf... byteBufArr) {
        return addComponents(false, byteBufArr);
    }

    public CompositeByteBuf addFlattenedComponents(boolean z10, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        int i10 = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex();
        if (i10 == iWriterIndex) {
            byteBuf.release();
            return this;
        }
        if (!(byteBuf instanceof CompositeByteBuf)) {
            addComponent0(z10, this.componentCount, byteBuf);
            consolidateIfNeeded();
            return this;
        }
        CompositeByteBuf compositeByteBuf = byteBuf instanceof WrappedCompositeByteBuf ? (CompositeByteBuf) byteBuf.unwrap() : (CompositeByteBuf) byteBuf;
        int i11 = iWriterIndex - i10;
        compositeByteBuf.checkIndex(i10, i11);
        Component[] componentArr = compositeByteBuf.components;
        int i12 = this.componentCount;
        int i13 = this.writerIndex;
        try {
            int componentIndex0 = compositeByteBuf.toComponentIndex0(i10);
            int iCapacity = capacity();
            while (true) {
                Component component = componentArr[componentIndex0];
                int iMax = Math.max(i10, component.offset);
                int iMin = Math.min(iWriterIndex, component.endOffset);
                int i14 = iMin - iMax;
                if (i14 > 0) {
                    addComp(this.componentCount, new Component(component.srcBuf.retain(), component.srcIdx(iMax), component.buf, component.idx(iMax), iCapacity, i14, null));
                }
                if (iWriterIndex == iMin) {
                    break;
                }
                iCapacity += i14;
                componentIndex0++;
                i10 = i10;
                componentArr = componentArr;
            }
            if (z10) {
                this.writerIndex = i11 + i13;
            }
            consolidateIfNeeded();
            byteBuf.release();
            return this;
        } catch (Throwable th2) {
            if (z10) {
                this.writerIndex = i13;
            }
            for (int i15 = this.componentCount - 1; i15 >= i12; i15--) {
                this.components[i15].free();
                removeComp(i15);
            }
            throw th2;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (i10 == 1) {
            return this.components[0].buf.array();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return 0;
        }
        if (i10 != 1) {
            throw new UnsupportedOperationException();
        }
        Component component = this.components[0];
        return component.idx(component.buf.arrayOffset());
    }

    public ByteBuf component(int i10) {
        checkComponentIndex(i10);
        return this.components[i10].duplicate();
    }

    public ByteBuf componentAtOffset(int i10) {
        return findComponent(i10).duplicate();
    }

    public CompositeByteBuf consolidate() {
        ensureAccessible();
        consolidate0(0, this.componentCount);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        checkIndex(i10, i11);
        ByteBuf byteBufAllocBuffer = allocBuffer(i11);
        if (i11 != 0) {
            copyTo(i10, i11, toComponentIndex0(i10), byteBufAllocBuffer);
        }
        return byteBufAllocBuffer;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        if (this.freed) {
            return;
        }
        this.freed = true;
        int i10 = this.componentCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.components[i11].free();
        }
    }

    public List<ByteBuf> decompose(int i10, int i11) {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return Collections.emptyList();
        }
        int componentIndex0 = toComponentIndex0(i10);
        Component component = this.components[componentIndex0];
        ByteBuf byteBufSlice = component.srcBuf.slice(component.srcIdx(i10), Math.min(component.endOffset - i10, i11));
        int i12 = i11 - byteBufSlice.readableBytes();
        if (i12 == 0) {
            return Collections.singletonList(byteBufSlice);
        }
        ArrayList arrayList = new ArrayList(this.componentCount - componentIndex0);
        arrayList.add(byteBufSlice);
        do {
            componentIndex0++;
            Component component2 = this.components[componentIndex0];
            ByteBuf byteBufSlice2 = component2.srcBuf.slice(component2.srcIdx(component2.offset), Math.min(component2.length(), i12));
            i12 -= byteBufSlice2.readableBytes();
            arrayList.add(byteBufSlice2);
        } while (i12 > 0);
        return arrayList;
    }

    public CompositeByteBuf discardReadComponents() {
        ensureAccessible();
        int i10 = readerIndex();
        if (i10 == 0) {
            return this;
        }
        int iWriterIndex = writerIndex();
        if (i10 == iWriterIndex && iWriterIndex == capacity()) {
            int i11 = this.componentCount;
            for (int i12 = 0; i12 < i11; i12++) {
                this.components[i12].free();
            }
            this.lastAccessed = null;
            clearComps();
            setIndex(0, 0);
            adjustMarkers(i10);
            return this;
        }
        int i13 = this.componentCount;
        Component component = null;
        int i14 = 0;
        while (i14 < i13) {
            component = this.components[i14];
            if (component.endOffset > i10) {
                break;
            }
            component.free();
            i14++;
        }
        if (i14 == 0) {
            return this;
        }
        Component component2 = this.lastAccessed;
        if (component2 != null && component2.endOffset <= i10) {
            this.lastAccessed = null;
        }
        removeCompRange(0, i14);
        int i15 = component.offset;
        updateComponentOffsets(0);
        setIndex(i10 - i15, iWriterIndex - i15);
        adjustMarkers(i15);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int forEachByteAsc0(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        if (i11 <= i10) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = i11 - i10;
        while (i12 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int iIdx = component.idx(i10);
                int iMin = Math.min(i12, component.endOffset - i10);
                int iForEachByteAsc0 = byteBuf instanceof AbstractByteBuf ? ((AbstractByteBuf) byteBuf).forEachByteAsc0(iIdx, iIdx + iMin, byteProcessor) : byteBuf.forEachByte(iIdx, iMin, byteProcessor);
                if (iForEachByteAsc0 != -1) {
                    return iForEachByteAsc0 - component.adjustment;
                }
                i10 += iMin;
                i12 -= iMin;
            }
            componentIndex0++;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc0(int i10, int i11, ByteProcessor byteProcessor) throws Exception {
        if (i11 > i10) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = (i10 + 1) - i11;
        while (i12 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int iIdx = component.idx(i12 + i11);
                int iMin = Math.min(i12, iIdx);
                int i13 = iIdx - iMin;
                int iForEachByteDesc0 = byteBuf instanceof AbstractByteBuf ? ((AbstractByteBuf) byteBuf).forEachByteDesc0(iIdx - 1, i13, byteProcessor) : byteBuf.forEachByteDesc(i13, iMin, byteProcessor);
                if (iForEachByteDesc0 != -1) {
                    return iForEachByteDesc0 - component.adjustment;
                }
                i12 -= iMin;
            }
            componentIndex0--;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        Component componentFindComponent = findComponent(i10);
        return componentFindComponent.buf.getByte(componentFindComponent.idx(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        return this.components[0].buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (i10 != 1) {
            return false;
        }
        return this.components[0].buf.hasMemoryAddress();
    }

    public ByteBuf internalComponent(int i10) {
        checkComponentIndex(i10);
        return this.components[i10].slice();
    }

    public ByteBuf internalComponentAtOffset(int i10) {
        return findComponent(i10).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        int i12 = this.componentCount;
        if (i12 == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (i12 == 1) {
            return this.components[0].internalNioBuffer(i10, i11);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf
    public boolean isAccessible() {
        return !this.freed;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!this.components[i11].buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<ByteBuf> iterator() {
        ensureAccessible();
        return this.componentCount == 0 ? EMPTY_ITERATOR : new CompositeByteBufIterator();
    }

    public int maxNumComponents() {
        return this.maxNumComponents;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (i10 != 1) {
            throw new UnsupportedOperationException();
        }
        Component component = this.components[0];
        return component.buf.memoryAddress() + ((long) component.adjustment);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        int i12 = this.componentCount;
        if (i12 == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (i12 == 1) {
            Component component = this.components[0];
            ByteBuf byteBuf = component.buf;
            if (byteBuf.nioBufferCount() == 1) {
                return byteBuf.nioBuffer(component.idx(i10), i11);
            }
        }
        ByteBuffer[] byteBufferArrNioBuffers = nioBuffers(i10, i11);
        if (byteBufferArrNioBuffers.length == 1) {
            return byteBufferArrNioBuffers[0];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i11).order(order());
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            byteBufferOrder.put(byteBuffer);
        }
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return this.components[0].buf.nioBufferCount();
        }
        int iNioBufferCount = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iNioBufferCount += this.components[i11].buf.nioBufferCount();
        }
        return iNioBufferCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance(this.componentCount);
        try {
            int componentIndex0 = toComponentIndex0(i10);
            while (i11 > 0) {
                Component component = this.components[componentIndex0];
                ByteBuf byteBuf = component.buf;
                int iMin = Math.min(i11, component.endOffset - i10);
                int iNioBufferCount = byteBuf.nioBufferCount();
                if (iNioBufferCount == 0) {
                    throw new UnsupportedOperationException();
                }
                if (iNioBufferCount != 1) {
                    Collections.addAll(recyclableArrayListNewInstance, byteBuf.nioBuffers(component.idx(i10), iMin));
                } else {
                    recyclableArrayListNewInstance.add(byteBuf.nioBuffer(component.idx(i10), iMin));
                }
                i10 += iMin;
                i11 -= iMin;
                componentIndex0++;
            }
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) recyclableArrayListNewInstance.toArray(EmptyArrays.EMPTY_BYTE_BUFFERS);
            recyclableArrayListNewInstance.recycle();
            return byteBufferArr;
        } catch (Throwable th2) {
            recyclableArrayListNewInstance.recycle();
            throw th2;
        }
    }

    public int numComponents() {
        return this.componentCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    public CompositeByteBuf removeComponent(int i10) {
        checkComponentIndex(i10);
        Component component = this.components[i10];
        if (this.lastAccessed == component) {
            this.lastAccessed = null;
        }
        component.free();
        removeComp(i10);
        if (component.length() > 0) {
            updateComponentOffsets(i10);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int i10, int i11) {
        checkComponentIndex(i10, i11);
        if (i11 == 0) {
            return this;
        }
        int i12 = i11 + i10;
        boolean z10 = false;
        for (int i13 = i10; i13 < i12; i13++) {
            Component component = this.components[i13];
            if (component.length() > 0) {
                z10 = true;
            }
            if (this.lastAccessed == component) {
                this.lastAccessed = null;
            }
            component.free();
        }
        removeCompRange(i10, i12);
        if (z10) {
            updateComponentOffsets(i10);
        }
        return this;
    }

    public int toByteIndex(int i10) {
        checkComponentIndex(i10);
        return this.components[i10].offset;
    }

    public int toComponentIndex(int i10) {
        checkIndex(i10);
        return toComponentIndex0(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        return a.a(c.a(c0.b.a(super.toString(), 1, 0), ", components="), this.componentCount, ')');
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    public CompositeByteBuf addComponent(int i10, ByteBuf byteBuf) {
        return addComponent(false, i10, byteBuf);
    }

    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        return addComponents(false, iterable);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        int i10 = this.componentCount;
        if (i10 > 0) {
            return this.components[i10 - 1].endOffset;
        }
        return 0;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf clear() {
        super.clear();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        ensureAccessible();
        int i10 = readerIndex();
        if (i10 == 0) {
            return this;
        }
        int iWriterIndex = writerIndex();
        if (i10 == iWriterIndex && iWriterIndex == capacity()) {
            int i11 = this.componentCount;
            for (int i12 = 0; i12 < i11; i12++) {
                this.components[i12].free();
            }
            this.lastAccessed = null;
            clearComps();
            setIndex(0, 0);
            adjustMarkers(i10);
            return this;
        }
        int i13 = this.componentCount;
        Component component = null;
        int i14 = 0;
        while (i14 < i13) {
            component = this.components[i14];
            if (component.endOffset > i10) {
                break;
            }
            component.free();
            i14++;
        }
        int i15 = i10 - component.offset;
        component.offset = 0;
        component.endOffset -= i10;
        component.srcAdjustment += i10;
        component.adjustment += i10;
        ByteBuf byteBuf = component.slice;
        if (byteBuf != null) {
            component.slice = byteBuf.slice(i15, component.length());
        }
        Component component2 = this.lastAccessed;
        if (component2 != null && component2.endOffset <= i10) {
            this.lastAccessed = null;
        }
        removeCompRange(0, i14);
        updateComponentOffsets(0);
        setIndex(0, iWriterIndex - i10);
        adjustMarkers(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        return discardReadComponents();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i10) {
        super.ensureWritable(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markReaderIndex() {
        super.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markWriterIndex() {
        super.markWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readerIndex(int i10) {
        super.readerIndex(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetReaderIndex() {
        super.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetWriterIndex() {
        super.resetWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int i10, boolean z10) {
        return setByte(i10, z10 ? 1 : 0);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i10, int i11) {
        Component componentFindComponent = findComponent(i10);
        componentFindComponent.buf.setByte(componentFindComponent.idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int i10, int i11) {
        return setShort(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int i10, double d10) {
        return setLong(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int i10, float f10) {
        return setInt(i10, Float.floatToRawIntBits(f10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setIndex(int i10, int i11) {
        super.setIndex(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i10, long j10) {
        checkIndex(i10, 8);
        _setLong(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i10, int i11) {
        super.setZero(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i10) {
        super.skipBytes(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean z10) {
        writeByte(z10 ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i10) {
        ensureWritable0(1);
        int i11 = this.writerIndex;
        this.writerIndex = i11 + 1;
        _setByte(i11, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int i10) {
        super.writeShort(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double d10) {
        super.writeLong(Double.doubleToRawLongBits(d10));
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float f10) {
        super.writeInt(Float.floatToRawIntBits(f10));
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i10) {
        super.writeInt(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j10) {
        super.writeLong(j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i10) {
        super.writeMedium(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i10) {
        super.writeShort(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int i10) {
        super.writeZero(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writerIndex(int i10) {
        super.writerIndex(i10);
        return this;
    }

    public CompositeByteBuf addComponent(boolean z10, ByteBuf byteBuf) {
        return addComponent(z10, this.componentCount, byteBuf);
    }

    public CompositeByteBuf addComponents(boolean z10, ByteBuf... byteBufArr) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        addComponents0(z10, this.componentCount, byteBufArr, 0);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf consolidate(int i10, int i11) {
        checkComponentIndex(i10, i11);
        consolidate0(i10, i11);
        return this;
    }

    public CompositeByteBuf addComponent(boolean z10, int i10, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z10, i10, byteBuf);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i10) {
        checkNewCapacity(i10);
        int i11 = this.componentCount;
        int iCapacity = capacity();
        if (i10 > iCapacity) {
            int i12 = i10 - iCapacity;
            addComponent0(false, i11, allocBuffer(i12).setIndex(0, i12));
            if (this.componentCount >= this.maxNumComponents) {
                consolidateIfNeeded();
            }
        } else if (i10 < iCapacity) {
            this.lastAccessed = null;
            int i13 = i11 - 1;
            int i14 = iCapacity - i10;
            while (i13 >= 0) {
                Component component = this.components[i13];
                int length = component.length();
                if (i14 < length) {
                    component.endOffset -= i14;
                    ByteBuf byteBuf = component.slice;
                    if (byteBuf == null) {
                        break;
                    }
                    component.slice = byteBuf.slice(0, component.length());
                    break;
                }
                component.free();
                i14 -= length;
                i13--;
            }
            removeCompRange(i13 + 1, i11);
            if (readerIndex() > i10) {
                setIndex0(i10, i10);
            } else if (this.writerIndex > i10) {
                this.writerIndex = i10;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int i10) {
        super.retain(i10);
        return this;
    }

    private void checkComponentIndex(int i10, int i11) {
        ensureAccessible();
        if (i10 < 0 || i10 + i11 > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(this.componentCount)));
        }
    }

    public CompositeByteBuf addComponents(boolean z10, Iterable<ByteBuf> iterable) {
        return addComponents(z10, this.componentCount, iterable);
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        super.retain();
        return this;
    }

    public CompositeByteBuf addComponents(int i10, ByteBuf... byteBufArr) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        addComponents0(false, i10, byteBufArr, 0);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, bArr.length);
        if (i12 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i10);
        while (i12 > 0) {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i12, component.endOffset - i10);
            component.buf.setBytes(component.idx(i10), bArr, i11, iMin);
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            componentIndex0++;
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        super.writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        if (i12 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i10);
        while (i12 > 0) {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i12, component.endOffset - i10);
            component.buf.getBytes(component.idx(i10), bArr, i11, iMin);
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            componentIndex0++;
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        super.readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i10) {
        super.writeBytes(byteBuf, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i10) {
        super.readBytes(byteBuf, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        super.writeBytes(byteBuf, i10, i11);
        return this;
    }

    public CompositeByteBuf addComponents(int i10, Iterable<ByteBuf> iterable) {
        return addComponents(false, i10, iterable);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i10, int i11) {
        super.readBytes(byteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        super.writeBytes(bArr, 0, bArr.length);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CompositeByteBuf addComponents(boolean z10, int i10, Iterable<ByteBuf> iterable) {
        ByteBuf byteBuf;
        if (iterable instanceof ByteBuf) {
            return addComponent(z10, i10, (ByteBuf) iterable);
        }
        ObjectUtil.checkNotNull(iterable, "buffers");
        Iterator it = iterable.iterator();
        try {
            checkComponentIndex(i10);
            while (it.hasNext() && (byteBuf = (ByteBuf) it.next()) != null) {
                i10 = Math.min(addComponent0(z10, i10, byteBuf) + 1, this.componentCount);
            }
            while (it.hasNext()) {
                ReferenceCountUtil.safeRelease(it.next());
            }
            consolidateIfNeeded();
            return this;
        } catch (Throwable th2) {
            while (it.hasNext()) {
                ReferenceCountUtil.safeRelease(it.next());
            }
            throw th2;
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        super.readBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        super.writeBytes(bArr, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i10, int i11) {
        super.readBytes(bArr, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        checkIndex(i10, iRemaining);
        if (iRemaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i10);
        while (iRemaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int iMin = Math.min(iRemaining, component.endOffset - i10);
                byteBuffer.limit(byteBuffer.position() + iMin);
                component.buf.setBytes(component.idx(i10), byteBuffer);
                i10 += iMin;
                iRemaining -= iMin;
                componentIndex0++;
            } catch (Throwable th2) {
                byteBuffer.limit(iLimit);
                throw th2;
            }
        }
        byteBuffer.limit(iLimit);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        super.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        checkIndex(i10, iRemaining);
        if (iRemaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i10);
        while (iRemaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int iMin = Math.min(iRemaining, component.endOffset - i10);
                byteBuffer.limit(byteBuffer.position() + iMin);
                component.buf.getBytes(component.idx(i10), byteBuffer);
                i10 += iMin;
                iRemaining -= iMin;
                componentIndex0++;
            } catch (Throwable th2) {
                byteBuffer.limit(iLimit);
                throw th2;
            }
        }
        byteBuffer.limit(iLimit);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        super.readBytes(byteBuffer);
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10) {
        this(byteBufAllocator, z10, i10, 0);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream, int i10) throws IOException {
        super.readBytes(outputStream, i10);
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10, ByteBuf... byteBufArr) {
        this(byteBufAllocator, z10, i10, byteBufArr, 0);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(readerIndex(), readableBytes());
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10, ByteBuf[] byteBufArr, int i11) {
        this(byteBufAllocator, z10, i10, byteBufArr.length - i11);
        addComponents0(false, 0, byteBufArr, i11);
        consolidateIfNeeded();
        setIndex0(0, capacity());
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10, Iterable<ByteBuf> iterable) {
        this(byteBufAllocator, z10, i10, iterable instanceof Collection ? ((Collection) iterable).size() : 0);
        addComponents(false, 0, iterable);
        setIndex(0, capacity());
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, byteBuf.capacity());
        if (i12 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i10);
        while (i12 > 0) {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i12, component.endOffset - i10);
            component.buf.setBytes(component.idx(i10), byteBuf, i11, iMin);
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            componentIndex0++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (i12 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i10);
        while (i12 > 0) {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i12, component.endOffset - i10);
            component.buf.getBytes(component.idx(i10), byteBuf, i11, iMin);
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            componentIndex0++;
        }
        return this;
    }

    public <T> CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10, ByteWrapper<T> byteWrapper, T[] tArr, int i11) {
        this(byteBufAllocator, z10, i10, tArr.length - i11);
        addComponents0(false, 0, byteWrapper, tArr, i11);
        consolidateIfNeeded();
        setIndex(0, capacity());
    }

    private <T> int addComponents0(boolean z10, int i10, ByteWrapper<T> byteWrapper, T[] tArr, int i11) {
        int i12;
        checkComponentIndex(i10);
        int length = tArr.length;
        while (i11 < length) {
            T t10 = tArr[i11];
            if (t10 == null) {
                break;
            }
            if (!byteWrapper.isEmpty(t10) && (i10 = addComponent0(z10, i10, byteWrapper.wrap(t10)) + 1) > (i12 = this.componentCount)) {
                i10 = i12;
            }
            i11++;
        }
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e A[PHI: r1 r6 r8
      0x001e: PHI (r1v5 int) = (r1v1 int), (r1v2 int) binds: [B:8:0x001c, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r6v4 int) = (r6v1 int), (r6v2 int) binds: [B:8:0x001c, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r8v4 int) = (r8v1 int), (r8v2 int) binds: [B:8:0x001c, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return inputStream.read(EmptyArrays.EMPTY_BYTES);
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = 0;
        do {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i11, component.endOffset - i10);
            if (iMin != 0) {
                int bytes = component.buf.setBytes(component.idx(i10), inputStream, iMin);
                if (bytes >= 0) {
                    i10 += bytes;
                    i11 -= bytes;
                    i12 += bytes;
                    if (bytes == iMin) {
                        componentIndex0++;
                    }
                } else if (i12 == 0) {
                    return -1;
                }
            } else {
                componentIndex0++;
            }
        } while (i11 > 0);
        return i12;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Integer.MAX_VALUE);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = null;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i10, i11));
        }
        long jWrite = gatheringByteChannel.write(nioBuffers(i10, i11));
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i10, i11), j10);
        }
        ByteBuffer[] byteBufferArrNioBuffers = nioBuffers(i10, i11);
        long jWrite = 0;
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            jWrite += (long) fileChannel.write(byteBuffer, j10 + jWrite);
        }
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e A[PHI: r1 r6 r8
      0x001e: PHI (r1v5 int) = (r1v1 int), (r1v2 int) binds: [B:8:0x001c, B:18:0x0037] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r6v4 int) = (r6v1 int), (r6v2 int) binds: [B:8:0x001c, B:18:0x0037] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r8v4 int) = (r8v1 int), (r8v2 int) binds: [B:8:0x001c, B:18:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) throws IOException {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return scatteringByteChannel.read(EMPTY_NIO_BUFFER);
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = 0;
        do {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i11, component.endOffset - i10);
            if (iMin != 0) {
                int bytes = component.buf.setBytes(component.idx(i10), scatteringByteChannel, iMin);
                if (bytes == 0) {
                    break;
                }
                if (bytes >= 0) {
                    i10 += bytes;
                    i11 -= bytes;
                    i12 += bytes;
                    if (bytes == iMin) {
                        componentIndex0++;
                    }
                } else if (i12 == 0) {
                    return -1;
                }
            } else {
                componentIndex0++;
            }
        } while (i11 > 0);
        return i12;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i10);
        while (i11 > 0) {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i11, component.endOffset - i10);
            component.buf.getBytes(component.idx(i10), outputStream, iMin);
            i10 += iMin;
            i11 -= iMin;
            componentIndex0++;
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e A[PHI: r1 r11 r15
      0x001e: PHI (r1v5 int) = (r1v1 int), (r1v2 int) binds: [B:8:0x001c, B:18:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r11v4 int) = (r11v1 int), (r11v2 int) binds: [B:8:0x001c, B:18:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r15v4 int) = (r15v1 int), (r15v2 int) binds: [B:8:0x001c, B:18:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return fileChannel.read(EMPTY_NIO_BUFFER, j10);
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = 0;
        do {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i11, component.endOffset - i10);
            if (iMin != 0) {
                int bytes = component.buf.setBytes(component.idx(i10), fileChannel, j10 + ((long) i12), iMin);
                if (bytes == 0) {
                    break;
                }
                if (bytes >= 0) {
                    i10 += bytes;
                    i11 -= bytes;
                    i12 += bytes;
                    if (bytes == iMin) {
                        componentIndex0++;
                    }
                } else if (i12 == 0) {
                    return -1;
                }
            } else {
                componentIndex0++;
            }
        } while (i11 > 0);
        return i12;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, ByteBuf byteBuf) {
        return getBytes(i10, byteBuf, byteBuf.writableBytes());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, ByteBuf byteBuf, int i11) {
        getBytes(i10, byteBuf, byteBuf.writerIndex(), i11);
        byteBuf.writerIndex(byteBuf.writerIndex() + i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, byte[] bArr) {
        return getBytes(i10, bArr, 0, bArr.length);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, ByteBuf byteBuf) {
        super.setBytes(i10, byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, ByteBuf byteBuf, int i11) {
        super.setBytes(i10, byteBuf, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, byte[] bArr) {
        return setBytes(i10, bArr, 0, bArr.length);
    }
}
