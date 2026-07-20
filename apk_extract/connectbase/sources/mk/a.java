package mk;

import java.util.LinkedHashMap;
import java.util.Map;
import kn.l0;
import lm.a1;
import nm.c1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f10732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f10733b;

    /* JADX INFO: renamed from: mk.a$a, reason: collision with other inner class name */
    public enum EnumC0280a {
        NORMAL(1000),
        GOING_AWAY(1001),
        PROTOCOL_ERROR(1002),
        CANNOT_ACCEPT(1003),
        CLOSED_ABNORMALLY(1006),
        NOT_CONSISTENT(1007),
        VIOLATED_POLICY(1008),
        TOO_BIG(1009),
        NO_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013);


        @os.l
        public static final C0281a Companion = new C0281a();

        @in.f
        @os.l
        public static final EnumC0280a UNEXPECTED_CONDITION;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final Map<Short, EnumC0280a> f10734a;
        private final short code;

        /* JADX INFO: renamed from: mk.a$a$a, reason: collision with other inner class name */
        public static final class C0281a {
            public C0281a() {
            }

            @lm.k(message = "Use INTERNAL_ERROR instead.", replaceWith = @a1(expression = "INTERNAL_ERROR", imports = {"io.ktor.http.cio.websocket.CloseReason.Codes.INTERNAL_ERROR"}))
            public static /* synthetic */ void b() {
            }

            @os.m
            public final EnumC0280a a(short s10) {
                return (EnumC0280a) EnumC0280a.f10734a.get(Short.valueOf(s10));
            }

            public C0281a(kn.w wVar) {
            }
        }

        static {
            int i10 = 0;
            EnumC0280a[] enumC0280aArrValues = values();
            int iJ = c1.j(enumC0280aArrValues.length);
            LinkedHashMap linkedHashMap = new LinkedHashMap(iJ < 16 ? 16 : iJ);
            int length = enumC0280aArrValues.length;
            while (i10 < length) {
                EnumC0280a enumC0280a = enumC0280aArrValues[i10];
                i10++;
                linkedHashMap.put(Short.valueOf(enumC0280a.getCode()), enumC0280a);
            }
            f10734a = linkedHashMap;
            UNEXPECTED_CONDITION = INTERNAL_ERROR;
        }

        EnumC0280a(short s10) {
            this.code = s10;
        }

        public final short getCode() {
            return this.code;
        }
    }

    public a(short s10, @os.l String str) {
        l0.p(str, "message");
        this.f10732a = s10;
        this.f10733b = str;
    }

    public static /* synthetic */ a d(a aVar, short s10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            s10 = aVar.f10732a;
        }
        if ((i10 & 2) != 0) {
            str = aVar.f10733b;
        }
        return aVar.c(s10, str);
    }

    public final short a() {
        return this.f10732a;
    }

    @os.l
    public final String b() {
        return this.f10733b;
    }

    @os.l
    public final a c(short s10, @os.l String str) {
        l0.p(str, "message");
        return new a(s10, str);
    }

    public final short e() {
        return this.f10732a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f10732a == aVar.f10732a && l0.g(this.f10733b, aVar.f10733b);
    }

    @os.m
    public final EnumC0280a f() {
        return EnumC0280a.Companion.a(this.f10732a);
    }

    @os.l
    public final String g() {
        return this.f10733b;
    }

    public int hashCode() {
        return this.f10733b.hashCode() + (Short.hashCode(this.f10732a) * 31);
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("CloseReason(reason=");
        Object objF = f();
        if (objF == null) {
            objF = Short.valueOf(this.f10732a);
        }
        sb2.append(objF);
        sb2.append(", message=");
        return l.a.a(sb2, this.f10733b, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@os.l EnumC0280a enumC0280a, @os.l String str) {
        this(enumC0280a.getCode(), str);
        l0.p(enumC0280a, "code");
        l0.p(str, "message");
    }
}
