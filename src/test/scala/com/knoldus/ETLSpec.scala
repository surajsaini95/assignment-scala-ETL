package com.knoldus

import org.scalatest.FlatSpec

class ETLSpec extends FlatSpec {

  "partOneETL  " should "return true" in {
    val expected = true
    val actual = ETL.partOneETL
    assert(expected == actual)
  }
  "partTwoETL  " should "return true" in {
    val expected = true
    val actual = ETL.partTwoETL
    assert(expected == actual)
  }


}
