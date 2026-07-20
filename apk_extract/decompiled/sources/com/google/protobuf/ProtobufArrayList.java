package com.google.protobuf;

import a1.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList<>(new Object[0], 0, false);
    private E[] array;
    private int size;

    public ProtobufArrayList() {
        this(new Object[10], 0, true);
    }

    private static <E> E[] createArray(int i8) {
        return (E[]) new Object[i8];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int i8) {
        if (i8 < 0 || i8 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i8));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i8) {
        StringBuilder sbU = a.u(i8, "Index:", ", Size:");
        sbU.append(this.size);
        return sbU.toString();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        ensureIsMutable();
        int i8 = this.size;
        E[] eArr = this.array;
        if (i8 == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((i8 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i9 = this.size;
        this.size = i9 + 1;
        eArr2[i9] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i8) {
        ensureIndexInRange(i8);
        return this.array[i8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i8) {
        ensureIsMutable();
        ensureIndexInRange(i8);
        E[] eArr = this.array;
        E e = eArr[i8];
        int i9 = this.size;
        if (i8 < i9 - 1) {
            System.arraycopy(eArr, i8 + 1, eArr, i8, (i9 - i8) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i8, E e) {
        ensureIsMutable();
        ensureIndexInRange(i8);
        E[] eArr = this.array;
        E e4 = eArr[i8];
        eArr[i8] = e;
        ((AbstractList) this).modCount++;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i8, boolean z2) {
        super(z2);
        this.array = eArr;
        this.size = i8;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public ProtobufArrayList<E> mutableCopyWithCapacity2(int i8) {
        if (i8 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i8), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i8, E e) {
        int i9;
        ensureIsMutable();
        if (i8 >= 0 && i8 <= (i9 = this.size)) {
            E[] eArr = this.array;
            if (i9 < eArr.length) {
                System.arraycopy(eArr, i8, eArr, i8 + 1, i9 - i8);
            } else {
                E[] eArr2 = (E[]) createArray(((i9 * 3) / 2) + 1);
                System.arraycopy(this.array, 0, eArr2, 0, i8);
                System.arraycopy(this.array, i8, eArr2, i8 + 1, this.size - i8);
                this.array = eArr2;
            }
            this.array[i8] = e;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i8));
    }
}
