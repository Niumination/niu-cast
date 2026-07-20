package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import jn.p;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import ln.a;
import nm.w0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n1#1,132:1\n104#1,4:133\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n98#1:133,4\n*E\n"})
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06161<T> implements Iterator<T>, a {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C06161(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        @b.a({"ClassVerificationFailure"})
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        @b.a({"ClassVerificationFailure"})
        public T next() {
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i10 = this.index;
            this.index = i10 + 1;
            return longSparseArray.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> boolean contains(@l LongSparseArray<T> longSparseArray, long j10) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j10) >= 0;
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> boolean containsKey(@l LongSparseArray<T> longSparseArray, long j10) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j10) >= 0;
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> boolean containsValue(@l LongSparseArray<T> longSparseArray, T t10) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t10) >= 0;
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> void forEach(@l LongSparseArray<T> longSparseArray, @l p<? super Long, ? super T, l2> pVar) {
        l0.p(longSparseArray, "<this>");
        l0.p(pVar, f.f8937e);
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i10)), longSparseArray.valueAt(i10));
        }
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> T getOrDefault(@l LongSparseArray<T> longSparseArray, long j10, T t10) {
        l0.p(longSparseArray, "<this>");
        T t11 = longSparseArray.get(j10);
        return t11 == null ? t10 : t11;
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> T getOrElse(@l LongSparseArray<T> longSparseArray, long j10, @l jn.a<? extends T> aVar) {
        l0.p(longSparseArray, "<this>");
        l0.p(aVar, "defaultValue");
        T t10 = longSparseArray.get(j10);
        return t10 == null ? aVar.invoke() : t10;
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> int getSize(@l LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> boolean isEmpty(@l LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> boolean isNotEmpty(@l LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    @l
    public static final <T> w0 keyIterator(@l final LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return new w0() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            @b.a({"ClassVerificationFailure"})
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // nm.w0
            @b.a({"ClassVerificationFailure"})
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return longSparseArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    @l
    public static final <T> LongSparseArray<T> plus(@l LongSparseArray<T> longSparseArray, @l LongSparseArray<T> longSparseArray2) {
        l0.p(longSparseArray, "<this>");
        l0.p(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@l LongSparseArray<T> longSparseArray, @l LongSparseArray<T> longSparseArray2) {
        l0.p(longSparseArray, "<this>");
        l0.p(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            longSparseArray.put(longSparseArray2.keyAt(i10), longSparseArray2.valueAt(i10));
        }
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> boolean remove(@l LongSparseArray<T> longSparseArray, long j10, T t10) {
        l0.p(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j10);
        if (iIndexOfKey < 0 || !l0.g(t10, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(16)
    @b.a({"ClassVerificationFailure"})
    public static final <T> void set(@l LongSparseArray<T> longSparseArray, long j10, T t10) {
        l0.p(longSparseArray, "<this>");
        longSparseArray.put(j10, t10);
    }

    @RequiresApi(16)
    @l
    public static final <T> Iterator<T> valueIterator(@l LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return new C06161(longSparseArray);
    }
}
