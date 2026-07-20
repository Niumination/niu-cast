package hq;

import gq.m;
import in.i;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kn.l0;
import kn.r1;
import lm.f1;
import nm.p;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "StreamsKt")
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n31#2:681\n*E\n"})
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Stream f7511a;

        public a(Stream stream) {
            this.f7511a = stream;
        }

        @Override // gq.m
        @l
        public Iterator<T> iterator() {
            Iterator<T> it = this.f7511a.iterator();
            l0.o(it, "iterator(...)");
            return it;
        }
    }

    /* JADX INFO: renamed from: hq.b$b, reason: collision with other inner class name */
    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n39#2:681\n*E\n"})
    public static final class C0205b implements m<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntStream f7512a;

        public C0205b(IntStream intStream) {
            this.f7512a = intStream;
        }

        @Override // gq.m
        @l
        public Iterator<Integer> iterator() {
            Iterator<Integer> it = this.f7512a.iterator();
            l0.o(it, "iterator(...)");
            return it;
        }
    }

    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n47#2:681\n*E\n"})
    public static final class c implements m<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongStream f7513a;

        public c(LongStream longStream) {
            this.f7513a = longStream;
        }

        @Override // gq.m
        @l
        public Iterator<Long> iterator() {
            Iterator<Long> it = this.f7513a.iterator();
            l0.o(it, "iterator(...)");
            return it;
        }
    }

    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n55#2:681\n*E\n"})
    public static final class d implements m<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleStream f7514a;

        public d(DoubleStream doubleStream) {
            this.f7514a = doubleStream;
        }

        @Override // gq.m
        @l
        public Iterator<Double> iterator() {
            Iterator<Double> it = this.f7514a.iterator();
            l0.o(it, "iterator(...)");
            return it;
        }
    }

    @f1(version = "1.2")
    @l
    public static final m<Double> b(@l DoubleStream doubleStream) {
        l0.p(doubleStream, "<this>");
        return new d(doubleStream);
    }

    @f1(version = "1.2")
    @l
    public static final m<Integer> c(@l IntStream intStream) {
        l0.p(intStream, "<this>");
        return new C0205b(intStream);
    }

    @f1(version = "1.2")
    @l
    public static final m<Long> d(@l LongStream longStream) {
        l0.p(longStream, "<this>");
        return new c(longStream);
    }

    @f1(version = "1.2")
    @l
    public static final <T> m<T> e(@l Stream<T> stream) {
        l0.p(stream, "<this>");
        return new a(stream);
    }

    @f1(version = "1.2")
    @l
    public static final <T> Stream<T> f(@l final m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Stream<T> stream = StreamSupport.stream(new Supplier() { // from class: hq.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return b.g(mVar);
            }
        }, 16, false);
        l0.o(stream, "stream(...)");
        return stream;
    }

    public static final Spliterator g(m mVar) {
        l0.p(mVar, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(mVar.iterator(), 16);
    }

    @f1(version = "1.2")
    @l
    public static final List<Double> h(@l DoubleStream doubleStream) {
        l0.p(doubleStream, "<this>");
        double[] array = doubleStream.toArray();
        l0.o(array, "toArray(...)");
        return p.p(array);
    }

    @f1(version = "1.2")
    @l
    public static final List<Integer> i(@l IntStream intStream) {
        l0.p(intStream, "<this>");
        int[] array = intStream.toArray();
        l0.o(array, "toArray(...)");
        return p.r(array);
    }

    @f1(version = "1.2")
    @l
    public static final List<Long> j(@l LongStream longStream) {
        l0.p(longStream, "<this>");
        long[] array = longStream.toArray();
        l0.o(array, "toArray(...)");
        return p.s(array);
    }

    @f1(version = "1.2")
    @l
    public static final <T> List<T> k(@l Stream<T> stream) {
        l0.p(stream, "<this>");
        Object objCollect = stream.collect(Collectors.toList());
        l0.o(objCollect, "collect(...)");
        return (List) objCollect;
    }
}
