package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpRequest;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public interface HttpDataFactory {
    void cleanAllHttpData();

    @Deprecated
    void cleanAllHttpDatas();

    void cleanRequestHttpData(HttpRequest httpRequest);

    @Deprecated
    void cleanRequestHttpDatas(HttpRequest httpRequest);

    Attribute createAttribute(HttpRequest httpRequest, String str);

    Attribute createAttribute(HttpRequest httpRequest, String str, long j10);

    Attribute createAttribute(HttpRequest httpRequest, String str, String str2);

    FileUpload createFileUpload(HttpRequest httpRequest, String str, String str2, String str3, String str4, Charset charset, long j10);

    void removeHttpDataFromClean(HttpRequest httpRequest, InterfaceHttpData interfaceHttpData);

    void setMaxLimit(long j10);
}
