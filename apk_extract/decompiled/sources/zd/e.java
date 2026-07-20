package zd;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.widget.FootOperationBar;
import com.transsion.widgetslib.widget.InvertArrowSpinner;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f11286b;

    public /* synthetic */ e(ViewGroup viewGroup, int i8) {
        this.f11285a = i8;
        this.f11286b = viewGroup;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        switch (this.f11285a) {
            case 0:
                ((FootOperationBar) this.f11286b).f3372d.setSelected(false);
                break;
            default:
                InvertArrowSpinner invertArrowSpinner = (InvertArrowSpinner) this.f11286b;
                Activity activity = invertArrowSpinner.getActivity();
                if (activity == null || !activity.isChangingConfigurations()) {
                    invertArrowSpinner.f3391c = false;
                }
                invertArrowSpinner.setBackground(invertArrowSpinner.getResources().getDrawable(R$drawable.os_spinner_background_material_blue_open));
                break;
        }
    }
}
