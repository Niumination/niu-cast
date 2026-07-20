package sj;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HostnameVerifier f10142b;

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        switch (this.f10141a) {
            case 0:
                break;
        }
        return this.f10142b.verify(str, sSLSession);
    }
}
