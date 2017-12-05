package com.ai.ai.converter;

public interface CustomConverter<T, T1> {

    T convertToEntity(T1 dto);

    T1 convertToDto(T entity);
}
