package androidx.core.util;

import android.util.SparseIntArray;
import jn.a;
import jn.p;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import nm.v0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseIntArrayKt {
    public static final boolean contains(@l SparseIntArray sparseIntArray, int i10) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsKey(@l SparseIntArray sparseIntArray, int i10) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsValue(@l SparseIntArray sparseIntArray, int i10) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i10) >= 0;
    }

    public static final void forEach(@l SparseIntArray sparseIntArray, @l p<? super Integer, ? super Integer, l2> pVar) {
        l0.p(sparseIntArray, "<this>");
        l0.p(pVar, f.f8937e);
        int size = sparseIntArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i10)), Integer.valueOf(sparseIntArray.valueAt(i10)));
        }
    }

    public static final int getOrDefault(@l SparseIntArray sparseIntArray, int i10, int i11) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.get(i10, i11);
    }

    public static final int getOrElse(@l SparseIntArray sparseIntArray, int i10, @l a<Integer> aVar) {
        l0.p(sparseIntArray, "<this>");
        l0.p(aVar, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : aVar.invoke().intValue();
    }

    public static final int getSize(@l SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(@l SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(@l SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    @l
    public static final v0 keyIterator(@l final SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return new v0() { // from class: androidx.core.util.SparseIntArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // nm.v0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseIntArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @l
    public static final SparseIntArray plus(@l SparseIntArray sparseIntArray, @l SparseIntArray sparseIntArray2) {
        l0.p(sparseIntArray, "<this>");
        l0.p(sparseIntArray2, "other");
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray2.size() + sparseIntArray.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(@l SparseIntArray sparseIntArray, @l SparseIntArray sparseIntArray2) {
        l0.p(sparseIntArray, "<this>");
        l0.p(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i10), sparseIntArray2.valueAt(i10));
        }
    }

    public static final boolean remove(@l SparseIntArray sparseIntArray, int i10, int i11) {
        l0.p(sparseIntArray, "<this>");
        int iIndexOfKey = sparseIntArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || i11 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(@l SparseIntArray sparseIntArray, int i10, int i11) {
        l0.p(sparseIntArray, "<this>");
        sparseIntArray.put(i10, i11);
    }

    @l
    public static final v0 valueIterator(@l final SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return new v0() { // from class: androidx.core.util.SparseIntArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // nm.v0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseIntArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
