package br.com.hexa.infra.utils;

import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperUtils {

    private static ModelMapper modelMapper;

    @Autowired
    public ModelMapperUtils(ModelMapper modelMapper) {
        ModelMapperUtils.modelMapper = modelMapper;
    }

    public static <E> E map(Object source, Class<E> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static void map(Object source, Object destinationType) {
        modelMapper.map(source, destinationType);
    }

    public static <E, L> List<E> mapList(Collection<E> source, Class<E> destinationType) {
        return source.stream().map(sourceItem -> map(sourceItem, destinationType)).collect(Collectors.toList());
    }

    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outClass) {
        Type listType = TypeToken.getParameterized(List.class, outClass).getType();
        return modelMapper.map(entityList, listType);
    }
}
