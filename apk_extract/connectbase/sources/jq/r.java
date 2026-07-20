package jq;

import ik.y0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kn.r1;
import lm.d1;
import lm.f1;
import lm.l2;
import lm.p2;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,397:1\n22#2,3:398\n1#3:401\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n103#1:398,3\n*E\n"})
public final class r implements Serializable {

    @os.l
    public static final a Companion = new a();

    @os.m
    private Set<? extends t> _options;

    @os.l
    private final Pattern nativePattern;

    public static final class a {
        public a() {
        }

        public final int b(int i10) {
            return (i10 & 2) != 0 ? i10 | 64 : i10;
        }

        @os.l
        public final String c(@os.l String str) {
            kn.l0.p(str, "literal");
            String strQuote = Pattern.quote(str);
            kn.l0.o(strQuote, "quote(...)");
            return strQuote;
        }

        @os.l
        public final String d(@os.l String str) {
            kn.l0.p(str, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(str);
            kn.l0.o(strQuoteReplacement, "quoteReplacement(...)");
            return strQuoteReplacement;
        }

        @os.l
        public final r e(@os.l String str) {
            kn.l0.p(str, "literal");
            return new r(str, t.LITERAL);
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b implements Serializable {

        @os.l
        public static final a Companion = new a();
        private static final long serialVersionUID = 0;
        private final int flags;

        @os.l
        private final String pattern;

        public static final class a {
            public a() {
            }

            public a(kn.w wVar) {
            }
        }

        public b(@os.l String str, int i10) {
            kn.l0.p(str, "pattern");
            this.pattern = str;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            kn.l0.o(patternCompile, "compile(...)");
            return new r(patternCompile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @os.l
        public final String getPattern() {
            return this.pattern;
        }
    }

    public static final class c extends kn.n0 implements jn.a<p> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence, int i10) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i10;
        }

        @Override // jn.a
        @os.m
        public final p invoke() {
            return r.this.find(this.$input, this.$startIndex);
        }
    }

    public /* synthetic */ class d extends kn.h0 implements jn.l<p, p> {
        public static final d INSTANCE = new d();

        public d() {
            super(1, p.class, y0.b.f8223h, "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // jn.l
        @os.m
        public final p invoke(@os.l p pVar) {
            kn.l0.p(pVar, "p0");
            return pVar.next();
        }
    }

    @r1({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt$fromInt$1$1\n*L\n1#1,397:1\n*E\n"})
    public static final class e extends kn.n0 implements jn.l<t, Boolean> {
        final /* synthetic */ int $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i10) {
            super(1);
            this.$value = i10;
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(t tVar) {
            t tVar2 = tVar;
            return Boolean.valueOf((this.$value & tVar2.getMask()) == tVar2.getValue());
        }
    }

    @xm.f(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {275, 283, 287}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    public static final class f extends xm.k implements jn.p<gq.o<? super String>, um.d<? super l2>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(CharSequence charSequence, int i10, um.d<? super f> dVar) {
            super(2, dVar);
            this.$input = charSequence;
            this.$limit = i10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            f fVar = r.this.new f(this.$input, this.$limit, dVar);
            fVar.L$0 = obj;
            return fVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super String> oVar, @os.m um.d<? super l2> dVar) {
            return ((f) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x006e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0079  */
        /* JADX WARN: Code duplicated, block: B:27:0x009a A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006c -> B:21:0x006f). Please report as a decompilation issue!!! */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            gq.o oVar;
            Matcher matcher;
            int i10;
            String string;
            String string2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = this.label;
            if (i11 == 0) {
                d1.n(obj);
                gq.o oVar2 = (gq.o) this.L$0;
                Matcher matcher2 = r.this.nativePattern.matcher(this.$input);
                if (this.$limit != 1 && matcher2.find()) {
                    int iEnd = 0;
                    oVar = oVar2;
                    matcher = matcher2;
                    i10 = 0;
                    string = this.$input.subSequence(iEnd, matcher.start()).toString();
                    this.L$0 = oVar;
                    this.L$1 = matcher;
                    this.I$0 = i10;
                    this.label = 2;
                    if (oVar.a(string, this) == aVar) {
                        return aVar;
                    }
                    iEnd = matcher.end();
                    i10++;
                    if (i10 != this.$limit - 1) {
                    }
                    CharSequence charSequence = this.$input;
                    string2 = charSequence.subSequence(iEnd, charSequence.length()).toString();
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    if (oVar.a(string2, this) == aVar) {
                        return aVar;
                    }
                    return l2.f10208a;
                }
                String string3 = this.$input.toString();
                this.label = 1;
                if (oVar2.a(string3, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    if (i11 == 2) {
                        i10 = this.I$0;
                        Matcher matcher3 = (Matcher) this.L$1;
                        oVar = (gq.o) this.L$0;
                        d1.n(obj);
                        matcher = matcher3;
                        iEnd = matcher.end();
                        i10++;
                        if (i10 != this.$limit - 1 || !matcher.find()) {
                            CharSequence charSequence2 = this.$input;
                            string2 = charSequence2.subSequence(iEnd, charSequence2.length()).toString();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            if (oVar.a(string2, this) == aVar) {
                                return aVar;
                            }
                        }
                        string = this.$input.subSequence(iEnd, matcher.start()).toString();
                        this.L$0 = oVar;
                        this.L$1 = matcher;
                        this.I$0 = i10;
                        this.label = 2;
                        if (oVar.a(string, this) == aVar) {
                            return aVar;
                        }
                        iEnd = matcher.end();
                        i10++;
                        if (i10 != this.$limit - 1) {
                        }
                        CharSequence charSequence3 = this.$input;
                        string2 = charSequence3.subSequence(iEnd, charSequence3.length()).toString();
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 3;
                        if (oVar.a(string2, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i11 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
    }

    @z0
    public r(@os.l Pattern pattern) {
        kn.l0.p(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ p find$default(r rVar, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return rVar.find(charSequence, i10);
    }

    public static /* synthetic */ gq.m findAll$default(r rVar, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return rVar.findAll(charSequence, i10);
    }

    public static /* synthetic */ List split$default(r rVar, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return rVar.split(charSequence, i10);
    }

    public static /* synthetic */ gq.m splitToSequence$default(r rVar, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return rVar.splitToSequence(charSequence, i10);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        kn.l0.o(strPattern, "pattern(...)");
        return new b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @os.m
    public final p find(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kn.l0.o(matcher, "matcher(...)");
        return s.f(matcher, i10, charSequence);
    }

    @os.l
    public final gq.m<p> findAll(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "input");
        if (i10 >= 0 && i10 <= charSequence.length()) {
            return gq.s.n(new c(charSequence, i10), d.INSTANCE);
        }
        StringBuilder sbA = h.b.a("Start index out of bounds: ", i10, ", input length: ");
        sbA.append(charSequence.length());
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @os.l
    public final Set<t> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(t.class);
        kn.l0.m(enumSetAllOf);
        nm.d0.Q0(enumSetAllOf, new e(iFlags));
        Set<t> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        kn.l0.o(setUnmodifiableSet, "unmodifiableSet(...)");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    @os.l
    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        kn.l0.o(strPattern, "pattern(...)");
        return strPattern;
    }

    @os.m
    @f1(version = "1.7")
    @p2(markerClass = {lm.r.class})
    public final p matchAt(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "input");
        Matcher matcherRegion = this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i10, charSequence.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        kn.l0.m(matcherRegion);
        return new q(matcherRegion, charSequence);
    }

    @os.m
    public final p matchEntire(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kn.l0.o(matcher, "matcher(...)");
        return s.h(matcher, charSequence);
    }

    public final boolean matches(@os.l CharSequence charSequence) {
        kn.l0.p(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @f1(version = "1.7")
    @p2(markerClass = {lm.r.class})
    public final boolean matchesAt(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "input");
        return this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i10, charSequence.length()).lookingAt();
    }

    @os.l
    public final String replace(@os.l CharSequence charSequence, @os.l String str) {
        kn.l0.p(charSequence, "input");
        kn.l0.p(str, "replacement");
        String strReplaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        kn.l0.o(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    @os.l
    public final String replaceFirst(@os.l CharSequence charSequence, @os.l String str) {
        kn.l0.p(charSequence, "input");
        kn.l0.p(str, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        kn.l0.o(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    @os.l
    public final List<String> split(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "input");
        h0.K4(i10);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (i10 == 1 || !matcher.find()) {
            return nm.x.k(charSequence.toString());
        }
        int i11 = 10;
        if (i10 > 0 && i10 <= 10) {
            i11 = i10;
        }
        ArrayList arrayList = new ArrayList(i11);
        int i12 = i10 - 1;
        int iEnd = 0;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i12 >= 0 && arrayList.size() == i12) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    @f1(version = "1.6")
    @p2(markerClass = {lm.r.class})
    @os.l
    public final gq.m<String> splitToSequence(@os.l CharSequence charSequence, int i10) {
        kn.l0.p(charSequence, "input");
        h0.K4(i10);
        return gq.q.b(new f(charSequence, i10, null));
    }

    @os.l
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @os.l
    public String toString() {
        String string = this.nativePattern.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.l
    public final String replace(@os.l CharSequence charSequence, @os.l jn.l<? super p, ? extends CharSequence> lVar) {
        kn.l0.p(charSequence, "input");
        kn.l0.p(lVar, "transform");
        int i10 = 0;
        p pVarFind$default = find$default(this, charSequence, 0, 2, null);
        if (pVarFind$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(charSequence, i10, pVarFind$default.c().f15911a);
            sb2.append(lVar.invoke(pVarFind$default));
            i10 = pVarFind$default.c().f15912b + 1;
            pVarFind$default = pVarFind$default.next();
            if (i10 >= length) {
                break;
            }
        } while (pVarFind$default != null);
        if (i10 < length) {
            sb2.append(charSequence, i10, length);
        }
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(@os.l String str) {
        kn.l0.p(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        kn.l0.o(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(@os.l String str, @os.l t tVar) {
        kn.l0.p(str, "pattern");
        kn.l0.p(tVar, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.b(tVar.getValue()));
        kn.l0.o(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(@os.l String str, @os.l Set<? extends t> set) {
        kn.l0.p(str, "pattern");
        kn.l0.p(set, "options");
        Pattern patternCompile = Pattern.compile(str, Companion.b(s.k(set)));
        kn.l0.o(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
