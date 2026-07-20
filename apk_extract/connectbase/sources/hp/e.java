package hp;

/* JADX INFO: loaded from: classes3.dex */
public interface e {

    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    @os.l
    a a();

    @os.l
    b b(@os.l eo.a aVar, @os.l eo.a aVar2, @os.m eo.e eVar);
}
