package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import ik.y0;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class HardwareFoldingFeature implements FoldingFeature {

    @l
    public static final Companion Companion = new Companion(null);

    @l
    private final Bounds featureBounds;

    @l
    private final FoldingFeature.State state;

    @l
    private final Type type;

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        public final void validateFeatureBounds$window_release(@l Bounds bounds) {
            l0.p(bounds, "bounds");
            if (bounds.getWidth() == 0 && bounds.getHeight() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero");
            }
            if (bounds.getLeft() != 0 && bounds.getTop() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
            }
        }

        private Companion() {
        }
    }

    public static final class Type {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private static final Type FOLD = new Type("FOLD");

        @l
        private static final Type HINGE = new Type("HINGE");

        @l
        private final String description;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @l
            public final Type getFOLD() {
                return Type.FOLD;
            }

            @l
            public final Type getHINGE() {
                return Type.HINGE;
            }

            private Companion() {
            }
        }

        private Type(String str) {
            this.description = str;
        }

        @l
        public String toString() {
            return this.description;
        }
    }

    public HardwareFoldingFeature(@l Bounds bounds, @l Type type, @l FoldingFeature.State state) {
        l0.p(bounds, "featureBounds");
        l0.p(type, y0.a.f8215h);
        l0.p(state, "state");
        this.featureBounds = bounds;
        this.type = type;
        this.state = state;
        Companion.validateFeatureBounds$window_release(bounds);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!l0.g(HardwareFoldingFeature.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
        return l0.g(this.featureBounds, hardwareFoldingFeature.featureBounds) && l0.g(this.type, hardwareFoldingFeature.type) && l0.g(getState(), hardwareFoldingFeature.getState());
    }

    @Override // androidx.window.layout.DisplayFeature
    @l
    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    @Override // androidx.window.layout.FoldingFeature
    @l
    public FoldingFeature.OcclusionType getOcclusionType() {
        return (this.featureBounds.getWidth() == 0 || this.featureBounds.getHeight() == 0) ? FoldingFeature.OcclusionType.NONE : FoldingFeature.OcclusionType.FULL;
    }

    @Override // androidx.window.layout.FoldingFeature
    @l
    public FoldingFeature.Orientation getOrientation() {
        return this.featureBounds.getWidth() > this.featureBounds.getHeight() ? FoldingFeature.Orientation.HORIZONTAL : FoldingFeature.Orientation.VERTICAL;
    }

    @Override // androidx.window.layout.FoldingFeature
    @l
    public FoldingFeature.State getState() {
        return this.state;
    }

    @l
    public final Type getType$window_release() {
        return this.type;
    }

    public int hashCode() {
        return getState().hashCode() + ((this.type.hashCode() + (this.featureBounds.hashCode() * 31)) * 31);
    }

    @Override // androidx.window.layout.FoldingFeature
    public boolean isSeparating() {
        Type type = this.type;
        Type.Companion companion = Type.Companion;
        if (l0.g(type, companion.getHINGE())) {
            return true;
        }
        return l0.g(this.type, companion.getFOLD()) && l0.g(getState(), FoldingFeature.State.HALF_OPENED);
    }

    @l
    public String toString() {
        return "HardwareFoldingFeature { " + this.featureBounds + ", type=" + this.type + ", state=" + getState() + " }";
    }
}
