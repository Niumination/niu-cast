package se;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a5 extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b5 f9648a;

    public a5(b5 b5Var) {
        this.f9648a = b5Var;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onAvailable(network);
        b5 b5Var = this.f9648a;
        ConnectivityManager connectivityManager = b5Var.f9661a;
        NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
        if (networkCapabilities == null || !networkCapabilities.hasTransport(1)) {
            return;
        }
        b5Var.f9663c.add(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        b5 b5Var = this.f9648a;
        ConnectivityManager connectivityManager = b5Var.f9661a;
        NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
        if (networkCapabilities == null || !networkCapabilities.hasTransport(1)) {
            return;
        }
        b5Var.f9663c.remove(network);
    }
}
