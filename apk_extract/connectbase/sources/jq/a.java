package jq;

/* JADX INFO: loaded from: classes3.dex */
public enum a {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");


    @os.l
    private final String code;
    private final int value;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ym.a f8795b = ym.c.c(a());

    @os.l
    public static final C0229a Companion = new C0229a();

    /* JADX INFO: renamed from: jq.a$a, reason: collision with other inner class name */
    public static final class C0229a {
        public C0229a() {
        }

        @os.l
        public final a a(int i10) {
            if (new tn.l(0, 16, 1).l(i10)) {
                return a.getEntries().get(i10);
            }
            if (new tn.l(18, 30, 1).l(i10)) {
                return a.getEntries().get(i10 - 1);
            }
            throw new IllegalArgumentException(k.b.a("Category #", i10, " is not defined."));
        }

        public C0229a(kn.w wVar) {
        }
    }

    a(int i10, String str) {
        this.value = i10;
        this.code = str;
    }

    @os.l
    public static ym.a<a> getEntries() {
        return f8795b;
    }

    public final boolean contains(char c10) {
        return Character.getType(c10) == this.value;
    }

    @os.l
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
