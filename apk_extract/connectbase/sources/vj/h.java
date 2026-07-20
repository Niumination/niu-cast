package vj;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@e0("https://github.com/grpc/grpc-java/issues/5029")
public abstract class h {

    public enum a {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public abstract void a(a aVar, String str);

    public abstract void b(a aVar, String str, Object... objArr);
}
