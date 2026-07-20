package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kn.l0;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class ContextKt {
    public static final <T> T getSystemService(Context context) {
        l0.p(context, "<this>");
        l0.P();
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(@l Context context, @m AttributeSet attributeSet, @l int[] iArr, @AttrRes int i10, @StyleRes int i11, @l jn.l<? super TypedArray, l2> lVar) {
        l0.p(context, "<this>");
        l0.p(iArr, "attrs");
        l0.p(lVar, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        lVar.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, jn.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            attributeSet = null;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        l0.p(context, "<this>");
        l0.p(iArr, "attrs");
        l0.p(lVar, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        lVar.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@l Context context, @StyleRes int i10, @l int[] iArr, @l jn.l<? super TypedArray, l2> lVar) {
        l0.p(context, "<this>");
        l0.p(iArr, "attrs");
        l0.p(lVar, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, iArr);
        l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        lVar.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
