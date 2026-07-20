package od;

import android.content.DialogInterface;
import android.view.View;
import com.transsion.widgetslib.preference.OSListPreference;
import ld.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSListPreference f8442a;

    public a(OSListPreference oSListPreference) {
        this.f8442a = oSListPreference;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i8) {
        OSListPreference oSListPreference = this.f8442a;
        oSListPreference.p = i8;
        oSListPreference.f3086k = -1;
        m mVar = oSListPreference.f3085j;
        View decorView = (mVar == null || mVar.getWindow() == null) ? null : oSListPreference.f3085j.getWindow().getDecorView();
        if (decorView != null) {
            decorView.removeCallbacks(null);
        }
        m mVar2 = oSListPreference.f3085j;
        View decorView2 = (mVar2 == null || mVar2.getWindow() == null) ? null : oSListPreference.f3085j.getWindow().getDecorView();
        if (decorView2 != null) {
            decorView2.post(null);
        }
    }
}
