package jq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.r1;
import lm.a1;
import lm.f1;
import lm.p2;
import lm.s0;
import lm.t0;
import nm.v0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n79#1,22:1487\n113#1,5:1509\n130#1,5:1514\n79#1,22:1519\n107#1:1541\n79#1,22:1542\n113#1,5:1564\n124#1:1569\n113#1,5:1570\n130#1,5:1575\n141#1:1580\n130#1,5:1581\n79#1,22:1586\n113#1,5:1608\n130#1,5:1613\n12554#2,2:1618\n12554#2,2:1620\n288#3,2:1622\n288#3,2:1624\n1549#3:1627\n1620#3,3:1628\n1549#3:1631\n1620#3,3:1632\n1#4:1626\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n107#1:1487,22\n124#1:1509,5\n141#1:1514,5\n146#1:1519,22\n151#1:1541\n151#1:1542,22\n156#1:1564,5\n161#1:1569\n161#1:1570,5\n166#1:1575,5\n171#1:1580\n171#1:1581,5\n176#1:1586,22\n187#1:1608,5\n198#1:1613,5\n940#1:1618,2\n964#1:1620,2\n1003#1:1622,2\n1009#1:1624,2\n1309#1:1627\n1309#1:1628,3\n1334#1:1631\n1334#1:1632,3\n*E\n"})
public class h0 extends e0 {

    public static final class a extends nm.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f8820b;

        public a(CharSequence charSequence) {
            this.f8820b = charSequence;
        }

        @Override // nm.v
        public char c() {
            CharSequence charSequence = this.f8820b;
            int i10 = this.f8819a;
            this.f8819a = i10 + 1;
            return charSequence.charAt(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8819a < this.f8820b.length();
        }
    }

