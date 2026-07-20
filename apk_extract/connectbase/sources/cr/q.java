package cr;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends AbstractList<f> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f[] f3453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f3454b;

    public q(f[] fVarArr, int[] iArr) {
        this.f3453a = fVarArr;
        this.f3454b = iArr;
    }

    public static void a(long j10, c cVar, int i10, List<f> list, int i11, int i12, List<Integer> list2) {
        int iIntValue;
        int i13;
        int i14;
        int i15;
        if (i11 >= i12) {
            throw new AssertionError();
        }
        for (int i16 = i11; i16 < i12; i16++) {
            if (list.get(i16).size() < i10) {
                throw new AssertionError();
            }
        }
        f fVar = list.get(i11);
        f fVar2 = list.get(i12 - 1);
        if (i10 == fVar.size()) {
            int i17 = i11 + 1;
            i13 = i17;
            iIntValue = list2.get(i11).intValue();
            fVar = list.get(i17);
        } else {
            iIntValue = -1;
            i13 = i11;
        }
        if (fVar.getByte(i10) == fVar2.getByte(i10)) {
            int iMin = Math.min(fVar.size(), fVar2.size());
            int i18 = 0;
            for (int i19 = i10; i19 < iMin && fVar.getByte(i19) == fVar2.getByte(i19); i19++) {
                i18++;
            }
            long jC = 1 + j10 + ((long) c(cVar)) + 2 + ((long) i18);
            cVar.writeInt(-i18);
            cVar.writeInt(iIntValue);
            int i20 = i10;
            while (true) {
                i14 = i10 + i18;
                if (i20 >= i14) {
                    break;
                }
                cVar.writeInt(fVar.getByte(i20) & 255);
                i20++;
            }
            if (i13 + 1 == i12) {
                if (i14 != list.get(i13).size()) {
                    throw new AssertionError();
                }
                cVar.writeInt(list2.get(i13).intValue());
                return;
            } else {
                c cVar2 = new c();
                cVar.writeInt((int) ((((long) c(cVar2)) + jC) * (-1)));
                a(jC, cVar2, i14, list, i13, i12, list2);
                cVar.Z0(cVar2, cVar2.f3404b);
                return;
            }
        }
        int i21 = 1;
        for (int i22 = i13 + 1; i22 < i12; i22++) {
            if (list.get(i22 - 1).getByte(i10) != list.get(i22).getByte(i10)) {
                i21++;
            }
        }
        long jC2 = j10 + ((long) c(cVar)) + 2 + ((long) (i21 * 2));
        cVar.writeInt(i21);
        cVar.writeInt(iIntValue);
        for (int i23 = i13; i23 < i12; i23++) {
            byte b10 = list.get(i23).getByte(i10);
            if (i23 == i13 || b10 != list.get(i23 - 1).getByte(i10)) {
                cVar.writeInt(b10 & 255);
            }
        }
        c cVar3 = new c();
        int i24 = i13;
        while (i24 < i12) {
            byte b11 = list.get(i24).getByte(i10);
            int i25 = i24 + 1;
            int i26 = i25;
            while (true) {
                if (i26 >= i12) {
                    i15 = i12;
                    break;
                } else {
                    if (b11 != list.get(i26).getByte(i10)) {
                        i15 = i26;
                        break;
                    }
                    i26++;
                }
            }
            if (i25 == i15 && i10 + 1 == list.get(i24).size()) {
                cVar.writeInt(list2.get(i24).intValue());
            } else {
                cVar.writeInt((int) ((((long) c(cVar3)) + jC2) * (-1)));
                a(jC2, cVar3, i10 + 1, list, i24, i15, list2);
            }
            cVar3 = cVar3;
            i24 = i15;
        }
        c cVar4 = cVar3;
        cVar.Z0(cVar4, cVar4.f3404b);
    }

    public static int c(c cVar) {
        return (int) (cVar.f3404b / 4);
    }

    public static q e(f... fVarArr) {
        if (fVarArr.length == 0) {
            return new q(new f[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList2.add(-1);
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList2.set(Collections.binarySearch(arrayList, fVarArr[i11]), Integer.valueOf(i11));
        }
        if (((f) arrayList.get(0)).size() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i12 = 0;
        while (i12 < arrayList.size()) {
            f fVar = (f) arrayList.get(i12);
            int i13 = i12 + 1;
            int i14 = i13;
            while (i14 < arrayList.size()) {
                f fVar2 = (f) arrayList.get(i14);
                if (!fVar2.startsWith(fVar)) {
                    break;
                }
                if (fVar2.size() == fVar.size()) {
                    throw new IllegalArgumentException("duplicate option: " + fVar2);
                }
                if (((Integer) arrayList2.get(i14)).intValue() > ((Integer) arrayList2.get(i12)).intValue()) {
                    arrayList.remove(i14);
                    arrayList2.remove(i14);
                } else {
                    i14++;
                }
            }
            i12 = i13;
        }
        c cVar = new c();
        a(0L, cVar, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iC = c(cVar);
        int[] iArr = new int[iC];
        for (int i15 = 0; i15 < iC; i15++) {
            iArr[i15] = cVar.readInt();
        }
        if (cVar.b1()) {
            return new q((f[]) fVarArr.clone(), iArr);
        }
        throw new AssertionError();
    }

    public f b(int i10) {
        return this.f3453a[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        return this.f3453a[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3453a.length;
    }
}
