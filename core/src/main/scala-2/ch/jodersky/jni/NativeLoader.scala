package ch.jodersky.jni

class NativeLoader(nativeLibrary: String) {
  def load(nativeLibrary: String, clz: Class[_]): Unit = macro nativeLoaderMacro.impl
  load(nativeLibrary, this.getClass)
}
