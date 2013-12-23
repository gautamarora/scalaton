package com.gautam

import org.scalatest._

class HelloScalaTest extends FlatSpec {
    "A Function" should "print Hello" in {
        val str = "Hello"
        assert(str.equals("Hello"))
    }
}