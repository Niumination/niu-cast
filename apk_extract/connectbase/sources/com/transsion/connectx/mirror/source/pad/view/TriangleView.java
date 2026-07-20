package com.transsion.connectx.mirror.source.pad.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.connectx.mirror.source.R;
import in.j;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class TriangleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public Paint f2156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public Path f2157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2158c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public TriangleView(@l Context context) {
        this(context, null, 0, 6, null);
        l0.p(context, "context");
    }

    public final void a() {
        Path path = this.f2157b;
        path.reset();
        path.moveTo(0.0f, 0.0f);
        path.lineTo((getWidth() * 3) / 8.0f, (getHeight() * 7) / 8.0f);
        path.quadTo(getWidth() / 2.0f, (getHeight() / 8.0f) + getHeight(), (getWidth() * 5) / 8.0f, (getHeight() * 7) / 8.0f);
        path.lineTo(getWidth(), 0.0f);
        path.close();
    }

    public final void b() {
        Path path = this.f2157b;
        path.reset();
        path.moveTo(0.0f, getHeight());
        path.lineTo((getWidth() * 3) / 8.0f, getHeight() / 8.0f);
        path.quadTo(getWidth() / 2.0f, (-getHeight()) / 8.0f, (getWidth() * 5) / 8.0f, getHeight() / 8.0f);
        path.lineTo(getWidth(), getHeight());
        path.close();
    }

    @Override // android.view.View
    public void onDraw(@l Canvas canvas) {
        l0.p(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f2158c) {
            a();
        } else {
            b();
        }
        canvas.drawPath(this.f2157b, this.f2156a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public TriangleView(@l Context context, @m AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        l0.p(context, "context");
    }

    public /* synthetic */ TriangleView(Context context, AttributeSet attributeSet, int i10, int i11, w wVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @j
    public TriangleView(@l Context context, @m AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l0.p(context, "context");
        this.f2156a = new Paint();
        this.f2157b = new Path();
        this.f2156a.setColor(Color.parseColor("#565E65"));
        this.f2156a.setStyle(Paint.Style.FILL);
        this.f2156a.setAntiAlias(true);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TriangleView, i10, 0);
            l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.f2158c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TriangleView_isReverse, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
