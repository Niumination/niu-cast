package je;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f6236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f6238d;
    public final /* synthetic */ ViewGroup e;

    public /* synthetic */ q(ViewGroup viewGroup, LinearLayout linearLayout, int i8, View view, int i9) {
        this.f6235a = i9;
        this.e = viewGroup;
        this.f6236b = linearLayout;
        this.f6237c = i8;
        this.f6238d = view;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f6235a) {
            case 0:
                return OSLiquidToolBar.setRightContainerAnim$lambda$26((OSLiquidToolBar) this.e, this.f6236b, this.f6237c, this.f6238d, view, motionEvent);
            default:
                return OSLiquidWidgetToolBar.setRightContainerAnim$lambda$26((OSLiquidWidgetToolBar) this.e, this.f6236b, this.f6237c, this.f6238d, view, motionEvent);
        }
    }
}
