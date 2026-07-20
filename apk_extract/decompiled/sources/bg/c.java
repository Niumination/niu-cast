package bg;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements CharSequence, Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nh.d f1314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char[] f1316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1317d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1319i;

    public c() {
        nh.d pool = e.f1320a;
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.f1314a = pool;
    }

    public final char[] a(int i8) {
        ArrayList arrayList = this.f1315b;
        if (arrayList != null) {
            char[] cArr = this.f1316c;
            Intrinsics.checkNotNull(cArr);
            return (char[]) arrayList.get(i8 / cArr.length);
        }
        if (i8 >= 2048) {
            f(i8);
            throw null;
        }
        char[] cArr2 = this.f1316c;
        if (cArr2 != null) {
            return cArr2;
        }
        f(i8);
        throw null;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c9) {
        char[] cArrD = d();
        char[] cArr = this.f1316c;
        Intrinsics.checkNotNull(cArr);
        int length = cArr.length;
        int i8 = this.f1318h;
        cArrD[length - i8] = c9;
        this.f1317d = null;
        this.f1318h = i8 - 1;
        this.f1319i++;
        return this;
    }

    public final CharSequence b(int i8, int i9) {
        if (i8 == i9) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i9 - i8);
        for (int i10 = i8 - (i8 % 2048); i10 < i9; i10 += 2048) {
            char[] cArrA = a(i10);
            int iMin = Math.min(i9 - i10, 2048);
            for (int iMax = Math.max(0, i8 - i10); iMax < iMin; iMax++) {
                sb2.append(cArrA[iMax]);
            }
        }
        return sb2;
    }

    public final char c(int i8) {
        char[] cArrA = a(i8);
        char[] cArr = this.f1316c;
        Intrinsics.checkNotNull(cArr);
        return cArrA[i8 % cArr.length];
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "index is negative: ").toString());
        }
        if (i8 < this.f1319i) {
            return c(i8);
        }
        throw new IllegalArgumentException(a1.a.r(a1.a.u(i8, "index ", " is not in range [0, "), this.f1319i, ')').toString());
    }

    public final char[] d() {
        if (this.f1318h != 0) {
            char[] cArr = this.f1316c;
            Intrinsics.checkNotNull(cArr);
            return cArr;
        }
        char[] cArr2 = (char[]) this.f1314a.R();
        char[] cArr3 = this.f1316c;
        this.f1316c = cArr2;
        this.f1318h = cArr2.length;
        this.e = false;
        if (cArr3 == null) {
            return cArr2;
        }
        ArrayList arrayList = this.f1315b;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f1315b = arrayList;
            arrayList.add(cArr3);
        }
        arrayList.add(cArr2);
        return cArr2;
    }

    public final void e() {
        ArrayList arrayList = this.f1315b;
        nh.d dVar = this.f1314a;
        if (arrayList != null) {
            this.f1316c = null;
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                dVar.h0(arrayList.get(i8));
            }
        } else {
            char[] cArr = this.f1316c;
            if (cArr != null) {
                dVar.h0(cArr);
            }
            this.f1316c = null;
        }
        this.e = true;
        this.f1315b = null;
        this.f1317d = null;
        this.f1319i = 0;
        this.f1318h = 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CharSequence)) {
            return false;
        }
        CharSequence charSequence = (CharSequence) obj;
        if (this.f1319i != charSequence.length()) {
            return false;
        }
        int i8 = this.f1319i;
        for (int i9 = 0; i9 < i8; i9++) {
            if (c(i9) != charSequence.charAt(i9)) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i8) {
        if (this.e) {
            throw new IllegalStateException("Buffer is already released");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i8);
        sb2.append(" is not in range [0; ");
        char[] cArr = this.f1316c;
        Intrinsics.checkNotNull(cArr);
        sb2.append(cArr.length - this.f1318h);
        sb2.append(')');
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public final int hashCode() {
        String str = this.f1317d;
        if (str != null) {
            return str.hashCode();
        }
        int i8 = this.f1319i;
        int iC = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            iC = (iC * 31) + c(i9);
        }
        return iC;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f1319i;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i8, int i9) {
        if (i8 <= i9) {
            if (i8 < 0) {
                throw new IllegalArgumentException(a1.a.o(i8, "startIndex is negative: ").toString());
            }
            if (i9 <= this.f1319i) {
                return new b(this, i8, i9);
            }
            throw new IllegalArgumentException(a1.a.r(a1.a.u(i9, "endIndex (", ") is greater than length ("), this.f1319i, ')').toString());
        }
        throw new IllegalArgumentException(("startIndex (" + i8 + ") should be less or equal to endIndex (" + i9 + ')').toString());
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        String str = this.f1317d;
        if (str != null) {
            return str;
        }
        String string = b(0, this.f1319i).toString();
        this.f1317d = string;
        return string;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i8, int i9) {
        if (charSequence == null) {
            return this;
        }
        int i10 = i8;
        while (i10 < i9) {
            char[] cArrD = d();
            int length = cArrD.length;
            int i11 = this.f1318h;
            int i12 = length - i11;
            int iMin = Math.min(i9 - i10, i11);
            for (int i13 = 0; i13 < iMin; i13++) {
                cArrD[i12 + i13] = charSequence.charAt(i10 + i13);
            }
            i10 += iMin;
            this.f1318h -= iMin;
        }
        this.f1317d = null;
        this.f1319i = (i9 - i8) + this.f1319i;
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }
}
