package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSpannableStringBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n1#1,163:1\n74#1,4:164\n74#1,4:168\n74#1,4:172\n74#1,4:176\n74#1,4:180\n74#1,4:184\n74#1,4:188\n74#1,4:192\n74#1,4:196\n*S KotlinDebug\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n87#1:164,4\n96#1:168,4\n105#1:172,4\n115#1:176,4\n125#1:180,4\n134#1:184,4\n144#1:188,4\n153#1:192,4\n162#1:196,4\n*E\n"})
public final class SpannableStringBuilderKt {
    @l
    public static final SpannableStringBuilder backgroundColor(@l SpannableStringBuilder spannableStringBuilder, @ColorInt int i10, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i10);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder bold(@l SpannableStringBuilder spannableStringBuilder, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannedString buildSpannedString(@l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(lVar, "builderAction");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        lVar.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @l
    public static final SpannableStringBuilder color(@l SpannableStringBuilder spannableStringBuilder, @ColorInt int i10, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i10);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder inSpans(@l SpannableStringBuilder spannableStringBuilder, @l Object[] objArr, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(objArr, "spans");
        l0.p(lVar, "builderAction");
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        for (Object obj : objArr) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder italic(@l SpannableStringBuilder spannableStringBuilder, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder scale(@l SpannableStringBuilder spannableStringBuilder, float f10, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f10);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder strikeThrough(@l SpannableStringBuilder spannableStringBuilder, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder subscript(@l SpannableStringBuilder spannableStringBuilder, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder superscript(@l SpannableStringBuilder spannableStringBuilder, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder underline(@l SpannableStringBuilder spannableStringBuilder, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(lVar, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @l
    public static final SpannableStringBuilder inSpans(@l SpannableStringBuilder spannableStringBuilder, @l Object obj, @l jn.l<? super SpannableStringBuilder, l2> lVar) {
        l0.p(spannableStringBuilder, "<this>");
        l0.p(obj, "span");
        l0.p(lVar, "builderAction");
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
