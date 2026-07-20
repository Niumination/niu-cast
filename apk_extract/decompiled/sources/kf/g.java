package kf;

import k3.fa;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f6858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6859i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(jf.d client, vf.b request, wf.b response, byte[] responseBody) {
        super(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        this.f6858h = responseBody;
        h hVar = new h(this, request);
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.f6856b = hVar;
        i iVar = new i(this, responseBody, response);
        Intrinsics.checkNotNullParameter(iVar, "<set-?>");
        this.f6857c = iVar;
        this.f6859i = true;
    }

    @Override // kf.c
    public final boolean b() {
        return this.f6859i;
    }

    @Override // kf.c
    public final Object f() {
        return fa.a(this.f6858h);
    }
}
