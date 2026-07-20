package v4;

import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final enum c extends j {
    public c(String str, int i8) {
        super(str, i8, null);
    }

    @Override // v4.j, v4.k
    public /* bridge */ /* synthetic */ List alternateNames(Field field) {
        return super.alternateNames(field);
    }

    @Override // v4.j, v4.k
    public String translateName(Field field) {
        return field.getName();
    }
}
