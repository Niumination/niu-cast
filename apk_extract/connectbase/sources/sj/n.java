package sj;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface n extends x, Map<String, x> {
    @Override // java.util.Map
    x get(Object obj);

    a toConfig();

    @Override // sj.x
    Map<String, Object> unwrapped();

    @Override // sj.x, sj.m
    n withFallback(m mVar);

    n withOnlyKey(String str);

    @Override // sj.x
    n withOrigin(o oVar);

    n withValue(String str, x xVar);

    n withoutKey(String str);
}
