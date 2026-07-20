package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface WindowBackend {
    void registerLayoutChangeCallback(@l Activity activity, @l Executor executor, @l Consumer<WindowLayoutInfo> consumer);

    void unregisterLayoutChangeCallback(@l Consumer<WindowLayoutInfo> consumer);
}
