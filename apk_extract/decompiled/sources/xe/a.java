package xe;

import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f10918a = new Regex("^([0-9A-Fa-f]{2}:){5}([0-9A-Fa-f]{2})$");

    static {
        new Regex("[0-9A-Fa-f]+");
    }
}
