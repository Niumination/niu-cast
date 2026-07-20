package k3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class tc {
    public static void a(long j8, qj.f fVar, int i8, List list, int i9, int i10, List list2) {
        int i11;
        int i12;
        int i13;
        int i14 = i8;
        if (i9 >= i10) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i15 = i9; i15 < i10; i15++) {
            if (((qj.j) list.get(i15)).size() < i14) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        qj.j jVar = (qj.j) list.get(i9);
        qj.j jVar2 = (qj.j) list.get(i10 - 1);
        int i16 = -1;
        if (i14 == jVar.size()) {
            int iIntValue = ((Number) list2.get(i9)).intValue();
            int i17 = i9 + 1;
            qj.j jVar3 = (qj.j) list.get(i17);
            i11 = i17;
            i12 = iIntValue;
            jVar = jVar3;
        } else {
            i11 = i9;
            i12 = -1;
        }
        if (jVar.getByte(i14) == jVar2.getByte(i14)) {
            int iMin = Math.min(jVar.size(), jVar2.size());
            int i18 = 0;
            for (int i19 = i14; i19 < iMin && jVar.getByte(i19) == jVar2.getByte(i19); i19++) {
                i18++;
            }
            long j10 = 4;
            long j11 = (fVar.f9195b / j10) + j8 + ((long) 2) + ((long) i18) + 1;
            fVar.b0(-i18);
            fVar.b0(i12);
            int i20 = i18 + i14;
            while (i14 < i20) {
                fVar.b0(jVar.getByte(i14) & 255);
                i14++;
            }
            if (i11 + 1 == i10) {
                if (i20 != ((qj.j) list.get(i11)).size()) {
                    throw new IllegalStateException("Check failed.");
                }
                fVar.b0(((Number) list2.get(i11)).intValue());
                return;
            } else {
                qj.f fVar2 = new qj.f();
                fVar.b0(((int) ((fVar2.f9195b / j10) + j11)) * (-1));
                a(j11, fVar2, i20, list, i11, i10, list2);
                fVar.N(fVar2);
                return;
            }
        }
        int i21 = 1;
        for (int i22 = i11 + 1; i22 < i10; i22++) {
            if (((qj.j) list.get(i22 - 1)).getByte(i14) != ((qj.j) list.get(i22)).getByte(i14)) {
                i21++;
            }
        }
        long j12 = 4;
        long j13 = (fVar.f9195b / j12) + j8 + ((long) 2) + ((long) (i21 * 2));
        fVar.b0(i21);
        fVar.b0(i12);
        for (int i23 = i11; i23 < i10; i23++) {
            int i24 = ((qj.j) list.get(i23)).getByte(i14);
            if (i23 == i11 || i24 != ((qj.j) list.get(i23 - 1)).getByte(i14)) {
                fVar.b0(i24 & 255);
            }
        }
        qj.f fVar3 = new qj.f();
        int i25 = i11;
        while (i25 < i10) {
            byte b9 = ((qj.j) list.get(i25)).getByte(i14);
            int i26 = i25 + 1;
            int i27 = i26;
            while (true) {
                if (i27 >= i10) {
                    i13 = i10;
                    break;
                } else {
                    if (b9 != ((qj.j) list.get(i27)).getByte(i14)) {
                        i13 = i27;
                        break;
                    }
                    i27++;
                }
            }
            if (i26 == i13 && i14 + 1 == ((qj.j) list.get(i25)).size()) {
                fVar.b0(((Number) list2.get(i25)).intValue());
            } else {
                fVar.b0(((int) ((fVar3.f9195b / j12) + j13)) * i16);
                a(j13, fVar3, i14 + 1, list, i25, i13, list2);
            }
            fVar3 = fVar3;
            i25 = i13;
            i16 = -1;
        }
        fVar.N(fVar3);
    }

    public static qj.p b(qj.j... byteStrings) {
        Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
        int i8 = 0;
        if (byteStrings.length == 0) {
            return new qj.p(new qj.j[0], new int[]{0, -1});
        }
        List mutableList = ArraysKt.toMutableList(byteStrings);
        CollectionsKt.sort(mutableList);
        ArrayList arrayList = new ArrayList(byteStrings.length);
        for (qj.j jVar : byteStrings) {
            arrayList.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
        List listMutableListOf = CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
        int length = byteStrings.length;
        int i9 = 0;
        int i10 = 0;
        while (i9 < length) {
            listMutableListOf.set(CollectionsKt__CollectionsKt.binarySearch$default(mutableList, byteStrings[i9], 0, 0, 6, (Object) null), Integer.valueOf(i10));
            i9++;
            i10++;
        }
        if (((qj.j) mutableList.get(0)).size() <= 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i11 = 0;
        while (i11 < mutableList.size()) {
            qj.j jVar2 = (qj.j) mutableList.get(i11);
            int i12 = i11 + 1;
            int i13 = i12;
            while (i13 < mutableList.size()) {
                qj.j jVar3 = (qj.j) mutableList.get(i13);
                if (!jVar3.startsWith(jVar2)) {
                    break;
                }
                if (jVar3.size() == jVar2.size()) {
                    throw new IllegalArgumentException(("duplicate option: " + jVar3).toString());
                }
                if (((Number) listMutableListOf.get(i13)).intValue() > ((Number) listMutableListOf.get(i11)).intValue()) {
                    mutableList.remove(i13);
                    listMutableListOf.remove(i13);
                } else {
                    i13++;
                }
            }
            i11 = i12;
        }
        qj.f fVar = new qj.f();
        a(0L, fVar, 0, mutableList, 0, mutableList.size(), listMutableListOf);
        int[] iArr = new int[(int) (fVar.f9195b / ((long) 4))];
        while (!fVar.T()) {
            iArr[i8] = fVar.readInt();
            i8++;
        }
        Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        return new qj.p((qj.j[]) objArrCopyOf, iArr);
    }
}
