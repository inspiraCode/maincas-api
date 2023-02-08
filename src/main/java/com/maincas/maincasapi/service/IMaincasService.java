package com.maincas.maincasapi.service;

import java.util.List;

public interface IMaincasService<T> extends IMaincasBaseService<T> {
  List<T> fetchAll();
}
