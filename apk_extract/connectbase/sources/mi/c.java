package mi;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import libcore.icu.Transliterator;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10669c = "HanziToPinyin";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f10670d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char f10671e = 1040;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char f10672f = 1071;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char f10673g = 1103;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f10674h = 1576;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f10675i = 1609;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char f10676j = 1488;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char f10677k = 1514;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10678l = 14;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10679m = 15;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10680n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Map<Character, Character> f10681o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ArrayList<Character> f10682p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ArrayList<Character> f10683q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Transliterator f10684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Transliterator f10685b;

    public class a extends b {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f10686l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f10687m = 1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f10688n = 2;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f10690d = " ";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f10691e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f10692f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f10693g = 3;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f10694h = 14;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f10695i = 15;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f10696j = 16;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10699c;

        public b() {
        }

        public b(int i10, String str, String str2) {
            this.f10697a = i10;
            this.f10698b = str;
            this.f10699c = str2;
        }
    }

    static {
        HashMap map = new HashMap();
        f10681o = map;
        map.put((char) 1040, '2');
        f10681o.put((char) 1041, '2');
        f10681o.put((char) 1042, '2');
        f10681o.put((char) 1043, '2');
        f10681o.put((char) 1044, '3');
        f10681o.put((char) 1045, '3');
        f10681o.put((char) 1046, '3');
        f10681o.put((char) 1047, '3');
        f10681o.put((char) 1048, '4');
        f10681o.put((char) 1049, '4');
        f10681o.put((char) 1050, '4');
        f10681o.put((char) 1051, '4');
        f10681o.put((char) 1052, '5');
        f10681o.put((char) 1053, '5');
        f10681o.put((char) 1054, '5');
        f10681o.put((char) 1055, '5');
        f10681o.put((char) 1056, '6');
        f10681o.put((char) 1057, '6');
        f10681o.put((char) 1058, '6');
        f10681o.put((char) 1059, '6');
        f10681o.put((char) 1060, '7');
        f10681o.put((char) 1061, '7');
        f10681o.put((char) 1062, '7');
        f10681o.put((char) 1063, '7');
        f10681o.put((char) 1064, '8');
        f10681o.put((char) 1065, '8');
        f10681o.put((char) 1066, '8');
        f10681o.put((char) 1067, '8');
        f10681o.put((char) 1068, '9');
        f10681o.put((char) 1069, '9');
        f10681o.put((char) 1070, '9');
        f10681o.put((char) 1071, '9');
        f10681o.put((char) 1072, '2');
        f10681o.put((char) 1073, '2');
        f10681o.put((char) 1074, '2');
        f10681o.put((char) 1075, '2');
        f10681o.put((char) 1076, '3');
        f10681o.put((char) 1077, '3');
        f10681o.put((char) 1078, '3');
        f10681o.put((char) 1079, '3');
        f10681o.put((char) 1080, '4');
        f10681o.put((char) 1081, '4');
        f10681o.put((char) 1082, '4');
        f10681o.put((char) 1083, '4');
        f10681o.put((char) 1084, '5');
        f10681o.put((char) 1085, '5');
        f10681o.put((char) 1086, '5');
        f10681o.put((char) 1087, '5');
        f10681o.put((char) 1088, '6');
        f10681o.put((char) 1089, '6');
        f10681o.put((char) 1090, '6');
        f10681o.put((char) 1091, '6');
        f10681o.put((char) 1092, '7');
        f10681o.put((char) 1093, '7');
        f10681o.put((char) 1094, '7');
        f10681o.put((char) 1095, '7');
        f10681o.put((char) 1096, '8');
        f10681o.put((char) 1097, '8');
        f10681o.put((char) 1098, '8');
        f10681o.put((char) 1099, '8');
        f10681o.put((char) 1100, '9');
        f10681o.put((char) 1101, '9');
        f10681o.put((char) 1102, '9');
        f10681o.put((char) 1103, '9');
        f10681o.put((char) 1025, '3');
        f10681o.put((char) 1105, '3');
        f10681o.put((char) 1576, '2');
        f10681o.put((char) 1577, '2');
        f10681o.put((char) 1578, '2');
        f10681o.put((char) 1579, '2');
        f10681o.put((char) 1569, '3');
        f10681o.put((char) 1575, '3');
        f10681o.put((char) 1587, '4');
        f10681o.put((char) 1588, '4');
        f10681o.put((char) 1589, '4');
        f10681o.put((char) 1590, '4');
        f10681o.put((char) 1583, '5');
        f10681o.put((char) 1584, '5');
        f10681o.put((char) 1585, '5');
        f10681o.put((char) 1586, '5');
        f10681o.put((char) 1580, '6');
        f10681o.put((char) 1581, '6');
        f10681o.put((char) 1582, '6');
        f10681o.put((char) 1606, '7');
        f10681o.put((char) 1607, '7');
        f10681o.put((char) 1608, '7');
        f10681o.put((char) 1609, '7');
        f10681o.put((char) 1601, '8');
        f10681o.put((char) 1602, '8');
        f10681o.put((char) 1603, '8');
        f10681o.put((char) 1604, '8');
        f10681o.put((char) 1605, '8');
        f10681o.put((char) 1591, '9');
        f10681o.put((char) 1592, '9');
        f10681o.put((char) 1593, '9');
        f10681o.put((char) 1594, '9');
        f10681o.put((char) 1491, '2');
        f10681o.put((char) 1492, '2');
        f10681o.put((char) 1493, '2');
        f10681o.put((char) 1488, '3');
        f10681o.put((char) 1489, '3');
        f10681o.put((char) 1490, '3');
        f10681o.put((char) 1502, '4');
        f10681o.put((char) 1504, '4');
        f10681o.put((char) 1500, '5');
        f10681o.put((char) 1499, '5');
        f10681o.put((char) 1494, '6');
        f10681o.put((char) 1495, '6');
        f10681o.put((char) 1496, '6');
        f10681o.put((char) 1512, '7');
        f10681o.put((char) 1513, '7');
        f10681o.put((char) 1514, '7');
        f10681o.put((char) 1510, '8');
        f10681o.put((char) 1511, '8');
        f10681o.put((char) 1505, '9');
        f10681o.put((char) 1506, '9');
        f10681o.put((char) 1507, '9');
        ArrayList<Character> arrayList = new ArrayList<>();
        f10682p = arrayList;
        ArrayList<Character> arrayList2 = new ArrayList<>();
        f10683q = arrayList2;
        arrayList.add((char) 1025);
        arrayList2.add((char) 1105);
    }

    public c() {
        try {
            this.f10684a = new Transliterator("Han-Latin/Names; Latin-Ascii; Any-Upper");
            this.f10685b = new Transliterator("Latin-Ascii");
        } catch (RuntimeException unused) {
            Log.w("HanziToPinyin", "Han-Latin/Names transliterator data is missing, HanziToPinyin is disabled");
        }
    }

    public static c d() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f10670d == null) {
                    f10670d = new c();
                }
                cVar = f10670d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    public final void a(StringBuilder sb2, ArrayList<String> arrayList) {
        arrayList.add(sb2.toString());
        sb2.setLength(0);
    }

    public final void b(ArrayList<b> arrayList, ArrayList<String> arrayList2, StringBuilder sb2, StringBuilder sb3) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        for (int i10 = size - 1; i10 >= 0; i10--) {
            String str = arrayList.get(i10).f10699c;
            int length = str.length();
            String str2 = arrayList2.get(i10);
            if (sb4.length() > 0) {
                sb4.setLength(0);
                sb5.setLength(0);
            }
            sb4.insert(0, str);
            char c10 = (char) length;
            sb4.insert(0, c10);
            sb5.insert(0, str2);
            sb5.insert(0, c10);
            sb6.insert(0, (CharSequence) sb4);
            sb7.insert(0, (CharSequence) sb5);
        }
        sb2.append((CharSequence) sb6);
        sb3.append((CharSequence) sb7);
        arrayList.clear();
        arrayList2.clear();
    }

    public final void c(StringBuilder sb2, ArrayList<b> arrayList, int i10) {
        String string = sb2.toString();
        arrayList.add(new b(i10, string, string));
        sb2.setLength(0);
    }

    public ArrayList<b> e(String str) {
        ArrayList<b> arrayList = new ArrayList<>();
        if (!g() || TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder();
        b bVar = new b();
        int i10 = 1;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (!Character.isSpaceChar(cCharAt)) {
                j(cCharAt, bVar);
                int i12 = bVar.f10697a;
                if (i12 == 2) {
                    if (sb2.length() > 0) {
                        c(sb2, arrayList, i10);
                    }
                    arrayList.add(bVar);
                    bVar = new b();
                } else {
                    if (i10 != i12 && sb2.length() > 0) {
                        c(sb2, arrayList, i10);
                    }
                    sb2.append(bVar.f10699c);
                }
                i10 = bVar.f10697a;
            } else if (sb2.length() > 0) {
                c(sb2, arrayList, i10);
            }
        }
        if (sb2.length() > 0) {
            c(sb2, arrayList, i10);
        }
        return arrayList;
    }

    public String f(String str, StringBuilder sb2) {
        int i10;
        char c10;
        int i11;
        String str2 = str;
        if (sb2 == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb3 = new StringBuilder();
        ArrayList<b> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        char c11 = 0;
        char c12 = 1;
        for (int length = str.length(); i12 < length; length = i10) {
            char cCharAt = str2.charAt(i12);
            if (cCharAt == '-' || cCharAt == ',') {
                i10 = length;
                i13++;
            } else {
                if (cCharAt == ' ') {
                    if (sb4.length() > 0) {
                        c(sb4, arrayList, i14);
                        a(sb5, arrayList2);
                    }
                    b(arrayList, arrayList2, sb3, sb2);
                    i13++;
                    i10 = length;
                } else if (cCharAt < 256) {
                    if (i14 != 1 && sb4.length() > 0) {
                        c(sb4, arrayList, i14);
                        a(sb5, arrayList2);
                    }
                    c12 = (cCharAt < 'A' || cCharAt > 'Z') ? (char) 2 : (char) 1;
                    if (c11 == 2 && c12 == 1) {
                        c(sb4, arrayList, i14);
                        a(sb5, arrayList2);
                    }
                    sb4.append(Character.valueOf(Character.toUpperCase(cCharAt)));
                    sb5.append((char) i13);
                    i13++;
                    i10 = length;
                    c11 = c12;
                    i14 = 1;
                } else if (h(cCharAt) || (cCharAt >= 1040 && cCharAt <= 1103)) {
                    i10 = length;
                    if (i14 != 14 && sb4.length() > 0) {
                        c(sb4, arrayList, i14);
                        a(sb5, arrayList2);
                    }
                    if (i(cCharAt) || (cCharAt >= 1040 && cCharAt <= 1071)) {
                        c10 = 2;
                        c12 = 1;
                    } else {
                        c10 = 2;
                        c12 = 2;
                    }
                    if (c11 == c10 && c12 == 1) {
                        c(sb4, arrayList, i14);
                        a(sb5, arrayList2);
                    }
                    Character ch2 = f10681o.get(Character.valueOf(cCharAt));
                    if (ch2 != null) {
                        sb4.append(ch2);
                        sb5.append((char) i13);
                    }
                    i13++;
                    i14 = 14;
                    c11 = c12;
                } else {
                    if (cCharAt >= 1576 && cCharAt <= 1609) {
                        i11 = 15;
                        if (i14 != 15 && sb4.length() > 0) {
                            c(sb4, arrayList, i14);
                            a(sb5, arrayList2);
                        }
                        Character ch3 = f10681o.get(Character.valueOf(cCharAt));
                        if (ch3 != null) {
                            sb4.append(ch3);
                            sb5.append((char) i13);
                        }
                    } else if (cCharAt < 1488 || cCharAt > 1514) {
                        b bVar = new b();
                        j(cCharAt, bVar);
                        int length2 = bVar.f10699c.length();
                        i10 = length;
                        if (bVar.f10697a == 2) {
                            if (sb4.length() > 0) {
                                c(sb4, arrayList, i14);
                                a(sb5, arrayList2);
                            }
                            arrayList.add(bVar);
                            for (int i15 = 0; i15 < length2; i15++) {
                                sb5.append((char) i13);
                            }
                            a(sb5, arrayList2);
                            i13++;
                            i14 = 2;
                        } else {
                            i13++;
                        }
                    } else {
                        i11 = 16;
                        if (i14 != 16 && sb4.length() > 0) {
                            c(sb4, arrayList, i14);
                            a(sb5, arrayList2);
                        }
                        Character ch4 = f10681o.get(Character.valueOf(cCharAt));
                        if (ch4 != null) {
                            sb4.append(ch4);
                            sb5.append((char) i13);
                        }
                    }
                    i13++;
                    i14 = i11;
                    i10 = length;
                    c11 = c12;
                }
                c11 = 0;
            }
            if (i13 > 127) {
                break;
            }
            i12++;
            str2 = str;
        }
        if (sb4.length() > 0) {
            c(sb4, arrayList, i14);
            a(sb5, arrayList2);
        }
        b(arrayList, arrayList2, sb3, sb2);
        return sb3.toString();
    }

    public boolean g() {
        return this.f10684a != null;
    }

    public final boolean h(char c10) {
        return f10682p.contains(Character.valueOf(c10)) || f10683q.contains(Character.valueOf(c10));
    }

    public final boolean i(char c10) {
        return f10682p.contains(Character.valueOf(c10));
    }

    public final void j(char c10, b bVar) {
        String string = Character.toString(c10);
        bVar.f10698b = string;
        if (c10 < 128) {
            bVar.f10697a = 1;
            bVar.f10699c = string;
            return;
        }
        if (c10 < 592 || (7680 <= c10 && c10 < 7935)) {
            bVar.f10697a = 1;
            Transliterator transliterator = this.f10685b;
            if (transliterator != null) {
                string = transliterator.transliterate(string);
            }
            bVar.f10699c = string;
            return;
        }
        bVar.f10697a = 2;
        String strTransliterate = this.f10684a.transliterate(string);
        bVar.f10699c = strTransliterate;
        if (TextUtils.isEmpty(strTransliterate) || TextUtils.equals(bVar.f10698b, bVar.f10699c)) {
            bVar.f10697a = 3;
            bVar.f10699c = bVar.f10698b;
        }
    }

    public String k(String str) {
        return (!g() || TextUtils.isEmpty(str)) ? "" : this.f10684a.transliterate(str);
    }
}
