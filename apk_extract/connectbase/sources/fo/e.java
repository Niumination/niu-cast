package fo;

import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public enum e {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");


    @os.l
    private final String renderName;

    e(String str) {
        this.renderName = str == null ? cq.a.f(name()) : str;
    }

    @os.l
    public final String getRenderName() {
        return this.renderName;
    }

    /* synthetic */ e(String str, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : str);
    }
}
