package se;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class u3 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[o2.values().length];
        try {
            iArr[o2.TCP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[o2.WebSocket.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
