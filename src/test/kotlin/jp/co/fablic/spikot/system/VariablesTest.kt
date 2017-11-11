package jp.co.fablic.spikot.system

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class VariablesTest {
  private val map = MutableKeyVals()
  private val mapVars = Variables(map)

  @BeforeEach
  fun clear() = map.clear()

  @Test
  @DisplayName("StringVar can be read")
  fun testStringVar() {
    val key = "SLACK_TOKEN"
    val myToken = "my-token"
    map[key] = myToken

    val value = mapVars[StrVar(key)]
    assertEquals(myToken, value)
  }

  @Test
  @DisplayName("Reading a non-existent StringVar throws an exception")
  fun testStringVarDoesNotExist() {
    assertThrows(KeyNotFound::class.java, { mapVars[StrVar("nowhere-key")] })
  }

  @Test
  @DisplayName("Reading a non-existent NullableStringVar returns null")
  fun testNullableStringVar() {
    assertNull(mapVars[NullableStrVar("nowhere-key")])
  }
}

private class MutableKeyVals : KeyVals {
  val map = mutableMapOf<String, String?>()
  override operator fun get(key: String) = map[key]
  operator fun set(key: String, value: String?) = map.set(key, value)
  fun clear() = map.clear()
}