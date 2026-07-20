package androidx.window.java.area;

import android.app.Activity;
import android.os.Binder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import androidx.window.area.WindowAreaController;
import androidx.window.area.WindowAreaInfo;
import androidx.window.area.WindowAreaPresentationSessionCallback;
import androidx.window.area.WindowAreaSessionCallback;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.java.core.CallbackToFlowAdapter;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oi.h;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0007J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0015\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00102\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/window/java/area/WindowAreaControllerCallbackAdapter;", "Landroidx/window/area/WindowAreaController;", "controller", "Landroidx/window/java/core/CallbackToFlowAdapter;", "callbackToFlowAdapter", "<init>", "(Landroidx/window/area/WindowAreaController;Landroidx/window/java/core/CallbackToFlowAdapter;)V", "(Landroidx/window/area/WindowAreaController;)V", "Landroid/os/Binder;", "token", "Landroid/app/Activity;", AtomicIntentType.ACTIVITY, "Ljava/util/concurrent/Executor;", "executor", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "windowAreaPresentationSessionCallback", "", "presentContentOnWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaPresentationSessionCallback;)V", "Landroidx/window/area/WindowAreaSessionCallback;", "windowAreaSessionCallback", "transferActivityToWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaSessionCallback;)V", "Landroidx/core/util/Consumer;", "", "Landroidx/window/area/WindowAreaInfo;", "listener", "addWindowAreaInfoListListener", "(Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "removeWindowAreaInfoListListener", "(Landroidx/core/util/Consumer;)V", "Landroidx/window/area/WindowAreaController;", "Landroidx/window/java/core/CallbackToFlowAdapter;", "Loi/h;", "getWindowAreaInfos", "()Loi/h;", "windowAreaInfos", "window-java_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WindowAreaControllerCallbackAdapter implements WindowAreaController {
    private final CallbackToFlowAdapter callbackToFlowAdapter;
    private final WindowAreaController controller;

    private WindowAreaControllerCallbackAdapter(WindowAreaController windowAreaController, CallbackToFlowAdapter callbackToFlowAdapter) {
        this.controller = windowAreaController;
        this.callbackToFlowAdapter = callbackToFlowAdapter;
    }

    public final void addWindowAreaInfoListListener(Executor executor, Consumer<List<WindowAreaInfo>> listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.callbackToFlowAdapter.connect(executor, listener, this.controller.getWindowAreaInfos());
    }

    @Override // androidx.window.area.WindowAreaController
    public h getWindowAreaInfos() {
        return this.controller.getWindowAreaInfos();
    }

    @Override // androidx.window.area.WindowAreaController
    public void presentContentOnWindowArea(Binder token, Activity activity, Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(windowAreaPresentationSessionCallback, "windowAreaPresentationSessionCallback");
        this.controller.presentContentOnWindowArea(token, activity, executor, windowAreaPresentationSessionCallback);
    }

    public final void removeWindowAreaInfoListListener(Consumer<List<WindowAreaInfo>> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.callbackToFlowAdapter.disconnect(listener);
    }

    @Override // androidx.window.area.WindowAreaController
    public void transferActivityToWindowArea(Binder token, Activity activity, Executor executor, WindowAreaSessionCallback windowAreaSessionCallback) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(windowAreaSessionCallback, "windowAreaSessionCallback");
        this.controller.transferActivityToWindowArea(token, activity, executor, windowAreaSessionCallback);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowAreaControllerCallbackAdapter(WindowAreaController controller) {
        this(controller, new CallbackToFlowAdapter());
        Intrinsics.checkNotNullParameter(controller, "controller");
    }
}
