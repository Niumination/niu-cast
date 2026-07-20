package o3;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import c2.k;
import o.d;
import q2.g;
import q2.h;
import r2.l;
import u2.f;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8367a;

    public q2.c a(Context context, Looper looper, k kVar, Object obj, g gVar, h hVar) {
        int i8 = this.f8367a;
        switch (i8) {
            case 0:
                kVar.getClass();
                Integer num = kVar.f1408b;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new p3.a(context, looper, kVar, bundle, gVar, hVar);
            case 1:
                d.y(obj);
                throw null;
            default:
                l lVar = (l) gVar;
                l lVar2 = (l) hVar;
                switch (i8) {
                    case 2:
                        return new w2.c(context, looper, kVar, (f) obj, lVar, lVar2);
                    case 3:
                        return new y2.g(context, looper, 308, kVar, lVar, lVar2);
                    default:
                        throw new UnsupportedOperationException("buildClient must be implemented");
                }
        }
    }
}
