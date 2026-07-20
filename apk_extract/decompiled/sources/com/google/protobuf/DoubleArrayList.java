package com.google.protobuf;

import a1.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList(new double[0], 0, false);
    private double[] array;
    private int size;

    public DoubleArrayList() {
        this(new double[10], 0, true);
    }

    public static DoubleArrayList emptyList() {
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
    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i8 = doubleArrayList.size;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.size;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        double[] dArr = this.array;
        if (i10 > dArr.length) {
            this.array = Arrays.copyOf(dArr, i10);
        }
        System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
        this.size = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void addDouble(double d7) {
        ensureIsMutable();
        int i8 = this.size;
        double[] dArr = this.array;
        if (i8 == dArr.length) {
            double[] dArr2 = new double[((i8 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i8);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i9 = this.size;
        this.size = i9 + 1;
        dArr3[i9] = d7;
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
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int i8 = 0; i8 < this.size; i8++) {
            if (Double.doubleToLongBits(this.array[i8]) != Double.doubleToLongBits(dArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int i8) {
        ensureIndexInRange(i8);
        return this.array[i8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int i8 = 0; i8 < this.size; i8++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i8]));
        }
        return iHashLong;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.array[i8] == dDoubleValue) {
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
        double[] dArr = this.array;
        System.arraycopy(dArr, i9, dArr, i8, this.size - i9);
        this.size -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double setDouble(int i8, double d7) {
        ensureIsMutable();
        ensureIndexInRange(i8);
        double[] dArr = this.array;
        double d10 = dArr[i8];
        dArr[i8] = d7;
        return d10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private DoubleArrayList(double[] dArr, int i8, boolean z2) {
        super(z2);
        this.array = dArr;
        this.size = i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i8) {
        return Double.valueOf(getDouble(i8));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Double> mutableCopyWithCapacity2(int i8) {
        if (i8 >= this.size) {
            return new DoubleArrayList(Arrays.copyOf(this.array, i8), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double remove(int i8) {
        ensureIsMutable();
        ensureIndexInRange(i8);
        double[] dArr = this.array;
        double d7 = dArr[i8];
        int i9 = this.size;
        if (i8 < i9 - 1) {
            System.arraycopy(dArr, i8 + 1, dArr, i8, (i9 - i8) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d7);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double set(int i8, Double d7) {
        return Double.valueOf(setDouble(i8, d7.doubleValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Double d7) {
        addDouble(d7.doubleValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i8, Double d7) {
        addDouble(i8, d7.doubleValue());
    }

    private void addDouble(int i8, double d7) {
        int i9;
        ensureIsMutable();
        if (i8 >= 0 && i8 <= (i9 = this.size)) {
            double[] dArr = this.array;
            if (i9 < dArr.length) {
                System.arraycopy(dArr, i8, dArr, i8 + 1, i9 - i8);
            } else {
                double[] dArr2 = new double[((i9 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i8);
                System.arraycopy(this.array, i8, dArr2, i8 + 1, this.size - i8);
                this.array = dArr2;
            }
            this.array[i8] = d7;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i8));
    }
}
