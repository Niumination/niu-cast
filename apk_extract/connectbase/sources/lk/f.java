package lk;

import ik.p0;
import java.util.ArrayList;
import java.util.Iterator;
import jn.p;
import kn.l0;
import kn.n0;
import kn.r;
import lm.d1;
import lm.l2;
import lm.y;
import nm.h0;
import nm.v0;
import nm.z;
import os.l;
import os.m;
import pl.n;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f10120a = '\t';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final lk.a<p0> f10121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final long[] f10122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final byte[] f10123d;

    public static final class a extends n0 implements jn.l<p0, Integer> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @l
        public final Integer invoke(@l p0 p0Var) {
            l0.p(p0Var, "it");
            return Integer.valueOf(p0Var.f8144a.length());
        }
    }

    @xm.f(c = "io.ktor.http.cio.internals.CharsKt", f = "Chars.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {133, 141}, m = "writeIntHex", n = {"$this$writeIntHex", "table", "current", "digits", "$this$writeIntHex", "table", "current", "digits"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
    public static final class c extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.q(null, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0054 A[PHI: r7
      0x0054: PHI (r7v2 long) = (r7v1 long), (r7v0 long) binds: [B:18:0x0062, B:13:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        long j10;
        lk.a.C0264a c0264a = lk.a.f10100b;
        p0.f8135b.getClass();
        f10121b = c0264a.b(p0.f8143j, a.INSTANCE, b.INSTANCE);
        tn.l lVar = new tn.l(0, 255, 1);
        ArrayList arrayList = new ArrayList(z.b0(lVar, 10));
        Iterator<Integer> it = lVar.iterator();
        while (it.hasNext()) {
            int iNextInt = ((v0) it).nextInt();
            if (48 > iNextInt || iNextInt >= 58) {
                long j11 = iNextInt;
                long j12 = 97;
                if (j11 < 97 || j11 > 102) {
                    j12 = 65;
                    if (j11 < 65 || j11 > 70) {
                        j10 = -1;
                    } else {
                        j10 = (j11 - j12) + ((long) 10);
                    }
                } else {
                    j10 = (j11 - j12) + ((long) 10);
                }
            } else {
                j10 = ((long) iNextInt) - 48;
            }
            arrayList.add(Long.valueOf(j10));
        }
        f10122c = h0.W5(arrayList);
        tn.l lVar2 = new tn.l(0, 15, 1);
        ArrayList arrayList2 = new ArrayList(z.b0(lVar2, 10));
        Iterator<Integer> it2 = lVar2.iterator();
        while (it2.hasNext()) {
            int iNextInt2 = ((v0) it2).nextInt();
            arrayList2.add(Byte.valueOf((byte) (iNextInt2 < 10 ? iNextInt2 + 48 : (char) (((char) (iNextInt2 + 97)) - '\n'))));
        }
        f10123d = h0.O5(arrayList2);
    }

    public static final boolean a(@l CharSequence charSequence, int i10, int i11, @l CharSequence charSequence2) {
        l0.p(charSequence, "<this>");
        l0.p(charSequence2, "other");
        if (i11 - i10 != charSequence2.length()) {
            return false;
        }
        int i12 = i10;
        while (i12 < i11) {
            int i13 = i12 + 1;
            int iCharAt = charSequence.charAt(i12);
            if (iCharAt <= 90 && 65 <= iCharAt) {
                iCharAt += 32;
            }
            int iCharAt2 = charSequence2.charAt(i12 - i10);
            if (iCharAt2 <= 90 && 65 <= iCharAt2) {
                iCharAt2 += 32;
            }
            if (iCharAt != iCharAt2) {
                return false;
            }
            i12 = i13;
        }
        return true;
    }

    public static /* synthetic */ boolean b(CharSequence charSequence, int i10, int i11, CharSequence charSequence2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = charSequence.length();
        }
        return a(charSequence, i10, i11, charSequence2);
    }

    @l
    public static final lk.a<p0> c() {
        return f10121b;
    }

    public static /* synthetic */ void d() {
    }

    @l
    public static final byte[] e() {
        return f10123d;
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void g() {
    }

    public static final int h(@l CharSequence charSequence, int i10, int i11) {
        l0.p(charSequence, "<this>");
        int i12 = 0;
        while (i10 < i11) {
            int i13 = i10 + 1;
            int iCharAt = charSequence.charAt(i10);
            if (iCharAt <= 90 && 65 <= iCharAt) {
                iCharAt += 32;
            }
            i12 = (i12 * 31) + iCharAt;
            i10 = i13;
        }
        return i12;
    }

    public static /* synthetic */ int i(CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = charSequence.length();
        }
        return h(charSequence, i10, i11);
    }

    public static final Void j(CharSequence charSequence, int i10) {
        throw new NumberFormatException("Invalid HEX number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i10));
    }

    public static final void k(CharSequence charSequence) {
        throw new NumberFormatException("Invalid number " + ((Object) charSequence) + ": too large for Long type");
    }

    public static final void l(CharSequence charSequence, int i10) {
        throw new NumberFormatException("Invalid number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i10) + " at position " + i10);
    }

    public static final long m(@l CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length > 19) {
            k(charSequence);
        }
        if (length == 19) {
            return n(charSequence);
        }
        int i10 = 0;
        long j10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            long jCharAt = ((long) charSequence.charAt(i10)) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                l(charSequence, i10);
            }
            j10 = (j10 << 3) + (j10 << 1) + jCharAt;
            i10 = i11;
        }
        return j10;
    }

    public static final long n(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        long j10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            long jCharAt = ((long) charSequence.charAt(i10)) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                l(charSequence, i10);
            }
            j10 = (j10 << 3) + (j10 << 1) + jCharAt;
            if (j10 < 0) {
                k(charSequence);
            }
            i10 = i11;
        }
        return j10;
    }

    public static final long o(@l CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        long[] jArr = f10122c;
        int length = charSequence.length();
        long j10 = 0;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            int iCharAt = charSequence.charAt(i10) & r.f9345c;
            long j11 = iCharAt < 255 ? jArr[iCharAt] : -1L;
            if (j11 == -1) {
                j(charSequence, i10);
                throw new y();
            }
            j10 = (j10 << 4) | j11;
            i10 = i11;
        }
        return j10;
    }

    public static final int p(int i10) {
        return (i10 > 90 || 65 > i10) ? i10 : i10 + 32;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final Object q(@l n nVar, int i10, @l um.d<? super l2> dVar) {
        c cVar;
        byte[] bArr;
        int i11;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i12 = cVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                cVar.label = i12 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = cVar.label;
        if (i13 != 0) {
            if (i13 != 1 && i13 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i14 = cVar.I$1;
            i10 = cVar.I$0;
            bArr = (byte[]) cVar.L$1;
            n nVar2 = (n) cVar.L$0;
            d1.n(obj);
            i11 = i14;
            nVar = nVar2;
            break;
        }
        d1.n(obj);
        if (i10 <= 0) {
            throw new IllegalArgumentException("Does only work for positive numbers");
        }
        bArr = f10123d;
        int i15 = 0;
        while (true) {
            i11 = i15 + 1;
            if (i15 >= 8) {
                break;
            }
            int i16 = i10 >>> 28;
            i10 <<= 4;
            if (i16 != 0) {
                byte b10 = bArr[i16];
                cVar.L$0 = nVar;
                cVar.L$1 = bArr;
                cVar.I$0 = i10;
                cVar.I$1 = i11;
                cVar.label = 1;
                if (nVar.H(b10, cVar) != aVar) {
                    break;
                }
                return aVar;
            }
            i15 = i11;
        }
        while (true) {
            int i17 = i11 + 1;
            if (i11 >= 8) {
                return l2.f10208a;
            }
            int i18 = i10 >>> 28;
            i10 <<= 4;
            byte b11 = bArr[i18];
            cVar.L$0 = nVar;
            cVar.L$1 = bArr;
            cVar.I$0 = i10;
            cVar.I$1 = i17;
            cVar.label = 2;
            if (nVar.H(b11, cVar) == aVar) {
                return aVar;
            }
            i11 = i17;
        }
    }

    public static final void r(@l tl.e eVar, int i10) throws tl.n0 {
        int i11;
        l0.p(eVar, "<this>");
        if (i10 <= 0) {
            throw new IllegalArgumentException("Does only work for positive numbers");
        }
        byte[] bArr = f10123d;
        int i12 = 0;
        while (true) {
            i11 = i12 + 1;
            if (i12 >= 8) {
                break;
            }
            int i13 = i10 >>> 28;
            i10 <<= 4;
            if (i13 != 0) {
                eVar.d1(bArr[i13]);
                break;
            }
            i12 = i11;
        }
        while (true) {
            int i14 = i11 + 1;
            if (i11 >= 8) {
                return;
            }
            int i15 = i10 >>> 28;
            i10 <<= 4;
            eVar.d1(bArr[i15]);
            i11 = i14;
        }
    }

    public static final class b extends n0 implements p<p0, Integer, Character> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @l
        public final Character invoke(@l p0 p0Var, int i10) {
            l0.p(p0Var, p6.m.f13003a);
            return Character.valueOf(p0Var.f8144a.charAt(i10));
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Character invoke(p0 p0Var, Integer num) {
            return invoke(p0Var, num.intValue());
        }
    }
}
