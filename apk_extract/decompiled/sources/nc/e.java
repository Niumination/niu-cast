package nc;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f8164b = "(\\p{Digit}+)";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f8165c = "(\\p{XDigit}+)";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f8166d = "[eE][+-]?(\\p{Digit}+)";
    final String e = "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

    public e(String str) {
        this.f8163a = str;
    }

    public boolean a() {
        return this.f8163a.matches("\\-?\\d+");
    }

    public Double b() {
        return Double.valueOf(Double.parseDouble(this.f8163a));
    }

    public Float c() {
        return Float.valueOf(Float.parseFloat(this.f8163a));
    }

    public Integer d() {
        if (this.f8163a.startsWith("0x")) {
            return Integer.valueOf(Integer.parseInt(this.f8163a.substring(2), 16));
        }
        return f() ? Integer.valueOf(Integer.parseInt(this.f8163a.substring(1), 8)) : Integer.valueOf(Integer.parseInt(this.f8163a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b().doubleValue();
    }

    public Long e() {
        if (this.f8163a.startsWith("0x")) {
            return Long.valueOf(Long.parseLong(this.f8163a.substring(2), 16));
        }
        return f() ? Long.valueOf(Long.parseLong(this.f8163a.substring(1), 8)) : Long.valueOf(Long.parseLong(this.f8163a));
    }

    public final boolean f() {
        return this.f8163a.length() > 1 && this.f8163a.charAt(0) == '0' && Character.isDigit(this.f8163a.charAt(1));
    }

    @Override // java.lang.Number
    public float floatValue() {
        return c().floatValue();
    }

    @Override // java.lang.Number
    public int intValue() {
        return d().intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return e().longValue();
    }
}
