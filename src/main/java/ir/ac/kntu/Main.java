package ir.ac.kntu;

import ir.ac.kntu.services.*;

public class Main {
    public static void main(String[] args) {
        Agency agency = new Agency();
        RandObjGen randObjGen = new RandObjGen();
        randObjGen.generate(agency);
        agency.operatorlogin();


    }
}