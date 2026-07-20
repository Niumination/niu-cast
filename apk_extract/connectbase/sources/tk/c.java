package tk;

import bm.f;
import bm.h;
import fl.t0;
import java.nio.ByteBuffer;
import lm.a1;
import lm.k;
import lm.m;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f15778c = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final ThreadGroup f15776a = new ThreadGroup("io-pool-group");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f15777b = 4096;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final h<ByteBuffer> f15779d = new f(4096, 4096);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final h<ByteBuffer> f15780e = new f(2048, 65535);

    @t0
    public static /* synthetic */ void a() {
    }

    public static final int b() {
        return f15777b;
    }

    @t0
    public static /* synthetic */ void c() {
    }

    @l
    public static final h<ByteBuffer> d() {
        return f15779d;
    }

    @t0
    public static /* synthetic */ void e() {
    }

    @l
    public static final h<ByteBuffer> f() {
        return f15780e;
    }

    @t0
    public static /* synthetic */ void g() {
    }

    @k(level = m.HIDDEN, message = "Use Dispatchers.IO instead for both blocking and non-blocking I/O", replaceWith = @a1(expression = "Dispatchers.IO", imports = {"kotlinx.coroutines.Dispatchers"}))
    public static /* synthetic */ void i() {
    }

    @k(level = m.HIDDEN, message = "This is going to be removed")
    public static /* synthetic */ void k() {
    }
}
