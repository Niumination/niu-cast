package hj;

import java.net.Proxy;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[Proxy.Type.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        iArr[Proxy.Type.HTTP.ordinal()] = 2;
    }
}
