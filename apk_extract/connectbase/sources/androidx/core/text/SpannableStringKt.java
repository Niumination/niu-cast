package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import b.a;
import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSpannableString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 2 SpannedString.kt\nandroidx/core/text/SpannedStringKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,68:1\n31#2,4:69\n13579#3,2:73\n*S KotlinDebug\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n34#1:69,4\n34#1:73,2\n*E\n"})
public final class SpannableStringKt {
    @a({"SyntheticAccessor"})
    public static final void clearSpans(@l Spannable spannable) {
        l0.p(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        l0.o(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@l Spannable spannable, int i10, int i11, @l Object obj) {
        l0.p(spannable, "<this>");
        l0.p(obj, "span");
        spannable.setSpan(obj, i10, i11, 17);
    }

    @l
    public static final Spannable toSpannable(@l CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        l0.o(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(@l Spannable spannable, @l tn.l lVar, @l Object obj) {
        l0.p(spannable, "<this>");
        l0.p(lVar, "range");
        l0.p(obj, "span");
        spannable.setSpan(obj, lVar.f15911a, lVar.f15912b, 17);
    }
}
