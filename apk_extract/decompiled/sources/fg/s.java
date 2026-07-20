package fg;

import java.io.Closeable;
import java.nio.channels.SelectableChannel;
import li.x0;

/* JADX INFO: loaded from: classes3.dex */
public interface s extends Closeable, x0 {
    boolean isClosed();

    m p();

    void q(r rVar, boolean z2);

    SelectableChannel u();

    int y();
}
