package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import b.a;
import jn.p;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import nm.v0;
import nm.w0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n103#1,4:127\n1#2:126\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n97#1:127,4\n*E\n"})
public final class SparseLongArrayKt {
    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final boolean contains(@l SparseLongArray sparseLongArray, int i10) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final boolean containsKey(@l SparseLongArray sparseLongArray, int i10) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final boolean containsValue(@l SparseLongArray sparseLongArray, long j10) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j10) >= 0;
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final void forEach(@l SparseLongArray sparseLongArray, @l p<? super Integer, ? super Long, l2> pVar) {
        l0.p(sparseLongArray, "<this>");
        l0.p(pVar, f.f8937e);
        int size = sparseLongArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.invoke(Integer.valueOf(sparseLongArray.keyAt(i10)), Long.valueOf(sparseLongArray.valueAt(i10)));
        }
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final long getOrDefault(@l SparseLongArray sparseLongArray, int i10, long j10) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.get(i10, j10);
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final long getOrElse(@l SparseLongArray sparseLongArray, int i10, @l jn.a<Long> aVar) {
        l0.p(sparseLongArray, "<this>");
        l0.p(aVar, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : aVar.invoke().longValue();
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final int getSize(@l SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final boolean isEmpty(@l SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final boolean isNotEmpty(@l SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    @l
    public static final v0 keyIterator(@l final SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return new v0() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // nm.v0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseLongArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    @l
    public static final SparseLongArray plus(@l SparseLongArray sparseLongArray, @l SparseLongArray sparseLongArray2) {
        l0.p(sparseLongArray, "<this>");
        l0.p(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final void putAll(@l SparseLongArray sparseLongArray, @l SparseLongArray sparseLongArray2) {
        l0.p(sparseLongArray, "<this>");
        l0.p(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i10), sparseLongArray2.valueAt(i10));
        }
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final boolean remove(@l SparseLongArray sparseLongArray, int i10, long j10) {
        l0.p(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || j10 != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    public static final void set(@l SparseLongArray sparseLongArray, int i10, long j10) {
        l0.p(sparseLongArray, "<this>");
        sparseLongArray.put(i10, j10);
    }

    @RequiresApi(18)
    @a({"ClassVerificationFailure"})
    @l
    public static final w0 valueIterator(@l final SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return new w0() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // nm.w0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseLongArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
