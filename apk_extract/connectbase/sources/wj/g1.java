package wj;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f18693a = Logger.getLogger(g1.class.getName());

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18694a;

        static {
            int[] iArr = new int[d2.c.values().length];
            f18694a = iArr;
            try {
                iArr[d2.c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18694a[d2.c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18694a[d2.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18694a[d2.c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18694a[d2.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18694a[d2.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Object a(String str) throws IOException {
        d2.a aVar = new d2.a(new StringReader(str));
        try {
            return e(aVar);
        } finally {
            try {
                aVar.close();
            } catch (IOException e10) {
                f18693a.log(Level.WARNING, "Failed to close", (Throwable) e10);
            }
        }
    }

    public static List<?> b(d2.a aVar) throws IOException {
        aVar.beginArray();
        ArrayList arrayList = new ArrayList();
        while (aVar.hasNext()) {
            arrayList.add(e(aVar));
        }
        c1.h0.h0(aVar.peek() == d2.c.END_ARRAY, "Bad token: " + aVar.getPath());
        aVar.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    public static Void c(d2.a aVar) throws IOException {
        aVar.nextNull();
        return null;
    }

    public static Map<String, ?> d(d2.a aVar) throws IOException {
        aVar.beginObject();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (aVar.hasNext()) {
            linkedHashMap.put(aVar.nextName(), e(aVar));
        }
        c1.h0.h0(aVar.peek() == d2.c.END_OBJECT, "Bad token: " + aVar.getPath());
        aVar.endObject();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static Object e(d2.a aVar) throws IOException {
        c1.h0.h0(aVar.hasNext(), "unexpected end of JSON");
        switch (a.f18694a[aVar.peek().ordinal()]) {
            case 1:
                return b(aVar);
            case 2:
                return d(aVar);
            case 3:
                return aVar.nextString();
            case 4:
                return Double.valueOf(aVar.nextDouble());
            case 5:
                return Boolean.valueOf(aVar.nextBoolean());
            case 6:
                aVar.nextNull();
                return null;
            default:
                throw new IllegalStateException("Bad token: " + aVar.getPath());
        }
    }
}