    @r1({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt$rangesDelimitedBy$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n1#2:1487\n*E\n"})
    public static final class b extends kn.n0 implements jn.p<CharSequence, Integer, t0<? extends Integer, ? extends Integer>> {
        final /* synthetic */ char[] $delimiters;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(char[] cArr, boolean z10) {
            super(2);
            this.$delimiters = cArr;
            this.$ignoreCase = z10;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ t0<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }

        @os.m
        public final t0<Integer, Integer> invoke(@os.l CharSequence charSequence, int i10) {
            kn.l0.p(charSequence, "$this$$receiver");
            int iR3 = h0.r3(charSequence, this.$delimiters, i10, this.$ignoreCase);
            if (iR3 < 0) {
                return null;
            }
            return new t0<>(Integer.valueOf(iR3), 1);
        }
    }

    @r1({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt$rangesDelimitedBy$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n1#2:1487\n*E\n"})
    public static final class c extends kn.n0 implements jn.p<CharSequence, Integer, t0<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List<String> $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List<String> list, boolean z10) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z10;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ t0<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }

        @os.m
        public final t0<Integer, Integer> invoke(@os.l CharSequence charSequence, int i10) {
            kn.l0.p(charSequence, "$this$$receiver");
            t0<Integer, String> t0VarB3 = h0.b3(charSequence, this.$delimitersList, i10, this.$ignoreCase, false);
            if (t0VarB3 != null) {
                return new t0<>(t0VarB3.getFirst(), Integer.valueOf(t0VarB3.getSecond().length()));
            }
            return null;
        }
    }

    public static final class d extends kn.n0 implements jn.l<tn.l, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l tn.l lVar) {
            kn.l0.p(lVar, "it");
            return h0.h5(this.$this_splitToSequence, lVar);
        }
    }

    public static final class e extends kn.n0 implements jn.l<tn.l, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l tn.l lVar) {
            kn.l0.p(lVar, "it");
            return h0.h5(this.$this_splitToSequence, lVar);
        }
    }

    public static final int A3(@os.l CharSequence charSequence, char c10, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? F3(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    @os.l
    public static final String A4(@os.l String str, @os.l String str2, @os.l String str3, @os.l String str4) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "replacement");
        kn.l0.p(str4, "missingDelimiterValue");
        int iD3 = D3(str, str2, 0, false, 6, null);
        return iD3 == -1 ? str4 : G4(str, 0, iD3, str3).toString();
    }

    @f1(version = "1.5")
    public static final boolean A5(@os.l String str) {
        kn.l0.p(str, "<this>");
        if (kn.l0.g(str, "true")) {
            return true;
        }
        if (kn.l0.g(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException(m.a.a("The string doesn't represent a boolean value: ", str));
    }

    public static final int B3(@os.l CharSequence charSequence, @os.l String str, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(str, "string");
        return (z10 || !(charSequence instanceof String)) ? m3(charSequence, str, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(str, i10);
    }

    public static /* synthetic */ String B4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return z4(str, c10, str2, str3);
    }

    @os.m
    @f1(version = "1.5")
    public static final Boolean B5(@os.l String str) {
        kn.l0.p(str, "<this>");
        if (kn.l0.g(str, "true")) {
            return Boolean.TRUE;
        }
        if (kn.l0.g(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int C3(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = g3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return A3(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ String C4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return A4(str, str2, str3, str4);
    }

    @os.l
    public static CharSequence C5(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zR = jq.d.r(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zR) {
                    break;
                }
                length--;
            } else if (zR) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static /* synthetic */ int D3(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = g3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return B3(charSequence, str, i10, z10);
    }

    @an.f
    public static final String D4(CharSequence charSequence, r rVar, String str) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        kn.l0.p(str, "replacement");
        return rVar.replaceFirst(charSequence, str);
    }

    @os.l
    public static final CharSequence D5(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zBooleanValue = ((Boolean) g0.a(charSequence, !z10 ? i10 : length, lVar)).booleanValue();
            if (z10) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final int E3(@os.l CharSequence charSequence, @os.l Collection<String> collection, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(collection, "strings");
        t0<Integer, String> t0VarB3 = b3(charSequence, collection, i10, z10, true);
        if (t0VarB3 != null) {
            return t0VarB3.getFirst().intValue();
        }
        return -1;
    }

    @s0
    @an.f
    @in.i(name = "replaceFirstCharWithChar")
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.5")
    public static final String E4(String str, jn.l<? super Character, Character> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "transform");
        if (str.length() <= 0) {
            return str;
        }
        char cCharValue = lVar.invoke(Character.valueOf(str.charAt(0))).charValue();
        String strSubstring = str.substring(1);
        kn.l0.o(strSubstring, "substring(...)");
        return cCharValue + strSubstring;
    }

    @os.l
    public static final CharSequence E5(@os.l CharSequence charSequence, @os.l char... cArr) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(cArr, "chars");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zN8 = nm.r.n8(cArr, charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zN8) {
                    break;
                }
                length--;
            } else if (zN8) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final int F3(@os.l CharSequence charSequence, @os.l char[] cArr, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(nm.r.Ws(cArr), i10);
        }
        int iG3 = g3(charSequence);
        if (i10 > iG3) {
            i10 = iG3;
        }
        while (-1 < i10) {
            char cCharAt = charSequence.charAt(i10);
            for (char c10 : cArr) {
                if (jq.e.J(c10, cCharAt, z10)) {
                    return i10;
                }
            }
            i10--;
        }
        return -1;
    }

    @s0
    @an.f
    @in.i(name = "replaceFirstCharWithCharSequence")
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.5")
    public static final String F4(String str, jn.l<? super Character, ? extends CharSequence> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "transform");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) lVar.invoke(Character.valueOf(str.charAt(0))));
        String strSubstring = str.substring(1);
        kn.l0.o(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        return sb2.toString();
    }

    @an.f
    public static final String F5(String str) {
        kn.l0.p(str, "<this>");
        return C5(str).toString();
    }

    public static /* synthetic */ int G3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = g3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return E3(charSequence, collection, i10, z10);
    }

    @os.l
    public static final CharSequence G4(@os.l CharSequence charSequence, int i10, int i11, @os.l CharSequence charSequence2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "replacement");
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(charSequence, 0, i10);
        kn.l0.o(sb2, "append(...)");
        sb2.append(charSequence2);
        sb2.append(charSequence, i11, charSequence.length());
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    @os.l
    public static final String G5(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zBooleanValue = lVar.invoke(Character.valueOf(str.charAt(!z10 ? i10 : length))).booleanValue();
            if (z10) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    public static /* synthetic */ int H3(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = g3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return F3(charSequence, cArr, i10, z10);
    }

    @os.l
    public static final CharSequence H4(@os.l CharSequence charSequence, @os.l tn.l lVar, @os.l CharSequence charSequence2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "range");
        kn.l0.p(charSequence2, "replacement");
        return G4(charSequence, lVar.f15911a, lVar.f15912b + 1, charSequence2);
    }

    @os.l
    public static final String H5(@os.l String str, @os.l char... cArr) {
        kn.l0.p(str, "<this>");
        kn.l0.p(cArr, "chars");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zN8 = nm.r.n8(cArr, str.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zN8) {
                    break;
                }
                length--;
            } else if (zN8) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    @os.l
    public static gq.m<String> I3(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return X4(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @an.f
    public static final String I4(String str, int i10, int i11, CharSequence charSequence) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charSequence, "replacement");
        return G4(str, i10, i11, charSequence).toString();
    }

    @os.l
    public static CharSequence I5(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!jq.d.r(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return "";
    }

    @os.l
    public static final List<String> J3(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return gq.v.c3(I3(charSequence));
    }

    @an.f
    public static final String J4(String str, tn.l lVar, CharSequence charSequence) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "range");
        kn.l0.p(charSequence, "replacement");
        return H4(str, lVar, charSequence).toString();
    }

    @os.l
    public static final CharSequence J5(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i10 = length - 1;
            if (!((Boolean) g0.a(charSequence, length, lVar)).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i10 < 0) {
                return "";
            }
            length = i10;
        }
    }

    @an.f
    public static final boolean K3(CharSequence charSequence, r rVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        return rVar.matches(charSequence);
    }

    public static final void K4(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(h.a.a("Limit must be non-negative, but was ", i10).toString());
        }
    }

    @os.l
    public static final CharSequence K5(@os.l CharSequence charSequence, @os.l char... cArr) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(cArr, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!nm.r.n8(cArr, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return "";
    }

    @os.l
    public static final String L2(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "other");
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i10 = 0;
        while (i10 < iMin && jq.e.J(charSequence.charAt(i10), charSequence2.charAt(i10), z10)) {
            i10++;
        }
        int i11 = i10 - 1;
        if (h3(charSequence, i11) || h3(charSequence2, i11)) {
            i10--;
        }
        return charSequence.subSequence(0, i10).toString();
    }

    @an.f
    public static final String L3(String str) {
        return str == null ? "" : str;
    }

    @an.f
    public static final List<String> L4(CharSequence charSequence, r rVar, int i10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        return rVar.split(charSequence, i10);
    }

    @an.f
    public static final String L5(String str) {
        kn.l0.p(str, "<this>");
        return I5(str).toString();
    }

    public static /* synthetic */ String M2(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return L2(charSequence, charSequence2, z10);
    }

    @os.l
    public static final CharSequence M3(@os.l CharSequence charSequence, int i10, char c10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Desired length ", i10, " is less than zero."));
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(charSequence);
        v0 v0VarI = new tn.l(1, i10 - charSequence.length(), 1).iterator();
        while (v0VarI.hasNext()) {
            v0VarI.nextInt();
            sb2.append(c10);
        }
        return sb2;
    }

    @os.l
    public static final List<String> M4(@os.l CharSequence charSequence, @os.l char[] cArr, boolean z10, int i10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(cArr, "delimiters");
        if (cArr.length == 1) {
            return O4(charSequence, String.valueOf(cArr[0]), z10, i10);
        }
        Iterable iterableN = gq.v.N(W3(charSequence, cArr, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(nm.z.b0(iterableN, 10));
        Iterator it = iterableN.iterator();
        while (it.hasNext()) {
            arrayList.add(h5(charSequence, (tn.l) it.next()));
        }
        return arrayList;
    }

    @os.l
    public static final String M5(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        CharSequence charSequenceSubSequence;
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i10 = length - 1;
            if (!lVar.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i10 < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i10;
        }
        return charSequenceSubSequence.toString();
    }

    @os.l
    public static final String N2(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "other");
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int iMin = Math.min(length, length2);
        int i10 = 0;
        while (i10 < iMin && jq.e.J(charSequence.charAt((length - i10) - 1), charSequence2.charAt((length2 - i10) - 1), z10)) {
            i10++;
        }
        if (h3(charSequence, (length - i10) - 1) || h3(charSequence2, (length2 - i10) - 1)) {
            i10--;
        }
        return charSequence.subSequence(length - i10, length).toString();
    }

    @os.l
    public static final String N3(@os.l String str, int i10, char c10) {
        kn.l0.p(str, "<this>");
        return M3(str, i10, c10).toString();
    }

    @os.l
    public static final List<String> N4(@os.l CharSequence charSequence, @os.l String[] strArr, boolean z10, int i10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return O4(charSequence, str, z10, i10);
            }
        }
        Iterable iterableN = gq.v.N(X3(charSequence, strArr, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(nm.z.b0(iterableN, 10));
        Iterator it = iterableN.iterator();
        while (it.hasNext()) {
            arrayList.add(h5(charSequence, (tn.l) it.next()));
        }
        return arrayList;
    }

    @os.l
    public static final String N5(@os.l String str, @os.l char... cArr) {
        CharSequence charSequenceSubSequence;
        kn.l0.p(str, "<this>");
        kn.l0.p(cArr, "chars");
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i10 = length - 1;
            if (!nm.r.n8(cArr, str.charAt(length))) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i10 < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i10;
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ String O2(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return N2(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ CharSequence O3(CharSequence charSequence, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = ' ';
        }
        return M3(charSequence, i10, c10);
    }

    public static final List<String> O4(CharSequence charSequence, String str, boolean z10, int i10) {
        K4(i10);
        int length = 0;
        int iL3 = l3(charSequence, str, 0, z10);
        if (iL3 == -1 || i10 == 1) {
            return nm.x.k(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        int i11 = 10;
        if (z11 && i10 <= 10) {
            i11 = i10;
        }
        ArrayList arrayList = new ArrayList(i11);
        do {
            arrayList.add(charSequence.subSequence(length, iL3).toString());
            length = str.length() + iL3;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iL3 = l3(charSequence, str, length, z10);
        } while (iL3 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    @os.l
    public static CharSequence O5(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!jq.d.r(charSequence.charAt(i10))) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean P2(@os.l CharSequence charSequence, char c10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        return o3(charSequence, c10, 0, z10, 2, null) >= 0;
    }

    public static /* synthetic */ String P3(String str, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = ' ';
        }
        return N3(str, i10, c10);
    }

    public static /* synthetic */ List P4(CharSequence charSequence, r rVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        return rVar.split(charSequence, i10);
    }

    @os.l
    public static final CharSequence P5(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        int iA = f0.a(charSequence, "<this>", lVar, "predicate");
        for (int i10 = 0; i10 < iA; i10++) {
            if (!((Boolean) g0.a(charSequence, i10, lVar)).booleanValue()) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    public static boolean Q2(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (p3(charSequence, (String) charSequence2, 0, z10, 2, null) < 0) {
                return false;
            }
        } else if (n3(charSequence, charSequence2, 0, charSequence.length(), z10, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    @os.l
    public static final CharSequence Q3(@os.l CharSequence charSequence, int i10, char c10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Desired length ", i10, " is less than zero."));
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        v0 v0VarI = new tn.l(1, i10 - charSequence.length(), 1).iterator();
        while (v0VarI.hasNext()) {
            v0VarI.nextInt();
            sb2.append(c10);
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static /* synthetic */ List Q4(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return M4(charSequence, cArr, z10, i10);
    }

    @os.l
    public static final CharSequence Q5(@os.l CharSequence charSequence, @os.l char... cArr) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(cArr, "chars");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!nm.r.n8(cArr, charSequence.charAt(i10))) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    @an.f
    public static final boolean R2(CharSequence charSequence, r rVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        return rVar.containsMatchIn(charSequence);
    }

    @os.l
    public static String R3(@os.l String str, int i10, char c10) {
        kn.l0.p(str, "<this>");
        return Q3(str, i10, c10).toString();
    }

    public static /* synthetic */ List R4(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return N4(charSequence, strArr, z10, i10);
    }

    @an.f
    public static final String R5(String str) {
        kn.l0.p(str, "<this>");
        return O5(str).toString();
    }

    public static /* synthetic */ boolean S2(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return P2(charSequence, c10, z10);
    }

    public static /* synthetic */ CharSequence S3(CharSequence charSequence, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = ' ';
        }
        return Q3(charSequence, i10, c10);
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final gq.m<String> S4(CharSequence charSequence, r rVar, int i10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        return rVar.splitToSequence(charSequence, i10);
    }

    @os.l
    public static final String S5(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        CharSequence charSequenceSubSequence;
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!lVar.invoke(Character.valueOf(str.charAt(i10))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(i10, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ boolean T2(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return Q2(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String T3(String str, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = ' ';
        }
        return R3(str, i10, c10);
    }

    @os.l
    public static final gq.m<String> T4(@os.l CharSequence charSequence, @os.l char[] cArr, boolean z10, int i10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(cArr, "delimiters");
        return gq.v.k1(W3(charSequence, cArr, 0, z10, i10, 2, null), new e(charSequence));
    }

    @os.l
    public static final String T5(@os.l String str, @os.l char... cArr) {
        CharSequence charSequenceSubSequence;
        kn.l0.p(str, "<this>");
        kn.l0.p(cArr, "chars");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!nm.r.n8(cArr, str.charAt(i10))) {
                charSequenceSubSequence = str.subSequence(i10, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static final boolean U2(@os.m CharSequence charSequence, @os.m CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return e0.K1((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!jq.e.J(charSequence.charAt(i10), charSequence2.charAt(i10), true)) {
                return false;
            }
        }
        return true;
    }

    public static final gq.m<tn.l> U3(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11) {
        K4(i11);
        return new h(charSequence, i10, i11, new b(cArr, z10));
    }

    @os.l
    public static final gq.m<String> U4(@os.l CharSequence charSequence, @os.l String[] strArr, boolean z10, int i10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(strArr, "delimiters");
        return gq.v.k1(X3(charSequence, strArr, 0, z10, i10, 2, null), new d(charSequence));
    }

    public static final boolean V2(@os.m CharSequence charSequence, @os.m CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return kn.l0.g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static final gq.m<tn.l> V3(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11) {
        K4(i11);
        return new h(charSequence, i10, i11, new c(nm.p.t(strArr), z10));
    }

    public static /* synthetic */ gq.m V4(CharSequence charSequence, r rVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        return rVar.splitToSequence(charSequence, i10);
    }

    public static final boolean W2(@os.l CharSequence charSequence, char c10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.length() > 0 && jq.e.J(charSequence.charAt(g3(charSequence)), c10, z10);
    }

    public static /* synthetic */ gq.m W3(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return U3(charSequence, cArr, i10, z10, i11);
    }

    public static /* synthetic */ gq.m W4(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return T4(charSequence, cArr, z10, i10);
    }

    public static final boolean X2(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "suffix");
        return (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? e0.J1((String) charSequence, (String) charSequence2, false, 2, null) : Y3(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z10);
    }

    public static /* synthetic */ gq.m X3(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return V3(charSequence, strArr, i10, z10, i11);
    }

    public static /* synthetic */ gq.m X4(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return U4(charSequence, strArr, z10, i10);
    }

    public static /* synthetic */ boolean Y2(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return W2(charSequence, c10, z10);
    }

    public static final boolean Y3(@os.l CharSequence charSequence, int i10, @os.l CharSequence charSequence2, int i11, int i12, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!jq.e.J(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean Y4(@os.l CharSequence charSequence, char c10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.length() > 0 && jq.e.J(charSequence.charAt(0), c10, z10);
    }

    public static /* synthetic */ boolean Z2(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return X2(charSequence, charSequence2, z10);
    }

    @os.l
    public static final CharSequence Z3(@os.l CharSequence charSequence, @os.l CharSequence charSequence2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "prefix");
        return d5(charSequence, charSequence2, false, 2, null) ? charSequence.subSequence(charSequence2.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static boolean Z4(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "prefix");
        return (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? e0.r2((String) charSequence, (String) charSequence2, i10, false, 4, null) : Y3(charSequence, i10, charSequence2, 0, charSequence2.length(), z10);
    }

    @os.m
    public static final t0<Integer, String> a3(@os.l CharSequence charSequence, @os.l Collection<String> collection, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(collection, "strings");
        return b3(charSequence, collection, i10, z10, false);
    }

    @os.l
    public static String a4(@os.l String str, @os.l CharSequence charSequence) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charSequence, "prefix");
        if (!d5(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean a5(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "prefix");
        return (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? e0.s2((String) charSequence, (String) charSequence2, false, 2, null) : Y3(charSequence, 0, charSequence2, 0, charSequence2.length(), z10);
    }

    public static final t0<Integer, String> b3(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        tn.j jVarK0;
        Object next;
        String str;
        Object next2;
        String str2;
        if (!z10 && collection.size() == 1) {
            String str3 = (String) nm.h0.f5(collection);
            int iP3 = !z11 ? p3(charSequence, str3, i10, false, 4, null) : D3(charSequence, str3, i10, false, 4, null);
            if (iP3 < 0) {
                return null;
            }
            return new t0<>(Integer.valueOf(iP3), str3);
        }
        if (z11) {
            int iG3 = g3(charSequence);
            if (i10 > iG3) {
                i10 = iG3;
            }
            jVarK0 = tn.u.k0(i10, 0);
        } else {
            if (i10 < 0) {
                i10 = 0;
            }
            jVarK0 = new tn.l(i10, charSequence.length(), 1);
        }
        if (charSequence instanceof String) {
            int i11 = jVarK0.f15911a;
            int i12 = jVarK0.f15912b;
            int i13 = jVarK0.f15913c;
            if ((i13 > 0 && i11 <= i12) || (i13 < 0 && i12 <= i11)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        str2 = (String) next2;
                    } while (!e0.b2(str2, 0, (String) charSequence, i11, str2.length(), z10));
                    String str4 = (String) next2;
                    if (str4 != null) {
                        return new t0<>(Integer.valueOf(i11), str4);
                    }
                    if (i11 != i12) {
                        i11 += i13;
                    }
                }
            }
        } else {
            int i14 = jVarK0.f15911a;
            int i15 = jVarK0.f15912b;
            int i16 = jVarK0.f15913c;
            if ((i16 > 0 && i14 <= i15) || (i16 < 0 && i15 <= i14)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        str = (String) next;
                    } while (!Y3(str, 0, charSequence, i14, str.length(), z10));
                    String str5 = (String) next;
                    if (str5 != null) {
                        return new t0<>(Integer.valueOf(i14), str5);
                    }
                    if (i14 != i15) {
                        i14 += i16;
                    }
                }
            }
        }
        return null;
    }

    @os.l
    public static final CharSequence b4(@os.l CharSequence charSequence, int i10, int i11) {
        kn.l0.p(charSequence, "<this>");
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
        }
        if (i11 == i10) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() - (i11 - i10));
        sb2.append(charSequence, 0, i10);
        kn.l0.o(sb2, "append(...)");
        sb2.append(charSequence, i11, charSequence.length());
        kn.l0.o(sb2, "append(...)");
        return sb2;
    }

    public static /* synthetic */ boolean b5(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return Y4(charSequence, c10, z10);
    }

    public static /* synthetic */ t0 c3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return a3(charSequence, collection, i10, z10);
    }

    @os.l
    public static final CharSequence c4(@os.l CharSequence charSequence, @os.l tn.l lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "range");
        return b4(charSequence, lVar.f15911a, lVar.f15912b + 1);
    }

    public static /* synthetic */ boolean c5(CharSequence charSequence, CharSequence charSequence2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return Z4(charSequence, charSequence2, i10, z10);
    }

    @os.m
    public static final t0<Integer, String> d3(@os.l CharSequence charSequence, @os.l Collection<String> collection, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(collection, "strings");
        return b3(charSequence, collection, i10, z10, true);
    }

    @an.f
    public static final String d4(String str, int i10, int i11) {
        kn.l0.p(str, "<this>");
        return b4(str, i10, i11).toString();
    }

    public static /* synthetic */ boolean d5(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return a5(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ t0 e3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = g3(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return d3(charSequence, collection, i10, z10);
    }

    @an.f
    public static final String e4(String str, tn.l lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "range");
        return c4(str, lVar).toString();
    }

    @os.l
    public static final CharSequence e5(@os.l CharSequence charSequence, @os.l tn.l lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "range");
        return charSequence.subSequence(lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static tn.l f3(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return new tn.l(0, charSequence.length() - 1, 1);
    }

    @os.l
    public static final CharSequence f4(@os.l CharSequence charSequence, @os.l CharSequence charSequence2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "suffix");
        return Z2(charSequence, charSequence2, false, 2, null) ? charSequence.subSequence(0, charSequence.length() - charSequence2.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @an.f
    @lm.k(message = "Use parameters named startIndex and endIndex.", replaceWith = @a1(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    public static final CharSequence f5(String str, int i10, int i11) {
        kn.l0.p(str, "<this>");
        return str.subSequence(i10, i11);
    }

    public static int g3(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    @os.l
    public static String g4(@os.l String str, @os.l CharSequence charSequence) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charSequence, "suffix");
        if (!Z2(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @an.f
    public static final String g5(CharSequence charSequence, int i10, int i11) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.subSequence(i10, i11).toString();
    }

    public static final boolean h3(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        return new tn.l(0, charSequence.length() + (-2), 1).l(i10) && Character.isHighSurrogate(charSequence.charAt(i10)) && Character.isLowSurrogate(charSequence.charAt(i10 + 1));
    }

    @os.l
    public static final CharSequence h4(@os.l CharSequence charSequence, @os.l CharSequence charSequence2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "delimiter");
        return i4(charSequence, charSequence2, charSequence2);
    }

    @os.l
    public static final String h5(@os.l CharSequence charSequence, @os.l tn.l lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "range");
        return charSequence.subSequence(lVar.f15911a, lVar.f15912b + 1).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @an.f
    public static final <C extends CharSequence & R, R> R i3(C c10, jn.a<? extends R> aVar) {
        kn.l0.p(aVar, "defaultValue");
        return e0.S1(c10) ? aVar.invoke() : c10;
    }

    @os.l
    public static final CharSequence i4(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "suffix");
        return (charSequence.length() >= charSequence3.length() + charSequence2.length() && d5(charSequence, charSequence2, false, 2, null) && Z2(charSequence, charSequence3, false, 2, null)) ? charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @os.l
    public static String i5(@os.l String str, @os.l tn.l lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "range");
        String strSubstring = str.substring(lVar.f15911a, lVar.f15912b + 1);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @an.f
    public static final <C extends CharSequence & R, R> R j3(C c10, jn.a<? extends R> aVar) {
        kn.l0.p(aVar, "defaultValue");
        return c10.length() == 0 ? aVar.invoke() : c10;
    }

    @os.l
    public static String j4(@os.l String str, @os.l CharSequence charSequence) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charSequence, "delimiter");
        return k4(str, charSequence, charSequence);
    }

    public static /* synthetic */ String j5(CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = charSequence.length();
        }
        kn.l0.p(charSequence, "<this>");
        return charSequence.subSequence(i10, i11).toString();
    }

    public static final int k3(@os.l CharSequence charSequence, char c10, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? r3(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    @os.l
    public static final String k4(@os.l String str, @os.l CharSequence charSequence, @os.l CharSequence charSequence2) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charSequence, "prefix");
        kn.l0.p(charSequence2, "suffix");
        if (str.length() < charSequence2.length() + charSequence.length() || !d5(str, charSequence, false, 2, null) || !Z2(str, charSequence2, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @os.l
    public static String k5(@os.l String str, char c10, @os.l String str2) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "missingDelimiterValue");
        int iO3 = o3(str, c10, 0, false, 6, null);
        if (iO3 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iO3 + 1, str.length());
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int l3(@os.l CharSequence charSequence, @os.l String str, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(str, "string");
        return (z10 || !(charSequence instanceof String)) ? n3(charSequence, str, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(str, i10);
    }

    @an.f
    public static final String l4(CharSequence charSequence, r rVar, String str) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        kn.l0.p(str, "replacement");
        return rVar.replace(charSequence, str);
    }

    @os.l
    public static String l5(@os.l String str, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "missingDelimiterValue");
        int iP3 = p3(str, str2, 0, false, 6, null);
        if (iP3 == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iP3, str.length());
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int m3(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        tn.j jVarK0;
        if (z11) {
            int iG3 = g3(charSequence);
            if (i10 > iG3) {
                i10 = iG3;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            jVarK0 = tn.u.k0(i10, i11);
        } else {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = charSequence.length();
            if (i11 > length) {
                i11 = length;
            }
            jVarK0 = new tn.l(i10, i11, 1);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int i12 = jVarK0.f15911a;
            int i13 = jVarK0.f15912b;
            int i14 = jVarK0.f15913c;
            if ((i14 <= 0 || i12 > i13) && (i14 >= 0 || i13 > i12)) {
                return -1;
            }
            while (!e0.b2((String) charSequence2, 0, (String) charSequence, i12, ((String) charSequence2).length(), z10)) {
                if (i12 == i13) {
                    return -1;
                }
                i12 += i14;
            }
            return i12;
        }
        int i15 = jVarK0.f15911a;
        int i16 = jVarK0.f15912b;
        int i17 = jVarK0.f15913c;
        if ((i17 <= 0 || i15 > i16) && (i17 >= 0 || i16 > i15)) {
            return -1;
        }
        while (!Y3(charSequence2, 0, charSequence, i15, charSequence2.length(), z10)) {
            if (i15 == i16) {
                return -1;
            }
            i15 += i17;
        }
        return i15;
    }

    @an.f
    public static final String m4(CharSequence charSequence, r rVar, jn.l<? super p, ? extends CharSequence> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(rVar, "regex");
        kn.l0.p(lVar, "transform");
        return rVar.replace(charSequence, lVar);
    }

    public static /* synthetic */ String m5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return k5(str, c10, str2);
    }

    public static /* synthetic */ int n3(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return m3(charSequence, charSequence2, i10, i11, z10, z11);
    }

    @os.l
    public static final String n4(@os.l String str, char c10, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "replacement");
        kn.l0.p(str3, "missingDelimiterValue");
        int iO3 = o3(str, c10, 0, false, 6, null);
        return iO3 == -1 ? str3 : G4(str, iO3 + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String n5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return l5(str, str2, str3);
    }

    public static /* synthetic */ int o3(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return k3(charSequence, c10, i10, z10);
    }

    @os.l
    public static final String o4(@os.l String str, @os.l String str2, @os.l String str3, @os.l String str4) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "replacement");
        kn.l0.p(str4, "missingDelimiterValue");
        int iP3 = p3(str, str2, 0, false, 6, null);
        return iP3 == -1 ? str4 : G4(str, str2.length() + iP3, str.length(), str3).toString();
    }

    @os.l
    public static String o5(@os.l String str, char c10, @os.l String str2) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "missingDelimiterValue");
        int iC3 = C3(str, c10, 0, false, 6, null);
        if (iC3 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iC3 + 1, str.length());
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ int p3(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return l3(charSequence, str, i10, z10);
    }

    public static /* synthetic */ String p4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return n4(str, c10, str2, str3);
    }

    @os.l
    public static String p5(@os.l String str, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "missingDelimiterValue");
        int iD3 = D3(str, str2, 0, false, 6, null);
        if (iD3 == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iD3, str.length());
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int q3(@os.l CharSequence charSequence, @os.l Collection<String> collection, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(collection, "strings");
        t0<Integer, String> t0VarB3 = b3(charSequence, collection, i10, z10, false);
        if (t0VarB3 != null) {
            return t0VarB3.getFirst().intValue();
        }
        return -1;
    }

    public static /* synthetic */ String q4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return o4(str, str2, str3, str4);
    }

    public static /* synthetic */ String q5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return o5(str, c10, str2);
    }

    public static final int r3(@os.l CharSequence charSequence, @os.l char[] cArr, int i10, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(nm.r.Ws(cArr), i10);
        }
        if (i10 < 0) {
            i10 = 0;
        }
        v0 v0VarI = new tn.l(i10, g3(charSequence), 1).iterator();
        while (v0VarI.hasNext()) {
            int iNextInt = v0VarI.nextInt();
            char cCharAt = charSequence.charAt(iNextInt);
            for (char c10 : cArr) {
                if (jq.e.J(c10, cCharAt, z10)) {
                    return iNextInt;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final String r4(@os.l String str, char c10, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "replacement");
        kn.l0.p(str3, "missingDelimiterValue");
        int iC3 = C3(str, c10, 0, false, 6, null);
        return iC3 == -1 ? str3 : G4(str, iC3 + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String r5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return p5(str, str2, str3);
    }

    public static /* synthetic */ int s3(CharSequence charSequence, Collection collection, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return q3(charSequence, collection, i10, z10);
    }

    @os.l
    public static final String s4(@os.l String str, @os.l String str2, @os.l String str3, @os.l String str4) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "replacement");
        kn.l0.p(str4, "missingDelimiterValue");
        int iD3 = D3(str, str2, 0, false, 6, null);
        return iD3 == -1 ? str4 : G4(str, str2.length() + iD3, str.length(), str3).toString();
    }

    @os.l
    public static String s5(@os.l String str, char c10, @os.l String str2) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "missingDelimiterValue");
        int iO3 = o3(str, c10, 0, false, 6, null);
        if (iO3 == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iO3);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ int t3(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return r3(charSequence, cArr, i10, z10);
    }

    public static /* synthetic */ String t4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return r4(str, c10, str2, str3);
    }

    @os.l
    public static final String t5(@os.l String str, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "missingDelimiterValue");
        int iP3 = p3(str, str2, 0, false, 6, null);
        if (iP3 == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iP3);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @an.f
    public static final boolean u3(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    public static /* synthetic */ String u4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return s4(str, str2, str3, str4);
    }

    public static /* synthetic */ String u5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return s5(str, c10, str2);
    }

    @an.f
    public static final boolean v3(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return !e0.S1(charSequence);
    }

    @os.l
    public static final String v4(@os.l String str, char c10, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "replacement");
        kn.l0.p(str3, "missingDelimiterValue");
        int iO3 = o3(str, c10, 0, false, 6, null);
        return iO3 == -1 ? str3 : G4(str, 0, iO3, str2).toString();
    }

    public static /* synthetic */ String v5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return t5(str, str2, str3);
    }

    @an.f
    public static final boolean w3(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    @os.l
    public static final String w4(@os.l String str, @os.l String str2, @os.l String str3, @os.l String str4) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "replacement");
        kn.l0.p(str4, "missingDelimiterValue");
        int iP3 = p3(str, str2, 0, false, 6, null);
        return iP3 == -1 ? str4 : G4(str, 0, iP3, str3).toString();
    }

    @os.l
    public static final String w5(@os.l String str, char c10, @os.l String str2) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "missingDelimiterValue");
        int iC3 = C3(str, c10, 0, false, 6, null);
        if (iC3 == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iC3);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @an.f
    public static final boolean x3(CharSequence charSequence) {
        return charSequence == null || e0.S1(charSequence);
    }

    public static /* synthetic */ String x4(String str, char c10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = str;
        }
        return v4(str, c10, str2, str3);
    }

    @os.l
    public static String x5(@os.l String str, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "delimiter");
        kn.l0.p(str3, "missingDelimiterValue");
        int iD3 = D3(str, str2, 0, false, 6, null);
        if (iD3 == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iD3);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @an.f
    public static final boolean y3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static /* synthetic */ String y4(String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str4 = str;
        }
        return w4(str, str2, str3, str4);
    }

    public static /* synthetic */ String y5(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return w5(str, c10, str2);
    }

    @os.l
    public static final nm.v z3(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return new a(charSequence);
    }

    @os.l
    public static final String z4(@os.l String str, char c10, @os.l String str2, @os.l String str3) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "replacement");
        kn.l0.p(str3, "missingDelimiterValue");
        int iC3 = C3(str, c10, 0, false, 6, null);
        return iC3 == -1 ? str3 : G4(str, 0, iC3, str2).toString();
    }

    public static /* synthetic */ String z5(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return x5(str, str2, str3);
    }
}
