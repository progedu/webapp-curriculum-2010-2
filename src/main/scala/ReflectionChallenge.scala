import scala.reflect.runtime.universe._

class Issue(private val title: String) {
    private def printTitle(): Unit = println(title)
}

object ReflectionChallenge extends App {
    val issue = new Issue("不具合1")

    val m = runtimeMirror(issue.getClass.getClassLoader)

    val im = m.reflect(issue)

    val issueMirror = im.reflectMethod(typeOf[Issue].decl(TermName("printTitle")).asMethod)

    issueMirror.apply(0)
}

