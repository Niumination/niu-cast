package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void onPull(EdgeEffect edgeEffect, float f, float f4) {
            edgeEffect.onPull(f, f4);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float onPullDistance(EdgeEffect edgeEffect, float f, float f4) {
            try {
                return edgeEffect.onPullDistance(f, f4);
            } catch (Throwable unused) {
                edgeEffect.onPull(f, f4);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @NonNull
    public static EdgeEffect create(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return Api31Impl.create(context, attributeSet);
    }

    public static float getDistance(@NonNull EdgeEffect edgeEffect) {
        return Api31Impl.getDistance(edgeEffect);
    }

    public static float onPullDistance(@NonNull EdgeEffect edgeEffect, float f, float f4) {
        return Api31Impl.onPullDistance(edgeEffect, f, f4);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i8) {
        this.mEdgeEffect.onAbsorb(i8);
        return true;
    }

    @Deprecated
    public boolean onPull(float f) {
        this.mEdgeEffect.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i8, int i9) {
        this.mEdgeEffect.setSize(i8, i9);
    }

    @Deprecated
    public boolean onPull(float f, float f4) {
        onPull(this.mEdgeEffect, f, f4);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f, float f4) {
        Api21Impl.onPull(edgeEffect, f, f4);
    }
}
