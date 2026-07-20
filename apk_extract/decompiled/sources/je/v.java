package je;

import android.widget.TextView;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f6250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f6251c;

    public /* synthetic */ v(TextView textView, int i8, float f) {
        this.f6249a = i8;
        this.f6250b = textView;
        this.f6251c = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6249a) {
            case 0:
                OSLiquidToolBar.AnonymousClass1.onGlobalLayout$lambda$0(this.f6250b, this.f6251c);
                break;
            default:
                OSLiquidWidgetToolBar.AnonymousClass1.onGlobalLayout$lambda$0(this.f6250b, this.f6251c);
                break;
        }
    }
}
