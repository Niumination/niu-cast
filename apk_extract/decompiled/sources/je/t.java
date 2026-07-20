package je;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;
import com.transsion.widgetsliquid.view.OsLiqBottomToolBar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f6246b;

    public /* synthetic */ t(ViewGroup viewGroup, int i8) {
        this.f6245a = i8;
        this.f6246b = viewGroup;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
        int i9 = this.f6245a;
        ViewGroup viewGroup = this.f6246b;
        switch (i9) {
            case 0:
                OSLiquidToolBar.showPopupWindow$lambda$10((OSLiquidToolBar) viewGroup, adapterView, view, i8, j8);
                break;
            case 1:
                OSLiquidWidgetToolBar.showPopupWindow$lambda$10((OSLiquidWidgetToolBar) viewGroup, adapterView, view, i8, j8);
                break;
            default:
                ((OsLiqBottomToolBar) viewGroup).lambda$showListPopupWindow$0(adapterView, view, i8, j8);
                break;
        }
    }
}
