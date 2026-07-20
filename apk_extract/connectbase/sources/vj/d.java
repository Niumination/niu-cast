package vj;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static abstract class a {
        public abstract void a(v1 v1Var);

        public abstract void b(y2 y2Var);
    }

    public static abstract class b {
        public abstract String a();

        public e b() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public abstract w1<?, ?> c();

        public abstract h2 d();

        public abstract vj.a e();
    }

    public abstract void a(b bVar, Executor executor, a aVar);

    @Deprecated
    @e0("https://github.com/grpc/grpc-java/issues/1914")
    public void b() {
    }
}
