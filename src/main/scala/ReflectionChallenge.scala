import scala.reflect.runtime.universe._

class Issue(private val title: String) {
  private def printTitle(): Unit = println(title)
}

object ReflectionChallenge extends App {
  val issue = new Issue("不具合1")
  val mirror = runtimeMirror(issue.getClass.getClassLoader)
  val instance = mirror.reflect(issue)
  val printTitleMethod = typeTag[Issue].tpe.decl(TermName("printTitle")).asMethod // Methodを呼び出す
  instance.reflectMethod(printTitleMethod).apply() // invokerミラー
}