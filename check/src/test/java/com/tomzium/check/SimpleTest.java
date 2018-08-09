package com.tomzium.check;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by TomazWang on 2018/08/09.
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

public class SimpleTest {

    @Test
    public void simpleTest(){
        assertThat(2, equalTo(2));
    }



}
