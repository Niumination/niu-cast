package ae;

import android.app.Activity;
import android.app.Fragment;
import android.view.MenuItem;
import android.widget.PopupMenu;
import com.transsion.widgetslib.widget.actionbar.OverflowMenu;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PopupMenu.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OverflowMenu f116a;

    public b(OverflowMenu overflowMenu) {
        this.f116a = overflowMenu;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        OverflowMenu overflowMenu = this.f116a;
        Activity activity = overflowMenu.f3464n;
        if (activity != null) {
            activity.onOptionsItemSelected(menuItem);
        }
        Fragment fragment = overflowMenu.f3463m;
        if (fragment == null) {
            return false;
        }
        fragment.onOptionsItemSelected(menuItem);
        return false;
    }
}
