package v4;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    @Deprecated
    public u() {
    }

    public abstract u deepCopy();

    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    @Deprecated
    public char getAsCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public t getAsJsonArray() {
        if (isJsonArray()) {
            return (t) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public w getAsJsonNull() {
        if (isJsonNull()) {
            return (w) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public x getAsJsonObject() {
        if (isJsonObject()) {
            return (x) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public z getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (z) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof t;
    }

    public boolean isJsonNull() {
        return this instanceof w;
    }

    public boolean isJsonObject() {
        return this instanceof x;
    }

    public boolean isJsonPrimitive() {
        return this instanceof z;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            d5.d dVar = new d5.d(stringWriter);
            dVar.setStrictness(h0.LENIENT);
            x4.c0.write(this, dVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
