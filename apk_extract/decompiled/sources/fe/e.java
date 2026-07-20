package fe;

import android.view.MotionEvent;
import android.view.View;
import com.transsion.widgetslib.widget.shadow.SpringFloatingOvalButton;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpringFloatingOvalButton f5030a;

    public e(SpringFloatingOvalButton springFloatingOvalButton) {
        this.f5030a = springFloatingOvalButton;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f5030a.e;
        if (onTouchListener == null) {
            return false;
        }
        onTouchListener.onTouch(view, motionEvent);
        return false;
    }
}
