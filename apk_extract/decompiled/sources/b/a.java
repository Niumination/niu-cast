package b;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1159b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f1158a = i8;
        this.f1159b = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i8 = this.f1158a;
        Object obj = this.f1159b;
        switch (i8) {
            case 0:
                ComponentActivity._init_$lambda$2((ComponentActivity) obj, lifecycleOwner, event);
                break;
            case 1:
                ComponentActivity._init_$lambda$3((ComponentActivity) obj, lifecycleOwner, event);
                break;
            default:
                SavedStateRegistry.performAttach$lambda$4((SavedStateRegistry) obj, lifecycleOwner, event);
                break;
        }
    }
}
