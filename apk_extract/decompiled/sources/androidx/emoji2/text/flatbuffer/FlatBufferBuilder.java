package androidx.emoji2.text.flatbuffer;

import h0.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    ByteBuffer f1136bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.buf.get() & UByte.MAX_VALUE;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i8);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i8) {
            return ByteBuffer.allocate(i8).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i8, ByteBufferFactory byteBufferFactory) {
        this(i8, byteBufferFactory, null, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int iCapacity = byteBuffer.capacity();
        if (((-1073741824) & iCapacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i8 = iCapacity == 0 ? 1 : iCapacity << 1;
        byteBuffer.position(0);
        ByteBuffer byteBufferNewByteBuffer = byteBufferFactory.newByteBuffer(i8);
        byteBufferNewByteBuffer.position(byteBufferNewByteBuffer.clear().capacity() - iCapacity);
        byteBufferNewByteBuffer.put(byteBuffer);
        return byteBufferNewByteBuffer;
    }

    public static boolean isFieldPresent(Table table, int i8) {
        return table.__offset(i8) != 0;
    }

    public void Nested(int i8) {
        if (i8 != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void addBoolean(boolean z2) {
        prep(1, 0);
        putBoolean(z2);
    }

    public void addByte(byte b9) {
        prep(1, 0);
        putByte(b9);
    }

    public void addDouble(double d7) {
        prep(8, 0);
        putDouble(d7);
    }

    public void addFloat(float f) {
        prep(4, 0);
        putFloat(f);
    }

    public void addInt(int i8) {
        prep(4, 0);
        putInt(i8);
    }

    public void addLong(long j8) {
        prep(8, 0);
        putLong(j8);
    }

    public void addOffset(int i8) {
        prep(4, 0);
        putInt((offset() - i8) + 4);
    }

    public void addShort(short s2) {
        prep(2, 0);
        putShort(s2);
    }

    public void addStruct(int i8, int i9, int i10) {
        if (i9 != i10) {
            Nested(i9);
            slot(i8);
        }
    }

    public void clear() {
        this.space = this.f1136bb.capacity();
        this.f1136bb.clear();
        this.minalign = 1;
        while (true) {
            int i8 = this.vtable_in_use;
            if (i8 <= 0) {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
            int[] iArr = this.vtable;
            int i9 = i8 - 1;
            this.vtable_in_use = i9;
            iArr[i9] = 0;
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - length;
        this.space = i8;
        byteBuffer.position(i8);
        this.f1136bb.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t3, int[] iArr) {
        t3.sortTables(iArr, this.f1136bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int iEncodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, iEncodedLength, 1);
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - iEncodedLength;
        this.space = i8;
        byteBuffer.position(i8);
        this.utf8.encodeUtf8(charSequence, this.f1136bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i8, int i9, int i10) {
        int i11 = i8 * i9;
        startVector(i8, i9, i10);
        ByteBuffer byteBuffer = this.f1136bb;
        int i12 = this.space - i11;
        this.space = i12;
        byteBuffer.position(i12);
        ByteBuffer byteBufferOrder = this.f1136bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i11);
        return byteBufferOrder;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f1136bb;
    }

    public int endTable() {
        int i8;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int iOffset = offset();
        int i9 = this.vtable_in_use - 1;
        while (i9 >= 0 && this.vtable[i9] == 0) {
            i9--;
        }
        for (int i10 = i9; i10 >= 0; i10--) {
            int i11 = this.vtable[i10];
            addShort((short) (i11 != 0 ? iOffset - i11 : 0));
        }
        addShort((short) (iOffset - this.object_start));
        addShort((short) ((i9 + 3) * 2));
        int i12 = 0;
        loop2: while (true) {
            if (i12 >= this.num_vtables) {
                i8 = 0;
                break;
            }
            int iCapacity = this.f1136bb.capacity() - this.vtables[i12];
            int i13 = this.space;
            short s2 = this.f1136bb.getShort(iCapacity);
            if (s2 == this.f1136bb.getShort(i13)) {
                int i14 = 2;
                while (true) {
                    if (i14 >= s2) {
                        i8 = this.vtables[i12];
                        break loop2;
                    }
                    if (this.f1136bb.getShort(iCapacity + i14) != this.f1136bb.getShort(i13 + i14)) {
                        break;
                    }
                    i14 += 2;
                }
            }
            i12++;
        }
        if (i8 != 0) {
            int iCapacity2 = this.f1136bb.capacity() - iOffset;
            this.space = iCapacity2;
            this.f1136bb.putInt(iCapacity2, i8 - iOffset);
        } else {
            int i15 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i15 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i15 * 2);
            }
            int[] iArr2 = this.vtables;
            int i16 = this.num_vtables;
            this.num_vtables = i16 + 1;
            iArr2[i16] = offset();
            ByteBuffer byteBuffer = this.f1136bb;
            byteBuffer.putInt(byteBuffer.capacity() - iOffset, offset() - iOffset);
        }
        this.nested = false;
        return iOffset;
    }

    public int endVector() {
        if (!this.nested) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public void finish(int i8, boolean z2) {
        prep(this.minalign, (z2 ? 4 : 0) + 4);
        addOffset(i8);
        if (z2) {
            addInt(this.f1136bb.capacity() - this.space);
        }
        this.f1136bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i8) {
        finish(i8, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z2) {
        this.force_defaults = z2;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.f1136bb = byteBuffer;
        byteBuffer.clear();
        this.f1136bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.f1136bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.f1136bb.capacity() - this.space;
    }

    public void pad(int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            ByteBuffer byteBuffer = this.f1136bb;
            int i10 = this.space - 1;
            this.space = i10;
            byteBuffer.put(i10, (byte) 0);
        }
    }

    public void prep(int i8, int i9) {
        if (i8 > this.minalign) {
            this.minalign = i8;
        }
        int i10 = ((~((this.f1136bb.capacity() - this.space) + i9)) + 1) & (i8 - 1);
        while (this.space < i10 + i8 + i9) {
            int iCapacity = this.f1136bb.capacity();
            ByteBuffer byteBuffer = this.f1136bb;
            ByteBuffer byteBufferGrowByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.f1136bb = byteBufferGrowByteBuffer;
            if (byteBuffer != byteBufferGrowByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space = (this.f1136bb.capacity() - iCapacity) + this.space;
        }
        pad(i10);
    }

    public void putBoolean(boolean z2) {
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - 1;
        this.space = i8;
        byteBuffer.put(i8, z2 ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b9) {
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - 1;
        this.space = i8;
        byteBuffer.put(i8, b9);
    }

    public void putDouble(double d7) {
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - 8;
        this.space = i8;
        byteBuffer.putDouble(i8, d7);
    }

    public void putFloat(float f) {
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - 4;
        this.space = i8;
        byteBuffer.putFloat(i8, f);
    }

    public void putInt(int i8) {
        ByteBuffer byteBuffer = this.f1136bb;
        int i9 = this.space - 4;
        this.space = i9;
        byteBuffer.putInt(i9, i8);
    }

    public void putLong(long j8) {
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - 8;
        this.space = i8;
        byteBuffer.putLong(i8, j8);
    }

    public void putShort(short s2) {
        ByteBuffer byteBuffer = this.f1136bb;
        int i8 = this.space - 2;
        this.space = i8;
        byteBuffer.putShort(i8, s2);
    }

    public void required(int i8, int i9) {
        int iCapacity = this.f1136bb.capacity() - i8;
        if (this.f1136bb.getShort((iCapacity - this.f1136bb.getInt(iCapacity)) + i9) == 0) {
            throw new AssertionError(a.h(i9, "FlatBuffers: field ", " must be set"));
        }
    }

    public byte[] sizedByteArray(int i8, int i9) {
        finished();
        byte[] bArr = new byte[i9];
        this.f1136bb.position(i8);
        this.f1136bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer byteBufferDuplicate = this.f1136bb.duplicate();
        byteBufferDuplicate.position(this.space);
        byteBufferDuplicate.limit(this.f1136bb.capacity());
        return new ByteBufferBackedInputStream(byteBufferDuplicate);
    }

    public void slot(int i8) {
        this.vtable[i8] = offset();
    }

    public void startTable(int i8) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i8) {
            this.vtable = new int[i8];
        }
        this.vtable_in_use = i8;
        Arrays.fill(this.vtable, 0, i8, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i8, int i9, int i10) {
        notNested();
        this.vector_num_elems = i9;
        int i11 = i8 * i9;
        prep(4, i11);
        prep(i10, i11);
        this.nested = true;
    }

    public FlatBufferBuilder(int i8, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i8 = i8 <= 0 ? 1 : i8;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.f1136bb = byteBuffer;
            byteBuffer.clear();
            this.f1136bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f1136bb = byteBufferFactory.newByteBuffer(i8);
        }
        this.utf8 = utf8;
        this.space = this.f1136bb.capacity();
    }

    public void addBoolean(int i8, boolean z2, boolean z3) {
        if (this.force_defaults || z2 != z3) {
            addBoolean(z2);
            slot(i8);
        }
    }

    public void addByte(int i8, byte b9, int i9) {
        if (this.force_defaults || b9 != i9) {
            addByte(b9);
            slot(i8);
        }
    }

    public void addDouble(int i8, double d7, double d10) {
        if (this.force_defaults || d7 != d10) {
            addDouble(d7);
            slot(i8);
        }
    }

    public void addFloat(int i8, float f, double d7) {
        if (this.force_defaults || f != d7) {
            addFloat(f);
            slot(i8);
        }
    }

    public void addInt(int i8, int i9, int i10) {
        if (this.force_defaults || i9 != i10) {
            addInt(i9);
            slot(i8);
        }
    }

    public void addLong(int i8, long j8, long j10) {
        if (this.force_defaults || j8 != j10) {
            addLong(j8);
            slot(i8);
        }
    }

    public void addShort(int i8, short s2, int i9) {
        if (this.force_defaults || s2 != i9) {
            addShort(s2);
            slot(i8);
        }
    }

    public void finishSizePrefixed(int i8, String str) {
        finish(i8, str, true);
    }

    public void addOffset(int i8, int i9, int i10) {
        if (this.force_defaults || i9 != i10) {
            addOffset(i9);
            slot(i8);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.f1136bb.capacity() - this.space);
    }

    public int createByteVector(byte[] bArr, int i8, int i9) {
        startVector(1, i9, 1);
        ByteBuffer byteBuffer = this.f1136bb;
        int i10 = this.space - i9;
        this.space = i10;
        byteBuffer.position(i10);
        this.f1136bb.put(bArr, i8, i9);
        return endVector();
    }

    public void finish(int i8) {
        finish(i8, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f1136bb;
        int i8 = this.space - iRemaining;
        this.space = i8;
        byteBuffer2.position(i8);
        this.f1136bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i8, String str, boolean z2) {
        prep(this.minalign, (z2 ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i9 = 3; i9 >= 0; i9--) {
                addByte((byte) str.charAt(i9));
            }
            finish(i8, z2);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f1136bb;
        int i8 = this.space - iRemaining;
        this.space = i8;
        byteBuffer2.position(i8);
        this.f1136bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i8, String str) {
        finish(i8, str, false);
    }

    public FlatBufferBuilder(int i8) {
        this(i8, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }
}
