package ao;

import kn.l0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'UBYTEARRAY' uses external variables
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
public final class m {
    public static final m UBYTEARRAY;
    public static final m UINTARRAY;
    public static final m ULONGARRAY;
    public static final m USHORTARRAY;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ m[] f624a;

    @os.l
    private final dp.b classId;

    @os.l
    private final dp.f typeName;

    static {
        dp.b bVarE = dp.b.e("kotlin/UByteArray");
        l0.o(bVarE, "fromString(\"kotlin/UByteArray\")");
        UBYTEARRAY = new m("UBYTEARRAY", 0, bVarE);
        dp.b bVarE2 = dp.b.e("kotlin/UShortArray");
        l0.o(bVarE2, "fromString(\"kotlin/UShortArray\")");
        USHORTARRAY = new m("USHORTARRAY", 1, bVarE2);
        dp.b bVarE3 = dp.b.e("kotlin/UIntArray");
        l0.o(bVarE3, "fromString(\"kotlin/UIntArray\")");
        UINTARRAY = new m("UINTARRAY", 2, bVarE3);
        dp.b bVarE4 = dp.b.e("kotlin/ULongArray");
        l0.o(bVarE4, "fromString(\"kotlin/ULongArray\")");
        ULONGARRAY = new m("ULONGARRAY", 3, bVarE4);
        f624a = a();
    }

    public m(String str, int i10, dp.b bVar) {
        super(str, i10);
        this.classId = bVar;
        dp.f fVarJ = bVar.j();
        l0.o(fVarJ, "classId.shortClassName");
        this.typeName = fVarJ;
    }

    public static final /* synthetic */ m[] a() {
        return new m[]{UBYTEARRAY, USHORTARRAY, UINTARRAY, ULONGARRAY};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f624a.clone();
    }

    @os.l
    public final dp.f getTypeName() {
        return this.typeName;
    }
}
