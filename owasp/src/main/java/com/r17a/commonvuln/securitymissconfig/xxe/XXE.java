package com.r17a.commonvuln.securitymissconfig.xxe;

abstract class XXE {
    abstract void readNoFixXxe();
    abstract void readWithFixXxe();

    void test(){
        System.out.println("\n---------This is result with xxe!-------------");
        this.readNoFixXxe();
        System.out.println("\n---------This is result fixing xxe patch!-------------");
        this.readWithFixXxe();
    }
}
