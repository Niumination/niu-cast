package com.transsion.widgetslib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: classes2.dex */
public class OSListView extends ListView {
    public OSListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public OSListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OSListView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
    }
}
