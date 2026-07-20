package io.github.inflationx.viewpump;

import androidx.annotation.MainThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewPump {
    private static ViewPump INSTANCE;
    private final List<Interceptor> interceptors;
    private final boolean mCustomViewCreation;
    private final List<Interceptor> mInterceptorsWithFallback;
    private final boolean mReflection;

    public static final class Builder {
        private boolean customViewCreation;
        private final List<Interceptor> interceptors;
        private boolean reflection;

        public Builder addInterceptor(Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public ViewPump build() {
            return new ViewPump(this);
        }

        public Builder setCustomViewInflationEnabled(boolean z2) {
            this.customViewCreation = z2;
            return this;
        }

        public Builder setPrivateFactoryInjectionEnabled(boolean z2) {
            this.reflection = z2;
            return this;
        }

        private Builder() {
            this.interceptors = new ArrayList();
            this.reflection = true;
            this.customViewCreation = true;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @MainThread
    public static ViewPump get() {
        if (INSTANCE == null) {
            INSTANCE = builder().build();
        }
        return INSTANCE;
    }

    private static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static void init(ViewPump viewPump) {
        INSTANCE = viewPump;
    }

    public InflateResult inflate(InflateRequest inflateRequest) {
        return new InterceptorChain(this.mInterceptorsWithFallback, 0, inflateRequest).proceed(inflateRequest);
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public boolean isCustomViewCreation() {
        return this.mCustomViewCreation;
    }

    public boolean isReflection() {
        return this.mReflection;
    }

    private ViewPump(Builder builder) {
        this.interceptors = immutableList(builder.interceptors);
        List list = builder.interceptors;
        list.add(new FallbackViewCreationInterceptor());
        this.mInterceptorsWithFallback = immutableList(list);
        this.mReflection = builder.reflection;
        this.mCustomViewCreation = builder.customViewCreation;
    }
}
