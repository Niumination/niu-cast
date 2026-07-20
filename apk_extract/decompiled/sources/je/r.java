package je;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f6241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f6242d;

    public /* synthetic */ r(int i8, int i9, View view, ViewGroup viewGroup) {
        this.f6239a = i9;
        this.f6242d = viewGroup;
        this.f6240b = i8;
        this.f6241c = view;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f6239a) {
            case 0:
                return OSLiquidToolBar.setRightContainerAnim$lambda$27((OSLiquidToolBar) this.f6242d, this.f6240b, this.f6241c, view, motionEvent);
            default:
                return OSLiquidWidgetToolBar.setRightContainerAnim$lambda$27((OSLiquidWidgetToolBar) this.f6242d, this.f6240b, this.f6241c, view, motionEvent);
        }
    }
}
