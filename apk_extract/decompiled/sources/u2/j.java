package u2;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f10342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10345d;
    public final Bundle e;
    public final /* synthetic */ com.google.android.gms.common.internal.a f;

    public j(com.google.android.gms.common.internal.a aVar, int i8, Bundle bundle) {
        this.f = aVar;
        Boolean bool = Boolean.TRUE;
        this.f10344c = aVar;
        this.f10342a = bool;
        this.f10343b = false;
        this.f10345d = i8;
        this.e = bundle;
    }

    public abstract void a(ConnectionResult connectionResult);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.f10342a = null;
        }
        synchronized (this.f10344c.f1885m) {
            this.f10344c.f1885m.remove(this);
        }
    }
}
