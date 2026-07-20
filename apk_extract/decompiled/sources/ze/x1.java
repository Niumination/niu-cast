package ze;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class x1 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1[] f11471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11472c;

    public x1(int i8, y1[] y1VarArr, int i9) {
        this.f11470a = i8;
        this.f11471b = y1VarArr;
        this.f11472c = i9;
    }

    public static x1 c(w1 w1Var, int i8, y1 y1Var, int i9, int i10) {
        int i11 = (i8 >>> i10) & 31;
        int i12 = 1 << i11;
        int i13 = (i9 >>> i10) & 31;
        int i14 = 1 << i13;
        y1 y1Var2 = w1Var;
        y1 y1Var3 = y1Var;
        if (i12 == i14) {
            x1 x1VarC = c(w1Var, i8, y1Var, i9, i10 + 5);
            return new x1(i12, new y1[]{x1VarC}, x1VarC.f11472c);
        }
        if (i11 > i13) {
            y1Var3 = w1Var;
            y1Var2 = y1Var;
        }
        return new x1(i12 | i14, new y1[]{y1Var2, y1Var3}, y1Var3.size() + y1Var2.size());
    }

    @Override // ze.y1
    public final Object a(sj.a aVar, int i8, int i9) {
        int i10 = 1 << ((i8 >>> i9) & 31);
        int i11 = this.f11470a;
        if ((i11 & i10) == 0) {
            return null;
        }
        return this.f11471b[Integer.bitCount((i10 - 1) & i11)].a(aVar, i8, i9 + 5);
    }

    @Override // ze.y1
    public final y1 b(sj.a aVar, Object obj, int i8, int i9) {
        int i10 = 1 << ((i8 >>> i9) & 31);
        int i11 = this.f11470a;
        int iBitCount = Integer.bitCount((i10 - 1) & i11);
        int i12 = i11 & i10;
        y1[] y1VarArr = this.f11471b;
        int i13 = this.f11472c;
        if (i12 != 0) {
            y1[] y1VarArr2 = (y1[]) Arrays.copyOf(y1VarArr, y1VarArr.length);
            y1 y1VarB = y1VarArr[iBitCount].b(aVar, obj, i8, i9 + 5);
            y1VarArr2[iBitCount] = y1VarB;
            return new x1(i11, y1VarArr2, (y1VarB.size() + i13) - y1VarArr[iBitCount].size());
        }
        int i14 = i11 | i10;
        y1[] y1VarArr3 = new y1[y1VarArr.length + 1];
        System.arraycopy(y1VarArr, 0, y1VarArr3, 0, iBitCount);
        y1VarArr3[iBitCount] = new w1(1, aVar, obj);
        System.arraycopy(y1VarArr, iBitCount, y1VarArr3, iBitCount + 1, y1VarArr.length - iBitCount);
        return new x1(i14, y1VarArr3, i13 + 1);
    }

    @Override // ze.y1
    public final int size() {
        return this.f11472c;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CompressedIndex(");
        sb2.append("bitmap=" + Integer.toBinaryString(this.f11470a) + " ");
        for (y1 y1Var : this.f11471b) {
            sb2.append(y1Var);
            sb2.append(" ");
        }
        sb2.append(")");
        return sb2.toString();
    }
}
