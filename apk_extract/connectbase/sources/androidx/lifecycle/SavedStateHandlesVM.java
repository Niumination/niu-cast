package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesVM extends ViewModel {

    @l
    private final Map<String, SavedStateHandle> handles = new LinkedHashMap();

    @l
    public final Map<String, SavedStateHandle> getHandles() {
        return this.handles;
    }
}
