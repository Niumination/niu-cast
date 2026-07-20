package y4;

import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends v4.p0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f11059d = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11060a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f11061b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f11062c = new HashMap();

    public j(Class cls) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i8 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i8] = field;
                    i8++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i8);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r7 = (Enum) field2.get(null);
                String strName = r7.name();
                String string = r7.toString();
                SerializedName serializedName = (SerializedName) field2.getAnnotation(SerializedName.class);
                if (serializedName != null) {
                    strName = serializedName.value();
                    for (String str : serializedName.alternate()) {
                        this.f11060a.put(str, r7);
                    }
                }
                this.f11060a.put(strName, r7);
                this.f11061b.put(string, r7);
                this.f11062c.put(r7, strName);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        String strNextString = bVar.nextString();
        Enum r7 = (Enum) this.f11060a.get(strNextString);
        return r7 == null ? (Enum) this.f11061b.get(strNextString) : r7;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        Enum r7 = (Enum) obj;
        dVar.value(r7 == null ? null : (String) this.f11062c.get(r7));
    }
}
