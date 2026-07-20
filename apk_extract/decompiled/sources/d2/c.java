package d2;

/* JADX INFO: loaded from: classes.dex */
public final class c extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f4267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a2.c f4268c;

    public final d a() {
        String strConcat = this.f4266a == null ? " backendName" : "";
        if (this.f4268c == null) {
            strConcat = strConcat.concat(" priority");
        }
        if (strConcat.isEmpty()) {
            return new d(this.f4266a, this.f4267b, this.f4268c);
        }
        throw new IllegalStateException("Missing required properties:".concat(strConcat));
    }
}
