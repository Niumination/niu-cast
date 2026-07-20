package v1;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class x implements y {
    private static final /* synthetic */ x[] $VALUES;
    public static final x BIG_DECIMAL;
    public static final x DOUBLE;
    public static final x LAZILY_PARSED_NUMBER;
    public static final x LONG_OR_DOUBLE;

    public final enum a extends x {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // v1.y
        public Double readNumber(d2.a aVar) throws IOException {
            return Double.valueOf(aVar.nextDouble());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        DOUBLE = aVar;
        x xVar = new x("LAZILY_PARSED_NUMBER", 1) { // from class: v1.x.b
            {
                a aVar2 = null;
            }

            @Override // v1.y
            public Number readNumber(d2.a aVar2) throws IOException {
                return new x1.h(aVar2.nextString());
            }
        };
        LAZILY_PARSED_NUMBER = xVar;
        x xVar2 = new x("LONG_OR_DOUBLE", 2) { // from class: v1.x.c
            {
                a aVar2 = null;
            }

            @Override // v1.y
            public Number readNumber(d2.a aVar2) throws IOException, o {
                String strNextString = aVar2.nextString();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strNextString));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strNextString);
                        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                            if (!aVar2.isLenient()) {
                                throw new d2.e("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar2.getPreviousPath());
                            }
                        }
                        return dValueOf;
                    }
                } catch (NumberFormatException e10) {
                    StringBuilder sbA = e.a.a("Cannot parse ", strNextString, "; at path ");
                    sbA.append(aVar2.getPreviousPath());
                    throw new o(sbA.toString(), e10);
                }
            }
        };
        LONG_OR_DOUBLE = xVar2;
        x xVar3 = new x("BIG_DECIMAL", 3) { // from class: v1.x.d
            {
                a aVar2 = null;
            }

            @Override // v1.y
            public BigDecimal readNumber(d2.a aVar2) throws IOException {
                String strNextString = aVar2.nextString();
                try {
                    return new BigDecimal(strNextString);
                } catch (NumberFormatException e10) {
                    StringBuilder sbA = e.a.a("Cannot parse ", strNextString, "; at path ");
                    sbA.append(aVar2.getPreviousPath());
                    throw new o(sbA.toString(), e10);
                }
            }
        };
        BIG_DECIMAL = xVar3;
        $VALUES = new x[]{aVar, xVar, xVar2, xVar3};
    }

    private x(String str, int i10) {
        super(str, i10);
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) $VALUES.clone();
    }

    public /* synthetic */ x(String str, int i10, a aVar) {
        this(str, i10);
    }
}
