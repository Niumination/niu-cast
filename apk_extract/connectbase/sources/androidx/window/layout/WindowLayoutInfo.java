package androidx.window.layout;

import androidx.annotation.RestrictTo;
import java.util.List;
import kn.l0;
import nm.h0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class WindowLayoutInfo {

    @l
    private final List<DisplayFeature> displayFeatures;

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowLayoutInfo(@l List<? extends DisplayFeature> list) {
        l0.p(list, "displayFeatures");
        this.displayFeatures = list;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !l0.g(WindowLayoutInfo.class, obj.getClass())) {
            return false;
        }
        return l0.g(this.displayFeatures, ((WindowLayoutInfo) obj).displayFeatures);
    }

    @l
    public final List<DisplayFeature> getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    @l
    public String toString() {
        return h0.m3(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
