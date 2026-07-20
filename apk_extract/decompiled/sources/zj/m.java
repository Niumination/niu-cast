package zj;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient o0 f11655a;
    private final int code;
    private final String message;

    public m(o0 o0Var) {
        Objects.requireNonNull(o0Var, "response == null");
        StringBuilder sb2 = new StringBuilder("HTTP ");
        dj.j0 j0Var = o0Var.f11691a;
        sb2.append(j0Var.f4579d);
        sb2.append(" ");
        sb2.append(j0Var.f4578c);
        super(sb2.toString());
        this.code = j0Var.f4579d;
        this.message = j0Var.f4578c;
        this.f11655a = o0Var;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public o0 response() {
        return this.f11655a;
    }
}
