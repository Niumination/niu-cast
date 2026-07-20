package jq;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,397:1\n1789#2,3:398\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n19#1:398,3\n*E\n"})
public final class s {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt$fromInt$1$1\n*L\n1#1,397:1\n*E\n"})
    public static final class a<T> extends kn.n0 implements jn.l<T, Boolean> {
        final /* synthetic */ int $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10) {
            super(1);
            this.$value = i10;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.l
        @os.l
        public final Boolean invoke(Enum r10) {
            i iVar = (i) r10;
            return Boolean.valueOf((this.$value & iVar.getMask()) == iVar.getValue());
        }
    }

    public static final p f(Matcher matcher, int i10, CharSequence charSequence) {
        if (matcher.find(i10)) {
            return new q(matcher, charSequence);
        }
        return null;
    }

    public static final <T extends Enum<T> & i> Set<T> g(int i10) {
        kn.l0.P();
        EnumSet enumSetAllOf = EnumSet.allOf(Enum.class);
        kn.l0.m(enumSetAllOf);
        kn.l0.P();
        nm.d0.Q0(enumSetAllOf, new a(i10));
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        kn.l0.o(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public static final p h(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new q(matcher, charSequence);
        }
        return null;
    }

    public static final tn.l i(MatchResult matchResult) {
        return tn.u.W1(matchResult.start(), matchResult.end());
    }

    public static final tn.l j(MatchResult matchResult, int i10) {
        return tn.u.W1(matchResult.start(i10), matchResult.end(i10));
    }

    public static final int k(Iterable<? extends i> iterable) {
        Iterator<? extends i> it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= it.next().getValue();
        }
        return value;
    }
}
