package androidx.core.location;

import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CancellationSignal.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f455a;

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        this.f455a.cancel();
    }
}
