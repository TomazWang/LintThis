package com.tomzium.check

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

/**
 * Created by TomazWang on 2018/08/09.
 *
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

class SimpleKtTest{
    
    @Test
    fun testFind(){
        assertThat(2, equalTo(2))
    }
}