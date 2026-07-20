package com.transsion.connectx.mirror.source.pad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.transsion.connectx.mirror.source.R;
import in.j;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public class WindowButton extends RelativeLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public WindowButton(@l Context context) {
        this(context, null, 0, 6, null);
        l0.p(context, "context");
    }

    public final void setImageSrc(int i10) {
        ImageView imageView = (ImageView) findViewById(R.id.button_image);
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
    }

    public void setLineVisible(boolean z10) {
    }

    public final void setText(@l String str) {
        l0.p(str, "text");
        TextView textView = (TextView) findViewById(R.id.button_text);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public WindowButton(@l Context context, @m AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        l0.p(context, "context");
    }

    public /* synthetic */ WindowButton(Context context, AttributeSet attributeSet, int i10, int i11, w wVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @j
    public WindowButton(@l Context context, @m AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l0.p(context, "context");
    }
}
