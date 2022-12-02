package com.example.serviciobackend.util;

import java.util.List;

public interface IGenericCrud<T> {

    List<T> listaUsuarios();
    T guardar (T t);
    T actualizar(T t);
    T buscarPorId(int id);
    void eliminar(int id);
}
