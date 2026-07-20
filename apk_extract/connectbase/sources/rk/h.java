package rk;

import fl.t0;
import java.io.Closeable;
import java.nio.channels.SelectableChannel;
import nq.n1;

/* JADX INFO: loaded from: classes2.dex */
@t0
public interface h extends Closeable, n1 {

    public static final class a {
        @t0
        public static /* synthetic */ void a() {
        }
    }

    int X();

    @os.l
    SelectableChannel a();

    void e2(@os.l g gVar, boolean z10);

    @os.l
    c w();
}
