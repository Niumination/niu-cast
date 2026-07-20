package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class HtmlKt {
    @l
    public static final Spanned parseAsHtml(@l String str, int i10, @m Html.ImageGetter imageGetter, @m Html.TagHandler tagHandler) {
        l0.p(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i10, imageGetter, tagHandler);
        l0.o(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            imageGetter = null;
        }
        if ((i11 & 4) != 0) {
            tagHandler = null;
        }
        l0.p(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i10, imageGetter, tagHandler);
        l0.o(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    @l
    public static final String toHtml(@l Spanned spanned, int i10) {
        l0.p(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i10);
        l0.o(html, "toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        l0.p(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i10);
        l0.o(html, "toHtml(this, option)");
        return html;
    }
}
