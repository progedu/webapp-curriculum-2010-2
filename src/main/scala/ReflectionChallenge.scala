import scala.reflect.runtime.universe._

class Issue(private val title: String) {
    private def printTitle(): Unit = println(title)
}

object ReflectionChallenge extends App {
    val issue = new Issue("不具合1")

      // TODO リフレクションを用いて printTitle() メソッドを呼び出す
    val m = runtimeMirror(issue.getClass.getClassLoader)

    val shippingTermSymb = typeOf[Issue].decl(TermName("printTitle")).asMethod

    val im = m.reflect(issue)

    im.reflectMethod(shippingTermSymb).apply()
}