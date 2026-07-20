package v4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class z extends u {
    private final Object value;

    public z(Boolean bool) {
        Objects.requireNonNull(bool);
        this.value = bool;
    }

    private static boolean isIntegral(z zVar) {
        Object obj = zVar.value;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        if (this.value == null) {
            return zVar.value == null;
        }
        if (isIntegral(this) && isIntegral(zVar)) {
            if ((this.value instanceof BigInteger) || (zVar.value instanceof BigInteger)) {
                return getAsBigInteger().equals(zVar.getAsBigInteger());
            }
            return getAsNumber().longValue() == zVar.getAsNumber().longValue();
        }
        Object obj2 = this.value;
        if (obj2 instanceof Number) {
            Object obj3 = zVar.value;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return getAsBigDecimal().compareTo(zVar.getAsBigDecimal()) == 0;
                }
                double asDouble = getAsDouble();
                double asDouble2 = zVar.getAsDouble();
                if (asDouble != asDouble2) {
                    return Double.isNaN(asDouble) && Double.isNaN(asDouble2);
                }
                return true;
            }
        }
        return obj2.equals(zVar.value);
    }

    @Override // v4.u
    public BigDecimal getAsBigDecimal() {
        Object obj = this.value;
        return obj instanceof BigDecimal ? (BigDecimal) obj : x4.s.parseBigDecimal(getAsString());
    }

    @Override // v4.u
    public BigInteger getAsBigInteger() {
        Object obj = this.value;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        return isIntegral(this) ? BigInteger.valueOf(getAsNumber().longValue()) : x4.s.parseBigInteger(getAsString());
    }

    @Override // v4.u
    public boolean getAsBoolean() {
        return isBoolean() ? ((Boolean) this.value).booleanValue() : Boolean.parseBoolean(getAsString());
    }

    @Override // v4.u
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // v4.u
    @Deprecated
    public char getAsCharacter() {
        String asString = getAsString();
        if (asString.isEmpty()) {
            throw new UnsupportedOperationException("String value is empty");
        }
        return asString.charAt(0);
    }

    @Override // v4.u
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // v4.u
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // v4.u
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // v4.u
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // v4.u
    public Number getAsNumber() {
        Object obj = this.value;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new x4.l((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // v4.u
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // v4.u
    public String getAsString() {
        Object obj = this.value;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((Boolean) this.value).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            jDoubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.value;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    @Override // v4.u
    public z deepCopy() {
        return this;
    }

    public z(Number number) {
        Objects.requireNonNull(number);
        this.value = number;
    }

    public z(String str) {
        Objects.requireNonNull(str);
        this.value = str;
    }

    public z(Character ch2) {
        Objects.requireNonNull(ch2);
        this.value = ch2.toString();
    }
}
