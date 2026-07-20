package vj;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/4017")
public abstract class b implements Closeable {
    public abstract f b(f fVar);

    public abstract <ReqT, RespT> q2<?, ?> c(q2<ReqT, RespT> q2Var);
}
