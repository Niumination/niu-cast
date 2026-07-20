package io.netty.buffer;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class IntPriorityQueue {
    public static final int NO_VALUE = -1;
    private int[] array = new int[9];
    private int size;

    private void lift(int i10) {
        while (i10 > 1) {
            int i11 = i10 >> 1;
            if (!subord(i11, i10)) {
                return;
            }
            swap(i10, i11);
            i10 = i11;
        }
    }

    private void sink(int i10) {
        while (true) {
            int i11 = i10 << 1;
            int i12 = this.size;
            if (i11 > i12) {
                return;
            }
            if (i11 < i12) {
                int i13 = i11 + 1;
                if (subord(i11, i13)) {
                    i11 = i13;
                }
            }
            if (!subord(i10, i11)) {
                return;
            }
            swap(i10, i11);
            i10 = i11;
        }
    }

    private boolean subord(int i10, int i11) {
        int[] iArr = this.array;
        return iArr[i10] > iArr[i11];
    }

    private void swap(int i10, int i11) {
        int[] iArr = this.array;
        int i12 = iArr[i10];
        iArr[i10] = iArr[i11];
        iArr[i11] = i12;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void offer(int i10) {
        if (i10 == -1) {
            throw new IllegalArgumentException("The NO_VALUE (-1) cannot be added to the queue.");
        }
        int i11 = this.size + 1;
        this.size = i11;
        int[] iArr = this.array;
        if (i11 == iArr.length) {
            this.array = Arrays.copyOf(iArr, ((iArr.length - 1) * 2) + 1);
        }
        int[] iArr2 = this.array;
        int i12 = this.size;
        iArr2[i12] = i10;
        lift(i12);
    }

    public int peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.array[1];
    }

    public int poll() {
        int i10 = this.size;
        if (i10 == 0) {
            return -1;
        }
        int[] iArr = this.array;
        int i11 = iArr[1];
        iArr[1] = iArr[i10];
        iArr[i10] = 0;
        this.size = i10 - 1;
        sink(1);
        return i11;
    }

    public void remove(int i10) {
        int i11 = 1;
        while (true) {
            int i12 = this.size;
            if (i11 > i12) {
                return;
            }
            int[] iArr = this.array;
            if (iArr[i11] == i10) {
                this.size = i12 - 1;
                iArr[i11] = iArr[i12];
                lift(i11);
                sink(i11);
                return;
            }
            i11++;
        }
    }
}
