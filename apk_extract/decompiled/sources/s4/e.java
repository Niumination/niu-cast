package s4;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import q4.f;
import q4.g;

/* JADX INFO: loaded from: classes.dex */
public final class e implements q4.e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9506a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonWriter f9507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f9508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f9509d;
    public final a e;
    public final boolean f;

    public e(Writer writer, HashMap map, HashMap map2, a aVar, boolean z2) {
        this.f9507b = new JsonWriter(writer);
        this.f9508c = map;
        this.f9509d = map2;
        this.e = aVar;
        this.f = z2;
    }

    @Override // q4.e
    public final q4.e a(q4.c cVar, Object obj) throws IOException {
        f(obj, cVar.f8961a);
        return this;
    }

    @Override // q4.e
    public final q4.e b(q4.c cVar, long j8) throws IOException {
        String str = cVar.f8961a;
        g();
        JsonWriter jsonWriter = this.f9507b;
        jsonWriter.name(str);
        g();
        jsonWriter.value(j8);
        return this;
    }

    @Override // q4.g
    public final g c(String str) throws IOException {
        g();
        this.f9507b.value(str);
        return this;
    }

    @Override // q4.g
    public final g d(boolean z2) throws IOException {
        g();
        this.f9507b.value(z2);
        return this;
    }

    public final e e(Object obj) throws IOException {
        JsonWriter jsonWriter = this.f9507b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        f(entry.getValue(), (String) key);
                    } catch (ClassCastException e) {
                        throw new q4.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            q4.d dVar = (q4.d) this.f9508c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            f fVar = (f) this.f9509d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.e.a(obj, this);
                throw null;
            }
            String strName = ((Enum) obj).name();
            g();
            jsonWriter.value(strName);
            return this;
        }
        if (obj instanceof byte[]) {
            g();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        int i8 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i8 < length) {
                jsonWriter.value(iArr[i8]);
                i8++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i8 < length2) {
                long j8 = jArr[i8];
                g();
                jsonWriter.value(j8);
                i8++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i8 < length3) {
                jsonWriter.value(dArr[i8]);
                i8++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i8 < length4) {
                jsonWriter.value(zArr[i8]);
                i8++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i8 < length5) {
                e(numberArr[i8]);
                i8++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i8 < length6) {
                e(objArr[i8]);
                i8++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final e f(Object obj, String str) throws IOException {
        boolean z2 = this.f;
        JsonWriter jsonWriter = this.f9507b;
        if (z2) {
            if (obj != null) {
                g();
                jsonWriter.name(str);
                e(obj);
            }
            return this;
        }
        g();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
        } else {
            e(obj);
        }
        return this;
    }

    public final void g() {
        if (!this.f9506a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
