package androidx.window.layout;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;
import androidx.window.core.Bounds;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class WindowMetrics {

    @l
    private final Bounds _bounds;

    public WindowMetrics(@l Bounds bounds) {
        l0.p(bounds, "_bounds");
        this._bounds = bounds;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !l0.g(WindowMetrics.class, obj.getClass())) {
            return false;
        }
        return l0.g(this._bounds, ((WindowMetrics) obj)._bounds);
    }

    @l
    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public int hashCode() {
        return this._bounds.hashCode();
    }

    @l
    public String toString() {
        return "WindowMetrics { bounds: " + getBounds() + " }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowMetrics(@l Rect rect) {
        this(new Bounds(rect));
        l0.p(rect, "bounds");
    }
}
