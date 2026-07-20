package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f994b;

    public /* synthetic */ c(Object obj, int i8) {
        this.f993a = i8;
        this.f994b = obj;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        int i8 = this.f993a;
        Object obj = this.f994b;
        switch (i8) {
            case 0:
                return ((SurfaceEdge.SettableSurface) obj).lambda$new$0(completer);
            default:
                return ((SurfaceOutputImpl) obj).lambda$new$0(completer);
        }
    }
}
