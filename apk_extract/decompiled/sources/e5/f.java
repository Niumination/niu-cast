package e5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k3.y1;
import kotlin.text.Typography;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Logger f4674h = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map f4675i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set f4676j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f4677k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map f4678l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map f4679m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map f4680n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f4681o;
    public static final Pattern p;
    public static final Pattern q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f4682r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f4683s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f4684t;
    public static final Pattern u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f4685v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f4686w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f4687x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static f f4688y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n6.a f4689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final se.e f4691c = new se.e(9);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f4692d = new HashSet(35);
    public final w e = new w(9);
    public final HashSet f = new HashSet(320);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet f4693g = new HashSet();

    static {
        HashMap map = new HashMap();
        map.put(54, "9");
        f4675i = Collections.unmodifiableMap(map);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(52);
        hashSet3.add(54);
        hashSet3.add(55);
        hashSet3.add(62);
        hashSet3.addAll(hashSet);
        f4676j = Collections.unmodifiableSet(hashSet3);
        HashMap map2 = new HashMap();
        map2.put('0', '0');
        map2.put('1', '1');
        map2.put('2', '2');
        map2.put('3', '3');
        map2.put('4', '4');
        map2.put('5', '5');
        map2.put('6', '6');
        map2.put('7', '7');
        map2.put('8', '8');
        map2.put('9', '9');
        HashMap map3 = new HashMap(40);
        map3.put('A', '2');
        map3.put('B', '2');
        map3.put('C', '2');
        map3.put('D', '3');
        map3.put('E', '3');
        map3.put('F', '3');
        map3.put('G', '4');
        map3.put('H', '4');
        map3.put('I', '4');
        map3.put('J', '5');
        map3.put('K', '5');
        map3.put('L', '5');
        map3.put('M', '6');
        map3.put('N', '6');
        map3.put('O', '6');
        map3.put('P', '7');
        map3.put('Q', '7');
        map3.put('R', '7');
        map3.put('S', '7');
        map3.put('T', '8');
        map3.put('U', '8');
        map3.put('V', '8');
        map3.put('W', '9');
        map3.put('X', '9');
        map3.put('Y', '9');
        map3.put('Z', '9');
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map3);
        f4678l = mapUnmodifiableMap;
        HashMap map4 = new HashMap(100);
        map4.putAll(mapUnmodifiableMap);
        map4.putAll(map2);
        f4679m = Collections.unmodifiableMap(map4);
        HashMap map5 = new HashMap();
        map5.putAll(map2);
        map5.put('+', '+');
        map5.put('*', '*');
        map5.put('#', '#');
        f4677k = Collections.unmodifiableMap(map5);
        HashMap map6 = new HashMap();
        for (Character ch2 : mapUnmodifiableMap.keySet()) {
            map6.put(Character.valueOf(Character.toLowerCase(ch2.charValue())), ch2);
            map6.put(ch2, ch2);
        }
        map6.putAll(map2);
        map6.put('-', '-');
        map6.put((char) 65293, '-');
        map6.put((char) 8208, '-');
        map6.put((char) 8209, '-');
        map6.put((char) 8210, '-');
        map6.put(Character.valueOf(Typography.ndash), '-');
        map6.put(Character.valueOf(Typography.mdash), '-');
        map6.put((char) 8213, '-');
        map6.put((char) 8722, '-');
        map6.put('/', '/');
        map6.put((char) 65295, '/');
        map6.put(' ', ' ');
        map6.put((char) 12288, ' ');
        map6.put((char) 8288, ' ');
        map6.put('.', '.');
        map6.put((char) 65294, '.');
        f4680n = Collections.unmodifiableMap(map6);
        Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb2 = new StringBuilder();
        Map map7 = f4678l;
        sb2.append(Arrays.toString(map7.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb2.append(Arrays.toString(map7.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String string = sb2.toString();
        f4681o = Pattern.compile("[+＋]+");
        Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        p = Pattern.compile("(\\p{Nd})");
        q = Pattern.compile("[+＋\\p{Nd}]");
        f4682r = Pattern.compile("[\\\\/] *x");
        f4683s = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        f4684t = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String strJ = h0.a.j("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*", string, "\\p{Nd}]*");
        String strA = a(true);
        a(false);
        u = Pattern.compile("^\\+(\\p{Nd}|[\\-\\.\\(\\)]?)*\\p{Nd}(\\p{Nd}|[\\-\\.\\(\\)]?)*$");
        String strB = h0.a.B(string, "\\p{Nd}");
        f4685v = Pattern.compile("^(" + h0.a.l("[", strB, "]+((\\-)*[", strB, "])*") + "\\.)*" + h0.a.l("[", string, "]+((\\-)*[", strB, "])*") + "\\.?$");
        StringBuilder sb3 = new StringBuilder("(?:");
        sb3.append(strA);
        sb3.append(")$");
        f4686w = Pattern.compile(sb3.toString(), 66);
        f4687x = Pattern.compile(strJ + "(?:" + strA + ")?", 66);
        Pattern.compile("(\\D+)");
        Pattern.compile("(\\$\\d)");
        Pattern.compile("\\(?\\$1\\)?");
        f4688y = null;
    }

    public f(n6.a aVar, HashMap map) {
        this.f4689a = aVar;
        this.f4690b = map;
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.f4693g.add((Integer) entry.getKey());
            } else {
                this.f.addAll(list);
            }
        }
        if (this.f.remove("001")) {
            f4674h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f4692d.addAll((Collection) map.get(1));
    }

    public static String a(boolean z2) {
        String str = ";ext=" + b(20);
        String str2 = "[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|anexo)[:\\.．]?[  \\t,-]*" + b(20) + "#?";
        String str3 = "[  \\t,]*(?:[xｘ#＃~～]|int|ｉｎｔ)[:\\.．]?[  \\t,-]*" + b(9) + "#?";
        String str4 = "[- ]+" + b(6) + "#";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("|");
        sb2.append(str2);
        sb2.append("|");
        sb2.append(str3);
        String strN = h0.a.n(sb2, "|", str4);
        if (!z2) {
            return strN;
        }
        return strN + "|" + ("[  \\t]*(?:,{2}|;)[:\\.．]?[  \\t,-]*" + b(15) + "#?") + "|" + ("[  \\t]*(?:,)+[:\\.．]?[  \\t,-]*" + b(9) + "#?");
    }

    public static String b(int i8) {
        return h0.a.h(i8, "(\\p{Nd}{1,", "})");
    }

    public static synchronized f c() {
        if (f4688y == null) {
            h5.a aVar = h5.a.f5260d;
            i5.a aVar2 = aVar.f5262b;
            if (aVar2 == null) {
                throw new IllegalArgumentException("metadataLoader could not be null.");
            }
            f fVar = new f(new n6.a(aVar.f5263c, aVar2, aVar.f5261a), y1.a());
            synchronized (f.class) {
                f4688y = fVar;
            }
        }
        return f4688y;
    }

    public static String f(p pVar) {
        StringBuilder sb2 = new StringBuilder();
        if (pVar.isItalianLeadingZero() && pVar.getNumberOfLeadingZeros() > 0) {
            char[] cArr = new char[pVar.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb2.append(new String(cArr));
        }
        sb2.append(pVar.getNationalNumber());
        return sb2.toString();
    }

    public static n g(j jVar, d dVar) {
        switch (dVar.ordinal()) {
            case 0:
            case 2:
                return jVar.getFixedLine();
            case 1:
                return jVar.getMobile();
            case 3:
                return jVar.getTollFree();
            case 4:
                return jVar.getPremiumRate();
            case 5:
                return jVar.getSharedCost();
            case 6:
                return jVar.getVoip();
            case 7:
                return jVar.getPersonalNumber();
            case 8:
                return jVar.getPager();
            case 9:
                return jVar.getUan();
            case 10:
                return jVar.getVoicemail();
            default:
                return jVar.getGeneralDesc();
        }
    }

    public static void l(StringBuilder sb2) {
        if (!f4684t.matcher(sb2).matches()) {
            sb2.replace(0, sb2.length(), m(sb2));
            return;
        }
        int length = sb2.length();
        StringBuilder sb3 = new StringBuilder(sb2.length());
        for (int i8 = 0; i8 < sb2.length(); i8++) {
            Character ch2 = (Character) f4679m.get(Character.valueOf(Character.toUpperCase(sb2.charAt(i8))));
            if (ch2 != null) {
                sb3.append(ch2);
            }
        }
        sb2.replace(0, length, sb3.toString());
    }

    public static String m(CharSequence charSequence) {
        StringBuilder sb2 = new StringBuilder(charSequence.length());
        for (int i8 = 0; i8 < charSequence.length(); i8++) {
            int iDigit = Character.digit(charSequence.charAt(i8), 10);
            if (iDigit != -1) {
                sb2.append(iDigit);
            }
        }
        return sb2.toString();
    }

    public static e o(StringBuilder sb2, j jVar, d dVar) {
        n nVarG = g(jVar, dVar);
        List<Integer> possibleLengthList = nVarG.getPossibleLengthList().isEmpty() ? jVar.getGeneralDesc().getPossibleLengthList() : nVarG.getPossibleLengthList();
        List<Integer> possibleLengthLocalOnlyList = nVarG.getPossibleLengthLocalOnlyList();
        if (dVar == d.FIXED_LINE_OR_MOBILE) {
            n nVarG2 = g(jVar, d.FIXED_LINE);
            if (nVarG2.getPossibleLengthCount() == 1 && nVarG2.getPossibleLength(0) == -1) {
                return o(sb2, jVar, d.MOBILE);
            }
            n nVarG3 = g(jVar, d.MOBILE);
            if (nVarG3.getPossibleLengthCount() != 1 || nVarG3.getPossibleLength(0) != -1) {
                ArrayList arrayList = new ArrayList(possibleLengthList);
                arrayList.addAll(nVarG3.getPossibleLengthCount() == 0 ? jVar.getGeneralDesc().getPossibleLengthList() : nVarG3.getPossibleLengthList());
                Collections.sort(arrayList);
                if (possibleLengthLocalOnlyList.isEmpty()) {
                    possibleLengthLocalOnlyList = nVarG3.getPossibleLengthLocalOnlyList();
                } else {
                    ArrayList arrayList2 = new ArrayList(possibleLengthLocalOnlyList);
                    arrayList2.addAll(nVarG3.getPossibleLengthLocalOnlyList());
                    Collections.sort(arrayList2);
                    possibleLengthLocalOnlyList = arrayList2;
                }
                possibleLengthList = arrayList;
            }
        }
        if (possibleLengthList.get(0).intValue() == -1) {
            return e.INVALID_LENGTH;
        }
        int length = sb2.length();
        if (possibleLengthLocalOnlyList.contains(Integer.valueOf(length))) {
            return e.IS_POSSIBLE_LOCAL_ONLY;
        }
        int iIntValue = possibleLengthList.get(0).intValue();
        if (iIntValue == length) {
            return e.IS_POSSIBLE;
        }
        if (iIntValue > length) {
            return e.TOO_SHORT;
        }
        if (((Integer) a1.a.j(1, possibleLengthList)).intValue() < length) {
            return e.TOO_LONG;
        }
        return possibleLengthList.subList(1, possibleLengthList.size()).contains(Integer.valueOf(length)) ? e.IS_POSSIBLE : e.INVALID_LENGTH;
    }

    public final j d(String str) {
        if (str == null || !this.f.contains(str)) {
            return null;
        }
        n6.a aVar = this.f4689a;
        aVar.getClass();
        if (str.equals("001")) {
            throw new IllegalArgumentException(str.concat(" region code is a non-geo entity"));
        }
        j jVar = (j) ((ConcurrentHashMap) ((j5.a) ((dj.m) aVar.f8123c).d(((w) aVar.f8122b).C(str))).f6106b.f6816a).get(str);
        String strConcat = "Missing metadata for region code ".concat(str);
        if (jVar != null) {
            return jVar;
        }
        throw new a(strConcat);
    }

    public final j e(int i8, String str) {
        if (!"001".equals(str)) {
            return d(str);
        }
        if (!this.f4693g.contains(Integer.valueOf(i8))) {
            return null;
        }
        n6.a aVar = this.f4689a;
        aVar.getClass();
        List list = (List) y1.a().get(Integer.valueOf(i8));
        if (list != null && !list.contains("001")) {
            throw new IllegalArgumentException(h0.a.g(i8, " calling code belongs to a geo entity"));
        }
        j5.a aVar2 = (j5.a) ((dj.m) aVar.f8123c).d(((w) aVar.f8122b).C(Integer.valueOf(i8)));
        j jVar = (j) ((ConcurrentHashMap) aVar2.f6105a.f6816a).get(Integer.valueOf(i8));
        String strO = a1.a.o(i8, "Missing metadata for country code ");
        if (jVar != null) {
            return jVar;
        }
        throw new a(strO);
    }

    public final d h(String str, j jVar) {
        if (!i(str, jVar.getGeneralDesc())) {
            return d.UNKNOWN;
        }
        if (i(str, jVar.getPremiumRate())) {
            return d.PREMIUM_RATE;
        }
        if (i(str, jVar.getTollFree())) {
            return d.TOLL_FREE;
        }
        if (i(str, jVar.getSharedCost())) {
            return d.SHARED_COST;
        }
        if (i(str, jVar.getVoip())) {
            return d.VOIP;
        }
        if (i(str, jVar.getPersonalNumber())) {
            return d.PERSONAL_NUMBER;
        }
        if (i(str, jVar.getPager())) {
            return d.PAGER;
        }
        if (i(str, jVar.getUan())) {
            return d.UAN;
        }
        if (i(str, jVar.getVoicemail())) {
            return d.VOICEMAIL;
        }
        if (!i(str, jVar.getFixedLine())) {
            return (jVar.getSameMobileAndFixedLinePattern() || !i(str, jVar.getMobile())) ? d.UNKNOWN : d.MOBILE;
        }
        if (!jVar.getSameMobileAndFixedLinePattern() && !i(str, jVar.getMobile())) {
            return d.FIXED_LINE;
        }
        return d.FIXED_LINE_OR_MOBILE;
    }

    public final boolean i(String str, n nVar) {
        int length = str.length();
        List<Integer> possibleLengthList = nVar.getPossibleLengthList();
        if (possibleLengthList.size() <= 0 || possibleLengthList.contains(Integer.valueOf(length))) {
            return this.f4691c.k(str, nVar);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0077  */
    public final int j(CharSequence charSequence, j jVar, StringBuilder sb2, p pVar) throws c {
        o oVar;
        int i8 = 0;
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb3 = new StringBuilder(charSequence);
        String internationalPrefix = jVar != null ? jVar.getInternationalPrefix() : "NonMatch";
        if (sb3.length() == 0) {
            oVar = o.FROM_DEFAULT_COUNTRY;
        } else {
            Matcher matcher = f4681o.matcher(sb3);
            if (matcher.lookingAt()) {
                sb3.delete(0, matcher.end());
                l(sb3);
                oVar = o.FROM_NUMBER_WITH_PLUS_SIGN;
            } else {
                Pattern patternE = this.e.E(internationalPrefix);
                l(sb3);
                Matcher matcher2 = patternE.matcher(sb3);
                if (matcher2.lookingAt()) {
                    int iEnd = matcher2.end();
                    Matcher matcher3 = p.matcher(sb3.substring(iEnd));
                    if (matcher3.find() && m(matcher3.group(1)).equals("0")) {
                        oVar = o.FROM_DEFAULT_COUNTRY;
                    } else {
                        sb3.delete(0, iEnd);
                        oVar = o.FROM_NUMBER_WITH_IDD;
                    }
                } else {
                    oVar = o.FROM_DEFAULT_COUNTRY;
                }
            }
        }
        if (oVar != o.FROM_DEFAULT_COUNTRY) {
            if (sb3.length() <= 2) {
                throw new c(b.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            if (sb3.length() != 0 && sb3.charAt(0) != '0') {
                int length = sb3.length();
                for (int i9 = 1; i9 <= 3 && i9 <= length; i9++) {
                    int i10 = Integer.parseInt(sb3.substring(0, i9));
                    if (this.f4690b.containsKey(Integer.valueOf(i10))) {
                        sb2.append(sb3.substring(i9));
                        i8 = i10;
                        break;
                    }
                }
            }
            if (i8 == 0) {
                throw new c(b.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            pVar.setCountryCode(i8);
            return i8;
        }
        if (jVar != null) {
            int countryCode = jVar.getCountryCode();
            String strValueOf = String.valueOf(countryCode);
            String string = sb3.toString();
            if (string.startsWith(strValueOf)) {
                StringBuilder sb4 = new StringBuilder(string.substring(strValueOf.length()));
                n generalDesc = jVar.getGeneralDesc();
                k(sb4, jVar, null);
                se.e eVar = this.f4691c;
                if ((!eVar.k(sb3, generalDesc) && eVar.k(sb4, generalDesc)) || o(sb3, jVar, d.UNKNOWN) == e.TOO_LONG) {
                    sb2.append((CharSequence) sb4);
                    pVar.setCountryCode(countryCode);
                    return countryCode;
                }
            }
        }
        pVar.setCountryCode(0);
        return 0;
    }

    public final void k(StringBuilder sb2, j jVar, StringBuilder sb3) {
        int length = sb2.length();
        String nationalPrefixForParsing = jVar.getNationalPrefixForParsing();
        if (length == 0 || nationalPrefixForParsing.length() == 0) {
            return;
        }
        Matcher matcher = this.e.E(nationalPrefixForParsing).matcher(sb2);
        if (matcher.lookingAt()) {
            n generalDesc = jVar.getGeneralDesc();
            se.e eVar = this.f4691c;
            boolean zK = eVar.k(sb2, generalDesc);
            int iGroupCount = matcher.groupCount();
            String nationalPrefixTransformRule = jVar.getNationalPrefixTransformRule();
            if (nationalPrefixTransformRule == null || nationalPrefixTransformRule.length() == 0 || matcher.group(iGroupCount) == null) {
                if (!zK || eVar.k(sb2.substring(matcher.end()), generalDesc)) {
                    if (sb3 != null && iGroupCount > 0 && matcher.group(iGroupCount) != null) {
                        sb3.append(matcher.group(1));
                    }
                    sb2.delete(0, matcher.end());
                    return;
                }
                return;
            }
            StringBuilder sb4 = new StringBuilder(sb2);
            sb4.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
            if (!zK || eVar.k(sb4.toString(), generalDesc)) {
                if (sb3 != null && iGroupCount > 1) {
                    sb3.append(matcher.group(1));
                }
                sb2.replace(0, sb2.length(), sb4.toString());
            }
        }
    }

    public final p n(String str, String str2) throws c {
        String strSubstring;
        CharSequence charSequenceSubSequence;
        int iJ;
        p pVar = new p();
        if (str == null) {
            throw new c(b.NOT_A_NUMBER, "The phone number supplied was null.");
        }
        if (str.length() > 250) {
            throw new c(b.TOO_LONG, "The string supplied was too long to parse.");
        }
        StringBuilder sb2 = new StringBuilder();
        String string = str.toString();
        int iIndexOf = string.indexOf(";phone-context=");
        String strGroup = "";
        if (iIndexOf == -1) {
            strSubstring = null;
        } else {
            int i8 = iIndexOf + 15;
            if (i8 >= string.length()) {
                strSubstring = "";
            } else {
                int iIndexOf2 = string.indexOf(59, i8);
                strSubstring = iIndexOf2 != -1 ? string.substring(i8, iIndexOf2) : string.substring(i8);
            }
        }
        if (strSubstring != null && (strSubstring.length() == 0 || !(u.matcher(strSubstring).matches() || f4685v.matcher(strSubstring).matches()))) {
            throw new c(b.NOT_A_NUMBER, "The phone-context value is invalid.");
        }
        if (strSubstring != null) {
            if (strSubstring.charAt(0) == '+') {
                sb2.append(strSubstring);
            }
            int iIndexOf3 = string.indexOf("tel:");
            sb2.append(string.substring(iIndexOf3 >= 0 ? iIndexOf3 + 4 : 0, iIndexOf));
        } else {
            Matcher matcher = q.matcher(string);
            if (matcher.find()) {
                charSequenceSubSequence = string.subSequence(matcher.start(), string.length());
                Matcher matcher2 = f4683s.matcher(charSequenceSubSequence);
                if (matcher2.find()) {
                    charSequenceSubSequence = charSequenceSubSequence.subSequence(0, matcher2.start());
                }
                Matcher matcher3 = f4682r.matcher(charSequenceSubSequence);
                if (matcher3.find()) {
                    charSequenceSubSequence = charSequenceSubSequence.subSequence(0, matcher3.start());
                }
            } else {
                charSequenceSubSequence = "";
            }
            sb2.append(charSequenceSubSequence);
        }
        int iIndexOf4 = sb2.indexOf(";isub=");
        if (iIndexOf4 > 0) {
            sb2.delete(iIndexOf4, sb2.length());
        }
        int length = sb2.length();
        Pattern pattern = f4687x;
        if (!(length < 2 ? false : pattern.matcher(sb2).matches())) {
            throw new c(b.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
        }
        boolean z2 = str2 != null && this.f.contains(str2);
        Pattern pattern2 = f4681o;
        if (!z2 && (sb2.length() == 0 || !pattern2.matcher(sb2).lookingAt())) {
            throw new c(b.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
        }
        Matcher matcher4 = f4686w.matcher(sb2);
        if (matcher4.find()) {
            String strSubstring2 = sb2.substring(0, matcher4.start());
            if (strSubstring2.length() < 2 ? false : pattern.matcher(strSubstring2).matches()) {
                int iGroupCount = matcher4.groupCount();
                for (int i9 = 1; i9 <= iGroupCount; i9++) {
                    if (matcher4.group(i9) != null) {
                        strGroup = matcher4.group(i9);
                        sb2.delete(matcher4.start(), sb2.length());
                        break;
                    }
                }
            }
        }
        if (strGroup.length() > 0) {
            pVar.setExtension(strGroup);
        }
        j jVarD = d(str2);
        StringBuilder sb3 = new StringBuilder();
        try {
            iJ = j(sb2, jVarD, sb3, pVar);
        } catch (c e) {
            Matcher matcher5 = pattern2.matcher(sb2);
            if (e.getErrorType() != b.INVALID_COUNTRY_CODE || !matcher5.lookingAt()) {
                throw new c(e.getErrorType(), e.getMessage());
            }
            iJ = j(sb2.substring(matcher5.end()), jVarD, sb3, pVar);
            if (iJ == 0) {
                throw new c(b.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
            }
        }
        if (iJ != 0) {
            List list = (List) this.f4690b.get(Integer.valueOf(iJ));
            String str3 = list == null ? "ZZ" : (String) list.get(0);
            if (!str3.equals(str2)) {
                jVarD = e(iJ, str3);
            }
        } else {
            l(sb2);
            sb3.append((CharSequence) sb2);
            if (str2 != null) {
                pVar.setCountryCode(jVarD.getCountryCode());
            }
        }
        if (sb3.length() < 2) {
            throw new c(b.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (jVarD != null) {
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder(sb3);
            k(sb5, jVarD, sb4);
            e eVarO = o(sb5, jVarD, d.UNKNOWN);
            if (eVarO != e.TOO_SHORT && eVarO != e.IS_POSSIBLE_LOCAL_ONLY && eVarO != e.INVALID_LENGTH) {
                sb3 = sb5;
            }
        }
        int length2 = sb3.length();
        if (length2 < 2) {
            throw new c(b.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (length2 > 17) {
            throw new c(b.TOO_LONG, "The string supplied is too long to be a phone number.");
        }
        if (sb3.length() > 1 && sb3.charAt(0) == '0') {
            pVar.setItalianLeadingZero(true);
            int i10 = 1;
            while (i10 < sb3.length() - 1 && sb3.charAt(i10) == '0') {
                i10++;
            }
            if (i10 != 1) {
                pVar.setNumberOfLeadingZeros(i10);
            }
        }
        pVar.setNationalNumber(Long.parseLong(sb3.toString()));
        return pVar;
    }
}
