package zj;

import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends CompletableFuture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f11634a;

    public g(w wVar) {
        this.f11634a = wVar;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        if (z2) {
            this.f11634a.cancel();
        }
        return super.cancel(z2);
    }
}
