package of;

import android.os.ParcelFileDescriptor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    void a(Consumer<Exception> consumer);

    void b(ParcelFileDescriptor parcelFileDescriptor, String str, Consumer<Exception> consumer);

    void c(BiConsumer<String, Exception> biConsumer);

    void close();

    void d(BiConsumer<Boolean, Exception> biConsumer);

    void e(BiConsumer<Integer, Exception> biConsumer);

    boolean open();
}
