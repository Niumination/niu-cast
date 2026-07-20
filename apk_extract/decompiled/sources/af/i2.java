package af;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f324a = Logger.getLogger(i2.class.getName());

    public static Object a(d5.b bVar) throws IOException {
        v8.n(bVar.hasNext(), "unexpected end of JSON");
        switch (h2.f307a[bVar.peek().ordinal()]) {
            case 1:
                bVar.beginArray();
                ArrayList arrayList = new ArrayList();
                while (bVar.hasNext()) {
                    arrayList.add(a(bVar));
                }
                v8.n(bVar.peek() == d5.c.END_ARRAY, "Bad token: " + bVar.getPath());
                bVar.endArray();
                return Collections.unmodifiableList(arrayList);
            case 2:
                bVar.beginObject();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (bVar.hasNext()) {
                    linkedHashMap.put(bVar.nextName(), a(bVar));
                }
                v8.n(bVar.peek() == d5.c.END_OBJECT, "Bad token: " + bVar.getPath());
                bVar.endObject();
                return Collections.unmodifiableMap(linkedHashMap);
            case 3:
                return bVar.nextString();
            case 4:
                return Double.valueOf(bVar.nextDouble());
            case 5:
                return Boolean.valueOf(bVar.nextBoolean());
            case 6:
                bVar.nextNull();
                return null;
            default:
                throw new IllegalStateException("Bad token: " + bVar.getPath());
        }
    }
}
