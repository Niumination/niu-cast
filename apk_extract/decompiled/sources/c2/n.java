package c2;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1422a;

    public n(long j8) {
        this.f1422a = j8;
    }

    public static n a(BufferedReader bufferedReader) throws IOException {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        n nVar = new n(Long.parseLong(jsonReader.nextString()));
                        jsonReader.close();
                        return nVar;
                    }
                    n nVar2 = new n(jsonReader.nextLong());
                    jsonReader.close();
                    return nVar2;
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } catch (Throwable th2) {
            jsonReader.close();
            throw th2;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return this.f1422a == ((n) obj).f1422a;
        }
        return false;
    }

    public final int hashCode() {
        long j8 = this.f1422a;
        return ((int) ((j8 >>> 32) ^ j8)) ^ 1000003;
    }

    public final String toString() {
        return o.d.p(new StringBuilder("LogResponse{nextRequestWaitMillis="), this.f1422a, "}");
    }
}
