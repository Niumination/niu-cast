package vk;

import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public class d extends nl.e<Object, dk.b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17588i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final a f17581n = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public static final nl.j f17582p = new nl.j("Before");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public static final nl.j f17583v = new nl.j("Transform");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public static final nl.j f17584w = new nl.j("Render");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @l
    public static final nl.j f17585x = new nl.j("ContentEncoding");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @l
    public static final nl.j f17586y = new nl.j("TransferEncoding");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @l
    public static final nl.j f17587z = new nl.j("After");

    @l
    public static final nl.j H = new nl.j("Engine");

    public static final class a {
        public a() {
        }

        @l
        public final nl.j a() {
            return d.f17587z;
        }

        @l
        public final nl.j b() {
            return d.f17582p;
        }

        @l
        public final nl.j c() {
            return d.f17585x;
        }

        @l
        public final nl.j d() {
            return d.H;
        }

        @l
        public final nl.j e() {
            return d.f17584w;
        }

        @l
        public final nl.j f() {
            return d.f17586y;
        }

        @l
        public final nl.j g() {
            return d.f17583v;
        }

        public a(w wVar) {
        }
    }

    public d() {
        this(false, 1, null);
    }

    @Override // nl.e
    public boolean m() {
        return this.f17588i;
    }

    public /* synthetic */ d(boolean z10, int i10, w wVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public d(boolean z10) {
        super(f17582p, f17583v, f17584w, f17585x, f17586y, f17587z, H);
        this.f17588i = z10;
    }
}
