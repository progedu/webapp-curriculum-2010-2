import scala.reflect.runtime.universe._

class Issue(private val title: String) {
    private def printTitle(): Unit = println(title)
}

object ReflectionChallenge extends App {
    val issue = new Issue("不具合1")

    val m = runtimeMirror(issue.getClass.getClassLoader)
    val printTitleTermSymbol = typeOf[Issue].decl(TermName("printTitle")).asMethod
    val im = m.reflect(issue)
    val printTitleMethodMirror = im.reflectMethod(printTitleTermSymbol)

    printTitleMethodMirror()
}

