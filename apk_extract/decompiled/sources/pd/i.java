package pd;

import android.app.Dialog;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f8761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Dialog f8763c;

    public i(boolean z2, boolean z3, Dialog dialog) {
        this.f8761a = z2;
        this.f8762b = z3;
        this.f8763c = dialog;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Dialog dialog;
        if (!this.f8761a || !this.f8762b) {
            return false;
        }
        if (motionEvent.getAction() == 1 && (dialog = this.f8763c) != null && dialog.isShowing()) {
            dialog.cancel();
        }
        return true;
    }
}
