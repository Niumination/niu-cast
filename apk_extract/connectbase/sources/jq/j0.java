package jq;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kn.r1;
import lm.a1;
import lm.a2;
import lm.f1;
import lm.l2;
import lm.p2;
import lm.s0;
import lm.t0;
import lm.w1;
import nm.c1;
import nm.n1;
import nm.v0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,2486:1\n126#1,2:2487\n214#1,5:2489\n502#1,5:2495\n502#1,5:2500\n462#1:2505\n1183#1,2:2506\n463#1,2:2508\n1185#1:2510\n465#1:2511\n462#1:2512\n1183#1,2:2513\n463#1,2:2515\n1185#1:2517\n465#1:2518\n1183#1,3:2519\n492#1,2:2522\n492#1,2:2524\n750#1,4:2526\n719#1,4:2530\n735#1,4:2534\n782#1,4:2538\n882#1,5:2542\n923#1,3:2547\n926#1,3:2557\n941#1,3:2560\n944#1,3:2570\n1041#1,3:2587\n1011#1,4:2590\n1000#1:2594\n1183#1,2:2595\n1185#1:2598\n1001#1:2599\n1183#1,3:2600\n1032#1:2603\n1174#1:2604\n1175#1:2606\n1033#1:2607\n1174#1,2:2608\n1183#1,3:2610\n1982#1,2:2613\n1984#1,6:2616\n2006#1,2:2622\n2008#1,6:2625\n2431#1,6:2631\n2461#1,7:2637\n1#2:2494\n1#2:2597\n1#2:2605\n1#2:2615\n1#2:2624\n372#3,7:2550\n372#3,7:2563\n372#3,7:2573\n372#3,7:2580\n*S KotlinDebug\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n52#1:2487,2\n62#1:2489,5\n420#1:2495,5\n429#1:2500,5\n440#1:2505\n440#1:2506,2\n440#1:2508,2\n440#1:2510\n440#1:2511\n451#1:2512\n451#1:2513,2\n451#1:2515,2\n451#1:2517\n451#1:2518\n462#1:2519,3\n474#1:2522,2\n483#1:2524,2\n677#1:2526,4\n692#1:2530,4\n706#1:2534,4\n769#1:2538,4\n842#1:2542,5\n898#1:2547,3\n898#1:2557,3\n911#1:2560,3\n911#1:2570,3\n970#1:2587,3\n980#1:2590,4\n990#1:2594\n990#1:2595,2\n990#1:2598\n990#1:2599\n1000#1:2600,3\n1024#1:2603\n1024#1:2604\n1024#1:2606\n1024#1:2607\n1032#1:2608,2\n1786#1:2610,3\n2077#1:2613,2\n2077#1:2616,6\n2095#1:2622,2\n2095#1:2625,6\n2420#1:2631,6\n2448#1:2637,7\n990#1:2597\n1024#1:2605\n2077#1:2615\n2095#1:2624\n898#1:2550,7\n911#1:2563,7\n925#1:2573,7\n943#1:2580,7\n*E\n"})
public class j0 extends i0 {

    @r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,70:1\n2475#2:71\n*E\n"})
    public static final class a implements Iterable<Character>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f8824a;

        public a(CharSequence charSequence) {
            this.f8824a = charSequence;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Character> iterator() {
            return h0.z3(this.f8824a);
        }
    }

    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,680:1\n2483#2:681\n*E\n"})
    public static final class b implements gq.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f8825a;

        public b(CharSequence charSequence) {
            this.f8825a = charSequence;
        }

