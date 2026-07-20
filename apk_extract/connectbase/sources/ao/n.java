package ao;

import kn.l0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'UBYTE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final n UBYTE;
    public static final n UINT;
    public static final n ULONG;
    public static final n USHORT;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ n[] f625a;

    @os.l
    private final dp.b arrayClassId;

    @os.l
    private final dp.b classId;

    @os.l
    private final dp.f typeName;

    static {
        dp.b bVarE = dp.b.e("kotlin/UByte");
        l0.o(bVarE, "fromString(\"kotlin/UByte\")");
        UBYTE = new n("UBYTE", 0, bVarE);
        dp.b bVarE2 = dp.b.e("kotlin/UShort");
        l0.o(bVarE2, "fromString(\"kotlin/UShort\")");
        USHORT = new n("USHORT", 1, bVarE2);
        dp.b bVarE3 = dp.b.e("kotlin/UInt");
        l0.o(bVarE3, "fromString(\"kotlin/UInt\")");
        UINT = new n("UINT", 2, bVarE3);
        dp.b bVarE4 = dp.b.e("kotlin/ULong");
        l0.o(bVarE4, "fromString(\"kotlin/ULong\")");
        ULONG = new n("ULONG", 3, bVarE4);
        f625a = a();
    }

    public n(String str, int i10, dp.b bVar) {
        super(str, i10);
        this.classId = bVar;
        dp.f fVarJ = bVar.j();
        l0.o(fVarJ, "classId.shortClassName");
        this.typeName = fVarJ;
        this.arrayClassId = new dp.b(bVar.h(), dp.f.k(l0.C(fVarJ.b(), "Array")));
    }

    public static final /* synthetic */ n[] a() {
        return new n[]{UBYTE, USHORT, UINT, ULONG};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f625a.clone();
    }

    @os.l
    public final dp.b getArrayClassId() {
        return this.arrayClassId;
    }

    @os.l
    public final dp.b getClassId() {
        return this.classId;
    }

    @os.l
    public final dp.f getTypeName() {
        return this.typeName;
    }
}
