package od;

import android.content.DialogInterface;
import com.transsion.widgetslib.preference.OSDialogPreference;
import com.transsion.widgetslib.preference.OSMultiCheckPreference;
import com.transsion.widgetslib.preference.OSMultiSelectListPreference;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements DialogInterface.OnMultiChoiceClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSDialogPreference f8444b;

    public /* synthetic */ b(OSDialogPreference oSDialogPreference, int i8) {
        this.f8443a = i8;
        this.f8444b = oSDialogPreference;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i8, boolean z2) {
        switch (this.f8443a) {
            case 0:
                ((OSMultiCheckPreference) this.f8444b).f3098n[i8] = z2;
                return;
            default:
                OSMultiSelectListPreference oSMultiSelectListPreference = (OSMultiSelectListPreference) this.f8444b;
                if (z2) {
                    oSMultiSelectListPreference.getClass();
                    oSMultiSelectListPreference.f3102m[i8].toString();
                    throw null;
                }
                oSMultiSelectListPreference.getClass();
                oSMultiSelectListPreference.f3102m[i8].toString();
                throw null;
        }
    }
}
