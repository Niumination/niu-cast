package tl;

import java.nio.ByteOrder;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BIG_ENDIAN' uses external variables
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
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static final q BIG_ENDIAN;

    @os.l
    public static final a Companion;
    public static final q LITTLE_ENDIAN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final q f15879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ q[] f15880b;

    @os.l
    private final ByteOrder nioOrder;

    public static final class a {
        public a() {
        }

        @os.l
        public final q a() {
            return q.f15879a;
        }

        @os.l
        public final q b(@os.l ByteOrder byteOrder) {
            kn.l0.p(byteOrder, "nioOrder");
            return r.b(byteOrder);
        }

        public a(kn.w wVar) {
        }
    }

    static {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        kn.l0.o(byteOrder, "BIG_ENDIAN");
        BIG_ENDIAN = new q("BIG_ENDIAN", 0, byteOrder);
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        kn.l0.o(byteOrder2, "LITTLE_ENDIAN");
        LITTLE_ENDIAN = new q("LITTLE_ENDIAN", 1, byteOrder2);
        f15880b = a();
        Companion = new a();
        ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
        kn.l0.o(byteOrderNativeOrder, "nativeOrder()");
        f15879a = r.b(byteOrderNativeOrder);
    }

    public q(String str, int i10, ByteOrder byteOrder) {
        super(str, i10);
        this.nioOrder = byteOrder;
    }

    public static final /* synthetic */ q[] a() {
        return new q[]{BIG_ENDIAN, LITTLE_ENDIAN};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f15880b.clone();
    }

    @os.l
    public final ByteOrder getNioOrder() {
        return this.nioOrder;
    }
}
