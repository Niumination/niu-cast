package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import rs.f;

/* JADX INFO: loaded from: classes2.dex */
public class InflateResult {
    private final AttributeSet attrs;
    private final Context context;
    private final String name;
    private final View view;

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @Nullable
    public AttributeSet attrs() {
        return this.attrs;
    }

    @NonNull
    public Context context() {
        return this.context;
    }

    @NonNull
    public String name() {
        return this.name;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder();
    }

    @NonNull
    public String toString() {
        return "InflateResult{view=" + this.view + ", name=" + this.name + ", context=" + this.context + ", attrs=" + this.attrs + f.f14860b;
    }

    @Nullable
    public View view() {
        return this.view;
    }

    public static final class Builder {
        private AttributeSet attrs;
        private Context context;
        private String name;
        private View view;

        public Builder attrs(@Nullable AttributeSet attributeSet) {
            this.attrs = attributeSet;
            return this;
        }

        public InflateResult build() {
            String str = this.name;
            if (str == null) {
                throw new IllegalStateException("name == null");
            }
            if (this.context == null) {
                throw new IllegalStateException("context == null");
            }
            View view = this.view;
            if (view == null || str.equals(view.getClass().getName())) {
                return new InflateResult(this);
            }
            throw new IllegalStateException("name (" + this.name + ") must be the view's fully qualified name (" + this.view.getClass().getName() + ")");
        }

        public Builder context(@NonNull Context context) {
            this.context = context;
            return this;
        }

        public Builder name(@NonNull String str) {
            this.name = str;
            return this;
        }

        public Builder view(@Nullable View view) {
            this.view = view;
            return this;
        }

        private Builder() {
        }

        private Builder(InflateResult inflateResult) {
            this.view = inflateResult.view;
            this.name = inflateResult.name;
            this.context = inflateResult.context;
            this.attrs = inflateResult.attrs;
        }
    }

    private InflateResult(Builder builder) {
        this.view = builder.view;
        this.name = builder.name;
        this.context = builder.context;
        this.attrs = builder.attrs;
    }
}
