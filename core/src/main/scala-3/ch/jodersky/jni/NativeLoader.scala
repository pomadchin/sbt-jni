package ch.jodersky.jni

import quoted.*

class NativeLoader(nativeLibrary: String):
  inline def load = ${ nativeLoaderMacro.impl('nativeLibrary, '{ this.getClass }) }
  load
