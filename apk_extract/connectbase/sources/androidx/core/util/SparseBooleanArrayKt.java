package androidx.core.util;

import android.util.SparseBooleanArray;
import jn.a;
import jn.p;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import nm.t;
import nm.v0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSparseBooleanArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n77#1,4:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n*L\n73#1:97,4\n*E\n"})
public final class SparseBooleanArrayKt {
    public static final boolean contains(@l SparseBooleanArray sparseBooleanArray, int i10) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsKey(@l SparseBooleanArray sparseBooleanArray, int i10) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsValue(@l SparseBooleanArray sparseBooleanArray, boolean z10) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z10) >= 0;
    }

    public static final void forEach(@l SparseBooleanArray sparseBooleanArray, @l p<? super Integer, ? super Boolean, l2> pVar) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(pVar, f.f8937e);
        int size = sparseBooleanArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i10)), Boolean.valueOf(sparseBooleanArray.valueAt(i10)));
        }
    }

    public static final boolean getOrDefault(@l SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i10, z10);
    }

    public static final boolean getOrElse(@l SparseBooleanArray sparseBooleanArray, int i10, @l a<Boolean> aVar) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(aVar, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : aVar.invoke().booleanValue();
    }

    public static final int getSize(@l SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@l SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(@l SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    @l
    public static final v0 keyIterator(@l final SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return new v0() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // nm.v0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseBooleanArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @l
    public static final SparseBooleanArray plus(@l SparseBooleanArray sparseBooleanArray, @l SparseBooleanArray sparseBooleanArray2) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray2.size() + sparseBooleanArray.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(@l SparseBooleanArray sparseBooleanArray, @l SparseBooleanArray sparseBooleanArray2) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i10), sparseBooleanArray2.valueAt(i10));
        }
    }

    public static final boolean remove(@l SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        l0.p(sparseBooleanArray, "<this>");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || z10 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i10);
        return true;
    }

    public static final void set(@l SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        l0.p(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i10, z10);
    }

    @l
    public static final t valueIterator(@l final SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return new t() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // nm.t
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseBooleanArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
