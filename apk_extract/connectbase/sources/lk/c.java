package lk;

import fl.t0;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.w;
import lm.y;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class c implements CharSequence, Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final bm.h<char[]> f10106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public List<char[]> f10107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public char[] f10108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public String f10109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10112g;

    public final class a implements CharSequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m
        public String f10115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f10116d;

        public a(c cVar, int i10, int i11) {
            l0.p(cVar, "this$0");
            this.f10116d = cVar;
            this.f10113a = i10;
            this.f10114b = i11;
        }

        public char a(int i10) {
            int i11 = this.f10113a + i10;
            if (i10 < 0) {
                throw new IllegalArgumentException(l0.C("index is negative: ", Integer.valueOf(i10)).toString());
            }
            if (i11 < this.f10114b) {
                return this.f10116d.l(i11);
            }
            StringBuilder sbA = h.b.a("index (", i10, ") should be less than length (");
            sbA.append(c());
            sbA.append(')');
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        public final int b() {
            return this.f10114b;
        }

        public int c() {
            return this.f10114b - this.f10113a;
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int i10) {
            return a(i10);
        }

        public final int d() {
            return this.f10113a;
        }

        public boolean equals(@m Object obj) {
            if (!(obj instanceof CharSequence)) {
                return false;
            }
            CharSequence charSequence = (CharSequence) obj;
            if (charSequence.length() != c()) {
                return false;
            }
            return this.f10116d.q(this.f10113a, charSequence, 0, c());
        }

        public int hashCode() {
            String str = this.f10115c;
            Integer numValueOf = str == null ? null : Integer.valueOf(str.hashCode());
            return numValueOf == null ? this.f10116d.o(this.f10113a, this.f10114b) : numValueOf.intValue();
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return c();
        }

        @Override // java.lang.CharSequence
        @l
        public CharSequence subSequence(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException(l0.C("start is negative: ", Integer.valueOf(i10)).toString());
            }
            if (i10 > i11) {
                throw new IllegalArgumentException(("start (" + i10 + ") should be less or equal to end (" + i11 + ')').toString());
            }
            int i12 = this.f10114b;
            int i13 = this.f10113a;
            if (i11 <= i12 - i13) {
                return i10 == i11 ? "" : new a(this.f10116d, i10 + i13, i13 + i11);
            }
            throw new IllegalArgumentException(("end should be less than length (" + c() + ')').toString());
        }

        @Override // java.lang.CharSequence
        @l
        public String toString() {
            String str = this.f10115c;
            if (str != null) {
                return str;
            }
            String string = this.f10116d.h(this.f10113a, this.f10114b).toString();
            this.f10115c = string;
            return string;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // java.lang.Appendable
    @l
    public Appendable append(char c10) {
        char[] cArrP = p();
        char[] cArr = this.f10108c;
        l0.m(cArr);
        int length = cArr.length;
        int i10 = this.f10111f;
        cArrP[length - i10] = c10;
        this.f10109d = null;
        this.f10111f = i10 - 1;
        this.f10112g++;
        return this;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i10) {
        return k(i10);
    }

    public final char[] e() {
        List list;
        char[] cArrW0 = this.f10106a.W0();
        char[] cArr = this.f10108c;
        this.f10108c = cArrW0;
        this.f10111f = cArrW0.length;
        this.f10110e = false;
        if (cArr != null) {
            List<char[]> list2 = this.f10107b;
            if (list2 == null) {
                list = list2;
                ArrayList arrayList = new ArrayList();
                this.f10107b = arrayList;
                arrayList.add(cArr);
                list = arrayList;
            }
            list = list2;
            list.add(cArrW0);
        }
        return cArrW0;
    }

    public boolean equals(@m Object obj) {
        if (!(obj instanceof CharSequence)) {
            return false;
        }
        CharSequence charSequence = (CharSequence) obj;
        if (this.f10112g != charSequence.length()) {
            return false;
        }
        return q(0, charSequence, 0, this.f10112g);
    }

    public final char[] f(int i10) {
        List<char[]> list = this.f10107b;
        if (list != null) {
            char[] cArr = this.f10108c;
            l0.m(cArr);
            return list.get(i10 / cArr.length);
        }
        if (i10 >= 2048) {
            s(i10);
            throw new y();
        }
        char[] cArr2 = this.f10108c;
        if (cArr2 != null) {
            return cArr2;
        }
        s(i10);
        throw new y();
    }

    public final CharSequence h(int i10, int i11) {
        if (i10 == i11) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i11 - i10);
        for (int i12 = i10 - (i10 % 2048); i12 < i11; i12 += 2048) {
            char[] cArrF = f(i12);
            int iMin = Math.min(i11 - i12, 2048);
            for (int iMax = Math.max(0, i10 - i12); iMax < iMin; iMax++) {
                sb2.append(cArrF[iMax]);
            }
        }
        return sb2;
    }

    public int hashCode() {
        String str = this.f10109d;
        Integer numValueOf = str == null ? null : Integer.valueOf(str.hashCode());
        return numValueOf == null ? o(0, this.f10112g) : numValueOf.intValue();
    }

    public final int i() {
        char[] cArr = this.f10108c;
        l0.m(cArr);
        return cArr.length - this.f10111f;
    }

    public char k(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(l0.C("index is negative: ", Integer.valueOf(i10)).toString());
        }
        if (i10 < this.f10112g) {
            return l(i10);
        }
        throw new IllegalArgumentException(u.a.a(h.b.a("index ", i10, " is not in range [0, "), this.f10112g, ')').toString());
    }

    public final char l(int i10) {
        char[] cArrF = f(i10);
        char[] cArr = this.f10108c;
        l0.m(cArr);
        return cArrF[i10 % cArr.length];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f10112g;
    }

    public int m() {
        return this.f10112g;
    }

    @l
    public final bm.h<char[]> n() {
        return this.f10106a;
    }

    public final int o(int i10, int i11) {
        int iL = 0;
        while (i10 < i11) {
            iL = (iL * 31) + l(i10);
            i10++;
        }
        return iL;
    }

    public final char[] p() {
        if (this.f10111f == 0) {
            return e();
        }
        char[] cArr = this.f10108c;
        l0.m(cArr);
        return cArr;
    }

    public final boolean q(int i10, CharSequence charSequence, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int i14 = i13 + 1;
            if (l(i10 + i13) != charSequence.charAt(i13 + i11)) {
                return false;
            }
            i13 = i14;
        }
        return true;
    }

    public final void r() {
        List<char[]> list = this.f10107b;
        if (list != null) {
            this.f10108c = null;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f10106a.recycle(list.get(i10));
            }
        } else {
            char[] cArr = this.f10108c;
            if (cArr != null) {
                this.f10106a.recycle(cArr);
            }
            this.f10108c = null;
        }
        this.f10110e = true;
        this.f10107b = null;
        this.f10109d = null;
        this.f10112g = 0;
        this.f10111f = 0;
    }

    public final Void s(int i10) {
        if (this.f10110e) {
            throw new IllegalStateException("Buffer is already released");
        }
        throw new IndexOutOfBoundsException(i10 + " is not in range [0; " + i() + ')');
    }

    @Override // java.lang.CharSequence
    @l
    public CharSequence subSequence(int i10, int i11) {
        if (i10 <= i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException(l0.C("startIndex is negative: ", Integer.valueOf(i10)).toString());
            }
            if (i11 <= this.f10112g) {
                return new a(this, i10, i11);
            }
            throw new IllegalArgumentException(u.a.a(h.b.a("endIndex (", i11, ") is greater than length ("), this.f10112g, ')').toString());
        }
        throw new IllegalArgumentException(("startIndex (" + i10 + ") should be less or equal to endIndex (" + i11 + ')').toString());
    }

    @Override // java.lang.CharSequence
    @l
    public String toString() {
        String str = this.f10109d;
        if (str != null) {
            return str;
        }
        String string = h(0, this.f10112g).toString();
        this.f10109d = string;
        return string;
    }

    public c(@l bm.h<char[]> hVar) {
        l0.p(hVar, "pool");
        this.f10106a = hVar;
    }

    public /* synthetic */ c(bm.h hVar, int i10, w wVar) {
        this((i10 & 1) != 0 ? d.a() : hVar);
    }

    @Override // java.lang.Appendable
    @l
    public Appendable append(@m CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            return this;
        }
        int i12 = i10;
        while (i12 < i11) {
            char[] cArrP = p();
            int length = cArrP.length;
            int i13 = this.f10111f;
            int i14 = length - i13;
            int iMin = Math.min(i11 - i12, i13);
            for (int i15 = 0; i15 < iMin; i15++) {
                cArrP[i14 + i15] = charSequence.charAt(i15 + i12);
            }
            i12 += iMin;
            this.f10111f -= iMin;
        }
        this.f10109d = null;
        this.f10112g = (i11 - i10) + this.f10112g;
        return this;
    }

    @Override // java.lang.Appendable
    @l
    public Appendable append(@m CharSequence charSequence) {
        return charSequence == null ? this : append(charSequence, 0, charSequence.length());
    }
}
