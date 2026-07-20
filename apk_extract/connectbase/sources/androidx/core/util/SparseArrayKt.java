package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import jn.p;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import ln.a;
import nm.v0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,94:1\n76#1,4:95\n*S KotlinDebug\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n72#1:95,4\n*E\n"})
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06171<T> implements Iterator<T>, a {
        final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        public C06171(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.$this_valueIterator;
            int i10 = this.index;
            this.index = i10 + 1;
            return sparseArray.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    public static final <T> boolean contains(@l SparseArray<T> sparseArray, int i10) {
        l0.p(sparseArray, "<this>");
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean containsKey(@l SparseArray<T> sparseArray, int i10) {
        l0.p(sparseArray, "<this>");
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean containsValue(@l SparseArray<T> sparseArray, T t10) {
        l0.p(sparseArray, "<this>");
        return sparseArray.indexOfValue(t10) >= 0;
    }

    public static final <T> void forEach(@l SparseArray<T> sparseArray, @l p<? super Integer, ? super T, l2> pVar) {
        l0.p(sparseArray, "<this>");
        l0.p(pVar, f.f8937e);
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i10)), sparseArray.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(@l SparseArray<T> sparseArray, int i10, T t10) {
        l0.p(sparseArray, "<this>");
        T t11 = sparseArray.get(i10);
        return t11 == null ? t10 : t11;
    }

    public static final <T> T getOrElse(@l SparseArray<T> sparseArray, int i10, @l jn.a<? extends T> aVar) {
        l0.p(sparseArray, "<this>");
        l0.p(aVar, "defaultValue");
        T t10 = sparseArray.get(i10);
        return t10 == null ? aVar.invoke() : t10;
    }

    public static final <T> int getSize(@l SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@l SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@l SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    @l
    public static final <T> v0 keyIterator(@l final SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return new v0() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // nm.v0
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @l
    public static final <T> SparseArray<T> plus(@l SparseArray<T> sparseArray, @l SparseArray<T> sparseArray2) {
        l0.p(sparseArray, "<this>");
        l0.p(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@l SparseArray<T> sparseArray, @l SparseArray<T> sparseArray2) {
        l0.p(sparseArray, "<this>");
        l0.p(sparseArray2, "other");
        int size = sparseArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(sparseArray2.keyAt(i10), sparseArray2.valueAt(i10));
        }
    }

    public static final <T> boolean remove(@l SparseArray<T> sparseArray, int i10, T t10) {
        l0.p(sparseArray, "<this>");
        int iIndexOfKey = sparseArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || !l0.g(t10, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(@l SparseArray<T> sparseArray, int i10, T t10) {
        l0.p(sparseArray, "<this>");
        sparseArray.put(i10, t10);
    }

    @l
    public static final <T> Iterator<T> valueIterator(@l SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return new C06171(sparseArray);
    }
}
