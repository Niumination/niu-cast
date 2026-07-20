package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import in.n;
import java.util.Iterator;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    @l
    public static final LegacySavedStateHandleController INSTANCE = new LegacySavedStateHandleController();

    @l
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(@l SavedStateRegistryOwner savedStateRegistryOwner) {
            l0.p(savedStateRegistryOwner, "owner");
            if (!(savedStateRegistryOwner instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
            SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.keys().iterator();
            while (it.hasNext()) {
                ViewModel viewModel = viewModelStore.get(it.next());
                l0.m(viewModel);
                LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, savedStateRegistryOwner.getLifecycle());
            }
            if (viewModelStore.keys().isEmpty()) {
                return;
            }
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        }
    }

    private LegacySavedStateHandleController() {
    }

    @n
    public static final void attachHandleIfNeeded(@l ViewModel viewModel, @l SavedStateRegistry savedStateRegistry, @l Lifecycle lifecycle) {
        l0.p(viewModel, "viewModel");
        l0.p(savedStateRegistry, "registry");
        l0.p(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.isAttached()) {
            return;
        }
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        INSTANCE.tryToAddRecreator(savedStateRegistry, lifecycle);
    }

    @n
    @l
    public static final SavedStateHandleController create(@l SavedStateRegistry savedStateRegistry, @l Lifecycle lifecycle, @m String str, @m Bundle bundle) {
        l0.p(savedStateRegistry, "registry");
        l0.p(lifecycle, "lifecycle");
        l0.m(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.Companion.createHandle(savedStateRegistry.consumeRestoredStateForKey(str), bundle));
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        INSTANCE.tryToAddRecreator(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    private final void tryToAddRecreator(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.runOnNextRecreation(OnRecreation.class);
        } else {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.LegacySavedStateHandleController.tryToAddRecreator.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event) {
                    l0.p(lifecycleOwner, "source");
                    l0.p(event, NotificationCompat.CATEGORY_EVENT);
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.removeObserver(this);
                        savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                    }
                }
            });
        }
    }
}
