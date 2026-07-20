package b;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1161b;

    public /* synthetic */ b(Object obj, int i8) {
        this.f1160a = i8;
        this.f1161b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        int i8 = this.f1160a;
        Object obj = this.f1161b;
        switch (i8) {
            case 0:
                return ComponentActivity._init_$lambda$4((ComponentActivity) obj);
            case 1:
                return ((FragmentActivity) obj).lambda$init$0();
            case 2:
                return ((FragmentManager) obj).lambda$attachController$4();
            default:
                return SavedStateHandle.savedStateProvider$lambda$0((SavedStateHandle) obj);
        }
    }
}
