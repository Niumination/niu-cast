package androidx.camera.view;

import android.view.Surface;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1056c;

    public /* synthetic */ e(int i8, Object obj, Object obj2) {
        this.f1054a = i8;
        this.f1055b = obj;
        this.f1056c = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f1054a) {
            case 0:
                return ((PendingValue) this.f1055b).lambda$setValue$0(this.f1056c, completer);
            default:
                return ((TextureViewImplementation) this.f1055b).lambda$tryToProvidePreviewSurface$1((Surface) this.f1056c, completer);
        }
    }
}
