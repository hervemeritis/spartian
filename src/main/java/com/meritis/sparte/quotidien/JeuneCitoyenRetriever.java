package com.meritis.sparte.quotidien;

import com.meritis.sparte.people.JeuneCitoyen;

@FunctionalInterface
public interface JeuneCitoyenRetriever {
    JeuneCitoyen retrieveByName(String name);
}
