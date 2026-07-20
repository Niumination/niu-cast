package u2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static final Uri e = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10361d;

    public r(String str, boolean z2) {
        l.c(str);
        this.f10358a = str;
        l.c("com.google.android.gms");
        this.f10359b = "com.google.android.gms";
        this.f10360c = 4225;
        this.f10361d = z2;
    }

    public final Intent a(Context context) {
        Bundle bundleCall;
        Intent intent = null;
        String str = this.f10358a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.f10361d) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(e, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e4) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e4.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return intent != null ? intent : new Intent(str).setPackage(this.f10359b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return l.h(this.f10358a, rVar.f10358a) && l.h(this.f10359b, rVar.f10359b) && l.h(null, null) && this.f10360c == rVar.f10360c && this.f10361d == rVar.f10361d;
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.f10360c);
        Boolean boolValueOf = Boolean.valueOf(this.f10361d);
        return Arrays.hashCode(new Object[]{this.f10358a, this.f10359b, null, numValueOf, boolValueOf});
    }

    public final String toString() {
        String str = this.f10358a;
        if (str != null) {
            return str;
        }
        l.e(null);
        throw null;
    }
}
