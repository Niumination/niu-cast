package o0;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import li.p1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8354c;

    public /* synthetic */ c(int i8, Object obj, Object obj2) {
        this.f8352a = i8;
        this.f8353b = obj;
        this.f8354c = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f8352a) {
            case 0:
                ((MenuHostHelper) this.f8353b).lambda$addMenuProvider$0((MenuProvider) this.f8354c, lifecycleOwner, event);
                break;
            default:
                LifecycleController.observer$lambda$0((LifecycleController) this.f8353b, (p1) this.f8354c, lifecycleOwner, event);
                break;
        }
    }
}
