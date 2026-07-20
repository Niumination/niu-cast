package com.transsion.connectx.mirror.source.pad.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.connectx.mirror.source.R;
import in.j;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortCutTextView extends LinearLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public ShortCutTextView(@l Context context) {
        this(context, null, 0, 6, null);
        l0.p(context, "context");
    }

    public final void a(@l String str, @l String str2, @l String str3) {
        l0.p(str, "textLeft");
        l0.p(str2, "textCenter");
        l0.p(str3, "textRight");
        TextView textView = (TextView) findViewById(R.id.text_left);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) findViewById(R.id.text_center);
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = (TextView) findViewById(R.id.text_right);
        if (textView3 == null) {
            return;
        }
        textView3.setText(str3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public ShortCutTextView(@l Context context, @m AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        l0.p(context, "context");
    }

    public /* synthetic */ ShortCutTextView(Context context, AttributeSet attributeSet, int i10, int i11, w wVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @j
    public ShortCutTextView(@l Context context, @m AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l0.p(context, "context");
        View.inflate(context, R.layout.item_short_cut_text, this);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShortCutTextView, i10, 0);
            l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.ShortCutTextView_textLeft);
            string = string == null ? "/" : string;
            l0.m(string);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.ShortCutTextView_textCenter);
            string2 = string2 == null ? "/" : string2;
            l0.m(string2);
            String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.ShortCutTextView_textRight);
            String str = string3 != null ? string3 : "/";
            l0.m(str);
            a(string, string2, str);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
