package io.github.inflationx.calligraphy3;

import io.github.inflationx.viewpump.InflateResult;
import io.github.inflationx.viewpump.Interceptor;

/* JADX INFO: loaded from: classes3.dex */
public class CalligraphyInterceptor implements Interceptor {
    private final Calligraphy calligraphy;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphy = new Calligraphy(calligraphyConfig);
    }

    @Override // io.github.inflationx.viewpump.Interceptor
    public InflateResult intercept(Interceptor.Chain chain) {
        InflateResult inflateResultProceed = chain.proceed(chain.request());
        return inflateResultProceed.toBuilder().view(this.calligraphy.onViewCreated(inflateResultProceed.view(), inflateResultProceed.context(), inflateResultProceed.attrs())).build();
    }
}
