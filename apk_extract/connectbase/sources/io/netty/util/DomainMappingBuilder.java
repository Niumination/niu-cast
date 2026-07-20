package io.netty.util;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class DomainMappingBuilder<V> {
    private final DomainNameMappingBuilder<V> builder;

    public DomainMappingBuilder(V v10) {
        this.builder = new DomainNameMappingBuilder<>(v10);
    }

    public DomainMappingBuilder<V> add(String str, V v10) {
        this.builder.add(str, v10);
        return this;
    }

    public DomainNameMapping<V> build() {
        return this.builder.build();
    }

    public DomainMappingBuilder(int i10, V v10) {
        this.builder = new DomainNameMappingBuilder<>(i10, v10);
    }
}
