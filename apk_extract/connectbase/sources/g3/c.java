package g3;

import android.net.Uri;
import io.netty.handler.codec.rtsp.RtspHeaders;
import jq.e0;
import kn.l0;
import kn.r1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nGrpcConnectorFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrpcConnectorFactory.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcConnectorFactory\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,29:1\n29#2:30\n1#3:31\n*S KotlinDebug\n*F\n+ 1 GrpcConnectorFactory.kt\ncom/transsion/airtransfer/filetransfer/transmission/grpc/GrpcConnectorFactory\n*L\n17#1:30\n*E\n"})
public final class c implements z2.d.a {
    @Override // z2.d.a
    @m
    public z2.d a(@l String str) {
        l0.p(str, RtspHeaders.Values.URL);
        Uri uri = Uri.parse(str);
        l0.o(uri, "parse(this)");
        if (!l0.g(uri.getScheme(), t2.a.f15435b)) {
            return null;
        }
        v2.c.f16501a.c();
        String host = uri.getHost();
        if (host == null || e0.S1(host)) {
            f fVar = new f(uri.getPort());
            fVar.b();
            return fVar;
        }
        b bVar = new b(String.valueOf(uri.getHost()), uri.getPort());
        bVar.b();
        return bVar;
    }
}
