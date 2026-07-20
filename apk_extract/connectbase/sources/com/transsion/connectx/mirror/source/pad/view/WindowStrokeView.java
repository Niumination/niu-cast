package com.transsion.connectx.mirror.source.pad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.transsion.connectx.mirror.source.R;
import in.j;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class WindowStrokeView extends LinearLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public WindowStrokeView(@l Context context) {
        this(context, null, 0, 6, null);
        l0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public WindowStrokeView(@l Context context, @m AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        l0.p(context, "context");
    }

    public /* synthetic */ WindowStrokeView(Context context, AttributeSet attributeSet, int i10, int i11, w wVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @j
    public WindowStrokeView(@l Context context, @m AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l0.p(context, "context");
        View.inflate(context, R.layout.window_stroke, this);
    }
}
