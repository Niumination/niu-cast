package tj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    public static class a implements Comparator<Map.Entry<Integer, d>> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<Integer, d> entry, Map.Entry<Integer, d> entry2) {
            return Integer.compare(entry.getKey().intValue(), entry2.getKey().intValue());
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15626a;

        static {
            int[] iArr = new int[sj.z.values().length];
            f15626a = iArr;
            try {
                iArr[sj.z.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15626a[sj.z.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15626a[sj.z.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15626a[sj.z.LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15626a[sj.z.OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15626a[sj.z.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static d a(d dVar, sj.z zVar) {
        sj.z zVarValueType = dVar.valueType();
        sj.z zVar2 = sj.z.STRING;
        if (zVarValueType == zVar2) {
            String str = (String) dVar.unwrapped();
            int i10 = b.f15626a[zVar.ordinal()];
            if (i10 == 1) {
                try {
                    try {
                        return new q(dVar.origin(), Long.parseLong(str), str);
                    } catch (NumberFormatException unused) {
                        return new l(dVar.origin(), Double.parseDouble(str), str);
                    }
                } catch (NumberFormatException unused2) {
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    if (str.equals("true") || str.equals("yes") || str.equals(nq.w0.f11976d)) {
                        return new g(dVar.origin(), true);
                    }
                    if (str.equals("false") || str.equals("no") || str.equals(nq.w0.f11977e)) {
                        return new g(dVar.origin(), false);
                    }
                }
            } else if (str.equals(d6.a.E)) {
                return new c0(dVar.origin());
            }
        } else if (zVar == zVar2) {
            int i11 = b.f15626a[dVar.valueType().ordinal()];
            if (i11 == 1 || i11 == 3) {
                return new g0.a(dVar.origin(), dVar.transformToString());
            }
        } else if (zVar == sj.z.LIST && dVar.valueType() == sj.z.OBJECT) {
            c cVar = (c) dVar;
            HashMap map = new HashMap();
            for (String str2 : cVar.keySet()) {
                try {
                    int i12 = Integer.parseInt(str2, 10);
                    if (i12 >= 0) {
                        map.put(Integer.valueOf(i12), cVar.get((Object) str2));
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (!map.isEmpty()) {
                ArrayList arrayList = new ArrayList(map.entrySet());
                Collections.sort(arrayList, new a());
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Map.Entry) it.next()).getValue());
                }
                return new e1(dVar.origin(), arrayList2);
            }
        }
        return dVar;
    }
}
