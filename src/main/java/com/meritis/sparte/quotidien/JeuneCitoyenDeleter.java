package com.meritis.sparte.quotidien;

import com.meritis.sparte.people.JeuneCitoyen;

@FunctionalInterface
public interface JeuneCitoyenDeleter {
    void delete(JeuneCitoyen jeuneCitoyen);
}
