package com.transsion.widgetslistitemlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import l9.a;
import u8.b;

/* JADX INFO: loaded from: classes3.dex */
public class OSCollapseLinerLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f3784c;

    public OSCollapseLinerLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setClickable(true);
        setOrientation(1);
        this.f3782a = getResources().getDimension(R$dimen.os_radius_l);
        if (this.f3784c == null) {
            this.f3784c = new b();
        }
        if (getBackground() == null) {
            this.f3783b = true;
            setBackground(ContextCompat.getDrawable(getContext(), R$drawable.os_list_item_view_bg_corners_normal));
        }
        getContext();
        new ArrayList();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (this.f3783b) {
            b bVar = this.f3784c;
            bVar.getClass();
            if (bVar.b(a.f7350k).c()) {
                this.f3784c.a(canvas, getWidth(), getHeight(), this.f3782a, u8.a.ALL);
            }
        }
        super.draw(canvas);
    }

    public OSCollapseLinerLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public OSCollapseLinerLayout(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        a();
    }
}
