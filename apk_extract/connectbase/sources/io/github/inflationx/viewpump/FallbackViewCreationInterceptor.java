package io.github.inflationx.viewpump;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class FallbackViewCreationInterceptor implements Interceptor {
    @Override // io.github.inflationx.viewpump.Interceptor
    public InflateResult intercept(Interceptor.Chain chain) {
        InflateRequest inflateRequestRequest = chain.request();
        View viewOnCreateView = inflateRequestRequest.fallbackViewCreator().onCreateView(inflateRequestRequest.parent(), inflateRequestRequest.name(), inflateRequestRequest.context(), inflateRequestRequest.attrs());
        return InflateResult.builder().view(viewOnCreateView).name(viewOnCreateView != null ? viewOnCreateView.getClass().getName() : inflateRequestRequest.name()).context(inflateRequestRequest.context()).attrs(inflateRequestRequest.attrs()).build();
    }
}
