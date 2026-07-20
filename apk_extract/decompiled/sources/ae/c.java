package ae;

import android.widget.PopupMenu;
import com.transsion.widgetslib.widget.actionbar.OverflowMenu;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements PopupMenu.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OverflowMenu f117a;

    public c(OverflowMenu overflowMenu) {
        this.f117a = overflowMenu;
    }

    @Override // android.widget.PopupMenu.OnDismissListener
    public final void onDismiss(PopupMenu popupMenu) {
        OverflowMenu overflowMenu = this.f117a;
        overflowMenu.p = false;
        overflowMenu.setSelected(false);
    }
}
