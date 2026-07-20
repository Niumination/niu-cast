package androidx.window.embedding;

import android.graphics.Rect;
import android.view.WindowMetrics;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.window.core.ExperimentalWindowApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kn.l0;
import kn.w;
import mm.a;
import mm.e;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public class SplitRule extends EmbeddingRule {

    @l
    public static final Companion Companion = new Companion(null);
    public static final int FINISH_ADJACENT = 2;
    public static final int FINISH_ALWAYS = 1;
    public static final int FINISH_NEVER = 0;
    private final int layoutDirection;
    private final int minSmallestWidth;
    private final int minWidth;
    private final float splitRatio;

    @RequiresApi(30)
    public static final class Api30Impl {

        @l
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        @DoNotInline
        @l
        public final Rect getBounds(@l WindowMetrics windowMetrics) {
            l0.p(windowMetrics, "windowMetrics");
            Rect bounds = windowMetrics.getBounds();
            l0.o(bounds, "windowMetrics.bounds");
            return bounds;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @e(a.SOURCE)
    public @interface LayoutDir {
    }

    @Retention(RetentionPolicy.SOURCE)
    @e(a.SOURCE)
    public @interface SplitFinishBehavior {
    }

    public SplitRule() {
        this(0, 0, 0.0f, 0, 15, null);
    }

    public final boolean checkParentMetrics(@l WindowMetrics windowMetrics) {
        l0.p(windowMetrics, "parentMetrics");
        Rect bounds = Api30Impl.INSTANCE.getBounds(windowMetrics);
        return (this.minWidth == 0 || bounds.width() >= this.minWidth) && (this.minSmallestWidth == 0 || Math.min(bounds.width(), bounds.height()) >= this.minSmallestWidth);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitRule)) {
            return false;
        }
        SplitRule splitRule = (SplitRule) obj;
        return this.minWidth == splitRule.minWidth && this.minSmallestWidth == splitRule.minSmallestWidth && this.splitRatio == splitRule.splitRatio && this.layoutDirection == splitRule.layoutDirection;
    }

    public final int getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMinSmallestWidth() {
        return this.minSmallestWidth;
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public int hashCode() {
        return ((Float.hashCode(this.splitRatio) + (((this.minWidth * 31) + this.minSmallestWidth) * 31)) * 31) + this.layoutDirection;
    }

    public /* synthetic */ SplitRule(int i10, int i11, float f10, int i12, int i13, w wVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0.5f : f10, (i13 & 8) != 0 ? 3 : i12);
    }

    public SplitRule(int i10, int i11, float f10, int i12) {
        this.minWidth = i10;
        this.minSmallestWidth = i11;
        this.splitRatio = f10;
        this.layoutDirection = i12;
    }
}
