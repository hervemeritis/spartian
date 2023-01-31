package com.meritis.sparte;

import com.meritis.sparte.armee.Grade;
import com.meritis.sparte.equipement.Armure;
import com.meritis.sparte.equipement.Bouclier;
import com.meritis.sparte.equipement.Lance;
import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.Spartiate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class Laconie {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Spartiate leonidas = () -> "Leonidas";
        Spartiate kratos = () -> "Kratos";
        System.out.println(leonidas.name());
        System.out.println(kratos.name());
        Homoioi leonidas1 = Homoioi.initialize()
                                   .name("Leonidas")
                                   .age(20)
                                   .grade(Grade.HOPPLYTE)
                                   .fullyEquiped();

        Object o = new Service();
        Method test = o.getClass()
                             .getDeclaredMethod("test", Test.class);
        Test tes = () -> System.out.println("coucou");
        test.invoke(o, tes);
    }

    public interface Test {
        void test();

    }

    public static class Service {
        void test(Test test) {
            test.test();
        }
    }
}
