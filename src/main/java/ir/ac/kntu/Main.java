package ir.ac.kntu;

import ir.ac.kntu.model.agency.Agency;
import ir.ac.kntu.model.utils.RandObjGen;

public class Main {
    public static void main(String[] args) {
        Agency agency = new Agency();
        RandObjGen randObjGen = new RandObjGen();
        randObjGen.generate(agency);
        agency.start();
        System.out.println("Exit");


    }
}