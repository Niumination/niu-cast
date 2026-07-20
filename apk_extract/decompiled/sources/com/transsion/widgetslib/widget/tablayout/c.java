package com.transsion.widgetslib.widget.tablayout;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        TextView textView = ((TabLayout.TabView) view).f3706b;
        if (textView != null) {
            if (motionEvent.getAction() == 0) {
                textView.setPressed(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                textView.setPressed(false);
            }
        }
        return false;
    }
}
