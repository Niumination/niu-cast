package k3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class i9 {
    public static String a(Map map) {
        int size = map.size();
        d9.b(size, "size");
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb2.append('{');
        boolean z2 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z2) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z2 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }
}
