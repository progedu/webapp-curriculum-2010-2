import scala.reflect.runtime.universe._

class Issue(private val title: String) {
  private def printTitle(): Unit = println(title)
}

object ReflectionChallenge extends App {
  val issue = new Issue("不具合1")
  val mirror = runtimeMirror(getClass.getClassLoader)
  val issueMirror = mirror.reflect(issue)
  val printTitle = typeTag[Issue].tpe.decl(TermName("printTitle")).asMethod
  issueMirror.reflectMethod(printTitle).apply()
}
