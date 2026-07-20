package io.github.inflationx.viewpump;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class InterceptorChain implements Interceptor.Chain {
    private final int index;
    private final List<Interceptor> interceptors;
    private final InflateRequest request;

    public InterceptorChain(@NonNull List<Interceptor> list, int i10, @NonNull InflateRequest inflateRequest) {
        this.interceptors = list;
        this.index = i10;
        this.request = inflateRequest;
    }

    @Override // io.github.inflationx.viewpump.Interceptor.Chain
    @NonNull
    public InflateResult proceed(@NonNull InflateRequest inflateRequest) {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError("no interceptors added to the chain");
        }
        InterceptorChain interceptorChain = new InterceptorChain(this.interceptors, this.index + 1, inflateRequest);
        Interceptor interceptor = this.interceptors.get(this.index);
        InflateResult inflateResultIntercept = interceptor.intercept(interceptorChain);
        if (inflateResultIntercept != null) {
            return inflateResultIntercept;
        }
        throw new NullPointerException("interceptor " + interceptor + " returned null");
    }

    @Override // io.github.inflationx.viewpump.Interceptor.Chain
    @NonNull
    public InflateRequest request() {
        return this.request;
    }
}
