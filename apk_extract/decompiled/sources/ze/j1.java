package ze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11365c = Logger.getLogger(j1.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static j1 f11366d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f11367a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f11368b = Collections.emptyList();

    public static List a() {
        Logger logger = f11365c;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(cf.l.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e4) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e4);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e10) {
            logger.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
