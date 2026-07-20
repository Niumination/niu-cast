package bi;

/* JADX INFO: loaded from: classes2.dex */
public class o extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f888b = "(\\p{Digit}+)";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f889c = "(\\p{XDigit}+)";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f890d = "[eE][+-]?(\\p{Digit}+)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f891e = "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

    public o(String str) {
        this.f887a = str;
    }

    public boolean a() {
        return this.f887a.matches("\\-?\\d+");
    }

    public Double b() {
        return Double.valueOf(Double.parseDouble(this.f887a));
    }

    public Float c() {
        return Float.valueOf(Float.parseFloat(this.f887a));
    }

    public Integer d() {
        if (f()) {
            return Integer.valueOf(Integer.parseInt(this.f887a.substring(2), 16));
        }
        return g() ? Integer.valueOf(Integer.parseInt(this.f887a.substring(1), 8)) : Integer.valueOf(Integer.parseInt(this.f887a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b().doubleValue();
    }

    public Long e() {
        if (f()) {
            return Long.valueOf(Long.parseLong(this.f887a.substring(2), 16));
        }
        return g() ? Long.valueOf(Long.parseLong(this.f887a.substring(1), 8)) : Long.valueOf(Long.parseLong(this.f887a));
    }

    public final boolean f() {
        return this.f887a.startsWith("0x");
    }

    @Override // java.lang.Number
    public float floatValue() {
        return c().floatValue();
    }

    public final boolean g() {
        return this.f887a.length() > 1 && this.f887a.charAt(0) == '0' && Character.isDigit(this.f887a.charAt(1));
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
