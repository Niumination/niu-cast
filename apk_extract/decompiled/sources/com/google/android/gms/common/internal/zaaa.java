package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    public static final int a(int i8, int i9, int i10, int i11) {
        if (i8 == 0) {
            return i9;
        }
        if (i8 == 1) {
            return i10;
        }
        if (i8 == 2) {
            return i11;
        }
        throw new IllegalStateException(a1.a.o(i8, "Unknown color scheme: "));
    }
}
