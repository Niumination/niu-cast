package lk;

import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10117a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10118b = 2048;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final bm.h<char[]> f10119c = new a();

    public static final class a extends bm.d<char[]> {
        public a() {
            super(4096);
        }

        @Override // bm.d
        public char[] n() {
            return new char[2048];
        }

        @l
        public char[] y() {
            return new char[2048];
        }
    }

    @l
    public static final bm.h<char[]> a() {
        return f10119c;
    }

    public static /* synthetic */ void b() {
    }
}