        @Override // gq.m
        @os.l
        public Iterator<Character> iterator() {
            return h0.z3(this.f8825a);
        }
    }

    public static final class c extends kn.n0 implements jn.l<CharSequence, String> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l CharSequence charSequence) {
            kn.l0.p(charSequence, "it");
            return charSequence.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    @r1({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt$groupingBy$1\n*L\n1#1,2486:1\n*E\n"})
    public static final class d<K> implements nm.o0<Character, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f8826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<Character, K> f8827b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(CharSequence charSequence, jn.l<? super Character, ? extends K> lVar) {
            this.f8826a = charSequence;
            this.f8827b = lVar;
        }

        @Override // nm.o0
        public Object a(Character ch2) {
            Character ch3 = ch2;
            ch3.charValue();
            return this.f8827b.invoke(ch3);
        }

        @Override // nm.o0
        @os.l
        public Iterator<Character> b() {
            return h0.z3(this.f8826a);
        }

        public K c(char c10) {
            return this.f8827b.invoke(Character.valueOf(c10));
        }
    }

    public static final class e extends kn.n0 implements jn.l<CharSequence, String> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l CharSequence charSequence) {
            kn.l0.p(charSequence, "it");
            return charSequence.toString();
        }
    }

    public static final class f extends kn.n0 implements jn.l<CharSequence, String> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l CharSequence charSequence) {
            kn.l0.p(charSequence, "it");
            return charSequence.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class g<R> extends kn.n0 implements jn.l<Integer, R> {
        final /* synthetic */ int $size;
        final /* synthetic */ CharSequence $this_windowedSequence;
        final /* synthetic */ jn.l<CharSequence, R> $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(int i10, CharSequence charSequence, jn.l<? super CharSequence, ? extends R> lVar) {
            super(1);
            this.$size = i10;
            this.$this_windowedSequence = charSequence;
            this.$transform = lVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final R invoke(int i10) {
            int length = this.$size + i10;
            if (length < 0 || length > this.$this_windowedSequence.length()) {
                length = this.$this_windowedSequence.length();
            }
            return this.$transform.invoke(this.$this_windowedSequence.subSequence(i10, length));
        }
    }

    public static final class h extends kn.n0 implements jn.a<Iterator<? extends Character>> {
        final /* synthetic */ CharSequence $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(CharSequence charSequence) {
            super(0);
            this.$this_withIndex = charSequence;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Character> invoke() {
            return h0.z3(this.$this_withIndex);
        }
    }

    @os.l
    public static String A6(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = str.length() - i10;
        if (length < 0) {
            length = 0;
        }
        return V8(str, length);
    }

    @os.l
    public static final <R> List<R> A7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            Object objA = g0.a(charSequence, i10, lVar);
            if (objA != null) {
                arrayList.add(objA);
            }
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @os.l
    public static final <R> List<R> A8(@os.l CharSequence charSequence, R r10, @os.l jn.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        if (charSequence.length() == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.l
    public static final CharSequence B6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iG3 = h0.g3(charSequence); -1 < iG3; iG3--) {
            if (!((Boolean) g0.a(charSequence, iG3, lVar)).booleanValue()) {
                return charSequence.subSequence(0, iG3 + 1);
            }
        }
        return "";
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C B7(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            Object objA = g0.a(charSequence, i10, lVar);
            if (objA != null) {
                c10.add(objA);
            }
        }
        return c10;
    }

    @f1(version = "1.4")
    @os.l
    public static final List<Character> B8(@os.l CharSequence charSequence, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        if (charSequence.length() == 0) {
            return nm.k0.INSTANCE;
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        int i10 = 1;
        while (i10 < length) {
            Character chInvoke = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i10)));
            char cCharValue = chInvoke.charValue();
            arrayList.add(chInvoke);
            i10++;
            cCharAt = cCharValue;
        }
        return arrayList;
    }

    @os.l
    public static final String C6(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iG3 = h0.g3(str); -1 < iG3; iG3--) {
            if (!lVar.invoke(Character.valueOf(str.charAt(iG3))).booleanValue()) {
                String strSubstring = str.substring(0, iG3 + 1);
                kn.l0.o(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return "";
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C C7(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            c10.add(lVar.invoke(Character.valueOf(charSequence.charAt(i10))));
        }
        return c10;
    }

    @f1(version = "1.4")
    @os.l
    public static final List<Character> C8(@os.l CharSequence charSequence, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        if (charSequence.length() == 0) {
            return nm.k0.INSTANCE;
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        int i10 = 1;
        while (i10 < length) {
            Character chInvoke = qVar.invoke(Integer.valueOf(i10), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i10)));
            char cCharValue = chInvoke.charValue();
            arrayList.add(chInvoke);
            i10++;
            cCharAt = cCharValue;
        }
        return arrayList;
    }

    @os.l
    public static final CharSequence D6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        int iA = f0.a(charSequence, "<this>", lVar, "predicate");
        for (int i10 = 0; i10 < iA; i10++) {
            if (!((Boolean) g0.a(charSequence, i10, lVar)).booleanValue()) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    @os.m
    @f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Character D7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iG3 = h0.g3(charSequence);
        if (iG3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        v0 v0VarA = nm.o.a(1, iG3, 1);
        while (v0VarA.hasNext()) {
            char cCharAt2 = charSequence.charAt(v0VarA.nextInt());
            R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                cCharAt = cCharAt2;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <R> List<R> D8(@os.l CharSequence charSequence, R r10, @os.l jn.p<? super R, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        if (charSequence.length() == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            r10 = pVar.invoke(r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.l
    public static final String E6(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!lVar.invoke(Character.valueOf(str.charAt(i10))).booleanValue()) {
                String strSubstring = str.substring(i10);
                kn.l0.o(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return "";
    }

    @f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char E7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int iG3 = h0.g3(charSequence);
        if (iG3 == 0) {
            return cCharAt;
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        v0 v0VarA = nm.o.a(1, iG3, 1);
        while (v0VarA.hasNext()) {
            char cCharAt2 = charSequence.charAt(v0VarA.nextInt());
            R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                cCharAt = cCharAt2;
                rInvoke = rInvoke2;
            }
        }
        return cCharAt;
    }

    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <R> List<R> E8(@os.l CharSequence charSequence, R r10, @os.l jn.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        if (charSequence.length() == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @an.f
    public static final char F6(CharSequence charSequence, int i10, jn.l<? super Integer, Character> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > h0.g3(charSequence)) ? lVar.invoke(Integer.valueOf(i10)).charValue() : charSequence.charAt(i10);
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final double F7(CharSequence charSequence, jn.l<? super Character, Double> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) g0.a(charSequence, 0, lVar)).doubleValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
        }
        return dDoubleValue;
    }

    public static char F8(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    @an.f
    public static final Character G6(CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        return j7(charSequence, i10);
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final float G7(CharSequence charSequence, jn.l<? super Character, Float> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) g0.a(charSequence, 0, lVar)).floatValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
        }
        return fFloatValue;
    }

    public static final char G8(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
                chValueOf = Character.valueOf(cCharAt);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        kn.l0.n(chValueOf, "null cannot be cast to non-null type kotlin.Char");
        return chValueOf.charValue();
    }

    @os.l
    public static final CharSequence H6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) throws IOException {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        return sb2;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R H7(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (r10.compareTo(rInvoke) < 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @os.m
    public static final Character H8(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @os.l
    public static final String I6(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) throws IOException {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R I7(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (r10.compareTo(rInvoke) < 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @os.m
    public static final Character I8(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                if (z10) {
                    return null;
                }
                chValueOf = Character.valueOf(cCharAt);
                z10 = true;
            }
        }
        if (z10) {
            return chValueOf;
        }
        return null;
    }

    @os.l
    public static final CharSequence J6(@os.l CharSequence charSequence, @os.l jn.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i10);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
            i10++;
            i11 = i12;
        }
        return sb2;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final Double J7(CharSequence charSequence, jn.l<? super Character, Double> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        double dDoubleValue = ((Number) g0.a(charSequence, 0, lVar)).doubleValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.l
    public static final CharSequence J8(@os.l CharSequence charSequence, @os.l Iterable<Integer> iterable) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(charSequence.charAt(it.next().intValue()));
        }
        return sb2;
    }

    @os.l
    public static final String K6(@os.l String str, @os.l jn.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        kn.l0.p(str, "<this>");
        kn.l0.p(pVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
            i10++;
            i11 = i12;
        }
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final Float K7(CharSequence charSequence, jn.l<? super Character, Float> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        float fFloatValue = ((Number) g0.a(charSequence, 0, lVar)).floatValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.l
    public static final CharSequence K8(@os.l CharSequence charSequence, @os.l tn.l lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? "" : h0.e5(charSequence, lVar);
    }

    @os.l
    public static final <C extends Appendable> C L6(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i10);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Character.valueOf(cCharAt)).booleanValue()) {
                c10.append(cCharAt);
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R> R L7(CharSequence charSequence, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (comparator.compare(r10, rInvoke) < 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @an.f
    public static final String L8(String str, Iterable<Integer> iterable) {
        kn.l0.p(str, "<this>");
        kn.l0.p(iterable, "indices");
        return J8(str, iterable).toString();
    }

    @os.l
    public static final CharSequence M6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) throws IOException {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        return sb2;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R> R M7(CharSequence charSequence, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (comparator.compare(r10, rInvoke) < 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @os.l
    public static final String M8(@os.l String str, @os.l tn.l lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? "" : h0.i5(str, lVar);
    }

    @os.l
    public static final String N6(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) throws IOException {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    @f1(version = "1.4")
    public static final Character N7(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (kn.l0.t(cCharAt, cCharAt2) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int N8(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Integer> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            iIntValue += ((Number) g0.a(charSequence, i10, lVar)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final <C extends Appendable> C O6(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.l<? super Character, Boolean> lVar) throws IOException {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                c10.append(cCharAt);
            }
        }
        return c10;
    }

    @f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final char O7(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (kn.l0.t(cCharAt, cCharAt2) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double O8(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Double> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            dDoubleValue += ((Number) g0.a(charSequence, i10, lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final <C extends Appendable> C P6(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.l<? super Character, Boolean> lVar) throws IOException {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                c10.append(cCharAt);
            }
        }
        return c10;
    }

    @os.m
    @f1(version = "1.4")
    public static final Character P7(@os.l CharSequence charSequence, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @s0
    @an.f
    @in.i(name = "sumOfDouble")
    @f1(version = "1.4")
    public static final double P8(CharSequence charSequence, jn.l<? super Character, Double> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            dDoubleValue += ((Number) g0.a(charSequence, i10, lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @an.f
    public static final Character Q6(CharSequence charSequence, jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    @f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final char Q7(@os.l CharSequence charSequence, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @s0
    @an.f
    @in.i(name = "sumOfInt")
    @f1(version = "1.4")
    public static final int Q8(CharSequence charSequence, jn.l<? super Character, Integer> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            iIntValue += ((Number) g0.a(charSequence, i10, lVar)).intValue();
        }
        return iIntValue;
    }

    @an.f
    public static final Character R6(CharSequence charSequence, jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char cCharAt = charSequence.charAt(length);
                if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                    return Character.valueOf(cCharAt);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @os.m
    @f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Character R7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iG3 = h0.g3(charSequence);
        if (iG3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        v0 v0VarA = nm.o.a(1, iG3, 1);
        while (v0VarA.hasNext()) {
            char cCharAt2 = charSequence.charAt(v0VarA.nextInt());
            R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                cCharAt = cCharAt2;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @s0
    @an.f
    @in.i(name = "sumOfLong")
    @f1(version = "1.4")
    public static final long R8(CharSequence charSequence, jn.l<? super Character, Long> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            jLongValue += ((Number) g0.a(charSequence, i10, lVar)).longValue();
        }
        return jLongValue;
    }

    public static char S6(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char S7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int iG3 = h0.g3(charSequence);
        if (iG3 == 0) {
            return cCharAt;
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        v0 v0VarA = nm.o.a(1, iG3, 1);
        while (v0VarA.hasNext()) {
            char cCharAt2 = charSequence.charAt(v0VarA.nextInt());
            R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                cCharAt = cCharAt2;
                rInvoke = rInvoke2;
            }
        }
        return cCharAt;
    }

    @s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @f1(version = "1.5")
    public static final int S8(CharSequence charSequence, jn.l<? super Character, w1> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = w1.m(0);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            iM += ((w1) g0.a(charSequence, i10, lVar)).f10227a;
        }
        return iM;
    }

    public static final char T6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return cCharAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final double T7(CharSequence charSequence, jn.l<? super Character, Double> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) g0.a(charSequence, 0, lVar)).doubleValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
        }
        return dDoubleValue;
    }

    @s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @f1(version = "1.5")
    public static final long T8(CharSequence charSequence, jn.l<? super Character, a2> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            jM += ((a2) g0.a(charSequence, i10, lVar)).f10177a;
        }
        return jM;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    @f1(version = "1.5")
    @an.f
    public static final <R> R U6(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        R r10;
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            r10 = (R) g0.a(charSequence, i10, lVar);
            if (r10 != null) {
                if (r10 != null) {
                    return r10;
                }
                throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
            }
        }
        r10 = null;
        if (r10 != null) {
            return r10;
        }
        throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final float U7(CharSequence charSequence, jn.l<? super Character, Float> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) g0.a(charSequence, 0, lVar)).floatValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
        }
        return fFloatValue;
    }

    @os.l
    public static final CharSequence U8(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = charSequence.length();
        if (i10 > length) {
            i10 = length;
        }
        return charSequence.subSequence(0, i10);
    }

    @f1(version = "1.5")
    @an.f
    public static final <R> R V6(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            R r10 = (R) g0.a(charSequence, i10, lVar);
            if (r10 != null) {
                return r10;
            }
        }
        return null;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R V7(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (r10.compareTo(rInvoke) > 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @os.l
    public static String V8(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        String strSubstring = str.substring(0, i10);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @os.m
    public static final Character W6(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R W7(CharSequence charSequence, jn.l<? super Character, ? extends R> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (r10.compareTo(rInvoke) > 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @os.l
    public static final CharSequence W8(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = charSequence.length();
        if (i10 > length) {
            i10 = length;
        }
        return charSequence.subSequence(length - i10, length);
    }

    @os.m
    public static final Character X6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final Double X7(CharSequence charSequence, jn.l<? super Character, Double> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        double dDoubleValue = ((Number) g0.a(charSequence, 0, lVar)).doubleValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.l
    public static String X8(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        String strSubstring = str.substring(length - i10);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @os.l
    public static final <R> List<R> Y6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            nm.d0.r0(arrayList, (Iterable) g0.a(charSequence, i10, lVar));
        }
        return arrayList;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final Float Y7(CharSequence charSequence, jn.l<? super Character, Float> lVar) {
        if (f0.a(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        float fFloatValue = ((Number) g0.a(charSequence, 0, lVar)).floatValue();
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.l
    public static final CharSequence Y8(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iG3 = h0.g3(charSequence); -1 < iG3; iG3--) {
            if (!((Boolean) g0.a(charSequence, iG3, lVar)).booleanValue()) {
                return charSequence.subSequence(iG3 + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @f1(version = "1.4")
    public static final <R> List<R> Z6(CharSequence charSequence, jn.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            nm.d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R> R Z7(CharSequence charSequence, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (comparator.compare(r10, rInvoke) > 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @os.l
    public static final String Z8(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iG3 = h0.g3(str); -1 < iG3; iG3--) {
            if (!lVar.invoke(Character.valueOf(str.charAt(iG3))).booleanValue()) {
                String strSubstring = str.substring(iG3 + 1);
                kn.l0.o(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return str;
    }

    @s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C a7(CharSequence charSequence, C c10, jn.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            nm.d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return c10;
    }

    @s0
    @f1(version = "1.4")
    @an.f
    public static final <R> R a8(CharSequence charSequence, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R r10 = (R) g0.a(charSequence, 0, lVar);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(it.nextInt())));
            if (comparator.compare(r10, rInvoke) > 0) {
                r10 = rInvoke;
            }
        }
        return r10;
    }

    @os.l
    public static final CharSequence a9(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        int iA = f0.a(charSequence, "<this>", lVar, "predicate");
        for (int i10 = 0; i10 < iA; i10++) {
            if (!((Boolean) g0.a(charSequence, i10, lVar)).booleanValue()) {
                return charSequence.subSequence(0, i10);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C b7(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            nm.d0.r0(c10, (Iterable) g0.a(charSequence, i10, lVar));
        }
        return c10;
    }

    @os.m
    @f1(version = "1.4")
    public static final Character b8(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (kn.l0.t(cCharAt, cCharAt2) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @os.l
    public static final String b9(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!lVar.invoke(Character.valueOf(str.charAt(i10))).booleanValue()) {
                String strSubstring = str.substring(0, i10);
                kn.l0.o(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return str;
    }

    public static final <R> R c7(@os.l CharSequence charSequence, R r10, @os.l jn.p<? super R, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            r10 = pVar.invoke(r10, Character.valueOf(charSequence.charAt(i10)));
        }
        return r10;
    }

    @f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final char c8(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (kn.l0.t(cCharAt, cCharAt2) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @os.l
    public static final <C extends Collection<? super Character>> C c9(@os.l CharSequence charSequence, @os.l C c10) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            c10.add(Character.valueOf(charSequence.charAt(i10)));
        }
        return c10;
    }

    public static final <R> R d7(@os.l CharSequence charSequence, R r10, @os.l jn.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Character.valueOf(charSequence.charAt(i10)));
            i10++;
            i11++;
        }
        return r10;
    }

    @os.m
    @f1(version = "1.4")
    public static final Character d8(@os.l CharSequence charSequence, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @os.l
    public static final HashSet<Character> d9(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length > 128) {
            length = 128;
        }
        return (HashSet) c9(charSequence, new HashSet(c1.j(length)));
    }

    public static final boolean e6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!((Boolean) g0.a(charSequence, i10, lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <R> R e7(@os.l CharSequence charSequence, R r10, @os.l jn.p<? super Character, ? super R, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iG3 = h0.g3(charSequence); iG3 >= 0; iG3--) {
            r10 = pVar.invoke(Character.valueOf(charSequence.charAt(iG3)), r10);
        }
        return r10;
    }

    @f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final char e8(@os.l CharSequence charSequence, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @os.l
    public static List<Character> e9(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            return length != 1 ? f9(charSequence) : nm.x.k(Character.valueOf(charSequence.charAt(0)));
        }
        return nm.k0.INSTANCE;
    }

    public static final boolean f6(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return !(charSequence.length() == 0);
    }

    public static final <R> R f7(@os.l CharSequence charSequence, R r10, @os.l jn.q<? super Integer, ? super Character, ? super R, ? extends R> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iG3 = h0.g3(charSequence); iG3 >= 0; iG3--) {
            r10 = qVar.invoke(Integer.valueOf(iG3), Character.valueOf(charSequence.charAt(iG3)), r10);
        }
        return r10;
    }

    public static final boolean f8(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    @os.l
    public static final List<Character> f9(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return (List) c9(charSequence, new ArrayList(charSequence.length()));
    }

    public static final boolean g6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (((Boolean) g0.a(charSequence, i10, lVar)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final void g7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, l2> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            lVar.invoke(Character.valueOf(charSequence.charAt(i10)));
        }
    }

    public static final boolean g8(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (((Boolean) g0.a(charSequence, i10, lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final Set<Character> g9(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            return nm.m0.INSTANCE;
        }
        if (length == 1) {
            return n1.f(Character.valueOf(charSequence.charAt(0)));
        }
        int length2 = charSequence.length();
        if (length2 > 128) {
            length2 = 128;
        }
        return (Set) c9(charSequence, new LinkedHashSet(c1.j(length2)));
    }

    @os.l
    public static final Iterable<Character> h6(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return ((charSequence instanceof String) && ((String) charSequence).length() == 0) ? nm.k0.INSTANCE : new a(charSequence);
    }

    public static final void h7(@os.l CharSequence charSequence, @os.l jn.p<? super Integer, ? super Character, l2> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            pVar.invoke(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10)));
            i10++;
            i11++;
        }
    }

    @f1(version = "1.1")
    @os.l
    public static final <S extends CharSequence> S h8(@os.l S s10, @os.l jn.l<? super Character, l2> lVar) {
        kn.l0.p(s10, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (int i10 = 0; i10 < s10.length(); i10++) {
            lVar.invoke(Character.valueOf(s10.charAt(i10)));
        }
        return s10;
    }

    @f1(version = "1.2")
    @os.l
    public static final List<String> h9(@os.l CharSequence charSequence, int i10, int i11, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        return i9(charSequence, i10, i11, z10, e.INSTANCE);
    }

    @os.l
    public static final gq.m<Character> i6(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return ((charSequence instanceof String) && ((String) charSequence).length() == 0) ? gq.g.f6836a : new b(charSequence);
    }

    @an.f
    public static final char i7(CharSequence charSequence, int i10, jn.l<? super Integer, Character> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > h0.g3(charSequence)) ? lVar.invoke(Integer.valueOf(i10)).charValue() : charSequence.charAt(i10);
    }

    @f1(version = "1.4")
    @os.l
    public static final <S extends CharSequence> S i8(@os.l S s10, @os.l jn.p<? super Integer, ? super Character, l2> pVar) {
        kn.l0.p(s10, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int i10 = 0;
        int i11 = 0;
        while (i10 < s10.length()) {
            pVar.invoke(Integer.valueOf(i11), Character.valueOf(s10.charAt(i10)));
            i10++;
            i11++;
        }
        return s10;
    }

    @f1(version = "1.2")
    @os.l
    public static final <R> List<R> i9(@os.l CharSequence charSequence, int i10, int i11, boolean z10, @os.l jn.l<? super CharSequence, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        nm.r1.a(i10, i11);
        int length = charSequence.length();
        int i12 = 0;
        ArrayList arrayList = new ArrayList((length / i11) + (length % i11 == 0 ? 0 : 1));
        while (i12 >= 0 && i12 < length) {
            int i13 = i12 + i10;
            if (i13 < 0 || i13 > length) {
                if (!z10) {
                    break;
                }
                i13 = length;
            }
            arrayList.add(lVar.invoke(charSequence.subSequence(i12, i13)));
            i12 += i11;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <K, V> Map<K, V> j6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(charSequence.length());
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            t0 t0Var = (t0) g0.a(charSequence, i10, lVar);
            linkedHashMap.put(t0Var.getFirst(), t0Var.getSecond());
        }
        return linkedHashMap;
    }

    @os.m
    public static Character j7(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0 || i10 > h0.g3(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i10));
    }

    @os.l
    public static final t0<CharSequence, CharSequence> j8(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            } else {
                sb3.append(cCharAt);
            }
        }
        return new t0<>(sb2, sb3);
    }

    public static /* synthetic */ List j9(CharSequence charSequence, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return h9(charSequence, i10, i11, z10);
    }

    @os.l
    public static final <K> Map<K, Character> k6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(charSequence.length());
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            linkedHashMap.put(lVar.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @os.l
    public static final <K> Map<K, List<Character>> k7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @os.l
    public static final t0<String, String> k8(@os.l String str, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(lVar, "predicate");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            } else {
                sb3.append(cCharAt);
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        String string2 = sb3.toString();
        kn.l0.o(string2, "toString(...)");
        return new t0<>(string, string2);
    }

    public static /* synthetic */ List k9(CharSequence charSequence, int i10, int i11, boolean z10, jn.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return i9(charSequence, i10, i11, z10, lVar);
    }

    @os.l
    public static final <K, V> Map<K, V> l6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(charSequence.length());
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            linkedHashMap.put(lVar.invoke(Character.valueOf(cCharAt)), lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @os.l
    public static final <K, V> Map<K, List<V>> l7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @an.f
    public static final char l8(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return m8(charSequence, rn.f.Default);
    }

    @f1(version = "1.2")
    @os.l
    public static final gq.m<String> l9(@os.l CharSequence charSequence, int i10, int i11, boolean z10) {
        kn.l0.p(charSequence, "<this>");
        return m9(charSequence, i10, i11, z10, f.INSTANCE);
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Character>> M m6(@os.l CharSequence charSequence, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            m10.put(lVar.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return m10;
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Character>>> M m7(@os.l CharSequence charSequence, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Character.valueOf(cCharAt));
        }
        return m10;
    }

    @f1(version = "1.3")
    public static final char m8(@os.l CharSequence charSequence, @os.l rn.f fVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(fVar, "random");
        if (charSequence.length() != 0) {
            return charSequence.charAt(fVar.nextInt(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @f1(version = "1.2")
    @os.l
    public static final <R> gq.m<R> m9(@os.l CharSequence charSequence, int i10, int i11, boolean z10, @os.l jn.l<? super CharSequence, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        nm.r1.a(i10, i11);
        return gq.v.k1(nm.h0.A1(tn.u.B1(z10 ? h0.f3(charSequence) : tn.u.W1(0, (charSequence.length() - i10) + 1), i11)), new g(i10, charSequence, lVar));
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M n6(@os.l CharSequence charSequence, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            m10.put(lVar.invoke(Character.valueOf(cCharAt)), lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return m10;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M n7(@os.l CharSequence charSequence, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return m10;
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Character n8(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return o8(charSequence, rn.f.Default);
    }

    public static /* synthetic */ gq.m n9(CharSequence charSequence, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return l9(charSequence, i10, i11, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M o6(@os.l CharSequence charSequence, @os.l M m10, @os.l jn.l<? super Character, ? extends t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            t0 t0Var = (t0) g0.a(charSequence, i10, lVar);
            m10.put(t0Var.getFirst(), t0Var.getSecond());
        }
        return m10;
    }

    @f1(version = "1.1")
    @os.l
    public static final <K> nm.o0<Character, K> o7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "keySelector");
        return new d(charSequence, lVar);
    }

    @os.m
    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Character o8(@os.l CharSequence charSequence, @os.l rn.f fVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(fVar, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(fVar.nextInt(charSequence.length())));
    }

    public static /* synthetic */ gq.m o9(CharSequence charSequence, int i10, int i11, boolean z10, jn.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return m9(charSequence, i10, i11, z10, lVar);
    }

    @f1(version = "1.3")
    @os.l
    public static final <V> Map<Character, V> p6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends V> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int length = charSequence.length();
        if (length > 128) {
            length = 128;
        }
        int iJ = c1.j(length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            linkedHashMap.put(Character.valueOf(cCharAt), lVar.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final int p7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        int iA = f0.a(charSequence, "<this>", lVar, "predicate");
        for (int i10 = 0; i10 < iA; i10++) {
            if (((Boolean) g0.a(charSequence, i10, lVar)).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    public static final char p8(@os.l CharSequence charSequence, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(it.nextInt()))).charValue();
        }
        return cCharAt;
    }

    @os.l
    public static final Iterable<nm.s0<Character>> p9(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return new nm.t0(new h(charSequence));
    }

    @f1(version = "1.3")
    @os.l
    public static final <V, M extends Map<? super Character, ? super V>> M q6(@os.l CharSequence charSequence, @os.l M m10, @os.l jn.l<? super Character, ? extends V> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            m10.put(Character.valueOf(cCharAt), lVar.invoke(Character.valueOf(cCharAt)));
        }
        return m10;
    }

    public static final int q7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (((Boolean) g0.a(charSequence, length, lVar)).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    public static final char q8(@os.l CharSequence charSequence, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            cCharAt = qVar.invoke(Integer.valueOf(iNextInt), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(iNextInt))).charValue();
        }
        return cCharAt;
    }

    @os.l
    public static final List<t0<Character, Character>> q9(@os.l CharSequence charSequence, @os.l CharSequence charSequence2) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "other");
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new t0(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(charSequence2.charAt(i10))));
        }
        return arrayList;
    }

    @f1(version = "1.2")
    @os.l
    public static List<String> r6(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        return h9(charSequence, i10, i10, true);
    }

    public static char r7(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(h0.g3(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @os.m
    @f1(version = "1.4")
    public static final Character r8(@os.l CharSequence charSequence, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            cCharAt = qVar.invoke(Integer.valueOf(iNextInt), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(iNextInt))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @os.l
    public static final <V> List<V> r9(@os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l jn.p<? super Character, ? super Character, ? extends V> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(charSequence2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(charSequence2.charAt(i10))));
        }
        return arrayList;
    }

    @f1(version = "1.2")
    @os.l
    public static final <R> List<R> s6(@os.l CharSequence charSequence, int i10, @os.l jn.l<? super CharSequence, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        return i9(charSequence, i10, i10, true, lVar);
    }

    public static final char s7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char cCharAt = charSequence.charAt(length);
                if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                    return cCharAt;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @os.m
    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Character s8(@os.l CharSequence charSequence, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        v0 it = new tn.l(1, h0.g3(charSequence), 1).iterator();
        while (it.hasNext()) {
            cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(it.nextInt()))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @f1(version = "1.2")
    @os.l
    public static final List<t0<Character, Character>> s9(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return nm.k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(length);
        int i10 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            i10++;
            arrayList.add(new t0(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i10))));
        }
        return arrayList;
    }

    @f1(version = "1.2")
    @os.l
    public static final gq.m<String> t6(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        return u6(charSequence, i10, c.INSTANCE);
    }

    @os.m
    public static final Character t7(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final char t8(@os.l CharSequence charSequence, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        int iG3 = h0.g3(charSequence);
        if (iG3 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(iG3);
        for (int i10 = iG3 - 1; i10 >= 0; i10--) {
            cCharAt = pVar.invoke(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    @f1(version = "1.2")
    @os.l
    public static final <R> List<R> t9(@os.l CharSequence charSequence, @os.l jn.p<? super Character, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return nm.k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(length);
        int i10 = 0;
        while (i10 < length) {
            Character chValueOf = Character.valueOf(charSequence.charAt(i10));
            i10++;
            arrayList.add(pVar.invoke(chValueOf, Character.valueOf(charSequence.charAt(i10))));
        }
        return arrayList;
    }

    @f1(version = "1.2")
    @os.l
    public static final <R> gq.m<R> u6(@os.l CharSequence charSequence, int i10, @os.l jn.l<? super CharSequence, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        return m9(charSequence, i10, i10, true, lVar);
    }

    @os.m
    public static final Character u7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            char cCharAt = charSequence.charAt(length);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    public static final char u8(@os.l CharSequence charSequence, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        int iG3 = h0.g3(charSequence);
        if (iG3 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(iG3);
        for (int i10 = iG3 - 1; i10 >= 0; i10--) {
            cCharAt = qVar.invoke(Integer.valueOf(i10), Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    @an.f
    public static final int v6(CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        return charSequence.length();
    }

    @os.l
    public static final <R> List<R> v7(@os.l CharSequence charSequence, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            arrayList.add(lVar.invoke(Character.valueOf(charSequence.charAt(i10))));
        }
        return arrayList;
    }

    @os.m
    @f1(version = "1.4")
    public static final Character v8(@os.l CharSequence charSequence, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(qVar, "operation");
        int iG3 = h0.g3(charSequence);
        if (iG3 < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(iG3);
        for (int i10 = iG3 - 1; i10 >= 0; i10--) {
            cCharAt = qVar.invoke(Integer.valueOf(i10), Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    public static final int w6(@os.l CharSequence charSequence, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (((Boolean) g0.a(charSequence, i11, lVar)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final <R> List<R> w7(@os.l CharSequence charSequence, @os.l jn.p<? super Integer, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @os.m
    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Character w8(@os.l CharSequence charSequence, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        int iG3 = h0.g3(charSequence);
        if (iG3 < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(iG3);
        for (int i10 = iG3 - 1; i10 >= 0; i10--) {
            cCharAt = pVar.invoke(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @os.l
    public static final CharSequence x6(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = charSequence.length();
        if (i10 > length) {
            i10 = length;
        }
        return charSequence.subSequence(i10, charSequence.length());
    }

    @os.l
    public static final <R> List<R> x7(@os.l CharSequence charSequence, @os.l jn.p<? super Integer, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            int i12 = i11 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10)));
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @os.l
    public static final CharSequence x8(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "<this>");
        StringBuilder sbReverse = new StringBuilder(charSequence).reverse();
        kn.l0.o(sbReverse, "reverse(...)");
        return sbReverse;
    }

    @os.l
    public static String y6(@os.l String str, int i10) {
        kn.l0.p(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = str.length();
        if (i10 > length) {
            i10 = length;
        }
        String strSubstring = str.substring(i10);
        kn.l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C y7(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.p<? super Integer, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            int i12 = i11 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10)));
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @an.f
    public static final String y8(String str) {
        kn.l0.p(str, "<this>");
        return x8(str).toString();
    }

    @os.l
    public static final CharSequence z6(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested character count ", i10, " is less than zero.").toString());
        }
        int length = charSequence.length() - i10;
        if (length < 0) {
            length = 0;
        }
        return U8(charSequence, length);
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C z7(@os.l CharSequence charSequence, @os.l C c10, @os.l jn.p<? super Integer, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return c10;
    }

    @f1(version = "1.4")
    @os.l
    public static final <R> List<R> z8(@os.l CharSequence charSequence, R r10, @os.l jn.p<? super R, ? super Character, ? extends R> pVar) {
        kn.l0.p(charSequence, "<this>");
        kn.l0.p(pVar, "operation");
        if (charSequence.length() == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            r10 = pVar.invoke(r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }
}
