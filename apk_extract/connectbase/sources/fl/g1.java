package fl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final boolean[] f6038a = f(new char[]{y5.a.G, y5.a.H, y5.a.I, y5.a.J, 'l', 'L', 'P', 'p', 'n', 'N'});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Set<String> f6039b = nm.o1.u("CON", "PRN", "AUX", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final boolean[] f6040c = f(new char[]{rs.f.f14862d, el.b0.f4502a, n1.e.f11184d, kl.f.f9277j, '?', '\"', jq.m0.f8867e, jq.m0.f8868f, '|'});

    public static final boolean a(boolean[] zArr, char c10) {
        kn.l0.p(zArr, "<this>");
        return c10 < zArr.length && zArr[c10];
    }

    public static final List<String> b(List<String> list, int i10) throws IOException {
        ArrayList arrayList = new ArrayList(list.size());
        if (i10 > 0) {
            arrayList.addAll(list.subList(0, i10));
        }
        d(arrayList, list.get(i10));
        int i11 = i10 + 1;
        int size = list.size();
        while (i11 < size) {
            int i12 = i11 + 1;
            String str = list.get(i11);
            if (e(str)) {
                d(arrayList, str);
            } else {
                arrayList.add(str);
            }
            i11 = i12;
        }
        return arrayList;
    }

    @t0
    @os.l
    public static final List<String> c(@os.l List<String> list) {
        kn.l0.p(list, "<this>");
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (e(list.get(i10))) {
                return b(list, i10);
            }
            i10 = i11;
        }
        return list;
    }

    public static final void d(List<String> list, String str) throws IOException {
        CharSequence charSequenceSubSequence;
        if (str.length() == 0 || kn.l0.g(str, ".") || kn.l0.g(str, "~") || f6039b.contains(t1.g(str))) {
            return;
        }
        if (kn.l0.g(str, "..")) {
            if (list.isEmpty()) {
                return;
            }
            list.remove(nm.y.J(list));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (kn.l0.t(cCharAt, 32) >= 0 && !a(f6040c, cCharAt)) {
                sb2.append(cCharAt);
            }
            i10 = i11;
        }
        String string = sb2.toString();
        kn.l0.o(string, "filterTo(StringBuilder(), predicate).toString()");
        int length2 = string.length() - 1;
        if (length2 < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i12 = length2 - 1;
            char cCharAt2 = string.charAt(length2);
            if (cCharAt2 != ' ' && cCharAt2 != '.') {
                charSequenceSubSequence = string.subSequence(0, length2 + 1);
                break;
            } else {
                if (i12 < 0) {
                    charSequenceSubSequence = "";
                    break;
                }
                length2 = i12;
            }
        }
        String string2 = charSequenceSubSequence.toString();
        if (string2.length() <= 0) {
            string2 = null;
        }
        if (string2 == null) {
            return;
        }
        list.add(string2);
    }

    public static final boolean e(String str) {
        int length = str.length();
        if (length == 0) {
            return true;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '.' && (length == 1 || (length == 2 && str.charAt(1) == '.'))) {
            return true;
        }
        if (cCharAt == '~' && length == 1) {
            return true;
        }
        if (a(f6038a, cCharAt)) {
            Set<String> set = f6039b;
            if (set.contains(str) || set.contains(t1.g(str))) {
                return true;
            }
        }
        char cCharAt2 = str.charAt(length - 1);
        if (cCharAt2 == ' ' || cCharAt2 == '.') {
            return true;
        }
        boolean[] zArr = f6040c;
        int i10 = 0;
        while (i10 < str.length()) {
            char cCharAt3 = str.charAt(i10);
            i10++;
            if (kn.l0.t(cCharAt3, 32) < 0 || a(zArr, cCharAt3)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean[] f(char[] cArr) {
        boolean[] zArr = new boolean[256];
        for (int i10 = 0; i10 < 256; i10++) {
            zArr[i10] = nm.r.n8(cArr, (char) i10);
        }
        return zArr;
    }
}
