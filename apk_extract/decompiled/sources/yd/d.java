package yd;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11134b;

    public /* synthetic */ d(int i8, int i9) {
        this.f11133a = i9;
        this.f11134b = i8;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f11133a) {
            case 0:
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f11134b);
                break;
            default:
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f11134b);
                break;
        }
    }
}
