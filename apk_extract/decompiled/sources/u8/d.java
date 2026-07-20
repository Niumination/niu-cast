package u8;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f10416c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o9.b f10417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bd.b f10418b;

    static {
        int[] iArr = new int[a.values().length];
        f10416c = iArr;
        a aVar = a.TOP_LEFT;
        iArr[aVar.ordinal()] = 1;
        a aVar2 = a.TOP_RIGHT;
        iArr[aVar2.ordinal()] = 2;
        a aVar3 = a.BOTTOM_RIGHT;
        iArr[aVar3.ordinal()] = 4;
        a aVar4 = a.BOTTOM_LEFT;
        iArr[aVar4.ordinal()] = 8;
        iArr[a.LEFT.ordinal()] = iArr[aVar.ordinal()] | iArr[aVar4.ordinal()];
        iArr[a.TOP.ordinal()] = iArr[aVar.ordinal()] | iArr[aVar2.ordinal()];
        iArr[a.RIGHT.ordinal()] = iArr[aVar2.ordinal()] | iArr[aVar3.ordinal()];
        iArr[a.BOTTOM.ordinal()] = iArr[aVar4.ordinal()] | iArr[aVar3.ordinal()];
        iArr[a.ALL.ordinal()] = iArr[aVar.ordinal()] | iArr[aVar2.ordinal()] | iArr[aVar4.ordinal()] | iArr[aVar3.ordinal()];
    }
}
