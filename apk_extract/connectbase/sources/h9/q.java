package h9;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import ic.n1;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7065c = "q";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n1 f7066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.s f7067b;

    public PendingIntent a(Context context, int i10, Intent intent, int i11, Bundle bundle, UserHandle userHandle) {
        if (context != null) {
            return d(fc.b.a.f6001u).b(context, i10, intent, i11, bundle, userHandle);
        }
        throw new IllegalArgumentException("context cannot be null");
    }

    public PendingIntent b(Context context, int i10, Intent intent, int i11, UserHandle userHandle) {
        return d(fc.b.a.f5994n).c(context, i10, intent, i11, userHandle);
    }

    public Intent c(PendingIntent pendingIntent) {
        return d(fc.b.a.f5989i).a(pendingIntent);
    }

    public bf.o d(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7065c, "TranThubPendingIntent");
            n1 n1Var = this.f7066a;
            if (n1Var != null) {
                return n1Var;
            }
            n1 n1Var2 = new n1();
            this.f7066a = n1Var2;
            return n1Var2;
        }
        dc.e.f(f7065c, "TranAospPendingIntent");
        p6.s sVar = this.f7067b;
        if (sVar != null) {
            return sVar;
        }
        p6.s sVar2 = new p6.s();
        this.f7067b = sVar2;
        return sVar2;
    }
}
