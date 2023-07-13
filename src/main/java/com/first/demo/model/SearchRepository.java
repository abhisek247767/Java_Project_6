package com.first.demo.model;

import java.util.List;

public interface SearchRepository {

	List<Posti> findtext(String text);

}
