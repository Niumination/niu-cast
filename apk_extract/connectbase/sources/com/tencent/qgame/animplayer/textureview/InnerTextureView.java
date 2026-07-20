package com.tencent.qgame.animplayer.textureview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import f2.g;
import in.j;
import k2.a;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class InnerTextureView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public g f1808a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public InnerTextureView(@l Context context) {
        this(context, null, 0, 6, null);
        l0.p(context, "context");
    }

    public void a() {
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(@m MotionEvent motionEvent) {
        g gVar;
        a aVar;
        g gVar2 = this.f1808a;
        if (gVar2 == null || !gVar2.z() || motionEvent == null || (gVar = this.f1808a) == null || (aVar = gVar.f5755s) == null || !aVar.g(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @m
    public final g getPlayer() {
        return this.f1808a;
    }

    public final void setPlayer(@m g gVar) {
        this.f1808a = gVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @j
    public InnerTextureView(@l Context context, @m AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        l0.p(context, "context");
    }

    public /* synthetic */ InnerTextureView(Context context, AttributeSet attributeSet, int i10, int i11, w wVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @j
    public InnerTextureView(@l Context context, @m AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l0.p(context, "context");
    }
}
