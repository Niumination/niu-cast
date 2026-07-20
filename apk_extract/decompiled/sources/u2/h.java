package u2;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f10340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10341c;

    public /* synthetic */ h(Intent intent, Object obj, int i8) {
        this.f10339a = i8;
        this.f10340b = intent;
        this.f10341c = obj;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, r2.e] */
    public final void a() {
        switch (this.f10339a) {
            case 0:
                Intent intent = this.f10340b;
                if (intent != null) {
                    ((GoogleApiActivity) this.f10341c).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.f10340b;
                if (intent2 != null) {
                    this.f10341c.startActivityForResult(intent2, 2);
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i8) {
        try {
            a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
