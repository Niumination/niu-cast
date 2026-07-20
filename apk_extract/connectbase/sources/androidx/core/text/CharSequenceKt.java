package androidx.core.text;

import android.text.TextUtils;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(@l CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(@l CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
