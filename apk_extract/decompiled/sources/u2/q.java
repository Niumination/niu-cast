package u2;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class q extends j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10357g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(com.google.android.gms.common.internal.a aVar, int i8) {
        super(aVar, i8, null);
        this.f10357g = aVar;
    }

    @Override // u2.j
    public final void a(ConnectionResult connectionResult) {
        com.google.android.gms.common.internal.a aVar = this.f10357g;
        aVar.getClass();
        aVar.f1883k.a(connectionResult);
        System.currentTimeMillis();
    }

    @Override // u2.j
    public final boolean b() {
        this.f10357g.f1883k.a(ConnectionResult.e);
        return true;
    }
}
