package com.transsion.iotservice.multiscreen.pc.http;

import androidx.constraintlayout.widget.ConstraintLayout;
import dj.e0;
import dj.h0;
import dj.j0;
import dj.m0;
import dj.u;
import dj.v;
import dj.w;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import qj.f;
import qj.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/LoggingInterceptor;", "Ldj/w;", "<init>", "()V", "Ldj/e0;", "request", "", "getRequestHeaders", "(Ldj/e0;)Ljava/lang/String;", "getRequestInfo", "Ldj/j0;", "response", "getResponseInfo", "(Ldj/j0;)Ljava/lang/String;", "Ldj/v;", "chain", "intercept", "(Ldj/v;)Ldj/j0;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LoggingInterceptor implements w {
    private final String getRequestHeaders(e0 request) {
        return request == null ? "" : request.f4530d.toString();
    }

    private final String getRequestInfo(e0 request) {
        h0 h0Var;
        if (request == null || (h0Var = request.e) == null) {
            return "";
        }
        try {
            f fVar = new f();
            h0Var.c(fVar);
            Charset charset = Charset.forName("utf-8");
            Intrinsics.checkNotNull(charset);
            Intrinsics.checkNotNullParameter(charset, "charset");
            return fVar.t(fVar.f9195b, charset);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private final String getResponseInfo(j0 response) {
        if (response == null || !response.c()) {
            return "";
        }
        m0 m0Var = response.f4581i;
        Intrinsics.checkNotNull(m0Var);
        long jA = m0Var.a();
        h hVarG = m0Var.g();
        try {
            hVarG.request(Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        f fVarN = hVarG.n();
        Charset charset = Charset.forName("utf-8");
        if (jA == 0) {
            return "";
        }
        f fVarClone = fVarN.clone();
        Intrinsics.checkNotNull(charset);
        Intrinsics.checkNotNullParameter(charset, "charset");
        return fVarClone.t(fVarClone.f9195b, charset);
    }

    @Override // dj.w
    public j0 intercept(v chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        ij.f fVar = (ij.f) chain;
        e0 e0Var = fVar.f;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = e0Var.f4529c;
        String requestHeaders = getRequestHeaders(e0Var);
        String requestInfo = getRequestInfo(e0Var);
        u uVar = e0Var.f4528b;
        String str2 = String.format("...\nrequest method:%s\nrequest link：%s\nheader：%s\nparam：%s\n", Arrays.copyOf(new Object[]{str, uVar, requestHeaders, requestInfo}, 4));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        gc.c("LoggingInterceptor", str2);
        j0 j0VarB = fVar.b(e0Var);
        String str3 = String.format("...\nrequest method:%s\nrequest link：%s\nheader：%s\nparam：%s\nresponse%s", Arrays.copyOf(new Object[]{e0Var.f4529c, uVar, getRequestHeaders(e0Var), getRequestInfo(e0Var), getResponseInfo(j0VarB)}, 5));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        gc.c("LoggingInterceptor", str3);
        return j0VarB;
    }
}
