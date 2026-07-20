package com.google.protobuf;

import a1.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList(new boolean[0], 0, false);
    private boolean[] array;
    private int size;

    public BooleanArrayList() {
        this(new boolean[10], 0, true);
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
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

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i8 = booleanArrayList.size;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.size;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        boolean[] zArr = this.array;
        if (i10 > zArr.length) {
            this.array = Arrays.copyOf(zArr, i10);
        }
        System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
        this.size = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean z2) {
        ensureIsMutable();
        int i8 = this.size;
        boolean[] zArr = this.array;
        if (i8 == zArr.length) {
            boolean[] zArr2 = new boolean[((i8 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i8);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i9 = this.size;
        this.size = i9 + 1;
        zArr3[i9] = z2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i8 = 0; i8 < this.size; i8++) {
            if (this.array[i8] != zArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int i8) {
        ensureIndexInRange(i8);
        return this.array[i8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashBoolean = 1;
        for (int i8 = 0; i8 < this.size; i8++) {
            iHashBoolean = (iHashBoolean * 31) + Internal.hashBoolean(this.array[i8]);
        }
        return iHashBoolean;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.array[i8] == zBooleanValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i8, int i9) {
        ensureIsMutable();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.array;
        System.arraycopy(zArr, i9, zArr, i8, this.size - i9);
        this.size -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int i8, boolean z2) {
        ensureIsMutable();
        ensureIndexInRange(i8);
        boolean[] zArr = this.array;
        boolean z3 = zArr[i8];
        zArr[i8] = z2;
        return z3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private BooleanArrayList(boolean[] zArr, int i8, boolean z2) {
        super(z2);
        this.array = zArr;
        this.size = i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int i8) {
        return Boolean.valueOf(getBoolean(i8));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int i8) {
        if (i8 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, i8), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int i8) {
        ensureIsMutable();
        ensureIndexInRange(i8);
        boolean[] zArr = this.array;
        boolean z2 = zArr[i8];
        int i9 = this.size;
        if (i8 < i9 - 1) {
            System.arraycopy(zArr, i8 + 1, zArr, i8, (i9 - i8) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean set(int i8, Boolean bool) {
        return Boolean.valueOf(setBoolean(i8, bool.booleanValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i8, Boolean bool) {
        addBoolean(i8, bool.booleanValue());
    }

    private void addBoolean(int i8, boolean z2) {
        int i9;
        ensureIsMutable();
        if (i8 >= 0 && i8 <= (i9 = this.size)) {
            boolean[] zArr = this.array;
            if (i9 < zArr.length) {
                System.arraycopy(zArr, i8, zArr, i8 + 1, i9 - i8);
            } else {
                boolean[] zArr2 = new boolean[((i9 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i8);
                System.arraycopy(this.array, i8, zArr2, i8 + 1, this.size - i8);
                this.array = zArr2;
            }
            this.array[i8] = z2;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i8));
    }
}
