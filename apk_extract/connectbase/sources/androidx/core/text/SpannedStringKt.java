package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class SpannedStringKt {
    public static final <T> T[] getSpans(Spanned spanned, int i10, int i11) {
        l0.p(spanned, "<this>");
        l0.P();
        T[] tArr = (T[]) spanned.getSpans(i10, i11, Object.class);
        l0.o(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static Object[] getSpans$default(Spanned spanned, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = spanned.length();
        }
        l0.p(spanned, "<this>");
        l0.P();
        Object[] spans = spanned.getSpans(i10, i11, Object.class);
        l0.o(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @l
    public static final Spanned toSpanned(@l CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        SpannedString spannedStringValueOf = SpannedString.valueOf(charSequence);
        l0.o(spannedStringValueOf, "valueOf(this)");
        return spannedStringValueOf;
    }
}
