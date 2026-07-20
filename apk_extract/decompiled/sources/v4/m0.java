package v4;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 implements n0 {
    private static final /* synthetic */ m0[] $VALUES;
    public static final m0 BIG_DECIMAL;
    public static final m0 DOUBLE;
    public static final m0 LAZILY_PARSED_NUMBER;
    public static final m0 LONG_OR_DOUBLE;

    static {
        i0 i0Var = new i0("DOUBLE", 0);
        DOUBLE = i0Var;
        final String str = "LAZILY_PARSED_NUMBER";
        final int i8 = 1;
        m0 m0Var = new m0(str, i8) { // from class: v4.j0
            {
                i0 i0Var2 = null;
            }

            @Override // v4.m0, v4.n0
            public Number readNumber(d5.b bVar) throws IOException {
                return new x4.l(bVar.nextString());
            }
        };
        LAZILY_PARSED_NUMBER = m0Var;
        final String str2 = "LONG_OR_DOUBLE";
        final int i9 = 2;
        m0 m0Var2 = new m0(str2, i9) { // from class: v4.k0
            {
                i0 i0Var2 = null;
            }

            private Number parseAsDouble(String str3, d5.b bVar) throws IOException {
                try {
                    Double dValueOf = Double.valueOf(str3);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!bVar.isLenient()) {
                            throw new d5.e("JSON forbids NaN and infinities: " + dValueOf + "; at path " + bVar.getPreviousPath());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e) {
                    StringBuilder sbY = a1.a.y("Cannot parse ", str3, "; at path ");
                    sbY.append(bVar.getPreviousPath());
                    throw new y(sbY.toString(), e);
                }
            }

            @Override // v4.m0, v4.n0
            public Number readNumber(d5.b bVar) throws IOException, y {
                String strNextString = bVar.nextString();
                if (strNextString.indexOf(46) >= 0) {
                    return parseAsDouble(strNextString, bVar);
                }
                try {
                    return Long.valueOf(Long.parseLong(strNextString));
                } catch (NumberFormatException unused) {
                    return parseAsDouble(strNextString, bVar);
                }
            }
        };
        LONG_OR_DOUBLE = m0Var2;
        final String str3 = "BIG_DECIMAL";
        final int i10 = 3;
        m0 m0Var3 = new m0(str3, i10) { // from class: v4.l0
            {
                i0 i0Var2 = null;
            }

            @Override // v4.m0, v4.n0
            public BigDecimal readNumber(d5.b bVar) throws IOException {
                String strNextString = bVar.nextString();
                try {
                    return x4.s.parseBigDecimal(strNextString);
                } catch (NumberFormatException e) {
                    StringBuilder sbY = a1.a.y("Cannot parse ", strNextString, "; at path ");
                    sbY.append(bVar.getPreviousPath());
                    throw new y(sbY.toString(), e);
                }
            }
        };
        BIG_DECIMAL = m0Var3;
        $VALUES = new m0[]{i0Var, m0Var, m0Var2, m0Var3};
    }

    private m0(String str, int i8) {
        super(str, i8);
    }

    public static m0 valueOf(String str) {
        return (m0) Enum.valueOf(m0.class, str);
    }

    public static m0[] values() {
        return (m0[]) $VALUES.clone();
    }

    public abstract /* synthetic */ Number readNumber(d5.b bVar) throws IOException;

    public /* synthetic */ m0(String str, int i8, i0 i0Var) {
        this(str, i8);
    }
}
