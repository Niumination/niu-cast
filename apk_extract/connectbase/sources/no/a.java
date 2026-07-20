package no;

/* JADX INFO: loaded from: classes3.dex */
public enum a {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");


    @os.l
    private final String javaTarget;

    a(String str) {
        this.javaTarget = str;
    }

    @os.l
    public final String getJavaTarget() {
        return this.javaTarget;
    }
}
