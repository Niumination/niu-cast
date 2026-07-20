package zd;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f11279a;

    public int getWidth() {
        return this.f11279a.getLayoutParams().width;
    }

    public void setWidth(int i8) {
        View view = this.f11279a;
        view.getLayoutParams().width = i8;
        view.requestLayout();
    }
}
