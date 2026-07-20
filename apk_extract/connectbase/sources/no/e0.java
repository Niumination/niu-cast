package no;

/* JADX INFO: loaded from: classes3.dex */
public enum e0 {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");


    @os.l
    public static final a Companion = new a();

    @os.l
    private final String description;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    e0(String str) {
        this.description = str;
    }

    @os.l
    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
