package d2;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f4263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f4264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4265d;
    public final long e;
    public final HashMap f;

    public b(String str, Integer num, f fVar, long j8, long j10, HashMap map) {
        this.f4262a = str;
        this.f4263b = num;
        this.f4264c = fVar;
        this.f4265d = j8;
        this.e = j10;
        this.f = map;
    }

    public final String a(String str) {
        String str2 = (String) this.f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final a c() {
        a aVar = new a();
        String str = this.f4262a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        aVar.f4257a = str;
        aVar.f4258b = this.f4263b;
        f fVar = this.f4264c;
        if (fVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        aVar.f4259c = fVar;
        aVar.f4260d = Long.valueOf(this.f4265d);
        aVar.e = Long.valueOf(this.e);
        aVar.f4261h = new HashMap(this.f);
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4262a.equals(bVar.f4262a)) {
            Integer num = bVar.f4263b;
            Integer num2 = this.f4263b;
            if (num2 != null ? num2.equals(num) : num == null) {
                if (this.f4264c.equals(bVar.f4264c) && this.f4265d == bVar.f4265d && this.e == bVar.e && this.f.equals(bVar.f)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f4262a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f4263b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f4264c.hashCode()) * 1000003;
        long j8 = this.f4265d;
        int i8 = (iHashCode2 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j10 = this.e;
        return this.f.hashCode() ^ ((i8 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f4262a + ", code=" + this.f4263b + ", encodedPayload=" + this.f4264c + ", eventMillis=" + this.f4265d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + "}";
    }
}
