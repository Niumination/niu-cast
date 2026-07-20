package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import b.a;
import java.util.Locale;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@a({"ClassVerificationFailure"})
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(@l Locale locale) {
        l0.p(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
