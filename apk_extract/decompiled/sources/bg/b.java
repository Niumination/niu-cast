package bg;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f1313d;

    public b(c cVar, int i8, int i9) {
        this.f1313d = cVar;
        this.f1310a = i8;
        this.f1311b = i9;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i8) {
        int i9 = this.f1310a + i8;
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "index is negative: ").toString());
        }
        if (i9 < this.f1311b) {
            return this.f1313d.c(i9);
        }
        StringBuilder sbU = a1.a.u(i8, "index (", ") should be less than length (");
        sbU.append(length());
        sbU.append(')');
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CharSequence)) {
            return false;
        }
        CharSequence charSequence = (CharSequence) obj;
        if (charSequence.length() != length()) {
            return false;
        }
        int length = length();
        int i8 = 0;
        while (true) {
            c cVar = this.f1313d;
            if (i8 >= length) {
                cVar.getClass();
                return true;
            }
            if (cVar.c(this.f1310a + i8) != charSequence.charAt(i8)) {
                return false;
            }
            i8++;
        }
    }

    public final int hashCode() {
        String str = this.f1312c;
        if (str != null) {
            return str.hashCode();
        }
        int i8 = this.f1310a;
        int iC = 0;
        while (true) {
            c cVar = this.f1313d;
            if (i8 >= this.f1311b) {
                cVar.getClass();
                return iC;
            }
            iC = (iC * 31) + cVar.c(i8);
            i8++;
        }
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f1311b - this.f1310a;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i8, int i9) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "start is negative: ").toString());
        }
        if (i8 > i9) {
            throw new IllegalArgumentException(("start (" + i8 + ") should be less or equal to end (" + i9 + ')').toString());
        }
        int i10 = this.f1311b;
        int i11 = this.f1310a;
        if (i9 <= i10 - i11) {
            if (i8 == i9) {
                return "";
            }
            return new b(this.f1313d, i8 + i11, i11 + i9);
        }
        throw new IllegalArgumentException(("end should be less than length (" + length() + ')').toString());
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        String str = this.f1312c;
        if (str != null) {
            return str;
        }
        String string = this.f1313d.b(this.f1310a, this.f1311b).toString();
        this.f1312c = string;
        return string;
    }
}
