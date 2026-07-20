package u6;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10381a = new b("EVENTS", 0, "events");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f10382b = new b("COUNTER", 1, "counter");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f10383c = new b("TID_CONFIG", 2, "tidconfig");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f10384d = new b("APPID_CONFIG", 3, "appidconfig");
    private final String e;

    private b(String str, int i8, String str2) {
        super(str, i8);
        this.e = str2;
    }

    public String a() {
        return this.e;
    }
}
