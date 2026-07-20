package com.transsion.widgetslib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes2.dex */
public class OSGridView extends GridView {
    public OSGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public OSGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OSGridView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
    }
}
