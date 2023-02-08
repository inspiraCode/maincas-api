package com.maincas.maincasapi.service;

import java.util.List;

public interface IMaincasItemService <T> extends IMaincasBaseService<T> {
  List<T> fetchByParentId(Long id);
}
