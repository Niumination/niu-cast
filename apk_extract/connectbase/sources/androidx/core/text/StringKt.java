package androidx.core.text;

import android.text.TextUtils;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class StringKt {
    @l
    public static final String htmlEncode(@l String str) {
        l0.p(str, "<this>");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        l0.o(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
