package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Flags {
    public static final short ACK = 1;
    public static final short END_HEADERS = 4;
    public static final short END_STREAM = 1;
    public static final short PADDED = 8;
    public static final short PRIORITY = 32;
    private short value;

    public Http2Flags() {
    }

    public boolean ack() {
        return isFlagSet((short) 1);
    }

    public boolean endOfHeaders() {
        return isFlagSet((short) 4);
    }

    public boolean endOfStream() {
        return isFlagSet((short) 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Http2Flags.class == obj.getClass() && this.value == ((Http2Flags) obj).value;
    }

    public int getNumPriorityBytes() {
        return priorityPresent() ? 5 : 0;
    }

    public int getPaddingPresenceFieldLength() {
        return paddingPresent() ? 1 : 0;
    }

    public int hashCode() {
        return 31 + this.value;
    }

    public boolean isFlagSet(short s10) {
        return (this.value & s10) != 0;
    }

    public boolean paddingPresent() {
        return isFlagSet((short) 8);
    }

    public boolean priorityPresent() {
        return isFlagSet((short) 32);
    }

    public Http2Flags setFlag(boolean z10, short s10) {
        if (z10) {
            this.value = (short) (this.value | s10);
        } else {
            this.value = (short) (this.value & (~s10));
        }
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("value = ");
        sb2.append((int) this.value);
        sb2.append(" (");
        if (ack()) {
            sb2.append("ACK,");
        }
        if (endOfHeaders()) {
            sb2.append("END_OF_HEADERS,");
        }
        if (endOfStream()) {
            sb2.append("END_OF_STREAM,");
        }
        if (priorityPresent()) {
            sb2.append("PRIORITY_PRESENT,");
        }
        if (paddingPresent()) {
            sb2.append("PADDING_PRESENT,");
        }
        sb2.append(')');
        return sb2.toString();
    }

    public short value() {
        return this.value;
    }

    public Http2Flags(short s10) {
        this.value = s10;
    }

    public Http2Flags ack(boolean z10) {
        return setFlag(z10, (short) 1);
    }

    public Http2Flags endOfHeaders(boolean z10) {
        return setFlag(z10, (short) 4);
    }

    public Http2Flags endOfStream(boolean z10) {
        return setFlag(z10, (short) 1);
    }

    public Http2Flags paddingPresent(boolean z10) {
        return setFlag(z10, (short) 8);
    }

    public Http2Flags priorityPresent(boolean z10) {
        return setFlag(z10, (short) 32);
    }
}
