package androidx.window.layout;

import android.app.Activity;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface ExtensionInterfaceCompat {

    public interface ExtensionCallbackInterface {
        void onWindowLayoutChanged(@l Activity activity, @l WindowLayoutInfo windowLayoutInfo);
    }

    void onWindowLayoutChangeListenerAdded(@l Activity activity);

    void onWindowLayoutChangeListenerRemoved(@l Activity activity);

    void setExtensionCallback(@l ExtensionCallbackInterface extensionCallbackInterface);

    boolean validateExtensionInterface();
}
