package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class InflateRequest {
    private final AttributeSet attrs;
    private final Context context;
    private final FallbackViewCreator fallbackViewCreator;
    private final String name;
    private final View parent;

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
    public FallbackViewCreator fallbackViewCreator() {
        return this.fallbackViewCreator;
    }

    @NonNull
    public String name() {
        return this.name;
    }

    @Nullable
    public View parent() {
        return this.parent;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder();
    }

    @NonNull
    public String toString() {
        return "InflateRequest{name='" + this.name + "', context=" + this.context + ", attrs=" + this.attrs + ", parent=" + this.parent + ", fallbackViewCreator=" + this.fallbackViewCreator + '}';
    }

    public static final class Builder {
        private AttributeSet attrs;
        private Context context;
        private FallbackViewCreator fallbackViewCreator;
        private String name;
        private View parent;

        public Builder attrs(@Nullable AttributeSet attributeSet) {
            this.attrs = attributeSet;
            return this;
        }

        public InflateRequest build() {
            if (this.name == null) {
                throw new IllegalStateException("name == null");
            }
            if (this.context == null) {
                throw new IllegalStateException("context == null");
            }
            if (this.fallbackViewCreator != null) {
                return new InflateRequest(this);
            }
            throw new IllegalStateException("fallbackViewCreator == null");
        }

        public Builder context(@NonNull Context context) {
            this.context = context;
            return this;
        }

        public Builder fallbackViewCreator(@NonNull FallbackViewCreator fallbackViewCreator) {
            this.fallbackViewCreator = fallbackViewCreator;
            return this;
        }

        public Builder name(@NonNull String str) {
            this.name = str;
            return this;
        }

        public Builder parent(@Nullable View view) {
            this.parent = view;
            return this;
        }

        private Builder() {
        }

        private Builder(InflateRequest inflateRequest) {
            this.name = inflateRequest.name;
            this.context = inflateRequest.context;
            this.attrs = inflateRequest.attrs;
            this.parent = inflateRequest.parent;
            this.fallbackViewCreator = inflateRequest.fallbackViewCreator;
        }
    }

    private InflateRequest(Builder builder) {
        this.name = builder.name;
        this.context = builder.context;
        this.attrs = builder.attrs;
        this.parent = builder.parent;
        this.fallbackViewCreator = builder.fallbackViewCreator;
    }
}
