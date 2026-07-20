package v4;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface k {
    default List<String> alternateNames(Field field) {
        return Collections.emptyList();
    }

    String translateName(Field field);
}
