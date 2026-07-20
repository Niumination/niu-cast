package zf;

import kotlin.collections.SetsKt;
import kotlin.text.Regex;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f11517a;

    static {
        SetsKt.setOf((Object[]) new String[]{"max-age", "expires", "domain", "path", "secure", "httponly", "$x-enc"});
        f11517a = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
        SetsKt.setOf((Object[]) new Character[]{';', ',', Character.valueOf(Typography.quote)});
    }
}
