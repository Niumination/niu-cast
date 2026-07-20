package ld;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f7364b;

    public b(j jVar, Context context) {
        this.f7364b = jVar;
        this.f7363a = context;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        j jVar = this.f7364b;
        if (jVar.M && jVar.N) {
            boolean z2 = motionEvent.getAction() == 1;
            View decorView = jVar.f7380c.getDecorView();
            int x2 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            int scaledWindowTouchSlop = ViewConfiguration.get(this.f7363a).getScaledWindowTouchSlop();
            int i8 = -scaledWindowTouchSlop;
            boolean z3 = x2 < i8 || y3 < i8 || x2 > decorView.getWidth() + scaledWindowTouchSlop || y3 > decorView.getHeight() + scaledWindowTouchSlop;
            boolean z5 = motionEvent.getAction() == 4;
            if ((z3 && z2) || z5) {
                jVar.e.obtainMessage(1, jVar.f7379b).sendToTarget();
            }
        }
        return true;
    }
}
