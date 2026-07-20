package w0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface d extends Closeable {
    @Nullable
    String U();

    @NonNull
    InputStream Z() throws IOException;

    @Nullable
    String k1();

    boolean o0();
}
