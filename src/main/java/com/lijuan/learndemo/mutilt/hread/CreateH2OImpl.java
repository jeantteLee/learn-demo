package com.lijuan.learndemo.mutilt.hread;

public class CreateH2OImpl implements CreateH2O {

    @Override
    public void createElement(String element) {
        System.out.print(element);
    }
}
