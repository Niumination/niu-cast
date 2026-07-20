package zd;

import android.view.MotionEvent;
import android.view.View;
import com.transsion.widgetslib.widget.FootOperationBar;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.e f11282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FootOperationBar f11284c;

    public d(FootOperationBar footOperationBar, o.e eVar, View view) {
        this.f11284c = footOperationBar;
        this.f11282a = eVar;
        this.f11283b = view;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        o.e eVar = this.f11282a;
        FootOperationBar footOperationBar = this.f11284c;
        if (action == 0) {
            footOperationBar.postDelayed(eVar, 100L);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        footOperationBar.removeCallbacks(eVar);
        int i8 = FootOperationBar.H;
        FootOperationBar.g(this.f11283b, 0.0f);
        return false;
    }
}
