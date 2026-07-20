package i6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public interface a<T> {
        void a(T t10);
    }

    /* JADX INFO: renamed from: i6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0215b<T> {
        boolean a(T t10);
    }

    public static <T> void a(Collection<T> collection, Collection<T> collection2, InterfaceC0215b<T> interfaceC0215b) {
        if (collection == null || collection.isEmpty() || collection2 == null) {
            return;
        }
        for (T t10 : collection) {
            if (interfaceC0215b == null || interfaceC0215b.a(t10)) {
                collection2.add(t10);
            }
        }
    }

    public static <T> void b(Collection<T> collection, a<T> aVar) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        for (T t10 : collection) {
            if (t10 != null) {
                aVar.a(t10);
            }
        }
    }

    public static <T> T c(Collection<T> collection, InterfaceC0215b<T> interfaceC0215b) {
        if (collection != null && !collection.isEmpty()) {
            for (T t10 : collection) {
                if (t10 != null && interfaceC0215b.a(t10)) {
                    return t10;
                }
            }
        }
        return null;
    }

    public static <T> List<T> d(Collection<T> collection, InterfaceC0215b<T> interfaceC0215b) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && !collection.isEmpty()) {
            for (T t10 : collection) {
                if (t10 != null && interfaceC0215b.a(t10)) {
                    arrayList.add(t10);
                }
            }
        }
        return arrayList;
    }
}
