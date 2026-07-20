package sj;

/* JADX INFO: loaded from: classes2.dex */
public interface x extends m {
    a atKey(String str);

    a atPath(String str);

    o origin();

    String render();

    String render(s sVar);

    Object unwrapped();

    z valueType();

    @Override // sj.m
    x withFallback(m mVar);

    x withOrigin(o oVar);
}
