package io.netty.handler.codec;

import c.a;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class CodecOutputList extends AbstractList<Object> implements RandomAccess {
    private Object[] array;
    private boolean insertSinceRecycled;
    private final CodecOutputListRecycler recycler;
    private int size;
    private static final CodecOutputListRecycler NOOP_RECYCLER = new CodecOutputListRecycler() { // from class: io.netty.handler.codec.CodecOutputList.1
        @Override // io.netty.handler.codec.CodecOutputList.CodecOutputListRecycler
        public void recycle(CodecOutputList codecOutputList) {
        }
    };
    private static final FastThreadLocal<CodecOutputLists> CODEC_OUTPUT_LISTS_POOL = new FastThreadLocal<CodecOutputLists>() { // from class: io.netty.handler.codec.CodecOutputList.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public CodecOutputLists initialValue() throws Exception {
            return new CodecOutputLists(16);
        }
    };

    public interface CodecOutputListRecycler {
        void recycle(CodecOutputList codecOutputList);
    }

    public static final class CodecOutputLists implements CodecOutputListRecycler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int count;
        private int currentIdx;
        private final CodecOutputList[] elements;
        private final int mask;

        public CodecOutputLists(int i10) {
            this.elements = new CodecOutputList[MathUtil.safeFindNextPositivePowerOfTwo(i10)];
            int i11 = 0;
            while (true) {
                CodecOutputList[] codecOutputListArr = this.elements;
                if (i11 >= codecOutputListArr.length) {
                    this.count = codecOutputListArr.length;
                    this.currentIdx = codecOutputListArr.length;
                    this.mask = codecOutputListArr.length - 1;
                    return;
                }
                codecOutputListArr[i11] = new CodecOutputList(this, 16);
                i11++;
            }
        }

        public CodecOutputList getOrCreate() {
            int i10 = this.count;
            if (i10 == 0) {
                return new CodecOutputList(CodecOutputList.NOOP_RECYCLER, 4);
            }
            this.count = i10 - 1;
            int i11 = (this.currentIdx - 1) & this.mask;
            CodecOutputList codecOutputList = this.elements[i11];
            this.currentIdx = i11;
            return codecOutputList;
        }

        @Override // io.netty.handler.codec.CodecOutputList.CodecOutputListRecycler
        public void recycle(CodecOutputList codecOutputList) {
            int i10 = this.currentIdx;
            this.elements[i10] = codecOutputList;
            this.currentIdx = this.mask & (i10 + 1);
            this.count++;
        }
    }

    private void checkIndex(int i10) {
        if (i10 < this.size) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("expected: index < (");
        sb2.append(this.size);
        sb2.append("),but actual is (");
        throw new IndexOutOfBoundsException(a.a(sb2, this.size, ")"));
    }

    private void expandArray() {
        Object[] objArr = this.array;
        int length = objArr.length << 1;
        if (length < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        this.array = objArr2;
    }

    private void insert(int i10, Object obj) {
        this.array[i10] = obj;
        this.insertSinceRecycled = true;
    }

    public static CodecOutputList newInstance() {
        return CODEC_OUTPUT_LISTS_POOL.get().getOrCreate();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        try {
            insert(this.size, obj);
        } catch (IndexOutOfBoundsException unused) {
            expandArray();
            insert(this.size, obj);
        }
        this.size++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        checkIndex(i10);
        return this.array[i10];
    }

    public Object getUnsafe(int i10) {
        return this.array[i10];
    }

    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    public void recycle() {
        for (int i10 = 0; i10 < this.size; i10++) {
            this.array[i10] = null;
        }
        this.size = 0;
        this.insertSinceRecycled = false;
        this.recycler.recycle(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i10) {
        checkIndex(i10);
        Object[] objArr = this.array;
        Object obj = objArr[i10];
        int i11 = (this.size - i10) - 1;
        if (i11 > 0) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, i11);
        }
        Object[] objArr2 = this.array;
        int i12 = this.size - 1;
        this.size = i12;
        objArr2[i12] = null;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i10);
        Object obj2 = this.array[i10];
        insert(i10, obj);
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private CodecOutputList(CodecOutputListRecycler codecOutputListRecycler, int i10) {
        this.recycler = codecOutputListRecycler;
        this.array = new Object[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i10);
        if (this.size == this.array.length) {
            expandArray();
        }
        int i11 = this.size;
        if (i10 != i11) {
            Object[] objArr = this.array;
            System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
        }
        insert(i10, obj);
        this.size++;
    }
}
