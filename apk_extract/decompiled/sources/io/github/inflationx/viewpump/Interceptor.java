package io.github.inflationx.viewpump;

/* JADX INFO: loaded from: classes3.dex */
public interface Interceptor {

    public interface Chain {
        InflateResult proceed(InflateRequest inflateRequest);

        InflateRequest request();
    }

    InflateResult intercept(Chain chain);
}
