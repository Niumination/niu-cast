package io.netty.handler.codec.http2;

import h.b;

/* JADX INFO: loaded from: classes3.dex */
final class HpackDynamicTable {
    private long capacity = -1;
    int head;
    HpackHeaderField[] hpackHeaderFields;
    private long size;
    int tail;

    public HpackDynamicTable(long j10) {
        setCapacity(j10);
    }

    public void add(HpackHeaderField hpackHeaderField) {
        long j10;
        long size = hpackHeaderField.size();
        if (size > this.capacity) {
            clear();
            return;
        }
        while (true) {
            long j11 = this.capacity;
            j10 = this.size;
            if (j11 - j10 >= size) {
                break;
            } else {
                remove();
            }
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i10 = this.head;
        int i11 = i10 + 1;
        this.head = i11;
        hpackHeaderFieldArr[i10] = hpackHeaderField;
        this.size = j10 + size;
        if (i11 == hpackHeaderFieldArr.length) {
            this.head = 0;
        }
    }

    public long capacity() {
        return this.capacity;
    }

    public void clear() {
        while (true) {
            int i10 = this.tail;
            if (i10 == this.head) {
                this.head = 0;
                this.tail = 0;
                this.size = 0L;
                return;
            } else {
                HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
                int i11 = i10 + 1;
                this.tail = i11;
                hpackHeaderFieldArr[i10] = null;
                if (i11 == hpackHeaderFieldArr.length) {
                    this.tail = 0;
                }
            }
        }
    }

    public HpackHeaderField getEntry(int i10) {
        if (i10 <= 0 || i10 > length()) {
            StringBuilder sbA = b.a("Index ", i10, " out of bounds for length ");
            sbA.append(length());
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        int i11 = this.head - i10;
        if (i11 >= 0) {
            return this.hpackHeaderFields[i11];
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        return hpackHeaderFieldArr[i11 + hpackHeaderFieldArr.length];
    }

    public int length() {
        int i10 = this.head;
        int i11 = this.tail;
        return i10 < i11 ? (this.hpackHeaderFields.length - i11) + i10 : i10 - i11;
    }

    public HpackHeaderField remove() {
        HpackHeaderField hpackHeaderField = this.hpackHeaderFields[this.tail];
        if (hpackHeaderField == null) {
            return null;
        }
        this.size -= (long) hpackHeaderField.size();
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i10 = this.tail;
        int i11 = i10 + 1;
        this.tail = i11;
        hpackHeaderFieldArr[i10] = null;
        if (i11 == hpackHeaderFieldArr.length) {
            this.tail = 0;
        }
        return hpackHeaderField;
    }

    public void setCapacity(long j10) {
        if (j10 < 0 || j10 > 4294967295L) {
            throw new IllegalArgumentException(h0.b.a("capacity is invalid: ", j10));
        }
        if (this.capacity == j10) {
            return;
        }
        this.capacity = j10;
        if (j10 == 0) {
            clear();
        } else {
            while (this.size > j10) {
                remove();
            }
        }
        int i10 = (int) (j10 / 32);
        if (j10 % 32 != 0) {
            i10++;
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        if (hpackHeaderFieldArr == null || hpackHeaderFieldArr.length != i10) {
            HpackHeaderField[] hpackHeaderFieldArr2 = new HpackHeaderField[i10];
            int length = length();
            if (this.hpackHeaderFields != null) {
                int i11 = this.tail;
                for (int i12 = 0; i12 < length; i12++) {
                    HpackHeaderField[] hpackHeaderFieldArr3 = this.hpackHeaderFields;
                    int i13 = i11 + 1;
                    hpackHeaderFieldArr2[i12] = hpackHeaderFieldArr3[i11];
                    i11 = i13 == hpackHeaderFieldArr3.length ? 0 : i13;
                }
            }
            this.tail = 0;
            this.head = length;
            this.hpackHeaderFields = hpackHeaderFieldArr2;
        }
    }

    public long size() {
        return this.size;
    }
}
