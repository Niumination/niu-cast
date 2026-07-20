package androidx.window.java.layout;

import android.app.Activity;
import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import androidx.window.java.core.CallbackToFlowAdapter;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oi.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\f\u0010\u0010J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u0016\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/window/java/layout/WindowInfoTrackerCallbackAdapter;", "Landroidx/window/layout/WindowInfoTracker;", "tracker", "Landroidx/window/java/core/CallbackToFlowAdapter;", "callbackToFlowAdapter", "<init>", "(Landroidx/window/layout/WindowInfoTracker;Landroidx/window/java/core/CallbackToFlowAdapter;)V", "(Landroidx/window/layout/WindowInfoTracker;)V", "Landroid/app/Activity;", AtomicIntentType.ACTIVITY, "Loi/h;", "Landroidx/window/layout/WindowLayoutInfo;", "windowLayoutInfo", "(Landroid/app/Activity;)Loi/h;", "Landroid/content/Context;", "context", "(Landroid/content/Context;)Loi/h;", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "consumer", "", "addWindowLayoutInfoListener", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "removeWindowLayoutInfoListener", "(Landroidx/core/util/Consumer;)V", "Landroidx/window/layout/WindowInfoTracker;", "Landroidx/window/java/core/CallbackToFlowAdapter;", "window-java_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WindowInfoTrackerCallbackAdapter implements WindowInfoTracker {
    private final CallbackToFlowAdapter callbackToFlowAdapter;
    private final WindowInfoTracker tracker;

    private WindowInfoTrackerCallbackAdapter(WindowInfoTracker windowInfoTracker, CallbackToFlowAdapter callbackToFlowAdapter) {
        this.tracker = windowInfoTracker;
        this.callbackToFlowAdapter = callbackToFlowAdapter;
    }

    public final void addWindowLayoutInfoListener(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.callbackToFlowAdapter.connect(executor, consumer, this.tracker.windowLayoutInfo(activity));
    }

    public final void removeWindowLayoutInfoListener(Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.callbackToFlowAdapter.disconnect(consumer);
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public h windowLayoutInfo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.tracker.windowLayoutInfo(activity);
    }

    public final void addWindowLayoutInfoListener(Context context, Executor executor, Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.callbackToFlowAdapter.connect(executor, consumer, this.tracker.windowLayoutInfo(context));
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public h windowLayoutInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.tracker.windowLayoutInfo(context);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerCallbackAdapter(WindowInfoTracker tracker) {
        this(tracker, new CallbackToFlowAdapter());
        Intrinsics.checkNotNullParameter(tracker, "tracker");
    }
}
