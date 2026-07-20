package dj;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;
import k3.b2;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4626a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4629d;
    public final ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f4630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4631h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4627b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4628c = "";
    public int e = -1;

    public t() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add("");
    }

    public final u a() {
        ArrayList arrayList;
        String str = this.f4626a;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        String strF = l.f(this.f4627b, 0, 0, false, 7);
        String strF2 = l.f(this.f4628c, 0, 0, false, 7);
        String str2 = this.f4629d;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iB = b();
        ArrayList arrayList2 = this.f;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.i(arrayList2));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(l.f((String) it.next(), 0, 0, false, 7));
        }
        ArrayList<String> arrayList4 = this.f4630g;
        if (arrayList4 != null) {
            arrayList = new ArrayList(CollectionsKt.i(arrayList4));
            for (String str3 : arrayList4) {
                arrayList.add(str3 != null ? l.f(str3, 0, 0, true, 3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.f4631h;
        return new u(str, strF, strF2, str2, iB, arrayList3, arrayList, str4 != null ? l.f(str4, 0, 0, false, 7) : null, toString());
    }

    public final int b() {
        int i8;
        int i9 = this.e;
        if (i9 != -1) {
            return i9;
        }
        String scheme = this.f4626a;
        Intrinsics.checkNotNull(scheme);
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        int iHashCode = scheme.hashCode();
        if (iHashCode == 3213448) {
            if (scheme.equals("http")) {
                i8 = 80;
                return i8;
            }
            return -1;
        }
        if (iHashCode == 99617003 && scheme.equals("https")) {
            i8 = 443;
            return i8;
        }
        return -1;
    }

    public final void c(String str) {
        String strB;
        this.f4630g = (str == null || (strB = l.b(str, 0, 0, " \"'<>#", true, false, true, false, 211)) == null) ? null : l.h(strB);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0207  */
    /* JADX WARN: Code duplicated, block: B:103:0x020b  */
    /* JADX WARN: Code duplicated, block: B:104:0x020d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0211  */
    /* JADX WARN: Code duplicated, block: B:114:0x0227  */
    /* JADX WARN: Code duplicated, block: B:125:0x0258  */
    /* JADX WARN: Code duplicated, block: B:128:0x025e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0262  */
    /* JADX WARN: Code duplicated, block: B:131:0x0288  */
    /* JADX WARN: Code duplicated, block: B:134:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:189:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:211:0x021e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x021b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x0219 A[EDGE_INSN: B:214:0x0219->B:109:0x0219 BREAK  A[LOOP:4: B:105:0x020e->B:216:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:4:0x0027  */
    /* JADX WARN: Code duplicated, block: B:72:0x0122  */
    /* JADX WARN: Code duplicated, block: B:75:0x0130  */
    /* JADX WARN: Code duplicated, block: B:76:0x0135  */
    /* JADX WARN: Code duplicated, block: B:99:0x0201  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(u uVar, String input) throws EOFException {
        int i8;
        byte b9;
        byte b10;
        int i9;
        int iF;
        byte bCharAt;
        ArrayList arrayList;
        String str;
        int i10;
        int i11;
        int i12;
        boolean z2;
        int i13;
        char cCharAt;
        int i14;
        int i15;
        byte b11;
        ArrayList arrayList2;
        char cCharAt2;
        Intrinsics.checkNotNullParameter(input, "input");
        byte[] bArr = ej.b.f4964a;
        int iN = ej.b.n(0, input.length(), input);
        int iO = ej.b.o(iN, input.length(), input);
        byte b12 = -1;
        if (iO - iN >= 2) {
            char cCharAt3 = input.charAt(iN);
            char c9 = 'a';
            if ((Intrinsics.compare((int) cCharAt3, 97) >= 0 && Intrinsics.compare((int) cCharAt3, 122) <= 0) || (Intrinsics.compare((int) cCharAt3, 65) >= 0 && Intrinsics.compare((int) cCharAt3, 90) <= 0)) {
                i8 = iN + 1;
                while (true) {
                    if (i8 < iO) {
                        char cCharAt4 = input.charAt(i8);
                        if ((c9 > cCharAt4 || 'z' < cCharAt4) && (('A' > cCharAt4 || 'Z' < cCharAt4) && (('0' > cCharAt4 || '9' < cCharAt4) && cCharAt4 != '+' && cCharAt4 != '-' && cCharAt4 != '.'))) {
                            if (cCharAt4 == ':') {
                                break;
                            } else {
                                break;
                            }
                        } else {
                            i8++;
                            c9 = 'a';
                        }
                    }
                    i8 = -1;
                    break;
                }
            } else {
                i8 = -1;
                break;
            }
        } else {
            i8 = -1;
            break;
        }
        String str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
        if (i8 != -1) {
            if (StringsKt__StringsJVMKt.startsWith(input, "https:", iN, true)) {
                this.f4626a = "https";
                iN += 6;
            } else {
                if (!StringsKt__StringsJVMKt.startsWith(input, "http:", iN, true)) {
                    StringBuilder sb2 = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                    String strSubstring = input.substring(0, i8);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb2.append(strSubstring);
                    sb2.append("'");
                    throw new IllegalArgumentException(sb2.toString());
                }
                this.f4626a = "http";
                iN += 5;
            }
        } else {
            if (uVar == null) {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            this.f4626a = uVar.f4634b;
        }
        int i16 = iN;
        int i17 = 0;
        while (true) {
            b9 = 47;
            b10 = 92;
            if (i16 >= iO || !((cCharAt2 = input.charAt(i16)) == '\\' || cCharAt2 == '/')) {
                break;
            }
            i17++;
            i16++;
        }
        ArrayList arrayList3 = this.f;
        byte b13 = 63;
        byte b14 = 35;
        if (i17 >= 2 || uVar == null) {
            i9 = iN + i17;
            boolean z3 = false;
            boolean z5 = false;
            while (true) {
                iF = ej.b.f(i9, iO, input, "@/\\?#");
                if (iF != iO) {
                    bCharAt = input.charAt(iF);
                } else {
                    bCharAt = b12;
                }
                if (bCharAt == b12 || bCharAt == b14 || bCharAt == b9 || bCharAt == b10 || bCharAt == b13) {
                    break;
                }
                if (bCharAt != 64) {
                    b11 = b13;
                    arrayList3 = arrayList3;
                    str2 = str2;
                } else {
                    if (z3) {
                        i15 = iF;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.f4628c);
                        sb3.append("%40");
                        b11 = b13;
                        sb3.append(l.b(input, i9, i15, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240));
                        this.f4628c = sb3.toString();
                    } else {
                        int iG = ej.b.g(input, ':', i9, iF);
                        int i18 = i9;
                        byte b15 = b13;
                        i15 = iF;
                        String strB = l.b(input, i18, iG, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                        if (z5) {
                            strB = this.f4627b + "%40" + strB;
                        }
                        this.f4627b = strB;
                        if (iG != i15) {
                            this.f4628c = l.b(input, iG + 1, i15, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                            z3 = true;
                        }
                        b11 = b15;
                        z5 = true;
                    }
                    i9 = i15 + 1;
                }
                b13 = b11;
                arrayList3 = arrayList3;
                str2 = str2;
                b10 = 92;
                b9 = 47;
                b14 = 35;
                b12 = -1;
            }
            arrayList = arrayList3;
            str = str2;
            i10 = i9;
            while (true) {
                if (i10 >= iF) {
                    cCharAt = input.charAt(i10);
                    if (cCharAt != ':') {
                        i11 = i10;
                        break;
                    }
                    if (cCharAt != '[') {
                        i14 = 1;
                        do {
                            i10++;
                            if (i10 < iF) {
                                break;
                            }
                        } while (input.charAt(i10) != ']');
                    } else {
                        i14 = 1;
                    }
                    i10 += i14;
                } else {
                    i11 = iF;
                    break;
                }
            }
            i12 = i11 + 1;
            if (i12 < iF) {
                this.f4629d = b2.b(l.f(input, i9, i11, false, 4));
                try {
                    i13 = Integer.parseInt(l.b(input, i12, iF, "", false, false, false, false, 248));
                    if (1 <= i13 || 65535 < i13) {
                        i13 = -1;
                    }
                } catch (NumberFormatException unused) {
                }
                this.e = i13;
                if (i13 != -1) {
                    StringBuilder sb4 = new StringBuilder("Invalid URL port: \"");
                    String strSubstring2 = input.substring(i12, iF);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, str);
                    sb4.append(strSubstring2);
                    sb4.append(Typography.quote);
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                z2 = false;
            } else {
                z2 = false;
                this.f4629d = b2.b(l.f(input, i9, i11, false, 4));
                String str3 = this.f4626a;
                Intrinsics.checkNotNull(str3);
                this.e = l.c(str3);
            }
            if (this.f4629d != null) {
                StringBuilder sb5 = new StringBuilder("Invalid URL host: \"");
                String strSubstring3 = input.substring(i9, i11);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, str);
                sb5.append(strSubstring3);
                sb5.append(Typography.quote);
                throw new IllegalArgumentException(sb5.toString().toString());
            }
            iN = iF;
        } else if (Intrinsics.areEqual(uVar.f4634b, this.f4626a)) {
            this.f4627b = uVar.e();
            this.f4628c = uVar.a();
            this.f4629d = uVar.e;
            this.e = uVar.f;
            arrayList3.clear();
            arrayList3.addAll(uVar.c());
            if (iN == iO || input.charAt(iN) == '#') {
                c(uVar.d());
            }
            arrayList = arrayList3;
            z2 = false;
        } else {
            i9 = iN + i17;
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                iF = ej.b.f(i9, iO, input, "@/\\?#");
                if (iF != iO) {
                    bCharAt = input.charAt(iF);
                } else {
                    bCharAt = b12;
                }
                if (bCharAt == b12) {
                    break;
                } else {
                    break;
                }
                b13 = b11;
                arrayList3 = arrayList3;
                str2 = str2;
                b10 = 92;
                b9 = 47;
                b14 = 35;
                b12 = -1;
            }
            arrayList = arrayList3;
            str = str2;
            i10 = i9;
            while (true) {
                if (i10 >= iF) {
                    cCharAt = input.charAt(i10);
                    if (cCharAt != ':') {
                        i11 = i10;
                        break;
                    }
                    if (cCharAt != '[') {
                        i14 = 1;
                        do {
                            i10++;
                            if (i10 < iF) {
                                break;
                                break;
                            }
                        } while (input.charAt(i10) != ']');
                    } else {
                        i14 = 1;
                    }
                    i10 += i14;
                } else {
                    i11 = iF;
                    break;
                }
            }
            i12 = i11 + 1;
            if (i12 < iF) {
                this.f4629d = b2.b(l.f(input, i9, i11, false, 4));
                i13 = Integer.parseInt(l.b(input, i12, iF, "", false, false, false, false, 248));
                if (1 <= i13) {
                    i13 = -1;
                } else {
                    i13 = -1;
                }
                this.e = i13;
                if (i13 != -1) {
                    StringBuilder sb6 = new StringBuilder("Invalid URL port: \"");
                    String strSubstring4 = input.substring(i12, iF);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, str);
                    sb6.append(strSubstring4);
                    sb6.append(Typography.quote);
                    throw new IllegalArgumentException(sb6.toString().toString());
                }
                z2 = false;
            } else {
                z2 = false;
                this.f4629d = b2.b(l.f(input, i9, i11, false, 4));
                String str4 = this.f4626a;
                Intrinsics.checkNotNull(str4);
                this.e = l.c(str4);
            }
            if (this.f4629d != null) {
                StringBuilder sb7 = new StringBuilder("Invalid URL host: \"");
                String strSubstring5 = input.substring(i9, i11);
                Intrinsics.checkNotNullExpressionValue(strSubstring5, str);
                sb7.append(strSubstring5);
                sb7.append(Typography.quote);
                throw new IllegalArgumentException(sb7.toString().toString());
            }
            iN = iF;
        }
        int iF2 = ej.b.f(iN, iO, input, "?#");
        if (iN != iF2) {
            char cCharAt5 = input.charAt(iN);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                arrayList2 = arrayList;
                arrayList2.clear();
                arrayList2.add("");
                iN++;
            } else {
                arrayList2 = arrayList;
                arrayList2.set(arrayList.size() - 1, "");
            }
            while (iN < iF2) {
                int iF3 = ej.b.f(iN, iF2, input, "/\\");
                boolean z12 = iF3 < iF2 ? true : z2;
                int i19 = iF3;
                String strB2 = l.b(input, iN, iF3, " \"<>^`{}|/\\?#", true, false, false, false, 240);
                if (!Intrinsics.areEqual(strB2, ".") && !StringsKt__StringsJVMKt.equals(strB2, "%2e", true)) {
                    if (!Intrinsics.areEqual(strB2, "..") && !StringsKt__StringsJVMKt.equals(strB2, "%2e.", true) && !StringsKt__StringsJVMKt.equals(strB2, ".%2e", true) && !StringsKt__StringsJVMKt.equals(strB2, "%2e%2e", true)) {
                        if (((CharSequence) a1.a.i(1, arrayList2)).length() == 0) {
                            arrayList2.set(arrayList2.size() - 1, strB2);
                        } else {
                            arrayList2.add(strB2);
                        }
                        if (z12) {
                            arrayList2.add("");
                        }
                    } else if (((String) arrayList2.remove(arrayList2.size() - 1)).length() != 0 || arrayList2.isEmpty()) {
                        arrayList2.add("");
                    } else {
                        arrayList2.set(arrayList2.size() - 1, "");
                    }
                }
                if (z12) {
                    i19++;
                }
                iN = i19;
            }
        }
        if (iF2 < iO && input.charAt(iF2) == '?') {
            int iG2 = ej.b.g(input, '#', iF2, iO);
            this.f4630g = l.h(l.b(input, iF2 + 1, iG2, " \"'<>#", true, false, true, false, 208));
            iF2 = iG2;
        }
        if (iF2 >= iO || input.charAt(iF2) != '#') {
            return;
        }
        this.f4631h = l.b(input, iF2 + 1, iO, "", true, false, false, true, 176);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a5  */
    public final String toString() {
        StringBuilder out = new StringBuilder();
        String str = this.f4626a;
        if (str != null) {
            out.append(str);
            out.append("://");
        } else {
            out.append("//");
        }
        if (this.f4627b.length() > 0 || this.f4628c.length() > 0) {
            out.append(this.f4627b);
            if (this.f4628c.length() > 0) {
                out.append(':');
                out.append(this.f4628c);
            }
            out.append('@');
        }
        String str2 = this.f4629d;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            if (StringsKt__StringsKt.contains$default((CharSequence) str2, ':', false, 2, (Object) null)) {
                out.append('[');
                out.append(this.f4629d);
                out.append(']');
            } else {
                out.append(this.f4629d);
            }
        }
        int i8 = -1;
        if (this.e != -1 || this.f4626a != null) {
            int iB = b();
            String scheme = this.f4626a;
            if (scheme != null) {
                Intrinsics.checkNotNull(scheme);
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                int iHashCode = scheme.hashCode();
                if (iHashCode != 3213448) {
                    if (iHashCode == 99617003 && scheme.equals("https")) {
                        i8 = 443;
                    }
                } else if (scheme.equals("http")) {
                    i8 = 80;
                }
                if (iB != i8) {
                    out.append(':');
                    out.append(iB);
                }
            } else {
                out.append(':');
                out.append(iB);
            }
        }
        ArrayList toPathString = this.f;
        Intrinsics.checkNotNullParameter(toPathString, "$this$toPathString");
        Intrinsics.checkNotNullParameter(out, "out");
        int size = toPathString.size();
        for (int i9 = 0; i9 < size; i9++) {
            out.append('/');
            out.append((String) toPathString.get(i9));
        }
        if (this.f4630g != null) {
            out.append('?');
            ArrayList toQueryString = this.f4630g;
            Intrinsics.checkNotNull(toQueryString);
            Intrinsics.checkNotNullParameter(toQueryString, "$this$toQueryString");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, toQueryString.size()), 2);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    String str3 = (String) toQueryString.get(first);
                    String str4 = (String) toQueryString.get(first + 1);
                    if (first > 0) {
                        out.append(Typography.amp);
                    }
                    out.append(str3);
                    if (str4 != null) {
                        out.append('=');
                        out.append(str4);
                    }
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        if (this.f4631h != null) {
            out.append('#');
            out.append(this.f4631h);
        }
        String string = out.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
